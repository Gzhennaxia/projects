package com.gzhennaxia.demo.interviews;

import java.io.*;

/**
 * @author bo li
 * @date 2020-12-10 11:19
 */
public class Split {

    public static void main(String[] args) throws IOException {
        String direction = "/Users/libo/Documents/GitHub/projects/demo/src/main/java/com/gzhennaxia/demo/interviews";
        File interviewFile = new File("/Users/libo/Documents/GitHub/Gzhennaxia.github.io/source/ignore_render/interview/Interview.md");
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(interviewFile)));
        String s;
        int i = 0;
        BufferedWriter bw = null;
        while ((s = br.readLine()) != null) {
            if (s.startsWith("## ")) {
                String filename = "Interview-" + i++ + "-" + s.substring(3) + ".md";
                File file1 = new File(direction + "/" + filename);
                if (bw != null) bw.close();
                bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file1)));
            }
            if (bw != null) {
                bw.append(s);
                bw.newLine();
            }
        }
        if (bw != null) bw.close();
    }
}
