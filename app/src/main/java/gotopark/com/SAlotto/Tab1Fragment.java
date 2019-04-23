package gotopark.com.SAlotto;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
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

    private TextView text1,wisetext1;

    private TextView limgtext1;
    private TextView limgtext2;
    private TextView limgtext3;
    private TextView limgtext4;
    private TextView limgtext5;
    private TextView limgtext6;

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


    private TextView WiseTxTWord;

    public Random rand;
    int count,primeWord;

    @SuppressLint("CutPasteId")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment1_layout, container, false);

        count = 0;
        rand = new Random();
        primeWord = rand.nextInt(13) + 4;


        wisetext1 = view.findViewById(R.id.wisetext);


        Button btnTEST = view.findViewById(R.id.btnTEST);
        Button btnTEST2 = view.findViewById(R.id.btnTEST2);
        Button btnSHARE = view.findViewById(R.id.button3);

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


        btnTEST.setTextColor(Color.parseColor("#ffffff"));
        btnTEST2.setTextColor(Color.parseColor("#ffffff"));


        btnTEST.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {

                // 반복 회수 지정
                int[] Times_Ran = {250, 350, 650, 850, 950, 1150};
                int xnum = rand.nextInt(5);
                int millisec = Times_Ran[xnum];
                // 반복 회수 끝

                CountDownTimer start = new CountDownTimer(millisec, 50) {
                    public void onTick(long millisUntilFinished) {
                        Gen1Number();
                    }

                    public void onFinish() {
                        // 반복 후 작업은 아래에 라인
                        wiseWord();
                    }

                }.start();


            }
        });

        btnTEST2.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {

                // 반복 회수 지정
                int[] Times_Ran = {250, 350, 650, 850, 950, 1150};
                int xnum = rand.nextInt(5);
                int millisec = Times_Ran[xnum];
                // 반복 회수 끝

                CountDownTimer start = new CountDownTimer(millisec, 50) {
                    public void onTick(long millisUntilFinished) {
                        Gen2Number();
                    }

                    public void onFinish() {
                        // 반복 후 작업은 아래에 라인
                        wiseWord();
                    }

                }.start();


            }
        });


        btnSHARE.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NewApi")
            @Override
            public void onClick(View view) {

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

        //안내 문구 삭제


        ctextR = App_Share;
        ctextR = ctextR + "\n" + "Lotto and plus1,2 ";
        ctextR = ctextR + "\n" + ctext1 + ", " + ctext2 + ", " + ctext3 + ", " + ctext4 + ", " + ctext5 + ", " + ctext6 + "\n";
        ctextR = ctextR + "\n" + "PowerBall";
        ctextR = ctextR + "\n" + cptext1 + ", " + cptext2 + ", " + cptext3 + ", " + cptext4 + ", " + cptext5 + ", " + cptext6 + "\n\n" + App_links1 + "\n1등 ^^당첨을 기원합니다.~♡";

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

    public void wiseWord(){

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


}