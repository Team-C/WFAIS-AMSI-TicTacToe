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
public enum MoveResult {

    INVALID_COORDINATES, INVALID_MOVE, INVALID_SIGN,
    VICTORY_X, VICTORY_O,
    DRAW, SUCCESS;

    public String getText() {
        switch (this) {
            case INVALID_COORDINATES:
                return "Invalid Coordinates";
            case INVALID_MOVE:
                return "Invalid Move";
            case INVALID_SIGN:
                return "Invalid Sign";
            case VICTORY_X:
                return "X is Victorious";
            case VICTORY_O:
                return "O is Victorious";
            case DRAW:
                return "Draw";
            case SUCCESS:
                return "Sign Placed";
            default:
                return " ";
        }
    }

}
