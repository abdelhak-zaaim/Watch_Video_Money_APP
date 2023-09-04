package watchvideo.dailytrend.Realmoney_3.realmoney_35.earnmoney_32;

import com.google.android.exoplayer2.util.MimeTypes;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import watchvideo.dailytrend.Realmoney_3.earnmoney_46.earnmoney_39;

public class realmoney_34 {
    @SerializedName(earnmoney_39.KEY_VIDEO_FAV_SIZE)
    @Expose
    private Integer fileSize;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("mp3_file_size")
    @Expose
    private Integer mp3FileSize;
    @SerializedName("mp3_url")
    @Expose
    private String mp3Url;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("thumb")
    @Expose
    private String thumb;
    @SerializedName(MimeTypes.BASE_TYPE_VIDEO)
    @Expose
    private String video;
    @SerializedName(earnmoney_39.KEY_VIDEO_VIEW_COUNTER)
    @Expose
    private Integer viewcounter;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer num) {
        this.id = num;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getVideo() {
        return this.video;
    }

    public void setVideo(String str) {
        this.video = str;
    }

    public Integer getFileSize() {
        return this.fileSize;
    }

    public void setFileSize(Integer num) {
        this.fileSize = num;
    }

    public String getMp3Url() {
        return this.mp3Url;
    }

    public void setMp3Url(String str) {
        this.mp3Url = str;
    }

    public Integer getMp3FileSize() {
        return this.mp3FileSize;
    }

    public void setMp3FileSize(Integer num) {
        this.mp3FileSize = num;
    }

    public String getThumb() {
        return this.thumb;
    }

    public void setThumb(String str) {
        this.thumb = str;
    }

    public Integer getViewCounter() {
        return this.viewcounter;
    }

    public void setViewCounter(Integer num) {
        this.viewcounter = num;
    }
}
