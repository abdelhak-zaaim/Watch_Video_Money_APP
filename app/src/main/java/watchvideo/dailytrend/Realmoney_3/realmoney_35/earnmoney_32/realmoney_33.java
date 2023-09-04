package watchvideo.dailytrend.Realmoney_3.realmoney_35.earnmoney_32;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class realmoney_33 {
    @SerializedName("data")
    @Expose
    private realmoney_32 data;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("status_code")
    @Expose
    private Integer statusCode;

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public Integer getStatusCode() {
        return this.statusCode;
    }

    public void setStatusCode(Integer num) {
        this.statusCode = num;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public realmoney_32 getData() {
        return this.data;
    }

    public void setData(realmoney_32 dataItem) {
        this.data = dataItem;
    }
}
