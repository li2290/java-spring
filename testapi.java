package com.eagle.controller;

import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;

public class testapi {
    public static void appendMethodA(String fileName, String content) {
        try {
            // 打开一个随机访问文件流，按读写方式
            RandomAccessFile randomFile = new RandomAccessFile(fileName, "rw");
            // 文件长度，字节数
            long fileLength = randomFile.length();
            //将写文件指针移到文件尾。在该位置发生下一个读取或写入操作。
            randomFile.seek(fileLength);
            //按字节序列将该字符串写入该文件。
            randomFile.writeBytes(content);
            //关闭此随机访问文件流并释放与该流关联的所有系统资源。
            randomFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * B方法追加文件：使用FileWriter
     */
    public static void appendMethodB(String fileName, String content) {
        try {
            //打开一个写文件器，构造函数中的第二个参数true表示以追加形式写文件,如果为 true，则将字节写入文件末尾处，而不是写入文件开始处
            FileWriter writer = new FileWriter(fileName, true);
            writer.write(content);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
