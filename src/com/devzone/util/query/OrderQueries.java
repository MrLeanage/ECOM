package com.devzone.util.query;

public class OrderQueries {
    public static final String LOAD_DATA_QUERY = "SELECT * FROM order";
    public static final String INSERT_DATA_QUERY = "INSERT INTO orders(OPID, OCName, OCNIC, OCPhone, OType, ODescription, OPrice, OAdAmount, OQuantity, OStatus) VALUES (?,?,?,?,?,?,?,?,?,?)";
    public static final String SELECT_DATA_QUERY = "SELECT * FROM orders WHERE OID = ?";
}
