package com.gzhennaxia.ledger.demo.apache.commons.io;

import java.io.*;

/**
 * https://r12a.github.io/app-encodings/
 *
 * @author bo li
 * @date 2020-07-29 14:05
 */
public class EncodingDetectDemo {

    public static void main(String[] args) throws FileNotFoundException {
        String filePath = "/Users/libo/Documents/GitHub/projects/ledger/src/main/java/com/gzhennaxia/ledger/demo/apache/commons/io/alipay_record_20200729_0829_1.csv";
        String filePath2 = "/Users/libo/Documents/GitHub/projects/ledger/src/main/java/com/gzhennaxia/ledger/demo/apache/commons/io/alipay_record_20200729_0829_2.csv";
//        FileInputStream in = new FileInputStream(filePath);

        convertEncoding("GBK", "UTF-8", filePath, filePath2);
    }


    public static void convertEncoding(String srcEncode, String targetEncode, String srcPath, String targetPath) {
        File srcFile = new File(srcPath);
        if (srcFile.isFile()) {
            try {
                File targetFile = new File(targetPath);
                if (!targetFile.exists()) {
                    targetFile.createNewFile();
                }
                BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(srcFile), srcEncode));
                BufferedWriter writer = new BufferedWriter(new FileWriter(targetFile));
                String line;
                while ((line = reader.readLine()) != null) {
//                    writer.write(new String(line.getBytes(), targetEncode));
                    writer.write(line);
                    writer.newLine();
                }
                System.out.println(targetFile.getAbsolutePath());
                reader.close();
                writer.flush();
                writer.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}