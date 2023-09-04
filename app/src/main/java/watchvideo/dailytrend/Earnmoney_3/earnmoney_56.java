package watchvideo.dailytrend.Earnmoney_3;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface earnmoney_56 {
    @FormUrlEncoded
    @POST("appServices/getQuckcodeAds.php")
    Call<ResponseBody> getHomeAdsData(@Field("pkgname") String str);

    @GET
    Call<ResponseBody> getVersionDataFromServer(@Url String str);
}
