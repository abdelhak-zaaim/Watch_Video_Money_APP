package watchvideo.dailytrend.Realmoney_3.realmoney_36.earnmoney_50;

import watchvideo.dailytrend.Realmoney_3.realmoney_36.earnmoney_47;
import watchvideo.dailytrend.Realmoney_3.realmoney_35.earnmoney_31.earnmoney_29;
import watchvideo.dailytrend.Realmoney_3.earnmoney_46.earnmoney_43;
import watchvideo.dailytrend.Realmoney_3.earnmoney_46.earnmoney_37;
import watchvideo.dailytrend.Realmoney_3.earnmoney_46.earnmoney_38;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class earnmoney_49 {
    static earnmoney_49 instance;
    private earnmoney_47 callback;
    private String strlang;

    public static earnmoney_49 getInstance() {
        if (instance == null) {
            instance = new earnmoney_49();
        }
        return instance;
    }

    public void setListener(earnmoney_47 earnmoney47, String str) {
        this.callback = earnmoney47;
        this.strlang = str;
        start();
    }

    public void start() {
        ((earnmoney_37) earnmoney_43.getClient().create(earnmoney_37.class)).getVideoCategories(earnmoney_38.token, earnmoney_38.package_name, earnmoney_38.TYPE, this.strlang).enqueue(new Callback<earnmoney_29>() {
            @Override 
            public void onResponse(Call<earnmoney_29> call, Response<earnmoney_29> response) {
                try {
                    earnmoney_49.this.callback.onGetCategories(response.body());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override 
            public void onFailure(Call<earnmoney_29> call, Throwable th) {
                th.printStackTrace();
            }
        });
    }
}
