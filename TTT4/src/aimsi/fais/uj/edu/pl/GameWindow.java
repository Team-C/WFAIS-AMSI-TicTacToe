package aimsi.fais.uj.edu.pl;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class GameWindow extends JFrame {

    GamePanel Panel1;
    GamePanel Panel2;
    GamePanel Panel3;
    GamePanel Panel4;

    class GamePanel extends JPanel {

        int z = 0;

        GamePanel(int z) {
            this.setSize(new Dimension(400, 400));
            this.setBackground(new Color(0, 0, z * 50));
            this.z = z - 1;
        }

        @Override
        public void paintComponent(Graphics g) {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    switch (GameController.map.getSign(i, j, z)) {
                        case NONE:
                            g.setColor(new Color(0, 255, 255));
                            break;
                        case O:
                            g.setColor(new Color(0, 0, 255));
                            break;
                        case X:
                            g.setColor(new Color(0, 255, 0));
                            break;
                        default:
                            g.setColor(new Color(0, 0, 0));
                    }
                    g.fillRect(i * 100, j * 100, 100, 100);
                }
            }
        }
    }

    class Listener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            int x = e.getX();
            int y = e.getY();
            int z;
            System.out.println(x + " " + y);
            if (x < 400) { //lewy panel
                if (y < 400) { //lewy górny panel
                    x = x / 100;
                    y = y / 100;
                    z = 0;
                } else { //lewy dolny panel
                    x = x / 100;
                    y = (y-400) / 100;
                    z = 2;
                }
            } else { //prawy panel
                if (y < 400) { //prawy górny panel
                    x = (x-400) / 100;
                    y = y / 100;
                    z = 1;
                } else { //prawy dolny panel
                    x = (x-400) / 100;
                    y = (y-400) / 100;
                    z = 3;
                }
            }
            
            //if (CurrentPlayer == P1){
            //    GameController.map.addSign(x, y, z, FieldType.O);
            //} else {
            //    GameController.map.addSign(x, y, z, FieldType.X);
            //} TO WSTAWIC JAK SIE POJAWI SPRAWDZANIE CZYJA JEST TURA
            
            GameController.map.addSign(x, y, z, FieldType.O);
            System.out.println(x + " " + y + " " + z);
            //A TO WYPIEPRZYC
            
            
            Panel1.repaint();
            Panel2.repaint();
            Panel3.repaint();
            Panel4.repaint();
            
            GameController.switchPlayers();
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    }

    class Field extends JComponent {

        int x, y;

        Field(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void paint(Graphics g) {
            g.setColor(Color.red);
            g.fillRect(x * 50, y * 50, 50, 50);
        }
    }

    public GameWindow() {

        this.setSize(800, 800);
        this.setLayout(new GridLayout(2, 2));
        this.setBackground(new Color(0,0,0));

        Panel1 = new GamePanel(1);
        Panel2 = new GamePanel(2);
        Panel3 = new GamePanel(3);
        Panel4 = new GamePanel(4);

        this.add(Panel1);
        this.add(Panel2);
        this.add(Panel3);
        this.add(Panel4);

        this.addMouseListener(new Listener());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

}
