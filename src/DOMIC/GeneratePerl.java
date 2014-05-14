/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DOMIC;


import java.util.Formatter;

/**
 *
 * @author Сергей
 */
public class GeneratePerl {
    
    StringBuilder parseToPerl = new StringBuilder();
    
    GeneratePerl(QuestionBlock questionBlock){
        
        StringBuilder parse = new StringBuilder();
       
             this.parseToPerl.append("[");
             
        for (int i=0; i<questionBlock.questions.size(); i++){
            
             
             this.parseToPerl.append("{-qu=> '" + questionBlock.getQuestionName(i) + "'-sa [=>");
            
            for(int j=0; j<questionBlock.questions.get(i).answers.size(); j++){
              
                this.parseToPerl.append("'" + questionBlock.getAnswerText(i, j) + "',");
            }
            this.parseToPerl.deleteCharAt(this.parseToPerl.length()-1);
            
             this.parseToPerl.append("]}");
            
        }
       
       
             this.parseToPerl.append("]");
        
        
    }
     public StringBuilder getPerl(){
         
         return this.parseToPerl;
    
    
}
    
    
    
}
