import javax.swing.*;
import java.awt.*;

public class NumberBox extends ClickableArea {

    private static final Color NORMAL_COLOR = Color.BLACK;
    private static final Color START_COLOR = Color.GREEN;
    private static final Color END_COLOR = Color.RED;

    private boolean highlighted, isEnd;

    private int val;


    public NumberBox(int val) {
        super();

        this.val = val;

        highlighted = isEnd = false;

        setDefaultBorder(null);
    }
    /************************** Overridden Methods **************************/

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (highlighted) {
            g.setColor(isEnd ? END_COLOR : START_COLOR);
            g.setFont(g.getFont().deriveFont(Font.BOLD));
        } else {
            g.setColor(NORMAL_COLOR);
            g.setFont(g.getFont().deriveFont(Font.PLAIN));
        }

        g.drawString(String.valueOf(val), getWidth() / 3, getHeight() / 2);
    }

    @Override
    public void onClick() {
        if (JOptionPane.showConfirmDialog(getParent(), "Would you like to fire a beam from box " + val + "?", "Fire?",
                JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION) {

            getBaffleGrid().fireBeam(val);
        }
    }

    /****************************** Accessors *******************************/

    public int getVal() { return val; }

    /****************************** Mutators ********************************/

    public void clearHighlight() { highlighted = false; }

    public void setHighlighted(boolean val, boolean isEnd) {
        highlighted = val;
        this.isEnd = isEnd;
    }

    /**************************** Other Methods *****************************/
}
