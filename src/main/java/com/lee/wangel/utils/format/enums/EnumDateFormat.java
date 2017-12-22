package com.lee.wangel.utils.format.enums;

/**
 * 测试
 * 2017/12/21 17:43 lee.wangel
 */
public enum EnumDateFormat {

    yyMM("yyMM")
    ,yy_MM("yyyy-MM")
    ,yyyyMM("yyyyMM")
    ,yyyyMMdd("yyyyMMdd")
    ,yyyyMMddHHmm("yyyyMMddHHmm")
    ,yyyyMMddHHmmss("yyyyMMddHHmmss")
    ,yyyy_MM_dd("yyyy-MM-dd")
    ,yyyy_MM_dd_HH_mm("yyyy-MM-dd HH:mm")
    ,yyyy_MM_dd_HH_mm_ss("yyyy-MM-dd HH:mm:ss")
    ,yyyy__MM__dd("yyyy/MM/dd")
    ,yyyy__MM__dd_HH_mm("yyyy/MM/dd HH:mm")
    ,yyyy__MM__dd_HH_mm_ss("yyyy/MM/dd HH:mm:ss")
    ,MM("MM")
    ,MMdd("MMdd")
    ,dd("dd")
    ,HHmm("HHmm")
    ,HHmmss("HHmmss")
    ;
    private String format;
    private EnumDateFormat(String format){
        this.format = format;
    }
    public String getFormat(){
        return this.format;
    }
}
