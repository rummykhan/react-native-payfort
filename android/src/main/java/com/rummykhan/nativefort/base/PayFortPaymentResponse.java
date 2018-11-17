package com.rummykhan.nativefort;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by rummykhan on 17/11/18
 */
public class PayFortPaymentResponse implements Parcelable {

    @SerializedName("amount")
    private String amount;

    @SerializedName("response_code")
    private String responseCode;

    @SerializedName("card_number")
    private String cardNumber;

    @SerializedName("card_holder_name")
    private String cardHolderName;

    @SerializedName("payment_option")
    private String paymentOption;

    @SerializedName("expiry_date")
    private String expiryDate;

    @SerializedName("customer_ip")
    private String customerIP;

    @SerializedName("eci")
    private String eci;

    @SerializedName("language")
    private String language;

    @SerializedName("fort_id")
    private String fortId;

    @SerializedName("command")
    private String authorization;

    @SerializedName("response_message")
    private String responseMessage;

    @SerializedName("sdk_token")
    private String sdkToken;

    @SerializedName("authorization_code")
    private String authorizationCode;

    @SerializedName("merchant_reference")
    private String merchantReference;

    @SerializedName("customer_email")
    private String customerEmail;

    @SerializedName("token_name")
    private String tokenName;

    @SerializedName("currency")
    private String currency;

    @SerializedName("status")
    private String status;

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public String getPaymentOption() {
        return paymentOption;
    }

    public void setPaymentOption(String paymentOption) {
        this.paymentOption = paymentOption;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getCustomerIP() {
        return customerIP;
    }

    public void setCustomerIP(String customerIP) {
        this.customerIP = customerIP;
    }

    public String getEci() {
        return eci;
    }

    public void setEci(String eci) {
        this.eci = eci;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getFortId() {
        return fortId;
    }

    public void setFortId(String fortId) {
        this.fortId = fortId;
    }

    public String getAuthorization() {
        return authorization;
    }

    public void setAuthorization(String authorization) {
        this.authorization = authorization;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public String getSdkToken() {
        return sdkToken;
    }

    public void setSdkToken(String sdkToken) {
        this.sdkToken = sdkToken;
    }

    public String getAuthorizationCode() {
        return authorizationCode;
    }

    public void setAuthorizationCode(String authorizationCode) {
        this.authorizationCode = authorizationCode;
    }

    public String getMerchantReference() {
        return merchantReference;
    }

    public void setMerchantReference(String merchantReference) {
        this.merchantReference = merchantReference;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getTokenName() {
        return tokenName;
    }

    public void setTokenName(String tokenName) {
        this.tokenName = tokenName;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.amount);
        dest.writeString(this.responseCode);
        dest.writeString(this.cardNumber);
        dest.writeString(this.cardHolderName);
        dest.writeString(this.paymentOption);
        dest.writeString(this.expiryDate);
        dest.writeString(this.customerIP);
        dest.writeString(this.eci);
        dest.writeString(this.language);
        dest.writeString(this.fortId);
        dest.writeString(this.authorization);
        dest.writeString(this.responseMessage);
        dest.writeString(this.sdkToken);
        dest.writeString(this.authorizationCode);
        dest.writeString(this.merchantReference);
        dest.writeString(this.customerEmail);
        dest.writeString(this.tokenName);
        dest.writeString(this.currency);
        dest.writeString(this.status);
    }

    public PayFortPaymentResponse() {
    }

    protected PayFortPaymentResponse(Parcel in) {
        this.amount = in.readString();
        this.responseCode = in.readString();
        this.cardNumber = in.readString();
        this.cardHolderName = in.readString();
        this.paymentOption = in.readString();
        this.expiryDate = in.readString();
        this.customerIP = in.readString();
        this.eci = in.readString();
        this.language = in.readString();
        this.fortId = in.readString();
        this.authorization = in.readString();
        this.responseMessage = in.readString();
        this.sdkToken = in.readString();
        this.authorizationCode = in.readString();
        this.merchantReference = in.readString();
        this.customerEmail = in.readString();
        this.tokenName = in.readString();
        this.currency = in.readString();
        this.status = in.readString();
    }

    public static final Parcelable.Creator<PayFortPaymentResponse> CREATOR = new Parcelable.Creator<PayFortPaymentResponse>() {
        @Override
        public PayFortPaymentResponse createFromParcel(Parcel source) {
            return new PayFortPaymentResponse(source);
        }

        @Override
        public PayFortPaymentResponse[] newArray(int size) {
            return new PayFortPaymentResponse[size];
        }
    };
}
