import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * Created by andrewliu on 1/24/16.
 */
public class Layout {

    JFrame frame;
    JPanel mainPanel;

    int ROW = 25;
    int COL = 35;

    Block blocks[][];

    String rands[][];

    public void buildGUI() {

        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(ROW, COL, 0, 0));

        blocks = new Block[ROW][COL];
        rands = new String[ROW][COL];
        createRand();
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                blocks[i][j] = new Block(rands[i][j]);
                blocks[i][j].setBorderPainted(false);
               /* System.out.print(rands[i][j]);
                if (j % (COL - 1) == 0 && j != 0) {
                    System.out.print("\r\n");
                }*/
            }
        }
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                mainPanel.add(blocks[i][j]);
            }
        }
        frame.add(mainPanel);
        frame.setVisible(true);
        frame.setBounds(500, 500, 30, 40);
    }

    //TODO add different color to different string or char

    /**
     * Using char or String???
     */

    public void createRand() {
        Random random = new Random();
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                rands[i][j] = String.valueOf(random.nextInt(9) + 1);
            }
        }
        int row_at = random.nextInt(25) + 1;
        int col_at = random.nextInt(35) + 1;
        rands[row_at][col_at] = "@";
    }


}
