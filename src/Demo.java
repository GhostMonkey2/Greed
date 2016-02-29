import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

/**
 * Created by Andrew on 2016/2/27.
 */
public class Demo extends Canvas {

    static int ROW = 40;
    static int COL = 30;

    int row_at;
    int col_at;

    String rands[][];


   /* public void paint(Graphics graphics)  {

        rands = new String[ROW][COL];
        createRand();
        int s = 12;//单元格大小


        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                graphics.drawRect(i * s, j * s, s, s);
                graphics.setColor(Color.black);
                graphics.fillRect(i * s, j * s, s, s);

                Color color = Color.WHITE;
                if (rands[i][j].equals("1"))
                    color = Color.blue;
                if (rands[i][j].equals("2")) {
                    color = Color.cyan;
                }
                if (rands[i][j].equals("3")) {
                    color = Color.green;
                }
                if (rands[i][j].equals("4")) {
                    color = Color.orange;
                }
                if (rands[i][j].equals("5")) {
                    color = Color.pink;
                }
                if (rands[i][j].equals("6")) {
                    color = Color.red;
                }
                if (rands[i][j].equals("7")) {
                    color = Color.magenta;
                }
                if (rands[i][j].equals("8")) {
                    color = new Color(255, 160, 0);
                }
                if (rands[i][j].equals("9")) {
                    color = new Color(120,23,50);
                }
                graphics.setColor(color);
                graphics.drawString(rands[i][j], i*s, j*s);

            }
        }
        graphics.dispose();
    }*/

    public static void main(String[] args)  {
        Demo demo = new Demo();
        demo.go();
    }

    public void go() {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        rands = new String[ROW][COL];
        createRand();
        MyDrawPanel myDrawPanel = new MyDrawPanel();
        f.setSize(620, 620);
        f.setLocationRelativeTo(null);
        f.getContentPane().add(myDrawPanel);
      /*  f.add(new Demo());*/
        f.setVisible(true);
        f.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
            }

            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    int move = 0;
                    if (rands[row_at][col_at -1].equals(" ")) {
                        System.out.println("null");
                    } else {
                        move = Integer.parseInt(rands[row_at - 1][col_at]);
                    }
                    if (row_at - move >= 0) {
                        for (int i = 0; i < move; i++) {
                            rands[row_at - i][col_at] = " ";
                        }
                        row_at = row_at - move;
                        rands[row_at][col_at] = "@";
                        myDrawPanel.repaint();
                    }

                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    int move = 0;
                    if (rands[row_at][col_at -1].equals(" ")) {
                        System.out.println("null");
                    } else {
                        move = Integer.parseInt(rands[row_at + 1][col_at]);
                    }
                    if (row_at + move < ROW) {
                        for (int i = 0; i < move; i++) {
                            rands[row_at + i][col_at] = " ";
                        }
                        row_at = row_at + move;
                        rands[row_at][col_at] = "@";
                        myDrawPanel.repaint();
                    }
                }
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    int move = 0;
                    if (rands[row_at][col_at -1].equals(" ")) {
                        System.out.println("null");
                    } else {
                        move = Integer.parseInt(rands[row_at][col_at - 1]);
                    }
                    if (col_at - move >= 0) {
                        for (int i = 0; i < move; i++) {
                            rands[row_at][col_at - i] = " ";
                        }
                        col_at -= move;
                        rands[row_at][col_at] = "@";
                        myDrawPanel.repaint();

                    }
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    int move = 0;
                    if (rands[row_at][col_at -1].equals(" ")) {
                        System.out.println("null");
                    } else {
                        move = Integer.parseInt(rands[row_at][col_at + 1]);
                    }
                    if (col_at + move < COL) {
                        for (int i = 0; i < move; i++) {
                            rands[row_at][col_at + i] = " ";
                        }
                        col_at += move;
                        rands[row_at][col_at] = "@";
                        myDrawPanel.repaint();

                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
            }
        });
    }

    public void checkWin() {

    }

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

    class MyDrawPanel extends JPanel {
        public void paintComponent(Graphics graphics) {

            int s = 12;//单元格大小


            for (int i = 0; i < ROW; i++) {
                for (int j = 0; j < COL; j++) {
                    graphics.drawRect(i * s, j * s, s, s);
                    graphics.setColor(Color.black);
                    graphics.fillRect(i * s, j * s, s, s);

                    Color color = Color.WHITE;
                    if (rands[i][j].equals("1"))
                        color = Color.blue;
                    if (rands[i][j].equals("2")) {
                        color = Color.cyan;
                    }
                    if (rands[i][j].equals("3")) {
                        color = Color.green;
                    }
                    if (rands[i][j].equals("4")) {
                        color = Color.orange;
                    }
                    if (rands[i][j].equals("5")) {
                        color = Color.pink;
                    }
                    if (rands[i][j].equals("6")) {
                        color = Color.red;
                    }
                    if (rands[i][j].equals("7")) {
                        color = Color.magenta;
                    }
                    if (rands[i][j].equals("8")) {
                        color = new Color(255, 160, 0);
                    }
                    if (rands[i][j].equals("9")) {
                        color = new Color(120,23,50);
                    }
                    graphics.setColor(color);
                    graphics.drawString(rands[i][j], i*s, j*s);

                }
            }
        }
    }


}
