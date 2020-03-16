package com.devzone.model;

import com.devzone.util.utility.UtilityMethod;
import java.io.InputStream;

public class Product {
    private String pID = null;
    private String pName = null;
    private String pDescription = null;
    private String pDimention = null;
    private String pWeight = null;
    private String pColor = null;
    private String pMaterial = null;
    private String pAvailability = null;
    private String pCustomize = null;
    private Double pPrice = null;
    private String pImage1 = null;
    private String pImage2 = null;
    private String pImage3 = null;
    private String pHomeProduct = null;

    public Product(String pID, String pName, String pDescription, String pDimention, String pWeight, String pColor, String pMaterial, String pAvailability, String pCustomize, Double pPrice, String pImage1, String pImage2, String pImage3, String pHomeProduct) {
        this.pID = UtilityMethod.addPrefix("P", pID);
        this.pName = pName;
        this.pDescription = pDescription;
        this.pDimention = pDimention;
        this.pWeight = pWeight;
        this.pColor = pColor;
        this.pMaterial = pMaterial;
        this.pAvailability = pAvailability;
        this.pCustomize = pCustomize;
        this.pPrice = pPrice;
        this.pImage1 = pImage1;
        this.pImage2 = pImage2;
        this.pImage3 = pImage3;
        this.pHomeProduct = pHomeProduct;
        
    }
    public Product(){
        
    }

    public String getpID() {
        return pID;
    }

    public void setpID(String pID) {
        this.pID = pID;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getpDescription() {
        return pDescription;
    }

    public void setpDescription(String pDescription) {
        this.pDescription = pDescription;
    }

    public String getpDimention() {
        return pDimention;
    }

    public void setpDimention(String pDimention) {
        this.pDimention = pDimention;
    }

    public String getpWeight() {
        return pWeight;
    }

    public void setpWeight(String pWeight) {
        this.pWeight = pWeight;
    }

    public String getpColor() {
        return pColor;
    }

    public void setpColor(String pColor) {
        this.pColor = pColor;
    }

    public String getpMaterial() {
        return pMaterial;
    }

    public void setpMaterial(String pMaterial) {
        this.pMaterial = pMaterial;
    }

    public String getpAvailability() {
        return pAvailability;
    }

    public void setpAvailability(String pAvailability) {
        this.pAvailability = pAvailability;
    }

    public String getpCustomize() {
        return pCustomize;
    }

    public void setpCustomize(String pCustomize) {
        this.pCustomize = pCustomize;
    }

    public Double getpPrice() {
        return pPrice;
    }

    public void setpPrice(String pPrice) {
        if(!pPrice.equals("null") || !pPrice.equals("")){
            this.pPrice = Double.valueOf(pPrice);
        }
        this.pPrice = Double.parseDouble(pPrice);
    }

    public String getpImage1() {
        return pImage1;
    }

    public void setpImage1(String pImage1) {
        this.pImage1 = pImage1;
    }

    public String getpImage2() {
        return pImage2;
    }

    public void setpImage2(String pImage2) {
        this.pImage2 = pImage2;
    }

    public String getpImage3() {
        return pImage3;
    }

    public void setpImage3(String pImage3) {
        this.pImage3 = pImage3;
    }

    public String getpHomeProduct() {
        return pHomeProduct;
    }

    public void setpHomeProduct(String pHomeProduct) {
        this.pHomeProduct = pHomeProduct;
    }
    
}
