package gotopark.com.SAlotto.module;

import gotopark.com.SAlotto.R;

/**
 * Created by buster on 18. 3. 26.
 */

public class numtoimg {

    public int Numimg(int input1) {


        int Num = input1;
        final int Imgnum[] ={
                R.drawable.ball1,
                R.drawable.ball2,
                R.drawable.ball3,
                R.drawable.ball4};

            if (Num >= 1 && Num <= 13) {
                return Imgnum[0];
            } else if (Num >= 14 && Num <= 26) {
                return Imgnum[1];
            } else if (Num >= 27 && Num <= 36) {
                return Imgnum[2];
            } else if (Num >= 37 && Num <= 52) {
                return Imgnum[3];
            }else {
                return Imgnum[3];

            }


    }


    public int added(int input1 , int input2) {

        int add_b = input1 + input2;

        return add_b;


    }

}