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

    public EncodeJson(ArrayList<QuestionBlock> questionBlocks, String FilePatch) {
        
        
        JSONParser jsonParser = new JSONParser();

        try {

            FileReader fileReader = new FileReader(FilePatch);

            JSONObject jsonObject = (JSONObject) jsonParser.parse(fileReader);

            JSONArray test = (JSONArray) jsonObject.get("test");

            for (int i = 0; i < test.size(); i++) {
                JSONArray questionBlock;
                this.questionBlocks.add(new QuestionBlock());
                questionBlock = (JSONArray) test.get(i);

                for (int j = 0; j < questionBlock.size(); j++) {
                    HashMap questions = (HashMap) questionBlock.get(j);
                    Collection question;
                    question = questions.values();
                    Collection type;
                    type = questions.keySet();
                    Object values[] = question.toArray();
                    Object keys[] = type.toArray();

                    JSONArray answerList = (JSONArray) values[1];

                    this.questionBlocks.get(i).questions.add(new Question((String) values[0]));

                    if (String.valueOf(keys[1]).equals("-oa")) {

                        this.questionBlocks.get(i).questions.get(j).addAnswer(true, String.valueOf(answerList.get(0)));

                    }
                    if (String.valueOf(keys[1]).equals("-sa")) {

                        for (int n = 0; n < answerList.size(); n++) {
                            if (n == 0) {
                                this.questionBlocks.get(i).questions.get(j).addAnswer(true, String.valueOf(answerList.get(n)));
                            } else {
                                this.questionBlocks.get(i).questions.get(j).addAnswer(true, String.valueOf(answerList.get(n)));
                            }
                        }

                    }
                    if (String.valueOf(keys[1]).equals("-ma")) {

                        JSONArray trueAnswer = (JSONArray) answerList.get(0);
                        JSONArray falseAnswer = (JSONArray) answerList.get(1);
                        for (int n = 0; n < trueAnswer.size(); n++) {

                            this.questionBlocks.get(i).questions.get(j).addAnswer(true, String.valueOf(trueAnswer.get(n)));
                        }
                        for (int n = 0; n < falseAnswer.size(); n++) {

                            this.questionBlocks.get(i).questions.get(j).addAnswer(false, String.valueOf(falseAnswer.get(n)));
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
