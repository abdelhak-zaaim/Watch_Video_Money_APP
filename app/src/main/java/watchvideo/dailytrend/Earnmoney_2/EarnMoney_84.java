package watchvideo.dailytrend.Earnmoney_2;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.Nullable;

import watchvideo.dailytrend.R;

public class EarnMoney_84 extends Activity {

    private static int OUT_TIME = 3000;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.realmoneyrealmoneyapp);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                finishAffinity();
                finish();
                System.exit(1);
            }
        }, OUT_TIME);

    }

    @Override
    public void onBackPressed() {
        finishAffinity();
    }

}
