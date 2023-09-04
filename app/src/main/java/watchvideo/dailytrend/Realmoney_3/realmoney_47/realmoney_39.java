package watchvideo.dailytrend.Realmoney_3.realmoney_47;

import android.os.Build;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import watchvideo.dailytrend.R;
import watchvideo.dailytrend.Realmoney_3.realmoney_36.earnmoney_50.earnmoney_48;
import watchvideo.dailytrend.Realmoney_3.earnmoney_46.earnmoney_44;

public class realmoney_39 extends earnmoney_44 {
    public static boolean isMainActivityRunning = false;
    Toolbar toolbar;

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.realmoneygames);
        isMainActivityRunning = true;
        this.toolbar = (Toolbar) findViewById(R.id.toolbar);
        setUpDesign();
        setPager();
        isStoragePermissionGranted();
    }

    public boolean isStoragePermissionGranted() {
        if (Build.VERSION.SDK_INT < 23 || checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
            return true;
        }
        ActivityCompat.requestPermissions(this, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 1);
        return false;
    }

    public void setPager() {
        getSupportFragmentManager().beginTransaction().replace(R.id.viewpager, earnmoney_48.getInstance()).addToBackStack(null).commitAllowingStateLoss();
    }

    public void setUpDesign() {
        setSupportActionBar(this.toolbar);
    }

    @Override 
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        int i2 = iArr[0];
    }

    @Override 
    public void onBackPressed() {
        isMainActivityRunning = false;
        super.onBackPressed();
        finish();
    }
}
