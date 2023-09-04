package watchvideo.dailytrend.Realmoney_3.realmoney_35.earnmoney_34;

import com.google.android.exoplayer2.util.MimeTypes;
import com.google.gson.annotations.SerializedName;
import watchvideo.dailytrend.Realmoney_3.earnmoney_46.earnmoney_39;
import java.io.Serializable;

public class realmoney_26 implements Serializable {
    @SerializedName(earnmoney_39.KEY_VIDEO_FAV_SIZE)
    private int fileSize;
    @SerializedName("id")
    private int id;
    @SerializedName("mp3_file_size")
    private int mp3FileSize;
    @SerializedName("mp3_url")
    private String mp3Url;
    @SerializedName("name")
    private String name;
    @SerializedName("thumb")
    private String thumb;
    @SerializedName(MimeTypes.BASE_TYPE_VIDEO)
    private String video;
    @SerializedName(earnmoney_39.KEY_VIDEO_VIEW_COUNTER)
    private int viewCounter;

    public String getMp3Url() {
        return this.mp3Url;
    }

    public void setMp3Url(String str) {
        this.mp3Url = str;
    }

    public String getThumb() {
        return this.thumb;
    }

    public void setThumb(String str) {
        this.thumb = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public int getMp3FileSize() {
        return this.mp3FileSize;
    }

    public void setMp3FileSize(int i) {
        this.mp3FileSize = i;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int i) {
        this.id = i;
    }

    public String getVideo() {
        return this.video;
    }

    public void setVideo(String str) {
        this.video = str;
    }

    public int getViewCounter() {
        return this.viewCounter;
    }

    public void setViewCounter(int i) {
        this.viewCounter = i;
    }

    public int getFileSize() {
        return this.fileSize;
    }

    public void setFileSize(int i) {
        this.fileSize = i;
    }

    @Override // java.lang.Object
    public String toString() {
        return "ModelVideo{mp3_url = '" + this.mp3Url + "',thumb = '" + this.thumb + "',name = '" + this.name + "',mp3_file_size = '" + this.mp3FileSize + "',id = '" + this.id + "',video = '" + this.video + "',view_counter = '" + this.viewCounter + "',file_size = '" + this.fileSize + "'}";
    }
}
