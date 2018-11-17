
# react-native-fort

### Install using

`$ npm install react-native-fort --save`

### Automatic Installation

`$ react-native link react-native-fort`


### Manual Installation

#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.rummykhan.nativefort.NativeFortPackage;` to the imports at the top of the file
  - Add `new NativeFortPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-fort'
  	project(':react-native-fort').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-fort/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-fort')
  	```

### Usage

`NativeFort` exposes some constants for Payfort Commands, Currency and Languages

#### Commands
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


```javscript

// Signature for sendCommand

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


```javascript

import NativeFort from 'react-native-fort';

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

### Contact

[rehan_manzoor@outlook.com](mailto:rehan_manzoor@outlook.com)
  