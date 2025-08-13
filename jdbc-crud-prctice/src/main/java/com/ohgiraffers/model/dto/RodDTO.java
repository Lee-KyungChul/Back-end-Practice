package com.ohgiraffers.model.dto;

public class RodDTO {

    private int rodNo;
    private String fishingPoint;
    private String rodType;
    private String rodName;
    private String rodLength;
    private String rodAction;
    private String fishSize;

    public RodDTO() {}

    public RodDTO(int rodNo, String fishingPoint, String rodType, String rodName, String rodLength, String rodAction, String fishSize) {
        this.rodNo = rodNo;
        this.fishingPoint = fishingPoint;
        this.rodType = rodType;
        this.rodName = rodName;
        this.rodLength = rodLength;
        this.rodAction = rodAction;
        this.fishSize = fishSize;
    }

    public int getRodNo() {
        return rodNo;
    }

    public void setRodNo(int rodNo) {
        this.rodNo = rodNo;
    }

    public String getFishingPoint() {
        return fishingPoint;
    }

    public void setFishingPoint(String fishingPoint) {
        this.fishingPoint = fishingPoint;
    }

    public String getRodType() {
        return rodType;
    }

    public void setRodType(String rodType) {
        this.rodType = rodType;
    }

    public String getRodName() {
        return rodName;
    }

    public void setRodName(String rodName) {
        this.rodName = rodName;
    }

    public String getRodLength() {
        return rodLength;
    }

    public void setRodLength(String rodLength) {
        this.rodLength = rodLength;
    }

    public String getRodAction() {
        return rodAction;
    }

    public void setRodAction(String rodAction) {
        this.rodAction = rodAction;
    }

    public String getFishSize() {
        return fishSize;
    }

    public void setFishSize(String fishSize) {
        this.fishSize = fishSize;
    }

    @Override
    public String toString() {
        return "RodDTO{" +
                "rodNo=" + rodNo +
                ", fishingPoint='" + fishingPoint + '\'' +
                ", rodType='" + rodType + '\'' +
                ", rodName='" + rodName + '\'' +
                ", rodLength='" + rodLength + '\'' +
                ", rodAction='" + rodAction + '\'' +
                ", fishSize='" + fishSize + '\'' +
                '}';
    }
}
