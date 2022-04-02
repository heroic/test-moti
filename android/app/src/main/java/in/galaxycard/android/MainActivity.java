package in.galaxycard.android;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.bugsnag.android.Bugsnag;
import com.facebook.react.ReactActivity;
import com.facebook.react.ReactActivityDelegate;
import com.facebook.react.ReactRootView;
import com.scottyab.rootbeer.RootBeer;
import com.swmansion.gesturehandler.react.RNGestureHandlerEnabledRootView;

import org.jetbrains.annotations.NotNull;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends ReactActivity {
    private static final String MAIN_COMPONENT_NAME = "GalaxyCard";

    private View mSplashView;

    private Timer mTimer;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(null);
        mSplashView = LayoutInflater.from(this).inflate(R.layout.splash, null);
        ViewGroup.LayoutParams layoutParams = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        addContentView(mSplashView, layoutParams);
//    ((ViewGroup)findViewById(android.R.id.content)).addView(mSplashView);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Utils.hideUi(this);
        mTimer = new Timer();
        mTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                removeSplash();
            }
        }, 2000);
    }

    @Override
    public void onResume() {
        super.onResume();
        RootBeer rootBeer = new RootBeer(this);
        if (!BuildConfig.DEBUG && rootBeer.isRooted()) {
           finishAndRemoveTask();
        }
    }

    @Override
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    @Override
    public void onTrimMemory(int level) {
        Bugsnag.leaveBreadcrumb("Low on memory with level" + level);
    }

    @Override
    public void onRestart() {
        super.onRestart();
        Bugsnag.leaveBreadcrumb("restarting");
    }

    public void onJsReady() {
        mTimer.cancel();
        removeSplash();
    }

    private synchronized void removeSplash() {
        runOnUiThread(() -> {
            if (mSplashView != null && mSplashView.getParent() != null) {
                ((ViewGroup) mSplashView.getParent()).removeView(mSplashView);
            }
        });
    }

    @Override
    public String getMainComponentName() {
        return MAIN_COMPONENT_NAME;
    }

    @Override
    protected ReactActivityDelegate createReactActivityDelegate() {
        return new ReactActivityDelegate(this, getMainComponentName()) {
            @Override
            protected ReactRootView createRootView() {
                return new RNGestureHandlerEnabledRootView(MainActivity.this);
            }
        };
    }
}
