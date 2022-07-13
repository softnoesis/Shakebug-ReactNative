# Shakebug-React Native

[![Maven Central](https://img.shields.io/maven-central/v/com.softnoesis.shakebug/ShakeBug.svg?label=Maven%20Central)](https://search.maven.org/search?q=g:com.softnoesis.shakebug)

Shakebug allows you to receive feedback from your beta testers or real users and improve the quality of your application in a simple way. Here users just need to shake their mobile and all the data regarding bugs & crashes can be seen by developers through their log in panel. It also helpful to analyse your users, session, location etc. Addition, you can add events on each action of your application and track it using this Shakebug framework.

Sign up for a service at https://www.shakebug.com

## Installation - Android

#### Gradle

Add this line to your build.gradle file.

```groovy
implementation 'com.softnoesis.shakebug:ShakeBug:<latest-version>'
```

#### Open package having MainActivity.java file and create **ShakeBugModule.java**

```java
import com.softnoesis.shakebuglibrary.ShakeBugInitialize;

class ShakeBugModule extends ReactContextBaseJavaModule implements ActivityEventListener {

  public ShakeBugModule(ReactApplicationContext reactContext) {
    super(reactContext);
    reactContext.addActivityEventListener(this);
    shakeBugInit();
  }

  @Override
  public String getName() {
    return "ShakeBugAndroid";
  }

  @ReactMethod
  public void shakeBugInit() {
    final Activity activity = getCurrentActivity();
    if (activity != null) {
      ShakeBug.initialize(this, "<Your Key>");
      // Be sure to replace `<Your Key>` with your application key which given by ShakeBug website.
    }
  }

  @Override
  public void onActivityResult(Activity activity, int requestCode, int resultCode, Intent data) {

  }

  @Override
  public void onNewIntent(Intent intent) {

  }
}
```

#### Now create **ShakeBugPackage.java**

```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class ShakeBugPackage implements ReactPackage {

  @Override
  public List<NativeModule> createNativeModules(ReactApplicationContext reactContext) {
    List<NativeModule> modules = new ArrayList<>();
    modules.add(new ShakeBugModule(reactContext));

    return  modules;
  }

  @Override
  public List<ViewManager> createViewManagers(ReactApplicationContext reactContext) {
    return Collections.emptyList();
  }
}
```

#### now open android/app/src/main/java/[...]/MainApplication.java You should find the getPackages() method looks like the below snippet. You just need to add shakeBugPackage to List\<ReactPackage>

```java
@Override
        protected List<ReactPackage> getPackages() {
          @SuppressWarnings("UnnecessaryLocalVariable")
          List<ReactPackage> packages = new PackageList(this).getPackages();
          // Packages that cannot be autolinked yet can be added manually here, for example:
          packages.add(new ShakeBugPackage());
          return packages;
        }
```

#### After this you just have call ShakeBugInit update App.js as shown in below image

```javascript
import React, {useEffect} from 'react';
import {NativeModules} from 'react-native';

const App = () => {

  useEffect(() => {
    NativeModules.ShakeBugAndroid.shakeBugInit()
  }, []);

  return (
   ...
  )
}


export default App;
```

## Optional Settings

1. If you want add event to any screen or activity use following methods

**Java**
```java
ShakeBug.getInstance().addEventKey(this,"<Key>","<Key Value>"); //pass any key or value
```

**Kotlin**
```kotlin
ShakeBug.getInstance().addEventKey(this,"<Key>","<Key Value>") // pass any key or value
```
   
2. Add the following for enabling/disabling first time tutorial screen

**Java**
```java
ShakeBug.getInstance().showTutorialScreenFirstTime(true); // Default value True
```

**Kotlin**
```kotlin
ShakeBug.getInstance().showTutorialScreenFirstTime(true) // Default value True
```

## Usage

Build & run your app. Once your app is running, shake your device to report a bug! Bug/Crash reports are sent directly to login panel of Shakebug.com and also notify on your registered email address.


## Contact
Visit on: [https://www.shakebug.com](https://www.shakebug.com)

Contact us on support@shakebug.com in case of any use.
