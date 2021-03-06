/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DOMIC;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Сергей
 */
public class GeneratePerl {

    public StringBuilder PerlScript = new StringBuilder();
    public StringBuilder OpenFile = new StringBuilder();
    public String result = "";

    public void GeneratePerl(File OpenFile) throws FileNotFoundException, IOException {

        try {
            
            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(OpenFile), "Windows-1251"));
            try {
                String s;
                while ((s = in.readLine()) != null) {
                    this.OpenFile.append(s);
                }
            } finally {
                in.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        
        

        this.PerlScript.append(
                "use JSON;"
                + this.OpenFile
                + "my %rec_hash = ('test' => $test);"
                + "print encode_json \\%rec_hash;");
        System.out.println(this.PerlScript);
        
       // String temp = new String(this.PerlScript.toString().getBytes("UTF-8"),"UTF-8");
        Process pb = new java.lang.ProcessBuilder("perl", "-e", PerlScript.toString()).start();
        InputStreamReader isr = new InputStreamReader(pb.getInputStream());
        BufferedReader br = new BufferedReader(isr);
        String line = "";
        while ((line = br.readLine()) != null) {
            result += line;
        }
        
        System.out.println(result);

    }

    public StringBuilder getPerlScript() {
        return this.PerlScript;
    }

    public String getJson() {
        return this.result;

    }
}
