package JFrame窗体.game;

import javax.swing.*;

public class TheLabel extends JLabel {
    private final int id;
    private final int iBorder;
    private int xx;
    private int yy;

    public TheLabel(int id, int border) {
        super(new ImageIcon(System.getProperty("user.dir") + "\\img\\" + (id + 1) + ".png"));
        this.id = id;
        this.iBorder = border;
        xx = id % 4 * iBorder;
        yy = id / 4 * iBorder;
        newXY();
    }

    public int getXx() {
        return xx;
    }

    public int getYy() {
        return yy;
    }

    public int getId() {
        return id;
    }

    public void setXx(int xx) {
        this.xx = xx;
    }

    public void setYy(int yy) {
        this.yy = yy;
    }

    public void newXY() {
        this.setBounds(xx, yy, iBorder, iBorder);
    }

}
