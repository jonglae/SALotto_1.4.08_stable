package gotopark.com.SAlotto;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

import gotopark.com.SAlotto.listview.Card;
import gotopark.com.SAlotto.listview.OneCardArrayAdapter;

public class ActivityOne extends AppCompatActivity {

    private static final String TAG = "ActivityOne";
    public ListView listView;
    public OneCardArrayAdapter oneCardArrayAdapter;
    ProgressDialog mProgressDialog;

    int tak, tok;
    SoundPool soundpool;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);
        setTitle("Check the Your Numbers");

        listView = findViewById(R.id.card_listView);

        soundpool = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
        tak = soundpool.load(this, R.raw.short_click2, 1);
        tok = soundpool.load(this, R.raw.click1_rebert1, 1);

        oneCardArrayAdapter = new OneCardArrayAdapter(getApplicationContext(), R.layout.list_item_card1);

        listView.addHeaderView(new View(this));
        listView.addFooterView(new View(this));

        Button btn6 = findViewById(R.id.button6);
        Button btn7 = findViewById(R.id.button7);
        Button btn8 = findViewById(R.id.button8);
        Button btn9 = findViewById(R.id.button9);

        btn6.setOnClickListener(Lot_list);
        btn7.setOnClickListener(Num_Choice1);
        btn8.setOnClickListener(Num_Choice2);
        btn9.setOnClickListener(Num_Choice3);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavView_Bar);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(1);
        menuItem.setChecked(true);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.ic_arrow:
                        Intent intent0 = new Intent(ActivityOne.this, MainActivity.class);
                        startActivity(intent0);
                        break;

                    case R.id.ic_android:
                        break;

                    case R.id.ic_books:
                        Intent intent2 = new Intent(ActivityOne.this, ActivityTwo.class);
                        startActivity(intent2);
                        break;

                    case R.id.ic_center_focus:
                        Intent intent3 = new Intent(ActivityOne.this, ActivityThree.class);
                        startActivity(intent3);
                        break;

                    case R.id.ic_backup:
                        Intent intent4 = new Intent(ActivityOne.this, ActivityFour.class);
                        startActivity(intent4);
                        break;
                }
                return false;
            }
        });


        Admob_is();
    }


    public Button.OnClickListener Lot_list = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            soundpool.play(tok, 1, 1, 1, 0, 1);

            Intent intent = new Intent(ActivityOne.this, Main2Activity.class);
            startActivity(intent);

        }
    };

    //daily lotto
    public Button.OnClickListener Num_Choice1 = new View.OnClickListener() {

        @RequiresApi(api = Build.VERSION_CODES.KITKAT)
        @Override
        public void onClick(View v) {
            soundpool.play(tok, 1, 1, 1, 0, 1);

            Intent intent = new Intent(ActivityOne.this, Main3Activity.class);
            intent.putExtra("select", 1);
            startActivity(intent);
        }
    };


    //lotto plus
    public Button.OnClickListener Num_Choice2 = new View.OnClickListener() {

        @RequiresApi(api = Build.VERSION_CODES.KITKAT)
        @Override
        public void onClick(View v) {
            soundpool.play(tok, 1, 1, 1, 0, 1);

            Intent intent = new Intent(ActivityOne.this, Main3Activity.class);
            intent.putExtra("select", 2);
            startActivity(intent);
        }
    };


    //powerball
    public Button.OnClickListener Num_Choice3 = new View.OnClickListener() {

        @RequiresApi(api = Build.VERSION_CODES.KITKAT)
        @Override
        public void onClick(View v) {
            soundpool.play(tok, 1, 1, 1, 0, 1);

            Intent intent = new Intent(ActivityOne.this, Main3Activity.class);
            intent.putExtra("select", 3);
            startActivity(intent);
        }
    };


    public void Admob_is() {

        // admob
        AdView mAdView = findViewById(R.id.adView);
//        MobileAds.initialize (getApplicationContext (),"ca-app-pub-5187489598351901~6823006419");
        MobileAds.initialize(getApplicationContext(), String.valueOf(R.string.google_adsene_id));
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onStart() {
        super.onStart();

        Context context = this;

        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        assert cm != null;
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        if (activeNetwork != null) { // connected to the internet
            if (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI) {
                // connected to wifi
                Toast.makeText(context, activeNetwork.getTypeName(), Toast.LENGTH_SHORT).show();


                /** 와이 파이 인터넷 연결시 시도 */
                new LotonumCall().execute();


            } else if (activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE) {
                // connected to the mobile provider's data plan
                Toast.makeText(context, activeNetwork.getTypeName(), Toast.LENGTH_SHORT).show();
                /** 모바일 연결시 시도  */
                new LotonumCall().execute();
            }

        } else {
            /** 네트웍 문제 메세지 출력 */
            for (int i = 0; i < 3; i++) {
                String iInfo1 = getString(R.string.net_Info);
                String iInfo2 = getString(R.string.net_Info1);
                String iInfo3 = getString(R.string.net_Info2);
                Card card = new Card(iInfo1, iInfo2, iInfo3, "^.^;;", 4, "");
                oneCardArrayAdapter.add(card);
                listView.setAdapter(oneCardArrayAdapter);
            }
        }
    }


    @SuppressLint("StaticFieldLeak")
    private class LotonumCall extends AsyncTask<Void, Void, Void> {
        Elements winperson1;
        Elements winperson2;
        Elements winperson3;
        Elements winperson4;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Create a progressdialog
            mProgressDialog = new ProgressDialog(ActivityOne.this);
            // Set progressdialog title
            mProgressDialog.setTitle("SA Lottery Result");
            // Set progressdialog message
            mProgressDialog.setMessage("Please Wait...");
            mProgressDialog.setIndeterminate(false);
            // Show progressdialog
            mProgressDialog.show();
        }

        @Override
        public Void doInBackground(Void... params) {

            String url = getString(R.string.active_one);
            try {
                // Connect to the web site
                Document document = Jsoup.connect(url)
                        .timeout(10000)
                        .get();

                if (document != null) {
                    winperson4 = document.select(getString(R.string.jsoup_q1));
                    winperson1 = document.select(getString(R.string.jsoup_q2));
                    winperson2 = document.select(getString(R.string.jsoup_q3));
                    winperson3 = document.select(getString(R.string.jsoup_q4));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        public void onPostExecute(Void result) {
            String[] SAloto = {"Lotto", "Lotto Plus", "Lotto Plus 2", " Daily Lotto", "Powerball", "Powerball Plus"};
            if (winperson4 != null) {
                String[] pbnum1 = new String[winperson1.size()];
                for (int i = 0; i < winperson1.size(); i++) {
                    pbnum1[i] = winperson1.get(i).text().substring(5);
                    pbnum1[i] = pbnum1[i].replaceAll("Next", "\nNext");
                }

                String[] pbnum2 = new String[winperson2.size()];
                for (int i = 0; i < winperson2.size(); i++) {
                    pbnum2[i] = winperson2.get(i).text();
                }

                String[] pbnum3 = new String[winperson3.size()];
                for (int i = 0; i < winperson3.size(); i++) {
                    pbnum3[i] = winperson3.get(i).text();
                }

                /** 리스트 뷰 출력 출력 */
                Node.setWin_Result(pbnum3) ;

                for (int i = 0; i < 6; i++) {
                    pbnum3[i] = pbnum3[i].replace("  ", " ");
                    Node node = new Node();

                    switch (i) {
                        case 0:
                            Card card = new Card(SAloto[i], pbnum2[i], pbnum3[i], pbnum1[i], 2, getString(R.string.listLast_Meg1));
                            oneCardArrayAdapter.add(card);
                            break;
                        case 1:
                            Card card1 = new Card(SAloto[i], pbnum2[i], pbnum3[i], pbnum1[i], 2, getString(R.string.listLast_Meg1));
                            oneCardArrayAdapter.add(card1);
                            break;
                        case 2:
                            Card card2 = new Card(SAloto[i], pbnum2[i], pbnum3[i], pbnum1[i], 2, getString(R.string.listLast_Meg1));
                            oneCardArrayAdapter.add(card2);
                            break;
                        case 3:
                            //daily Lotto
                            Card card3 = new Card(SAloto[i], pbnum2[i], pbnum3[i], "", 1, getString(R.string.listLast_Meg1));
                            oneCardArrayAdapter.add(card3);
                            break;
                        case 4:
                            Card card4 = new Card(SAloto[i], pbnum2[i], pbnum3[i], pbnum1[i - 1], 3, getString(R.string.listLast_Meg1));
                            oneCardArrayAdapter.add(card4);
                            break;
                        case 5:
                            Card card5 = new Card(SAloto[i], pbnum2[i], pbnum3[i], pbnum1[i - 1], 3, getString(R.string.listLast_Meg1));
                            oneCardArrayAdapter.add(card5);
                            break;
                    }
                }


                mProgressDialog.dismiss();
                listView.setAdapter(oneCardArrayAdapter);
            } else {
                /** 네트웍 품질 문제 발생시 메세지 출력 */
                for (int i = 0; i < 3; i++) {
                    String iInfo1 = getString(R.string.net_Info);
                    String iInfo2 = getString(R.string.net_Info1);
                    String iInfo3 = getString(R.string.net_Info2);
                    String iInfo4 = getString(R.string.net_Info3);
                    Card card = new Card(iInfo1, iInfo2, iInfo3, iInfo4, 4, "");
                    oneCardArrayAdapter.add(card);
                    listView.setAdapter(oneCardArrayAdapter);
                }
            }
        }
    }
}


