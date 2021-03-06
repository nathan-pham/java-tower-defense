package src.ui;

import java.awt.Rectangle;
import java.awt.Graphics;

public class Button {

    public int x, y, width, height;
    public String text;

    private Rectangle bounds;
    public boolean mouseOver, mousePressed;

    public static final int BORDER_RADIUS = 15;
    public static final int BOX_SHADOW = 6;

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

    public boolean getMouseOver() {
        return mouseOver;
    }


    public void setMousePressed(boolean mousePressed) {
        this.mousePressed = mousePressed;
    }
    
    public boolean getMousePressed() {
        return mousePressed;
    }

    // reset mouse states
    public void resetMouseStates() {
        setMouseOver(false);
        setMousePressed(false);
    }

    // render button
    public void draw(Graphics ctx) {
        drawBorder(ctx);
        drawBody(ctx);

        drawText(ctx);
    }
    
    private void drawBody(Graphics ctx) {
        ctx.setColor(Theme.BLUE.brighter());
        ctx.fillRoundRect(x, y + (mousePressed ? BOX_SHADOW : 0), width, height, BORDER_RADIUS, BORDER_RADIUS);
    }

    private void drawBorder(Graphics ctx) {
        ctx.setColor(Theme.BLUE);
        ctx.fillRoundRect(x, y + BOX_SHADOW, width, height, BORDER_RADIUS, BORDER_RADIUS);
    }

    private void drawText(Graphics ctx) {

        int w = ctx.getFontMetrics().stringWidth(text);
        int h = ctx.getFontMetrics().getHeight();
        
        ctx.setColor(Theme.WHITE);
        ctx.drawString(text, x + (width / 2) - (w / 2), y + (height / 2) + (h / 4) + (mousePressed ? BOX_SHADOW : 0));
    
    }

}
