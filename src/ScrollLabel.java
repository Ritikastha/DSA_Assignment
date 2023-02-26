import javax.swing.*;
import java.awt.*;

class ScrollLabel extends JLabel implements Scrollable {
    public ScrollLabel(String i) {
        super(i);
    }

    public Dimension getPreferredScrollableViewportSize() {
        return getPreferredSize();
    }

    public int getScrollableBlockIncrement(Rectangle r, int orietation,
                                           int direction) {
        return 10;
    }

    public boolean getScrollableTracksViewportHeight() {
        return false;
    }

    public boolean getScrollableTracksViewportWidth() {
        return false;
    }

    public int getScrollableUnitIncrement(Rectangle r, int orientation,
                                          int direction) {
        return 10;
    }

}