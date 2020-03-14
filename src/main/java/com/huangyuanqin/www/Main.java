package com.huangyuanqin.www;

import com.huangyuanqin.www.core.impl.CounterImpl;
import com.huangyuanqin.www.util.FileUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import static com.huangyuanqin.www.constant.CommadCode.*;

/**
 * @author hyq
 * @date : 2020/3/10  22:27
 */
public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        help();
        while (true){
            String s = scanner.nextLine();
            if(s.substring(0,2).equals("wc")){
                s = s.substring(3);
                args = s.split(" ");

                List<String> commandList = new LinkedList<String>();
                List<String> pathList = new LinkedList<String>();
                if(commandList.contains("-help")){
                    help();
                }else {
                    for(int i = 0; i<args.length;i++){
                        if(args[i].charAt(0)=='-'){
                            commandList.add(args[i]);
                        }else {
                            pathList.add(args[i]);
                        }
                    }
                    if(commandList.contains(COUNT_FILES)){
                        pathList = new FileUtil().getFiles(pathList.get(0));
                        countAll(commandList,pathList);

                    }else {
                        countOne(commandList,pathList);
                    }
                }

            }

        }

    }
    private static void help(){
        System.out.println("欢迎使用word-count程序");
        System.out.println("输入指令格式为 wc -c filePath，具体参数有：：" +
                "\n -c:计算字符数，-w 计算字数，-l 计算行数，" +
                "\n-s 多文件（使用正则表达式匹配文件），-a 获取空行代码行，注释行信息" +
                "\n-help 帮助信息");


    }
    private static void countOne(List<String> commandList, List<String> pathList){
        CounterImpl counterImpl = new CounterImpl();
        if(commandList.contains(COUNT_CHAR)){
            Long num = counterImpl.countChar(pathList.get(0));
            System.out.println("字符数:"+num);
        }else if(commandList.contains(COUNT_WORD)){
            Long num = counterImpl.countWord(pathList.get(0));
            System.out.println("字数:"+num);
        }else if(commandList.contains(COUNT_LINE)){
            Long num = counterImpl.countLine(pathList.get(0));
            System.out.println("行数:"+num);
        }else if(!commandList.contains(COUNT_COMPLEX)){
            System.out.println("没有合适的命令");
        }

        if(commandList.contains(COUNT_COMPLEX)){

            long empty = counterImpl.countEmptyLine(pathList.get(0));
            long code = counterImpl.countCodeLine(pathList.get(0));
            long annotation = counterImpl.countAnnotationLine(pathList.get(0));

            System.out.println("空白行："+empty);
            System.out.println("代码行："+code);
            System.out.println("注释行："+annotation);
        }
    }
    private static void countAll(List<String> commandList, List<String> pathList){
        CounterImpl counterImpl = new CounterImpl();
        if(commandList.contains(COUNT_CHAR)){
            Long num = counterImpl.countChar(pathList);
            System.out.println("字符数:"+num);
        }else if(commandList.contains(COUNT_WORD)){
            Long num = counterImpl.countWord(pathList);
            System.out.println("字数:"+num);
        }else if(commandList.contains(COUNT_LINE)){
            Long num = counterImpl.countLine(pathList);
            System.out.println("行数:"+num);
        }else {
            System.out.println("没有合适的命令");
        }

        if(commandList.contains(COUNT_COMPLEX)){

            long empty = counterImpl.countEmptyLine(pathList);
            long code = counterImpl.countCodeLine(pathList);
            long annotation = counterImpl.countAnnotationLine(pathList);

            System.out.println("空白行："+empty);
            System.out.println("代码行："+code);
            System.out.println("注释行："+annotation);
        }
    }
}
