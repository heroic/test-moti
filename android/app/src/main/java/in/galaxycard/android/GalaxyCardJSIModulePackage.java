package in.galaxycard.android;

import com.facebook.react.bridge.JSIModuleSpec;
import com.facebook.react.bridge.JavaScriptContextHolder;
import com.facebook.react.bridge.ReactApplicationContext;
import com.mrousavy.jsi.contacts.JsiContactsModule;
import com.reactnativemmkv.MmkvModule;
import com.swmansion.reanimated.ReanimatedJSIModulePackage;

import java.util.List;

// TODO: Remove all of this when MMKV and Reanimated can be autoinstalled (maybe RN 0.67)
public class GalaxyCardJSIModulePackage extends ReanimatedJSIModulePackage {
    @Override
    public List<JSIModuleSpec> getJSIModules(ReactApplicationContext reactApplicationContext, JavaScriptContextHolder jsContext) {
       JsiContactsModule.install(reactApplicationContext);
       return super.getJSIModules(reactApplicationContext, jsContext);
    }
}
