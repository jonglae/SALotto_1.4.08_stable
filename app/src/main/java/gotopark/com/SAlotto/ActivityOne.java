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
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
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
import gotopark.com.SAlotto.module.randomNum;

import static java.lang.String.valueOf;


public class ActivityOne extends Activity {

    private static final String TAG = "ActivityOne";
    public ListView listView;
    public OneCardArrayAdapter oneCardArrayAdapter;
    ProgressDialog mProgressDialog;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);
        setTitle("Check the Your Numbers");

        listView = findViewById(R.id.card_listView);

        oneCardArrayAdapter = new OneCardArrayAdapter(getApplicationContext(), R.layout.list_item_card1);

        listView.addHeaderView(new View(this));
        listView.addFooterView(new View(this));

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

                Card card = new Card(iInfo1, iInfo2, iInfo3, "^.^;;", "", "");
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

                    // Get the html document title

                    winperson4 = document.select("title");
                    winperson1 = document.select(".f13");
                    winperson2 = document.select(".lotterygame2");
                    winperson3 = document.select(".results2");

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        public void onPostExecute(Void result) {


            String[] SAloto = {"Lotto", "Lotto Plus", "Lotto Plus 2", "Powerball", "Powerball Plus"};

            if (winperson4 != null) {

                randomNum rand = new randomNum();


                String[] pbnum1 = new String[winperson1.size()];
                for (int i = 0; i < winperson1.size(); i++) {
                    pbnum1[i] = winperson1.get(i).text().substring(5);
                }

                String[] pbnum2 = new String[winperson2.size()];
                for (int i = 0; i < winperson2.size(); i++) {
                    pbnum2[i] = winperson2.get(i).text().substring(1);
                }

                String[] pbnum3 = new String[winperson3.size()];
                for (int i = 0; i < winperson3.size(); i++) {
                    pbnum3[i] = winperson3.get(i).text();
                }

                String[] Next1 = new String[pbnum3.length];
                String[] Next2 = new String[pbnum3.length];

                /** 리스트 뷰 출력 출력 */
                for (int i = 0; i < pbnum1.length; i++) {


                    // 문자열 자르기 로또 번호
                    Next1[i] = pbnum3[i].substring(0, pbnum3[i].length() - 2);
                    Next2[i] = pbnum3[i].substring(pbnum3[i].length() - 2);

                    // 로또 번호 보너스 번호에 + 집어 넣기
                    pbnum3[i] = null;
                    pbnum3[i] = Next1[i] + " + " + Next2[i];


                    if(i == 3){
                        // 파워볼 + 제거
                        pbnum3[i] =pbnum3[i].replace("+","");
                    }

                    // SALoto 의 필요 없는 문자 자르기
                    pbnum2[i] = pbnum2[i].replaceAll(SAloto[i], "").substring(6);


                    //Next Jackpot 필요 없는 문자 잘라 네기
                    pbnum1[i] = pbnum1[i].replaceAll(SAloto[i], "");
                    pbnum1[i] = pbnum1[i].replaceAll("Next", "\nNext");

                    // lotto plus2 blue text 오타 수정
                    if (i == 2) {
                        pbnum1[2] = pbnum1[2].replaceAll("Lotto Plus", "");

                    }


                    Card card = new Card(SAloto[i], pbnum2[i], pbnum3[i], pbnum1[i], "", "(Last Number is Bonus or PB number)");
                    oneCardArrayAdapter.add(card);
                }

                String saywords = BackProcessHandler.frontSay();

                Card card2 = new Card("Wise Word", saywords, "", "", "", "");
                oneCardArrayAdapter.add(card2);

                Card card3 = new Card("", "", "", "", "", "");
                oneCardArrayAdapter.add(card3);

                mProgressDialog.dismiss();
                listView.setAdapter(oneCardArrayAdapter);


            } else {

                /** 네트웍 품질 문제 발생시 메세지 출력 */

                for (int i = 0; i < 3; i++) {

                    String iInfo1 = getString(R.string.net_Info);
                    String iInfo2 = getString(R.string.net_Info1);
                    String iInfo3 = getString(R.string.net_Info2);
                    String iInfo4 = getString(R.string.net_Info3);


                    Card card = new Card(iInfo1, iInfo2, iInfo3, iInfo4, "", "");
                    oneCardArrayAdapter.add(card);
                    listView.setAdapter(oneCardArrayAdapter);

                }

            }

        }
    }

}


