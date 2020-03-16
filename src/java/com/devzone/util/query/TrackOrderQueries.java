package com.devzone.util.query;

public class TrackOrderQueries {
    public static final String LOAD_DATA_QUERY = "SELECT * FROM trackinfo";
    public static final String TRACK_SPECIFIC_DATA_QUERY = "SELECT * FROM trackinfo WHERE TOID = ?";
    public static final String TRACK_VALIDATE_QUERY = "SELECT * FROM trackinfo WHERE TOID = ? AND TCode = ?";
    public static final String INSERT_DATA_QUERY = "INSERT INTO trackinfo ( TCode, TOID) VALUES( ?, ?)";
    public static final String UPDATE_STATUS_QUERY = "UPDATE trackinfo SET TStatus = ? WHERE TOID = ?";
}
