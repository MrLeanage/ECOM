/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.devzone.model;

/**
 *
 * @author dulshan
 */
public class Order {
    private String oID = null;
    private String oPID = null;
    private String oCName = null;
    private String oCNIC = null;
    private String oCPhone = null;
    private String oType = null;
    private String oDescription = null;
    private Double oPrice = null;
    private Double oAdAmount = null;
    private Integer oQuantity = null;
    private String oStatus = null;

    public Order(String oID, String oPID,String oCName, String oCNIC, String oCPhone, String oType, String oDescription, Double oPrice, Double oAdAmount, Integer oQuantity, String oStatus) {
        this.oID = oID;
        this.oPID = oPID;
        this.oCName = oCName;
        this.oCNIC = oCNIC;
        this.oCPhone = oCPhone;
        this.oType = oType;
        this.oDescription = oDescription;
        this.oPrice = oPrice;
        this.oAdAmount = oAdAmount;
        this.oQuantity = oQuantity;
        this.oStatus = oStatus;
    }

    public Order() {
        //To change body of generated methods, choose Tools | Templates.
    }

    public String getoID() {
        return oID;
    }

    public void setoID(String oID) {
        this.oID = oID;
    }

    public String getoPID() {
        return oPID;
    }

    public void setoPID(String oPID) {
        this.oPID = oPID;
    }

    public String getoCName() {
        return oCName;
    }

    public void setoCName(String oCName) {
        this.oCName = oCName;
    }

    public String getoCNIC() {
        return oCNIC;
    }

    public void setoCNIC(String oCNIC) {
        this.oCNIC = oCNIC;
    }

    public String getoCPhone() {
        return oCPhone;
    }

    public void setoCPhone(String oCPhone) {
        this.oCPhone = oCPhone;
    }

    public String getoType() {
        return oType;
    }

    public void setoType(String oType) {
        this.oType = oType;
    }

    public String getoDescription() {
        return oDescription;
    }

    public void setoDescription(String oDescription) {
        this.oDescription = oDescription;
    }

    public Double getoPrice() {
        return oPrice;
    }

    public void setoPrice(String oPrice) {
        this.oPrice = Double.parseDouble(oPrice);
    }

    public Double getoAdAmount() {
        return oAdAmount;
    }

    public void setoAdAmount(String oAdAmount) {
        this.oAdAmount = Double.parseDouble(oAdAmount);
    }

    public Integer getoQuantity() {
        return oQuantity;
    }

    public void setoQuantity(String oQuantity) {
        this.oQuantity = Integer.parseInt(oQuantity);
    }

    public String getoStatus() {
        return oStatus;
    }

    public void setoStatus(String oStatus) {
        this.oStatus = oStatus;
    }
    
    
}
