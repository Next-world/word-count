package com.huangyuanqin.www.core.impl;

import com.huangyuanqin.www.core.Counter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.List;

/**
 * @author hyq
 * @date : 2020/3/10  22:27
 */
public class CounterImpl implements Counter {

    private static Logger logger = LoggerFactory.getLogger(CounterImpl.class);

    public long countChar(String path){
        File file = new File(path);
        if(!file.exists()){
            return -1L;
        }
        return file.length();
    }

    public long countWord(String path) {
        File file = new File(path);
        if(!file.exists()){
            return -1L;
        }
        long count = 0L;
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String[] words;
            while (bufferedReader.read()>0){
                String s = bufferedReader.readLine();
                words = s.split("[\\W]+");
                for (String s1 : words){
                    if(s1.matches("[\\w]+")){
                        count++;
                    }

                }
            }
        } catch (FileNotFoundException e) {
            logger.warn("文件未找到");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {

            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return count;
    }

    public long countLine(String path){
        File file = new File(path);
        if(!file.exists()){
            return -1L;
        }
        long count = 0L;
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {

            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            while (bufferedReader.readLine() != null){
                count++;
            }

        } catch (FileNotFoundException e) {
            logger.warn("文件未找到");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {

                fileReader.close();
                bufferedReader.close();

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        return count;
    }

    public long countChar(List<String> paths) {
        long total = 0L;
        for(String s :paths){
            total += this.countChar(s);
        }
        return total;
    }

    public long countWord(List<String> paths) {
        long total = 0L;
        for(String s :paths){
            total += this.countWord(s);
        }
        return total;
    }

    public long countLine(List<String> paths) {
        long total = 0L;
        for(String s :paths){
            total += this.countLine(s);
        }
        return total;
    }

    public long countEmptyLine(String path) {
        File file = new File(path);
        if(!file.exists()){
            return -1L;
        }
        long count = 0L;
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {

            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            while (bufferedReader.read() > 0){
                String s = bufferedReader.readLine();
                s = s.trim();
                if ("".equals(s)){
                    count++;
                }
            }

        } catch (FileNotFoundException e) {
            logger.warn("文件未找到");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {

                fileReader.close();
                bufferedReader.close();

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        return count;
    }

    public long countAnnotationLine(String path) {
        File file = new File(path);
        if(!file.exists()){
            return -1L;
        }
        //单行注释正则
        String regexAnnotation = "\\s*/{2}.*";
        //多行注释正则
        String regexAnnotationStart = "\\s*/\\x2A.*";
        String regexAnnotationEnd = "\\s*\\x2A/.*";

        long count = 0L;
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {

            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null){
                if(line.matches(regexAnnotationStart)){
                    count++;
                    line = bufferedReader.readLine();
                    while (!line.matches(regexAnnotationEnd)){
                        count++;
                        line = bufferedReader.readLine();
                    }
                    count++;
                }
                if(line.matches(regexAnnotation)){
                    count++;
                }
            }

        } catch (FileNotFoundException e) {
            logger.warn("文件未找到");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {

                fileReader.close();
                bufferedReader.close();

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        return count;
    }

    public long countCodeLine(String path) {
        return countLine(path)-countEmptyLine(path)-countAnnotationLine(path);
    }

    public long countEmptyLine(List<String> paths) {
        long total = 0L;
        for(String s :paths){
            total += this.countEmptyLine(s);
        }
        return total;
    }

    public long countAnnotationLine(List<String> paths) {
        long total = 0L;
        for(String s :paths){
            total += this.countAnnotationLine(s);
        }
        return total;
    }

    public long countCodeLine(List<String> paths) {
        long total = 0L;
        for(String s :paths){
            total += this.countCodeLine(s);
        }
        return total;
    }
}
