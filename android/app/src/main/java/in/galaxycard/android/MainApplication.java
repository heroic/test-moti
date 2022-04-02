package in.galaxycard.android;

import android.app.Application;
import android.content.Context;
import android.content.IntentFilter;

import com.bugsnag.android.Bugsnag;
import com.facebook.react.PackageList;
import com.facebook.react.ReactApplication;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.JSIModulePackage;
import com.facebook.soloader.SoLoader;
import com.microsoft.codepush.react.CodePush;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import io.rumors.reactnativesettings.receivers.AirplaneModeReceiver;
import io.rumors.reactnativesettings.receivers.GpsLocationReceiver;

public class MainApplication extends Application implements ReactApplication {

    private final ReactNativeHost mReactNativeHost =
            new ReactNativeHost(this) {
                @Override
                public boolean getUseDeveloperSupport() {
                    return BuildConfig.DEBUG;
                }

                @Override
                protected List<ReactPackage> getPackages() {
                    @SuppressWarnings("UnnecessaryLocalVariable")
                    List<ReactPackage> packages = new PackageList(this).getPackages();
                    // Packages that cannot be autolinked yet can be added manually here, for example:
                    // packages.add(new MyReactNativePackage());
                    packages.add(new CodePush(getString(R.string.CodePushDeploymentKey), MainApplication.this, BuildConfig.DEBUG));
                    return packages;
                }

                @Override
                protected String getJSMainModuleName() {
                    return "index";
                }

                @Override
                protected JSIModulePackage getJSIModulePackage() {
                    return new GalaxyCardJSIModulePackage();
                }

                @Override
                protected String getJSBundleFile() {
                    return CodePush.getJSBundleFile();
                }
            };

    /**
     * Loads Flipper in React Native templates. Call this in the onCreate method with something like
     * initializeFlipper(this, getReactNativeHost().getReactInstanceManager());
     *
     * @param context
     * @param reactInstanceManager
     */
    private static void initializeFlipper(
            Context context, ReactInstanceManager reactInstanceManager) {
        if (BuildConfig.DEBUG) {
            try {
        /*
         We use reflection here to pick up the class that initializes Flipper,
        since Flipper library is not available in release mode
        */
                Class<?> aClass = Class.forName("in.galaxycard.android.ReactNativeFlipper");
                aClass
                        .getMethod("initializeFlipper", Context.class, ReactInstanceManager.class)
                        .invoke(null, context, reactInstanceManager);
            } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public ReactNativeHost getReactNativeHost() {
        return mReactNativeHost;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        SoLoader.init(this, /* native exopackage */ false);
        SoLoader.loadLibrary("bugsnag-ndk");
        SoLoader.loadLibrary("bugsnag-plugin-android-anr");

        Bugsnag.start(this);

        initializeFlipper(this, getReactNativeHost().getReactInstanceManager());

        registerReceiver(new GpsLocationReceiver(), new IntentFilter("android.location.PROVIDERS_CHANGED"));
        registerReceiver(new AirplaneModeReceiver(), new IntentFilter("android.intent.action.AIRPLANE_MODE"));
    }
}
