package watchvideo.dailytrend.Realmoney_3.realmoney_35.earnmoney_33;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

public class realmoney_28 {
    @SerializedName("dp_categories")
    private ArrayList<realmoney_27> dpCategories;
    @SerializedName("joke_categories")
    private ArrayList<realmoney_27> jokeCategories;
    @SerializedName("text_categories")
    private ArrayList<realmoney_27> textCategories;
    @SerializedName("version")
    private realmoney_29 vResponse;
    @SerializedName("video_categories")
    private ArrayList<realmoney_27> videoCategories;

    public ArrayList<realmoney_27> getTextCategories() {
        return this.textCategories;
    }

    public void setTextCategories(ArrayList<realmoney_27> arrayList) {
        this.textCategories = arrayList;
    }

    public ArrayList<realmoney_27> getDpCategories() {
        return this.dpCategories;
    }

    public void setDpCategories(ArrayList<realmoney_27> arrayList) {
        this.dpCategories = arrayList;
    }

    public ArrayList<realmoney_27> getVideoCategories() {
        return this.videoCategories;
    }

    public void setVideoCategories(ArrayList<realmoney_27> arrayList) {
        this.videoCategories = arrayList;
    }

    public ArrayList<realmoney_27> getJokeCategories() {
        return this.jokeCategories;
    }

    public void setJokeCategories(ArrayList<realmoney_27> arrayList) {
        this.jokeCategories = arrayList;
    }

    public realmoney_29 getVersion() {
        return this.vResponse;
    }

    public void setVersion(realmoney_29 versionResponse) {
        this.vResponse = versionResponse;
    }

    public String toString() {
        return "LangData{text_categories = '" + this.textCategories + "',dp_categories = '" + this.dpCategories + "',video_categories = '" + this.videoCategories + "',joke_categories = '" + this.jokeCategories + "',version = '" + this.vResponse + "'}";
    }
}
