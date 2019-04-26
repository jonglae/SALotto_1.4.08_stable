package gotopark.com.SAlotto.module;

import org.jsoup.select.Elements;

import gotopark.com.SAlotto.R;

/**
 * Created by buster on 18. 3. 26.
 */

public class numtoimg {

    public int Numimg(int input1) {


        final int[] Imgnum = {
                R.drawable.ball1,
                R.drawable.ball2,
                R.drawable.ball3,
                R.drawable.ball4};

        if (input1 >= 1 && input1 <= 13) {
            return Imgnum[0];
        } else if (input1 >= 14 && input1 <= 26) {
            return Imgnum[1];
        } else if (input1 >= 27 && input1 <= 36) {
            return Imgnum[2];
        } else if (input1 >= 37 && input1 <= 52) {
            return Imgnum[3];
        } else {
            return Imgnum[3];

        }


    }





}

