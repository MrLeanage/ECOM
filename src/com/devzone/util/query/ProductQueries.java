package com.devzone.util.query;

public class ProductQueries {
    public static final String LOAD_DATA_QUERY = "SELECT * FROM product";
    public static final String LOAD_HOME_DATA_QUERY = "SELECT * FROM product WHERE PHomeProduct = 'Home'";
    public static final String SELECT_DATA_QUERY = "SELECT * FROM product WHERE PID = ?";
    public static final String INSERT_DATA_QUERY = "INSERT INTO product (PName, PDescription, PDimention, PWeight, PColor, PMaterial, PAvailability, PCustomize, PPrice, PImage1, PImage2, PImage3, pHomeProduct) VALUES( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String UPDATE_DATA_QUERY = "UPDATE product SET PName = ?, PDescription = ?, PDimention = ? , PWeight = ?, PColor = ?, PMaterial = ?, PAvailability = ?, PCustomize = ? , PPrice = ?, PImage1 = ?, PImage2 = ?, PImage3 = ?, pHomeProduct = ? WHERE PID = ?";
    public static final String DELETE_DATA_QUERY = "DELETE FROM product WHERE PID = ? ";

}
