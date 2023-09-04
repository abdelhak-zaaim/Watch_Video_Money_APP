package watchvideo.dailytrend.Earnmoney_3;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class earnmoney_55 {
    private static Retrofit retrofit;

    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder().baseUrl("http://qct.quickcodetechnologies.com/").addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
}
