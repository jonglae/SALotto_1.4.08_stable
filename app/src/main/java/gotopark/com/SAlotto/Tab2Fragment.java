package gotopark.com.SAlotto;

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

import java.text.DecimalFormat;
import java.util.Random;

import gotopark.com.SAlotto.module.numtoimg;
import gotopark.com.SAlotto.module.randomNum;

public class Tab2Fragment extends Fragment {



    private static final String TAG = "Tab2Fragment";
    public String ctextR;
    TextView text1;
    TextView wisetext1;

    TextView F1TV1, F1TV2, F1TV3, F1TV4, F1TV5, F1TV6;
    TextView F2TV1, F2TV2, F2TV3, F2TV4, F2TV5, F2TV6;
    TextView F3TV1, F3TV2, F3TV3, F3TV4, F3TV5, F3TV6;
    TextView F4TV1, F4TV2, F4TV3, F4TV4, F4TV5, F4TV6;
    TextView F5TV1, F5TV2, F5TV3, F5TV4, F5TV5, F5TV6;


    ImageView F1MIV1, F1MIV2, F1MIV3, F1MIV4, F1MIV5, F1MIV6;
    ImageView F2MIV1, F2MIV2, F2MIV3, F2MIV4, F2MIV5, F2MIV6;
    ImageView F3MIV1, F3MIV2, F3MIV3, F3MIV4, F3MIV5, F3MIV6;
    ImageView F4MIV1, F4MIV2, F4MIV3, F4MIV4, F4MIV5, F4MIV6;
    ImageView F5MIV1, F5MIV2, F5MIV3, F5MIV4, F5MIV5, F5MIV6;


    int[] Lot1num1 = new int[6];
    int[] Lot1num2 = new int[6];
    int[] Lot1num3 = new int[6];
    int[] Lot1num4 = new int[6];
    int[] Lot1num5 = new int[6];

    private Random rand;
    int count,primeWord;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment2_layout, container, false);

        count = 0;
        rand = new Random();
        primeWord = rand.nextInt(13) + 4;


        Button btnTEST = view.findViewById(R.id.btnTEST);
        btnTEST.setTextColor(Color.parseColor("#ffffff"));
        Button btnSHARE = view.findViewById(R.id.button2);

        wisetext1 = view.findViewById(R.id.wisetext2);


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

        F1MIV1 = view.findViewById(R.id.F1MIV1);
        F1MIV2 = view.findViewById(R.id.F1MIV2);
        F1MIV3 = view.findViewById(R.id.F1MIV3);
        F1MIV4 = view.findViewById(R.id.F1MIV4);
        F1MIV5 = view.findViewById(R.id.F1MIV5);
        F1MIV6 = view.findViewById(R.id.F1MIV6);

        F2MIV1 = view.findViewById(R.id.F2MIV1);
        F2MIV2 = view.findViewById(R.id.F2MIV2);
        F2MIV3 = view.findViewById(R.id.F2MIV3);
        F2MIV4 = view.findViewById(R.id.F2MIV4);
        F2MIV5 = view.findViewById(R.id.F2MIV5);
        F2MIV6 = view.findViewById(R.id.F2MIV6);

        F3MIV1 = view.findViewById(R.id.F3MIV1);
        F3MIV2 = view.findViewById(R.id.F3MIV2);
        F3MIV3 = view.findViewById(R.id.F3MIV3);
        F3MIV4 = view.findViewById(R.id.F3MIV4);
        F3MIV5 = view.findViewById(R.id.F3MIV5);
        F3MIV6 = view.findViewById(R.id.F3MIV6);

        F4MIV1 = view.findViewById(R.id.F4MIV1);
        F4MIV2 = view.findViewById(R.id.F4MIV2);
        F4MIV3 = view.findViewById(R.id.F4MIV3);
        F4MIV4 = view.findViewById(R.id.F4MIV4);
        F4MIV5 = view.findViewById(R.id.F4MIV5);
        F4MIV6 = view.findViewById(R.id.F4MIV6);

        F5MIV1 = view.findViewById(R.id.F5MIV1);
        F5MIV2 = view.findViewById(R.id.F5MIV2);
        F5MIV3 = view.findViewById(R.id.F5MIV3);
        F5MIV4 = view.findViewById(R.id.F5MIV4);
        F5MIV5 = view.findViewById(R.id.F5MIV5);
        F5MIV6 = view.findViewById(R.id.F5MIV6);


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
                        GenNumber();
                    }

                    public void onFinish() {
                        // 반복 후 작업은 아래에 라인
                        wiseWord();
                    }

                }.start();


            }
        });

        btnSHARE.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {

                String check1;
                check1 = F2TV1.getText().toString();

                if (check1 != null && check1.equals("")) {

                    showGuide(getString(R.string.tab_info1));
                    wisetext1.setText(getString(R.string.tab_info1));

                    //안내 문구

                } else {


                    LotCOPY();
                    Intent msg = new Intent(Intent.ACTION_SEND);
                    msg.addCategory(Intent.CATEGORY_DEFAULT);
                    msg.putExtra(Intent.EXTRA_SUBJECT, "Lotto Number");
                    msg.putExtra(Intent.EXTRA_TEXT, ctextR);
                    msg.putExtra(Intent.EXTRA_TITLE, "SA Lottery");
                    msg.setType("text/plain");
                    startActivity(Intent.createChooser(msg, "Share"));
                    showGuide("Lotto Number Share");

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
        String tab_info1 = getString(R.string.tab_text1);

        String[] SLot1num1 = new String[6];
        String[] SLot1num2 = new String[6];
        String[] SLot1num3 = new String[6];
        String[] SLot1num4 = new String[6];
        String[] SLot1num5 = new String[6];

        //텍스트 변환
        /** 숫자 고정 자리수 */
        DecimalFormat cure = new DecimalFormat("##");
        cure.setMinimumIntegerDigits(2);

        for (int i = 0; i < 6; i++) {
            SLot1num1[i] = cure.format((Lot1num1[i]));
            SLot1num2[i] = cure.format((Lot1num2[i]));
            SLot1num3[i] = cure.format((Lot1num3[i]));
            SLot1num4[i] = cure.format((Lot1num4[i]));
            SLot1num5[i] = cure.format((Lot1num5[i]));
        }


        ctextR = tab_info1 + "\n";

        ctextR = ctextR + (SLot1num1[0] + ", " + SLot1num1[1] + ", " + SLot1num1[2] + ", " + SLot1num1[3] + ", " + SLot1num1[4] + ", " + SLot1num1[5] + "\n");
        ctextR = ctextR + (SLot1num2[0] + ", " + SLot1num2[1] + ", " + SLot1num2[2] + ", " + SLot1num2[3] + ", " + SLot1num2[4] + ", " + SLot1num2[5] + "\n");
        ctextR = ctextR + (SLot1num3[0] + ", " + SLot1num3[1] + ", " + SLot1num3[2] + ", " + SLot1num3[3] + ", " + SLot1num3[4] + ", " + SLot1num3[5] + "\n");
        ctextR = ctextR + (SLot1num4[0] + ", " + SLot1num4[1] + ", " + SLot1num4[2] + ", " + SLot1num4[3] + ", " + SLot1num4[4] + ", " + SLot1num4[5] + "\n");
        ctextR = ctextR + (SLot1num5[0] + ", " + SLot1num5[1] + ", " + SLot1num5[2] + ", " + SLot1num5[3] + ", " + SLot1num5[4] + ", " + SLot1num5[5]);

        ctextR = ctextR + "\n\n" + App_links1 + "\n" + App_Share + "★Good Luck★";

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


    public void GenNumber() {

        /**
         //                Toast.makeText(getActivity(), "TESTING BUTTON CLICK 1",Toast.LENGTH_SHORT).show();
         //                showGuide("안녕하세요");
         */


        int d1ball1;
        int d1ball2;
        int d1ball3;
        int d1ball4;
        int d1ball5;
        int d1ball6;

        int d2ball1;
        int d2ball2;
        int d2ball3;
        int d2ball4;
        int d2ball5;
        int d2ball6;

        int d3ball1;
        int d3ball2;
        int d3ball3;
        int d3ball4;
        int d3ball5;
        int d3ball6;

        int d4ball1;
        int d4ball2;
        int d4ball3;
        int d4ball4;
        int d4ball5;
        int d4ball6;

        int d5ball1;
        int d5ball2;
        int d5ball3;
        int d5ball4;
        int d5ball5;
        int d5ball6;

        randomNum Rnum = new randomNum();
        numtoimg NumtoI = new numtoimg();

        Lot1num1 = Rnum.lotArray(6, 52);
        Lot1num2 = Rnum.lotArray(6, 52);
        Lot1num3 = Rnum.lotArray(6, 52);
        Lot1num4 = Rnum.lotArray(6, 52);
        Lot1num5 = Rnum.lotArray(6, 52);

        d1ball1 = NumtoI.Numimg(Lot1num1[0]);
        d1ball2 = NumtoI.Numimg(Lot1num1[1]);
        d1ball3 = NumtoI.Numimg(Lot1num1[2]);
        d1ball4 = NumtoI.Numimg(Lot1num1[3]);
        d1ball5 = NumtoI.Numimg(Lot1num1[4]);
        d1ball6 = NumtoI.Numimg(Lot1num1[5]);

        d2ball1 = NumtoI.Numimg(Lot1num2[0]);
        d2ball2 = NumtoI.Numimg(Lot1num2[1]);
        d2ball3 = NumtoI.Numimg(Lot1num2[2]);
        d2ball4 = NumtoI.Numimg(Lot1num2[3]);
        d2ball5 = NumtoI.Numimg(Lot1num2[4]);
        d2ball6 = NumtoI.Numimg(Lot1num2[5]);

        d3ball1 = NumtoI.Numimg(Lot1num3[0]);
        d3ball2 = NumtoI.Numimg(Lot1num3[1]);
        d3ball3 = NumtoI.Numimg(Lot1num3[2]);
        d3ball4 = NumtoI.Numimg(Lot1num3[3]);
        d3ball5 = NumtoI.Numimg(Lot1num3[4]);
        d3ball6 = NumtoI.Numimg(Lot1num3[5]);

        d4ball1 = NumtoI.Numimg(Lot1num4[0]);
        d4ball2 = NumtoI.Numimg(Lot1num4[1]);
        d4ball3 = NumtoI.Numimg(Lot1num4[2]);
        d4ball4 = NumtoI.Numimg(Lot1num4[3]);
        d4ball5 = NumtoI.Numimg(Lot1num4[4]);
        d4ball6 = NumtoI.Numimg(Lot1num4[5]);

        d5ball1 = NumtoI.Numimg(Lot1num5[0]);
        d5ball2 = NumtoI.Numimg(Lot1num5[1]);
        d5ball3 = NumtoI.Numimg(Lot1num5[2]);
        d5ball4 = NumtoI.Numimg(Lot1num5[3]);
        d5ball5 = NumtoI.Numimg(Lot1num5[4]);
        d5ball6 = NumtoI.Numimg(Lot1num5[5]);

        F1TV1.setText(String.valueOf(Lot1num1[0]));
        F1TV2.setText(String.valueOf(Lot1num1[1]));
        F1TV3.setText(String.valueOf(Lot1num1[2]));
        F1TV4.setText(String.valueOf(Lot1num1[3]));
        F1TV5.setText(String.valueOf(Lot1num1[4]));
        F1TV6.setText(String.valueOf(Lot1num1[5]));

        F2TV1.setText(String.valueOf(Lot1num2[0]));
        F2TV2.setText(String.valueOf(Lot1num2[1]));
        F2TV3.setText(String.valueOf(Lot1num2[2]));
        F2TV4.setText(String.valueOf(Lot1num2[3]));
        F2TV5.setText(String.valueOf(Lot1num2[4]));
        F2TV6.setText(String.valueOf(Lot1num2[5]));

        F3TV1.setText(String.valueOf(Lot1num3[0]));
        F3TV2.setText(String.valueOf(Lot1num3[1]));
        F3TV3.setText(String.valueOf(Lot1num3[2]));
        F3TV4.setText(String.valueOf(Lot1num3[3]));
        F3TV5.setText(String.valueOf(Lot1num3[4]));
        F3TV6.setText(String.valueOf(Lot1num3[5]));

        F4TV1.setText(String.valueOf(Lot1num4[0]));
        F4TV2.setText(String.valueOf(Lot1num4[1]));
        F4TV3.setText(String.valueOf(Lot1num4[2]));
        F4TV4.setText(String.valueOf(Lot1num4[3]));
        F4TV5.setText(String.valueOf(Lot1num4[4]));
        F4TV6.setText(String.valueOf(Lot1num4[5]));

        F5TV1.setText(String.valueOf(Lot1num5[0]));
        F5TV2.setText(String.valueOf(Lot1num5[1]));
        F5TV3.setText(String.valueOf(Lot1num5[2]));
        F5TV4.setText(String.valueOf(Lot1num5[3]));
        F5TV5.setText(String.valueOf(Lot1num5[4]));
        F5TV6.setText(String.valueOf(Lot1num5[5]));

//        Ballimg1.setImageResource (dball1);

        F1MIV1.setImageResource(d1ball1);
        F1MIV2.setImageResource(d1ball2);
        F1MIV3.setImageResource(d1ball3);
        F1MIV4.setImageResource(d1ball4);
        F1MIV5.setImageResource(d1ball5);
        F1MIV6.setImageResource(d1ball6);

        F2MIV1.setImageResource(d2ball1);
        F2MIV2.setImageResource(d2ball2);
        F2MIV3.setImageResource(d2ball3);
        F2MIV4.setImageResource(d2ball4);
        F2MIV5.setImageResource(d2ball5);
        F2MIV6.setImageResource(d2ball6);

        F3MIV1.setImageResource(d3ball1);
        F3MIV2.setImageResource(d3ball2);
        F3MIV3.setImageResource(d3ball3);
        F3MIV4.setImageResource(d3ball4);
        F3MIV5.setImageResource(d3ball5);
        F3MIV6.setImageResource(d3ball6);


        F4MIV1.setImageResource(d4ball1);
        F4MIV2.setImageResource(d4ball2);
        F4MIV3.setImageResource(d4ball3);
        F4MIV4.setImageResource(d4ball4);
        F4MIV5.setImageResource(d4ball5);
        F4MIV6.setImageResource(d4ball6);

        F5MIV1.setImageResource(d5ball1);
        F5MIV2.setImageResource(d5ball2);
        F5MIV3.setImageResource(d5ball3);
        F5MIV4.setImageResource(d5ball4);
        F5MIV5.setImageResource(d5ball5);
        F5MIV6.setImageResource(d5ball6);


    }

}