package com.onion.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by OnionMac on 2018/3/19.
 */
public class BankLoader {

    public static List<Bank> bankList;

    static {
        bankList = new ArrayList<>();

        bankList.add(new Bank("ICBC","01020000","中国工商银行"));
        bankList.add(new Bank("ABC","01030000","中国农业银行"));
        bankList.add(new Bank("CMBCHINA","03080000","招商银行"));
        bankList.add(new Bank("CCB","01050000","中国建设银行"));
        bankList.add(new Bank("BOCO","03010000","交通银行"));
        bankList.add(new Bank("BOC","01040000","中国银行"));
        bankList.add(new Bank("CMBC","03050000","中国民生银行"));
        bankList.add(new Bank("CGB","03060000","广发银行"));
        bankList.add(new Bank("HXB","03040000","华夏银行"));
        bankList.add(new Bank("POST","01000000","中国邮政储蓄银行"));
        bankList.add(new Bank("ECITIC","03020000","中信银行"));
        bankList.add(new Bank("CEB","03030000","中国光大银行"));
        bankList.add(new Bank("PINGAN","03070000","平安银行"));
        bankList.add(new Bank("CIB","03090000","兴业银行"));
        bankList.add(new Bank("SPDB","03100000","浦发银行"));
        bankList.add(new Bank("BCCB","04031000","北京银行"));
        bankList.add(new Bank("BON","04083320","宁波银行"));
        bankList.add(new Bank("SHB","04012900","上海银行"));
        bankList.add(new Bank("CZB","03160000","浙商银行"));
    }

    public static Map<String,String> loader(Map<String,String> map){

        for (Bank bank : bankList) {
            map.put(bank.getBankLocalCode(),bank.getBankCode());
        }

        return map;
    }

}
