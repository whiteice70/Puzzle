package GameJFrame;

import SetTool.Tool;

import javax.swing.*;

public class LoginJFrame extends JFrame {
    public LoginJFrame(){
        LoginUi();
        //画面
        newImage();


        //设置显示
        this.setVisible(true);
    }

    private void newImage() {
        //消除原格式
        setLayout(null);
        //用户名图片
        ImageIcon uIcon=new ImageIcon("image/username.JPG");
        JLabel ujl=new JLabel(uIcon);
        ujl.setBounds(100+25-75,100,75,30);
        this.getContentPane().add(ujl);
        //用户名输入
        JTextField username=new JFormattedTextField();
        username.setBounds(100+25,100,200,30);
        this.getContentPane().add(username);


        //密码图片
        ImageIcon pIcon=new ImageIcon("image/password.jpg");
        JLabel pjl=new JLabel(pIcon);
        pjl.setBounds(100+25-75,100+50,75,30);
        this.getContentPane().add(pjl);
        //密码输入
        JPasswordField password=new JPasswordField();
        password.setBounds(100+25,50+100,200,30);
        this.getContentPane().add(password);

        //验证码图片
        ImageIcon cIcon=new ImageIcon("image/code.jpg");
        JLabel cjl=new JLabel(cIcon);
        cjl.setBounds(100+25-75,100+50+50,75,30);
        this.getContentPane().add(cjl);
        //验证码输入
        JPasswordField code=new JPasswordField();
        code.setBounds(100+25,50+100+50,100,30);
        this.getContentPane().add(code);
        //验证码
        String getCode=Tool.createCode();
        JLabel showCode=new JLabel(getCode);
        showCode.setBounds(100+25+100+35,50+100+50,100,30);
        this.getContentPane().add(showCode);

        //添加按钮
        //添加登录按钮
        JButton login=new JButton();
        login.setBounds(50,250,50,33);
        login.setIcon(new ImageIcon("image/loginb.JPG"));
        login.setBorderPainted(false);
        login.setContentAreaFilled(false);
        this.getContentPane().add(login);
        //添加注册按钮
        JButton reg=new JButton();
        reg.setBounds(275,250,50,33);
        reg.setIcon(new ImageIcon("image/regb.JPG"));
        reg.setBorderPainted(false);
        reg.setContentAreaFilled(false);
        this.getContentPane().add(reg);


        //添加背景图片
        ImageIcon icon0=new ImageIcon("image/login.JPG");
        JLabel jl0=new JLabel(icon0);
        jl0.setBounds(0,0,400,450);
        this.getContentPane().add(jl0);



    }
    public void showJD(String s){
        //创建一个弹窗对象
        JDialog jd=new JDialog();
        //设置大小
        jd.setSize(200,150);
        //
        jd.setAlwaysOnTop(false);
        //
        jd.setLocationRelativeTo(null);
        //
        jd.setModal(true);

        JLabel warning =new JLabel(s);
        warning.setBounds(0,0,200,150);
        jd.getContentPane().add(warning);
        jd.setVisible(true);
    }

    private void LoginUi() {
        //设置页面大小
        this.setSize(400,450);
        //设置保持置顶
        this.setAlwaysOnTop(false);
        //设置居中
        this.setLocationRelativeTo(null);
        //设置标题
        this.setTitle("登录");
        //设置页面的关闭方式
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
