package com.maveric.userservice.constants;


public class Constants {

    private Constants()
    {

    }

    public static final String USER_NOT_FOUND_CODE="404";
    public static final String USER_NOT_FOUND_MESSAGE="User not Found for Id-";
    public static final String USER_DELETED_SUCCESS="User deleted successfully.";
    public static final String METHOD_NOT_ALLOWED_CODE="405";
    public static final String METHOD_NOT_ALLOWED_MESSAGE="Method Not Allowed. Kindly check the Request URL and Request Type.";
    public static final String BAD_REQUEST_CODE="400";
    public static final String BAD_REQUEST_MESSAGE="Invalid inputs!";

    public static final String INVALID_INPUT_TYPE="Gender should be MALE/FEMALE";
    public static final String INVALID_DATE_TYPE="Date format Miss Match";

    public static final String HTTPMESSAGENOTREADABLEEXCEPTION_MESSAGE="Format Miss Matching";
    public static final String SERVICE_UNAVAILABLE_CODE="503";
    public static final String SERVICE_UNAVAILABLE_MESSAGE="Services down! Kindly contact administrator.";

    public static final String INTERNAL_SERVER_ERROR_CODE="500";

    public static final String INTERNAL_SERVER_ERROR_MESSAGE="Server could not resolve your request.";

}
