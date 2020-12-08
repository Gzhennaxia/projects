package com.gzhennaxia.ledger.demo.apache.commons.csv;

import com.gzhennaxia.ledger.entity.WeChatLedgerItem;
import com.gzhennaxia.ledger.utils.BeanConverter;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Read / Write CSV files in Java using Apache Commons CSV
 * https://www.callicoder.com/java-read-write-csv-file-apache-commons-csv/
 *
 * @author bo li
 * @date 2020-07-22 12:09
 */
public class WeChatDemo {

    private final static String CSV_FILE_PATH = "/Users/libo/Documents/GitHub/projects/ledger/src/main/java/com/gzhennaxia/ledger/demo/apache/commons/csv/微信支付账单(20201108-20201208)-1.csv";
    private final static String OUT_FILE_PATH = "/Users/libo/Documents/GitHub/projects/ledger/src/main/java/com/gzhennaxia/ledger/demo/apache/commons/csv/20201108-20201208-1.csv";

    public static void main(String[] args) throws IOException, ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        fun(dateFormat.parse("2020/11/21 13:13"));
    }


    private static void fun(Date startTime) throws IOException {

        BufferedReader reader = Files.newBufferedReader(Paths.get(CSV_FILE_PATH));
        CSVParser parser = new CSVParser(reader, CSVFormat.DEFAULT);

        // Mac下生成CSV文件，用Excel打开时经常会遇到中文乱码的问题。
        // 选中CSV文件后点击空格预览，也能正常显示中文。但用Excel打开时，就变成一堆乱码。
        // 原因是Mac下文本的默认编码是UTF-8，而Excel对中文的处理是GBK编码。
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(OUT_FILE_PATH), "gbk"));
//        BufferedWriter writer = Files.newBufferedWriter(Paths.get(OUT_FILE_PATH + System.currentTimeMillis() + ".csv"));
        CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT
                .withHeader("日期", "时间", "类别", "名称", "金额(¥)", "数量", "支付方式", "渠道", "备注"));

        SimpleDateFormat date = new SimpleDateFormat("yyyy/MM/dd");
        SimpleDateFormat time = new SimpleDateFormat("HH:mm");
        Calendar calendar = Calendar.getInstance();

        for (CSVRecord record : parser) {

            WeChatLedgerItem item = BeanConverter.convert2WeChatLedgerItem(record);
            if (item != null) {
                Date transactionTime = item.getTransactionTime();
                String money = item.getMoney().substring(1);
                calendar.setTime(transactionTime);
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                int hour = calendar.get(Calendar.HOUR_OF_DAY);
                int minute = calendar.get(Calendar.MINUTE);
                if (transactionTime.after(startTime)) {
                    if ("支出".equals(item.getIncomeOrExpenditure())) {
                        String counterparty = item.getCounterparty();
                        String transactionType = item.getTransactionType();
                        String productName = item.getProductName();
                        String categroy = "";
                        String name = "";
                        String count = "";
                        String payType = "";
                        if ("零钱".equals(item.getPayType())) {
                            payType = "微信";
                        } else if ("交通银行(0147)".equals(item.getPayType())) {
                            payType = "微信-银行卡";
                        }
                        String channel = "";
                        String remark = "";
                        switch (counterparty) {
                            case "不必再憶":
                                categroy = "早餐";
                                if ("¥5.00".equals(item.getMoney())) name = "肉包子*1、菜包子*1、茶叶蛋*1";
                                if ("¥4.50".equals(item.getMoney())) name = "菜包子*2、茶叶蛋*1";
                                count = "1份";
                                channel = "楼下包子铺";
                                break;
                            case "路...一直在":
                                if (7 < hour && hour <= 13) {
                                    categroy = "午餐";
                                } else if (13 < hour && hour <= 19) {
                                    categroy = "晚餐";
                                } else if (19 < hour || hour <= 7) {
                                    categroy = "夜宵";
                                }
                                count = "1份";
                                channel = "羊肉饸饹面";
                                break;
                            case "美团点评平台商户":
                                if (7 < hour && hour <= 13) {
                                    categroy = "午餐";
                                } else if (13 < hour && hour <= 19) {
                                    categroy = "晚餐";
                                } else if (19 < hour || hour <= 7) {
                                    categroy = "夜宵";
                                }
                                count = "1份";
                                channel = "美团外卖APP";
                                break;
                            case "肯德基":
                                if (7 < hour && hour <= 13) {
                                    categroy = "午餐";
                                } else if (13 < hour && hour <= 19) {
                                    categroy = "晚餐";
                                } else if (19 < hour || hour <= 7) {
                                    categroy = "夜宵";
                                }
                                count = "1份";
                                channel = "肯德基门店";
                                break;
                            case "唯客（南油）":
                                categroy = "晚餐";
                                count = "1份";
                                channel = "唯客门店";
                                name = "快餐";
                                break;
                            case "深圳市地铁相关运营主体":
                                categroy = "地铁";
                                count = "1次";
                                channel = "乘车码小程序";
                                break;
                            case "深圳通":
                                categroy = "公交";
                                count = "1次";
                                channel = "深圳通小程序";
                                break;
                            case "京东商城平台商户":
                                categroy = "网购";
                                count = "1次";
                                channel = "京东APP";
                                break;
                        }
                        switch (productName) {
                            case "中国联通-美团外卖满10减10满减券":
                                categroy = "优惠券";
                                count = "1张";

                                channel = "联通手机营业厅APP";
                                name = "中国联通-美团外卖满10减10满减券";
                                break;
                            case "":

                                break;
                        }
                        if ("北京摩拜科技有限公司".equals(counterparty) && "车费代扣".equals(productName)) {
                            categroy = "单车";
                            count = "1次";
                            channel = "美团APP";
                            name = "美团单车";
                        }
                        if ("转账".equals(transactionType)) {
                            if ("Boris".equals(counterparty)) continue;
                            count = "1次";
                            channel = "微信";
                            name = transactionType + "给" + counterparty;
                        }
                        if ("微信红包（单发）".equals(transactionType)) {
                            if ("发给Boris".equals(counterparty)) continue;
                            switch (counterparty) {
                                case "发给Zal Zhang":
                                    name = "快餐";
                                    categroy = "晚餐";
                                    count = "1次";
                                    channel = "亮哥代付";
                                    break;
                                case "发给奎":
                                    name = "快餐";
                                    categroy = "晚餐";
                                    count = "1次";
                                    channel = "西奎代付";
                                    break;
                                case "发给Soaic":
                                    name = "快餐";
                                    categroy = "晚餐";
                                    count = "1次";
                                    channel = "肖赛代付";
                                    break;
                                default:
                                    count = "1次";
                                    channel = "微信";
                                    name = transactionType + counterparty;
                                    break;
                            }
                        }
                        if ("丽珍".equals(counterparty)) {
                            if ("2100.00".equals(money)) {
                                categroy = "房租";
                                count = "1次";
                                channel = "微信转账";
                                name = year + "年" + (month + 1) + "月 " + "房租";
                                remark = "总共" + money + "，和老蒋平摊";
                                money = Double.valueOf(money) / 2 + "";
                            } else {
                                categroy = "物业水电";
                                count = "1次";
                                channel = "微信转账";
                                name = year + "年" + month + "月 " + "物业+水电";
                                remark = "总共" + money + "，和老蒋平摊";
                                money = Double.valueOf(money) / 2 + "";
                            }
                        }
                        csvPrinter.printRecord(
                                date.format(item.getTransactionTime()),
                                time.format(item.getTransactionTime()),
                                categroy,
                                name,
                                money,
                                count,
                                payType,
                                channel,
                                remark
                        );
                    }
                }
            } else {
                System.out.println("Record No - " + record.getRecordNumber());
                System.out.println("---------------------------------------");
            }
        }
        csvPrinter.flush();
    }
}
