package com.huangyuanqin.www.core;


import java.util.List;

public interface Counter {

    /**
     * 计算文件的字符数
     * @param path 文件路径
     * @return 字符数
     */
    long countChar(String path);

    /**
     * 计算文件的字数
     * @param path 文件路径
     * @return 字数
     */
    long countWord(String path);

    /**
     * 计算文件行数
     * @param path 文件路径
     * @return 行数
     */
    long countLine(String path);

    /**
     * 计算多文件的字符数
     * @param paths 多文件的路径
     * @return 字符数
     */
    long countChar(List<String> paths);

    /**
     * 计算多文件的字数
     * @param paths 多文件的路径
     * @return 字符数
     */
    long countWord(List<String> paths);

    /**
     * 计算多文件的行数
     * @param paths 多文件的路径
     * @return 行数
     */
    long countLine(List<String> paths);

    /**
     *计算空行
     * @param path 路径
     * @return 空行数量
     */
    long countEmptyLine(String path);

    /**
     * 计算注释行
     * @param path 路径
     * @return 注释行数量
     */
    long countAnnotationLine(String path);

    /**
     * 计算代码行
     * @param path 路径
     * @return 行数
     */
    long countCodeLine(String path);

    /**
     *计算空行
     * @param paths 路径
     * @return 空行数量
     */
    long countEmptyLine(List<String> paths);

    /**
     * 计算注释行
     * @param paths 路径
     * @return 注释行数量
     */
    long countAnnotationLine(List<String> paths);

    /**
     * 计算代码行
     * @param paths 路径
     * @return 行数
     */
    long countCodeLine(List<String> paths);


}
