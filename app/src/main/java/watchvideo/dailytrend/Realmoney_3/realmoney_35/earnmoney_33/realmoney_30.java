package watchvideo.dailytrend.Realmoney_3.realmoney_35.earnmoney_33;

import com.google.gson.annotations.SerializedName;

public class realmoney_30 {
    @SerializedName("data")
    private realmoney_28 data;
    @SerializedName("message")
    private String message;
    @SerializedName("status")
    private String status;
    @SerializedName("status_code")
    private int statusCode;

    public void setStatusCode(int i) {
        this.statusCode = i;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public void setData(realmoney_28 langData) {
        this.data = langData;
    }

    public realmoney_28 getData() {
        return this.data;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public String getMessage() {
        return this.message;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public String getStatus() {
        return this.status;
    }

    public String toString() {
        return "LangResponse{status_code = '" + this.statusCode + "',data = '" + this.data + "',message = '" + this.message + "',status = '" + this.status + "'}";
    }
}
