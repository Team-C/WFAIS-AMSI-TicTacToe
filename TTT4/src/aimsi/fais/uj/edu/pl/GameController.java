/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package aimsi.fais.uj.edu.pl;

/**
 *
 * @author student
 */
public class GameController {

    private Map map;
    private Player p1;
    private Player p2;
    
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    public MoveResult addSign(int x, int y, int z, SignType sign) {
        return map.addSign(x, y, z, sign);
    }
    public void restartGame() {
        //TODO
        map.restart();
    }
    public void switchPlayers() {
        //TODO
    }
    
}
