package com.devzone.util.query;

public class MaterialQueries {
    public static final String LOAD_DATA_QUERY = "SELECT * FROM material";
    public static final String INSERT_DATA_QUERY = "INSERT INTO material (MName, ) VALUES( ?)";
    public static final String SELECT_DATA_QUERY = "SELECT * FROM material WHERE MID = ?";
    public static final String UPDATE_DATA_QUERY = "UPDATE material SET MName = ? WHERE MID = ?";
    public static final String DELETE_DATA_QUERY = "DELETE FROM material WHERE MID = ? ";

}
