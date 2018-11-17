package com.rummykhan.nativefort;


/**
 * Created by rummykhan on 17/11/18
 */
public class Payfort {

    // Commands
    public final static String COMMAND_AUTHORIZATION = "AUTHORIZATION";
    public final static String COMMAND_PURCHASE = "PURCHASE";
    public final static String COMMAND_SDK_TOKEN = "SDK_TOKEN";

    // Keys
    public static final String FAILURE_SDK_INIT = "FAILURE_SDK_INIT";
    public static final String FAILURE_TOKEN_INIT = "FAILURE_TOKEN_INIT";
    public static final String PURCHASE_EXCEPTION = "PURCHASE_EXCEPTION";


    // Urls
    public final static String URL_SANDBOX = "https://sbpaymentservices.payfort.com/FortAPI/paymentApi/";
    public final static String URL_PRODUCTION = "https://checkout.payfort.com/FortAPI/paymentPage";

    // WS params
    public final static String KEY_MERCHANT_IDENTIFIER = "merchant_identifier";
    public final static String KEY_SERVICE_COMMAND = "service_command";
    public final static String KEY_DEVICE_ID = "device_id";
    public final static String KEY_LANGUAGE = "language";
    public final static String KEY_ACCESS_CODE = "access_code";
    public final static String KEY_SIGNATURE = "signature";

    // Constants Keys
    public static final String KEY_COMMAND_AUTHORIZATION = "COMMAND_AUTHORIZATION";
    public static final String KEY_COMMAND_PURCHASE = "COMMAND_PURCHASE";
    public static final String KEY_CURRENCY_AED = "CURRENCY_AED";
    public static final String KEY_CURRENCY_SAR = "CURRENCY_SAR";

    //Request key for response
    public static final String RESPONSE_GET_TOKEN = "RESPONSE_GET_TOKEN";
    public static final String RESPONSE_PURCHASE = "RESPONSE_PURCHASE";
    public static final int RESPONSE_PURCHASE_INT = 111;
    public static final String RESPONSE_PURCHASE_CANCEL = "RESPONSE_PURCHASE_CANCEL";
    public static final String RESPONSE_PURCHASE_SUCCESS = "RESPONSE_PURCHASE_SUCCESS";
    public static final String RESPONSE_PURCHASE_FAILURE = "RESPONSE_PURCHASE_FAILURE";

    // Currency
    public final static String CURRENCY_AED = "AED";
    public final static String CURRENCY_SAR = "SAR";
}