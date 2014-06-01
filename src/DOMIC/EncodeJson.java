/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DOMIC;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
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

    
    public ArrayList<QuestionBlock> questionBlocks = new ArrayList<>();

    public EncodeJson(String JsonText) {
        
        
        JSONParser jsonParser = new JSONParser();

        try {

            

            JSONObject jsonObject = (JSONObject) jsonParser.parse(JsonText);

            JSONArray test = (JSONArray) jsonObject.get("test");
            
            for (int i = 0; i < test.size(); i++) {
               
                JSONArray questionBlock;
                this.questionBlocks.add(new QuestionBlock());
                questionBlock = (JSONArray) test.get(i);
                
                
                for (int j = 0; j < questionBlock.size(); j++) {
                   
                    HashMap questions = (HashMap) questionBlock.get(j);

                    if (questions.get("-oa") != null) {

                        this.questionBlocks.get(i).questions.add(new Question((String) questions.get("-qu")));
                        JSONArray answerList = null;
                        answerList = (JSONArray) questions.get("-oa");
                        
                        this.questionBlocks.get(i).questions.get(j).addAnswer(true, (String) answerList.get(0));
                       
                        
                        
                      
                    }
                    if (questions.get("-sa") != null) {

                        
                        this.questionBlocks.get(i).questions.add(new Question((String) questions.get("-qu")));
                        JSONArray answerList = null;
                        answerList = (JSONArray) questions.get("-sa");
                        for(int k=0; k<answerList.size(); k++){
                            this.questionBlocks.get(i).questions.get(j).addAnswer(true, (String) answerList.get(k));
                        }
                        
                        
                            
                        }
                        
                    
                    if (questions.get("-ma") != null) {
                        
                        this.questionBlocks.get(i).questions.add(new Question((String) questions.get("-qu")));
                        JSONArray answerList = null;
                        
                        answerList = (JSONArray) questions.get("-ma");
                        JSONArray trueAnswer = (JSONArray) answerList.get(0);
                        JSONArray falseAnswer = (JSONArray) answerList.get(1);
                        
                         for (int k = 0; k < trueAnswer.size(); k++) {
                             this.questionBlocks.get(i).questions.get(j).addAnswer(true, (String) trueAnswer.get(k));
                             
                         }
                          for (int k = 0; k < falseAnswer.size(); k++) {
                               this.questionBlocks.get(i).questions.get(j).addAnswer(false, (String) falseAnswer.get(k));
                              
                          }
                         
                    }

                  
                }

            }

            

            System.out.println("");

        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

}
