package watchvideo.dailytrend.Earnmoney;

import java.util.ArrayList;

public class realmoney11 {

    public static ArrayList<realmoney11> arrAdDataStart = new ArrayList<realmoney11>();
    public static ArrayList<realmoney11> arrAdDataExit = new ArrayList<realmoney11>();
    String app_name = "";
    String package_name = "";
    String app_icon = "";

    public static void setArrAdDataExit(ArrayList<realmoney11> arrAdDataExit) {
        arrAdDataExit = arrAdDataExit;
    }

    public String getApp_name() {
        return app_name;
    }

    public void setApp_name(String app_name) {
        this.app_name = app_name;
    }

    public String getPackage_name() {
        return package_name;
    }

    public void setPackage_name(String package_name) {
        this.package_name = package_name;
    }

    public String getApp_icon() {
        return app_icon;
    }

    public void setApp_icon(String app_icon) {
        this.app_icon = app_icon;
    }

}
