package src.main;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;

public class GameScreen extends JPanel {

    public GameScreen() {

    }

    public void paintComponent(Graphics ctx) {

        super.paintComponent(ctx);

        ctx.setColor(Color.RED);
        ctx.fillRect(50, 50, 100, 100);

    }

}
