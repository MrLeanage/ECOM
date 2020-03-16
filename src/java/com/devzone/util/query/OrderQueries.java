package com.devzone.util.query;

public class OrderQueries {
    public static final String LOAD_DATA_QUERY = "SELECT * FROM orders";
    public static final String INSERT_DATA_QUERY = "INSERT INTO orders(OPID, OCName, OCNIC, OCPhone, OType, ODescription, OPrice, OAdAmount, OQuantity, OStatus) VALUES (?,?,?,?,?,?,?,?,?,?)";
    public static final String SELECT_DATA_QUERY = "SELECT * FROM orders WHERE OID = ?";
    public static final String UPDATE_STATUS_QUERY = "UPDATE orders SET OStatus = ? WHERE OID = ?";
}
