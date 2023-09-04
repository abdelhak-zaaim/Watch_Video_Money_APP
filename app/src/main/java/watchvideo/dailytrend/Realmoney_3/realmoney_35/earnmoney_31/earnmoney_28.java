package watchvideo.dailytrend.Realmoney_3.realmoney_35.earnmoney_31;

import com.google.gson.annotations.SerializedName;

public class earnmoney_28 {
    @SerializedName("icon")
    private String icon;
    @SerializedName("id")
    private int id;
    private String isAds;
    @SerializedName("name")
    private String name;

    public String getIsAds() {
        return this.isAds;
    }

    public void setIsAds(String str) {
        this.isAds = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getName() {
        return this.name;
    }

    public void setIcon(String str) {
        this.icon = str;
    }

    public String getIcon() {
        return this.icon;
    }

    public void setId(int i) {
        this.id = i;
    }

    public int getId() {
        return this.id;
    }

    public String toString() {
        return "ModelVideo{name = '" + this.name + "',icon = '" + this.icon + "',id = '" + this.id + "',isAds = '0'}";
    }
}
