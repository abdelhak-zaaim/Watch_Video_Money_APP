package watchvideo.dailytrend.Earnmoney_6.RealMoney_104;

import android.content.Context;
import android.os.Build;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class RealMoney_110 {
    private Context _context;

    public RealMoney_110(Context context) {
        this._context = context;
    }

    private String capitalize(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        char charAt = str.charAt(0);
        if (Character.isUpperCase(charAt)) {
            return str;
        }
        return Character.toUpperCase(charAt) + str.substring(1);
    }

    public void checkDialogs() {
        EarnMoney_103 Instance = EarnMoney_103.Instance();
        EarnMoney_103.Instance().getClass();
        String stringPref = Instance.getStringPref("share_date_count");
        if (stringPref != null) {
            try {
                if (stringPref.length() > 0) {
                    try {
                        Date convertStringToDate = RealMoney_109.Instance().convertStringToDate(stringPref, "d MMM yyyy");
                        if (convertStringToDate != null) {
                            convertStringToDate.getTime();
                            Calendar.getInstance().getTimeInMillis();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        Calendar instance = Calendar.getInstance();
        instance.add(6, 3);
        String format = DateFormat.getDateInstance(2).format(instance.getTime());
        EarnMoney_103 Instance2 = EarnMoney_103.Instance();
        EarnMoney_103.Instance().getClass();
        Instance2.putPref("share_date_count", String.valueOf(format));
        EarnMoney_103.Instance().savePref();
    }

    public String getDeviceName() {
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        if (str2.toLowerCase().startsWith(str.toLowerCase())) {
            return capitalize(str2);
        }
        return capitalize(str) + " " + str2;
    }
}
