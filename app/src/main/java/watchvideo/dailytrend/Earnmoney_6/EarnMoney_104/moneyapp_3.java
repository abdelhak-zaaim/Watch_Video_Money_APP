package watchvideo.dailytrend.Earnmoney_6.EarnMoney_104;

import com.tonyodev.fetch2.Download;
import java.io.Serializable;
import java.util.ArrayList;

public class moneyapp_3 implements Serializable {
    private ArrayList<moneyapp_4> arrModelNewImageBanner;
    private String created_at;
    public Download download;
    public int downloadId;
    public long downloadedBytesPerSecond = 0;
    public long eta = -1;
    private String id;
    private int itemType;
    private String language;
    private String likes;
    private moneyapp_1 promoBannerModel;
    private String thumb;
    private String title;
    private int videoIdentifyer;
    private String videoName;
    private String videoPath;
    private String views;

    public moneyapp_3(int i) {
        this.itemType = i;
    }

    public moneyapp_3() {
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof moneyapp_3) && ((moneyapp_3) obj).downloadId == this.downloadId);
    }

    public ArrayList<moneyapp_4> getArrModelNewImageBanner() {
        return this.arrModelNewImageBanner;
    }

    public String getCreated_at() {
        return this.created_at;
    }

    public String getId() {
        return this.id;
    }

    public int getItemType() {
        return this.itemType;
    }

    public String getLanguage() {
        return this.language;
    }

    public String getLikes() {
        return this.likes;
    }

    public moneyapp_1 getPromoBannerModel() {
        return this.promoBannerModel;
    }

    public String getThumb() {
        return this.thumb;
    }

    public String getTitle() {
        return this.title;
    }

    public int getVideoIdentifyer() {
        return this.videoIdentifyer;
    }

    public String getVideoName() {
        return this.videoName;
    }

    public String getVideoPath() {
        return this.videoPath;
    }

    public String getViews() {
        return this.views;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return this.downloadId;
    }

    public void setArrModelNewImageBanner(ArrayList<moneyapp_4> arrayList) {
        this.arrModelNewImageBanner = arrayList;
    }

    public void setCreated_at(String str) {
        this.created_at = str;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setItemType(int i) {
        this.itemType = i;
    }

    public void setLanguage(String str) {
        this.language = str;
    }

    public void setLikes(String str) {
        this.likes = str;
    }

    public void setPromoBannerModel(moneyapp_1 promoBannerModel2) {
        this.promoBannerModel = promoBannerModel2;
    }

    public void setThumb(String str) {
        this.thumb = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setVideoIdentifyer(int i) {
        this.videoIdentifyer = i;
    }

    public void setVideoName(String str) {
        this.videoName = str;
    }

    public void setVideoPath(String str) {
        this.videoPath = str;
    }

    public void setViews(String str) {
        this.views = str;
    }

    @Override // java.lang.Object
    public String toString() {
        Download download2 = this.download;
        if (download2 == null) {
            return "";
        }
        return download2.toString();
    }
}
