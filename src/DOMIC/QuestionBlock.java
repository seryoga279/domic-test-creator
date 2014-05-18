/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DOMIC;

import java.util.ArrayList;

public class QuestionBlock {

    ArrayList<Question> questions = new ArrayList<>();

    public void addQuestion(int indexQuestion, Question question) {
        questions.set(indexQuestion, question);
    }

    public String getAnswerText(int indexQuestions, int indexAnswer) {
        Question question = questions.get(indexQuestions);
        return question.getAnswerText(indexAnswer);

    }

    public boolean getAnswerCorrect(int indexQuestions, int indexAnswer) {
        Question question = questions.get(indexQuestions);
        return question.getAnswerCorrect(indexAnswer);
    }

    public String getQuestionName(int indexQuestions) {
        Question question = questions.get(indexQuestions);
        return question.getQuestionName();

    }

}
