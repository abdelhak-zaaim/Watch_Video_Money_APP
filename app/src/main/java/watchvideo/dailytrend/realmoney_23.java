package watchvideo.dailytrend;

import android.app.Activity;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.CountDownTimer;
import android.os.IBinder;
import android.util.Log;

public class realmoney_23 extends Service {
    public static final String COUNTDOWN_BR = "com.myphoto.phone.screendialer";
    private static final String TAG = "BroadcastService";
    public static Activity activity;
    public static realmoney_22 state = realmoney_22.IDLE;
    Intent bi = new Intent(COUNTDOWN_BR);
    public BroadcastReceiver br = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            realmoney_23.this.updateGUI(intent);
        }
    };

    CountDownTimer cdt = null;

    public interface timer_method {
        void tik_onFinish(Boolean bool);

        void tik_tik(long j);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        final timer_method timer_method2 = (timer_method) activity;
        Log.i(TAG, "Starting timer...");
        CountDownTimer r0 = new CountDownTimer(30000, 1000) {
            @Override
            public void onTick(long j) {
                StringBuilder sb = new StringBuilder();
                sb.append("Countdown seconds remaining: ");
                long j2 = j / 1000;
                sb.append(j2);
                Log.i(realmoney_23.TAG, sb.toString());
                realmoney_23.this.bi.putExtra("countdown", j2);
                realmoney_23.this.bi.putExtra("start", true);
                realmoney_23.state = realmoney_22.Counter_start;
                timer_method2.tik_tik(j);
                realmoney_23 broadcastService = realmoney_23.this;
                broadcastService.sendBroadcast(broadcastService.bi);
            }

            @Override
            public void onFinish() {
                realmoney_23.this.bi.putExtra("start", false);
                realmoney_23.state = realmoney_22.couner_Stop;
                realmoney_23 broadcastService = realmoney_23.this;
                broadcastService.sendBroadcast(broadcastService.bi);
                timer_method2.tik_onFinish(true);
                Log.i(realmoney_23.TAG, "Timer finished");
            }
        };
        this.cdt = r0;
        r0.start();
    }

    @Override
    public void onDestroy() {
        this.cdt.cancel();
        Log.i(TAG, "Timer cancelled");
        super.onDestroy();
    }

    @Override
    public int onStartCommand(Intent intent, int i, int i2) {
        return super.onStartCommand(intent, i, i2);
    }

    public void updateGUI(Intent intent) {
        if (intent.getExtras() != null) {
            long longExtra = intent.getLongExtra("countdown", 0);
            Log.i(TAG, "Countdown seconds remaining: " + (longExtra / 1000));
        }
    }

}
