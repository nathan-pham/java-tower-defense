package src.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Button {

    private int x, y, width, height;
    private String text;

    private Rectangle bounds;
    private boolean mouseOver;

    private final int BORDER_RADIUS = 15;

    // constructor
    public Button(String text, int x, int y, int width, int height) {
        this.text = text;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        initBounds();
    }

    private void initBounds() {
        this.bounds = new Rectangle(x, y, width, height);
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public void setMouseOver(boolean mouseOver) {
        this.mouseOver = mouseOver;
    }

    // render button
    public void draw(Graphics ctx) {
        drawBody(ctx);
        drawText(ctx);
    }
    
    private void drawBody(Graphics ctx) {
        // ctx.setColor(C);
        ctx.setColor(mouseOver ? Theme.NAVY : Theme.BLUE);
        ctx.fillRoundRect(x, y, width, height, BORDER_RADIUS, BORDER_RADIUS);
        // ctx.fillRect(x, y, width, height);
    }

    private void drawText(Graphics ctx) {

        int w = ctx.getFontMetrics().stringWidth(text);
        int h = ctx.getFontMetrics().getHeight();
        
        ctx.setColor(Theme.WHITE);
        ctx.drawString(text, x + (width / 2) - (w / 2), y + (height / 2) + (h / 4));
    
    }


}
