package watchvideo.dailytrend;

import android.content.Context;
import android.content.SharedPreferences;
import org.json.JSONException;
import org.json.JSONObject;

public class MyMoney {

    public static final String AFTER_TWO_HOUR = "after_two_hour";
    public static final String AFTER_TWO_HOUR_FLIP = "after_two_flip";
    public static final String AFTER_TWO_HOUR_SCRATCH = "after_two_hour_scratch";
    public static final String AFTER_TWO_HOUR_SLOT = "after_two_hour_slot";
    public static final String AGE = "Birth_age";
    public static final String CHECK_IN_DAY = "check_in_day";
    public static final String DAILY_OFFER = "InstallOfferTimer";
    public static final String EMAIL_ID = "email_id";
    public static final String FLIP_COUNT = "flip_count";
    public static final String FLIP_LEFT = "flip_left";
    public static final String GENDER = "gender";
    public static final String MOBILE_NO = "mobile_no";
    public static final String POINTS = "points";
    private static final String PREF_NAME = "VideoCashReward";
    public static final String PREVIOUS_CHECK_IN_DATE = "previous_check_in_date";
    public static final String REFERRAL_ALREADY_USE = "referral_already_code";
    public static final String REFERRAL_CODE = "referral_code";
    public static final String SCRATCH_COUNT = "scratch_count";
    public static final String SCRATCH_LEFT = "scratch_left";
    public static final String SLOT_COUNT = "slot_count";
    public static final String SLOT_LEFT = "slot_left";
    public static final String SPIN_COUNT = "spin_count";
    public static final String SPIN_LEFT = "spin_left";
    public static final String USER_NAME = "user_name";
    SharedPreferences pref;

    public MyMoney(Context context) {
        this.pref = context.getSharedPreferences(PREF_NAME, 0);
    }

    public void setPref(String str, int i) {
        SharedPreferences.Editor edit = this.pref.edit();
        edit.putInt(str, i);
        edit.commit();
    }

    public Integer getPref(String str, int i) {
        return Integer.valueOf(this.pref.getInt(str, i));
    }

    public void setPref(String str, String str2) {
        SharedPreferences.Editor edit = this.pref.edit();
        edit.putString(str, str2);
        edit.commit();
    }

    public String getPref(String str, String str2) {
        return this.pref.getString(str, str2);
    }

    public void setPref(String str, boolean z) {
        SharedPreferences.Editor edit = this.pref.edit();
        edit.putBoolean(str, z);
        edit.commit();
    }

    public boolean getPref(String str, boolean z) {
        return this.pref.getBoolean(str, z);
    }

    public void setPref(String str, long j) {
        SharedPreferences.Editor edit = this.pref.edit();
        edit.putLong(str, j);
        edit.commit();
    }

    public long getPref(String str, long j) {
        return this.pref.getLong(str, j);
    }

    public void clearPref() {
        SharedPreferences.Editor edit = this.pref.edit();
        edit.clear();
        edit.commit();
    }

    public JSONObject GetChatReadCounter(Context context) {
        if (!this.pref.contains("ReadCounter")) {
            return new JSONObject();
        }
        try {
            return new JSONObject(getPref("ReadCounter", ""));
        } catch (JSONException unused) {
            return new JSONObject();
        }
    }

}
