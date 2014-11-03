package aimsi.fais.uj.edu.pl;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author Bartosz Bereza
 */
class GamePanel extends JPanel {
    int z = 0;
    private final GameWindow outer;

    GamePanel(int z, final GameWindow outer) {
        this.outer = outer;
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
