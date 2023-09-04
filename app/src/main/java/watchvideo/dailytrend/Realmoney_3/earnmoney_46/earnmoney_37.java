package watchvideo.dailytrend.Realmoney_3.earnmoney_46;

import watchvideo.dailytrend.Realmoney_3.realmoney_35.earnmoney_31.earnmoney_29;
import watchvideo.dailytrend.Realmoney_3.realmoney_35.earnmoney_33.realmoney_30;
import watchvideo.dailytrend.Realmoney_3.realmoney_35.earnmoney_34.realmoney_25;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface earnmoney_37 {
    @FormUrlEncoded
    @POST("api/getLanguages")
    Call<realmoney_30> getLanguages(@Field("token") String str, @Field("package") String str2);

    @FormUrlEncoded
    @POST("api/getVideoCategories")
    Call<earnmoney_29> getVideoCategories(@Field("token") String str, @Field("package") String str2, @Field("type") String str3, @Field("language_id") String str4);

    @FormUrlEncoded
    @POST("api/getVideos")
    Call<realmoney_25> getVideos(@Field("token") String str, @Field("package") String str2, @Field("category") int i, @Field("page") int i2, @Field("search") String str3, @Field("type") String str4, @Field("language_id") String str5);
}
