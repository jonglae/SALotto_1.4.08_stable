package gotopark.com.SAlotto;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Resources;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;
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

    public OneCardAdapter2 cardAdapter;
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

    Resources ball;
    int tak, tok;
    SoundPool soundpool;

    String[] numbers;
    String[] numbers2;
    int ballgiri;

    String title;
    int select;

    @SuppressLint("SetTextI18n")
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        View divier_bottom = findViewById(id.bottom_divider);

        Intent intent = getIntent();
        select = Objects.requireNonNull(intent.getExtras()).getInt("select");
        ball = getResources();
        TextView Seltext = findViewById(id.seltext);

        switch (select) {
            case 1:
                divier_bottom.setVisibility(View.GONE);
                numbers = ball.getStringArray(array.daily);
                ballgiri = 5;
                numbers2 = null;
                title = "Daily Lotto";

                break;
            case 2:
                divier_bottom.setVisibility(View.GONE);
                numbers = ball.getStringArray(array.lotto);
                ballgiri = 6;
                numbers2 = null;
                title = "Lotto/plus 1 2";

                break;

            case 3:
                ballgiri = 5;
                numbers = ball.getStringArray(array.powerfive);
                numbers2 = ball.getStringArray(array.powerball);
                title = "PowerBall/Plus";

                break;
        }

        Seltext.setText(title);

        db = new DatabaseHelper(this);
        final GridView gridView1 = findViewById(id.grid);
        final GridView gridView2 = findViewById(id.grid2);

        adapter = new GridViewAdapter(numbers, this);

        if (numbers2 != null) {
            adapter2 = new GridViewAdapter(numbers2, this);
        }

        View btnGo = findViewById(id.button);
        View btnClear = findViewById(id.button10);

        selectedStrings = new ArrayList<>();
        selectedStrings_star2 = new ArrayList<>();

        listView = findViewById(id.card_listView);
        cardAdapter = new OneCardAdapter2(getApplicationContext(), R.layout.tab1_lot_list);

        gridView1.setAdapter(adapter);
        if (numbers2 != null) {
            gridView2.setAdapter(adapter2);
        }
        soundpool = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
        tak = soundpool.load(this, R.raw.short_click2, 1);
        tok = soundpool.load(this, R.raw.click1_rebert1, 1);

        gridView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

                selectedIndex1 = adapter.selectedPositions.indexOf(position);

                if (selectedStrings.size() == (ballgiri - 1)) {
                    Log.d("====click ok=====", "click ok");
                    Click_true = 0;
                }

                if (selectedIndex1 > -1) {
                    soundpool.play(tok, 1, 1, 0, 0, 1);
                    adapter.selectedPositions.remove(selectedIndex1);
                    ((GridItemView) v).display(false);
                    selectedStrings.remove(parent.getItemAtPosition(position));
                } else {
                    if (selectedStrings.size() == ballgiri) {
                        Toast.makeText(getApplicationContext(), "OK", Toast.LENGTH_LONG).show();
                    } else {
                        soundpool.play(tak, 1, 1, 0, 0, 1);
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


        btnClear.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                soundpool.play(tok, 1, 1, 0, 0, 1);


                switch (title) {

                    case "Daily Lotto":
                        adapter1_clear();
                        break;

                    case "Lotto/plus 1 2":
                        adapter1_clear();
                        break;

                    case "PowerBall/Plus":
                        adapter1_clear();
                        adapter2_clear();
                        break;
                }
            }


            void adapter1_clear() {

                adapter.selectedPositions.clear();
                selectedStrings.clear();
                adapter.notifyDataSetChanged();
            }

            void adapter2_clear() {

                adapter2.selectedPositions.clear();
                selectedStrings_star2.clear();
                adapter2.notifyDataSetChanged();
            }


        });


        btnGo.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                soundpool.play(tok, 1, 1, 0, 0, 1);
                pbnum = String.valueOf(selectedStrings);
                pbnum2 = String.valueOf(selectedStrings_star2);
                int star2_Size = selectedStrings_star2.size();

                switch (select) {
                    case 1:
                        star2_Size = 1;
                        break;

                    case 2:
                        star2_Size = 1;
                        break;

                    case 3:
                        break;
                }

                if (selectedStrings.size() == ballgiri && star2_Size == 1 && Click_true == 0) {
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
                        pbnum = pbnum.replace(" ", "");

                        pbnum2 = pbnum2.replace("[", "");
                        pbnum2 = pbnum2.replace("]", "");
                        pbnum2 = pbnum2.replace(" ", "");

                        if (select == 3) {
                            pbnum = pbnum + "," + pbnum2;
                        }
                        Card card = new Card(LottoCount + "St Number was Save", pbnum, "", "", select, "");

                        //DB 입력
                        db.insertNote(pbnum, title, "Manual Select Number");

                        cardAdapter.add(card);
                        listView.setAdapter(cardAdapter);

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