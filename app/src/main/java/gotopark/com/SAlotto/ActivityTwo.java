package gotopark.com.SAlotto;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.BottomNavigationView;
import android.util.Log;
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
import java.util.ArrayList;
import java.util.List;

import gotopark.com.SAlotto.listview.Card;
import gotopark.com.SAlotto.listview.OneCardArrayAdapter;
import gotopark.com.SAlotto.module.parted1;

@SuppressLint("Registered")
public class ActivityTwo extends Activity {

    private static final String TAG = "ActivityTwo";
    public ListView listView;
    public OneCardArrayAdapter oneCardArrayAdapter;
    ProgressDialog mProgressDialog;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    String str = "";

    String[] SAloto = {"Lotto Past Draws", "Lotto Plus Past Draws", "PowerBall Past Draws", "PowerBall Plus Past Draws"};
    int SAlotoChoice;
    String url;
    int SliceNumber, infoBallChoice;
    String[] InfoBall = {"(Last Number is Bonus Ball)", "(Last Number is PowerBall)"};
    String iInfo1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        setTitle("Check the Your Numbers");
        listView = (ListView) findViewById(R.id.card_listView);

        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);


        oneCardArrayAdapter = new OneCardArrayAdapter(getApplicationContext(), R.layout.list_item_card1);

        listView.addHeaderView(new View(this));
        listView.addFooterView(new View(this));

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavView_Bar);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(2);
        menuItem.setChecked(true);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.ic_arrow:
                        Intent intent0 = new Intent(ActivityTwo.this, MainActivity.class);
                        intent0.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent0);
                        break;

                    case R.id.ic_android:
                        Intent intent1 = new Intent(ActivityTwo.this, ActivityOne.class);
                        intent1.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent1);
                        break;

                    case R.id.ic_books:

                        break;

                    case R.id.ic_center_focus:
                        Intent intent3 = new Intent(ActivityTwo.this, ActivityThree.class);
                        intent3.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent3);
                        break;

                    case R.id.ic_backup:
                        Intent intent4 = new Intent(ActivityTwo.this, ActivityFour.class);
                        intent4.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent4);
                        break;
                }
                return false;
            }
        });


        button1.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {

                SAlotoChoice = 0;
                url = getString(R.string.JsoupLink1);
                SliceNumber = 7;
                infoBallChoice = 0;

                oneCardArrayAdapter.cardList.clear();

                if (iInfo1 == "Network Error!") {

                    oneCardArrayAdapter.notifyDataSetChanged();
                    NetPoor();


                } else {

                    new Lotto().execute();
                    oneCardArrayAdapter.notifyDataSetChanged();
                }

            }
        });


        button2.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {

                SAlotoChoice = 1;
                url = getString(R.string.JsoupLink2);
                SliceNumber = 7;
                infoBallChoice = 0;

                oneCardArrayAdapter.cardList.clear();


                if (iInfo1 == "Network Error!") {

                    oneCardArrayAdapter.notifyDataSetChanged();
                    NetPoor();

                } else {

                    new Lotto().execute();
                    oneCardArrayAdapter.notifyDataSetChanged();
                }

            }
        });


        button3.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {

                SAlotoChoice = 2;
                url = getString(R.string.JsoupLink3);
                SliceNumber = 6;
                infoBallChoice = 1;

                oneCardArrayAdapter.cardList.clear();

                if (iInfo1 == "Network Error!") {

                    oneCardArrayAdapter.notifyDataSetChanged();
                    NetPoor();


                } else {

                    new Lotto().execute();
                    oneCardArrayAdapter.notifyDataSetChanged();
                }

            }
        });


        button4.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {

                SAlotoChoice = 3;
                url = getString(R.string.JsoupLink4);
                SliceNumber = 6;
                infoBallChoice = 1;

                oneCardArrayAdapter.cardList.clear();
                if (iInfo1 == "Network Error!") {

                    oneCardArrayAdapter.notifyDataSetChanged();
                    NetPoor();


                } else {

                    new Lotto().execute();
                    oneCardArrayAdapter.notifyDataSetChanged();
                }

            }
        });

    }

    public void Admob_is() {

        // admob
        AdView mAdView = (AdView) findViewById(R.id.adView);
        MobileAds.initialize(getApplicationContext(), String.valueOf(R.string.unit_id));
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
                InfoMessage();

                Admob_is();

            } else if (activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE) {
                // connected to the mobile provider's data plan
                Toast.makeText(context, activeNetwork.getTypeName(), Toast.LENGTH_SHORT).show();

                /** 모바일 연결시 시도  */
                InfoMessage();

                Admob_is();


            }

        } else {
            /** 네트웍 문제 메세지 출력 */

            NetPoor();

        }
    }

    private void NetPoor() {

        for (int i = 0; i < 3; i++) {

            iInfo1 = "Network Error!";
            String iInfo2 = "Please ON Wifi OR Mobile Network";
            String iInfo3 = "Need Internet!!!";

            Card card = new Card(iInfo1, iInfo2, iInfo3, "^.^;;", "", "");
            oneCardArrayAdapter.add(card);
            listView.setAdapter(oneCardArrayAdapter);

        }

    }

    private void InfoMessage() {

        String iInfo1 = "SA Lotto Past Winning Numbers";
        String iInfo2 = "Please touch the button under";
        String iInfo3 = "Good luck for you !!!";

        Card card = new Card(iInfo1, "", iInfo2, "", iInfo3, "");
        oneCardArrayAdapter.add(card);
        listView.setAdapter(oneCardArrayAdapter);

        Card card2 = new Card("", "", "", "", iInfo3, "");


    }


    @SuppressLint("StaticFieldLeak")
    class Lotto extends AsyncTask<Void, Void, Void> {

        Elements winperson4;
        Elements f13;
        Elements f14;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Create a progressdialog
            mProgressDialog = new ProgressDialog(ActivityTwo.this);
            // Set progressdialog title
            mProgressDialog.setTitle("SA Lotto past Draw ");
            // Set progressdialog message
            mProgressDialog.setMessage("Please Wait...");
            mProgressDialog.setIndeterminate(false);
            // Show progressdialog
            mProgressDialog.show();
        }

        @Override
        public Void doInBackground(Void... params) {

            try {
                // Connect to the web site
                Document document = Jsoup.connect(url)
                        .timeout(10000)
                        .get();

                if (document != null) {

                    // Get the html document title

                    winperson4 = document.select("title");

                    f13 = document.select(".lotterygame2");
                    f14 = document.select(".results2");

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        public void onPostExecute(Void result) {

            if (f13 != null && f13.size() > 0) {

                String[] SaLot_date = new String[f13.size()];
                String[] pbnum1 = new String[f13.size()];
                ArrayList<String> pbnum2 = new ArrayList<>();
                String[] pbnum4 = new String[f14.size()];

                for (int i = 0; i < f13.size(); i++) {
                    pbnum1[i] = f13.get(i).text();
                    SaLot_date[i] = pbnum1[i].replaceAll("Info", "");
                    SaLot_date[i] = SaLot_date[i].substring(8);
                }

                String[] Next1 = new String[pbnum4.length];
                String[] Next2 = new String[pbnum4.length];

                for (int i = 0; i < f14.size(); i++) {
                    pbnum4[i] = f14.get(i).text().replaceAll("\\<.*?>", "");

                    // 문자열 자르기 로또 번호
                    Next1[i] = pbnum4[i].substring(0, pbnum4[i].length() - 2);
                    Next2[i] = pbnum4[i].substring(pbnum4[i].length() - 2);

                    // 로또 번호 보너스 번호에 + 집어 넣기
                    pbnum4[i] = null;
                    pbnum4[i] = Next1[i] + " + " + Next2[i];


                }

                // ArrayList Divide
//                List <List <String>> Pblist = parted1.chopped (pbnum2, SliceNumber);

                for (int i = 0; i < f13.size(); i++) {
//                    pbnum3[i] = f13.get (i).toString ();

                    Card card = new Card(SAloto[SAlotoChoice] + " : " + (i + 1), SaLot_date[i], pbnum4[i], "", "", InfoBall[infoBallChoice]);
                    oneCardArrayAdapter.add(card);


                    str = SAloto[SAlotoChoice];


                }


                Card card = new Card("Be the happy rich", "* * *Congratulation* * *", "", "", "", "(EOF)");
                oneCardArrayAdapter.add(card);

                Card card2 = new Card("", "", "", "", "", "");
                oneCardArrayAdapter.add(card2);

                Log.e(TAG, "===================================>" + str);

                mProgressDialog.dismiss();
                listView.setAdapter(oneCardArrayAdapter);

            } else {

                for (int i = 0; i < 3; i++) {

                    String iInfo1 = "Network Error!";
                    String iInfo2 = "The network connection is poor.";
                    String iInfo3 = "Try again later!!!";
                    String iInfo4 = "If you To check your Lottery Number";
                    String iInfo5 = "Connect to the Internet";


                    Card card = new Card(iInfo1, iInfo2, iInfo3, iInfo4, iInfo5, "");
                    oneCardArrayAdapter.add(card);
                    oneCardArrayAdapter.notifyDataSetChanged();
                    listView.setAdapter(oneCardArrayAdapter);

                }
            }
        }

    }
}






