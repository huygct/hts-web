package com.huyvn.happytostudy.packet;

/**
 * Created by thuynghi on 15/01/2016.
 */
public interface StatusCode {
    /**
     * 2xx Success
     */
    public static final int CODE_200 = 200; // OK
    public static final int CODE_201 = 201; // Created
    public static final int CODE_202 = 202; // Accepted
    public static final int CODE_203 = 203; // Non-Authoritative Information
    public static final int CODE_204 = 204; // No Content
    /**
     * 3xx Redirection
     */
    public static final int CODE_300 = 300; // Multiple choices
    public static final int CODE_301 = 301; // Move Permanently
    public static final int CODE_302 = 302; // Found
    /**
     * 4xx Client Error
     */
    public static final int CODE_400 = 400; // Bad Request
    public static final int CODE_401 = 401; // Unauthorized
    public static final int CODE_402 = 402; // Payment Required
    public static final int CODE_403 = 403; // Forbidden
    public static final int CODE_404 = 402; // Not found

}
