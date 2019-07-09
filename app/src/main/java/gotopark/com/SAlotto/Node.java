package gotopark.com.SAlotto;

class Node {


    private static String[] Win_Result = new String[6];

    static String[] getWin_Result() {
        return Win_Result;
    }

    static void setWin_Result(String[] win_Result) {


        Win_Result = win_Result;
    }


    static String[] getPowerBall_5Ball() {
        String[] ball5 = new String[5];
        String inLotto = getWin_Result()[4];
        inLotto = inLotto.replace(" ", ",");
        ball5 = inLotto.split(",");
        return ball5;
    }


    static String[] getPowerBall_last() {
        String[] lastball = new String[1];
        String inLotto = getWin_Result()[4];
        inLotto = inLotto.replace(" ", ",");
        String[] aaaa = inLotto.split(",");
        lastball[0] = aaaa[5];
        return lastball;
    }


    public static String[] getLotto() {
        String inLotto = getWin_Result()[0];
        inLotto = inLotto.replace(" ", ",");
        return inLotto.split(",");
    }


    static String[] getDaily_Lotto() {
        if(getWin_Result()[0] == null){

        } else {

            String inLotto = getWin_Result()[3];
            inLotto = inLotto.replace(" ", ",");
            return inLotto.split(",");
        }

        return null;
    }


    static String[] getLotto_Pluse() {
        String inLotto = getWin_Result()[1];
        inLotto = inLotto.replace(" ", ",");
        return inLotto.split(",");
    }


    static String[] getLotto_Pluse2() {
        String inLotto = getWin_Result()[2];
        inLotto = inLotto.replace(" ", ",");
        return inLotto.split(",");
    }

    static String[] getPowerBall_Plus_5Ball() {
        String[] ball5 = new String[5];
        String inLotto = getWin_Result()[5];
        inLotto = inLotto.replace(" ", ",");
        ball5 = inLotto.split(",");
        return ball5;
    }

    static String[] getPowerBall_Plus_last() {
        String[] lastball = new String[1];
        String inLotto = getWin_Result()[5];
        inLotto = inLotto.replace(" ", ",");
        String[] aaaa = inLotto.split(",");
        lastball[0] = aaaa[5];
        return lastball;
    }

}
