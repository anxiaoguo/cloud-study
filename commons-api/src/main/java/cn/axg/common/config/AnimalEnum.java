package cn.axg.common.config;

import java.util.Arrays;

/**
 * 动物枚举（用来练习枚举）
 */
public enum AnimalEnum {


    XIAO_HEI(1, 1, 700, "小黑"),
    XIAO_HONG(2, 3, 400, "小红");


    private Integer number;

    private Integer age;

    private Integer price;

    private String name;


    AnimalEnum(Integer number, Integer age, Integer price, String name) {
        this.number = number;
        this.age = age;
        this.price = price;
        this.name = name;
    }

    public Integer getNumber() {
        return number;
    }

    public Integer getAge() {
        return age;
    }

    public Integer getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    /**
     * 通过编号来获取名字
     */

    public static AnimalEnum getNameByNumber(Integer no) {
        return Arrays.stream(values())
            .filter(i -> i.number == no)
            .findFirst()
            .orElse(null);
    }


}
