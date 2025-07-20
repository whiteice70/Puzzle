package SetTool;

import java.util.Random;

public class Tool {
    public static String[][] createArray(int sum){
        String[][] str=new String[sum][sum];
        for (int i = 0; i < sum; i++) {
            for (int i1 = 0; i1 < sum; i1++) {
                str[i][i1]="0"+i+"0"+i1;
            }
        }
        return str;
    }
    public static String[][] randomArray(int sum){
        String[][] str=createArray(sum);
        Random r=new Random();
        for (int i = 0; i < sum; i++) {
            for (int i1 = 0; i1 < sum; i1++) {
                int r1=r.nextInt(0,sum);
                int r0=r.nextInt(0,sum);
                String temp=str[i][i1];
                str[i][i1]=str[r1][r0];
                str[r1][r0]=temp;
            }
        }
        return str;
    }
}
