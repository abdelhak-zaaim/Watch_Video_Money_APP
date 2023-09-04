package watchvideo.dailytrend;

import android.content.Context;


import androidx.multidex.MultiDex;
import androidx.multidex.MultiDexApplication;

import com.google.gson.Gson;
import watchvideo.dailytrend.Realmoney_3.realmoney_35.earnmoney_33.realmoney_27;
import watchvideo.dailytrend.Earnmoney_3.earnmoney_55;
import watchvideo.dailytrend.Earnmoney_3.earnmoney_56;
import watchvideo.dailytrend.Earnmoney_3.earnmoney_57;
import java.util.ArrayList;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class earnmoney_21 extends MultiDexApplication {
    public static String apps_install_url = "";
    public static String apps_install_url_status = "0";
    public static String facebook_url = "";
    public static String facecbook_url_status = "0";
    public static String fb_test_device_id = "96e59b5a-cbfd-4900-aec9-492f9ed4e482";
    private static earnmoney_21 fire_base_app = null;
    public static String instagram_url = "";
    public static String instagram_url_status = "0";
    public static String live_video_call_url = "";
    public static String live_video_call_url_status = "0";
    public static String more_url = "https://play.google.com/store/apps/developer?id=Jovu+Padshe";
    public static String rate_url = "https://play.google.com/store/apps/details?id=";
    public static String start_url = "";
    public static String start_url_status = "0";
    public static String telegram_url = "";
    public static String telegram_url_status = "0";
    public static String twitter_url = "";
    public static String twitter_url_status = "0";
    public static int versioncode = 0;
    public static String website_url = "";
    public static String website_url_status = "0";
    public static String youtube_url = "";
    public static String youtube_url_status = "0";
    public ArrayList<realmoney_27> Vlanguages = new ArrayList<>();

    @Override 
    public void onCreate() {
        super.onCreate();
        fire_base_app = this;
    }

    @Override
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        MultiDex.install(this);
    }

    public static synchronized earnmoney_21 getInstance() {
        earnmoney_21 appHelper;
        synchronized (earnmoney_21.class) {
            synchronized (earnmoney_21.class) {
                synchronized (earnmoney_21.class) {
                    appHelper = fire_base_app;
                }
                return appHelper;
            }
        }
    }

    public ArrayList<realmoney_27> getLanguages() {
        return this.Vlanguages;
    }

    public static void getwebdata(Context context) {
        ((earnmoney_56) earnmoney_55.getClient().create(earnmoney_56.class)).getVersionDataFromServer("http://qct.quickcodetechnologies.com/api/public/com.coolappworld.healthbenefitsof.garlic.jd11/Social").enqueue(new Callback<ResponseBody>() {

            @Override 
            public void onFailure(Call<ResponseBody> call, Throwable th) {

            }

            @Override 
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    if (response.body() != null) {
                        ArrayList<earnmoney_57.SocialCode> listData = ((earnmoney_57) new Gson().fromJson(response.body().string(), earnmoney_57.class)).getListData();
                        earnmoney_21.website_url = listData.get(0).getWebUrl();
                        earnmoney_21.website_url_status = listData.get(0).getWebstatusCode();
                        earnmoney_21.instagram_url = listData.get(0).getInstaUrl();
                        earnmoney_21.instagram_url_status = listData.get(0).getInstastatusCode();
                        earnmoney_21.facebook_url = listData.get(0).getFbUrl();
                        earnmoney_21.facecbook_url_status = listData.get(0).getFbstatusCode();
                        earnmoney_21.twitter_url = listData.get(0).getTwitterUrl();
                        earnmoney_21.twitter_url_status = listData.get(0).getTwitterstatusCode();
                        earnmoney_21.telegram_url = listData.get(0).getTelegramUrl();
                        earnmoney_21.telegram_url_status = listData.get(0).getTelegramstatusCode();
                        earnmoney_21.youtube_url = listData.get(0).getYoutubeUrl();
                        earnmoney_21.youtube_url_status = listData.get(0).getYoutubestatusCode();
                    //    AppHelper.apps_install_url = listData.get(0).getAppinstallUrl();
                    //    AppHelper.apps_install_url_status = listData.get(0).getAppinstallstatusCode();
                        earnmoney_21.live_video_call_url = listData.get(0).getLivevideocallUrl();
                        earnmoney_21.live_video_call_url_status = listData.get(0).getLivevideocallstatusCode();
                        earnmoney_21.start_url = listData.get(0).getStartUrl();
                        earnmoney_21.start_url_status = listData.get(0).getStartstatusCode();
                    }
                } catch (Exception unused) {
                }
            }
        });
    }
}
