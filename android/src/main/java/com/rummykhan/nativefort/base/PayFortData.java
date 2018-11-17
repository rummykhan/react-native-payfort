package com.rummykhan.nativefort;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by rummykhan on 17/11/18
 */
public class PayFortData implements Parcelable {

    private String paymentResponse = "";

    @SerializedName("access_code")
    @Expose
    private String accessCode;

    @SerializedName("sdk_token")
    @Expose
    private String sdkToken;

    @SerializedName("response_message")
    @Expose
    private String responseMessage;

    @SerializedName("status")
    @Expose
    private String status;

    @SerializedName("response_code")
    @Expose
    private String responseCode;

    @SerializedName("device_id")
    @Expose
    private String deviceId;

    @SerializedName("language")
    @Expose
    private String language;

    @SerializedName("service_command")
    @Expose
    private String serviceCommand;

    @SerializedName("signature")
    @Expose
    private String signature;

    @SerializedName("merchant_identifier")
    @Expose
    private String merchantIdentifier;

    @SerializedName("eci")
    @Expose
    private String eci;

    @SerializedName("card_number")
    @Expose
    private String cardNumber;

    @SerializedName("fort_id")
    @Expose
    private String fortId;

    @SerializedName("customer_email")
    @Expose
    private String customerEmail;

    @SerializedName("customer_ip")
    @Expose
    private String customerIp;

    @SerializedName("currency")
    @Expose
    private String currency;

    @SerializedName("amount")
    @Expose
    private String amount;

    @SerializedName("merchant_reference")
    @Expose
    private String merchantReference;

    @SerializedName("command")
    @Expose
    private String command;

    @SerializedName("payment_option")
    @Expose
    private String paymentOption;

    @SerializedName("expiry_date")
    @Expose
    private String expiryDate;

    @SerializedName("authorization_code")
    @Expose
    private String authorizationCode;

    @SerializedName("settlement_reference")
    @Expose
    private String settlementReference;

    @SerializedName("customer_name")
    @Expose
    private String customerName;

    public String getPaymentResponse() {
        return paymentResponse;
    }

    public void setPaymentResponse(String paymentResponse) {
        this.paymentResponse = paymentResponse;
    }

    public String getAccessCode() {
        return accessCode;
    }

    public void setAccessCode(String accessCode) {
        this.accessCode = accessCode;
    }

    public String getSdkToken() {
        return sdkToken;
    }

    public void setSdkToken(String sdkToken) {
        this.sdkToken = sdkToken;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getServiceCommand() {
        return serviceCommand;
    }

    public void setServiceCommand(String serviceCommand) {
        this.serviceCommand = serviceCommand;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getMerchantIdentifier() {
        return merchantIdentifier;
    }

    public void setMerchantIdentifier(String merchantIdentifier) {
        this.merchantIdentifier = merchantIdentifier;
    }

    public String getEci() {
        return eci;
    }

    public void setEci(String eci) {
        this.eci = eci;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getFortId() {
        return fortId;
    }

    public void setFortId(String fortId) {
        this.fortId = fortId;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerIp() {
        return customerIp;
    }

    public void setCustomerIp(String customerIp) {
        this.customerIp = customerIp;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getMerchantReference() {
        return merchantReference;
    }

    public void setMerchantReference(String merchantReference) {
        this.merchantReference = merchantReference;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
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

    public String getAuthorizationCode() {
        return authorizationCode;
    }

    public void setAuthorizationCode(String authorizationCode) {
        this.authorizationCode = authorizationCode;
    }

    public String getSettlementReference() {
        return settlementReference;
    }

    public void setSettlementReference(String settlementReference) {
        this.settlementReference = settlementReference;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.paymentResponse);
        dest.writeString(this.accessCode);
        dest.writeString(this.sdkToken);
        dest.writeString(this.responseMessage);
        dest.writeString(this.status);
        dest.writeString(this.responseCode);
        dest.writeString(this.deviceId);
        dest.writeString(this.language);
        dest.writeString(this.serviceCommand);
        dest.writeString(this.signature);
        dest.writeString(this.merchantIdentifier);
        dest.writeString(this.eci);
        dest.writeString(this.cardNumber);
        dest.writeString(this.fortId);
        dest.writeString(this.customerEmail);
        dest.writeString(this.customerIp);
        dest.writeString(this.currency);
        dest.writeString(this.amount);
        dest.writeString(this.merchantReference);
        dest.writeString(this.command);
        dest.writeString(this.paymentOption);
        dest.writeString(this.expiryDate);
        dest.writeString(this.authorizationCode);
        dest.writeString(this.settlementReference);
        dest.writeString(this.customerName);
    }

    public PayFortData() {
    }

    protected PayFortData(Parcel in) {
        this.paymentResponse = in.readString();
        this.accessCode = in.readString();
        this.sdkToken = in.readString();
        this.responseMessage = in.readString();
        this.status = in.readString();
        this.responseCode = in.readString();
        this.deviceId = in.readString();
        this.language = in.readString();
        this.serviceCommand = in.readString();
        this.signature = in.readString();
        this.merchantIdentifier = in.readString();
        this.eci = in.readString();
        this.cardNumber = in.readString();
        this.fortId = in.readString();
        this.customerEmail = in.readString();
        this.customerIp = in.readString();
        this.currency = in.readString();
        this.amount = in.readString();
        this.merchantReference = in.readString();
        this.command = in.readString();
        this.paymentOption = in.readString();
        this.expiryDate = in.readString();
        this.authorizationCode = in.readString();
        this.settlementReference = in.readString();
        this.customerName = in.readString();
    }

    public static final Parcelable.Creator<PayFortData> CREATOR = new Parcelable.Creator<PayFortData>() {
        @Override
        public PayFortData createFromParcel(Parcel source) {
            return new PayFortData(source);
        }

        @Override
        public PayFortData[] newArray(int size) {
            return new PayFortData[size];
        }
    };
}
