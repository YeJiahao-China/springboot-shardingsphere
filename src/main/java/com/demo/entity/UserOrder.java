package com.demo.entity;

/**
 * @author JHYe
 * @date 2024/4/8
 */
public class UserOrder {
    private Long id;

    private Long user_id;

    private String name;

    private Integer consume;

    private char discount;

    public UserOrder(Long id, Long user_id, String name, Integer consume, char discount) {
        this.id = id;
        this.user_id = user_id;
        this.name = name;
        this.consume = consume;
        this.discount = discount;
    }

    public UserOrder() {
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
