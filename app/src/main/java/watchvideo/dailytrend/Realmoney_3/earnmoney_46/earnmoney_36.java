package watchvideo.dailytrend.Realmoney_3.earnmoney_46;

import android.content.Context;
import android.content.SharedPreferences;

public class earnmoney_36 {
    private static final String KEY_APP_RATER_DOWNLOAD_COUNT = "rater_download";
    private static final String KEY_APP_RATE_COUNT = "app_rate_count";
    private static final String KEY_APP_RATE_THRESHOLD = "app_rate_threshold";
    private static final String KEY_APP_VERSION_LAST_SHOWN = "app_version";
    private static final String KEY_CONFIG_RESPONSE = "config_res";
    private static final String KEY_DATE_RATER_COUNT = "date_count_rater";
    private static final String KEY_IS_APP_RATER_CLICKED = "is_app_rater_shown";
    private static final String KEY_UNIQUE_KEY = "unique_key";
    private static final String KEY_VERSION_DATE = "version_date";
    private static final String PRE_NAME = "app_pref";
    private static SharedPreferences pref;
    private SharedPreferences.Editor editor;

    public earnmoney_36(Context context) {
        if (pref == null) {
            pref = context.getSharedPreferences(PRE_NAME, 0);
        }
    }

    public void setUserInfo(String str) {
        SharedPreferences.Editor edit = pref.edit();
        this.editor = edit;
        edit.putString(KEY_UNIQUE_KEY, str);
        this.editor.commit();
    }

    public String getUniqueKey() {
        return pref.getString(KEY_UNIQUE_KEY, "");
    }

    public int getAppRateCount() {
        return pref.getInt(KEY_APP_RATE_COUNT, 0);
    }

    public void setAppRateCount(int i) {
        SharedPreferences.Editor edit = pref.edit();
        this.editor = edit;
        edit.putInt(KEY_APP_RATE_COUNT, i);
        this.editor.commit();
    }

    public int getAppRateThreshold() {
        return pref.getInt(KEY_APP_RATE_THRESHOLD, 0);
    }

    public void setAppRateThreshold(int i) {
        SharedPreferences.Editor edit = pref.edit();
        this.editor = edit;
        edit.putInt(KEY_APP_RATE_THRESHOLD, i);
        this.editor.commit();
    }

    public void setAppRaterClicked() {
        SharedPreferences.Editor edit = pref.edit();
        this.editor = edit;
        edit.putBoolean(KEY_IS_APP_RATER_CLICKED, true);
        this.editor.commit();
    }

    public boolean isAppRaterClicked() {
        return pref.getBoolean(KEY_IS_APP_RATER_CLICKED, false);
    }

    public int getAppRaterDownloadCount() {
        return pref.getInt(KEY_APP_RATER_DOWNLOAD_COUNT, 0);
    }

    public void setAppRaterDownloadCount(int i) {
        SharedPreferences.Editor edit = pref.edit();
        this.editor = edit;
        edit.putInt(KEY_APP_RATER_DOWNLOAD_COUNT, i);
        this.editor.commit();
    }

    public void setPermissionStatus(String str, boolean z) {
        SharedPreferences.Editor edit = pref.edit();
        this.editor = edit;
        edit.putBoolean(str, z);
        this.editor.commit();
    }

    public boolean getPermissionStatus(String str) {
        return pref.getBoolean(str, false);
    }

    public long getDateFirstLoadedApp() {
        return pref.getLong(KEY_DATE_RATER_COUNT, 0);
    }

    public void setDateFirstLoadedApp(long j) {
        SharedPreferences.Editor edit = pref.edit();
        this.editor = edit;
        edit.putLong(KEY_DATE_RATER_COUNT, j);
        this.editor.commit();
    }

    public String getConfigResponse() {
        return pref.getString(KEY_CONFIG_RESPONSE, "");
    }

    public void setConfigResponse(String str) {
        SharedPreferences.Editor edit = pref.edit();
        this.editor = edit;
        edit.putString(KEY_CONFIG_RESPONSE, str);
        this.editor.commit();
    }

    public void setAppVirsionCodeForForceDialog(int i) {
        SharedPreferences.Editor edit = pref.edit();
        this.editor = edit;
        edit.putInt(KEY_APP_VERSION_LAST_SHOWN, i);
        this.editor.commit();
    }

    public int getAppVersionCodeForForceDialog() {
        return pref.getInt(KEY_APP_VERSION_LAST_SHOWN, 0);
    }

    public String getVersionDate() {
        return pref.getString(KEY_VERSION_DATE, "");
    }

    public void setVersionDate(String str) {
        SharedPreferences.Editor edit = pref.edit();
        this.editor = edit;
        edit.putString(KEY_VERSION_DATE, str);
        this.editor.commit();
    }
}
