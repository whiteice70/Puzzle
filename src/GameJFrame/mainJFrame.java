package GameJFrame;

import javax.swing.*;
import javax.swing.border.BevelBorder;

import SetTool.Tool;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class mainJFrame extends JFrame implements KeyListener, ActionListener {
    JMenuItem replay;
    JMenuItem reLogin;
    JMenuItem close;
    JMenuItem aboutUs;

    int sum;
    String[][] str;
    int x;
    int y;
    int cont;
    boolean o;
    String[] file0={"cat","caLLo","girl","warma","mCat"};
    String file;
    public mainJFrame(){
        o=false;
        this.sum=4;
        this.cont=0;
        file=this.file0[Tool.getRandom(file0.length)];
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
    public void replay(){
        o=false;
        this.cont=0;
        String temp=file;
        do {
            this.file = this.file0[Tool.getRandom(file0.length)];
        } while (temp.equals(this.file));

        this.str=Tool.vArray(sum);
        findXY();
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
        replay=new JMenuItem("重新游戏");
        reLogin=new JMenuItem("重新登录");
        close=new JMenuItem("关闭游戏");

        aboutUs=new JMenuItem("公众号");



        //绑定事件
        replay.addActionListener(this);
        reLogin.addActionListener(this);
        close.addActionListener(this);
        aboutUs.addActionListener(this);
        //
        function.add(replay);
        //function.add(reLogin);
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
        if(checkWin()){
            setLayout(null);
            ImageIcon icon0=new ImageIcon("image/win.png");
            JLabel jl0=new JLabel(icon0);
            this.getContentPane().add(jl0);
            System.out.println("you win!");
            jl0.setBounds(145,100+102+25,500,436);
        }

        JLabel stepCount=new JLabel("步数:"+cont);
        stepCount.setBounds(50,30,100,30);
        this.getContentPane().add(stepCount);

        setLayout(null);
        for (int i = 0; i < sum; i++) {
            for (int i1 = 0; i1 < sum; i1++) {
                ImageIcon icon=new ImageIcon("image/"+file+"/"+str[i][i1]+".JPG");
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
        ImageIcon icon1=new ImageIcon("image/bgl.JPG");
        JLabel jl1=new JLabel(icon1);
        this.add(jl1);
        jl1.setBounds(-600,0,2800,1600);
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
        o=true;
        return true;
    }
    //根据输入移动空白方块
    public void move(int input){
        String temp;
        switch(input){
            case 37:
            case 65:
                if(y!=0){
                    temp=this.str[this.x][this.y-1];
                    this.str[this.x][this.y-1]=this.str[x][y];
                    this.str[x][y]=temp;
                    this.y--;
                    cont++;
                }
                break;
            case 38:
            case 87:
                if(x!=0){
                    temp=this.str[this.x-1][this.y];
                    this.str[this.x-1][this.y]=this.str[x][y];
                    this.str[x][y]=temp;
                    this.x--;
                    cont++;
                }
                break;
            case 39:
            case 68:
                if(y!=sum-1){
                    temp=this.str[this.x][this.y+1];
                    this.str[this.x][this.y+1]=this.str[x][y];
                    this.str[x][y]=temp;
                    this.y++;
                    cont++;
                }
                break;
            case 40:
            case 83:
                if(x!=sum-1){
                    temp=this.str[this.x+1][this.y];
                    this.str[this.x+1][this.y]=this.str[x][y];
                    this.str[x][y]=temp;
                    this.x++;
                    cont++;
                }
                break;
            case 10:
                this.str=Tool.createArray(sum);
                this.x=3;
                this.y=3;
                break;
            default:
                break;
        }
    }
    //查看完整图片
    public void showAllImage(){
        this.getContentPane().removeAll();
        setLayout(null);
        ImageIcon icon0=new ImageIcon("image/"+file+"/all.JPG");
        JLabel jl0=new JLabel(icon0);
        this.getContentPane().add(jl0);
        jl0.setBounds(95,102+100,600,600);
    }
    //重写了键盘监听类中的方法
    @Override
    public void keyTyped(KeyEvent e) {
        if(o){
            return;
        }
        int code=e.getKeyCode();
        System.out.println(code+"按下");
        if(code==32){
            showAllImage();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(o){
            return;
        }
        int code=e.getKeyCode();
        System.out.println(code+"长按");
        if(code==32){
            showAllImage();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code=e.getKeyCode();
        if(code==27){
            System.exit(0);
        }
        if(o){
            return;
        }
        //对上下左右判断

        System.out.println(code+"松开");
        //System.out.println(code);
        move(code);
        NewImage();

        System.out.println(cont);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //获取被点击的条目对象
        Object obj=e.getSource();
        //判断
        if(obj==replay){
            System.out.println("重新游戏！");
            replay();
        }else if(obj==reLogin){
            System.out.println("重新登录！");
        }else if(obj==close){
            System.out.println("关闭游戏");
            System.exit(0);
        }else if(obj==aboutUs){
            System.out.println("关于我们");
            JDialog jd=new JDialog();
            JLabel jl1=new JLabel(new ImageIcon("image/code.png"));
            jl1.setBounds(0,0,148,148);
            jd.getContentPane().add(jl1);
            jd.setSize(250,250);
            //jd.setAlwaysOnTop(true);
            jd.setLocationRelativeTo(null);
            jd.setModal(true);
            jd.setVisible(true);
        }
    }
}
