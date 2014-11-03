package aimsi.fais.uj.edu.pl;

import java.awt.Color;
import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

/**
 *
 * @author Bartosz Bereza
 */
public class GameWindow extends JFrame {

    private GamePanel Panel1;
    private GamePanel Panel2;
    private GamePanel Panel3;
    private GamePanel Panel4;

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
            
            GameController.attemptClaim(x, y, z);
            GameController.checkProgress();
            
            //---------DEBUG
            System.out.println("Picked: ["+x+"]"+"["+y+"]"+"["+z+"]");
            //---------
            
            
            Panel1.repaint();
            Panel2.repaint();
            Panel3.repaint();
            Panel4.repaint();
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


    public GameWindow() {

        this.setSize(800, 800);
        this.setLayout(new GridLayout(2, 2));
        this.setBackground(new Color(0,0,0));

        Panel1 = new GamePanel(1, this);
        Panel2 = new GamePanel(2, this);
        Panel3 = new GamePanel(3, this);
        Panel4 = new GamePanel(4, this);

        this.add(Panel1);
        this.add(Panel2);
        this.add(Panel3);
        this.add(Panel4);

        this.addMouseListener(new Listener());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

}
