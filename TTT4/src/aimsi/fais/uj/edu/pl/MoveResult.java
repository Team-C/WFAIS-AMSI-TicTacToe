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
    
    INVALID_COORDINATES {
                @Override
                public String toString() {
                    return "???";

                }
            },
    INVALID_MOVE {
                @Override
                public String toString() {
                    return "???";

                }
            },
    INVALID_PLAYER {
                @Override
                public String toString() {
                    return "???";

                }
            },
    INVALID_SIGN {
                @Override
                public String toString() {
                    return "???";

                }
            },
    VICTORY_X {
                @Override
                public String toString() {
                    return "???";

                }
            },
    VICTORY_O {
                @Override
                public String toString() {
                    return "???";

                }
            },
    DRAW {
                @Override
                public String toString() {
                    return "???";

                }
            },
    SUCCESS {
                @Override
                public String toString() {
                    return "???";

                }
            };
    
}
