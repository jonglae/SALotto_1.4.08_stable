package gotopark.com.SAlotto.module;

import org.jsoup.select.Elements;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by buster on 17. 9. 14.
남아프리리카 로또 방법
 1.Lotto : 6 numbers from 1 to 52
 2.Lotto Plus : choose 6 numbers from 1 to 52
 3.Lotto Plus 2 : 6 numbers from 1 to 52
 4.Powerball :  5 numbers from 1 to 45 on and 1 extra number from 1 to 20
 5.Powerball Plus :  choose 5 numbers from 1 to 45 on and 1 extra number from 1 to 20
 */

public class randomNum {

    public int[] lotArray(int input1, int input2) {

        int[] num = new int[input1];
        int xnum;
        int icount, j;
        Random rand = new Random();
//         로또 번호 발생 및  중복 제거

        for (icount = 0; icount < input1; icount++) {
            xnum = rand.nextInt(input2) + 1;
            num[icount] = xnum;
            for (j = 0; j < icount; j++) {
                if (num[icount] == num[j]) {
                    xnum = rand.nextInt(input2) + 1;
                    num[icount] = xnum;
                    icount = icount - 1;
                    break;
                }
            }
        }
//   오름 차순으로  정렬 및 딜레이 시간
        Arrays.sort(num);
        return num;


    }

    public String[] loopfor(Elements input1,int j) {
        String[] pbnum = new String[input1.size()];
        for (int i = 0; i < input1.size(); i++) {
            pbnum[i] = input1.get(i).text().substring(j);
        }
        return pbnum;
    }
}