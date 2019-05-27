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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import java.util.Objects;
import java.util.Random;


import gotopark.com.SAlotto.module.numtoimg;
import gotopark.com.SAlotto.module.randomNum;

public class Tab1Fragment extends Fragment {
    private static final String TAG = "Tab1Fragment";
    private String ctextR;

    private TextView text1, wisetext1;

    private TextView limgtext1;
    private TextView limgtext2;
    private TextView limgtext3;
    private TextView limgtext4;
    private TextView limgtext5;
    private TextView limgtext6;

    private TextView DLtext1;
    private TextView DLtext2;
    private TextView DLtext3;
    private TextView DLtext4;
    private TextView DLtext5;

    private ImageView limg1;
    private ImageView limg2;
    private ImageView limg3;
    private ImageView limg4;
    private ImageView limg5;
    private ImageView limg6;

    private TextView pimgtext1;
    private TextView pimgtext2;
    private TextView pimgtext3;
    private TextView pimgtext4;
    private TextView pimgtext5;
    private TextView pimgtext6;

    public Random rand;

    String ctextRlist1, ctextRlist2, ctextRlist3;


    int ClickCount1 = 1;
    int ClickCount2 = 1;
    int ClickCount3 = 1;

    int count, primeWord;

    int tak,tok;
    SoundPool soundpool;


    @SuppressLint("CutPasteId")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment1_layout, container, false);

        count = 0;
        rand = new Random();
        primeWord = rand.nextInt(13) + 4;

        soundpool = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
        tak = soundpool.load(getActivity() , R.raw.short_click2 , 1);
        tok = soundpool.load(getActivity(), R.raw.click1_rebert1, 1);

        wisetext1 = view.findViewById(R.id.wisetext);


        Button btnTEST = view.findViewById(R.id.btnTEST);
        Button btnTEST2 = view.findViewById(R.id.btnTEST2);
        Button btnTEST3 = view.findViewById(R.id.btnTEST3);
        Button btnSHARE = view.findViewById(R.id.button3);
        Button btn_list = view.findViewById(R.id.btn_list);

        Button btn_save1 = view.findViewById(R.id.btn_save1);
        Button btn_save2 = view.findViewById(R.id.btn_save2);
        Button btn_save3 = view.findViewById(R.id.btn_save3);

        limg1 = view.findViewById(R.id.limg1);
        limg2 = view.findViewById(R.id.limg2);
        limg3 = view.findViewById(R.id.limg3);
        limg4 = view.findViewById(R.id.limg4);
        limg5 = view.findViewById(R.id.limg5);
        limg6 = view.findViewById(R.id.limg6);

        limgtext1 = view.findViewById(R.id.limgtext1);
        limgtext2 = view.findViewById(R.id.limgtext2);
        limgtext3 = view.findViewById(R.id.limgtext3);
        limgtext4 = view.findViewById(R.id.limgtext4);
        limgtext5 = view.findViewById(R.id.limgtext5);
        limgtext6 = view.findViewById(R.id.limgtext6);


        pimgtext1 = view.findViewById(R.id.pimgtext1);
        pimgtext2 = view.findViewById(R.id.pimgtext2);
        pimgtext3 = view.findViewById(R.id.pimgtext3);
        pimgtext4 = view.findViewById(R.id.pimgtext4);
        pimgtext5 = view.findViewById(R.id.pimgtext5);
        pimgtext6 = view.findViewById(R.id.pimgtext6);

        DLtext1 = view.findViewById(R.id.dltext1);
        DLtext2 = view.findViewById(R.id.dltext2);
        DLtext3 = view.findViewById(R.id.dltext3);
        DLtext4 = view.findViewById(R.id.dltext4);
        DLtext5 = view.findViewById(R.id.dltext5);


        btnTEST.setTextColor(Color.parseColor("#ffffff"));
        btnTEST2.setTextColor(Color.parseColor("#ffffff"));


        btnTEST.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                // 사운드 재생
                soundpool.play(tak, 1, 1, 0, 0, 0);

                // 반복 회수 지정
                int[] Times_Ran = {250, 350, 650, 850, 950, 1150};
                int xnum = rand.nextInt(5);
                int millisec = Times_Ran[xnum];



                CountDownTimer start = new CountDownTimer(millisec, 50) {
                    public void onTick(long millisUntilFinished) {
                        soundpool.play(tak, 1, 1, 0, 0, 0);


                        Gen1Number();

                    }

                    public void onFinish() {
                        // 반복 후 작업은 아래에 라인
                        wiseWord();
                        ClickCount1 = 0;

                    }

                }.start();


            }
        });

        btnTEST2.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                // 사운드 재생
                soundpool.play(tak, 1, 1, 0, 0, 0);
                // 반복 회수 지정
                int[] Times_Ran = {250, 350, 650, 850, 950, 1150};
                int xnum = rand.nextInt(5);
                int millisec = Times_Ran[xnum];



                CountDownTimer start = new CountDownTimer(millisec, 50) {
                    public void onTick(long millisUntilFinished) {
                        soundpool.play(tak, 1, 1, 0, 0, 0);

                        Gen2Number();
                    }

                    public void onFinish() {
                        // 반복 후 작업은 아래에 라인
                        wiseWord();
                        ClickCount2 = 0;

                    }

                }.start();


            }
        });


        btnTEST3.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                // 사운드 재생
                soundpool.play(tak, 1, 1, 0, 0, 0);
                // 반복 회수 지정
                int[] Times_Ran = {250, 350, 650, 850, 950, 1150};
                int xnum = rand.nextInt(5);
                int millisec = Times_Ran[xnum];




                CountDownTimer start = new CountDownTimer(millisec, 50) {
                    public void onTick(long millisUntilFinished) {

                        soundpool.play(tak, 1, 1, 0, 0, 0);

                        Gen3Number();
                    }

                    public void onFinish() {
                        // 반복 후 작업은 아래에 라인
                        wiseWord();
                        ClickCount3 = 0;

                    }

                }.start();

            }
        });


        btn_save1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NewApi")
            @Override
            public void onClick(View view) {
                LotCOPY();
                soundpool.play(tok, 1, 1, 0, 0, 0);

                savenum(ClickCount1, ctextRlist1);
                ClickCount1 = 1;
            }
        });

        btn_save2.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NewApi")
            @Override
            public void onClick(View view) {
                soundpool.play(tok, 1, 1, 0, 0, 0);

                LotCOPY();

                savenum(ClickCount2, ctextRlist2);
                ClickCount2 = 1;
            }
        });
        btn_save3.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NewApi")
            @Override
            public void onClick(View view) {
                soundpool.play(tok, 1, 1, 0, 0, 0);

                LotCOPY();

                savenum(ClickCount3, ctextRlist3);
                ClickCount3 = 1;
            }
        });


        btn_list.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NewApi")
            @Override
            public void onClick(View view) {
                soundpool.play(tok, 1, 1, 0, 0, 0);

                Intent intent = new Intent(getActivity(), Main2Activity.class);
                startActivity(intent);

            }
        });


        btnSHARE.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NewApi")
            @Override
            public void onClick(View view) {
                soundpool.play(tak, 1, 1, 0, 0, 0);


                String check1;
                String check2;

                check1 = limgtext1.getText().toString();
                check2 = pimgtext1.getText().toString();

                if ((Objects.equals(check1, "0")) || (Objects.equals(check2, "0"))) {

                    //안내 문구
                    showGuide(getString(R.string.tab_info1));
                    wisetext1.setText(getString(R.string.tab_info1));


                } else {
                    LotCOPY();

                    Intent msg = new Intent(Intent.ACTION_SEND);
                    msg.addCategory(Intent.CATEGORY_DEFAULT);
                    msg.putExtra(Intent.EXTRA_SUBJECT, "Lottery Number");
                    msg.putExtra(Intent.EXTRA_TEXT, ctextR);
                    msg.putExtra(Intent.EXTRA_TITLE, "SA Lottery");
                    msg.setType("text/plain");
                    startActivity(Intent.createChooser(msg, "Share"));
                    showGuide("SA Lottery Number Share");
                }
            }
        });

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }


    public void showGuide(String input1) {
        Toast.makeText(getActivity(), input1, Toast.LENGTH_SHORT).show();
    }

    public void LotCOPY() {
        String App_links1 = getString(R.string.app_links);
        String App_Share = getString(R.string.app_share);

        String ctext1, cptext1;
        String ctext2, cptext2;
        String ctext3, cptext3;
        String ctext4, cptext4;
        String ctext5, cptext5;
        String ctext6, cptext6;

        String dltext1;
        String dltext2;
        String dltext3;
        String dltext4;
        String dltext5;


        ctext1 = limgtext1.getText().toString();
        ctext2 = limgtext2.getText().toString();
        ctext3 = limgtext3.getText().toString();
        ctext4 = limgtext4.getText().toString();
        ctext5 = limgtext5.getText().toString();
        ctext6 = limgtext6.getText().toString();

        cptext1 = pimgtext1.getText().toString();
        cptext2 = pimgtext2.getText().toString();
        cptext3 = pimgtext3.getText().toString();
        cptext4 = pimgtext4.getText().toString();
        cptext5 = pimgtext5.getText().toString();
        cptext6 = pimgtext6.getText().toString();

        dltext1 = DLtext1.getText().toString();
        dltext2 = DLtext2.getText().toString();
        dltext3 = DLtext3.getText().toString();
        dltext4 = DLtext4.getText().toString();
        dltext5 = DLtext5.getText().toString();


        //안내 문구 삭제


        ctextR = App_Share;
        ctextR = ctextR + "\n" + "Daily Lotto";
        ctextR = ctextR + "\n" + dltext1 + ", " + dltext2 + ", " + dltext3 + ", " + dltext4 + ", " + dltext5;

        ctextR = ctextR + "\n" + "Lotto and plus1,2 ";
        ctextR = ctextR + "\n" + ctext1 + ", " + ctext2 + ", " + ctext3 + ", " + ctext4 + ", " + ctext5 + ", " + ctext6;
        ctextR = ctextR + "\n" + "PowerBall";
        ctextR = ctextR + "\n" + cptext1 + ", " + cptext2 + ", " + cptext3 + ", " + cptext4 + ", " + cptext5 + ", " + cptext6 + "\n" + App_links1 + "\n1등 ^^당첨을 기원합니다.~♡";

        ctextRlist1 = "Lotto and plus1,2\n" + ctext1 + ", " + ctext2 + ", " + ctext3 + ", " + ctext4 + ", " + ctext5 + ", " + ctext6;
        ctextRlist2 = "PowerBall\n" + cptext1 + ", " + cptext2 + ", " + cptext3 + ", " + cptext4 + ", " + cptext5 + ", (" + cptext6 + ")";
        ctextRlist3 = "Daily Lotto\n" + dltext1 + ", " + dltext2 + ", " + dltext3 + ", " + dltext4 + ", " + dltext5;


    }


    public void Gen1Number() {

        int dball1;
        int dball2;
        int dball3;
        int dball4;
        int dball5;
        int dball6;

        int[] Lot1num1 = new int[6];
        randomNum Rnum = new randomNum();
        numtoimg NumtoI = new numtoimg();

        Lot1num1 = Rnum.lotArray(6, 52);

        dball1 = NumtoI.Numimg(Lot1num1[0]);
        dball2 = NumtoI.Numimg(Lot1num1[1]);
        dball3 = NumtoI.Numimg(Lot1num1[2]);
        dball4 = NumtoI.Numimg(Lot1num1[3]);
        dball5 = NumtoI.Numimg(Lot1num1[4]);
        dball6 = NumtoI.Numimg(Lot1num1[5]);

        limgtext1.setText(String.valueOf(Lot1num1[0]));
        limgtext2.setText(String.valueOf(Lot1num1[1]));
        limgtext3.setText(String.valueOf(Lot1num1[2]));
        limgtext4.setText(String.valueOf(Lot1num1[3]));
        limgtext5.setText(String.valueOf(Lot1num1[4]));
        limgtext6.setText(String.valueOf(Lot1num1[5]));

        limg1.setImageResource(dball1);
        limg2.setImageResource(dball2);
        limg3.setImageResource(dball3);
        limg4.setImageResource(dball4);
        limg5.setImageResource(dball5);
        limg6.setImageResource(dball6);


    }

    public void wiseWord() {

        count = count + 1;
//                        Log.e("============", count + "====" + primeWord);

        if (count == primeWord) {
            String saywords = BackProcessHandler.frontSay();
            wisetext1.setText(saywords);
            count = 0;
            primeWord = rand.nextInt(11) + 3;
        }

    }


    public void Gen2Number() {

        int[] Lot1num1 = new int[5];
        randomNum Rnum = new randomNum();

        int[] rednum1 = Rnum.lotArray(1, 20);
        Lot1num1 = Rnum.lotArray(5, 50);

        pimgtext1.setText(String.valueOf(Lot1num1[0]));
        pimgtext2.setText(String.valueOf(Lot1num1[1]));
        pimgtext3.setText(String.valueOf(Lot1num1[2]));
        pimgtext4.setText(String.valueOf(Lot1num1[3]));
        pimgtext5.setText(String.valueOf(Lot1num1[4]));
        pimgtext6.setText(String.valueOf(rednum1[0]));
    }

    public void Gen3Number() {

        int[] Lot1num1 = new int[4];
        randomNum Rnum = new randomNum();

        Lot1num1 = Rnum.lotArray(5, 36);

        DLtext1.setText(String.valueOf(Lot1num1[0]));
        DLtext2.setText(String.valueOf(Lot1num1[1]));
        DLtext3.setText(String.valueOf(Lot1num1[2]));
        DLtext4.setText(String.valueOf(Lot1num1[3]));
        DLtext5.setText(String.valueOf(Lot1num1[4]));
    }

    public void savenum(int clickcount, String ctextRlist) {

            if (clickcount == 0) {
                MainActivity.db.insertNote(ctextRlist);
                String Mesg1 = ctextRlist + " -> "+ "Number has been saved.";

                //The number has been saved.
//            wisetext1.setText(Mesg1);
                Toast.makeText(getActivity(), Mesg1, Toast.LENGTH_SHORT).show();

            } else {
                wisetext1.setText(getString(R.string.btn_save_Mesg1));

            }

    }

}