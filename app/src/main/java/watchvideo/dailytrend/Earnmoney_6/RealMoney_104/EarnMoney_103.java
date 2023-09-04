package watchvideo.dailytrend.Earnmoney_6.RealMoney_104;

import android.content.SharedPreferences;
import watchvideo.dailytrend.realmoney_24;
import watchvideo.dailytrend.Earnmoney_6.EarnMoney_104.cashearning6;
import java.util.ArrayList;
import java.util.HashSet;

public class EarnMoney_103 {
    private static volatile EarnMoney_103 _instance;
    public final String AD_PREF = "AD_PREF";
    public String DEFAULT_DOWNLOAD_VALUE = "default_download_value";
    public final String DOWNLOAD_AD_COUNT = "download_ad_count";
    public final String FULL_SCREEN_LANG_LIST = "full_screen_lang_list";
    public final String HOME_API_CALLING = "home_api_calling";
    public String IS_ANIMATION = "is_animation";
    public final String IS_AUTO_PLAY_DISABLE = "is_auto_play_disable";
    public String IS_INSTALL = "is_install";
    public final String IS_INTRO_SCREEN = "is_intro_screen";
    public final String IS_NOTIFICATION_DISABLE = "is_auto_play_disable";
    public final String IS_TIP = "is_tip";
    public final String IS_TIP_DETAIL = "is_tip_detail";
    public final String IS_TIP_LANG_SELECTION = "is_tip_lang_selection";
    public final String IS_TIP_SCREEN_CHANGE = "is_tip_screen_change";
    public String Is_DEFAULT_DOWNLOAD = "is_default_download";
    public final String LANDSCAPE_LANG_LIST = "landscape_lang_list";
    public String MY_PREF = "PhotoStampPref";
    public final String RATE_DOWNLOAD_COUNT = "rate_download_count";
    public final String RATE_IS_NEVER = "rate_is_never";
    public final String RATE_MAIN_COUNT = "rate_main_count";
    public final String RATE_NOTIFICATION_COUNT = "rate_notification_count";
    public final String SHARE_DATE_COUNT = "share_date_count";
    public final String SHARE_IS_NEVER = "share_is_never";
    public final String SHARE_SHOWING_COUNT = "share_later_count";
    public final String UPDATE_DATE = "rate_date";
    public final String UPDATE_LATER_COUNT = "rate_later_count";
    public final String UPDATE_NEVER = "rate_never";
    private SharedPreferences.Editor editor;
    private SharedPreferences pref;

    public static EarnMoney_103 Instance() {
        if (_instance == null) {
            synchronized (EarnMoney_103.class) {
                _instance = new EarnMoney_103();
            }
        }
        return _instance;
    }

    public void clearPref() {
        this.editor.clear();
    }

    public boolean getBooleanPref(String str) {
        return this.pref.getBoolean(str, false);
    }

    public void getFullScreenLangList() {
        HashSet hashSet = (HashSet) this.pref.getStringSet("full_screen_lang_list", null);
        if (hashSet != null) {
            cashearning6.Instance().arrSelectedLangId.clear();
            cashearning6.Instance().arrSelectedLangId.addAll(new ArrayList(hashSet));
        }
    }

    public int getIntPref(String str) {
        return this.pref.getInt(str, 0);
    }

    public void getLandscapeLangList() {
        HashSet hashSet = (HashSet) this.pref.getStringSet("landscape_lang_list", null);
        if (hashSet != null) {
            cashearning6.Instance().arrSelectedLandscapeLangId.clear();
            cashearning6.Instance().arrSelectedLandscapeLangId.addAll(new ArrayList(hashSet));
        }
    }

    public String getStringPref(String str) {
        return this.pref.getString(str, "");
    }

    public void initPref() {
        SharedPreferences sharedPreferences = realmoney_24.getContext().getSharedPreferences(this.MY_PREF, 0);
        this.pref = sharedPreferences;
        this.editor = sharedPreferences.edit();
    }

    public void putPref(String str, String str2) {
        this.editor.putString(str, str2);
    }

    public void saveFullScreenLangList() {
        this.editor.putStringSet("full_screen_lang_list", new HashSet(cashearning6.Instance().arrSelectedLangId));
        this.editor.commit();
    }

    public void saveLandscapeLangList() {
        this.editor.putStringSet("landscape_lang_list", new HashSet(cashearning6.Instance().arrSelectedLandscapeLangId));
        this.editor.commit();
    }

    public void savePref() {
        this.editor.commit();
    }

    public void putPref(String str, int i) {
        this.editor.putInt(str, i);
    }

    public void putPref(String str, boolean z) {
        this.editor.putBoolean(str, z);
    }
}
