package gotopark.com.SAlotto;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.ArrayList;
import java.util.Objects;

import gotopark.com.SAlotto.SelectNum.GridItemView;
import gotopark.com.SAlotto.SelectNum.GridViewAdapter;
import gotopark.com.SAlotto.database.DatabaseHelper;
import gotopark.com.SAlotto.listview.Card;
import gotopark.com.SAlotto.listview.OneCardAdapter2;

import static gotopark.com.SAlotto.R.*;


/**
 * Created by User on 4/15/2017.
 */

@SuppressLint("Registered")
public class Main3Activity extends AppCompatActivity {

    private ArrayList<String> selectedStrings;
    private ArrayList<String> selectedStrings_star2;

    private DatabaseHelper db;
    private static final String TAG = "Main3Activity";

    public OneCardAdapter2 cardArrayAdapter;
    public ListView listView;
    int LottoCount = 0;

    GridViewAdapter adapter;
    GridViewAdapter adapter2;

    int selectedIndex1;
    int selectedIndex2;
    int Click_true = 1;

    private String pbnum, pbnum2;
    private String old_pbnum1 = "";
    private String old_pbnum2 = "";


    int tak, tok;
    SoundPool soundpool;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Resources ball = getResources();

        db = new DatabaseHelper(this);

        String[] numbers = ball.getStringArray(array.fiveball);
        String[] numbers2 = ball.getStringArray(array.MeGaball);


        GridView gridView1 = findViewById(id.grid);
        GridView gridView2 = findViewById(id.grid2);

        adapter = new GridViewAdapter(numbers, this);
        adapter2 = new GridViewAdapter(numbers2, this);

        View btnGo = findViewById(id.button);

        selectedStrings = new ArrayList<>();
        selectedStrings_star2 = new ArrayList<>();

        listView = findViewById(id.card_listView);
        cardArrayAdapter = new OneCardAdapter2(getApplicationContext(), R.layout.tab1_lot_list);

        gridView1.setAdapter(adapter);
        gridView2.setAdapter(adapter2);

        soundpool = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
        tak = soundpool.load(this, R.raw.short_click2, 1);
        tok = soundpool.load(this, R.raw.click1_rebert1, 1);

        gridView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

                selectedIndex1 = adapter.selectedPositions.indexOf(position);

                if (selectedStrings.size() == 4) {
                    Log.d("====click ok=====", "click ok");

                    Click_true = 0;
                }

                if (selectedIndex1 > -1) {
                    soundpool.play(tok, 1, 1, 0, 0, 1);

                    adapter.selectedPositions.remove(selectedIndex1);
                    ((GridItemView) v).display(false);
                    selectedStrings.remove(parent.getItemAtPosition(position));


                } else {

                    if (selectedStrings.size() == 5) {

                        Toast.makeText(getApplicationContext(), "OK", Toast.LENGTH_LONG).show();

                    } else {
                        soundpool.play(tak, 1, 1, 0, 0, 1);
//                        Log.d("====IndexGesu=====", String.valueOf(IndexGesu1));

                        adapter.selectedPositions.add(position);
                        ((GridItemView) v).display(true);
                        selectedStrings.add((String) parent.getItemAtPosition(position));
                    }


                }


            }
        });


        gridView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

                selectedIndex2 = adapter2.selectedPositions.indexOf(position);

                if (selectedStrings_star2.size() == 0) {
                    Log.d("====click ok=====", "click ok");

                    Click_true = 0;
                }

                if (selectedIndex2 > -1) {
                    soundpool.play(tok, 1, 1, 0, 0, 1);

                    adapter2.selectedPositions.remove(selectedIndex2);
                    ((GridItemView) v).display(false);
                    selectedStrings_star2.remove(parent.getItemAtPosition(position));

                    Log.d("====parent=====", (String) parent.getItemAtPosition(position));

                } else {

                    if (selectedStrings_star2.size() == 1) {

//                        Click_true = 0;
                        Toast.makeText(getApplicationContext(), "Ball2 OK", Toast.LENGTH_LONG).show();

                    } else {
                        soundpool.play(tak, 1, 1, 0, 0, 1);

                        adapter2.selectedPositions.add(position);
                        ((GridItemView) v).display(true);
                        selectedStrings_star2.add((String) parent.getItemAtPosition(position));
                    }

                }

            }
        });


        btnGo.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                soundpool.play(tok, 1, 1, 0, 0, 1);

                pbnum = String.valueOf(selectedStrings);
                pbnum2 = String.valueOf(selectedStrings_star2);

                if (selectedStrings.size() == 5 && selectedStrings_star2.size() == 1 && Click_true == 0) {
                    if (Objects.equals(old_pbnum1, pbnum) && Objects.equals(old_pbnum2, pbnum2)) {
                        Toast.makeText(getApplicationContext(), "Same Numbers", Toast.LENGTH_LONG).show();

                    } else {
                        LottoCount += 1;

                        old_pbnum1 = pbnum;
                        old_pbnum2 = pbnum2;

                        pbnum = String.valueOf(selectedStrings);
                        pbnum2 = String.valueOf(selectedStrings_star2);

                        pbnum = pbnum.replace("[", "");
                        pbnum = pbnum.replace("]", "");

                        pbnum2 = pbnum2.replace("[", "");
                        pbnum2 = pbnum2.replace("]", "");



                        pbnum = pbnum + " (" + pbnum2 + ")";

                        Card card = new Card(LottoCount + "St Number", pbnum, "", "", "", "");

                        //DB 입력
                        db.insertNote(pbnum);


                        cardArrayAdapter.add(card);
                        listView.setAdapter(cardArrayAdapter);


                        Click_true = 1;


                    }


                }
            }
        });


        Admob_is();


    }

    public void Admob_is() {

        // admob
        AdView mAdView = findViewById(id.adView);
        MobileAds.initialize(getApplicationContext(), getString(R.string.banner_ad_unit_id2));
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }


    @Override
    public void onBackPressed() {
        finish();
    }
}