package watchvideo.dailytrend.Earnmoney;

import static watchvideo.dailytrend.Earnmoney.earnmoney.quera_link;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

import watchvideo.dailytrend.R;

import java.util.Random;

public class realmoney14 {

    MyCallback myCallback;
    private static realmoney14 mInstance;

    public static realmoney14 getInstance() {
        if (mInstance == null) {
            mInstance = new realmoney14();
        }
        return mInstance;
    }

    public void qureka_inter(Activity activity, MyCallback myCallback1){

        this.myCallback = myCallback1;

        int[] Images = {R.drawable.earnmoneywatchvideo_12, R.drawable.earnmoneywatchvideo_13, R.drawable.earnmoney_123, R.drawable.earnmoneywatchvideo_15, R.drawable.realmoney4, R.drawable.realmoney, R.drawable.realmoney2, R.drawable.earnmoneywatchvideo_14, R.drawable.realmoney3, R.drawable.earnmoneywatchvideo_16};
        final Dialog dialog = new Dialog(activity);
        dialog.setContentView(R.layout.watchvideoearnmoney);
        dialog.setCancelable(false);
        Window window = dialog.getWindow();

        ImageView img = (ImageView) dialog.findViewById(R.id.native_ad_media);
        img.setImageResource(Images[new Random().nextInt(Images.length)]);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        window.setLayout(-1, -2);

        dialog.findViewById(R.id.native_ad_media).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                try {
                    Intent intent = new Intent("android.intent.action.VIEW");
                    Bundle bundle = new Bundle();
                    bundle.putBinder("android.support.customtabs.extra.SESSION", null);
                    intent.putExtras(bundle);
                    intent.putExtra("android.support.customtabs.extra.TOOLBAR_COLOR", R.color.colorPrimary);
                    intent.putExtra("android.support.customtabs.extra.EXTRA_ENABLE_INSTANT_APPS", true);
                    intent.setPackage("com.android.chrome");
                    intent.setData(Uri.parse(quera_link));
                    activity.startActivity(intent, bundle);
                } catch (Exception e) {
                    e.printStackTrace();
                    Intent intent = new Intent("android.intent.action.VIEW");
                    Bundle bundle = new Bundle();
                    bundle.putBinder("android.support.customtabs.extra.SESSION", null);
                    intent.putExtras(bundle);
                    intent.putExtra("android.support.customtabs.extra.TOOLBAR_COLOR", R.color.colorPrimary);
                    intent.putExtra("android.support.customtabs.extra.EXTRA_ENABLE_INSTANT_APPS", true);
                    intent.setData(Uri.parse(quera_link));
                    activity.startActivity(intent, bundle);
                }
            }
        });


        dialog.findViewById(R.id.close).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                if (myCallback != null) {
                    myCallback.callbackCall();
                    myCallback = null;
                }
            }
        });
        dialog.show();


    }

    public interface MyCallback {
        void callbackCall();
    }

}
