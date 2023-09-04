package watchvideo.dailytrend.Earnmoney;

import androidx.annotation.Keep;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

@Keep
public interface watchvideoandearnmoney {

    @FormUrlEncoded
    @POST("")
    Call<String> getad(@Field("packageName") String str);

    @FormUrlEncoded
    @POST("/localadds.php")
    Call<String> getdata(@Field("request_for") String request_for, @Field("package_name") String str);

    @FormUrlEncoded
    @POST("/admin/localadds.php")
    Call<String> postdwn(@Field("request_for") String request_for,@Field("packagename") String str);

}
