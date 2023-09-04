package watchvideo.dailytrend.Earnmoney;

import static android.content.Context.CONNECTIVITY_SERVICE;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.facebook.ads.AbstractAdListener;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.InterstitialAd;

import java.util.List;

public class realmoney21 {

    private static dailyearnmoney progressDialog;
    private static realmoney21 mInstance;
    MyCallback myCallback;
    Activity activity;
    private InterstitialAd interstitialAd;

    public static realmoney21 getInstance() {
        if (mInstance == null) {
            mInstance = new realmoney21();
        }
        return mInstance;
    }

    public static boolean isInternetOn(Context con) {

        ConnectivityManager connec = (ConnectivityManager) con.getSystemService(CONNECTIVITY_SERVICE);

        if (connec.getNetworkInfo(0).getState() == android.net.NetworkInfo.State.CONNECTED ||
                connec.getNetworkInfo(0).getState() == android.net.NetworkInfo.State.CONNECTING ||
                connec.getNetworkInfo(1).getState() == android.net.NetworkInfo.State.CONNECTING ||
                connec.getNetworkInfo(1).getState() == android.net.NetworkInfo.State.CONNECTED) {

            return true;

        } else if (connec.getNetworkInfo(0).getState() == android.net.NetworkInfo.State.DISCONNECTED ||
                connec.getNetworkInfo(1).getState() == android.net.NetworkInfo.State.DISCONNECTED) {
            return false;
        }

        return false;
    }

    public void loadintertialads(final Activity context, String ads_id, MyCallback myCallback1) {
        this.myCallback = myCallback1;
        this.activity = context;

        interstitialAd = new InterstitialAd(context, ads_id);
        AbstractAdListener adListener = new AbstractAdListener() {
            @Override
            public void onError(Ad ad, AdError error) {

                if (progressDialog != null && progressDialog.isShowing()) {
                    progressDialog.dismiss();
                    progressDialog = null;
                }

                if (myCallback != null) {
                    myCallback.callbackCall();
                    myCallback = null;
                }
            }

            @RequiresApi(api = Build.VERSION_CODES.Q)
            @Override
            public void onAdLoaded(Ad ad) {
                super.onAdLoaded(ad);

                if (progressDialog != null && progressDialog.isShowing()) {
                    progressDialog.dismiss();
                    progressDialog = null;
                }

                if (interstitialAd != null) {
                    if (interstitialAd.isAdLoaded()) {
                        if (!isAppIsInBackground(context)) {
                            interstitialAd.show();
                        }
                    }
                }
            }

            @Override
            public void onAdClicked(Ad ad) {
                super.onAdClicked(ad);
            }

            @Override
            public void onInterstitialDisplayed(Ad ad) {
                super.onInterstitialDisplayed(ad);

            }

            @Override
            public void onInterstitialDismissed(Ad ad) {
                super.onInterstitialDismissed(ad);
                if (myCallback != null) {
                    myCallback.callbackCall();
                    myCallback = null;
                }

            }
        };

        InterstitialAd.InterstitialLoadAdConfig interstitialLoadAdConfig = interstitialAd.buildLoadAdConfig()
                .withAdListener(adListener)
                .build();
        interstitialAd.loadAd(interstitialLoadAdConfig);


        displayInterstitial(context, myCallback1);
    }


    public void displayInterstitial(Context context, MyCallback _myCallback) {
        this.myCallback = _myCallback;
        if (interstitialAd != null) {
            if (interstitialAd.isAdLoaded()) {
                interstitialAd.show();
            } else {
                progressDialog = new dailyearnmoney(activity);

                if (!((Activity) context).isFinishing()) {
                    try {
                        if (progressDialog != null) {
                            progressDialog.dismiss();
                        }
                        progressDialog.show();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    public boolean isAppIsInBackground(Context context) {
        boolean isInBackground = true;
        ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT_WATCH) {
            List<ActivityManager.RunningAppProcessInfo> runningProcesses = am.getRunningAppProcesses();
            for (ActivityManager.RunningAppProcessInfo processInfo : runningProcesses) {
                if (processInfo.importance == ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND) {
                    for (String activeProcess : processInfo.pkgList) {
                        if (activeProcess.equals(context.getPackageName())) {
                            isInBackground = false;
                        }
                    }
                }
            }
        } else {
            List<ActivityManager.RunningTaskInfo> taskInfo = am.getRunningTasks(1);
            ComponentName componentInfo = taskInfo.get(0).topActivity;
            if (componentInfo.getPackageName().equals(context.getPackageName())) {
                isInBackground = false;
            }
        }

        return isInBackground;
    }


    public interface MyCallback {
        void callbackCall();
    }


}
