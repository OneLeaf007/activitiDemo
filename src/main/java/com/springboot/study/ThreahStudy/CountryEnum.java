package com.springboot.study.ThreahStudy;


public enum CountryEnum {
    ONE(1,"齐国"),TWO(2,"楚国"),THREE(3,"燕国"),FOUR(4,"赵国"),FIVE(5,"魏国"),SIX(6,"韩国");



    private int resCode;

    private String resMassage;


    public int getResCode() {
        return resCode;
    }

    public String getResMassage() {
        return resMassage;
    }

    CountryEnum(int resCode, String resMassage) {
        this.resCode = resCode;
        this.resMassage = resMassage;
    }

    public static CountryEnum getCountryName(int index){
        CountryEnum[] countryEnums = CountryEnum.values();
        for (CountryEnum element : countryEnums) {
            if(index == element.getResCode()){
                return element;
            }
        }
        return null;
    }
}
