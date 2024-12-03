# Shakebug-React Native

[![Maven Central](https://img.shields.io/maven-central/v/com.softnoesis.shakebug/ShakeBug.svg?label=Maven%20Central)](https://search.maven.org/search?q=g:com.softnoesis.shakebug)

Shakebug allows you to receive feedback from your beta testers or real users and improve the quality of your application in a simple way. Here users just need to shake their mobile and all the data regarding bugs & crashes can be seen by developers through their log in panel. It also helpful to analyse your users, session, location etc. Addition, you can add events on each action of your application and track it using this Shakebug framework.

Sign up for a service at https://www.shakebug.com

## npm

Navigate to your React Native project directory and install shakebug-react-native

```groovy
npm install shakebug-react-native
```

Or if you prefer to use Yarn instead of npm:

```groovy
yarn add shakebug-react-native
```

## Installation - Android

#### Gradle

Add this line to your build.gradle file.

```groovy
implementation 'com.softnoesis.shakebug:ShakeBug:<latest-version>'
```

#### Open package having MainActivity.java file and create **ShakeBugModule.java**

```java
import com.softnoesis.shakebuglibrary.ShakeBug; // this
@Override
    protected void onCreate(Bundle savedInstanceState) {
       ...
       ShakeBug.sharedInstance().initiateWithKey(this, “”); //this
    }
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
