/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DOMIC;

import java.util.ArrayList;
import java.util.Formatter;

/**
 *
 * @author Сергей
 */
public class GeneratePerl {

    StringBuilder parseToPerl = new StringBuilder();

    GeneratePerl(ArrayList<QuestionBlock> questionBlock) {
        String valueTrueAnswer = null;
        int numberTrueAnswer = 0;
        this.parseToPerl.append("$test = [\n");
        for (int i = 0; i < questionBlock.size(); i++) {
            this.parseToPerl.append("[\n");
            

            for (int j = 0; j < questionBlock.get(i).questions.size(); j++) {

                
                

                    for (int n = 0; n < questionBlock.get(i).questions.get(j).answers.size(); n++) {
                        if (questionBlock.get(i).getAnswerCorrect(j, n) == true) {
                            numberTrueAnswer++;
                        }
                    }

                    if (numberTrueAnswer <= 1) {
                        this.parseToPerl.append("{\n-qu=> '" + questionBlock.get(i).getQuestionName(j) + "'\n-sa => [");
                                
                for(int k=0; k<questionBlock.get(i).questions.get(j).answers.size(); k++){
                   
                   //запись праавильных ответов для singleAnswer вопросов
                    if(questionBlock.get(i).getAnswerCorrect(j, k) == true){              
                     this.parseToPerl.append("'" + questionBlock.get(i).getAnswerText(j, k) + "',");
                    valueTrueAnswer = questionBlock.get(i).getAnswerText(j, k);
                    }
                   
                    }
                    
                //запись не праавильных ответов для singleAnswer вопросов
                for(int k=0; k<questionBlock.get(i).questions.get(j).answers.size(); k++){
                    if(questionBlock.get(i).getAnswerText(j, k) != valueTrueAnswer)
                    this.parseToPerl.append("'" + questionBlock.get(i).getAnswerText(j, k) + "',");
                    
                } 
                this.parseToPerl.deleteCharAt(this.parseToPerl.length()-1); 
                this.parseToPerl.append("]\n}\n");
                                   
                    }
                    
                    if (numberTrueAnswer > 1) {
                         this.parseToPerl.append("{\n-qu=> '" + questionBlock.get(i).getQuestionName(j) + "'\n-ma => [\n-ta => [");
                       for(int k=0; k<questionBlock.get(i).questions.get(j).answers.size(); k++){
                           if(questionBlock.get(i).getAnswerCorrect(j, k) == true){
                               this.parseToPerl.append("'" + questionBlock.get(i).getAnswerText(j, k) + "',");
                           }  
                           }
                       
                               this.parseToPerl.deleteCharAt(this.parseToPerl.length()-1);
                               this.parseToPerl.append("]\n-aa => [");
                               
                        for(int k=0; k<questionBlock.get(i).questions.get(j).answers.size(); k++){
                            
                                this.parseToPerl.append("'" + questionBlock.get(i).getAnswerText(j, k) + "',");
                            
                            
                        }
                        this.parseToPerl.deleteCharAt(this.parseToPerl.length()-1);
                        this.parseToPerl.append("]\n]\n}\n");
                       
                       
                        
                    }
                    
                    numberTrueAnswer = 0;
                    valueTrueAnswer = null;

                

            }
          
            this.parseToPerl.append("\n]");
        }
        this.parseToPerl.append("\n]");
    }

    public StringBuilder getPerl() {

        return this.parseToPerl;

    }

}
