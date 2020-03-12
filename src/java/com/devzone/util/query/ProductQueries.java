package com.devzone.util.query;

public class ProductQueries {
    public static final String LOAD_DATA_QUERY = "SELECT * FROM product";
    public static final String INSERT_DATA_QUERY = "INSERT INTO product (PName, PDescription, PDimention, PWeight, PColor, PMaterial, PAvailability, PCustomize) VALUES( ?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String UPDATE_DATA_QUERY = "UPDATE supplierinfo SET SIName = ?, SIAddress = ?, SIPhone1 = ? , SIPhone2 = ?, SIEmail = ?, SIType = ?, SIBankName = ?, SIAccNo = ? WHERE PID = ?";
    public static final String DELETE_DATA_QUERY = "DELETE FROM supplierinfo WHERE SIID = ? ";

}
