package com.reactsrping.boardback.common;

public interface ResponseCode {
    
    //public static final 

    // HTTP Status 200
    String SUCCESS = "SU"; 

    // HTTP Status 400
    String VALIDATION_FAILED = "VE";
    String DUPLICATE_EMAIL = "DE";
    String DUPLICATE_TELNUMBER = "DT";
    String DUPLICATE_NICKNAME = "DN";
    String NOT_EXISTED_USER = "NU";
    String NOT_EXISTED_BOARD = "NB";

    // HTTP Status 401
    String SIGN_IN_FAIL = "SF";
    String AUTHORIZATION_FAILED = "AF";

    // HTTP Status 403
    String NO_PERMISSION = "NP";
    
    // HTTP Status 500
    String DATABASE_ERROR= "DBE";

}