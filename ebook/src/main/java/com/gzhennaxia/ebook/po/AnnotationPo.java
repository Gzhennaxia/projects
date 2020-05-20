package com.gzhennaxia.ebook.po;

import lombok.Data;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author bo li
 * @date 2020-05-20 10:52
 */
@Data
public class AnnotationPo {

    private Integer id;

    private String assetId;

    private Integer styleType;

    private String representativeText;

    private String selectedText;

    private String note;

    private BigDecimal creationDate;

    private String location;

    public Date getCreateTime() {
        BigDecimal bigDecimal = this.creationDate.add(new BigDecimal(978307200));
        bigDecimal = bigDecimal.setScale(0, RoundingMode.DOWN);
        return new Timestamp(bigDecimal.longValue() * 1000);
    }

    public String getFormattedCreationDate() {
        DateFormat format = new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
        return format.format(getCreateTime());
    }

    public String generateContent() {
        StringBuilder result = new StringBuilder();
        String[] strings = this.representativeText.split(this.selectedText);
        if (strings.length > 0) {
            result.append(strings[0]);
        }
        result.append("<span style=\"color: ");
        switch (this.styleType) {
            case 3:
                result.append("#FECF0B");
                break;
            case 1:
                result.append("#33D42D");
                break;
            case 2:
                result.append("#3CA3FF");
                break;
        }
        result.append("\">");
        result.append(this.selectedText).append("</span>");
        if (strings.length > 1) {
            if (strings[1].endsWith("\n")) {
                strings[1] = strings[1].substring(0, strings[1].lastIndexOf("\n"));
            }
            result.append(strings[1]);
        }
        return result.toString();
    }

    @Override
    public String toString() {


        return "<div class=\"annotation-label-wapper\">\n" +
                "    <div>" +
                getFormattedCreationDate() +
                "</div>\n" +
                "    <div title=\"" +
                this.location +
                "\" class=\"annotation-label-pos\">POS</div>\n" +
                "</div>\n\n" +
                "{% note no-icon %}\n\n" +
                generateContent() +
                "\n\n" +
                "{% endnote %}";
    }

//    public static void main(String[] args) {
//        Annotation annotation = new Annotation();
//        annotation.setId(1);
//        annotation.setCreationDate(new BigDecimal("604448109.356924"));
//        annotation.setLocation("location");
//        annotation.setNote("note");
//        annotation.setRepresentativeText("威利在场一点儿也不能增加我们的安全感，它是最胆小的一只，只会亦步亦趋地跟着莫尼卡。");
//        annotation.setSelectedText("亦步亦趋");
//        annotation.setStyleType(0);
//
////        System.out.println(annotation.getFormattedCreationDate());
//        System.out.println(annotation.generateContent());
////
////        System.out.println(annotation);
//
//
////        String s1 = "他向我解释道：“吉娅，大多数人都是这么想的，我曾经也这么想。可是请你告诉我，你为什么不能因为做了一件自己喜欢的事情而挣到钱呢？”";
////        String s2 = "大多数人都是这么想的，我曾经也这么想。可是请你告诉我，你为什么不能因为做了一件自己喜欢的事情而挣到钱呢？";
////
////        String[] split = s1.split(s2);
////        System.out.println(split[0]);
////        System.out.println(split[1]);
////        System.out.println(split[2]);
//
////        System.out.println(annotation.generateContent());
//
//    }

}
