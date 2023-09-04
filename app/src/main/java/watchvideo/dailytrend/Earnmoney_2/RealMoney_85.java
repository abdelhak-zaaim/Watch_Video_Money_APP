package watchvideo.dailytrend.Earnmoney_2;

import static watchvideo.dailytrend.Earnmoney.earnmoney.quera_link;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import com.facebook.shimmer.ShimmerFrameLayout;
import watchvideo.dailytrend.Earnmoney.earnmoney;
import watchvideo.dailytrend.Earnmoney.realmoney;

import watchvideo.dailytrend.Earnmoney.realmoney14;
import watchvideo.dailytrend.Earnmoney.realmoney13;
import watchvideo.dailytrend.Earnmoney.realmoney12;
import watchvideo.dailytrend.Earnmoney.realmoney21;
import watchvideo.dailytrend.MyMoney;
import watchvideo.dailytrend.realmoney_24;
import watchvideo.dailytrend.realmoney_23;
import watchvideo.dailytrend.Earnmoney_4.earnmoney_61;
import watchvideo.dailytrend.R;
import watchvideo.dailytrend.Earnmoney_5.earnmoney_74;
import watchvideo.dailytrend.Earnmoney_5.earnmoney_71.earnmoney_72;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@SuppressLint("WrongConstant")

public class RealMoney_85 extends AppCompatActivity implements realmoney_23.timer_method {
    Animation animation;
    String[] array_numbers_30to240 = {"100", "150", "200", "250", "300", "350", "400", "450", "500", "550", "600", "650"};
    TextView atv_coin_value;
    TextView atv_spin_left_value;
    TextView atv_time_left_value;

    public BroadcastReceiver br = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            RealMoney_85.this.updateGUI(intent);
        }
    };

    ImageView btn_sin_here;
    public Dialog conform_dialog;
    List<earnmoney_72> data_number = new ArrayList();
    ImageView iv_spin;
    earnmoney_74 luckyWheel_number;
    private boolean mCustomTabsOpened = false;
    MyMoney myMoney;
    String result;

    RelativeLayout adContainerView, adContainerPlaylist;
    ShimmerFrameLayout main_act_banner;

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.realmoneygameapp);
        getWindow().setFlags(1024, 1024);

        ((ImageView) findViewById(R.id.ivback)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (earnmoney.isAdOn) {
                    if (earnmoney.ad_mode.equalsIgnoreCase("admob")) {
                        if (realmoney12.isInternetOn(RealMoney_85.this)) {
                            realmoney12.getInstance().loadintertialads(RealMoney_85.this, earnmoney.admob_inter_id, new realmoney12.MyCallback() {
                                @Override
                                public void callbackCall() {
                                    startActivity(new Intent(RealMoney_85.this, RealMoney_81.class));
                                }
                            });
                        } else {
                            startActivity(new Intent(RealMoney_85.this, RealMoney_81.class));
                        }

                    } else if (earnmoney.ad_mode.equalsIgnoreCase("qureka")) {

                        realmoney14.getInstance().qureka_inter(RealMoney_85.this, new realmoney14.MyCallback() {
                            @Override
                            public void callbackCall() {
                                startActivity(new Intent(RealMoney_85.this, RealMoney_81.class));
                            }
                        });

                    } else {

                        if (realmoney21.isInternetOn(RealMoney_85.this)) {
                            realmoney21.getInstance().loadintertialads(RealMoney_85.this, earnmoney.facebook_inter_id, new realmoney21.MyCallback() {
                                @Override
                                public void callbackCall() {
                                    startActivity(new Intent(RealMoney_85.this, RealMoney_81.class));
                                }
                            });
                        } else {
                            startActivity(new Intent(RealMoney_85.this, RealMoney_81.class));
                        }
                    }
                } else {
                    startActivity(new Intent(RealMoney_85.this, RealMoney_81.class));
                }
            }
        });


        //Banner :-
        adContainerView = findViewById(R.id.adViewContainer);
        adContainerPlaylist = findViewById(R.id.adViewContainer);
        main_act_banner = findViewById(R.id.main_act_banner);


        if (earnmoney.isAdOn) {
            if (earnmoney.ad_mode.equalsIgnoreCase("admob")) {
                realmoney.creteadadaptiveBanner(RealMoney_85.this, adContainerPlaylist, earnmoney.admob_banner_id);
            } else if (earnmoney.ad_mode.equalsIgnoreCase("qureka")) {
                main_act_banner.setVisibility(View.VISIBLE);
            } else {
                adContainerView.setBackgroundResource(R.drawable.realmoney_140);
                realmoney13.createFBLoadBanner(RealMoney_85.this, adContainerPlaylist, earnmoney.facebook_banner_id);
            }
        }


        main_act_banner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent1 = new Intent("android.intent.action.VIEW");
                    Bundle bundle = new Bundle();
                    int i = Build.VERSION.SDK_INT;
                    bundle.putBinder("android.support.customtabs.extra.SESSION", null);
                    intent1.putExtras(bundle);
                    intent1.putExtra("android.support.customtabs.extra.TOOLBAR_COLOR", R.color.colorPrimary);
                    intent1.putExtra("android.support.customtabs.extra.EXTRA_ENABLE_INSTANT_APPS", true);
                    intent1.setPackage("com.android.chrome");
                    intent1.setData(Uri.parse(quera_link));
                    startActivity(intent1, bundle);
                } catch (Exception e) {
                    e.printStackTrace();
                    Intent intent2 = new Intent("android.intent.action.VIEW");
                    Bundle bundle = new Bundle();
                    int i = Build.VERSION.SDK_INT;
                    bundle.putBinder("android.support.customtabs.extra.SESSION", null);
                    intent2.putExtras(bundle);
                    intent2.putExtra("android.support.customtabs.extra.TOOLBAR_COLOR", R.color.colorPrimary);
                    intent2.putExtra("android.support.customtabs.extra.EXTRA_ENABLE_INSTANT_APPS", true);
                    intent2.setData(Uri.parse(quera_link));
                    startActivity(intent2, bundle);

                }
            }
        });




        ((AnimationDrawable) ((RelativeLayout) findViewById(R.id.rl_number)).getBackground()).start();
        this.animation = AnimationUtils.loadAnimation(this, R.anim.moneyapp);
        this.myMoney = new MyMoney(this);
        this.atv_coin_value = (TextView) findViewById(R.id.atv_coin_value);
        this.atv_spin_left_value = (TextView) findViewById(R.id.atv_spin_left_value);
        this.atv_time_left_value = (TextView) findViewById(R.id.atv_time_left_value);
        this.iv_spin = (ImageView) findViewById(R.id.iv_spin);
        ImageView imageView = (ImageView) findViewById(R.id.btn_sin_here);
        this.btn_sin_here = imageView;


        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.startAnimation(RealMoney_85.this.animation);
                luckyWheel_number.startLuckyWheelWithTargetIndex(RealMoney_85.this.getRandomIndex_number());
            }
        });


        earnmoney_74 earnmoney74 = (earnmoney_74) findViewById(R.id.luckyWheel_number);
        this.luckyWheel_number = earnmoney74;
        earnmoney74.setVisibility(0);
        setItem_number();
        this.luckyWheel_number.setData(this.data_number);
        this.luckyWheel_number.setRound(10);

        this.luckyWheel_number.setLuckyRoundItemSelectedListener(new earnmoney_74.LuckyRoundItemSelectedListener() {
            @Override
            public void LuckyRoundItemSelected(int i) {
                if (i == 0) {
                    i++;
                }

                if (earnmoney.isAdOn) {
                    if (earnmoney.ad_mode.equalsIgnoreCase("admob")) {
                        if (realmoney12.isInternetOn(RealMoney_85.this)) {
                            int finalI1 = i;
                            realmoney12.getInstance().loadintertialads(RealMoney_85.this, earnmoney.admob_inter_id, new realmoney12.MyCallback() {
                                @Override
                                public void callbackCall() {
                                    RealMoney_85 realMoney85 = RealMoney_85.this;
                                    realMoney85.result = realMoney85.array_numbers_30to240[finalI1];
                                    RealMoney_85.this.ShowDialog();
                                }
                            });
                        } else {

                            RealMoney_85 realMoney85 = RealMoney_85.this;
                            realMoney85.result = realMoney85.array_numbers_30to240[i];
                            RealMoney_85.this.ShowDialog();
                        }

                    } else if (earnmoney.ad_mode.equalsIgnoreCase("qureka")) {

                        int finalI2 = i;
                        realmoney14.getInstance().qureka_inter(RealMoney_85.this, new realmoney14.MyCallback() {
                            @Override
                            public void callbackCall() {
                                RealMoney_85 realMoney85 = RealMoney_85.this;
                                realMoney85.result = realMoney85.array_numbers_30to240[finalI2];
                                RealMoney_85.this.ShowDialog();
                            }
                        });

                    } else {

                        if (realmoney21.isInternetOn(RealMoney_85.this)) {
                            int finalI = i;
                            realmoney21.getInstance().loadintertialads(RealMoney_85.this, earnmoney.facebook_inter_id, new realmoney21.MyCallback() {
                                @Override
                                public void callbackCall() {

                                    RealMoney_85 realMoney85 = RealMoney_85.this;
                                    realMoney85.result = realMoney85.array_numbers_30to240[finalI];
                                    RealMoney_85.this.ShowDialog();
                                }
                            });
                        } else {

                            RealMoney_85 realMoney85 = RealMoney_85.this;
                            realMoney85.result = realMoney85.array_numbers_30to240[i];
                            RealMoney_85.this.ShowDialog();
                        }
                    }
                } else {

                    RealMoney_85 realMoney85 = RealMoney_85.this;
                    realMoney85.result = realMoney85.array_numbers_30to240[i];
                    RealMoney_85.this.ShowDialog();
                }

            }
        });

    }

    public int getRandomIndex_number() {
        return new Random().nextInt(this.data_number.size());
    }

    private void setItem_number() {
        earnmoney_72 earnmoney72 = new earnmoney_72();
        earnmoney72.topText = "100";
        earnmoney72.icon = R.drawable.watchvideoearnmoney_29;
        earnmoney72.color = getResources().getColor(R.color.one);
        this.data_number.add(earnmoney72);
        earnmoney_72 earnmoney722 = new earnmoney_72();
        earnmoney722.topText = "150";
        earnmoney722.icon = R.drawable.watchvideoearnmoney_29;
        earnmoney722.color = getResources().getColor(R.color.two);
        this.data_number.add(earnmoney722);
        earnmoney_72 earnmoney723 = new earnmoney_72();
        earnmoney723.topText = "200";
        earnmoney723.icon = R.drawable.watchvideoearnmoney_29;
        earnmoney723.color = getResources().getColor(R.color.one);
        this.data_number.add(earnmoney723);
        earnmoney_72 earnmoney724 = new earnmoney_72();
        earnmoney724.topText = "250";
        earnmoney724.icon = R.drawable.watchvideoearnmoney_29;
        earnmoney724.color = getResources().getColor(R.color.two);
        this.data_number.add(earnmoney724);
        earnmoney_72 earnmoney725 = new earnmoney_72();
        earnmoney725.topText = "300";
        earnmoney725.icon = R.drawable.watchvideoearnmoney_29;
        earnmoney725.color = getResources().getColor(R.color.one);
        this.data_number.add(earnmoney725);
        earnmoney_72 earnmoney726 = new earnmoney_72();
        earnmoney726.topText = "350";
        earnmoney726.icon = R.drawable.watchvideoearnmoney_29;
        earnmoney726.color = getResources().getColor(R.color.two);
        this.data_number.add(earnmoney726);
        earnmoney_72 earnmoney727 = new earnmoney_72();
        earnmoney727.topText = "400";
        earnmoney727.icon = R.drawable.watchvideoearnmoney_29;
        earnmoney727.color = getResources().getColor(R.color.one);
        this.data_number.add(earnmoney727);
        earnmoney_72 earnmoney728 = new earnmoney_72();
        earnmoney728.topText = "450";
        earnmoney728.icon = R.drawable.watchvideoearnmoney_29;
        earnmoney728.color = getResources().getColor(R.color.two);
        this.data_number.add(earnmoney728);
        earnmoney_72 earnmoney729 = new earnmoney_72();
        earnmoney729.topText = "500";
        earnmoney729.icon = R.drawable.watchvideoearnmoney_29;
        earnmoney729.color = getResources().getColor(R.color.one);
        this.data_number.add(earnmoney729);
        earnmoney_72 earnmoney7210 = new earnmoney_72();
        earnmoney7210.topText = "550";
        earnmoney7210.icon = R.drawable.watchvideoearnmoney_29;
        earnmoney7210.color = getResources().getColor(R.color.two);
        this.data_number.add(earnmoney7210);
        earnmoney_72 earnmoney7211 = new earnmoney_72();
        earnmoney7211.topText = "600";
        earnmoney7211.icon = R.drawable.watchvideoearnmoney_29;
        earnmoney7211.color = getResources().getColor(R.color.one);
        this.data_number.add(earnmoney7211);
        earnmoney_72 earnmoney7212 = new earnmoney_72();
        earnmoney7212.topText = "650";
        earnmoney7212.icon = R.drawable.watchvideoearnmoney_29;
        earnmoney7212.color = getResources().getColor(R.color.two);
        this.data_number.add(earnmoney7212);
    }


    public void ShowDialog() {
        Dialog dialog = new Dialog(this, R.style.creativeDialogTheme);
        this.conform_dialog = dialog;
        dialog.setContentView(R.layout.earnmoneywatchvideo);
        this.conform_dialog.setCancelable(false);
        ((TextView) this.conform_dialog.findViewById(R.id.atv_point_value)).setText(this.result + " Points Added Successfully.");

        ((ImageView) this.conform_dialog.findViewById(R.id.btn_get_points)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RealMoney_85.this.conform_dialog.dismiss();
                if (!realmoney_24.is_first) {
                    realmoney_24.is_first = true;
                }

                RealMoney_85.this.myMoney.setPref(MyMoney.POINTS, RealMoney_85.this.myMoney.getPref(MyMoney.POINTS, 0).intValue() + Integer.parseInt(RealMoney_85.this.result));
                TextView textView = RealMoney_85.this.atv_coin_value;
                textView.setText("" + RealMoney_85.this.myMoney.getPref(MyMoney.POINTS, 0));
                int intValue = RealMoney_85.this.myMoney.getPref(MyMoney.SPIN_LEFT, 0).intValue();

                if (intValue != 0) {
                    RealMoney_85.this.btn_sin_here.setEnabled(true);
                    int i = intValue - 1;
                    RealMoney_85.this.myMoney.setPref(MyMoney.SPIN_LEFT, i);
                    MyMoney myMoney = RealMoney_85.this.myMoney;
                    myMoney.setPref(MyMoney.SPIN_COUNT, RealMoney_85.this.myMoney.getPref(MyMoney.SPIN_COUNT, 0).intValue() + Integer.parseInt(RealMoney_85.this.result));
                    // this.spin_count.setText(""+Integer.valueOf(this.myMoney.getPref(MyMoney.SPIN_COUNT, 0)));
                    TextView textView2 = RealMoney_85.this.atv_spin_left_value;
                    textView2.setText("" + Integer.valueOf(RealMoney_85.this.myMoney.getPref(MyMoney.SPIN_LEFT, 0)));

                    if (i != 0) {
                        RealMoney_85 realMoney85 = RealMoney_85.this;
                        realMoney85.startService(new Intent(realMoney85, realmoney_23.class));
                        return;
                    }
                    RealMoney_85.this.btn_sin_here.setEnabled(false);
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault());
                    Calendar instance = Calendar.getInstance();
                    instance.setTime(new Date());
                    instance.add(5, 1);
                    RealMoney_85.this.myMoney.setPref(MyMoney.AFTER_TWO_HOUR, simpleDateFormat.format(instance.getTime()));
                    String format = new SimpleDateFormat("HH:mm:ss").format(instance.getTime());
                    RealMoney_85.this.atv_time_left_value.setText(new SimpleDateFormat("hh:mm aa").format(instance.getTime()));
                    RealMoney_85.this.btn_sin_here.setEnabled(false);
                    RealMoney_85.this.Notification(format);
                }
            }
        });
        this.conform_dialog.show();
    }


    @Override
    public void tik_tik(long j) {
        this.btn_sin_here.setEnabled(false);
        long seconds = TimeUnit.MILLISECONDS.toSeconds(j);
        TextView textView = this.atv_time_left_value;
        textView.setText(seconds + "");
    }


    @Override
    public void tik_onFinish(Boolean bool) {
        this.btn_sin_here.setEnabled(true);
        stopService(new Intent(this, realmoney_23.class));
    }


    public void updateGUI(Intent intent) {
        if (intent.getExtras() == null) {
            return;
        }
        if (intent.getBooleanExtra("start", false)) {
            this.btn_sin_here.setEnabled(false);
            long longExtra = intent.getLongExtra("countdown", 0);
            TextView textView = this.atv_time_left_value;
            textView.setText(longExtra + "");
            return;
        }
        this.btn_sin_here.setEnabled(true);
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

        ((AlarmManager) getSystemService(NotificationCompat.CATEGORY_ALARM)).setRepeating(0, instance.getTimeInMillis(), 86400000, PendingIntent.getBroadcast(this, 10000, new Intent(this, earnmoney_61.class), PendingIntent.FLAG_IMMUTABLE));

    }

    @Override
    public void onBackPressed() {
        if (earnmoney.isAdOn) {
            if (earnmoney.ad_mode.equalsIgnoreCase("admob")) {
                if (realmoney12.isInternetOn(RealMoney_85.this)) {
                    realmoney12.getInstance().loadintertialads(RealMoney_85.this, earnmoney.admob_inter_id, new realmoney12.MyCallback() {
                        @Override
                        public void callbackCall() {
                            startActivity(new Intent(RealMoney_85.this, RealMoney_81.class));
                        }
                    });
                } else {
                    startActivity(new Intent(RealMoney_85.this, RealMoney_81.class));
                }

            } else if (earnmoney.ad_mode.equalsIgnoreCase("qureka")) {

                realmoney14.getInstance().qureka_inter(RealMoney_85.this, new realmoney14.MyCallback() {
                    @Override
                    public void callbackCall() {
                        startActivity(new Intent(RealMoney_85.this, RealMoney_81.class));
                    }
                });

            } else {

                if (realmoney21.isInternetOn(RealMoney_85.this)) {
                    realmoney21.getInstance().loadintertialads(RealMoney_85.this, earnmoney.facebook_inter_id, new realmoney21.MyCallback() {
                        @Override
                        public void callbackCall() {
                            startActivity(new Intent(RealMoney_85.this, RealMoney_81.class));
                        }
                    });
                } else {
                    startActivity(new Intent(RealMoney_85.this, RealMoney_81.class));
                }
            }
        } else {
            startActivity(new Intent(RealMoney_85.this, RealMoney_81.class));
        }

    }

    @Override
    public void onResume() {
        registerReceiver(this.br, new IntentFilter(getPackageName()));
        realmoney_23.activity = this;
        TextView textView = this.atv_coin_value;
        textView.setText("" + this.myMoney.getPref(MyMoney.POINTS, 0));
        TextView textView2 = this.atv_spin_left_value;
        textView2.setText("" + this.myMoney.getPref(MyMoney.SPIN_LEFT, 0));
        if (this.myMoney.getPref(MyMoney.SPIN_LEFT, 0).intValue() == 0) {
            this.btn_sin_here.setEnabled(false);
        } else {
            this.btn_sin_here.setEnabled(true);
        }
        super.onResume();
        if (this.mCustomTabsOpened) {
            this.mCustomTabsOpened = false;
            finish();
        }
        String pref = this.myMoney.getPref(MyMoney.AFTER_TWO_HOUR, "");
        if (!pref.equalsIgnoreCase("")) {
            Date date = null;
            try {
                date = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).parse(pref);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            if (System.currentTimeMillis() > date.getTime()) {
                this.myMoney.setPref(MyMoney.AFTER_TWO_HOUR, "");
                this.myMoney.setPref(MyMoney.SPIN_LEFT, 5);
                TextView textView3 = this.atv_spin_left_value;
                textView3.setText("" + this.myMoney.getPref(MyMoney.SPIN_LEFT, 0));
                this.atv_time_left_value.setText("00");
                this.btn_sin_here.setEnabled(true);
                return;
            }
            this.btn_sin_here.setEnabled(false);
            String format = new SimpleDateFormat("HH:mm:ss").format(Long.valueOf(date.getTime()));
            this.atv_time_left_value.setText(new SimpleDateFormat("hh:mm aa").format(Long.valueOf(date.getTime())));
            Notification(format);
            return;
        }
        this.btn_sin_here.setEnabled(true);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

}
