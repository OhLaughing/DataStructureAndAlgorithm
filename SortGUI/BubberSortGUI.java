package DataStructureAndAlgorithm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * Created by 10183960 on 2017/2/10.
 */
public class BubbleSortGUI extends JFrame {
    public static int width = 450;
    public static int height = 300;

    public static Color commonColor = new Color(49, 209, 255);

    public BubbleSortGUI() {
        setSize(width, height);
//        int[] array = getRandomArray(15);
        int[] array = {15,14,13,12,11,10,9,8,7,6,5,4,3,2,1} ;
        Bar[] bars = new Bar[array.length];
        for (int i = 0; i < array.length; i++) {
            bars[i] = new Bar(array[i]+50, commonColor);
        }
        add(new SelectSortPanel(bars));

    }

    public static void main(String[] args) {
        BubbleSortGUI frame = new BubbleSortGUI();
        frame.setTitle("select sort");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);
    }

    class SelectSortPanel extends JPanel {

        Timer timer = new Timer(200, new TimerListener());
        Bar[] bars;
        double barWidth;
        double scaleY;

        int min = 100;
        int preMin = 0;
        int pos = 0;
        int pos1 = 0;   //内层遍历
        int control = 0;

        public SelectSortPanel(Bar[] bars) {
            this.bars = bars;
            pos = bars.length - 1;
            min = bars[0].getHeight();
            preMin = 0;
            barWidth = (width - 20) / bars.length;
            scaleY = (height - 20) / 100;
            timer.start();
        }

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            for (int i = 0; i < bars.length; i++) {
                double barHeight = bars[i].getHeight() * scaleY;
                double x = barWidth * i + 10;
                double y = getHeight() - barHeight - 20;
                g.setColor(bars[i].getC());
                g.fillRect((int) x, (int) y, (int) (barWidth - 2), (int) barHeight);
                g.setColor(Color.BLACK);
                g.drawRect((int) x, (int) y, (int) (barWidth - 2), (int) barHeight);

                FontMetrics context = g.getFontMetrics();
                int stringWidth = context.stringWidth(String.valueOf(bars[i].getHeight()));

                g.drawString(String.valueOf(bars[i].getHeight()), (int) (x + barWidth / 2 - stringWidth / 2 - 1), getHeight() - 2);

            }
        }

        class TimerListener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {

                if (pos == 0)
                    return;
                if (pos1 < pos) {
                    //执行pos1与pos1+1的对比
                    switch (control) {
                        //case0是将pos1与pos1+1的颜色改变
                        case 0:
                            bars[pos1].setC(Color.RED);
                            bars[pos1 + 1].setC(Color.RED);
                            control++;
                            repaint();
                            break;
                        //case1是对比pos1与pos1+1，如果pos1大于pos1+1则调换位置
                        case 1:
                            if (bars[pos1].getHeight() > bars[pos1 + 1].getHeight()) {
                                int temp = bars[pos1].getHeight();
                                bars[pos1].setHeight(bars[pos1 + 1].getHeight());
                                bars[pos1+ 1].setHeight(temp);
                                control++;
                            }
                            else {
                                bars[pos1].setC(commonColor);
                                bars[pos1 + 1].setC(commonColor);
                                control = 0;
                                pos1++;
                            }
                            repaint();
                            break;
                        //case2是对比pos1与pos1+1之后，不管是否调换位置，都将颜色恢复正常
                        case 2:
                            bars[pos1].setC(commonColor);
                            bars[pos1 + 1].setC(commonColor);
                            control = 0;
                            pos1++;
                            repaint();
                            break;
                        default:
                            break;
                    }

                }
                else if (pos1 == pos) {
                    pos--;
                    pos1 = 0;
                }
            }
        }
    }

    public static int[] getRandomArray(int a) {
        int[] tmp = new int[a];
        Random random = new Random();
        for (int i = 0; i < a; i++) {
            tmp[i] = random.nextInt(90) + 10;
        }
        return tmp;
    }

    class Bar {
        private int height;
        private Color c;

        public Bar(int height, Color c) {
            this.c = c;
            this.height = height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public void setC(Color c) {
            this.c = c;
        }

        public int getHeight() {
            return height;
        }

        public Color getC() {
            return c;
        }
    }
}
