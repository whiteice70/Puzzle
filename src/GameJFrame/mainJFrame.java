package GameJFrame;

import javax.swing.*;
import javax.swing.border.BevelBorder;

import SetTool.Tool;


public class mainJFrame extends JFrame{
    public mainJFrame(){
        //初始化页面
        Ui();
        //初始化菜单
        Menu();
        //初始化图片
        NewImage();

        //让这个页面显示出来
        this.setVisible(true);
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
        int sum=4;
        String[][] str=Tool.createArray(sum);
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
    }
}
