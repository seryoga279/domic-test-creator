/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DOMIC;

import java.util.ArrayList;



public class QuestionBlock {
      ArrayList<Question>  questions = new ArrayList<>();
      
      public void addQuestion(int indexQuestion, Question question){
           questions.add(indexQuestion,question);      
}
      public String getAnswerText(int index_questions, int index_answer){
          Question question = questions.get(index_questions);
          return question.getAnswerText(index_answer);
         
}
      public boolean getAnswerCorrect(int index_questions, int index_answer){
          Question question = questions.get(index_questions);
          return question.getAnswerCorrect(index_answer);
      }
      public String getQuestionName(int index_questions){
          Question question = questions.get(index_questions);
          return question.getQuestionName();
          
      }
      
 }
