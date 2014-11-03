/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aimsi.fais.uj.edu.pl;

/**
 *
 * @author Wit
 */
public class Map {

    static FieldType[][][] fields = new FieldType[4][4][4];

    Map() {
        restart();
    }

    public void restart() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    fields[i][j][k] = FieldType.NONE;
                }
            }
        }
    }

    public FieldType getSign(int x, int y, int z) {
        // wyjscie poza mape
        if (x < 0 || x > 3 || y < 0 || y > 3 || z < 0 || z > 3) {
            return FieldType.NONE;
        }

        return fields[x][y][z];
    }

    public MoveResult addSign(int x, int y, int z, FieldType sign) {
        // wyjscie poza mape
        if (x < 0 || x > 3 || y < 0 || y > 3 || z < 0 || z > 3) {
            return MoveResult.INVALID_COORDINATES;
        }

        // proba nadpisania pola
        if (fields[x][y][z] != FieldType.NONE) {
            return MoveResult.INVALID_MOVE;
        }

        // niewlasciwy znak
        if (sign == FieldType.NONE) {
            return MoveResult.INVALID_SIGN;
        }

        // wykonanie ruchu
        fields[x][y][z] = sign;
        
        //VICTORY_X, VICTORY_O, DRAW,
        //TODO Check Victory
        
        if (victoryCheck(x, y, z)) {
            if (FieldType.O == sign) {
                return MoveResult.VICTORY_O;
            } else {
                return MoveResult.VICTORY_X;
            }
        }
        
        if (drawCheck()) {
            return MoveResult.DRAW;
        }

        return MoveResult.SUCCESS;
    }

    private boolean victoryCheck(int x, int y, int z) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private boolean drawCheck() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
