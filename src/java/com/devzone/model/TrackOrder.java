/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.devzone.model;

import com.devzone.util.utility.UtilityMethod;

/**
 *
 * @author dulshan
 */
public class TrackOrder {
    private String tID = null;
    private String tCode = null;
    private String tOID = null;
    private String tStatus = null;

    public TrackOrder(){}
        
    public TrackOrder(String tID, String tCode, String tOID, String tStatus) {
        this.tID = UtilityMethod.addPrefix("TRKO", tID);
        this.tCode = tCode;
        this.tOID = tOID;
        this.tStatus = tStatus;
    }

    public String gettID() {
        return tID;
    }

    public void settID(String tID) {
        this.tID = tID;
    }

    public String gettCode() {
        return tCode;
    }

    public void settCode(String tCode) {
        this.tCode = tCode;
    }

    public String gettOID() {
        return tOID;
    }

    public void settOID(String tOID) {
        this.tOID = tOID;
    }

    public String gettStatus() {
        return tStatus;
    }

    public void settStatus(String tStatus) {
        this.tStatus = tStatus;
    }
    
    
}
