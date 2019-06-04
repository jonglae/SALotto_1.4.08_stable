package gotopark.com.SAlotto;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.Random;

import gotopark.com.SAlotto.database.DatabaseHelper;
import gotopark.com.SAlotto.module.randomNum;


public class Tab3Fragment extends Fragment {

    private static final String TAG = "Tab3Fragment";

    public String ctextR;


    TextView F1TV1, F1TV2, F1TV3, F1TV4, F1TV5, F1TV6;
    TextView F2TV1, F2TV2, F2TV3, F2TV4, F2TV5, F2TV6;
    TextView F3TV1, F3TV2, F3TV3, F3TV4, F3TV5, F3TV6;
    TextView F4TV1, F4TV2, F4TV3, F4TV4, F4TV5, F4TV6;
    TextView F5TV1, F5TV2, F5TV3, F5TV4, F5TV5, F5TV6;

    int[] Lot1num1 = new int[5];
    int[] Lot1num2 = new int[5];
    int[] Lot1num3 = new int[5];
    int[] Lot1num4 = new int[5];
    int[] Lot1num5 = new int[5];

    int[] rednum1 = new int[1];
    int[] rednum2 = new int[1];
    int[] rednum3 = new int[1];
    int[] rednum4 = new int[1];
    int[] rednum5 = new int[1];

    private Random rand;
    int count, primeWord;
    public TextView wisetext1;

    String ctextRlist;
    String ctextRlist1;
    String ctextRlist2;
    String ctextRlist3;
    String ctextRlist4;
    String ctextRlist5;

    int ClickCount1 = 1;

    int tak, tok;
    SoundPool soundpool;

    DatabaseHelper db;

    int[] Times_Ran = {150, 250, 350, 550, 650, 850, 950, 1150, 1450, 1550};
    int millisec;
    int static_millisec=20;
    int InTerval =10;
    int MultiClick;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment3_layout, container, false);

        count = 0;
        rand = new Random();
        primeWord = rand.nextInt(13) + 4;

        soundpool = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
        tak = soundpool.load(getActivity(), R.raw.click1, 1);
        tok = soundpool.load(getActivity(), R.raw.click1_rebert1, 1);

        db = new DatabaseHelper(getActivity());

        Button btnTEST = view.findViewById(R.id.btnTEST);
        btnTEST.setTextColor(Color.parseColor("#ffffff"));
        Button btn_save = view.findViewById(R.id.button3);
        final Switch sw1 = view.findViewById(R.id.switch1);


        F1TV1 = view.findViewById(R.id.F1TV1);
        F1TV2 = view.findViewById(R.id.F1TV2);
        F1TV3 = view.findViewById(R.id.F1TV3);
        F1TV4 = view.findViewById(R.id.F1TV4);
        F1TV5 = view.findViewById(R.id.F1TV5);
        F1TV6 = view.findViewById(R.id.F1TV6);

        F2TV1 = view.findViewById(R.id.F2TV1);
        F2TV2 = view.findViewById(R.id.F2TV2);
        F2TV3 = view.findViewById(R.id.F2TV3);
        F2TV4 = view.findViewById(R.id.F2TV4);
        F2TV5 = view.findViewById(R.id.F2TV5);
        F2TV6 = view.findViewById(R.id.F2TV6);

        F3TV1 = view.findViewById(R.id.F3TV1);
        F3TV2 = view.findViewById(R.id.F3TV2);
        F3TV3 = view.findViewById(R.id.F3TV3);
        F3TV4 = view.findViewById(R.id.F3TV4);
        F3TV5 = view.findViewById(R.id.F3TV5);
        F3TV6 = view.findViewById(R.id.F3TV6);

        F4TV1 = view.findViewById(R.id.F4TV1);
        F4TV2 = view.findViewById(R.id.F4TV2);
        F4TV3 = view.findViewById(R.id.F4TV3);
        F4TV4 = view.findViewById(R.id.F4TV4);
        F4TV5 = view.findViewById(R.id.F4TV5);
        F4TV6 = view.findViewById(R.id.F4TV6);

        F5TV1 = view.findViewById(R.id.F5TV1);
        F5TV2 = view.findViewById(R.id.F5TV2);
        F5TV3 = view.findViewById(R.id.F5TV3);
        F5TV4 = view.findViewById(R.id.F5TV4);
        F5TV5 = view.findViewById(R.id.F5TV5);
        F5TV6 = view.findViewById(R.id.F5TV6);

        Button btnSHARE = view.findViewById(R.id.button);

        wisetext1 = view.findViewById(R.id.wisetext3);


        sw1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundpool.play(tak, 1, 1, 1, 0, 1);
                if (sw1.isChecked()) {
                    MultiClick = 1;
                } else {
                    MultiClick = 0;
                }
            }
        });

        btnTEST.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                // 반복 회수 끝
                soundpool.play(tak, 1, 1, 0, 0, 1);


                if (MultiClick == 1) {
                    // 반복 회수 지정

                    int xnum = rand.nextInt(9);
                    millisec = Times_Ran[xnum];
                } else {


                    millisec = static_millisec;
                }

                CountDownTimer start = new CountDownTimer(millisec, 10) {
                    public void onTick(long millisUntilFinished) {
                        soundpool.play(tak, 1, 1, 0, 0, 1);

                        GenNumber();
                    }

                    public void onFinish() {
                        // 반복 후 작업은 아래에 라인
                        ClickCount1 = 0;
                        wiseWord();

                    }

                }.start();

            }
        });


        btn_save.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NewApi")
            @Override
            public void onClick(View view) {
                soundpool.play(tok, 1, 1, 0, 0, 0);

                LotCOPY();

                savenum(ClickCount1, ctextRlist1);
                ClickCount1 = 1;
            }
        });

        btnSHARE.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                soundpool.play(tak, 1, 1, 0, 0, 0);

                String check1;
                check1 = F1TV1.getText().toString();

                if (check1 == "") {

                    showGuide(getString(R.string.tab_info1));
                    wisetext1.setText(getString(R.string.tab_info1));

                    //안내 문구

                } else {

                    LotCOPY();

                    Intent msg = new Intent(Intent.ACTION_SEND);
                    msg.addCategory(Intent.CATEGORY_DEFAULT);
                    msg.putExtra(Intent.EXTRA_SUBJECT, "Power Ball Number");
                    msg.putExtra(Intent.EXTRA_TEXT, ctextR);
                    msg.putExtra(Intent.EXTRA_TITLE, "SA Lottery");
                    msg.setType("text/plain");
                    startActivity(Intent.createChooser(msg, "Share"));
                    showGuide("PowerBall Number Share");
                }
            }
        });

        return view;

    }


    public void showGuide(String input1) {
        Toast.makeText(getActivity(), input1, Toast.LENGTH_SHORT).show();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void LotCOPY() {
        String App_links1 = getString(R.string.app_links);
        String App_Share = getString(R.string.app_share);
        String tab_info1 = getString(R.string.tab_text2);

        String Srednum1, Srednum2, Srednum3, Srednum4, Srednum5;

        String[] SLot1num1 = new String[5];
        String[] SLot1num2 = new String[5];
        String[] SLot1num3 = new String[5];
        String[] SLot1num4 = new String[5];
        String[] SLot1num5 = new String[5];


        //텍스트 변환
        /** 숫자 고정 자리수 */
        DecimalFormat cure = new DecimalFormat("##");
        cure.setMinimumIntegerDigits(2);

        Srednum1 = cure.format((rednum1[0]));
        Srednum2 = cure.format((rednum2[0]));
        Srednum3 = cure.format((rednum3[0]));
        Srednum4 = cure.format((rednum4[0]));
        Srednum5 = cure.format((rednum5[0]));

        for (int i = 0; i < 5; i++) {
            SLot1num1[i] = cure.format((Lot1num1[i]));
            SLot1num2[i] = cure.format((Lot1num2[i]));
            SLot1num3[i] = cure.format((Lot1num3[i]));
            SLot1num4[i] = cure.format((Lot1num4[i]));
            SLot1num5[i] = cure.format((Lot1num5[i]));
        }


        ctextR = tab_info1 + "\n";

        ctextR = ctextR + (SLot1num1[0] + ", " + SLot1num1[1] + ", " + SLot1num1[2] + ", " + SLot1num1[3] + ", " + SLot1num1[4] + " (" + Srednum1 + ")\n");
        ctextR = ctextR + (SLot1num2[0] + ", " + SLot1num2[1] + ", " + SLot1num2[2] + ", " + SLot1num2[3] + ", " + SLot1num2[4] + " (" + Srednum2 + ")\n");
        ctextR = ctextR + (SLot1num3[0] + ", " + SLot1num3[1] + ", " + SLot1num3[2] + ", " + SLot1num3[3] + ", " + SLot1num3[4] + " (" + Srednum3 + ")\n");
        ctextR = ctextR + (SLot1num4[0] + ", " + SLot1num4[1] + ", " + SLot1num4[2] + ", " + SLot1num4[3] + ", " + SLot1num4[4] + " (" + Srednum4 + ")\n");
        ctextR = ctextR + (SLot1num5[0] + ", " + SLot1num5[1] + ", " + SLot1num5[2] + ", " + SLot1num5[3] + ", " + SLot1num5[4] + " (" + Srednum5 + ")");

        ctextRlist = ctextR;

        ctextRlist1 = Lot1num1[0] + "," + Lot1num1[1] + "," + Lot1num1[2] + "," + Lot1num1[3] + "," + Lot1num1[4] + "," + rednum1[0];
        ctextRlist2 = Lot1num2[0] + "," + Lot1num2[1] + "," + Lot1num2[2] + "," + Lot1num2[3] + "," + Lot1num2[4] + "," + rednum2[0];
        ctextRlist3 = Lot1num3[0] + "," + Lot1num3[1] + "," + Lot1num3[2] + "," + Lot1num3[3] + "," + Lot1num3[4] + "," + rednum3[0];
        ctextRlist4 = Lot1num4[0] + "," + Lot1num4[1] + "," + Lot1num4[2] + "," + Lot1num4[3] + "," + Lot1num4[4] + "," + rednum4[0];
        ctextRlist5 = Lot1num5[0] + "," + Lot1num5[1] + "," + Lot1num5[2] + "," + Lot1num5[3] + "," + Lot1num5[4] + "," + rednum5[0];

        ctextR = ctextR + "\n\n" + App_links1 + "\n" + App_Share + "★Good Luck★";

    }

    public void wiseWord() {

        count = count + 1;
        Log.e("============", count + "====" + primeWord);

        if (count == primeWord) {
            String saywords = BackProcessHandler.frontSay();

            wisetext1.setText(saywords);
            count = 0;
            primeWord = rand.nextInt(11) + 3;
        }

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void GenNumber() {

        randomNum Rnum = new randomNum();

        rednum1 = Rnum.lotArray(1, 20);
        rednum2 = Rnum.lotArray(1, 20);
        rednum3 = Rnum.lotArray(1, 20);
        rednum4 = Rnum.lotArray(1, 20);
        rednum5 = Rnum.lotArray(1, 20);

        Lot1num1 = Rnum.lotArray(5, 50);
        Lot1num2 = Rnum.lotArray(5, 50);
        Lot1num3 = Rnum.lotArray(5, 50);
        Lot1num4 = Rnum.lotArray(5, 50);
        Lot1num5 = Rnum.lotArray(5, 50);

        F1TV1.setText(String.valueOf(Lot1num1[0]));
        F1TV2.setText(String.valueOf(Lot1num1[1]));
        F1TV3.setText(String.valueOf(Lot1num1[2]));
        F1TV4.setText(String.valueOf(Lot1num1[3]));
        F1TV5.setText(String.valueOf(Lot1num1[4]));
        F1TV6.setText(String.valueOf(rednum1[0]));

        F2TV1.setText(String.valueOf(Lot1num2[0]));
        F2TV2.setText(String.valueOf(Lot1num2[1]));
        F2TV3.setText(String.valueOf(Lot1num2[2]));
        F2TV4.setText(String.valueOf(Lot1num2[3]));
        F2TV5.setText(String.valueOf(Lot1num2[4]));
        F2TV6.setText(String.valueOf(rednum2[0]));

        F3TV1.setText(String.valueOf(Lot1num3[0]));
        F3TV2.setText(String.valueOf(Lot1num3[1]));
        F3TV3.setText(String.valueOf(Lot1num3[2]));
        F3TV4.setText(String.valueOf(Lot1num3[3]));
        F3TV5.setText(String.valueOf(Lot1num3[4]));
        F3TV6.setText(String.valueOf(rednum3[0]));

        F4TV1.setText(String.valueOf(Lot1num4[0]));
        F4TV2.setText(String.valueOf(Lot1num4[1]));
        F4TV3.setText(String.valueOf(Lot1num4[2]));
        F4TV4.setText(String.valueOf(Lot1num4[3]));
        F4TV5.setText(String.valueOf(Lot1num4[4]));
        F4TV6.setText(String.valueOf(rednum4[0]));

        F5TV1.setText(String.valueOf(Lot1num5[0]));
        F5TV2.setText(String.valueOf(Lot1num5[1]));
        F5TV3.setText(String.valueOf(Lot1num5[2]));
        F5TV4.setText(String.valueOf(Lot1num5[3]));
        F5TV5.setText(String.valueOf(Lot1num5[4]));
        F5TV6.setText(String.valueOf(rednum5[0]));

    }


    public void savenum(int clickcount, String ctextRlist) {

        if (clickcount == 0) {
            db.insertNote(ctextRlist1, "PowerBall/Plus", "5 Auto 1");
            db.insertNote(ctextRlist2, "PowerBall/Plus", "5 Auto 2");
            db.insertNote(ctextRlist3, "PowerBall/Plus", "5 Auto 3");
            db.insertNote(ctextRlist4, "PowerBall/Plus", "5 Auto 4");
            db.insertNote(ctextRlist5, "PowerBall/Plus", "5 Auto 5");


            String Mesg1 = ctextRlist + " -> " + "Number has been saved.";

            showGuide(Mesg1);

        } else {

            showGuide("First Gen Button Click");

        }

    }
}
