package watchvideo.dailytrend.Realmoney_3.realmoney_47.realmoney_46;

import watchvideo.dailytrend.Realmoney_3.realmoney_35.earnmoney_34.realmoney_25;
import watchvideo.dailytrend.Realmoney_3.earnmoney_46.earnmoney_43;
import watchvideo.dailytrend.Realmoney_3.earnmoney_46.earnmoney_37;
import watchvideo.dailytrend.Realmoney_3.earnmoney_46.earnmoney_38;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class realmoney_43 {
    static realmoney_43 instance;
    private realmoney_44 callback;
    private int category;
    private String language_id;
    private int page;
    private String search;
    private String type;

    public static realmoney_43 getInstance() {
        if (instance == null) {
            instance = new realmoney_43();
        }
        return instance;
    }

    public void setListener(realmoney_44 onGetVideo, int i, String str, String str2, int i2, String str3) {
        this.callback = onGetVideo;
        this.category = i;
        this.type = str;
        this.search = str2;
        this.page = i2;
        this.language_id = str3;
        start();
    }

    public void start() {
        ((earnmoney_37) earnmoney_43.getClient().create(earnmoney_37.class)).getVideos(earnmoney_38.token, earnmoney_38.package_name, this.category, this.page, this.search, this.type, this.language_id).enqueue(new Callback<realmoney_25>() {
            @Override 
            public void onResponse(Call<realmoney_25> call, Response<realmoney_25> response) {
                try {
                    realmoney_43.this.callback.onGetVideoList(response.body());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override 
            public void onFailure(Call<realmoney_25> call, Throwable th) {
                th.printStackTrace();
            }
        });
    }
}
