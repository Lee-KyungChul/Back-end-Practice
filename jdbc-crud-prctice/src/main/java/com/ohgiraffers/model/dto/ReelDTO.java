package com.ohgiraffers.model.dto;

public class ReelDTO {

    private int reel_no;
    private String fishing_point;
    private String fishing_type;
    private String reel_name;
    private String reel_type;
    private String reel_weight;

    public ReelDTO() {}

    public ReelDTO(int reel_no, String fishing_point, String fishing_type, String reel_name, String reel_type, String reel_weight) {
        this.reel_no = reel_no;
        this.fishing_point = fishing_point;
        this.fishing_type = fishing_type;
        this.reel_name = reel_name;
        this.reel_type = reel_type;
        this.reel_weight = reel_weight;
    }

    public int getReel_no() {
        return reel_no;
    }

    public void setReel_no(int reel_no) {
        this.reel_no = reel_no;
    }

    public String getFishing_point() {
        return fishing_point;
    }

    public void setFishing_point(String fishing_point) {
        this.fishing_point = fishing_point;
    }

    public String getFishing_type() {
        return fishing_type;
    }

    public void setFishing_type(String fishing_type) {
        this.fishing_type = fishing_type;
    }

    public String getReel_name() {
        return reel_name;
    }

    public void setReel_name(String reel_name) {
        this.reel_name = reel_name;
    }

    public String getReel_type() {
        return reel_type;
    }

    public void setReel_type(String reel_type) {
        this.reel_type = reel_type;
    }

    public String getReel_weight() {
        return reel_weight;
    }

    public void setReel_weight(String reel_weight) {
        this.reel_weight = reel_weight;
    }

    @Override
    public String toString() {
        return "ReelDTO{" +
                "reel_no=" + reel_no +
                ", fishing_point='" + fishing_point + '\'' +
                ", fishing_type='" + fishing_type + '\'' +
                ", reel_name='" + reel_name + '\'' +
                ", reel_type='" + reel_type + '\'' +
                ", reel_weight='" + reel_weight + '\'' +
                '}';
    }
}
