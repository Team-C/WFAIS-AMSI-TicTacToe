/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package aimsi.fais.uj.edu.pl;

import java.awt.EventQueue;
/**
 *
 * @author student
 */
public class GameController {

    static protected Map map = new Map();
    static protected Player p1;
    static protected Player p2;
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
		@Override
		public void run() {
			new GameWindow();
		}
	});
    }
    
    public MoveResult addSign(int x, int y, int z, FieldType sign) {
        return map.addSign(x, y, z, sign);
    }
    public static void restartGame() {
        //TODO
        map.restart();
    }
    public static void switchPlayers() {
        //TODO
    }
    
}
