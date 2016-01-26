import com.sun.rowset.internal.Row;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

/**
 * Created by andrewliu on 1/24/16.
 */
public class Layout {

    JFrame frame;
    JPanel mainPanel;
    JTextArea jTextArea;

    int ROW = 5;
    int COL = 30;

    int row_at;
    int col_at;

    StringBuffer content;

    Block blocks[][];

    String rands[][];

    public void buildGUI() {

        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPanel = new JPanel();
//        mainPanel.setLayout(new GridLayout(ROW, COL, 0, 0));

        GridLayout gridLayout = new GridLayout(ROW, COL);

        jTextArea = new JTextArea(25, 50);
        jTextArea.setSize(100, 30);
//        jTextArea.setLocation(50, 50);
        jTextArea.setEditable(false);
        jTextArea.setColumns(COL);
        jTextArea.setBackground(Color.black);
        jTextArea.setForeground(Color.white);
        jTextArea.setLayout(gridLayout);
        jTextArea.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
            }

            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
//                jTextArea.setText("");
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    int move = Integer.parseInt(rands[row_at -1][col_at]);
                    if (row_at - move >= 0) {
                        for (int i = 0; i < move; i++) {
                            rands[row_at-i][col_at] = "  ";
                        }
                        row_at = row_at - move;
                        rands[row_at][col_at] = "@";
                        jTextArea.setText(null);
                        jTextArea.setText(createContent());
                    }

                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    int move = Integer.parseInt(rands[row_at + 1][col_at]);
                    if (row_at + move < ROW) {
                        for (int i = 0; i < move; i++) {
                            rands[row_at + i][col_at] = "  ";
                        }
                        row_at = row_at + move;
                        rands[row_at][col_at] = "@";
                        jTextArea.setText("");
                        jTextArea.setText(createContent());
                    }
                }
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    int move = Integer.parseInt(rands[row_at][col_at - 1]);
                    if (col_at - move >= 0) {
                        for (int i = 0; i < move; i++) {
                            rands[row_at][col_at - i] = "  ";
                        }
                        col_at -= move;
                        rands[row_at][col_at] = "@";
                        jTextArea.setText(null);
                        jTextArea.setText(createContent());
                    }
                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    int move = Integer.parseInt(rands[row_at][col_at + 1]);
                    if (col_at + move < COL) {
                        for (int i = 0; i < move; i++) {
                            rands[row_at][col_at + i] = "  ";
                        }
                        col_at += move;
                        rands[row_at][col_at] = "@";
                        jTextArea.setText(null);
                        jTextArea.setText(createContent());
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
            }
        });

        rands = new String[ROW][COL];
        createRand();
        String text = createContent();
       /* for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                mainPanel.add(blocks[i][j]);
            }
        }*/
        jTextArea.setText(text);
        mainPanel.add(jTextArea);
        frame.add(mainPanel);
        frame.setVisible(true);
        frame.setBounds(50, 50, 300, 400);
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
        row_at = random.nextInt(ROW);
        col_at = random.nextInt(COL);
        rands[row_at][col_at] = "@";
    }

    public String createContent() {
        content = new StringBuffer("");
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                content.append(rands[i][j]);
                //System.out.print(rands[i][j]);
                if (j % (COL - 1) == 0 && j != 0) {
                    content.append("\r\n");
                }
            }
        }
        return content.toString();
    }




}
