package com.ohgiraffers.model.dto;

public class FishDTO {

    private int fish_no;
    private String fish_name;
    private String fishing_type;
    private String fishing_point;
    private String fish_size;

    public FishDTO() {}

    public FishDTO(int fish_no, String fish_name, String fishing_type, String fishing_point, String fish_size) {
        this.fish_no = fish_no;
        this.fish_name = fish_name;
        this.fishing_type = fishing_type;
        this.fishing_point = fishing_point;
        this.fish_size = fish_size;
    }

    public int getFish_no() {
        return fish_no;
    }

    public void setFish_no(int fish_no) {
        this.fish_no = fish_no;
    }

    public String getFish_name() {
        return fish_name;
    }

    public void setFish_name(String fish_name) {
        this.fish_name = fish_name;
    }

    public String getFishing_type() {
        return fishing_type;
    }

    public void setFishing_type(String fishing_type) {
        this.fishing_type = fishing_type;
    }

    public String getFishing_point() {
        return fishing_point;
    }

    public void setFishing_point(String fishing_point) {
        this.fishing_point = fishing_point;
    }

    public String getFish_size() {
        return fish_size;
    }

    public void setFish_size(String fish_size) {
        this.fish_size = fish_size;
    }

    @Override
    public String toString() {
        return "FishDTO{" +
                "fish_no=" + fish_no +
                ", fish_name='" + fish_name + '\'' +
                ", fishing_type='" + fishing_type + '\'' +
                ", fishing_point='" + fishing_point + '\'' +
                ", fish_size='" + fish_size + '\'' +
                '}';
    }
}
