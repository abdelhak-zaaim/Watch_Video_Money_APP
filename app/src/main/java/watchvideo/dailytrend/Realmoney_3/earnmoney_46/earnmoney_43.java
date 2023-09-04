package watchvideo.dailytrend.Realmoney_3.earnmoney_46;

import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class earnmoney_43 {
    private static Retrofit retrofit;

    public static Retrofit getClient() {
        if (retrofit == null) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.connectTimeout(100, TimeUnit.SECONDS);
            builder.readTimeout(100, TimeUnit.SECONDS);
            builder.writeTimeout(100, TimeUnit.SECONDS);
            retrofit = new Retrofit.Builder().baseUrl(earnmoney_45.MAIN_URL).client(builder.build()).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
}
