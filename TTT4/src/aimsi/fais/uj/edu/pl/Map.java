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
    static int moves;

    Map() {
        restart();
        
    }

    public void restart() {
        moves=0;
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
        
        if (victoryCheck(x, y, z, sign)) {
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

    private boolean victoryCheck(int x, int y, int z, FieldType sign) {
        //counters
        int c1 = 0, c2 = 0, c3 = 0, c4 = 0;
        
        // linear check
        for(int i=0;i<4;i++){
            if(fields[i][y][z] == sign) c1++;
            if(fields[x][i][z] == sign) c2++;
            if(fields[x][y][i] == sign) c3++;
        }
        
        if( c1==4 || c2==4 || c3==4 )return true;
        else{ c1=0; c2=0; c3=0; }
        
        //slant check - topleft
        for(int i=0; i<4; i++){
            if(fields[i][i][z] == sign) c1++;
            if(fields[i][y][i] == sign) c2++;
            if(fields[x][i][i] == sign) c3++;
            if(fields[i][i][i] == sign) c4++;
        }
        
        if( c1==4 || c2==4 || c3==4 || c4==4 )return true;
        else{ c1=0; c2=0; c3=0; c4=0; }
        
        //slant check - topright
        for(int i=0; i<4; i++){
            if(fields[4-i][i][z] == sign) c1++;
            if(fields[4-i][y][i] == sign) c2++;
            if(fields[4-i][i][i] == sign) c4++;
        }
        
        if( c1==4 || c2==4 || c4==4 )return true;
        else{ c1=0; c2=0; c4=0; }
        
        //slant check - bottomright
        for(int i=0; i<4; i++){
            if(fields[i][4-i][z] == sign) c1++;
            if(fields[x][4-i][i] == sign) c3++;
            if(fields[i][4-i][i] == sign) c4++;
        }
        
        if( c1==4 || c3==4 || c4==4 )return true;
        else{ c1=0; c3=0; c4=0; }
        
        //slant check - bottomleft
        for(int i=0; i<4; i++){
            if(fields[4-i][y][i] == sign) c2++;
            if(fields[x][4-i][i] == sign) c3++;
            if(fields[4-i][4-i][i] == sign) c4++;
        }
        
        if( c2==4 || c3==4 || c4==4 )return true;
        else{ c2=0; c3=0; c4=0; }
        
        
        return false;
    }

    private boolean drawCheck() {
           moves++;
           if(moves == 64) return true;
           
           return false;
    }

}
