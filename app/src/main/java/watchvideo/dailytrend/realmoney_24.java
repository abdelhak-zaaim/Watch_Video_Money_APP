package watchvideo.dailytrend;

import static watchvideo.dailytrend.Earnmoney_2.EarnMoney_85.decryptedString;

import android.annotation.SuppressLint;
import android.app.Application;
import android.app.Dialog;
import android.app.NotificationManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.facebook.ads.AudienceNetworkAds;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;
import com.onesignal.OneSignal;
import com.tonyodev.fetch2.DefaultFetchNotificationManager;
import com.tonyodev.fetch2.Fetch;
import com.tonyodev.fetch2.FetchConfiguration;
import com.tonyodev.fetch2.FetchListener;
import com.tonyodev.fetch2.NetworkType;
import com.tonyodev.fetch2core.Downloader;
import com.tonyodev.fetch2okhttp.OkHttpDownloader;
import com.valdesekamdem.library.mdtoast.MDToast;
import watchvideo.dailytrend.Earnmoney.earnmoney;
import watchvideo.dailytrend.Earnmoney.earnmoneyapp;
import watchvideo.dailytrend.Earnmoney.realmoney11;
import watchvideo.dailytrend.Earnmoney_6.RealMoney_104.EarnMoney_103;
import watchvideo.dailytrend.Realmoney_3.realmoney_35.earnmoney_33.realmoney_27;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Random;

@SuppressLint("WrongConstant")
public class realmoney_24 extends Application {

    public static long CountDown = 0;
    public static String Extra_Coin_Message = "Your Lucky Slot Machine Is Available Try It And Get More Coins For Earn Real USD Dollar Gift Card.";
    public static String Flip_Card_Message = "Your Lucky Flip Card Is Available Try It And Get More Coins For Win USD Dollar Gift Card.";
    public static final int GROUP_ID = -1246295935;
    public static String Lucky_Spin_Message = "Your Lucky Spin Is Available Try It And Get More Coins For Earn Real USD Dollar Gift Card.";
    public static final int NOTIFICATION_ID = (new Random().nextInt(601) + 200);
    public static String Scratch_Card_Message = "Your Scratch Card Is Available Try It And Get More Coins For Win USD Dollar Gift Card.";
    public static boolean ShowDailyUsage = true;
    public static boolean abortConnection = false;
    private static GoogleAnalytics analytics = null;
    public static int connection_status = 0;
    public static Context context = null;
    public static long device_created = 0;
    public static String device_id = null;
    private static realmoney_24 fire_base_app = null;
    public static String fire_base_evening_message = "Win Real USD Dollar \u20b9100 To \u20b910000 By Playing Some Games.";
    public static String fire_base_morning_message = "Win Real USD Dollar \u20b9350 To \u20b920000 By Watching Videos.";
    public static String firebase_key = decryptedString;
    public static boolean from_login;
    public static boolean h;
    public static boolean hasFile = false;
    public static boolean isStart;
    public static boolean is_first;
    public static boolean is_online;
    public static Tracker tracker;
    public ArrayList<realmoney_27> Vlanguages = new ArrayList<>();
    public Fetch fetch;
    public FetchConfiguration fetchConfiguration;
    public FetchListener fetchListener;
    NotificationManager manager;


    @SuppressLint("MissingPermission")
    public static boolean isOnline(Context context2) {
       ConnectivityManager connectivityManager = (ConnectivityManager) context2.getSystemService("connectivity");
         NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnectedOrConnecting() || !connectivityManager.getActiveNetworkInfo().isAvailable() || !connectivityManager.getActiveNetworkInfo().isConnected()) {
            is_online = false;
            return false;
        }
        is_online = true;
        return true;
    }


    public static synchronized realmoney_24 getInstance() {
        realmoney_24 appClass;
        synchronized (realmoney_24.class) {
            synchronized (realmoney_24.class) {
                synchronized (realmoney_24.class) {
                    appClass = fire_base_app;
                }
                return appClass;
            }
        }
    }


    private static final String INSTALL_PREF = "new_install";
    private static earnmoneyapp earnmoneyapp;

    public static boolean checkNewInstall(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(context.getPackageName(), 0);
        boolean z = sharedPreferences.getBoolean(INSTALL_PREF, false);
        if (!z) {
            sharedPreferences.edit().putBoolean(INSTALL_PREF, true).commit();
        }
        return z;
    }


    @SuppressLint("MissingPermission")
    @Override
    public void onCreate() {
        super.onCreate();
        fire_base_app = this;
        context = this;
        if (this == null) {
            context = this;
        }


        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE);
        OneSignal.initWithContext(this);
        OneSignal.setAppId("");

        MobileAds.initialize(
                this,
                new OnInitializationCompleteListener() {
                    @Override
                    public void onInitializationComplete(InitializationStatus initializationStatus) {
                    }
                });

        earnmoneyapp = new earnmoneyapp(this);
        AudienceNetworkAds.initialize(this);

//        getResponsead();
//       getResponse();

        this.fetchConfiguration = new FetchConfiguration.Builder(this).enableAutoStart(true).createDownloadFileOnEnqueue(false).enableRetryOnNetworkGain(true).setDownloadConcurrentLimit(2).setAutoRetryMaxAttempts(3).setHasActiveDownloadsCheckInterval(30000).setProgressReportingInterval(50).setHttpDownloader(new OkHttpDownloader(Downloader.FileDownloaderType.PARALLEL)).setNamespace("ApplicationClass").setNotificationManager(new DefaultFetchNotificationManager(this) {
            @Override
            public Fetch getFetchInstanceForNamespace(String str) {
                return null;
            }
        }).setGlobalNetworkType(NetworkType.ALL).build();

        Fetch.Impl.setDefaultInstanceConfiguration(this.fetchConfiguration);
        Fetch instance = Fetch.Impl.getInstance(this.fetchConfiguration);
        this.fetch = instance;
        try {
            instance.resumeGroup(GROUP_ID);
        } catch (Exception e) {
            e.printStackTrace();
        }
        EarnMoney_103.Instance().initPref();
        analytics = GoogleAnalytics.getInstance(this);
        EarnMoney_103 Instance = EarnMoney_103.Instance();
        EarnMoney_103.Instance().getClass();
        if (Instance.getIntPref("rate_notification_count") < 5) {
            EarnMoney_103 Instance2 = EarnMoney_103.Instance();
            EarnMoney_103.Instance().getClass();
            EarnMoney_103 Instance3 = EarnMoney_103.Instance();
            EarnMoney_103.Instance().getClass();
            Instance2.putPref("rate_notification_count", Instance3.getIntPref("rate_notification_count") + 1);
            EarnMoney_103.Instance().savePref();
        }
        EarnMoney_103.Instance().getFullScreenLangList();
        EarnMoney_103.Instance().getLandscapeLangList();
        EarnMoney_103 Instance4 = EarnMoney_103.Instance();
        EarnMoney_103.Instance().getClass();
        Instance4.putPref("home_api_calling", 1);
        EarnMoney_103.Instance().savePref();

    }

    public static Context getContext() {
        return context;
    }

    public static GoogleAnalytics analytics() {
        return analytics;
    }

    public static Tracker tracker() {
        return tracker;
    }

    public static Context f() {
        return context;
    }

    public static Typeface ChangeTypeFaceITCKabelStd(Context context2) {
        return Typeface.createFromAsset(context2.getAssets(), "BRLNSDB.TTF");
    }

    public ArrayList<realmoney_27> getLanguages() {
        return this.Vlanguages;
    }

    public static void ShowSuccessToast(Context context2, String str) {
        MDToast.makeText(context2, str, MDToast.LENGTH_SHORT, 1).show();
    }

    public static void ShowInfoToast(Context context2, String str) {
        MDToast.makeText(context2, str, MDToast.LENGTH_SHORT, 0).show();
    }

    public static void ShowWarningToast(Context context2, String str) {
        MDToast.makeText(context2, str, MDToast.LENGTH_SHORT, 2).show();
    }

    public static void ShowErrorToast(Context context2, String str) {
        MDToast.makeText(context2, str, MDToast.LENGTH_SHORT, 3).show();
    }


    public static void RateApp(Context context2) {
        try {
            context = context2;
            ConformRateDialog(context2, earnmoney_21.rate_url + context.getPackageName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void ConformRateDialog(final Context context2, final String str) {
        final Dialog dialog = new Dialog(context2, R.style.TransparentBackground);
        dialog.requestWindowFeature(1);
        dialog.setContentView(R.layout.realmoneyspin);
        ((TextView) dialog.findViewById(R.id.btn_rate_now)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    context2.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                } catch (ActivityNotFoundException e) {
                    e.printStackTrace();
                }
                dialog.dismiss();
            }
        });

        ((TextView) dialog.findViewById(R.id.btn_cancel)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();

    }


    public static void ShareApp(Context context2) {
        try {
            context = context2;
            ConformShareDialog(context2, context.getResources().getString(R.string.app_name) + " :", earnmoney_21.rate_url + context.getPackageName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void ConformShareDialog(Context context2, final String str, final String str2) {
        final Dialog dialog = new Dialog(context2, R.style.TransparentBackground);
        dialog.requestWindowFeature(1);
        dialog.setContentView(R.layout.spinandwin);
        ((TextView) dialog.findViewById(R.id.btn_share_now)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent("android.intent.action.SEND");
                    intent.setType("text/plain");
                    intent.putExtra("android.intent.extra.TEXT", str + "\n" + str2);
                    realmoney_24.context.startActivity(Intent.createChooser(intent, "Share via"));
                } catch (ActivityNotFoundException e) {
                    e.printStackTrace();
                }
                dialog.dismiss();
            }
        });


        ((TextView) dialog.findViewById(R.id.btn_cancel)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();

    }


    public static void NoInternetDialog(Context context2) {
        final Dialog dialog = new Dialog(context2, R.style.TransparentBackground);
        dialog.requestWindowFeature(1);
        dialog.setContentView(R.layout.moneyapp);
        dialog.setCancelable(false);
        ((TextView) dialog.findViewById(R.id.btn_ok)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    private void responsedata(String str) {
        try {
            JSONArray jSONArray = new JSONObject(str).getJSONArray("data");
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);

                if (jSONObject.getString("Package").equalsIgnoreCase(getPackageName())) {

                    Log.e("ddd", "dddd");

                    earnmoney.ad_open = jSONObject.getString("ad_open");
                    earnmoney.quera_link = jSONObject.getString("quera_link");
                    earnmoney.qureka_visible = jSONObject.getBoolean("qureka_visible");
                    earnmoney.skip_page = jSONObject.getBoolean("skip_page");
                    earnmoney.sign_page = jSONObject.getBoolean("sign_page");
                    earnmoney.video_status = jSONObject.getBoolean("video_status");


                    // Inter
                    earnmoney.isAdOn = jSONObject.getBoolean("isAdOn");
                    earnmoney.ad_mode = jSONObject.getString("ad_mode");
                    earnmoney.admob_inter_id = jSONObject.getString("admob_inter_id");
                    earnmoney.facebook_inter_id = jSONObject.getString("facebook_inter_id");


                    // Inter
                    earnmoney.isAdOn = jSONObject.getBoolean("isAdOn");
                    earnmoney.ad_mode = jSONObject.getString("ad_mode");
                    earnmoney.admob_inter_id = jSONObject.getString("admob_inter_id");
                    earnmoney.facebook_inter_id = jSONObject.getString("facebook_inter_id");


                    // Inter
                    earnmoney.isAdOn = jSONObject.getBoolean("isAdOn");
                    earnmoney.ad_mode = jSONObject.getString("ad_mode");
                    earnmoney.admob_inter_id = jSONObject.getString("admob_inter_id");
                    earnmoney.facebook_inter_id = jSONObject.getString("facebook_inter_id");


                    // Inter
                    earnmoney.isAdOn = jSONObject.getBoolean("isAdOn");
                    earnmoney.ad_mode = jSONObject.getString("ad_mode");
                    earnmoney.admob_inter_id = jSONObject.getString("admob_inter_id");
                    earnmoney.facebook_inter_id = jSONObject.getString("facebook_inter_id");


                    // Inter
                    earnmoney.isAdOn = jSONObject.getBoolean("isAdOn");
                    earnmoney.ad_mode = jSONObject.getString("ad_mode");
                    earnmoney.admob_inter_id = jSONObject.getString("admob_inter_id");
                    earnmoney.facebook_inter_id = jSONObject.getString("facebook_inter_id");


                    // Inter
                    earnmoney.isAdOn = jSONObject.getBoolean("isAdOn");
                    earnmoney.ad_mode = jSONObject.getString("ad_mode");
                    earnmoney.admob_inter_id = jSONObject.getString("admob_inter_id");
                    earnmoney.facebook_inter_id = jSONObject.getString("facebook_inter_id");


                    // Inter
                    earnmoney.isAdOn = jSONObject.getBoolean("isAdOn");
                    earnmoney.ad_mode = jSONObject.getString("ad_mode");
                    earnmoney.admob_inter_id = jSONObject.getString("admob_inter_id");
                    earnmoney.facebook_inter_id = jSONObject.getString("facebook_inter_id");


                    // Inter
                    earnmoney.isAdOn = jSONObject.getBoolean("isAdOn");
                    earnmoney.ad_mode = jSONObject.getString("ad_mode");
                    earnmoney.admob_inter_id = jSONObject.getString("admob_inter_id");
                    earnmoney.facebook_inter_id = jSONObject.getString("facebook_inter_id");


                    // Inter
                    earnmoney.isAdOn = jSONObject.getBoolean("isAdOn");
                    earnmoney.ad_mode = jSONObject.getString("ad_mode");
                    earnmoney.admob_inter_id = jSONObject.getString("admob_inter_id");
                    earnmoney.facebook_inter_id = jSONObject.getString("facebook_inter_id");


                    // Inter
                    earnmoney.isAdOn = jSONObject.getBoolean("isAdOn");
                    earnmoney.ad_mode = jSONObject.getString("ad_mode");
                    earnmoney.admob_inter_id = jSONObject.getString("admob_inter_id");
                    earnmoney.facebook_inter_id = jSONObject.getString("facebook_inter_id");


                    // Inter
                    earnmoney.isAdOn = jSONObject.getBoolean("isAdOn");
                    earnmoney.ad_mode = jSONObject.getString("ad_mode");
                    earnmoney.admob_inter_id = jSONObject.getString("admob_inter_id");
                    earnmoney.facebook_inter_id = jSONObject.getString("facebook_inter_id");


                    // Inter
                    earnmoney.isAdOn = jSONObject.getBoolean("isAdOn");
                    earnmoney.ad_mode = jSONObject.getString("ad_mode");
                    earnmoney.admob_inter_id = jSONObject.getString("admob_inter_id");
                    earnmoney.facebook_inter_id = jSONObject.getString("facebook_inter_id");


                    // Inter
                    earnmoney.isAdOn = jSONObject.getBoolean("isAdOn");
                    earnmoney.ad_mode = jSONObject.getString("ad_mode");
                    earnmoney.admob_inter_id = jSONObject.getString("admob_inter_id");
                    earnmoney.facebook_inter_id = jSONObject.getString("facebook_inter_id");


                    // Inter
                    earnmoney.isAdOn = jSONObject.getBoolean("isAdOn");
                    earnmoney.ad_mode = jSONObject.getString("ad_mode");
                    earnmoney.admob_inter_id = jSONObject.getString("admob_inter_id");
                    earnmoney.facebook_inter_id = jSONObject.getString("facebook_inter_id");


                    // Inter
                    earnmoney.isAdOn = jSONObject.getBoolean("isAdOn");
                    earnmoney.ad_mode = jSONObject.getString("ad_mode");
                    earnmoney.admob_inter_id = jSONObject.getString("admob_inter_id");
                    earnmoney.facebook_inter_id = jSONObject.getString("facebook_inter_id");



                    // Inter
                    earnmoney.isAdOn = jSONObject.getBoolean("isAdOn");
                    earnmoney.ad_mode = jSONObject.getString("ad_mode");
                    earnmoney.admob_inter_id = jSONObject.getString("admob_inter_id");
                    earnmoney.facebook_inter_id = jSONObject.getString("facebook_inter_id");



                    // Inter
                    earnmoney.isAdOn = jSONObject.getBoolean("isAdOn");
                    earnmoney.ad_mode = jSONObject.getString("ad_mode");
                    earnmoney.admob_inter_id = jSONObject.getString("admob_inter_id");
                    earnmoney.facebook_inter_id = jSONObject.getString("facebook_inter_id");


                    // Inter
                    earnmoney.isAdOn = jSONObject.getBoolean("isAdOn");
                    earnmoney.ad_mode = jSONObject.getString("ad_mode");
                    earnmoney.admob_inter_id = jSONObject.getString("admob_inter_id");
                    earnmoney.facebook_inter_id = jSONObject.getString("facebook_inter_id");


                    // Inter
                    earnmoney.isAdOn = jSONObject.getBoolean("isAdOn");
                    earnmoney.ad_mode = jSONObject.getString("ad_mode");
                    earnmoney.admob_inter_id = jSONObject.getString("admob_inter_id");
                    earnmoney.facebook_inter_id = jSONObject.getString("facebook_inter_id");


                    // Inter
                    earnmoney.isAdOn = jSONObject.getBoolean("isAdOn");
                    earnmoney.ad_mode = jSONObject.getString("ad_mode");
                    earnmoney.admob_inter_id = jSONObject.getString("admob_inter_id");
                    earnmoney.facebook_inter_id = jSONObject.getString("facebook_inter_id");


                    // Inter
                    earnmoney.isAdOn = jSONObject.getBoolean("isAdOn");
                    earnmoney.ad_mode = jSONObject.getString("ad_mode");
                    earnmoney.admob_inter_id = jSONObject.getString("admob_inter_id");
                    earnmoney.facebook_inter_id = jSONObject.getString("facebook_inter_id");


                    //Inter
                    earnmoney.isAdOn = jSONObject.getBoolean("isAdOn");
                    earnmoney.ad_mode = jSONObject.getString("ad_mode");
                    earnmoney.admob_inter_id = jSONObject.getString("admob_inter_id");
                    earnmoney.facebook_inter_id = jSONObject.getString("facebook_inter_id");


                    //Inter
                    earnmoney.isAdOn = jSONObject.getBoolean("isAdOn");
                    earnmoney.ad_mode = jSONObject.getString("ad_mode");
                    earnmoney.admob_inter_id = jSONObject.getString("admob_inter_id");
                    earnmoney.facebook_inter_id = jSONObject.getString("facebook_inter_id");


                    //Inter
                    earnmoney.isAdOn = jSONObject.getBoolean("isAdOn");
                    earnmoney.ad_mode = jSONObject.getString("ad_mode");
                    earnmoney.admob_inter_id = jSONObject.getString("admob_inter_id");
                    earnmoney.facebook_inter_id = jSONObject.getString("facebook_inter_id");





                    //Banner
                    earnmoney.isAdOn = jSONObject.getBoolean("isAdOn");
                    earnmoney.ad_mode = jSONObject.getString("ad_mode");
                    earnmoney.admob_banner_id = jSONObject.getString("admob_banner_id");
                    earnmoney.facebook_banner_id = jSONObject.getString("facebook_banner_id");


                    //Banner
                    earnmoney.isAdOn = jSONObject.getBoolean("isAdOn");
                    earnmoney.ad_mode = jSONObject.getString("ad_mode");
                    earnmoney.admob_banner_id = jSONObject.getString("admob_banner_id");
                    earnmoney.facebook_banner_id = jSONObject.getString("facebook_banner_id");


                    //Banner
                    earnmoney.isAdOn = jSONObject.getBoolean("isAdOn");
                    earnmoney.ad_mode = jSONObject.getString("ad_mode");
                    earnmoney.admob_banner_id = jSONObject.getString("admob_banner_id");
                    earnmoney.facebook_banner_id = jSONObject.getString("facebook_banner_id");


                    //Banner
                    earnmoney.isAdOn = jSONObject.getBoolean("isAdOn");
                    earnmoney.ad_mode = jSONObject.getString("ad_mode");
                    earnmoney.admob_banner_id = jSONObject.getString("admob_banner_id");
                    earnmoney.facebook_banner_id = jSONObject.getString("facebook_banner_id");


                    //Banner
                    earnmoney.isAdOn = jSONObject.getBoolean("isAdOn");
                    earnmoney.ad_mode = jSONObject.getString("ad_mode");
                    earnmoney.admob_banner_id = jSONObject.getString("admob_banner_id");
                    earnmoney.facebook_banner_id = jSONObject.getString("facebook_banner_id");


                    //Banner
                    earnmoney.isAdOn = jSONObject.getBoolean("isAdOn");
                    earnmoney.ad_mode = jSONObject.getString("ad_mode");
                    earnmoney.admob_banner_id = jSONObject.getString("admob_banner_id");
                    earnmoney.facebook_banner_id = jSONObject.getString("facebook_banner_id");


                    //Banner
                    earnmoney.isAdOn = jSONObject.getBoolean("isAdOn");
                    earnmoney.ad_mode = jSONObject.getString("ad_mode");
                    earnmoney.admob_banner_id = jSONObject.getString("admob_banner_id");
                    earnmoney.facebook_banner_id = jSONObject.getString("facebook_banner_id");


                    //Banner
                    earnmoney.isAdOn = jSONObject.getBoolean("isAdOn");
                    earnmoney.ad_mode = jSONObject.getString("ad_mode");
                    earnmoney.admob_banner_id = jSONObject.getString("admob_banner_id");
                    earnmoney.facebook_banner_id = jSONObject.getString("facebook_banner_id");

                    //Banner
                    earnmoney.isAdOn = jSONObject.getBoolean("isAdOn");
                    earnmoney.ad_mode = jSONObject.getString("ad_mode");
                    earnmoney.admob_banner_id = jSONObject.getString("admob_banner_id");
                    earnmoney.facebook_banner_id = jSONObject.getString("facebook_banner_id");


                    //Banner
                    earnmoney.isAdOn = jSONObject.getBoolean("isAdOn");
                    earnmoney.ad_mode = jSONObject.getString("ad_mode");
                    earnmoney.admob_banner_id = jSONObject.getString("admob_banner_id");
                    earnmoney.facebook_banner_id = jSONObject.getString("facebook_banner_id");






                    //Native
                    earnmoney.isAdOn = jSONObject.getBoolean("isAdOn");
                    earnmoney.ad_mode = jSONObject.getString("ad_mode");
                    earnmoney.admob_native_id = jSONObject.getString("admob_native_id");
                    earnmoney.facebook_native_id = jSONObject.getString("facebook_native_id");


                    //Native
                    earnmoney.isAdOn = jSONObject.getBoolean("isAdOn");
                    earnmoney.ad_mode = jSONObject.getString("ad_mode");
                    earnmoney.admob_native_id = jSONObject.getString("admob_native_id");
                    earnmoney.facebook_native_id = jSONObject.getString("facebook_native_id");


                    //Native
                    earnmoney.isAdOn = jSONObject.getBoolean("isAdOn");
                    earnmoney.ad_mode = jSONObject.getString("ad_mode");
                    earnmoney.admob_native_id = jSONObject.getString("admob_native_id");
                    earnmoney.facebook_native_id = jSONObject.getString("facebook_native_id");


                    //Native
                    earnmoney.isAdOn = jSONObject.getBoolean("isAdOn");
                    earnmoney.ad_mode = jSONObject.getString("ad_mode");
                    earnmoney.admob_native_id = jSONObject.getString("admob_native_id");
                    earnmoney.facebook_native_id = jSONObject.getString("facebook_native_id");


                    //Native
                    earnmoney.isAdOn = jSONObject.getBoolean("isAdOn");
                    earnmoney.ad_mode = jSONObject.getString("ad_mode");
                    earnmoney.admob_native_id = jSONObject.getString("admob_native_id");
                    earnmoney.facebook_native_id = jSONObject.getString("facebook_native_id");


                    //Native
                    earnmoney.isAdOn = jSONObject.getBoolean("isAdOn");
                    earnmoney.ad_mode = jSONObject.getString("ad_mode");
                    earnmoney.admob_native_id = jSONObject.getString("admob_native_id");
                    earnmoney.facebook_native_id = jSONObject.getString("facebook_native_id");


                    //Native
                    earnmoney.isAdOn = jSONObject.getBoolean("isAdOn");
                    earnmoney.ad_mode = jSONObject.getString("ad_mode");
                    earnmoney.admob_native_id = jSONObject.getString("admob_native_id");
                    earnmoney.facebook_native_id = jSONObject.getString("facebook_native_id");


                    //Native
                    earnmoney.isAdOn = jSONObject.getBoolean("isAdOn");
                    earnmoney.ad_mode = jSONObject.getString("ad_mode");
                    earnmoney.admob_native_id = jSONObject.getString("admob_native_id");
                    earnmoney.facebook_native_id = jSONObject.getString("facebook_native_id");

                }


            }


        } catch (JSONException e) {
            Log.e("GGG", e.toString());
            e.printStackTrace();
        }

    }


    private void getadapterresponse(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);

            Log.e("dcndc", str);
            for (int i = 1; i < jSONObject.length(); i++) {
                JSONObject jSONObject2 = jSONObject.getJSONObject(String.valueOf(i));
                String string = jSONObject2.getString("app_name");
                String string2 = jSONObject2.getString("app_icon");
                String string3 = jSONObject2.getString("app_package");
                Log.e("Respo", string);
                realmoney11 localAds = new realmoney11();
                localAds.setApp_icon(string2);
                localAds.setApp_name(string);
                localAds.setPackage_name(string3);

                if (getPackageName().equalsIgnoreCase(string3)) {

                } else {

                    earnmoney.models.add(localAds);

                }
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }


//    private void getResponse() {
//        new Retrofit.Builder().baseUrl(AppData.BASE_URL).addConverterFactory(ScalarsConverterFactory.create()).build().create(CallUrls.class).getdata("getcategories",getPackageName()).enqueue(new Callback<String>() {
//            @Override
//            public void onResponse(Call<String> call, Response<String> response) {
//                Log.i("Responsestringddd", response.body());
//                if (!response.isSuccessful()) {
//                    return;
//                }
//                if (response.body() != null) {
//                    Log.i("onSuccess", response.body());
//                    realmoney_24.this.getadapterresponse(response.body());
//                    return;
//                }
//                Log.i("onEmptyResponse", "Returned empty response");
//            }
//
//            @Override
//            public void onFailure(Call<String> call, Throwable th) {
//                Log.e("WEEE", th.getMessage());
//            }
//        });
//    }


//    private void getResponsead() {
//        new Retrofit.Builder().baseUrl(AppData.BASE_URL).addConverterFactory(ScalarsConverterFactory.create()).build().create(CallUrls.class).getad(getPackageName()).enqueue(new Callback<String>() {
//            @Override
//            public void onFailure(Call<String> call, Throwable th) {
//            }
//
//            @Override
//            public void onResponse(Call<String> call, Response<String> response) {
//                if (!response.isSuccessful()) {
//                    return;
//                }
//                if (response.body() != null) {
//                    Log.i("onSuccess", response.body());
//                    realmoney_24.this.responsedata(response.body());
//                    return;
//                }
//                Log.i("onEmptyResponse", "Returned empty response");
//            }
//        });
//    }


}
