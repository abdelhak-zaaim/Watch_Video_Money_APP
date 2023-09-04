package watchvideo.dailytrend.Earnmoney_2;

import static watchvideo.dailytrend.Earnmoney.earnmoney.quera_link;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;

import com.facebook.ads.NativeAdLayout;
import com.facebook.shimmer.ShimmerFrameLayout;
import watchvideo.dailytrend.Earnmoney.earnmoney;
import watchvideo.dailytrend.Earnmoney.realmoney;

import watchvideo.dailytrend.Earnmoney.realmoney14;
import watchvideo.dailytrend.Earnmoney.realmoney13;
import watchvideo.dailytrend.Earnmoney.realmoney12;
import watchvideo.dailytrend.Earnmoney.realmoney21;
import watchvideo.dailytrend.MyMoney;
import watchvideo.dailytrend.Realmoney.realmoney_49;
import watchvideo.dailytrend.R;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class EarnMoney_86 extends AppCompatActivity implements View.OnClickListener {
    TextView atv_coin_value;
    Calendar cal1;
    Calendar cal2;
    public Dialog conform_dialog;
    public Dialog conform_dialog_sorry;
    String current_date;
    Date date;
    Date date1;
    Date date2;
    SimpleDateFormat dateFormat;
    int final_point;
    private boolean mCustomTabsOpened = false;
    MyMoney myMoney;
    int new_point;
    int old_point;
    String pref_date;
    RelativeLayout rl_day1;
    RelativeLayout rl_day2;
    RelativeLayout rl_day3;
    RelativeLayout rl_day4;
    RelativeLayout rl_day5;
    RelativeLayout rl_day6;
    RelativeLayout rl_day7;
    private String surfacingId = "Rewarded_Android";

    RelativeLayout hscrollContainer;
    FrameLayout admob_native;
    NativeAdLayout nativeAdLayout;
    ShimmerFrameLayout qureka_banner;

    @Override 
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(1024, 1024);
        setContentView(R.layout.earnmoneymoney);
        this.myMoney = new MyMoney(this);


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


        qureka_banner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent("android.intent.action.VIEW");
                    Bundle bundle = new Bundle();
                    bundle.putBinder("android.support.customtabs.extra.SESSION", null);
                    intent.putExtras(bundle);
                    intent.putExtra("android.support.customtabs.extra.TOOLBAR_COLOR", R.color.colorPrimary);
                    intent.putExtra("android.support.customtabs.extra.EXTRA_ENABLE_INSTANT_APPS", true);
                    intent.setPackage("com.android.chrome");
                    intent.setData(Uri.parse(quera_link));
                    startActivity(intent, bundle);
                } catch (Exception e) {
                    e.printStackTrace();
                    Intent intent = new Intent("android.intent.action.VIEW");
                    Bundle bundle = new Bundle();
                    bundle.putBinder("android.support.customtabs.extra.SESSION", null);
                    intent.putExtras(bundle);
                    intent.putExtra("android.support.customtabs.extra.TOOLBAR_COLOR", R.color.colorPrimary);
                    intent.putExtra("android.support.customtabs.extra.EXTRA_ENABLE_INSTANT_APPS", true);
                    intent.setData(Uri.parse(quera_link));
                    startActivity(intent, bundle);
                }
            }
        });


        ((ImageView) findViewById(R.id.ivback)).setOnClickListener(new View.OnClickListener() {
            @Override 
            public void onClick(View view) {
                if (earnmoney.isAdOn) {
                    if (earnmoney.ad_mode.equalsIgnoreCase("admob")) {
                        if (realmoney12.isInternetOn(EarnMoney_86.this)) {
                            realmoney12.getInstance().loadintertialads(EarnMoney_86.this, earnmoney.admob_inter_id, new realmoney12.MyCallback() {
                                @Override
                                public void callbackCall() {
                                    startActivity(new Intent(EarnMoney_86.this, EarnMoney_82.class));
                                }
                            });
                        } else {
                            startActivity(new Intent(EarnMoney_86.this, EarnMoney_82.class));
                        }
                    } else if (earnmoney.ad_mode.equalsIgnoreCase("qureka")) {

                        realmoney14.getInstance().qureka_inter(EarnMoney_86.this, new realmoney14.MyCallback() {
                            @Override
                            public void callbackCall() {
                                startActivity(new Intent(EarnMoney_86.this, EarnMoney_82.class));
                            }
                        });

                    } else {

                        if (realmoney21.isInternetOn(EarnMoney_86.this)) {
                            realmoney21.getInstance().loadintertialads(EarnMoney_86.this, earnmoney.facebook_inter_id, new realmoney21.MyCallback() {
                                @Override
                                public void callbackCall() {
                                    startActivity(new Intent(EarnMoney_86.this, EarnMoney_82.class));
                                }
                            });
                        } else {
                            startActivity(new Intent(EarnMoney_86.this, EarnMoney_82.class));
                        }
                    }

                } else {
                    startActivity(new Intent(EarnMoney_86.this, EarnMoney_82.class));
                }
            }
        });

        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.rl_day1);
        this.rl_day1 = relativeLayout;
        relativeLayout.setOnClickListener(this);
        RelativeLayout relativeLayout2 = (RelativeLayout) findViewById(R.id.rl_day2);
        this.rl_day2 = relativeLayout2;
        relativeLayout2.setOnClickListener(this);
        RelativeLayout relativeLayout3 = (RelativeLayout) findViewById(R.id.rl_day3);
        this.rl_day3 = relativeLayout3;
        relativeLayout3.setOnClickListener(this);
        RelativeLayout relativeLayout4 = (RelativeLayout) findViewById(R.id.rl_day4);
        this.rl_day4 = relativeLayout4;
        relativeLayout4.setOnClickListener(this);
        RelativeLayout relativeLayout5 = (RelativeLayout) findViewById(R.id.rl_day5);
        this.rl_day5 = relativeLayout5;
        relativeLayout5.setOnClickListener(this);
        RelativeLayout relativeLayout6 = (RelativeLayout) findViewById(R.id.rl_day6);
        this.rl_day6 = relativeLayout6;
        relativeLayout6.setOnClickListener(this);
        RelativeLayout relativeLayout7 = (RelativeLayout) findViewById(R.id.rl_day7);
        this.rl_day7 = relativeLayout7;
        relativeLayout7.setOnClickListener(this);
        this.atv_coin_value = (TextView) findViewById(R.id.atv_coin_value);
        this.dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Check_In();
    }

    @Override 
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rl_day1:
                if (this.myMoney.getPref(MyMoney.PREVIOUS_CHECK_IN_DATE, "").isEmpty()) {
                    int intValue = this.myMoney.getPref(MyMoney.POINTS, 0).intValue();
                    this.old_point = intValue;
                    this.new_point = 100;
                    int i = intValue + 100;
                    this.final_point = i;
                    this.myMoney.setPref(MyMoney.POINTS, i);
                    TextView textView = this.atv_coin_value;
                    textView.setText("" + this.myMoney.getPref(MyMoney.POINTS, 0));
                    Date date3 = new Date();
                    this.date = date3;
                    String format = this.dateFormat.format(date3);
                    this.current_date = format;
                    this.myMoney.setPref(MyMoney.PREVIOUS_CHECK_IN_DATE, format);
                    this.myMoney.setPref(MyMoney.CHECK_IN_DAY, 1);
                    ShowDialog("100");
                    Check_In();
                    return;
                }
                this.pref_date = this.myMoney.getPref(MyMoney.PREVIOUS_CHECK_IN_DATE, "");
                this.dateFormat = new SimpleDateFormat("yyyy/MM/dd");
                Date date4 = new Date();
                this.date = date4;
                this.current_date = this.dateFormat.format(date4);
                try {
                    this.date1 = this.dateFormat.parse(this.pref_date);
                    this.date2 = this.dateFormat.parse(this.current_date);
                    this.cal1 = Calendar.getInstance();
                    this.cal2 = Calendar.getInstance();
                    this.cal1.setTime(this.date1);
                    this.cal2.setTime(this.date2);
                    if (this.cal1.before(this.cal2)) {
                        int intValue2 = this.myMoney.getPref(MyMoney.POINTS, 0).intValue();
                        this.old_point = intValue2;
                        this.new_point = 100;
                        int i2 = intValue2 + 100;
                        this.final_point = i2;
                        this.myMoney.setPref(MyMoney.POINTS, i2);
                        TextView textView2 = this.atv_coin_value;
                        textView2.setText("" + this.myMoney.getPref(MyMoney.POINTS, 0));
                        Date date5 = new Date();
                        this.date = date5;
                        String format2 = this.dateFormat.format(date5);
                        this.current_date = format2;
                        this.myMoney.setPref(MyMoney.PREVIOUS_CHECK_IN_DATE, format2);
                        this.myMoney.setPref(MyMoney.CHECK_IN_DAY, 1);
                        ShowDialog("100");
                        Check_In();
                        return;
                    }
                    SorryDialog();
                    return;
                } catch (ParseException e) {
                    e.printStackTrace();
                    return;
                }

            case R.id.rl_day2:
                this.pref_date = this.myMoney.getPref(MyMoney.PREVIOUS_CHECK_IN_DATE, "");
                this.dateFormat = new SimpleDateFormat("yyyy/MM/dd");
                Date date6 = new Date();
                this.date = date6;
                this.current_date = this.dateFormat.format(date6);
                try {
                    this.date1 = this.dateFormat.parse(this.pref_date);
                    this.date2 = this.dateFormat.parse(this.current_date);
                    this.cal1 = Calendar.getInstance();
                    this.cal2 = Calendar.getInstance();
                    this.cal1.setTime(this.date1);
                    this.cal2.setTime(this.date2);
                    if (this.cal1.before(this.cal2)) {
                        int intValue3 = this.myMoney.getPref(MyMoney.POINTS, 0).intValue();
                        this.old_point = intValue3;
                        this.new_point = 150;
                        int i3 = intValue3 + 150;
                        this.final_point = i3;
                        this.myMoney.setPref(MyMoney.POINTS, i3);
                        TextView textView3 = this.atv_coin_value;
                        textView3.setText("" + this.myMoney.getPref(MyMoney.POINTS, 0));
                        Date date7 = new Date();
                        this.date = date7;
                        String format3 = this.dateFormat.format(date7);
                        this.current_date = format3;
                        this.myMoney.setPref(MyMoney.PREVIOUS_CHECK_IN_DATE, format3);
                        this.myMoney.setPref(MyMoney.CHECK_IN_DAY, 2);
                        ShowDialog("150");
                        Check_In();
                        return;
                    }
                    SorryDialog();
                    return;
                } catch (ParseException e2) {
                    e2.printStackTrace();
                    return;
                }

            case R.id.rl_day3:
                this.pref_date = this.myMoney.getPref(MyMoney.PREVIOUS_CHECK_IN_DATE, "");
                this.dateFormat = new SimpleDateFormat("yyyy/MM/dd");
                Date date8 = new Date();
                this.date = date8;
                this.current_date = this.dateFormat.format(date8);
                try {
                    this.date1 = this.dateFormat.parse(this.pref_date);
                    this.date2 = this.dateFormat.parse(this.current_date);
                    this.cal1 = Calendar.getInstance();
                    this.cal2 = Calendar.getInstance();
                    this.cal1.setTime(this.date1);
                    this.cal2.setTime(this.date2);
                    if (this.cal1.before(this.cal2)) {
                        int intValue4 = this.myMoney.getPref(MyMoney.POINTS, 0).intValue();
                        this.old_point = intValue4;
                        this.new_point = 200;
                        int i4 = intValue4 + 200;
                        this.final_point = i4;
                        this.myMoney.setPref(MyMoney.POINTS, i4);
                        TextView textView4 = this.atv_coin_value;
                        textView4.setText("" + this.myMoney.getPref(MyMoney.POINTS, 0));
                        Date date9 = new Date();
                        this.date = date9;
                        String format4 = this.dateFormat.format(date9);
                        this.current_date = format4;
                        this.myMoney.setPref(MyMoney.PREVIOUS_CHECK_IN_DATE, format4);
                        this.myMoney.setPref(MyMoney.CHECK_IN_DAY, 3);
                        ShowDialog("200");
                        Check_In();
                        return;
                    }
                    SorryDialog();
                    return;
                } catch (ParseException e3) {
                    e3.printStackTrace();
                    return;
                }

            case R.id.rl_day4:
                this.pref_date = this.myMoney.getPref(MyMoney.PREVIOUS_CHECK_IN_DATE, "");
                this.dateFormat = new SimpleDateFormat("yyyy/MM/dd");
                Date date10 = new Date();
                this.date = date10;
                this.current_date = this.dateFormat.format(date10);
                try {
                    this.date1 = this.dateFormat.parse(this.pref_date);
                    this.date2 = this.dateFormat.parse(this.current_date);
                    this.cal1 = Calendar.getInstance();
                    this.cal2 = Calendar.getInstance();
                    this.cal1.setTime(this.date1);
                    this.cal2.setTime(this.date2);
                    if (this.cal1.before(this.cal2)) {
                        int intValue5 = this.myMoney.getPref(MyMoney.POINTS, 0).intValue();
                        this.old_point = intValue5;
                        this.new_point = ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION;
                        int i5 = intValue5 + ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION;
                        this.final_point = i5;
                        this.myMoney.setPref(MyMoney.POINTS, i5);
                        TextView textView5 = this.atv_coin_value;
                        textView5.setText("" + this.myMoney.getPref(MyMoney.POINTS, 0));
                        Date date11 = new Date();
                        this.date = date11;
                        String format5 = this.dateFormat.format(date11);
                        this.current_date = format5;
                        this.myMoney.setPref(MyMoney.PREVIOUS_CHECK_IN_DATE, format5);
                        this.myMoney.setPref(MyMoney.CHECK_IN_DAY, 4);
                        ShowDialog("250");
                        Check_In();
                        return;
                    }
                    SorryDialog();
                    return;
                } catch (ParseException e4) {
                    e4.printStackTrace();
                    return;
                }

            case R.id.rl_day5 :
                this.pref_date = this.myMoney.getPref(MyMoney.PREVIOUS_CHECK_IN_DATE, "");
                this.dateFormat = new SimpleDateFormat("yyyy/MM/dd");
                Date date12 = new Date();
                this.date = date12;
                this.current_date = this.dateFormat.format(date12);
                try {
                    this.date1 = this.dateFormat.parse(this.pref_date);
                    this.date2 = this.dateFormat.parse(this.current_date);
                    this.cal1 = Calendar.getInstance();
                    this.cal2 = Calendar.getInstance();
                    this.cal1.setTime(this.date1);
                    this.cal2.setTime(this.date2);
                    if (this.cal1.before(this.cal2)) {
                        int intValue6 = this.myMoney.getPref(MyMoney.POINTS, 0).intValue();
                        this.old_point = intValue6;
                        this.new_point = 300;
                        int i6 = intValue6 + 300;
                        this.final_point = i6;
                        this.myMoney.setPref(MyMoney.POINTS, i6);
                        TextView textView6 = this.atv_coin_value;
                        textView6.setText("" + this.myMoney.getPref(MyMoney.POINTS, 0));
                        Date date13 = new Date();
                        this.date = date13;
                        String format6 = this.dateFormat.format(date13);
                        this.current_date = format6;
                        this.myMoney.setPref(MyMoney.PREVIOUS_CHECK_IN_DATE, format6);
                        this.myMoney.setPref(MyMoney.CHECK_IN_DAY, 5);
                        ShowDialog("300");
                        Check_In();
                        return;
                    }
                    SorryDialog();
                    return;
                } catch (ParseException e5) {
                    e5.printStackTrace();
                    return;
                }

            case R.id.rl_day6 :
                this.pref_date = this.myMoney.getPref(MyMoney.PREVIOUS_CHECK_IN_DATE, "");
                this.dateFormat = new SimpleDateFormat("yyyy/MM/dd");
                Date date14 = new Date();
                this.date = date14;
                this.current_date = this.dateFormat.format(date14);
                try {
                    this.date1 = this.dateFormat.parse(this.pref_date);
                    this.date2 = this.dateFormat.parse(this.current_date);
                    this.cal1 = Calendar.getInstance();
                    this.cal2 = Calendar.getInstance();
                    this.cal1.setTime(this.date1);
                    this.cal2.setTime(this.date2);
                    if (this.cal1.before(this.cal2)) {
                        int intValue7 = this.myMoney.getPref(MyMoney.POINTS, 0).intValue();
                        this.old_point = intValue7;
                        this.new_point = 350;
                        int i7 = intValue7 + 350;
                        this.final_point = i7;
                        this.myMoney.setPref(MyMoney.POINTS, i7);
                        TextView textView7 = this.atv_coin_value;
                        textView7.setText("" + this.myMoney.getPref(MyMoney.POINTS, 0));
                        Date date15 = new Date();
                        this.date = date15;
                        String format7 = this.dateFormat.format(date15);
                        this.current_date = format7;
                        this.myMoney.setPref(MyMoney.PREVIOUS_CHECK_IN_DATE, format7);
                        this.myMoney.setPref(MyMoney.CHECK_IN_DAY, 6);
                        ShowDialog("350");
                        Check_In();
                        return;
                    }
                    SorryDialog();
                    return;
                } catch (ParseException e6) {
                    e6.printStackTrace();
                    return;
                }

            case R.id.rl_day7:
                this.pref_date = this.myMoney.getPref(MyMoney.PREVIOUS_CHECK_IN_DATE, "");
                this.dateFormat = new SimpleDateFormat("yyyy/MM/dd");
                Date date16 = new Date();
                this.date = date16;
                this.current_date = this.dateFormat.format(date16);
                try {
                    this.date1 = this.dateFormat.parse(this.pref_date);
                    this.date2 = this.dateFormat.parse(this.current_date);
                    this.cal1 = Calendar.getInstance();
                    this.cal2 = Calendar.getInstance();
                    this.cal1.setTime(this.date1);
                    this.cal2.setTime(this.date2);
                    if (this.cal1.before(this.cal2)) {
                        int intValue8 = this.myMoney.getPref(MyMoney.POINTS, 0).intValue();
                        this.old_point = intValue8;
                        this.new_point = 400;
                        int i8 = intValue8 + 400;
                        this.final_point = i8;
                        this.myMoney.setPref(MyMoney.POINTS, i8);
                        TextView textView8 = this.atv_coin_value;
                        textView8.setText("" + this.myMoney.getPref(MyMoney.POINTS, 0));
                        Date date17 = new Date();
                        this.date = date17;
                        String format8 = this.dateFormat.format(date17);
                        this.current_date = format8;
                        this.myMoney.setPref(MyMoney.PREVIOUS_CHECK_IN_DATE, format8);
                        this.myMoney.setPref(MyMoney.CHECK_IN_DAY, 7);
                        ShowDialog("400");
                        Check_In();
                        return;
                    }
                    SorryDialog();
                    return;
                } catch (ParseException e7) {
                    e7.printStackTrace();
                    return;
                }
            default:
                return;
        }
    }

    public void Check_In() {
        animateButton();
        if (this.myMoney.getPref(MyMoney.CHECK_IN_DAY, 0).intValue() == 0) {
            this.rl_day1.setEnabled(true);
            this.rl_day2.setEnabled(false);
            this.rl_day3.setEnabled(false);
            this.rl_day4.setEnabled(false);
            this.rl_day5.setEnabled(false);
            this.rl_day6.setEnabled(false);
            this.rl_day7.setEnabled(false);
        } else if (this.myMoney.getPref(MyMoney.CHECK_IN_DAY, 0).intValue() == 1) {
            this.rl_day1.setEnabled(false);
            this.rl_day2.setEnabled(true);
            this.rl_day3.setEnabled(false);
            this.rl_day4.setEnabled(false);
            this.rl_day5.setEnabled(false);
            this.rl_day6.setEnabled(false);
            this.rl_day7.setEnabled(false);
        } else if (this.myMoney.getPref(MyMoney.CHECK_IN_DAY, 0).intValue() == 2) {
            this.rl_day1.setEnabled(false);
            this.rl_day2.setEnabled(false);
            this.rl_day3.setEnabled(true);
            this.rl_day4.setEnabled(false);
            this.rl_day5.setEnabled(false);
            this.rl_day6.setEnabled(false);
            this.rl_day7.setEnabled(false);
        } else if (this.myMoney.getPref(MyMoney.CHECK_IN_DAY, 0).intValue() == 3) {
            this.rl_day1.setEnabled(false);
            this.rl_day2.setEnabled(false);
            this.rl_day3.setEnabled(false);
            this.rl_day4.setEnabled(true);
            this.rl_day5.setEnabled(false);
            this.rl_day6.setEnabled(false);
            this.rl_day7.setEnabled(false);
        } else if (this.myMoney.getPref(MyMoney.CHECK_IN_DAY, 0).intValue() == 4) {
            this.rl_day1.setEnabled(false);
            this.rl_day2.setEnabled(false);
            this.rl_day3.setEnabled(false);
            this.rl_day4.setEnabled(false);
            this.rl_day5.setEnabled(true);
            this.rl_day6.setEnabled(false);
            this.rl_day7.setEnabled(false);
        } else if (this.myMoney.getPref(MyMoney.CHECK_IN_DAY, 0).intValue() == 5) {
            this.rl_day1.setEnabled(false);
            this.rl_day2.setEnabled(false);
            this.rl_day3.setEnabled(false);
            this.rl_day4.setEnabled(false);
            this.rl_day5.setEnabled(false);
            this.rl_day6.setEnabled(true);
            this.rl_day7.setEnabled(false);
        } else if (this.myMoney.getPref(MyMoney.CHECK_IN_DAY, 0).intValue() == 6) {
            this.rl_day1.setEnabled(false);
            this.rl_day2.setEnabled(false);
            this.rl_day3.setEnabled(false);
            this.rl_day4.setEnabled(false);
            this.rl_day5.setEnabled(false);
            this.rl_day6.setEnabled(false);
            this.rl_day7.setEnabled(true);
        } else if (this.myMoney.getPref(MyMoney.CHECK_IN_DAY, 0).intValue() == 7) {
            this.rl_day1.setEnabled(true);
            this.rl_day2.setEnabled(false);
            this.rl_day3.setEnabled(false);
            this.rl_day4.setEnabled(false);
            this.rl_day5.setEnabled(false);
            this.rl_day6.setEnabled(false);
            this.rl_day7.setEnabled(false);
        }
    }

    public void animateButton() {
        Animation loadAnimation = AnimationUtils.loadAnimation(this, R.anim.watchvideoearnmoney);
        loadAnimation.setDuration(1000);
        loadAnimation.setInterpolator(new realmoney_49(1.0d, 1.0d));
        if (this.myMoney.getPref(MyMoney.CHECK_IN_DAY, 0).intValue() == 0) {
            this.rl_day1.startAnimation(loadAnimation);
            this.rl_day2.clearAnimation();
            this.rl_day3.clearAnimation();
            this.rl_day4.clearAnimation();
            this.rl_day5.clearAnimation();
            this.rl_day6.clearAnimation();
            this.rl_day7.clearAnimation();
        } else if (this.myMoney.getPref(MyMoney.CHECK_IN_DAY, 0).intValue() == 1) {
            this.rl_day1.clearAnimation();
            this.rl_day2.startAnimation(loadAnimation);
            this.rl_day3.clearAnimation();
            this.rl_day4.clearAnimation();
            this.rl_day5.clearAnimation();
            this.rl_day6.clearAnimation();
            this.rl_day7.clearAnimation();
        } else if (this.myMoney.getPref(MyMoney.CHECK_IN_DAY, 0).intValue() == 2) {
            this.rl_day1.clearAnimation();
            this.rl_day2.clearAnimation();
            this.rl_day3.startAnimation(loadAnimation);
            this.rl_day4.clearAnimation();
            this.rl_day5.clearAnimation();
            this.rl_day6.clearAnimation();
            this.rl_day7.clearAnimation();
        } else if (this.myMoney.getPref(MyMoney.CHECK_IN_DAY, 0).intValue() == 3) {
            this.rl_day1.clearAnimation();
            this.rl_day2.clearAnimation();
            this.rl_day3.clearAnimation();
            this.rl_day4.startAnimation(loadAnimation);
            this.rl_day5.clearAnimation();
            this.rl_day6.clearAnimation();
            this.rl_day7.clearAnimation();
        } else if (this.myMoney.getPref(MyMoney.CHECK_IN_DAY, 0).intValue() == 4) {
            this.rl_day1.clearAnimation();
            this.rl_day2.clearAnimation();
            this.rl_day3.clearAnimation();
            this.rl_day4.clearAnimation();
            this.rl_day5.startAnimation(loadAnimation);
            this.rl_day6.clearAnimation();
            this.rl_day7.clearAnimation();
        } else if (this.myMoney.getPref(MyMoney.CHECK_IN_DAY, 0).intValue() == 5) {
            this.rl_day1.clearAnimation();
            this.rl_day2.clearAnimation();
            this.rl_day3.clearAnimation();
            this.rl_day4.clearAnimation();
            this.rl_day5.clearAnimation();
            this.rl_day6.startAnimation(loadAnimation);
            this.rl_day7.clearAnimation();
        } else if (this.myMoney.getPref(MyMoney.CHECK_IN_DAY, 0).intValue() == 6) {
            this.rl_day1.clearAnimation();
            this.rl_day2.clearAnimation();
            this.rl_day3.clearAnimation();
            this.rl_day4.clearAnimation();
            this.rl_day5.clearAnimation();
            this.rl_day6.clearAnimation();
            this.rl_day7.startAnimation(loadAnimation);
        } else if (this.myMoney.getPref(MyMoney.CHECK_IN_DAY, 0).intValue() == 7) {
            this.rl_day1.startAnimation(loadAnimation);
            this.rl_day2.clearAnimation();
            this.rl_day3.clearAnimation();
            this.rl_day4.clearAnimation();
            this.rl_day5.clearAnimation();
            this.rl_day6.clearAnimation();
            this.rl_day7.clearAnimation();
        }

        loadAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                EarnMoney_86.this.animateButton();
            }
        });
    }

    private void ShowDialog(String str) {
        Dialog dialog = new Dialog(this, R.style.creativeDialogTheme);
        this.conform_dialog = dialog;
        dialog.setContentView(R.layout.earnmoneywatchvideo);
        this.conform_dialog.setCancelable(false);
        ((TextView) this.conform_dialog.findViewById(R.id.atv_point_value)).setText(str + " Points Added Successfully.");

        ((ImageView) this.conform_dialog.findViewById(R.id.btn_get_points)).setOnClickListener(new View.OnClickListener() {
            @Override 
            public void onClick(View view) {
                EarnMoney_86.this.conform_dialog.dismiss();
            }
        });
        this.conform_dialog.show();

    }

    private void SorryDialog() {
        Dialog dialog = new Dialog(this, R.style.creativeDialogTheme);
        this.conform_dialog_sorry = dialog;
        dialog.setContentView(R.layout.watchvideomoney);
        this.conform_dialog_sorry.setCancelable(false);
        ((TextView) this.conform_dialog_sorry.findViewById(R.id.atv_sorry_title)).setText("Please Try Tomorrow.");
        ((TextView) this.conform_dialog_sorry.findViewById(R.id.btn_ok)).setOnClickListener(new View.OnClickListener() {
            @Override 
            public void onClick(View view) {
                EarnMoney_86.this.conform_dialog_sorry.dismiss();
            }
        });
        this.conform_dialog_sorry.show();
    }

    @Override 
    public void onBackPressed() {
        if (earnmoney.isAdOn) {
            if (earnmoney.ad_mode.equalsIgnoreCase("admob")) {
                if (realmoney12.isInternetOn(EarnMoney_86.this)) {
                    realmoney12.getInstance().loadintertialads(EarnMoney_86.this, earnmoney.admob_inter_id, new realmoney12.MyCallback() {
                        @Override
                        public void callbackCall() {
                            startActivity(new Intent(EarnMoney_86.this, EarnMoney_82.class));
                        }
                    });
                } else {
                    startActivity(new Intent(EarnMoney_86.this, EarnMoney_82.class));
                }
            } else if (earnmoney.ad_mode.equalsIgnoreCase("qureka")) {

                realmoney14.getInstance().qureka_inter(EarnMoney_86.this, new realmoney14.MyCallback() {
                    @Override
                    public void callbackCall() {
                        startActivity(new Intent(EarnMoney_86.this, EarnMoney_82.class));
                    }
                });

            } else {

                if (realmoney21.isInternetOn(EarnMoney_86.this)) {
                    realmoney21.getInstance().loadintertialads(EarnMoney_86.this, earnmoney.facebook_inter_id, new realmoney21.MyCallback() {
                        @Override
                        public void callbackCall() {
                            startActivity(new Intent(EarnMoney_86.this, EarnMoney_82.class));
                        }
                    });
                } else {
                    startActivity(new Intent(EarnMoney_86.this, EarnMoney_82.class));
                }
            }

        } else {
            startActivity(new Intent(EarnMoney_86.this, EarnMoney_82.class));
        }

    }

    @Override 
    public void onResume() {
        super.onResume();
        if (this.mCustomTabsOpened) {
            this.mCustomTabsOpened = false;
            finish();
        }
        TextView textView = this.atv_coin_value;
        textView.setText("" + this.myMoney.getPref(MyMoney.POINTS, 0));
    }


    @Override 
    public void onDestroy() {
        super.onDestroy();
    }


}
