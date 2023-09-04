package watchvideo.dailytrend.Earnmoney_6.RealMoney_104;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import watchvideo.dailytrend.realmoney_24;

public class EarnMoney_102 {
    public static boolean isConnected() {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) realmoney_24.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                activeNetworkInfo.isAvailable();
            }
        } catch (Exception unused) {
        }
        return false;
    }
}
