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

    SignType[] fields = new SignType[64];

    Map() {
        Restart();
    }

    public void Restart() {
        for (int i = 0; i < 64; ++i) {
            fields[i] = SignType.NONE;
        }
    }

    public MoveResult AddSign(int x, int y, int z, SignType sign) {
        // wyjscie poza mape
        if (x < 0 || x > 3 || y < 0 || y > 3 || z < 0 || z > 3) {
            return MoveResult.INVALID_COORDINATES;
        }

        // proba nadpisania pola
        if (fields[x + y * 4 + z * 16] != SignType.NONE) {
            return MoveResult.INVALID_MOVE;
        }

        // niewlasciwy znak
        if (sign == SignType.NONE) {
            return MoveResult.INVALID_SIGN;
        }

        // wykonanie ruchu
        fields[x + y * 4 + z * 16] = sign;

        return MoveResult.SUCCESS;
    }

}
