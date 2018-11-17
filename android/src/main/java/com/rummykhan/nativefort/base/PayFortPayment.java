package com.rummykhan.nativefort;

import android.app.Activity;
import android.os.AsyncTask;
import android.text.TextUtils;

import com.google.gson.Gson;
import com.payfort.fort.android.sdk.base.FortSdk;
import com.payfort.fort.android.sdk.base.callbacks.FortCallBackManager;
import com.payfort.sdk.android.dependancies.base.FortInterfaces;
import com.payfort.sdk.android.dependancies.models.FortRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import com.facebook.react.bridge.Promise;

/**
 * Created by rummykhan on 17/11/18
 */
public class PayFortPayment {

    // Url
    private static String WS_GET_TOKEN = "";

    //S tatics
    public static String MERCHANT_IDENTIFIER = "";
    public static String ACCESS_CODE = "";
    public static String SHA_REQUEST_PHRASE = "";
    public static String SHA_RESPONSE_PHRASE = "";

    // ALgorithm
    private final static String SHA_TYPE = "SHA-256";

    private String currentLanguage;

    private final Gson gson;
    private Activity context;
    private FortCallBackManager fortCallback = null;

    private String sdkToken;
    private PayFortData payFortData;
    private Promise promise;
    private boolean isSandBox;

    public PayFortPayment(boolean isSandBox, Activity context, String language, FortCallBackManager fortCallback, Promise promise) {
        this.isSandBox = isSandBox;
        this.context = context;
        this.fortCallback = fortCallback;

        this.currentLanguage = language;
        this.promise = promise;

        sdkToken = "";
        gson = new Gson();

        this.setHostUrl();
    }

    public void requestForPayment(PayFortData payFortData) {
        this.payFortData = payFortData;
        new GetTokenFromServer().execute(WS_GET_TOKEN);
    }

    private String getEnvironment() {
        String environment = FortSdk.ENVIRONMENT.TEST;
        if (!this.isEnvironmentSandBox()) {
            environment = FortSdk.ENVIRONMENT.PRODUCTION;
        }
        return environment;
    }

    private boolean isEnvironmentSandBox() {
        return this.isSandBox;
    }

    private void requestPurchase() {
        try {

            FortSdk.getInstance().registerCallback(context, getPurchaseFortRequest(), getEnvironment(), Payfort.RESPONSE_PURCHASE_INT, fortCallback, true, new FortInterfaces.OnTnxProcessed() {
                @Override
                public void onCancel(Map<String, Object> requestParamsMap, Map<String, Object> responseMap) {
                    JSONObject response = new JSONObject(responseMap);
                    PayFortData payFortData = gson.fromJson(response.toString(), PayFortData.class);
                    payFortData.setPaymentResponse(response.toString());
                    promise.reject(response.toString(), Payfort.RESPONSE_PURCHASE_CANCEL);
                }

                @Override
                public void onSuccess(Map<String, Object> requestParamsMap, Map<String, Object> fortResponseMap) {
                    JSONObject response = new JSONObject(fortResponseMap);
                    PayFortData payFortData = gson.fromJson(response.toString(), PayFortData.class);
                    payFortData.setPaymentResponse(response.toString());
                    promise.resolve(response.toString());
                }

                @Override
                public void onFailure(Map<String, Object> requestParamsMap, Map<String, Object> fortResponseMap) {
                    JSONObject response = new JSONObject(fortResponseMap);
                    PayFortData payFortData = gson.fromJson(response.toString(), PayFortData.class);
                    payFortData.setPaymentResponse(response.toString());
                    promise.reject(response.toString(), Payfort.RESPONSE_PURCHASE_FAILURE);
                }
            });
        } catch (Exception e) {
            promise.reject(e.getMessage(), Payfort.FAILURE_SDK_INIT);
        }
    }

    private FortRequest getPurchaseFortRequest() {
        FortRequest fortRequest = new FortRequest();
        if (payFortData != null) {
            HashMap<String, Object> parameters = new HashMap<>();
            parameters.put("amount", String.valueOf(payFortData.getAmount()));
            parameters.put("command", payFortData.getCommand());
            parameters.put("currency", payFortData.getCurrency());
            parameters.put("customer_email", payFortData.getCustomerEmail());
            parameters.put("language", payFortData.getLanguage());
            parameters.put("merchant_reference", payFortData.getMerchantReference());
            parameters.put("sdk_token", sdkToken);

            fortRequest.setRequestMap(parameters);
        }
        return fortRequest;
    }

    private class GetTokenFromServer extends AsyncTask<String, String, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... postParams) {
            String response = "";

            HttpURLConnection conn;

            try {
                // Url encode spaces
                URL url = new URL(postParams[0].replace(" ", "%20"));
                conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("POST");
                conn.setRequestProperty("content-type", "application/json");

                String str = getTokenParams();
                byte[] outputInBytes = str.getBytes("UTF-8");
                OutputStream os = conn.getOutputStream();
                os.write(outputInBytes);
                os.close();
                conn.connect();

                if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                    InputStream inputStream = conn.getInputStream();
                    response = convertStreamToString(inputStream);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            return response;
        }

        @Override
        protected void onPostExecute(String response) {
            super.onPostExecute(response);

            try {
                PayFortData payFortData = gson.fromJson(response, PayFortData.class);

                if (!TextUtils.isEmpty(payFortData.getSdkToken())) {
                    sdkToken = payFortData.getSdkToken();
                    requestPurchase();
                } else {
                    payFortData.setPaymentResponse(response);
                    promise.reject(Payfort.FAILURE_TOKEN_INIT);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public String getTokenParams() {
        JSONObject jsonObject = new JSONObject();

        try {
            String device_id = FortSdk.getDeviceId(context);
            String concatenatedString = SHA_REQUEST_PHRASE +
                    Payfort.KEY_ACCESS_CODE + "=" + ACCESS_CODE +
                    Payfort.KEY_DEVICE_ID + "=" + device_id +
                    Payfort.KEY_LANGUAGE + "=" + currentLanguage +
                    Payfort.KEY_MERCHANT_IDENTIFIER + "=" + MERCHANT_IDENTIFIER +
                    Payfort.KEY_SERVICE_COMMAND + "=" + SDK_TOKEN +
                    SHA_REQUEST_PHRASE;

            jsonObject.put(Payfort.KEY_SERVICE_COMMAND, SDK_TOKEN);
            jsonObject.put(Payfort.KEY_MERCHANT_IDENTIFIER, MERCHANT_IDENTIFIER);
            jsonObject.put(Payfort.KEY_ACCESS_CODE, ACCESS_CODE);
            String signature = getSignatureSHA256(concatenatedString);
            jsonObject.put(Payfort.KEY_SIGNATURE, signature);
            jsonObject.put(Payfort.KEY_DEVICE_ID, device_id);
            jsonObject.put(Payfort.KEY_LANGUAGE, currentLanguage);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return String.valueOf(jsonObject);
    }

    private static String convertStreamToString(InputStream inputStream) {
        if (inputStream == null)
            return null;
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader r = new BufferedReader(new InputStreamReader(inputStream), 1024);
            String line;
            while ((line = r.readLine()) != null) {
                sb.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    private static String getSignatureSHA256(String s) {
        try {
            // Create MD5 Hash
            MessageDigest digest = MessageDigest.getInstance(SHA_TYPE);
            digest.update(s.getBytes());
            byte messageDigest[] = digest.digest();

            return String.format("%0" + (messageDigest.length * 2) + 'x', new BigInteger(1, messageDigest));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

    public void setHostUrl() {

        String url = Payfort.URL_SANDBOX;

        if (!this.isEnvironmentSandBox()) {
            url = Payfort.URL_PRODUCTION;
        }

        PayFortPayment.WS_GET_TOKEN = url;
    }

    public void setMerchantIdentifier(String merchantIdentifier) {
        PayFortPayment.MERCHANT_IDENTIFIER = merchantIdentifier;
    }

    public void setAccessCode(String accessCode) {
        PayFortPayment.ACCESS_CODE = accessCode;
    }

    public void setShaRequestPhrase(String shaRequestPhrase) {
        PayFortPayment.SHA_REQUEST_PHRASE = shaRequestPhrase;
    }

    public void setShaResponsePhrase(String shaResponsePhrase) {
        PayFortPayment.SHA_RESPONSE_PHRASE = shaResponsePhrase;
    }
}