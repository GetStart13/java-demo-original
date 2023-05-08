package JFrame窗体;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * 鼠标监听
 */
public class MouseListenerImpl implements MouseListener {
    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("鼠标被点击了。。。");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("鼠标按下了。。。");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("鼠标松开了。。。");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("鼠标划入了。。。");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("鼠标划出了。。。");
    }
}
