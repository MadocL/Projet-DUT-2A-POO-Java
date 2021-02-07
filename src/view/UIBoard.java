package view;

import model.Board;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class UIBoard extends JPanel {
    private Graphics g;
    private Board board;
    private static Color[] colors = {Color.WHITE, Color.YELLOW, Color.ORANGE, Color.RED, Color.MAGENTA, Color.PINK, Color.GREEN, Color.LIGHT_GRAY, Color.GRAY, Color.DARK_GRAY, Color.BLACK};

    public void setCells(Board board) {
        this.board = board;
    }

    @Override
    public void paint(Graphics g) { //method called automatically when updateUI() is called
        super.paint(g);
        doDrawing(g);
    }

    private void doDrawing(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        Rectangle2D.Double cell;
        g2d.setPaint(null);
        for(int i = 0; i < board.getBoard().length; i++){
            for(int j = 0; j < board.getBoard()[i].length; j++){
                g2d.setColor(valueToColor(board.getBoard()[i][j].getValue())); //set the right color before drawing the cell
                cell = new Rectangle2D.Double(j*50, i*50, 40, 40);
                g2d.fill(cell); //draw the cell

                if (g2d.getColor() != Color.BLACK) g2d.setColor(Color.BLACK); //set the text color
                else g2d.setColor(Color.WHITE);
                g2d.drawString(String.valueOf(board.getBoard()[i][j].getValue()), j*50 + 15, i*50 + 25); //draw the number at the right location
            }
        }
    }

    //just because I don't want to search the mathematical formula who do the same thing
    private Color valueToColor(int value){
        Color color;
        switch (value){
            case 0:
                color = colors[0];
                break;
            case 2:
                color = colors[1];
                break;
            case 4:
                color = colors[2];
                break;
            case 8:
                color = colors[3];
                break;
            case 16:
                color = colors[4];
                break;
            case 32:
                color = colors[5];
                break;
            case 64:
                color = colors[6];
                break;
            case 128:
                color = colors[7];
                break;
            case 256:
                color = colors[8];
                break;
            case 512:
                color = colors[9];
                break;
            case 1024:
                color = colors[10];
                break;
            case 2048:
                color = colors[11];
                break;
            default:
                color = Color.BLACK;
        }
        return color;
    }
}