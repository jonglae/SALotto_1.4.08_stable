package gotopark.com.SAlotto;

class Node {

    private static String[] Lotto = new String[6];
    private static String[] Lotto_Pluse = new String[6];
    private static String[] Lotto_Pluse2 = new String[6];

    private static String[] Daily_Lotto = new String[5];

    private static String[] PowerBall = new String[6];
    private static String[] PowerBall_5Ball = new String[5];
    private static String[] powerBall_last = new String[1];

    private static String[] PowerBall_Plus = new String[6];
    private static String[] PowerBall_Plus_5Ball = new String[5];
    private static String[] megaBall_last = new String[1];






    public static String[] getLotto_Pluse() {
        return Lotto_Pluse;
    }

    public static void setLotto_Pluse(String[] lotto_Pluse) {
        Lotto_Pluse = lotto_Pluse;
    }

    public static String[] getLotto_Pluse2() {
        return Lotto_Pluse2;
    }

    public static void setLotto_Pluse2(String[] lotto_Pluse2) {
        Lotto_Pluse2 = lotto_Pluse2;
    }



    public static String[] getPowerBall_Plus() {
        return PowerBall_Plus;
    }

    public static void setPowerBall_Plus(String[] powerBall_Plus) {
        PowerBall_Plus = powerBall_Plus;
    }

    public static String[] getPowerBall_Plus_5Ball() {
        return PowerBall_Plus_5Ball;
    }

    public static void setPowerBall_Plus_5Ball(String[] powerBall_Plus_5Ball) {
        PowerBall_Plus_5Ball = powerBall_Plus_5Ball;
    }

    String[] getPowerBall() {

        PowerBall_5Ball[0] = PowerBall[0];
        PowerBall_5Ball[1] = PowerBall[1];
        PowerBall_5Ball[2] = PowerBall[2];
        PowerBall_5Ball[3] = PowerBall[3];
        PowerBall_5Ball[4] = PowerBall[4];

        return PowerBall_5Ball;
    }

    void setPowerBall(String powerBall) {
        String PBall = powerBall.replace(" ", ",");
        PowerBall = PBall.split(",");
    }

    String[] getMegaBall() {

        Daily_Lotto[0] = Lotto[0];
        Daily_Lotto[1] = Lotto[1];
        Daily_Lotto[2] = Lotto[2];
        Daily_Lotto[3] = Lotto[3];
        Daily_Lotto[4] = Lotto[4];


        return Daily_Lotto;
    }

    void setMegaBall(String megaBall) {
        String MBall = megaBall.replace(" ", ",");
        Lotto = MBall.split(",");
    }


    String[] getPowerBall_Last() {
        powerBall_last[0] = PowerBall[5];
        return powerBall_last;
    }

    String[] getMegaBall_last() {
        megaBall_last[0] = Lotto[5];
        return megaBall_last;
    }
}
