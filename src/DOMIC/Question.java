/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DOMIC;

import java.util.ArrayList;

public class Question {
    
   ArrayList<Answer> answers = new ArrayList<>();
   String text;
   
    
    public void addAnswer(boolean correct, String text){
        Answer answer = new Answer(text, correct);
        answers.add(answer);
    }
    public String getAnswerText(int indexQuestion){
        Answer text = answers.get(indexQuestion);
        return text.getAnswerText();
    
    }
     public boolean getAnswerCorrect(int indexQuestion){
        Answer text = answers.get(indexQuestion);
        return text.getAnswerCorrect();
    
    }
     public String getQuestionName(){
         return this.text;
     }
     
    
    
    public Question(String text){
        this.text = text;
        
    }
    
    
}



