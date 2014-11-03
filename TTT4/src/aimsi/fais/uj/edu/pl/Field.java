package aimsi.fais.uj.edu.pl;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;

/**
 *
 * @author Bartosz Bereza
 */
class Field extends JComponent {
    int x;
    int y;
    private final GameWindow outer;

    Field(int x, int y, final GameWindow outer) {
        this.outer = outer;
        this.x = x;
        this.y = y;
    }

    public void paint(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(x * 50, y * 50, 50, 50);
    }
    
}
