package watchvideo.dailytrend.Earnmoney_6.RealMoney_104;

import android.app.Activity;
import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Environment;
import watchvideo.dailytrend.R;
import java.io.File;

public class RealMoney_107 {
    public static File getVideoDir(Activity activity, int i) {
        File file;
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        if (i == RealMoney_105.IS_FULLSCREEN_VIDEOS) {
            file = new File(externalStorageDirectory, activity.getResources().getString(R.string.dir_name) + "/");
        } else {
            file = new File(externalStorageDirectory, activity.getResources().getString(R.string.dir_name) + "/" + activity.getResources().getString(R.string.landscape));
        }
        if (!file.exists()) {
            file.mkdirs();
            file.mkdir();
        }
        return file;
    }

    public static void scanFile(Context context, File file) {
        MediaScannerConnection.scanFile(context, new String[]{file.getAbsolutePath()}, null, new MediaScannerConnection.OnScanCompletedListener() {

            @Override // android.media.MediaScannerConnection.OnScanCompletedListener
            public void onScanCompleted(String str, Uri uri) {
            }
        });
    }
}
