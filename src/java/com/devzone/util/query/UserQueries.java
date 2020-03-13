package com.devzone.util.query;

public class UserQueries {
   
    public static final String SELECT_DATA_QUERY = "SELECT * FROM user WHERE UID = ? AND UPassword = ?";
    public static final String INSERT_DATA_QUERY = "INSERT INTO user (UID, UName, UPassword, UAStatus) VALUES( ?, ?, ?, ?)";

}
