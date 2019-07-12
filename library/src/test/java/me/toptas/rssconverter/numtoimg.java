package me.toptas.rssconverter;

/**
 * Created by buster on 18. 3. 26.
 */

public class numtoimg {

    public String Numimg(int input1) {


        int[] Num = new int[input1];
        String[] Imgnum = {"blue","red","green","white","yellow"};

        for (int i = 0; i > 6; i++) {

            if (Num[i] > 1 && Num[i] < 10) {
                return Imgnum[0];
            } else if (Num[i] > 11 && Num[i] < 20) {
                return Imgnum[1];
            } else if (Num[i] > 21 && Num[i] < 30) {
                return Imgnum[2];
            } else if (Num[i] > 31 && Num[i] < 40) {
                return Imgnum[3];
            } else if (Num[i] > 41 && Num[i] < 49) {
                return Imgnum[4];
            }

        }

        return null;
    }

}