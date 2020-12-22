package com.gzhennaxia.ledger.demo.apache.commons.csv;

import com.gzhennaxia.ledger.demo.apache.commons.io.EncodingDetectDemo;
import com.gzhennaxia.ledger.entity.AliPayLedgerItem;
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
 * @author bo li
 * @date 2020-08-04 10:01
 */
public class AliDemo {

    private final static String FILE_PATH = "/Users/libo/Documents/GitHub/projects/ledger/src/main/java/com/gzhennaxia/ledger/demo/apache/commons/csv/alipay_record_20201221_0916_1.csv";
    private final static String CSV_FILE_PATH = "/Users/libo/Documents/GitHub/projects/ledger/src/main/java/com/gzhennaxia/ledger/demo/apache/commons/csv/alipay_record_20201221_0916_2.csv";
    private final static String OUT_FILE_PATH = "/Users/libo/Documents/GitHub/projects/ledger/src/main/java/com/gzhennaxia/ledger/demo/apache/commons/csv/alipay_record_20201221_0916_3.csv";

    public static void main(String[] args) throws IOException, ParseException {
        EncodingDetectDemo.convertEncoding("GBK", "UTF-8", FILE_PATH, CSV_FILE_PATH);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        fun(dateFormat.parse("2020/12/6 18:31"));
    }


    private static void fun(Date startTime) throws IOException {

        BufferedReader reader = Files.newBufferedReader(Paths.get(CSV_FILE_PATH));
        CSVParser parser = new CSVParser(reader, CSVFormat.DEFAULT);

        // Mac下生成CSV文件，用Excel打开时经常会遇到中文乱码的问题。
        // 选中CSV文件后点击空格预览，也能正常显示中文。但用Excel打开时，就变成一堆乱码。
        // 原因是Mac下文本的默认编码是UTF-8，而Excel对中文的处理是GBK编码。
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(OUT_FILE_PATH), "gbk"));
//        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(OUT_FILE_PATH)));
//        BufferedWriter writer = Files.newBufferedWriter(Paths.get(OUT_FILE_PATH + System.currentTimeMillis() + ".csv"));
        CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT
                .withHeader("日期", "时间", "类别", "名称", "金额(¥)", "数量", "支付方式", "渠道", "备注"));

        SimpleDateFormat date = new SimpleDateFormat("yyyy/MM/dd");
        SimpleDateFormat time = new SimpleDateFormat("HH:mm");
        Calendar calendar = Calendar.getInstance();

        for (CSVRecord record : parser) {

            AliPayLedgerItem item = BeanConverter.convert2AliPayLedgerItem(record);
            if (item != null) {
                Date dealCreateTime = item.getDealCreateTime();
                calendar.setTime(dealCreateTime);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                int hour = calendar.get(Calendar.HOUR_OF_DAY);
                int minute = calendar.get(Calendar.MINUTE);
                if (dealCreateTime.after(startTime)) {
                    if (item.getIncomeOrExpenditure().startsWith("支出")) {
                        String counterparty = item.getCounterparty();
                        String dealSource = item.getDealSource();
                        String productName = item.getProductName();
                        String category = "";
                        String name = productName;
                        String money = item.getMoney();
                        String count = "1次";
                        String payType = "支付宝";
                        String channel = "";
                        String remark = "";
                        switch (counterparty) {
                            case "罗崖":
                                category = "台球";
                                name = "打台球";
                                count = "1次";
                                channel = "港龙桌球城(上沙店)";
                                break;
                            case "老东北菜馆":
                                category = CSVUtils.getThreeMeals(hour);
                                name = "饺子";
                                count = "1次";
                                channel = "小区门口老东北饺子馆";
                                break;
                            case "重庆粉面":
                                category = CSVUtils.getThreeMeals(hour);
                                if ("10.00".equals(money)) {
                                    name = "重庆小面";
                                }
                                count = "1次";
                                channel = "重庆粉面-沙尾店";
                                break;
                            case "恛憶":
                                category = CSVUtils.getThreeMeals(hour);
                                if ("5.00".equals(item.getMoney())) name = "肉包子*1、菜包子*1、茶叶蛋*1";
                                if ("4.50".equals(item.getMoney())) name = "菜包子*2、茶叶蛋*1";
                                count = "1份";
                                channel = "楼下包子铺";
                                break;
                            case "拼多多平台商户":
                                category = "网购";
                                count = "1个";
                                channel = "拼多多APP";
                                break;
                            case "香火肥肠":
                                category = CSVUtils.getThreeMeals(hour);
                                count = "1次";
                                channel = "楼下肥肠店";
                                break;
                            case "马维良":
                                category = CSVUtils.getThreeMeals(hour);
                                switch (money) {
                                    case "15.00":
                                        name = "拉面";
                                        break;
                                    case "19.00":
                                        name = "鸡蛋炒刀削";
                                        break;
                                }
                                count = "1次";
                                channel = "公司附近兰州拉面门店";
                                break;
                            case "天猫超市":
                                category = "网购";
                                count = "1次";
                                channel = "淘宝-天猫超市";
                                break;
                            case "花呗":
                                category = "还款";
                                count = "1次";
                                channel = "支付宝-花呗";
                                break;
                            case "当当网":
                                category = "网购";
                                count = "1次";
                                channel = "当当APP";
                                break;
                            case "武汉市哈哈便利科技有限公司":
                                category = "饮品";
                                count = "1次";
                                channel = "公司楼道自动售卖机";
                                break;
                            case "高德打车入驻商户":
                                category = "打车";
                                count = "1次";
                                channel = "高德地图APP";
                                break;
                            case "路...一直在":
                                category = CSVUtils.getThreeMeals(hour);
                                count = "1份";
                                channel = "谚语羊肉饸饹面";
                                break;
                            case "谚语羊肉饸饹面":
                                category = CSVUtils.getThreeMeals(hour);
                                count = "1份";
                                channel = "谚语羊肉饸饹面";
                                break;
                            case "美团点评":
                                category = CSVUtils.getThreeMeals(hour);
                                count = "1份";
                                channel = "美团外卖APP";
                                break;
                            case "肯德基":
                                category = CSVUtils.getThreeMeals(hour);
                                count = "1份";
                                channel = "肯德基门店";
                                break;
                            case "唯客（南油）":
                                category = "晚餐";
                                count = "1份";

                                channel = "唯客门店";
                                name = "快餐";
                                break;
                            case "深圳市地铁相关运营主体":
                                category = "地铁";
                                count = "1次";
                                channel = "乘车码小程序";
                                break;
                            case "阿香竞彩":
                                category = "竞彩";
                                count = "1次";
                                channel = "阿香竞彩店APP";
                                break;
                            case "饿了么":
                                category = CSVUtils.getThreeMeals(hour);
                                count = "1次";
                                channel = "饿了么APP";
                                break;
                            case "友宝":
                                category = "饮品";
                                count = "1瓶";
                                channel = "友宝售货机";
                                break;
                            case "友宝售货机(广电集团3)":
                                category = "饮品";
                                count = "1瓶";
                                channel = "友宝售货机";
                                break;
                        }
                        if (counterparty.startsWith("7-Eleven")) {
                            category = "超市";
                            count = "1次";
                            payType = "支付宝-花呗";
                            channel = "7-Eleven便利店";
                        }
                        if (counterparty.startsWith("1点点")) {
                            category = "饮品";
                            count = "1次";
                            payType = "支付宝-花呗";
                            channel = "1点点门店";
                        }
                        if (counterparty.startsWith("黔派虾子羊肉粉")) {
                            category = CSVUtils.getThreeMeals(hour);
                            count = "1次";
                            payType = "支付宝-花呗";
                            channel = "黔派虾子羊肉粉-天安店";
                        }
                        switch (productName) {
                            case "中国联通-美团外卖满10减10满减券":
                                category = "优惠券";
                                count = "1张";
                                channel = "联通手机营业厅APP";
                                name = "中国联通-美团外卖满10减10满减券";
                                break;
                            case "借呗还款":
                                category = "还款";
                                count = "1次";
                                channel = "支付宝-借呗";
                                break;
                            case "百里臣金地分店消费":
                                category = "饮品";
                                count = "1次";
                                channel = "小区门口便利店";
                                break;
                            case "luckincoffee":
                                category = "饮品";
                                count = "1次";
                                channel = "luckincoffee APP";
                                break;
                        }
                        if (productName.startsWith("相互宝")) {
                            category = "保险";
                            count = "1期";
                            channel = "支付宝APP";
                        }
                        if (productName.startsWith("天猫超市卡")) {
                            category = "充值";
                            count = "1次";
                            channel = "天猫APP";
                        }
                        if (productName.startsWith("百里臣便利店金地分店消费")) {
                            channel = "百里臣便利店金地分店";
                        }
                        if ("北京摩拜科技有限公司".equals(counterparty) && "车费代扣".equals(productName)) {
                            category = "单车";
                            count = "1次";

                            channel = "美团APP";
                            name = "美团单车";
                        }
                        if ("中国联通".equals(counterparty) && "美团外卖满10减10满减券".equals(productName)) {
                            category = "外卖券";
                            count = "1次";
                            channel = "联通手机营业厅APP";
                        }
                        if ("中国联通".equals(counterparty) && "美团外卖满10减10满减券".equals(productName)) {
                            category = "优惠券";
                            count = "1张";
                            channel = "联通手机营业厅APP";
                            name = "中国联通-美团外卖满5减5满减券";
                        }
                        if ("淘宝".equals(dealSource)) {
                            category = "网购";
                            count = "1次";
                            if ("饿了么".equals(counterparty)) {
                                channel = "饿了么APP";
                            } else {
                                channel = "淘宝APP";
                            }
                        }
                        if ("中国联通".equals(counterparty) && productName.contains("交费")) {
                            category = "话费";
                            count = "1次";
                            channel = "联通手机营业厅APP";
                        }
                        csvPrinter.printRecord(
                                date.format(dealCreateTime),
                                time.format(dealCreateTime),
                                category,
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
