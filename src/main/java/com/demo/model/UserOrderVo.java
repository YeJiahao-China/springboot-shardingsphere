package com.demo.model;

/**
 * @author JHYe
 * @date 2024/4/8
 */
public class UserOrderVo {
    private Long id;

    private Long user_id;

    private String user_name;

    private String name;

    private Integer consume;

    private char discount;

    public UserOrderVo() {
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getConsume() {
        return consume;
    }

    public void setConsume(Integer consume) {
        this.consume = consume;
    }

    public char getDiscount() {
        return discount;
    }

    public void setDiscount(char discount) {
        this.discount = discount;
    }
}
