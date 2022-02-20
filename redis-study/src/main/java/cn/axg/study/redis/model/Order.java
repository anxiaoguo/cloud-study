package cn.axg.study.redis.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Order implements Serializable {

    private Integer id;

    private String totalPrice;

    private Integer userId;

}
