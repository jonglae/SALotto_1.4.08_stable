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
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.Random;

import gotopark.com.SAlotto.module.randomNum;


public class Tab3Fragment extends Fragment {

    private static final String TAG = "Tab3Fragment";

    public String ctextR;

    TextView text1;

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

    int[] rednum1 = new int[0];
    int[] rednum2 = new int[0];
    int[] rednum3 = new int[0];
    int[] rednum4 = new int[0];
    int[] rednum5 = new int[0];

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment3_layout, container, false);

        Button btnTEST = (Button) view.findViewById(R.id.btnTEST);
        btnTEST.setTextColor(Color.parseColor("#ffffff"));
        text1 = (TextView) view.findViewById(R.id.textView);


        F1TV1 = (TextView) view.findViewById(R.id.F1TV1);
        F1TV2 = (TextView) view.findViewById(R.id.F1TV2);
        F1TV3 = (TextView) view.findViewById(R.id.F1TV3);
        F1TV4 = (TextView) view.findViewById(R.id.F1TV4);
        F1TV5 = (TextView) view.findViewById(R.id.F1TV5);
        F1TV6 = (TextView) view.findViewById(R.id.F1TV6);

        F2TV1 = (TextView) view.findViewById(R.id.F2TV1);
        F2TV2 = (TextView) view.findViewById(R.id.F2TV2);
        F2TV3 = (TextView) view.findViewById(R.id.F2TV3);
        F2TV4 = (TextView) view.findViewById(R.id.F2TV4);
        F2TV5 = (TextView) view.findViewById(R.id.F2TV5);
        F2TV6 = (TextView) view.findViewById(R.id.F2TV6);

        F3TV1 = (TextView) view.findViewById(R.id.F3TV1);
        F3TV2 = (TextView) view.findViewById(R.id.F3TV2);
        F3TV3 = (TextView) view.findViewById(R.id.F3TV3);
        F3TV4 = (TextView) view.findViewById(R.id.F3TV4);
        F3TV5 = (TextView) view.findViewById(R.id.F3TV5);
        F3TV6 = (TextView) view.findViewById(R.id.F3TV6);

        F4TV1 = (TextView) view.findViewById(R.id.F4TV1);
        F4TV2 = (TextView) view.findViewById(R.id.F4TV2);
        F4TV3 = (TextView) view.findViewById(R.id.F4TV3);
        F4TV4 = (TextView) view.findViewById(R.id.F4TV4);
        F4TV5 = (TextView) view.findViewById(R.id.F4TV5);
        F4TV6 = (TextView) view.findViewById(R.id.F4TV6);

        F5TV1 = (TextView) view.findViewById(R.id.F5TV1);
        F5TV2 = (TextView) view.findViewById(R.id.F5TV2);
        F5TV3 = (TextView) view.findViewById(R.id.F5TV3);
        F5TV4 = (TextView) view.findViewById(R.id.F5TV4);
        F5TV5 = (TextView) view.findViewById(R.id.F5TV5);
        F5TV6 = (TextView) view.findViewById(R.id.F5TV6);

        Button btnSHARE = (Button) view.findViewById(R.id.button);

        btnTEST.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {

                Random rand = new Random();
                // 반복 회수 지정
                int Times_Ran[] = {250, 350, 650, 850, 950, 1150};
                int xnum = rand.nextInt(5);
                int millisec = Times_Ran[xnum];
                // 반복 회수 끝

                CountDownTimer start = new CountDownTimer(millisec, 50) {
                    public void onTick(long millisUntilFinished) {
                        GenNumber();
                    }

                    public void onFinish() {
                        // 반복 후 작업은 아래에 라인

                    }

                }.start();

            }
        });


        btnSHARE.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {

                String check1;
                check1 = F1TV1.getText().toString();

                if (check1 == "") {

                    showGuide(getString(R.string.tab_info1));
                    text1.setText(getString(R.string.tab_info1));

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

        ctextR = ctextR + "\n\n" + App_links1 + "\n" + App_Share + "★Good Luck★";

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

//        text1.setTextSize (TypedValue.COMPLEX_UNIT_SP, 30);
//        text1.setTextColor (Color.parseColor ("#000000"));
//        text1.setText (SLot1num1[0] + ", " + SLot1num1[1] + ", " + SLot1num1[2] + ", " + SLot1num1[3] + ", " + SLot1num1[4] + " (" + Srednum1 + ")\n");
//        text1.append (SLot1num2[0] + ", " + SLot1num2[1] + ", " + SLot1num2[2] + ", " + SLot1num2[3] + ", " + SLot1num2[4] + " (" + Srednum2 + ")\n");
//        text1.append (SLot1num3[0] + ", " + SLot1num3[1] + ", " + SLot1num3[2] + ", " + SLot1num3[3] + ", " + SLot1num3[4] + " (" + Srednum3 + ")\n");
//        text1.append (SLot1num4[0] + ", " + SLot1num4[1] + ", " + SLot1num4[2] + ", " + SLot1num4[3] + ", " + SLot1num4[4] + " (" + Srednum4 + ")\n");
//        text1.append (SLot1num5[0] + ", " + SLot1num5[1] + ", " + SLot1num5[2] + ", " + SLot1num5[3] + ", " + SLot1num5[4] + " (" + Srednum5 + ")");

    }


}
