/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aimsi.fais.uj.edu.pl;

import java.awt.Color;

/**
 *
 * @author student
 */
public enum FieldType {

    NONE, O, X;

    public String getText() {
        switch (this) {
            case X:
                return "X";
            case O:
                return "O";
            default:
                return "Unknown Sign Type";
        }
    }

    public FieldType getOpposite() {
        switch (this) {
            case X:
                return O;
            case O:
                return X;
            default:
                return NONE;
        }
    }

    public Color getBackgroundColor() {
        switch (this) {
            case X:
                return Color.WHITE;
            case O:
                return Color.WHITE;
            default:
                return Color.WHITE;
        }
    }

    public Color getTextColor() {
        switch (this) {
            case X:
                return Color.DARK_GRAY;
            case O:
                return Color.DARK_GRAY;
            default:
                return Color.MAGENTA;
        }
    }
}
