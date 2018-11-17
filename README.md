
# react-native-fort

## Getting started

`$ npm install react-native-fort --save`

### Mostly automatic installation

`$ react-native link react-native-fort`

### Manual installation


#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-fort` and add `NativeFort.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libNativeFort.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)<

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

#### Windows
[Read it! :D](https://github.com/ReactWindows/react-native)

1. In Visual Studio add the `NativeFort.sln` in `node_modules/react-native-fort/windows/NativeFort.sln` folder to their solution, reference from their app.
2. Open up your `MainPage.cs` app
  - Add `using Native.Fort.NativeFort;` to the usings at the top of the file
  - Add `new NativeFortPackage()` to the `List<IReactPackage>` returned by the `Packages` method


## Usage
```javascript
import NativeFort from 'react-native-fort';

// TODO: What to do with the module?
NativeFort;
```
  