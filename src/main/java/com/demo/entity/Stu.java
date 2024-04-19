package com.demo.entity;

/**
 * @author JHYe
 * @date 2024/4/9
 */
public class Stu {

    private Long number;

    private String name;

    private String country;


    public Stu() {
    }

    public Stu(Long number, String name, String country) {
        this.number = number;
        this.name = name;
        this.country = country;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
