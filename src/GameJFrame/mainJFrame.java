package GameJFrame;

import javax.swing.*;
import javax.swing.border.BevelBorder;

import SetTool.Tool;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class mainJFrame extends JFrame implements KeyListener {
    int sum;
    String[][] str;
    int x;
    int y;
    int cont;
    public mainJFrame(){
        this.sum=4;
        this.cont=0;
        this.str=Tool.vArray(sum);
        findXY();
        //初始化页面
        Ui();
        //初始化菜单
        Menu();
        //初始化图片
        NewImage();

        //让这个页面显示出来
        this.setVisible(true);
    }
    public void findXY(){
        for (int i = 0; i < sum; i++) {
            for (int i1 = 0; i1 < sum; i1++) {
                if(str[i][i1].equals("0303")){
                    this.x=i;
                    this.y=i1;
                }
            }
        }
    }
    public void Ui(){
        //创建一个新页面
        //JFrame MJF=new JFrame();
        //设置这个页面的宽度，高度
        this.setSize(800,1000);
        //让这个页面居中
        this.setLocationRelativeTo(null);
        //强制让页面浮于顶层
        this.setAlwaysOnTop(false);
        //设置标题
        this.setTitle("Puzzle(单机版)");
        //设置页面的关闭方式
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //添加键盘监听事件
        this.addKeyListener(this);


    }

    public void Menu(){
        //新建bar
        JMenuBar jmb=new JMenuBar();
        //新建menu
        JMenu function=new JMenu("功能");
        JMenu about=new JMenu("关于我们");
        //新建item
        JMenuItem replay=new JMenuItem("重新游戏");
        JMenuItem reLogin=new JMenuItem("重新登录");
        JMenuItem close=new JMenuItem("关闭游戏");

        JMenuItem aboutUs=new JMenuItem("公众号");
        //
        function.add(replay);
        function.add(reLogin);
        function.add(close);
        //
        about.add(aboutUs);
        //
        jmb.add(function);
        jmb.add(about);

        this.setJMenuBar(jmb);

    }
    public void NewImage(){
        this.getContentPane().removeAll();
        setLayout(null);
        for (int i = 0; i < sum; i++) {
            for (int i1 = 0; i1 < sum; i1++) {
                ImageIcon icon=new ImageIcon("image/girl/"+str[i][i1]+".JPG");
                JLabel jl=new JLabel(icon);
                this.add(jl);
                //添加边框
                jl.setBorder(new BevelBorder(BevelBorder.RAISED));
                jl.setBounds(95+150*i1,102+100+150*i,150,150);
            }
        }
        ImageIcon icon0=new ImageIcon("image/bg.JPG");
        JLabel jl0=new JLabel(icon0);
        this.add(jl0);
        jl0.setBounds(75,100,640,722);

        this.getContentPane().repaint();
    }
    //判断是否胜利
    public boolean checkWin(){
        String[][] str0= Tool.createArray(sum);
        for (int i = 0; i < sum; i++) {
            for (int i1 = 0; i1 < sum; i1++) {
                if(!str[i][i1].equals(str0[i][i1])){
                    return false;
                }
            }
        }
        return true;
    }
    //根据输入移动空白方块
    public void move(int input){
        String temp;
        switch(input){
            case 37:
                if(y!=0){
                    temp=this.str[this.x][this.y-1];
                    this.str[this.x][this.y-1]=this.str[x][y];
                    this.str[x][y]=temp;
                    this.y--;
                }
                break;
            case 38:
                if(x!=0){
                    temp=this.str[this.x-1][this.y];
                    this.str[this.x-1][this.y]=this.str[x][y];
                    this.str[x][y]=temp;
                    this.x--;
                }
                break;
            case 39:
                if(y!=sum-1){
                    temp=this.str[this.x][this.y+1];
                    this.str[this.x][this.y+1]=this.str[x][y];
                    this.str[x][y]=temp;
                    this.y++;
                }
                break;
            case 40:
                if(x!=sum-1){
                    temp=this.str[this.x+1][this.y];
                    this.str[this.x+1][this.y]=this.str[x][y];
                    this.str[x][y]=temp;
                    this.x++;
                }
                break;
            case 27:
                System.exit(0);
                break;
            default:
                break;
        }
    }
    //重写了键盘监听类中的方法
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        //对上下左右判断
        int code=e.getKeyCode();
        //System.out.println(code);
        move(code);
        NewImage();
        cont++;
        System.out.println(cont);
        if(checkWin()){
            System.out.println("you win!");
        }
    }
}
