package watchvideo.dailytrend.Realmoney_3.realmoney_47.realmoney_46;

import watchvideo.dailytrend.Realmoney_3.realmoney_35.earnmoney_33.realmoney_30;
import watchvideo.dailytrend.Realmoney_3.earnmoney_46.earnmoney_43;
import watchvideo.dailytrend.Realmoney_3.earnmoney_46.earnmoney_37;
import watchvideo.dailytrend.Realmoney_3.earnmoney_46.earnmoney_38;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class realmoney_45 {
    static realmoney_45 instance;
    private realmoney_42 callback;

    public static realmoney_45 getInstance() {
        if (instance == null) {
            instance = new realmoney_45();
        }
        return instance;
    }

    public void setListener(realmoney_42 realmoney42) {
        this.callback = realmoney42;
        start();
    }

    public void start() {
        ((earnmoney_37) earnmoney_43.getClient().create(earnmoney_37.class)).getLanguages(earnmoney_38.token, earnmoney_38.package_name).enqueue(new Callback<realmoney_30>() {

            @Override 
            public void onResponse(Call<realmoney_30> call, Response<realmoney_30> response) {
                try {
                    realmoney_45.this.callback.onGetLanguages(response.body().getData());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override 
            public void onFailure(Call<realmoney_30> call, Throwable th) {
                th.printStackTrace();
            }
        });
    }
}
