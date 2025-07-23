package SetTool;

import java.util.Random;

public class Tool {
    public static String createCode(){
        Random r=new Random();
        StringBuilder sb=new StringBuilder();
        char[] ctr=new char[52];
        for (int i = 0; i < 26; i++) {
            ctr[2*i]=(char)(i+65);
            ctr[2*i+1]=(char)(i+97);
        }
        for (int i = 0; i < 4; i++) {
            sb.append(ctr[r.nextInt(52)]);
        }
        sb.insert(r.nextInt(5),r.nextInt(10));
        return sb.toString();
    }
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
                int r1=r.nextInt(sum);
                int r0=r.nextInt(sum);
                String temp=str[i][i1];
                str[i][i1]=str[r1][r0];
                str[r1][r0]=temp;
            }
        }
        return str;
    }
    public static int getRandom(int sum){
        Random r=new Random();
        return r.nextInt(sum);
    }


    public static String[][] vArray(int sum){
        String[][] str=createArray(sum);
        Random r=new Random();
        int x=3;
        int y=3;
        int rr=2;
        int sumV=0;
        for (int i = 0; i < sum * sum*12;) {
            sumV++;
            String temp;
            int r0=r.nextInt(4);
            if(r0==rr){
                continue;
            }
            rr=r0;
            switch(r0){
                case 0:
                    if(y==0){
                        continue;
                    }else{
                        temp=str[x][y];
                        str[x][y]=str[x][y-1];
                        str[x][y-1]=temp;
                        y--;
                    }
                    break;
                case 1:
                    if(x==0){
                        continue;
                    }else{
                        temp=str[x][y];
                        str[x][y]=str[x-1][y];
                        str[x-1][y]=temp;
                        x--;
                    }
                    break;
                case 2:
                    if(y==sum-1){
                        continue;
                    }else{
                        temp=str[x][y];
                        str[x][y]=str[x][y+1];
                        str[x][y+1]=temp;
                        y++;
                    }
                    break;
                case 3:
                    if(x==sum-1){
                        continue;
                    }else{
                        temp=str[x][y];
                        str[x][y]=str[x+1][y];
                        str[x+1][y]=temp;
                        x++;
                    }
                    break;
                default:
                    break;
            }
            i++;
        }
        System.out.println("sumV:"+sumV);
        return str;
    }
}
