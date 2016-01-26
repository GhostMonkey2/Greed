import javax.swing.*;
import java.awt.*;

/**
 * Created by andrewliu on 1/25/16.
 */
public class Block extends JButton {
    public Block(String label) {
        setLabel(label);
        setForeground(getColor(label));
        setBackground(Color.black);
    }

    public Color getColor(String label) {
        Color color = Color.white;
        if (label != "@") {
        int num = Integer.parseInt(label);
        if (num == 1)
            color = Color.blue;
        if (num == 2) {
            color = Color.cyan;
        }
        if (num == 3) {
            color = Color.green;
        }
        if (num == 4) {
            color = Color.orange;
        }
        if (num == 5) {
            color = Color.pink;
        }
        if (num == 6) {
            color = Color.red;
        }
        if (num == 7) {
            color = Color.magenta;
        }
        if (num == 8) {
            color = Color.yellow;
        }
        if (num == 9) {
            color = new Color(120,23,50);
        }
        } else
        color = Color.white;
        return color;
    }
}
