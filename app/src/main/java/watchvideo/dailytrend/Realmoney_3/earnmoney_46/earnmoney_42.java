package watchvideo.dailytrend.Realmoney_3.earnmoney_46;

import android.annotation.SuppressLint;
import android.app.NotificationManager;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.google.android.exoplayer2.util.MimeTypes;
import watchvideo.dailytrend.Realmoney_3.realmoney_35.earnmoney_34.realmoney_26;
import java.io.File;

public class earnmoney_42 extends BroadcastReceiver {
    public static final String EXTRA_NOTIFICATION_ID = "id";

    @SuppressLint("WrongConstant")
    @Override
    public void onReceive(Context context, Intent intent) {
        context.sendBroadcast(new Intent("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        int intExtra = intent.getIntExtra("id", 0);
        int intExtra2 = intent.getIntExtra(earnmoney_44.EXTRA_ACTION, 0);
        File createFile = earnmoney_45.createFile((realmoney_26) intent.getSerializableExtra(earnmoney_44.EXTRA_MODEL_VIDEO));
        if (createFile != null) {
            Uri fromFile = Uri.fromFile(createFile);
            if (intExtra2 == 6) {
                Intent intent2 = new Intent("android.intent.action.VIEW", fromFile);
                intent2.setDataAndType(fromFile, "audio/*");
                  try {
                    context.startActivity(intent2);
                } catch (ActivityNotFoundException e) {
                    e.printStackTrace();
                }
            } else {
                Intent intent3 = new Intent("android.intent.action.VIEW", fromFile);
                intent3.setDataAndType(fromFile, MimeTypes.VIDEO_MP4);
                  try {
                    context.startActivity(intent3);
                } catch (ActivityNotFoundException e2) {
                    e2.printStackTrace();
                }
            }
            ((NotificationManager) context.getSystemService("notification")).cancel(intExtra);
        }
    }
}
