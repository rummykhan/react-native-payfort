
# React Native Payfort (Android Only)

### Install

`$ npm install react-native-payfort --save`

### Automatic Installation

`$ react-native link react-native-payfort`


### Usage

`NativeFort` exposes some constants for Payfort Commands, Currency and Languages

```javascript

import NativeFort from 'react-native-payfort';

let merchantID = "xxxxx";
let accessCode = "xxxxx";
let shaRequest = "xxxxx";
let shaResponse = "xxxxx";

NativeFort.sendCommand(
    NativeFort.COMMAND_PURCHASE,
    "2000",
    NativeFort.CURRENCY_SAR,
    "rehan_manzoor@outlook.com",
    NativeFort.LANGUAGE_EN,
    merchantID,
    accessCode,
    shaRequest,
    shaResponse,
    true,
).then(function(response){
    console.log(response);
}).catch(function(error){
    console.log(error);
});

```

#### Response Format

```json
{
  "amount":"2000",
  "response_code":"14000",
  "card_number":"400555******0001",
  "card_holder_name":"Visa",
  "payment_option":"VISA",
  "expiry_date":"2105",
  "customer_ip":"4.8.1.2",
  "eci":"ECOMMERCE",
  "language":"en",
  "fort_id":"154244999500011151",
  "command":"PURCHASE",
  "response_message":"Success",
  "sdk_token":"7A63FCACAC1E23CBE053321E320AED27",
  "authorization_code":"819341",
  "merchant_reference":"1542450845349",
  "customer_email":"rehan_manzoor@outlook.com",
  "token_name":"79D4D15A30DE2401E053321E320A16E2",
  "currency":"SAR",
  "status":"14"
}
```

#### Constants
```javascript

// Commands
NativeFort.COMMAND_PURCHASE,
NativeFort.COMMAND_AUTHORIZATION,

// Currencies
NativeFort.CURRENCY_AED,
NativeFort.CURRENCY_SAR,

// Languages
NativeFort.LANGUAGE_EN,
NativeFort.LANGUAGE_AR,

```

#### Signature for sendCommand

```javscript

NativeFort.sendCommand(
    String payfortCommand,
    String amount, // you have to multiply the value with the currency decimal code according to ISO code 3. e.g. if amount is 2 multiply it by 100 and then pass
    String currency,
    String email,
    String language,
    String payfortMerchantID,
    String payfortAccessCode,
    String payfortShaRequest,
    String payfortShaResponse,
    boolean isSandbox
)

```

### Contact

[rehan_manzoor@outlook.com](mailto:rehan_manzoor@outlook.com)
  