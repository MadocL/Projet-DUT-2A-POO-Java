package view;

import model.Board;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Application extends JFrame implements KeyListener {
    private UIBoard UIBoard;
    private char keyTyped;

    public void setKeyTyped(char keyTyped) {
        this.keyTyped = keyTyped;
    }

    public char getKeyTyped() {
        return keyTyped;
    }

    public view.UIBoard getUIBoard() {
        return UIBoard;
    }

    public void setBoard(Board board) {
        UIBoard.setCells(board);
    }

    public Application() {
        init();
    }

    public void init() {
        UIBoard = new UIBoard();
        add(UIBoard);
        setSize(260, 260);
        setTitle("2048 Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        keyTyped = '\0';
        this.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if(e.getKeyChar() == 'z' || e.getKeyChar() == 'q' || e.getKeyChar() == 's' || e.getKeyChar() == 'd'){
            keyTyped = e.getKeyChar();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {}
    @Override
    public void keyReleased(KeyEvent e) {}
}