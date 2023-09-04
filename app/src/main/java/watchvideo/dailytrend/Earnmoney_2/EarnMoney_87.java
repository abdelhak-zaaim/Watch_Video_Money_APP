package watchvideo.dailytrend.Earnmoney_2;

import static watchvideo.dailytrend.Earnmoney_2.RealMoney_93.EMAIL;
import static watchvideo.dailytrend.Earnmoney.earnmoney.sign_page;
import static watchvideo.dailytrend.Earnmoney.earnmoney.skip_page;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;

import watchvideo.dailytrend.Earnmoney.earnmoney;

import watchvideo.dailytrend.Earnmoney.realmoney14;
import watchvideo.dailytrend.Earnmoney.realmoney12;
import watchvideo.dailytrend.Earnmoney.realmoney21;
import watchvideo.dailytrend.MyMoney;
import watchvideo.dailytrend.R;

public class EarnMoney_87 extends AppCompatActivity {
    MyMoney myMoney;

    private static final String remote_ads_on_off = "remote_ads_on_off";
    private static final String remote_ad_mode = "remote_ad_mode";

    private static final String remote_admob_banner_id = "remote_admob_banner_id";
    private static final String remote_facebook_banner_id = "remote_facebook_banner_id";
    private static final String remote_interrstitial_admob_id = "remote_interrstitial_admob_id";
    private static final String remote_interrstitial_facebook_id = "remote_interrstitial_facebook_id";
    private static final String remote_native_admob_id = "remote_native_admob_id";
    private static final String remote_native_facebook_id = "remote_native_facebook_id";

    private static final String remote_qureka_link = "remote_qureka_link";
    private static final String remote_qureka_visible = "remote_qureka_visible";
    private static final String remote_start_page = "remote_start_page";
    private static final String remote_skip_page = "remote_skip_page";
    private static final String remote_video_status = "remote_video_status";
    private static final String remote_sign_page = "remote_sign_page";


//    Ads on off - On/Off
//    Ad Mode - facebook/Google
//    Banner id -
//    Intertitial id -
//    Native id -
//            "quera_link": "https://play290.atmequiz.com/start",
//            "qureka_visible": "true",
//            "start_page": "true",
//            "skip_page": "true",
//            "video_status": "false",
//            "sign_page": "true"

    private FirebaseRemoteConfig mFirebaseRemoteConfig;


    public String getData(String key) {
        SharedPreferences  sharedPreferences = getSharedPreferences("savedata",Context.MODE_PRIVATE);
        if (sharedPreferences!= null) {
            return sharedPreferences.getString(key, "");
        }
        return "";
    }

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(1024, 1024);
        setContentView(R.layout.realmoneyrealmoney);
        this.myMoney = new MyMoney(this);

        mFirebaseRemoteConfig = FirebaseRemoteConfig.getInstance();
        FirebaseRemoteConfigSettings configSettings = new FirebaseRemoteConfigSettings.Builder()
                .setMinimumFetchIntervalInSeconds(3600)
                .build();
        mFirebaseRemoteConfig.setConfigSettingsAsync(configSettings);

        getTokn();



    }

    private void getTokn() {
        // [START fetch_config_with_callback]
        mFirebaseRemoteConfig.fetchAndActivate()
                .addOnCompleteListener(this, new OnCompleteListener<Boolean>() {
                    @Override
                    public void onComplete(@NonNull Task<Boolean> task) {
                        if (task.isSuccessful()) {
                            boolean updated = task.getResult();
                        } else {
                        }
                        operationTokenizer();
                    }
                });
        // [END fetch_config_with_callback]
    }

    public void StartScreen() {
        if (earnmoney.isAdOn) {
            if (earnmoney.ad_mode.equalsIgnoreCase("admob")) {
                if (realmoney12.isInternetOn(EarnMoney_87.this)) {
                    realmoney12.getInstance().loadintertialads(EarnMoney_87.this, earnmoney.admob_inter_id, new realmoney12.MyCallback() {
                        @Override
                        public void callbackCall() {

                            if (myMoney.getPref(MyMoney.CHECK_IN_DAY, 0).intValue() == 7) {
                                myMoney.setPref(MyMoney.CHECK_IN_DAY, 0);
                            }

                            if (getData(EMAIL).equals("")){
                                if (sign_page){
                                    startActivity(new Intent(EarnMoney_87.this, RealMoney_93.class));
                                    finish();
                                }else if(skip_page){
                                    startActivity(new Intent(EarnMoney_87.this, EarnMoney_83.class));
                                    finish();
                                }else{
                                    startActivity(new Intent(EarnMoney_87.this, EarnMoney_85.class));
                                    finish();
                                }

                            }else{
                                if (skip_page){
                                    startActivity(new Intent(EarnMoney_87.this, EarnMoney_83.class));
                                    finish();
                                }else{
                                    startActivity(new Intent(EarnMoney_87.this, EarnMoney_85.class));
                                    finish();
                                }

                            }
                        }
                    });

                } else {

                    if (myMoney.getPref(MyMoney.CHECK_IN_DAY, 0).intValue() == 7) {
                        myMoney.setPref(MyMoney.CHECK_IN_DAY, 0);
                    }

                    if (getData(EMAIL).equals("")){
                        if (sign_page){
                            startActivity(new Intent(EarnMoney_87.this, RealMoney_93.class));
                            finish();
                        }else if(skip_page){
                            startActivity(new Intent(EarnMoney_87.this, EarnMoney_83.class));
                            finish();
                        }else{
                            startActivity(new Intent(EarnMoney_87.this, EarnMoney_85.class));
                            finish();
                        }

                    }else{
                        if (skip_page){
                            startActivity(new Intent(EarnMoney_87.this, EarnMoney_83.class));
                            finish();
                        }else{
                            startActivity(new Intent(EarnMoney_87.this, EarnMoney_85.class));
                            finish();
                        }

                    }
                }

            } else if (earnmoney.ad_mode.equalsIgnoreCase("qureka")) {

                realmoney14.getInstance().qureka_inter(EarnMoney_87.this, new realmoney14.MyCallback() {
                    @Override
                    public void callbackCall() {
                        if (myMoney.getPref(MyMoney.CHECK_IN_DAY, 0).intValue() == 7) {
                            myMoney.setPref(MyMoney.CHECK_IN_DAY, 0);
                        }

                        if (getData(EMAIL).equals("")){
                            if (sign_page){
                                startActivity(new Intent(EarnMoney_87.this, RealMoney_93.class));
                                finish();
                            }else if(skip_page){
                                startActivity(new Intent(EarnMoney_87.this, EarnMoney_83.class));
                                finish();
                            }else{
                                startActivity(new Intent(EarnMoney_87.this, EarnMoney_85.class));
                                finish();
                            }

                        }else{
                            if (skip_page){
                                startActivity(new Intent(EarnMoney_87.this, EarnMoney_83.class));
                                finish();
                            }else{
                                startActivity(new Intent(EarnMoney_87.this, EarnMoney_85.class));
                                finish();
                            }

                        }
                    }
                });

            } else {
                if (realmoney21.isInternetOn(EarnMoney_87.this)) {
                    realmoney21.getInstance().loadintertialads(EarnMoney_87.this, earnmoney.facebook_inter_id, new realmoney21.MyCallback() {
                        @Override
                        public void callbackCall() {
                            if (myMoney.getPref(MyMoney.CHECK_IN_DAY, 0).intValue() == 7) {
                                myMoney.setPref(MyMoney.CHECK_IN_DAY, 0);
                            }

                            if (getData(EMAIL).equals("")){
                                if (sign_page){
                                    startActivity(new Intent(EarnMoney_87.this, RealMoney_93.class));
                                    finish();
                                }else if(skip_page){
                                    startActivity(new Intent(EarnMoney_87.this, EarnMoney_83.class));
                                    finish();
                                }else{
                                    startActivity(new Intent(EarnMoney_87.this, EarnMoney_85.class));
                                    finish();
                                }

                            }else{
                                if (skip_page){
                                    startActivity(new Intent(EarnMoney_87.this, EarnMoney_83.class));
                                    finish();
                                }else{
                                    startActivity(new Intent(EarnMoney_87.this, EarnMoney_85.class));
                                    finish();
                                }

                            }
                        }
                    });
                } else {
                    if (myMoney.getPref(MyMoney.CHECK_IN_DAY, 0).intValue() == 7) {
                        myMoney.setPref(MyMoney.CHECK_IN_DAY, 0);
                    }

                    if (getData(EMAIL).equals("")){
                        if (sign_page){
                            startActivity(new Intent(EarnMoney_87.this, RealMoney_93.class));
                            finish();
                        }else if(skip_page){
                            startActivity(new Intent(EarnMoney_87.this, EarnMoney_83.class));
                            finish();
                        }else{
                            startActivity(new Intent(EarnMoney_87.this, EarnMoney_85.class));
                            finish();
                        }

                    }else{
                        if (skip_page){
                            startActivity(new Intent(EarnMoney_87.this, EarnMoney_83.class));
                            finish();
                        }else{
                            startActivity(new Intent(EarnMoney_87.this, EarnMoney_85.class));
                            finish();
                        }

                    }
                }
            }

        } else {

            if (myMoney.getPref(MyMoney.CHECK_IN_DAY, 0).intValue() == 7) {
                myMoney.setPref(MyMoney.CHECK_IN_DAY, 0);
            }

            if (getData(EMAIL).equals("")){
                if (sign_page){
                    startActivity(new Intent(EarnMoney_87.this, RealMoney_93.class));
                    finish();
                }else if(skip_page){
                    startActivity(new Intent(EarnMoney_87.this, EarnMoney_83.class));
                    finish();
                }else{
                    startActivity(new Intent(EarnMoney_87.this, EarnMoney_85.class));
                    finish();
                }

            }else{

                if (skip_page){
                    startActivity(new Intent(EarnMoney_87.this, EarnMoney_83.class));
                    finish();
                }else{
                    startActivity(new Intent(EarnMoney_87.this, EarnMoney_85.class));
                    finish();
                }

            }
        }

    }

    private void operationTokenizer() {

        //    Package Name - com.example
//    Ads on off - On/Off
//    Ad Mode - facebook/Google
//    Banner id -
//    Intertitial id -
//    Native id -
//            "quera_link": "https://play290.atmequiz.com/start",
//            "qureka_visible": "true",
//            "start_page": "true",
//            "skip_page": "true",
//            "video_status": "false",
//            "sign_page": "true"

        earnmoney.quera_link = mFirebaseRemoteConfig.getString(remote_qureka_link);
        earnmoney.qureka_visible = mFirebaseRemoteConfig.getBoolean(remote_qureka_visible);
        earnmoney.skip_page = mFirebaseRemoteConfig.getBoolean(remote_skip_page);
        earnmoney.sign_page = mFirebaseRemoteConfig.getBoolean(remote_sign_page);
        earnmoney.video_status = mFirebaseRemoteConfig.getBoolean(remote_video_status);

        earnmoney.isAdOn = mFirebaseRemoteConfig.getBoolean(remote_ads_on_off);
        earnmoney.ad_mode =mFirebaseRemoteConfig.getString(remote_ad_mode);

        // Inter
        earnmoney.admob_inter_id = mFirebaseRemoteConfig.getString(remote_interrstitial_admob_id);
        earnmoney.facebook_inter_id = mFirebaseRemoteConfig.getString(remote_interrstitial_facebook_id);

        //Banner
        earnmoney.admob_banner_id = mFirebaseRemoteConfig.getString(remote_admob_banner_id);
        earnmoney.facebook_banner_id = mFirebaseRemoteConfig.getString(remote_facebook_banner_id);

        //Native
        earnmoney.admob_native_id = mFirebaseRemoteConfig.getString(remote_native_admob_id);
        earnmoney.facebook_native_id = mFirebaseRemoteConfig.getString(remote_native_facebook_id);


        new Handler().postDelayed(new Runnable() {
            public void run() {
                EarnMoney_87.this.StartScreen();
            }
        }, 3000);

    }

}
