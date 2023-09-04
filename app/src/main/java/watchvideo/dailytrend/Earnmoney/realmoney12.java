package watchvideo.dailytrend.Earnmoney;

import static android.content.Context.CONNECTIVITY_SERVICE;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Build;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

import java.util.List;


public class realmoney12 {
    private static dailyearnmoney progressDialog;
    private static realmoney12 mInstance;
    public InterstitialAd interstitial1;
    AdRequest adRequest;
    MyCallback myCallback;
    Activity activity;

    public static realmoney12 getInstance() {
        if (mInstance == null) {
            mInstance = new realmoney12();
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

        } else if (
                connec.getNetworkInfo(0).getState() == android.net.NetworkInfo.State.DISCONNECTED ||
                        connec.getNetworkInfo(1).getState() == android.net.NetworkInfo.State.DISCONNECTED) {
            return false;
        }

        return false;
    }

    public void loadintertialads(final Activity context, String ads_id, MyCallback myCallback1) {
        this.myCallback = myCallback1;
        this.activity = context;

        AdRequest adRequest = new AdRequest.Builder().build();
        InterstitialAd.load(context, ads_id, adRequest,
                new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                        // The mInterstitialAd reference will be null until
                        // an ad is loaded.
                        interstitial1 = interstitialAd;
                        Log.e("TAG", "onAdLoaded");
                        if (progressDialog != null && progressDialog.isShowing()) {
                            progressDialog.dismiss();
                            progressDialog = null;
                        }
                        if (interstitial1 != null) {
                            interstitial1.show(context);
                        } else {
                        }
                        interstitialAd.setFullScreenContentCallback(
                                new FullScreenContentCallback() {
                                    @Override
                                    public void onAdDismissedFullScreenContent() {

                                        interstitial1 = null;
                                        Log.d("TAG", "The ad was dismissed.");
                                        if (myCallback != null) {
                                            myCallback.callbackCall();
                                            myCallback = null;
                                        }
                                    }

                                    @Override
                                    public void onAdFailedToShowFullScreenContent(AdError adError) {
                                        interstitial1 = null;
                                        Log.d("TAG", "The ad failed to show.");
                                    }

                                    @Override
                                    public void onAdShowedFullScreenContent() {

                                        Log.d("TAG", "The ad was shown.");
                                    }
                                });
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {

                        Log.e("TAG", loadAdError.getMessage());
                        interstitial1 = null;
                        if (progressDialog != null && progressDialog.isShowing()) {
                            progressDialog.dismiss();
                            progressDialog = null;
                        }

                        if (myCallback != null) {
                            myCallback.callbackCall();
                            myCallback = null;
                        }
                        String error =
                                String.format(
                                        "domain: %s, code: %d, message: %s",
                                        loadAdError.getDomain(), loadAdError.getCode(), loadAdError.getMessage());
                    }
                });

        displayInterstitial(context, myCallback1);
    }


    public void displayInterstitial(Activity context, MyCallback _myCallback) {
        this.myCallback = _myCallback;
        if (interstitial1 != null) {
            interstitial1.show(context);
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