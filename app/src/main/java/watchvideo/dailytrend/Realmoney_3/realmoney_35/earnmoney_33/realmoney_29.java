package watchvideo.dailytrend.Realmoney_3.realmoney_35.earnmoney_33;

import com.google.gson.annotations.SerializedName;
import com.tonyodev.fetch2core.server.FileResponse;

public class realmoney_29 {
    @SerializedName(FileResponse.FIELD_TYPE)
    private String type;
    @SerializedName("version_code")
    private float versionCode;

    public void setVersionCode(float f) {
        this.versionCode = f;
    }

    public float getVersionCode() {
        return this.versionCode;
    }

    public void setType(String str) {
        this.type = str;
    }

    public String getType() {
        return this.type;
    }

    public String toString() {
        return "VersionResponse{version_code = '" + this.versionCode + "',type = '" + this.type + "'}";
    }
}
