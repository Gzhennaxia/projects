package com.gzhennaxia.ledger.demo.apache.commons.csv;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Read / Write CSV files in Java using Apache Commons CSV
 * https://www.callicoder.com/java-read-write-csv-file-apache-commons-csv/
 *
 * @author bo li
 * @date 2020-07-22 12:09
 */
public class CSVDemo {

    private final static String CSV_FILE_PATH = "/Users/libo/Documents/GitHub/projects/ledger/src/main/java/com/gzhennaxia/ledger/demo/apache/commons/csv/微信支付账单(20200622-20200722).csv";

    public static void main(String[] args) throws IOException {

        BufferedReader reader = Files.newBufferedReader(Paths.get(CSV_FILE_PATH));
        CSVParser parser = new CSVParser(reader, CSVFormat.DEFAULT);
        for (CSVRecord record : parser) {
            System.out.println("Record No - " + record.getRecordNumber());
            System.out.println("---------------------------------------");
            System.out.println("Column 1 - " + record.get(0));
        }
    }
}
