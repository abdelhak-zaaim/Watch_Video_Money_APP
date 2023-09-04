package watchvideo.dailytrend.Earnmoney_6.EarnMoney_105;

import java.util.Map;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Path;

public class EarnMoney_113 {
    public static volatile EarnMoney_113 _instance;
    public static Retrofit retrofit;

    public interface CategoryService {
        @FormUrlEncoded
        @POST("categories/")
        Call<ResponseBody> getCategory(@FieldMap Map<String, String> map);

        @FormUrlEncoded
        @POST("categories/{value}")
        Call<ResponseBody> getVideoByCategory(@Path("value") String str, @FieldMap Map<String, String> map);
    }

    public interface CommanApiService {
        @FormUrlEncoded
        @POST("config/")
        Call<ResponseBody> getConfig(@FieldMap Map<String, String> map);

        @FormUrlEncoded
        @POST("pages/privacy-policy/")
        Call<ResponseBody> getPolicy(@FieldMap Map<String, String> map);

        @FormUrlEncoded
        @POST("reports/{value}")
        Call<ResponseBody> getReports(@Path("value") String str, @FieldMap Map<String, String> map);

        @FormUrlEncoded
        @POST("update/")
        Call<ResponseBody> getUpdateValue(@FieldMap Map<String, String> map);

        @FormUrlEncoded
        @POST("install/")
        Call<ResponseBody> installAppApi(@FieldMap Map<String, String> map);
    }

    public interface LangService {
        @FormUrlEncoded
        @POST("languages/")
        Call<ResponseBody> getLang(@FieldMap Map<String, String> map);

        @FormUrlEncoded
        @POST("languages/{value}")
        Call<ResponseBody> getVideoByLang(@Path("value") String str, @FieldMap Map<String, String> map);
    }

    public interface SearchService {
        @FormUrlEncoded
        @POST("search/tags/name/{value}")
        Call<ResponseBody> getVideosBySearch(@Path("value") String str, @FieldMap Map<String, String> map);

        @FormUrlEncoded
        @POST("search/main/title/{value}")
        Call<ResponseBody> getVideosByTitle(@Path("value") String str, @FieldMap Map<String, String> map);
    }

    public interface VideoDataService {
        @FormUrlEncoded
        @POST("downloads/{value}")
        Call<ResponseBody> downloadVideo(@Path("value") String str, @FieldMap Map<String, String> map);

        @FormUrlEncoded
        @POST("likes/{value}")
        Call<ResponseBody> likeVideo(@Path("value") String str, @FieldMap Map<String, String> map);

        @FormUrlEncoded
        @POST("views/{value}")
        Call<ResponseBody> viewVideo(@Path("value") String str, @FieldMap Map<String, String> map);
    }

    public interface VideoService {
        @FormUrlEncoded
        @POST("contents/")
        Call<ResponseBody> getVideo(@FieldMap Map<String, String> map);

        @FormUrlEncoded
        @POST("contents/{value}")
        Call<ResponseBody> getVideoById(@Path("value") String str, @FieldMap Map<String, String> map);
    }

    public static EarnMoney_113 Instance() {
        if (_instance == null) {
            synchronized (EarnMoney_113.class) {
                _instance = new EarnMoney_113();
            }
        }
        return _instance;
    }

    public static Retrofit getRetro() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        Retrofit build = new Retrofit.Builder().baseUrl("https://justapps.me/api/applications/").addConverterFactory(GsonConverterFactory.create()).client(new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build()).build();
        retrofit = build;
        return build;
    }
}
