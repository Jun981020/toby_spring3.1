package ch1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Calculator {
    public Integer calcSum(String filepath) throws IOException {
        LineCallBack lineCallBack =
                new LineCallBack<Integer>() {
                    @Override
                    public Integer doSomethingWithLine(String line, Integer value) {
                        return value + Integer.parseInt(line);
                    }
                };
        return lineReadTemplate(filepath,lineCallBack,0);
    }

    public Integer calcMultiply(String filepath) throws IOException {
        LineCallBack lineCallBack
                = new LineCallBack<Integer>() {
            @Override
            public Integer doSomethingWithLine(String line, Integer value) {
                return value * Integer.parseInt(line);
            }
        };
        return lineReadTemplate(filepath,lineCallBack,1);
    }

    public Integer fileReadeTemplate(String filepath,BufferedReaderCallback bufferedReaderCallback) throws IOException {
        BufferedReader bf = null;
        try {
            bf = new BufferedReader(new FileReader(filepath));
            int ret = bufferedReaderCallback.doSomethingWithReader(bf);
            return ret;
        }catch (IOException e){
            System.out.println("e.getMessage() = " + e.getMessage());
            throw e;
        }finally {
            if(bf != null){
                try {
                    bf.close();
                } catch (IOException e) {
                    System.out.println("e.getMessage() = " + e.getMessage());
                    throw e;
                }
            }
        }
    }
    public <T> T lineReadTemplate(String filepath,LineCallBack<T> lineCallBack,T initVal) throws IOException {
        BufferedReader br = null;
        try{
            br = new BufferedReader(new FileReader(filepath));
            T res = initVal;
            String line = null;
            while((line = br.readLine()) != null){
                res = lineCallBack.doSomethingWithLine(line,res);
            }
            return res;
        } catch (IOException e) {
            throw e;
        }
    }
    public String concatenate(String filepath) throws IOException {
        LineCallBack<String> concatenateCallback=
                new LineCallBack<String>() {
                    @Override
                    public String doSomethingWithLine(String line, String value) {
                        return value + line;
                    }
                };
        return lineReadTemplate(filepath,concatenateCallback,"");
    }


}
