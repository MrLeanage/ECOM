package com.devzone.model;

import com.devzone.util.utility.UtilityMethod;

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

    public Product(String pID, String pName, String pDescription, String pDimention, String pWeight, String pColor, String pMaterial, String pAvailability, String pCustomize) {
        this.pID = UtilityMethod.addPrefix("P", pID);
        this.pName = pName;
        this.pDescription = pDescription;
        this.pDimention = pDimention;
        this.pWeight = pWeight;
        this.pColor = pColor;
        this.pMaterial = pMaterial;
        this.pAvailability = pAvailability;
        this.pCustomize = pCustomize;
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
}
