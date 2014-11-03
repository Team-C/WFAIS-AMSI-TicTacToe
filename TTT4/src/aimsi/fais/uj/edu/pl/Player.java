/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aimsi.fais.uj.edu.pl;

/**
 *
 * @author Michał Szura
 */
public class Player {

    private String name;
    private int score;
    private FieldType sign;
    
    public Player(){
        this.name = "";
        this.score = 0;
    }
    
    public Player(FieldType sign){
        this.name = sign.getText();
        this.score = 0;
        this.sign = sign;
    }
    
    public Player(String name, FieldType sign){
        this.name = name;
        this.score = 0;
        this.sign = sign;
    }
    
    public FieldType getSign(){
        return this.sign;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void addScore() {
        this.score++;
    }

    public int getScore() {
        return this.score;
    }

    public void resetScore() {
        this.score = 0;
    }

}
