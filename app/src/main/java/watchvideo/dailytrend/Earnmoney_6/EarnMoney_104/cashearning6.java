package watchvideo.dailytrend.Earnmoney_6.EarnMoney_104;

import java.util.ArrayList;

public class cashearning6 {
    private static volatile cashearning6 _instance;
    ArrayList<cashearning> a = new ArrayList<>();
    public ArrayList<String> arrSelectedLandscapeLangId = new ArrayList<>();
    public ArrayList<String> arrSelectedLangId = new ArrayList<>();
    ArrayList<moneyapp_3> b = new ArrayList<>();
    ArrayList<moneyapp_3> e = new ArrayList<>();
    ArrayList<moneyapp_3> f = new ArrayList<>();
    ArrayList<moneyapp_3> g = new ArrayList<>();
    ArrayList<moneyapp_3> h = new ArrayList<>();

    public static cashearning6 Instance() {
        if (_instance == null) {
            synchronized (cashearning6.class) {
                _instance = new cashearning6();
            }
        }
        return _instance;
    }

    public void addSelectedLang(int i, String str) {
        if (i == 1) {
            if (this.arrSelectedLandscapeLangId.contains(str)) {
                this.arrSelectedLandscapeLangId.remove(str);
            } else {
                this.arrSelectedLandscapeLangId.add(str);
            }
        } else if (this.arrSelectedLangId.contains(str)) {
            this.arrSelectedLangId.remove(str);
        } else {
            this.arrSelectedLangId.add(str);
        }
    }

    public ArrayList<moneyapp_3> getArrFeatureLanceVideos() {
        return this.g;
    }

    public ArrayList<moneyapp_3> getArrFeatureVideos() {
        return this.f;
    }

    public ArrayList<moneyapp_3> getArrPopularVideos() {
        return this.e;
    }

    public ArrayList<cashearning> getArrReport() {
        return this.a;
    }

    public ArrayList<moneyapp_3> getArrSearchedVideos() {
        return this.h;
    }

    public ArrayList<moneyapp_3> getArrVideos() {
        return this.b;
    }

    public void setArrFeatureLanceVideos(ArrayList<moneyapp_3> arrayList) {
        this.g = arrayList;
    }

    public void setArrFeatureVideos(ArrayList<moneyapp_3> arrayList) {
        this.f = arrayList;
    }

    public void setArrPopularVideos(ArrayList<moneyapp_3> arrayList) {
        this.e = new ArrayList<>(arrayList);
    }

    public void setArrReport(ArrayList<cashearning> arrayList) {
        this.a = new ArrayList<>(arrayList);
    }

    public void setArrSearchedVideos(ArrayList<moneyapp_3> arrayList) {
        this.h = arrayList;
    }

    public void setArrVideos(ArrayList<moneyapp_3> arrayList) {
        this.b = new ArrayList<>(arrayList);
    }
}
