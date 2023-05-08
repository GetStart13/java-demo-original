package JFrame窗体;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * 键盘监听
 */
public class KeyListenerImpl implements KeyListener {

    /**
     * 按下某些按键时触发
     */
    @Override
    public void keyTyped(KeyEvent e) {
        //System.out.println("键盘键被测试了。。。跟按下类似，但某些按键(包括 ↑ ↓ ← → )不会被触发。");
    }

    /**
     * 按下时触发
     */
    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();//获取按下的键值
        System.out.println(keyCode);
        switch (keyCode) {
            case 37:
                System.out.println("left...");
                break;
            case 38:
                System.out.println("up...");
                break;
            case 39:
                System.out.println("right...");
                break;
            case 40:
                System.out.println("down...");
                break;
        }
    }

    /**
     * 松开时触发
     */
    @Override
    public void keyReleased(KeyEvent e) {
        //System.out.println("键盘键被松开了。。。");
    }
}
