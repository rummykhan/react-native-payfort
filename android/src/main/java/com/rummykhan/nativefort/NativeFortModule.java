
package com.rummykhan.nativefort;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;
import com.payfort.fort.android.sdk.base.callbacks.FortCallBackManager;
import com.payfort.fort.android.sdk.base.callbacks.FortCallback;
import java.util.*;
import com.payfort.fort.android.sdk.activities.InitSecureConnectionActivity;
import com.payfort.sdk.android.dependancies.models.FortRequest;
import android.content.Intent;

public class NativeFortModule extends ReactContextBaseJavaModule {

    private final ReactApplicationContext reactContext;

    public NativeFortModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
    }

    @Override
    public String getName() {
        return "NativeFort";
    }

    @Override
    public Map<String, Object> getConstants() {
        final Map<String, Object> constants = new HashMap<>();

        constants.put(Payfort.KEY_COMMAND_AUTHORIZATION, Payfort.COMMAND_AUTHORIZATION);
        constants.put(Payfort.KEY_COMMAND_PURCHASE, Payfort.COMMAND_PURCHASE);

        constants.put(Payfort.KEY_CURRENCY_AED, Payfort.CURRENCY_AED);
        constants.put(Payfort.KEY_CURRENCY_SAR, Payfort.CURRENCY_SAR);
        return constants;
    }

    //TODO: Add language to Exposed constants
    @ReactMethod
    public void sendCommand(String command,
                            String amount,
                            String currency,
                            String email,
                            String currentLanguage,
                            String merchantIdentifier,
                            String accessCode,
                            String shaRequestPhrase,
                            String shaResponsePhrase,
                            boolean isSandBox,
                            Promise promise
    ) {
        try {

            PayFortData payFortData = new PayFortData();
            payFortData.setCommand(command);
            payFortData.setAmount(amount);
            payFortData.setCurrency(currency);
            payFortData.setCustomerEmail(email);
            payFortData.setLanguage(currentLanguage);
            payFortData.setMerchantReference(String.valueOf(System.currentTimeMillis()));

            PayFortPayment payFortPayment = new PayFortPayment(
                    isSandBox,
                    this.reactContext.getCurrentActivity(),
                    currentLanguage,
                    FortCallback.Factory.create(),
                    promise
            );

            payFortPayment.setMerchantIdentifier(merchantIdentifier);
            payFortPayment.setAccessCode(accessCode);
            payFortPayment.setShaRequestPhrase(shaRequestPhrase);
            payFortPayment.setShaResponsePhrase(shaResponsePhrase);

            payFortPayment.requestForPayment(payFortData);

        } catch (Exception e) {
            promise.reject(e.getMessage(), Payfort.PURCHASE_EXCEPTION);
        }
    }

}