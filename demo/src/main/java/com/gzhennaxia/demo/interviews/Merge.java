package com.gzhennaxia.demo.interviews;

import org.springframework.util.StringUtils;

import java.io.*;
import java.util.Arrays;

/**
 * @author bo li
 * @date 2020-12-10 11:19
 */
public class Merge {

    public static void main(String[] args) throws IOException {
        File interviewPath = new File("/Users/libo/Documents/GitHub/Gzhennaxia.github.io/source/ignore_render/interview");
        String result = "/Users/libo/Documents/GitHub/projects/demo/src/main/java/com/gzhennaxia/demo/interviews/Interview.md";
        File[] files1 = interviewPath.listFiles();
        Arrays.sort(files1, (o1, o2) -> {
            String name = o1.getName();
            String name1 = o2.getName();
            Integer num = -1;
            Integer num1 = -1;
            if (name.contains("-")) {
                num = Integer.valueOf(name.substring(name.indexOf("-") + 1, name.lastIndexOf("-")));
            }
            if (name1.contains("-")) {
                num1 = Integer.valueOf(name1.substring(name1.indexOf("-") + 1, name1.lastIndexOf("-")));
            }
            return num - num1;
        });
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(result))));
        for (int i = 1; i < files1.length; i++) {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(files1[i])));
            String p = null;
            String s;
            while ((s = br.readLine()) != null) {
                p = s;
                bw.append(s);
                bw.newLine();
            }
            if (!StringUtils.isEmpty(p)) {
                bw.newLine();
            }
            br.close();
        }
        bw.close();
    }
}
