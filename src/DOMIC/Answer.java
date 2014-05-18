/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DOMIC;

/**
 *
 * @author Сергей
 */
public class Answer {

    String text;
    boolean correct;

    public Answer(String text, boolean correct) {
        this.text = text;
        this.correct = correct;

    }

    public String getAnswerText() {
        return this.text;
    }

    public boolean getAnswerCorrect() {
        return this.correct;
    }

}
