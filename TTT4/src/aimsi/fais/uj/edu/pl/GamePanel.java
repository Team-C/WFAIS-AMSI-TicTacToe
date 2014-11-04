package aimsi.fais.uj.edu.pl;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import java.io.File;
import java.io.IOException;

import javax.swing.JPanel;
import javax.imageio.ImageIO;

/**
 *
 * @author Bartosz Bereza
 */
class GamePanel extends JPanel {

    int z = 0;
    private final GameWindow outer;
    private BufferedImage O;
    private BufferedImage X;

    GamePanel(int z, final GameWindow outer) {
        this.outer = outer;
        this.setSize(new Dimension(400, 400));
        this.setBackground(new Color(0, 0, z * 50));
        this.z = z - 1;

        try {
            O = ImageIO.read(new File("O.jpg"));
            X = ImageIO.read(new File("X.jpg"));
        } catch (IOException ex) {
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                switch (GameController.map.getSign(i, j, z)) {
                    case NONE:
                        g.setColor(new Color(200, 200, 200));
                        g.fillRect(i * 95, j * 90, 90, 85);
                        break;
                    case O:
                        g.drawImage(O, i * 95, j * 90, null);
                        break;
                    case X:
                        g.drawImage(X, i * 95, j * 90, null);
                        break;
                    default:
                        g.setColor(new Color(0, 0, 0));
                }
                //g.fillRect(i * 95, j * 90, 90, 85);
            }
        }
    }
}
