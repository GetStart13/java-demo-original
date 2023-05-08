package JFrame窗体;


import javax.swing.*;
import java.awt.*;

public class GameTemplate {
    public void theGame() {
        JFrame jFrame = new JFrame();
        jFrame.setTitle("TheGame");//设置题目
        jFrame.setSize(720, 720);//设置宽高
        jFrame.setResizable(false);//禁用自定义调整大小
        jFrame.setAlwaysOnTop(true);//设置总是显示在第一层窗口
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 设置关闭按钮
        jFrame.setBackground(new Color(96, 159, 200));// 设置背景颜色
        jFrame.setLocationRelativeTo(null);//设置相对位置，空为居中
        jFrame.setLayout(null);//取消默认布局

        JButton button = new JButton("按钮");
        button.setBounds(0, 0, 100, 100);//设置界面
        button.addActionListener(s -> System.out.println("running..."));//绑定事件
        button.addMouseListener(new MouseListenerImpl());//绑定鼠标事件
        button.addKeyListener(new KeyListenerImpl());//绑定键值事件
        jFrame.getContentPane().add(button);//添加元素

        JLabel label = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\img\\1.png"));
        label.setBounds(100, 0, 100, 100);
        jFrame.getContentPane().add(label);

        jFrame.setVisible(true);//设置窗体可见
        jFrame.getContentPane().repaint();//刷新组件

    }
}
