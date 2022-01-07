package com.shakebugdemo;

import android.app.Activity;
import android.content.Intent;

import com.facebook.react.ReactActivity;
import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.ActivityEventListener;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.uimanager.ViewManager;
import com.softnoesis.shakebuglibrary.ShakeBugInitialize;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends ReactActivity {

  /**
   * Returns the name of the main component registered from JavaScript. This is used to schedule
   * rendering of the component.
   */
  @Override
  protected String getMainComponentName() {
    return "ShakeBugDemo";
  }
}

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
      new ShakeBugInitialize(activity,"<Your Key>");
    }
  }

  @Override
  public void onActivityResult(Activity activity, int requestCode, int resultCode, Intent data) {

  }

  @Override
  public void onNewIntent(Intent intent) {

  }
}

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
