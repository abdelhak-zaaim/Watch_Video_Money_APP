package watchvideo.dailytrend.Earnmoney_2;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import com.anupkumarpanwar.scratchview.ScratchView;
import com.facebook.ads.NativeAdLayout;
import com.facebook.shimmer.ShimmerFrameLayout;
import watchvideo.dailytrend.Earnmoney.earnmoney;
import watchvideo.dailytrend.Earnmoney.realmoney;

import watchvideo.dailytrend.Earnmoney.realmoney14;
import watchvideo.dailytrend.Earnmoney.realmoney13;
import watchvideo.dailytrend.Earnmoney.realmoney12;
import watchvideo.dailytrend.Earnmoney.realmoney21;
import watchvideo.dailytrend.MyMoney;
import watchvideo.dailytrend.R;
import watchvideo.dailytrend.earnmoney_23;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@SuppressLint("WrongConstant")

public class ScratchCard extends AppCompatActivity implements earnmoney_23.timer_method {

    Animation animation;
    TextView atv_coin_value;
    TextView atv_hours_value;
    TextView atv_scratch_left_value;
    TextView atv_seconds_value;
    TextView atv_time_left_value;

    private BroadcastReceiver br = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            ScratchCard.this.updateGUI(intent);
        }
    };

    public Dialog conform_dialog;
    ImageView iv_coin;
    LinearLayout ll_hours;
    LinearLayout ll_seconds;
    private boolean mCustomTabsOpened = false;
    MyMoney myMoney;
    RelativeLayout rl_saratch;
    RelativeLayout rl_time;
    ScratchView scratch_view;
    TextView tv_value;
    TextView tv_value1;

    RelativeLayout hscrollContainer;
    FrameLayout admob_native;
    NativeAdLayout nativeAdLayout;
    ShimmerFrameLayout qureka_banner;

    @Override 
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.realmoneyapp);
        getWindow().setFlags(1024, 1024);
        this.animation = AnimationUtils.loadAnimation(this, R.anim.moneyapp);
        this.myMoney = new MyMoney(this);

        ((ImageView) findViewById(R.id.ivback)).setOnClickListener(new View.OnClickListener() {
            @Override 
            public void onClick(View view) {
                if (earnmoney.isAdOn) {
                    if (earnmoney.ad_mode.equalsIgnoreCase("admob")) {
                        if (realmoney12.isInternetOn(ScratchCard.this)) {
                            realmoney12.getInstance().loadintertialads(ScratchCard.this, earnmoney.admob_inter_id, new realmoney12.MyCallback() {
                                @Override
                                public void callbackCall() {
                                    startActivity(new Intent(ScratchCard.this, EarnMoney_82.class));
                                }
                            });
                        } else {
                            startActivity(new Intent(ScratchCard.this, EarnMoney_82.class));
                        }

                    } else if (earnmoney.ad_mode.equalsIgnoreCase("qureka")) {

                        realmoney14.getInstance().qureka_inter(ScratchCard.this, new realmoney14.MyCallback() {
                            @Override
                            public void callbackCall() {
                                startActivity(new Intent(ScratchCard.this, EarnMoney_82.class));
                            }
                        });

                    } else {

                        if (realmoney21.isInternetOn(ScratchCard.this)) {
                            realmoney21.getInstance().loadintertialads(ScratchCard.this, earnmoney.facebook_inter_id, new realmoney21.MyCallback() {
                                @Override
                                public void callbackCall() {
                                    startActivity(new Intent(ScratchCard.this, EarnMoney_82.class));
                                }
                            });
                        } else {
                            startActivity(new Intent(ScratchCard.this, EarnMoney_82.class));
                        }
                    }
                } else {
                    startActivity(new Intent(ScratchCard.this, EarnMoney_82.class));
                }

            }
        });


        /// Native Ads :-
        hscrollContainer = findViewById(R.id.hscrollContainer);
        admob_native = findViewById(R.id.admob_native);
        nativeAdLayout = findViewById(R.id.fb_native);
        qureka_banner = findViewById(R.id.qureka_banner);


        if (earnmoney.isAdOn) {
            if (earnmoney.ad_mode.equalsIgnoreCase("admob")) {
                realmoney.Admobnative1(getApplicationContext(), admob_native, earnmoney.admob_native_id);
            } else if (earnmoney.ad_mode.equalsIgnoreCase("qureka")) {
                qureka_banner.setVisibility(View.VISIBLE);
            } else {
                hscrollContainer.setBackgroundResource(R.drawable.realmoney_140);
                realmoney13.loadNativeAd(getApplicationContext(), nativeAdLayout, earnmoney.facebook_native_id);
            }
        }


        this.tv_value = (TextView) findViewById(R.id.tv_value);
        this.tv_value1 = (TextView) findViewById(R.id.tv_value1);
        this.iv_coin = (ImageView) findViewById(R.id.iv_coin);
        this.rl_saratch = (RelativeLayout) findViewById(R.id.rl_saratch);
        this.rl_time = (RelativeLayout) findViewById(R.id.rl_time);
        this.ll_seconds = (LinearLayout) findViewById(R.id.ll_seconds);
        this.ll_hours = (LinearLayout) findViewById(R.id.ll_hours);
        this.atv_seconds_value = (TextView) findViewById(R.id.atv_seconds_value);
        this.atv_hours_value = (TextView) findViewById(R.id.atv_hours_value);
        this.atv_coin_value = (TextView) findViewById(R.id.atv_coin_value);
        this.atv_scratch_left_value = (TextView) findViewById(R.id.atv_scratch_left_value);
        this.atv_time_left_value = (TextView) findViewById(R.id.atv_time_left_value);
        ScratchView scratchView = (ScratchView) findViewById(R.id.scratch_view);
        this.scratch_view = scratchView;

        if (Build.VERSION.SDK_INT >= 19) {
            scratchView.setRevealListener(new ScratchView.IRevealListener() {
                @Override
                public void onRevealed(ScratchView scratchView) {
                    ScratchCard.this.tv_value.setText("You've Won");
                    ScratchCard.this.iv_coin.setImageResource(R.drawable.real_money9);
                    TextView textView = ScratchCard.this.tv_value1;
                    textView.setText("" + ScratchCard.this.getRandomIndex_number());
                    ScratchCard.this.ShowDialog();
                }

                @Override 
                public void onRevealPercentChangedListener(ScratchView scratchView, float f) {
                    if (((double) f) >= 0.5d) {
                        Log.d("Reveal Percentage", "onRevealPercentChangedListener: " + String.valueOf(f));
                    }
                }
            });
        }

    }


    public int getRandomIndex_number() {
        return new Random().nextInt(200) + 100;
    }


    public void ShowDialog() {
        Dialog dialog = new Dialog(this, R.style.creativeDialogTheme);
        this.conform_dialog = dialog;
        dialog.setContentView(R.layout.earnmoneywatchvideo);
        this.conform_dialog.setCancelable(false);
        ((TextView) this.conform_dialog.findViewById(R.id.atv_point_value)).setText(this.tv_value1.getText().toString() + " Points Added Successfully.");

        ((ImageView) this.conform_dialog.findViewById(R.id.btn_get_points)).setOnClickListener(new View.OnClickListener() {
            @Override 
            public void onClick(View view) {
                ScratchCard.this.conform_dialog.dismiss();
                ScratchCard.this.myMoney.setPref(MyMoney.POINTS, ScratchCard.this.myMoney.getPref(MyMoney.POINTS, 0).intValue() + Integer.parseInt(ScratchCard.this.tv_value1.getText().toString()));
                TextView textView = ScratchCard.this.atv_coin_value;
                textView.setText("" + ScratchCard.this.myMoney.getPref(MyMoney.POINTS, 0));
                int intValue = ScratchCard.this.myMoney.getPref(MyMoney.SCRATCH_LEFT, 0).intValue();
                if (intValue != 0) {
                    ScratchCard.this.rl_saratch.setVisibility(View.GONE);
                    ScratchCard.this.rl_time.setVisibility(View.VISIBLE);
                    ScratchCard.this.ll_seconds.setVisibility(View.VISIBLE);
                    ScratchCard.this.ll_hours.setVisibility(View.GONE);
                    int i = intValue - 1;
                    ScratchCard.this.myMoney.setPref(MyMoney.SCRATCH_LEFT, i);
                    ScratchCard.this.myMoney.setPref(MyMoney.SCRATCH_COUNT, ScratchCard.this.myMoney.getPref(MyMoney.SCRATCH_COUNT, 0).intValue() + Integer.parseInt(ScratchCard.this.tv_value1.getText().toString()));
                    TextView textView2 = ScratchCard.this.atv_scratch_left_value;
                    textView2.setText("" + ScratchCard.this.myMoney.getPref(MyMoney.SCRATCH_LEFT, 0));
                    if (i != 0) {
                        ScratchCard scratchCardActivity = ScratchCard.this;
                        scratchCardActivity.startService(new Intent(scratchCardActivity, earnmoney_23.class));
                        return;
                    }
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault());
                    Calendar instance = Calendar.getInstance();
                    instance.setTime(new Date());
                    instance.add(5, 1);
                    ScratchCard.this.myMoney.setPref(MyMoney.AFTER_TWO_HOUR_SCRATCH, simpleDateFormat.format(instance.getTime()));
                    ScratchCard.this.Notification(new SimpleDateFormat("HH:mm:ss").format(instance.getTime()));
                    String format = new SimpleDateFormat("hh:mm aa").format(instance.getTime());
                    ScratchCard.this.atv_time_left_value.setText(format);
                    ScratchCard.this.atv_hours_value.setText(format);
                    ScratchCard.this.rl_saratch.setVisibility(View.GONE);
                    ScratchCard.this.rl_time.setVisibility(View.VISIBLE);
                    ScratchCard.this.ll_seconds.setVisibility(View.GONE);
                    ScratchCard.this.ll_hours.setVisibility(View.VISIBLE);
                }
            }
        });

        this.conform_dialog.show();

    }


    @Override
    public void tik_tok(long j) {
        long seconds = TimeUnit.MILLISECONDS.toSeconds(j);
        TextView textView = this.atv_time_left_value;
        textView.setText(seconds + "");
        TextView textView2 = this.atv_seconds_value;
        textView2.setText("Please Wait " + seconds + " Seconds");
    }


    @Override
    public void tik_onFinish(Boolean bool) {
        this.rl_saratch.setVisibility(View.VISIBLE);
        this.rl_time.setVisibility(View.GONE);
        this.ll_seconds.setVisibility(View.GONE);
        this.ll_hours.setVisibility(View.GONE);
        stopService(new Intent(this, earnmoney_23.class));
    }


    public void updateGUI(Intent intent) {
        if (intent.getExtras() == null) {
            return;
        }
        if (intent.getBooleanExtra("start", false)) {
            this.rl_saratch.setVisibility(View.GONE);
            this.rl_time.setVisibility(View.VISIBLE);
            this.ll_seconds.setVisibility(View.VISIBLE);
            this.ll_hours.setVisibility(View.GONE);
            long longExtra = intent.getLongExtra("countdown", 0);
            TextView textView = this.atv_time_left_value;
            textView.setText(longExtra + "");
            TextView textView2 = this.atv_seconds_value;
            textView2.setText("Please Wait " + longExtra + " Seconds");
            return;
        }
        this.rl_saratch.setVisibility(View.VISIBLE);
        this.rl_time.setVisibility(View.GONE);
        this.ll_seconds.setVisibility(View.GONE);
        this.ll_hours.setVisibility(View.GONE);
    }


    @SuppressLint("InlinedApi")
    public void Notification(String str) {
        String[] split = str.split(":");
        int parseInt = Integer.parseInt(split[0]);
        int parseInt2 = Integer.parseInt(split[1]);
        int parseInt3 = Integer.parseInt(split[2]);
        Calendar instance = Calendar.getInstance();
        instance.set(11, parseInt);
        instance.set(12, parseInt2);
        instance.set(13, parseInt3);
        instance.set(14, 0);
        if (Calendar.getInstance().after(instance)) {
            instance.add(5, 1);
        }

        ((AlarmManager) getSystemService(NotificationCompat.CATEGORY_ALARM)).setRepeating(0, instance.getTimeInMillis(), 86400000, PendingIntent.getBroadcast(this, 10000, new Intent(this, watchvideo.dailytrend.Earnmoney_4.ScratchCard.class), PendingIntent.FLAG_IMMUTABLE));

    }


    @Override 
    public void onBackPressed() {
        if (earnmoney.isAdOn) {
            if (earnmoney.ad_mode.equalsIgnoreCase("admob")) {
                if (realmoney12.isInternetOn(ScratchCard.this)) {
                    realmoney12.getInstance().loadintertialads(ScratchCard.this, earnmoney.admob_inter_id, new realmoney12.MyCallback() {
                        @Override
                        public void callbackCall() {
                            startActivity(new Intent(ScratchCard.this, EarnMoney_82.class));
                        }
                    });
                } else {
                    startActivity(new Intent(ScratchCard.this, EarnMoney_82.class));
                }

            } else if (earnmoney.ad_mode.equalsIgnoreCase("qureka")) {

                realmoney14.getInstance().qureka_inter(ScratchCard.this, new realmoney14.MyCallback() {
                    @Override
                    public void callbackCall() {
                        startActivity(new Intent(ScratchCard.this, EarnMoney_82.class));
                    }
                });

            } else {

                if (realmoney21.isInternetOn(ScratchCard.this)) {
                    realmoney21.getInstance().loadintertialads(ScratchCard.this, earnmoney.facebook_inter_id, new realmoney21.MyCallback() {
                        @Override
                        public void callbackCall() {
                            startActivity(new Intent(ScratchCard.this, EarnMoney_82.class));
                        }
                    });
                } else {
                    startActivity(new Intent(ScratchCard.this, EarnMoney_82.class));
                }
            }
        } else {
            startActivity(new Intent(ScratchCard.this, EarnMoney_82.class));
        }
    }


    @Override 
    public void onResume() {
        registerReceiver(this.br, new IntentFilter(earnmoney_23.COUNTDOWN_BR));
        earnmoney_23.activity = this;
        TextView textView = this.atv_coin_value;
        textView.setText("" + this.myMoney.getPref(MyMoney.POINTS, 0));
        TextView textView2 = this.atv_scratch_left_value;
        textView2.setText("" + this.myMoney.getPref(MyMoney.SCRATCH_LEFT, 0));

        if (this.myMoney.getPref(MyMoney.SCRATCH_LEFT, 0).intValue() == 0) {
            this.rl_saratch.setVisibility(View.GONE);
            this.rl_time.setVisibility(View.VISIBLE);
            this.ll_seconds.setVisibility(View.GONE);
            this.ll_hours.setVisibility(View.VISIBLE);
        } else {
            this.rl_saratch.setVisibility(View.VISIBLE);
            this.rl_time.setVisibility(View.GONE);
            this.ll_seconds.setVisibility(View.GONE);
            this.ll_hours.setVisibility(View.GONE);
        }

        super.onResume();

        if (this.mCustomTabsOpened) {
            this.mCustomTabsOpened = false;
            finish();
        }

        String pref = this.myMoney.getPref(MyMoney.AFTER_TWO_HOUR_SCRATCH, "");
        if (!pref.equalsIgnoreCase("")) {
            Date date = null;
            try {
                date = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).parse(pref);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            if (System.currentTimeMillis() > date.getTime()) {
                this.myMoney.setPref(MyMoney.AFTER_TWO_HOUR_SCRATCH, "");
                this.myMoney.setPref(MyMoney.SCRATCH_LEFT, 5);
                TextView textView3 = this.atv_scratch_left_value;
                textView3.setText("" + this.myMoney.getPref(MyMoney.SCRATCH_LEFT, 0));
                this.atv_time_left_value.setText("00");
                this.atv_hours_value.setText("00");
                this.rl_saratch.setVisibility(View.VISIBLE);
                this.rl_time.setVisibility(View.GONE);
                this.ll_seconds.setVisibility(View.GONE);
                this.ll_hours.setVisibility(View.GONE);
                return;
            }

            this.rl_saratch.setVisibility(View.GONE);
            this.rl_time.setVisibility(View.VISIBLE);
            this.ll_seconds.setVisibility(View.GONE);
            this.ll_hours.setVisibility(View.VISIBLE);
            Notification(new SimpleDateFormat("HH:mm:ss").format(Long.valueOf(date.getTime())));
            String format = new SimpleDateFormat("hh:mm aa").format(Long.valueOf(date.getTime()));
            this.atv_time_left_value.setText(format);
            this.atv_hours_value.setText(format);
            return;
        }

        this.rl_saratch.setVisibility(View.VISIBLE);
        this.rl_time.setVisibility(View.GONE);
        this.ll_seconds.setVisibility(View.GONE);
        this.ll_hours.setVisibility(View.GONE);

    }


    @Override 
    public void onDestroy() {
        super.onDestroy();
    }


}
