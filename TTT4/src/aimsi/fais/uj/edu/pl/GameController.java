/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aimsi.fais.uj.edu.pl;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Michał Szura
 */
public class GameController {
    
    private static JFrame outcome = new JFrame();
    static protected Map map = new Map();
    static protected Player p1;
    static protected Player p2;
    protected static FieldType turn = FieldType.X;
    private static FieldType hasWon = FieldType.NONE;
    private static boolean isDraw = false;
    
    public static void main(String[] args) {
        p1 = new Player("Player 1", FieldType.X);
        p2 = new Player("Player 2", FieldType.O);
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GameWindow();
            }
        });
    }
    
    public static void attemptClaim(int x, int y, int z) {
        MoveResult res = addSign(x, y, z, turn);
        switch (res) {
            case SUCCESS:
                switchPlayers();
                break;
            case VICTORY_X:
                hasWon = FieldType.X;
                break;
            case VICTORY_O:
                hasWon = FieldType.O;
                break;
            case DRAW:
                isDraw = true;
                break;
            default:
                //throw new UnsupportedOperationException("Not supported yet: " + res.getText());
                System.out.println("Not supported yet: " + res.getText());
        }
    }
    
    public static void checkProgress() {
        if (hasWon != FieldType.NONE) {
            sendWin(hasWon);
            return;
        }
        if (isDraw) {
            sendDraw();
            return;
        }
    }
    
    private static void sendWin(FieldType winner) {
        outcome.setVisible(false);
        outcome.dispose();
        outcome = null;
        if (winner == p1.getSign()) {
            p1.addScore();
        } else if (winner == p2.getSign()) {
            p2.addScore();
        }
        outcome = new JFrame(winner.getText() + " has won!");
        JLabel winMessage = new JLabel("  " + winner.getText() + " has won! "
                + "Score is " + p1.getName() + ": " + p1.getScore() + ", "
                + p2.getName() + ": " + p2.getScore());
        outcome.add(winMessage);
        outcome.setResizable(false);
        outcome.setAlwaysOnTop(true);
        outcome.pack();
        outcome.setVisible(true);
        restartGame();
    }
    
    private static void sendDraw() {
        outcome.setVisible(false);
        outcome.dispose();
        outcome = null;
        outcome = new JFrame("Draw!");
        JLabel drawMessage = new JLabel("Its a Draw! "
                + "Score is " + p1.getName() + ": " + p1.getScore() + ", "
                + p2.getName() + ": " + p2.getScore());
        outcome.add(drawMessage);
        outcome.setResizable(false);
        outcome.setAlwaysOnTop(true);
        outcome.pack();
        outcome.setVisible(true);
        restartGame();
    }
    
    public static MoveResult addSign(int x, int y, int z, FieldType sign) {
        return map.addSign(x, y, z, sign);
    }
    
    public static void restartGame() {
        map.restart();
        if (p1.getSign() == FieldType.X) {
            turn = FieldType.O;
        } else {
            turn = FieldType.X;
        }
        switchPlayersSigns();
    }
    
    public static void switchPlayers() {
        if (turn == FieldType.X) {
            turn = FieldType.O;
        } else {
            turn = FieldType.X;
        }
    }
    
    public static void switchPlayersSigns() {
        if (p1.getSign() == FieldType.X) {
            p1.setSign(FieldType.O);
            p2.setSign(FieldType.X);
        } else {
            p1.setSign(FieldType.X);
            p2.setSign(FieldType.O);
        }
    }
    
}
