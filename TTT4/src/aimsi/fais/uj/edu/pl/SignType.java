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
public enum SignType {

    NONE {
                @Override
                public String toString() {
                    return "Empty Sign";

                }
            },
    O {
                @Override
                public String toString() {
                    return "Sign: O";

                }
            },
    X {
                @Override
                public String toString() {
                    return "Sign: X";

                }
            };
}
