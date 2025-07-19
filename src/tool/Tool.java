package tool;

import java.util.Random;

public class Tool {
    public static String randomCode(){
        Random r=new Random();
        StringBuilder sb=new StringBuilder();
        char[] ctr=new char[52];
        for (int i = 0; i < ctr.length/2; i++) {
            ctr[2*i]=(char)(i+65);
            ctr[2*i+1]=(char)(i+97);
        }
        int lengthCode=5;
        for (int i = 0; i < lengthCode-1; i++) {
            int rands=r.nextInt(0,52);
            sb.append(ctr[rands]);
        }
        int rands=r.nextInt(0,lengthCode);
        int randNumber=r.nextInt(0,10);
        sb.insert(rands,randNumber);
        return sb.toString();
    }
}
