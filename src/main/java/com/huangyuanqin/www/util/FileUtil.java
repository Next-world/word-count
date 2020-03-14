package com.huangyuanqin.www.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

/**
 * @author hyq
 * @date : 2020/3/14  15:39
 */
public class FileUtil {
    private List<String> pathList;

    private static Logger logger = LoggerFactory.getLogger(FileUtil.class);

    public List<String> getFiles(String path){
        String file = path.substring(0,path.lastIndexOf('\\'));
        String re = path.substring(path.lastIndexOf('\\')+1);

        logger.debug("file:"+file);
        logger.debug("re:"+re);

        File file1 = new File(file);
        if(!file1.exists()){
            logger.warn("文件路径不存在");
            return null;
        }else {
            pathList = new LinkedList<String>();
            getFiles0(file1,re);
        }
        return this.pathList;
    }
    private void getFiles0(File file, String re){
        if (file.isDirectory()){
            File[] files = file.listFiles();
            for (File f : files){
                getFiles0(f,re);
            }
        }else {
            String fileName = file.getName();
            if(fileName.matches(re)){
                fileName = file.getPath();
                logger.debug(fileName);
                pathList.add(fileName);
            }
        }
    }
}
