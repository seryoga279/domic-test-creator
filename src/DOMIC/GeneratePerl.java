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
    
    GeneratePerl(ArrayList<QuestionBlock> questionBlock){
       
             this.parseToPerl.append("$test = [");
             for(int i=0; i<questionBlock.size(); i++){ 
                 this.parseToPerl.append("[");
             
        for (int j=0; j<questionBlock.get(i).questions.size(); j++){
            
             
             this.parseToPerl.append("{-qu=> '" + questionBlock.get(i).getQuestionName(j) + "'-sa [=>");
            
            for(int k=0; k<questionBlock.get(i).questions.get(j).answers.size(); k++){
              
                this.parseToPerl.append("'" + questionBlock.get(i).getAnswerText(j, k) + "',");
            }
            this.parseToPerl.deleteCharAt(this.parseToPerl.length()-1);
            
             this.parseToPerl.append("]}");
            
        }
       
       
             this.parseToPerl.append("]]");
        
        
    }
    }
     public StringBuilder getPerl(){
         
         return this.parseToPerl;
    
    
}
    
    
    
}
