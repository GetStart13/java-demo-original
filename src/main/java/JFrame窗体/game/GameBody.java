package JFrame窗体.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 1、设置图片布局
 * 2、绑定键盘键事件
 * 3、接收键盘输入键值
 * 4、根据键值改变图片布局
 * 5、改变布局后刷新组件 repaint
 * 6、写逻辑打乱图片
 * 7、写逻辑判断图片布局是否游戏成功
 */
public class GameBody extends JFrame implements KeyListener {

    private static final int BORDER = 255;
    private final List<TheLabel> labels = new ArrayList<>();
    private final Random random = new Random();

    public GameBody() {
        mainFrame();
    }

    public void mainFrame() {

        this.setTitle("TheGame： ← ↑ → ↓ 移动空白方格，回车键刷新游戏！"); // 设置标题
        this.setSize(1020, 1030); // 设置宽高
        this.setResizable(false);//禁用自定义调整大小
        this.setAlwaysOnTop(true);//设置总是显示在第一层窗口
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // 设置关闭按钮
        this.setBackground(new Color(96, 159, 200)); // 设置背景颜色
        this.setLocationRelativeTo(null); // 设置相对位置，空为居中
        this.setLayout(null); // 取消默认布局
        this.addKeyListener(this); // 键盘监听
        // 存取拼图对象
        for (int i = 0; i < 16; i++) {
            TheLabel theLabel = new TheLabel(i, BORDER);
            this.getContentPane().add(theLabel);
            labels.add(theLabel);
        }

        // 打乱拼图
        refresh();

        this.setVisible(true); // 设置窗体可见
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO document why this method is empty
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case 37:
                left();
                //System.out.println("left...");
                break;
            case 38:
                upward();
                //System.out.println("upward...");
                break;
            case 39:
                right();
                //System.out.println("right...");
                break;
            case 40:
                down();
                //System.out.println("down...");
                break;
            case 10:
                this.getContentPane().removeAll();//回车键刷新游戏
                this.repaint();//组件重画
                for (TheLabel label : labels) {//遍历集合，将标签重新添加组件到窗体中
                    label.newXY();
                    this.getContentPane().add(label);
                }
                refresh();//打乱
                //System.out.println("enter...");
                break;
        }

        // 拼图是否还原
        boolean flag = false;
        for (TheLabel label : labels) {
            if (label.getXx() == label.getId() % 4 * BORDER && label.getYy() == label.getId() / 4 * BORDER) {
                flag = true;
            } else {
                flag = false;
                break;
            }
        }
        // 拼图被还原，游戏成功
        if (flag) {
            //labels.get(0).setIcon(new ImageIcon(System.getProperty("user.dir") + "\\img\\01.png"));//显示空白拼图格子
            //this.removeKeyListener(this);//移除键的监听事件
            this.getContentPane().removeAll();//移除所有组件，移除组件并不能移除监听事件
            this.getContentPane().repaint();//重新绘制窗体

            JLabel label = new JLabel();//设置要显示的成功图片
            label.setBounds(0, 0, 1020, 1020);
            label.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\img\\success.png"));
            this.getContentPane().add(label);
        } /*else {
            labels.get(0).setIcon(new ImageIcon(System.getProperty("user.dir") + "\\img\\1.png"));

        }*/
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public void left() {
        if (labels.get(0).getXx() > 0) {
            int temp = labels.get(0).getXx();
            for (TheLabel label : labels) {
                if (label.getXx() == labels.get(0).getXx() - BORDER && label.getYy() == labels.get(0).getYy()) {
                    labels.get(0).setXx(label.getXx());
                    label.setXx(temp);
                    label.newXY();
                    break;
                }
            }
        }
    }

    public void upward() {
        if (labels.get(0).getYy() > 0) {
            int temp = labels.get(0).getYy();
            for (TheLabel label : labels) {
                if (label.getYy() == labels.get(0).getYy() - BORDER && label.getXx() == labels.get(0).getXx()) {
                    labels.get(0).setYy(label.getYy());
                    label.setYy(temp);
                    label.newXY();
                    break;
                }
            }
        }
    }

    public void right() {
        if (labels.get(0).getXx() < BORDER * 3) {
            int temp = labels.get(0).getXx();
            for (TheLabel label : labels) {
                if (label.getXx() == labels.get(0).getXx() + BORDER && label.getYy() == labels.get(0).getYy()) {
                    labels.get(0).setXx(label.getXx());
                    label.setXx(temp);
                    label.newXY();
                    break;
                }
            }
        }
    }

    public void down() {
        if (labels.get(0).getYy() < BORDER * 3) {
            int temp = labels.get(0).getYy();
            for (TheLabel label : labels) {
                if (label.getYy() == labels.get(0).getYy() + BORDER && label.getXx() == labels.get(0).getXx()) {
                    labels.get(0).setYy(label.getYy());
                    label.setYy(temp);
                    label.newXY();
                    break;
                }
            }
        }
    }

    // 打乱拼图
    public void refresh() {
        int changeTimes = 100;
        while (changeTimes > 0) {
            int i = random.nextInt(4);
            switch (i) {
                case 0:
                    left();
                    break;
                case 1:
                    upward();
                    break;
                case 2:
                    right();
                    break;
                case 3:
                    down();
                    break;
            }
            --changeTimes;
        }
        // 空白拼图格子回到左上角
        while (labels.get(0).getXx() != 0 || labels.get(0).getYy() != 0) {
            upward();
            left();
        }
    }
}
