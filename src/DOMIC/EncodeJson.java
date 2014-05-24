/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DOMIC;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


/**
 *
 * @author Сергей
 */
public class EncodeJson {
   private static final String jsonFilePath = "C:\\Users\\Сергей\\WebstormProjects\\untitled\\text.json";

 public static void main(String[] args) {

  JSONParser jsonParser = new JSONParser();

  try {

   FileReader fileReader = new FileReader(jsonFilePath);

   JSONObject jsonObject = (JSONObject) jsonParser.parse(fileReader);

   JSONArray test = (JSONArray) jsonObject.get("test");

   
for (int i=0; i<test.size(); i++){
    JSONArray questionBlock;
    questionBlock = (JSONArray) test.get(i);
    for (int j=0; j<questionBlock.size(); j++){
        HashMap questions = (HashMap) questionBlock.get(j);
        Collection question;
        question = questions.values();
        Collection type;
        type = questions.keySet();
        Object values[] = question.toArray();
        Object keys[] = type.toArray();
       
        JSONArray answerList = (JSONArray) values[1];
         System.out.println(values[0]); 
         
        
       
            if(String.valueOf(keys[1]).equals("-oa")){
            
                System.out.println(answerList.get(0));
                
            }
            if(String.valueOf(keys[1]).equals("-sa")){
                
                
                
                for(int n=0; n<answerList.size(); n++){
                    if(n==0)
                        System.out.println(answerList.get(n) + " : true");
                    else
                        System.out.println(answerList.get(n) + " : false");
                }
                     
                
            }
            if(String.valueOf(keys[1]).equals("-ma")){
                
                JSONArray trueAnswer = (JSONArray) answerList.get(0);
                JSONArray falseAnswer = (JSONArray) answerList.get(1);
                for (int n=0; n<trueAnswer.size();n++){
                    
                    System.out.println(trueAnswer.get(n) + " : true");
                }
                for (int n=0; n<falseAnswer.size();n++){
                    
                    System.out.println(falseAnswer.get(n) + " : false");
                }
                
                
            }
       
        
    }
}    
      
      
  
  
 
  
    System.out.println("");
  
  
   


  } catch (FileNotFoundException e) {
   e.printStackTrace();
  } catch (IOException e) {
   e.printStackTrace();
  } catch (ParseException e) {
   e.printStackTrace();
  }

 }

}
    

