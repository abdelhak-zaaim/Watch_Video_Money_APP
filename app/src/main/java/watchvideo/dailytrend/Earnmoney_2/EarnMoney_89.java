package watchvideo.dailytrend.Earnmoney_2;

import static watchvideo.dailytrend.Earnmoney.earnmoney.quera_link;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
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
import watchvideo.dailytrend.Earnmoney_4.earnmoney_59;
import watchvideo.dailytrend.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@SuppressLint("WrongConstant")

public class EarnMoney_89 extends AppCompatActivity implements View.OnClickListener, realmoney_23.timer_method {
    Animation animation;
    TextView atv_1;
    TextView atv_10;
    TextView atv_11;
    TextView atv_12;
    TextView atv_13;
    TextView atv_14;
    TextView atv_15;
    TextView atv_16;
    TextView atv_2;
    TextView atv_3;
    TextView atv_4;
    TextView atv_5;
    TextView atv_6;
    TextView atv_7;
    TextView atv_8;
    TextView atv_9;
    TextView atv_coin_value;
    TextView atv_flip_left_value;
    TextView atv_time_left_value;


    public Dialog conform_dialog;
    ImageView iv_1;
    ImageView iv_10;
    ImageView iv_11;
    ImageView iv_12;
    ImageView iv_13;
    ImageView iv_14;
    ImageView iv_15;
    ImageView iv_16;
    ImageView iv_2;
    ImageView iv_3;
    ImageView iv_4;
    ImageView iv_5;
    ImageView iv_6;
    ImageView iv_7;
    ImageView iv_8;
    ImageView iv_9;
    private boolean mCustomTabsOpened = false;
    MyMoney myMoney;
    ObjectAnimator oa1;
    ObjectAnimator oa2;
    String result;
    RelativeLayout rl_1;
    RelativeLayout rl_10;
    RelativeLayout rl_11;
    RelativeLayout rl_12;
    RelativeLayout rl_13;
    RelativeLayout rl_14;
    RelativeLayout rl_15;
    RelativeLayout rl_16;
    RelativeLayout rl_2;
    RelativeLayout rl_3;
    RelativeLayout rl_4;
    RelativeLayout rl_5;
    RelativeLayout rl_6;
    RelativeLayout rl_7;
    RelativeLayout rl_8;
    RelativeLayout rl_9;

    RelativeLayout adContainerView, adContainerPlaylist;
    ShimmerFrameLayout main_act_banner;

    public BroadcastReceiver br = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            EarnMoney_89.this.updateGUI(intent);
        }
    };


    @Override 
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.moneyappreal);
        ((ImageView) findViewById(R.id.ivback)).setOnClickListener(new View.OnClickListener() {
            @Override 
            public void onClick(View view) {
                EarnMoney_89.this.onBackPressed();
            }
        });

        init();
        this.animation = AnimationUtils.loadAnimation(this, R.anim.moneyapp);

        Set_Random_Number();


        //Banner :-
        adContainerView = findViewById(R.id.adViewContainer);
        adContainerPlaylist = findViewById(R.id.adViewContainer);
        main_act_banner = findViewById(R.id.main_act_banner);


        if (earnmoney.isAdOn) {
            if (earnmoney.ad_mode.equalsIgnoreCase("admob")) {
                realmoney.creteadadaptiveBanner(EarnMoney_89.this, adContainerPlaylist, earnmoney.admob_banner_id);
            } else if (earnmoney.ad_mode.equalsIgnoreCase("qureka")) {
                main_act_banner.setVisibility(View.VISIBLE);
            } else {
                adContainerView.setBackgroundResource(R.drawable.realmoney_140);
                realmoney13.createFBLoadBanner(EarnMoney_89.this, adContainerPlaylist, earnmoney.facebook_banner_id);
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
                    Intent intent1 = new Intent("android.intent.action.VIEW");
                    Bundle bundle = new Bundle();
                    int i = Build.VERSION.SDK_INT;
                    bundle.putBinder("android.support.customtabs.extra.SESSION", null);
                    intent1.putExtras(bundle);
                    intent1.putExtra("android.support.customtabs.extra.TOOLBAR_COLOR", R.color.colorPrimary);
                    intent1.putExtra("android.support.customtabs.extra.EXTRA_ENABLE_INSTANT_APPS", true);
                    intent1.setData(Uri.parse(quera_link));
                    startActivity(intent1, bundle);
                }
            }
        });


    }

    public void init() {
        this.myMoney = new MyMoney(this);
        this.atv_coin_value = (TextView) findViewById(R.id.atv_coin_value);
        this.atv_flip_left_value = (TextView) findViewById(R.id.atv_flip_left_value);
        this.atv_time_left_value = (TextView) findViewById(R.id.atv_time_left_value);
        ImageView imageView = (ImageView) findViewById(R.id.iv_1);
        this.iv_1 = imageView;
        imageView.setVisibility(0);
        this.iv_1.setOnClickListener(this);
        this.atv_1 = (TextView) findViewById(R.id.atv_1);
        this.rl_1 = (RelativeLayout) findViewById(R.id.rl_1);
        ImageView imageView2 = (ImageView) findViewById(R.id.iv_2);
        this.iv_2 = imageView2;
        imageView2.setVisibility(0);
        this.iv_2.setOnClickListener(this);
        this.atv_2 = (TextView) findViewById(R.id.atv_2);
        this.rl_2 = (RelativeLayout) findViewById(R.id.rl_2);
        ImageView imageView3 = (ImageView) findViewById(R.id.iv_3);
        this.iv_3 = imageView3;
        imageView3.setVisibility(0);
        this.iv_3.setOnClickListener(this);
        this.atv_3 = (TextView) findViewById(R.id.atv_3);
        this.rl_3 = (RelativeLayout) findViewById(R.id.rl_3);
        ImageView imageView4 = (ImageView) findViewById(R.id.iv_4);
        this.iv_4 = imageView4;
        imageView4.setVisibility(0);
        this.iv_4.setOnClickListener(this);
        this.atv_4 = (TextView) findViewById(R.id.atv_4);
        this.rl_4 = (RelativeLayout) findViewById(R.id.rl_4);
        ImageView imageView5 = (ImageView) findViewById(R.id.iv_5);
        this.iv_5 = imageView5;
        imageView5.setVisibility(0);
        this.iv_5.setOnClickListener(this);
        this.atv_5 = (TextView) findViewById(R.id.atv_5);
        this.rl_5 = (RelativeLayout) findViewById(R.id.rl_5);
        ImageView imageView6 = (ImageView) findViewById(R.id.iv_6);
        this.iv_6 = imageView6;
        imageView6.setVisibility(0);
        this.iv_6.setOnClickListener(this);
        this.atv_6 = (TextView) findViewById(R.id.atv_6);
        this.rl_6 = (RelativeLayout) findViewById(R.id.rl_6);
        ImageView imageView7 = (ImageView) findViewById(R.id.iv_7);
        this.iv_7 = imageView7;
        imageView7.setVisibility(0);
        this.iv_7.setOnClickListener(this);
        this.atv_7 = (TextView) findViewById(R.id.atv_7);
        this.rl_7 = (RelativeLayout) findViewById(R.id.rl_7);
        ImageView imageView8 = (ImageView) findViewById(R.id.iv_8);
        this.iv_8 = imageView8;
        imageView8.setVisibility(0);
        this.iv_8.setOnClickListener(this);
        this.atv_8 = (TextView) findViewById(R.id.atv_8);
        this.rl_8 = (RelativeLayout) findViewById(R.id.rl_8);
        ImageView imageView9 = (ImageView) findViewById(R.id.iv_9);
        this.iv_9 = imageView9;
        imageView9.setVisibility(0);
        this.iv_9.setOnClickListener(this);
        this.atv_9 = (TextView) findViewById(R.id.atv_9);
        this.rl_9 = (RelativeLayout) findViewById(R.id.rl_9);
        ImageView imageView10 = (ImageView) findViewById(R.id.iv_10);
        this.iv_10 = imageView10;
        imageView10.setVisibility(0);
        this.iv_10.setOnClickListener(this);
        this.atv_10 = (TextView) findViewById(R.id.atv_10);
        this.rl_10 = (RelativeLayout) findViewById(R.id.rl_10);
        ImageView imageView11 = (ImageView) findViewById(R.id.iv_11);
        this.iv_11 = imageView11;
        imageView11.setVisibility(0);
        this.iv_11.setOnClickListener(this);
        this.atv_11 = (TextView) findViewById(R.id.atv_11);
        this.rl_11 = (RelativeLayout) findViewById(R.id.rl_11);
        ImageView imageView12 = (ImageView) findViewById(R.id.iv_12);
        this.iv_12 = imageView12;
        imageView12.setVisibility(0);
        this.iv_12.setOnClickListener(this);
        this.atv_12 = (TextView) findViewById(R.id.atv_12);
        this.rl_12 = (RelativeLayout) findViewById(R.id.rl_12);
        ImageView imageView13 = (ImageView) findViewById(R.id.iv_13);
        this.iv_13 = imageView13;
        imageView13.setVisibility(0);
        this.iv_13.setOnClickListener(this);
        this.atv_13 = (TextView) findViewById(R.id.atv_13);
        this.rl_13 = (RelativeLayout) findViewById(R.id.rl_13);
        ImageView imageView14 = (ImageView) findViewById(R.id.iv_14);
        this.iv_14 = imageView14;
        imageView14.setVisibility(0);
        this.iv_14.setOnClickListener(this);
        this.atv_14 = (TextView) findViewById(R.id.atv_14);
        this.rl_14 = (RelativeLayout) findViewById(R.id.rl_14);
        ImageView imageView15 = (ImageView) findViewById(R.id.iv_15);
        this.iv_15 = imageView15;
        imageView15.setVisibility(0);
        this.iv_15.setOnClickListener(this);
        this.atv_15 = (TextView) findViewById(R.id.atv_15);
        this.rl_15 = (RelativeLayout) findViewById(R.id.rl_15);
        ImageView imageView16 = (ImageView) findViewById(R.id.iv_16);
        this.iv_16 = imageView16;
        imageView16.setVisibility(0);
        this.iv_16.setOnClickListener(this);
        this.atv_16 = (TextView) findViewById(R.id.atv_16);
        this.rl_16 = (RelativeLayout) findViewById(R.id.rl_16);
    }

    @Override 
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_1:
                this.oa1 = ObjectAnimator.ofFloat(this.iv_1, "scaleX", 1.0f, 0.0f);
                this.oa2 = ObjectAnimator.ofFloat(this.iv_1, "scaleX", 0.0f, 1.0f);
                this.oa1.setInterpolator(new DecelerateInterpolator());
                this.oa2.setInterpolator(new AccelerateDecelerateInterpolator());
                this.oa1.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        EarnMoney_89.this.iv_1.setVisibility(8);
                        EarnMoney_89.this.rl_1.setVisibility(0);
                        EarnMoney_89 earnMoney89 = EarnMoney_89.this;
                        earnMoney89.result = earnMoney89.atv_1.getText().toString();
                        EarnMoney_89.this.oa2.start();
                        EarnMoney_89.this.ShowDialog();
                    }
                });
                this.oa1.start();
                return;

            case R.id.iv_10:
                this.oa1 = ObjectAnimator.ofFloat(this.iv_10, "scaleX", 1.0f, 0.0f);
                this.oa2 = ObjectAnimator.ofFloat(this.iv_10, "scaleX", 0.0f, 1.0f);
                this.oa1.setInterpolator(new DecelerateInterpolator());
                this.oa2.setInterpolator(new AccelerateDecelerateInterpolator());
                this.oa1.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        EarnMoney_89.this.iv_10.setVisibility(8);
                        EarnMoney_89.this.rl_10.setVisibility(0);
                        EarnMoney_89 earnMoney89 = EarnMoney_89.this;
                        earnMoney89.result = earnMoney89.atv_10.getText().toString();
                        EarnMoney_89.this.oa2.start();
                        EarnMoney_89.this.ShowDialog();
                    }
                });
                this.oa1.start();
                return;

            case R.id.iv_11:
                this.oa1 = ObjectAnimator.ofFloat(this.iv_11, "scaleX", 1.0f, 0.0f);
                this.oa2 = ObjectAnimator.ofFloat(this.iv_11, "scaleX", 0.0f, 1.0f);
                this.oa1.setInterpolator(new DecelerateInterpolator());
                this.oa2.setInterpolator(new AccelerateDecelerateInterpolator());
                this.oa1.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        EarnMoney_89.this.iv_11.setVisibility(8);
                        EarnMoney_89.this.rl_11.setVisibility(0);
                        EarnMoney_89 earnMoney89 = EarnMoney_89.this;
                        earnMoney89.result = earnMoney89.atv_11.getText().toString();
                        EarnMoney_89.this.oa2.start();
                        EarnMoney_89.this.ShowDialog();
                    }
                });
                this.oa1.start();
                return;

            case R.id.iv_12:
                this.oa1 = ObjectAnimator.ofFloat(this.iv_12, "scaleX", 1.0f, 0.0f);
                this.oa2 = ObjectAnimator.ofFloat(this.iv_12, "scaleX", 0.0f, 1.0f);
                this.oa1.setInterpolator(new DecelerateInterpolator());
                this.oa2.setInterpolator(new AccelerateDecelerateInterpolator());
                this.oa1.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        EarnMoney_89.this.iv_12.setVisibility(8);
                        EarnMoney_89.this.rl_12.setVisibility(0);
                        EarnMoney_89 earnMoney89 = EarnMoney_89.this;
                        earnMoney89.result = earnMoney89.atv_12.getText().toString();
                        EarnMoney_89.this.oa2.start();
                        EarnMoney_89.this.ShowDialog();
                    }
                });
                this.oa1.start();
                return;

            case R.id.iv_13 :
                this.oa1 = ObjectAnimator.ofFloat(this.iv_13, "scaleX", 1.0f, 0.0f);
                this.oa2 = ObjectAnimator.ofFloat(this.iv_13, "scaleX", 0.0f, 1.0f);
                this.oa1.setInterpolator(new DecelerateInterpolator());
                this.oa2.setInterpolator(new AccelerateDecelerateInterpolator());
                this.oa1.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        EarnMoney_89.this.iv_13.setVisibility(8);
                        EarnMoney_89.this.rl_13.setVisibility(0);
                        EarnMoney_89 earnMoney89 = EarnMoney_89.this;
                        earnMoney89.result = earnMoney89.atv_13.getText().toString();
                        EarnMoney_89.this.oa2.start();
                        EarnMoney_89.this.ShowDialog();
                    }
                });
                this.oa1.start();
                return;

            case R.id.iv_14 :
                this.oa1 = ObjectAnimator.ofFloat(this.iv_14, "scaleX", 1.0f, 0.0f);
                this.oa2 = ObjectAnimator.ofFloat(this.iv_14, "scaleX", 0.0f, 1.0f);
                this.oa1.setInterpolator(new DecelerateInterpolator());
                this.oa2.setInterpolator(new AccelerateDecelerateInterpolator());
                this.oa1.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        EarnMoney_89.this.iv_14.setVisibility(8);
                        EarnMoney_89.this.rl_14.setVisibility(0);
                        EarnMoney_89 earnMoney89 = EarnMoney_89.this;
                        earnMoney89.result = earnMoney89.atv_14.getText().toString();
                        EarnMoney_89.this.oa2.start();
                        EarnMoney_89.this.ShowDialog();
                    }
                });
                this.oa1.start();
                return;

            case R.id.iv_15:
                this.oa1 = ObjectAnimator.ofFloat(this.iv_15, "scaleX", 1.0f, 0.0f);
                this.oa2 = ObjectAnimator.ofFloat(this.iv_15, "scaleX", 0.0f, 1.0f);
                this.oa1.setInterpolator(new DecelerateInterpolator());
                this.oa2.setInterpolator(new AccelerateDecelerateInterpolator());
                this.oa1.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        EarnMoney_89.this.iv_15.setVisibility(8);
                        EarnMoney_89.this.rl_15.setVisibility(0);
                        EarnMoney_89 earnMoney89 = EarnMoney_89.this;
                        earnMoney89.result = earnMoney89.atv_15.getText().toString();
                        EarnMoney_89.this.oa2.start();
                        EarnMoney_89.this.ShowDialog();
                    }
                });
                this.oa1.start();
                return;

            case R.id.iv_16:
                this.oa1 = ObjectAnimator.ofFloat(this.iv_16, "scaleX", 1.0f, 0.0f);
                this.oa2 = ObjectAnimator.ofFloat(this.iv_16, "scaleX", 0.0f, 1.0f);
                this.oa1.setInterpolator(new DecelerateInterpolator());
                this.oa2.setInterpolator(new AccelerateDecelerateInterpolator());
                this.oa1.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        EarnMoney_89.this.iv_16.setVisibility(8);
                        EarnMoney_89.this.rl_16.setVisibility(0);
                        EarnMoney_89 earnMoney89 = EarnMoney_89.this;
                        earnMoney89.result = earnMoney89.atv_16.getText().toString();
                        EarnMoney_89.this.oa2.start();
                        EarnMoney_89.this.ShowDialog();
                    }
                });
                this.oa1.start();
                return;

            case R.id.iv_2:
                this.oa1 = ObjectAnimator.ofFloat(this.iv_2, "scaleX", 1.0f, 0.0f);
                this.oa2 = ObjectAnimator.ofFloat(this.iv_2, "scaleX", 0.0f, 1.0f);
                this.oa1.setInterpolator(new DecelerateInterpolator());
                this.oa2.setInterpolator(new AccelerateDecelerateInterpolator());
                this.oa1.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        EarnMoney_89.this.iv_2.setVisibility(8);
                        EarnMoney_89.this.rl_2.setVisibility(0);
                        EarnMoney_89 earnMoney89 = EarnMoney_89.this;
                        earnMoney89.result = earnMoney89.atv_2.getText().toString();
                        EarnMoney_89.this.oa2.start();
                        EarnMoney_89.this.ShowDialog();
                    }
                });
                this.oa1.start();
                return;

            case R.id.iv_3:
                this.oa1 = ObjectAnimator.ofFloat(this.iv_3, "scaleX", 1.0f, 0.0f);
                this.oa2 = ObjectAnimator.ofFloat(this.iv_3, "scaleX", 0.0f, 1.0f);
                this.oa1.setInterpolator(new DecelerateInterpolator());
                this.oa2.setInterpolator(new AccelerateDecelerateInterpolator());
                this.oa1.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        EarnMoney_89.this.iv_3.setVisibility(8);
                        EarnMoney_89.this.rl_3.setVisibility(0);
                        EarnMoney_89 earnMoney89 = EarnMoney_89.this;
                        earnMoney89.result = earnMoney89.atv_3.getText().toString();
                        EarnMoney_89.this.oa2.start();
                        EarnMoney_89.this.ShowDialog();
                    }
                });
                this.oa1.start();
                return;

            case R.id.iv_4:
                this.oa1 = ObjectAnimator.ofFloat(this.iv_4, "scaleX", 1.0f, 0.0f);
                this.oa2 = ObjectAnimator.ofFloat(this.iv_4, "scaleX", 0.0f, 1.0f);
                this.oa1.setInterpolator(new DecelerateInterpolator());
                this.oa2.setInterpolator(new AccelerateDecelerateInterpolator());
                this.oa1.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        EarnMoney_89.this.iv_4.setVisibility(8);
                        EarnMoney_89.this.rl_4.setVisibility(0);
                        EarnMoney_89 earnMoney89 = EarnMoney_89.this;
                        earnMoney89.result = earnMoney89.atv_4.getText().toString();
                        EarnMoney_89.this.oa2.start();
                        EarnMoney_89.this.ShowDialog();
                    }
                });
                this.oa1.start();
                return;

            case R.id.iv_5:
                this.oa1 = ObjectAnimator.ofFloat(this.iv_5, "scaleX", 1.0f, 0.0f);
                this.oa2 = ObjectAnimator.ofFloat(this.iv_5, "scaleX", 0.0f, 1.0f);
                this.oa1.setInterpolator(new DecelerateInterpolator());
                this.oa2.setInterpolator(new AccelerateDecelerateInterpolator());
                this.oa1.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        EarnMoney_89.this.iv_5.setVisibility(8);
                        EarnMoney_89.this.rl_5.setVisibility(0);
                        EarnMoney_89 earnMoney89 = EarnMoney_89.this;
                        earnMoney89.result = earnMoney89.atv_5.getText().toString();
                        EarnMoney_89.this.oa2.start();
                        EarnMoney_89.this.ShowDialog();
                    }
                });
                this.oa1.start();
                return;

            case R.id.iv_6 :
                this.oa1 = ObjectAnimator.ofFloat(this.iv_6, "scaleX", 1.0f, 0.0f);
                this.oa2 = ObjectAnimator.ofFloat(this.iv_6, "scaleX", 0.0f, 1.0f);
                this.oa1.setInterpolator(new DecelerateInterpolator());
                this.oa2.setInterpolator(new AccelerateDecelerateInterpolator());
                this.oa1.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        EarnMoney_89.this.iv_6.setVisibility(8);
                        EarnMoney_89.this.rl_6.setVisibility(0);
                        EarnMoney_89 earnMoney89 = EarnMoney_89.this;
                        earnMoney89.result = earnMoney89.atv_6.getText().toString();
                        EarnMoney_89.this.oa2.start();
                        EarnMoney_89.this.ShowDialog();
                    }
                });
                this.oa1.start();
                return;

            case R.id.iv_7:
                this.oa1 = ObjectAnimator.ofFloat(this.iv_7, "scaleX", 1.0f, 0.0f);
                this.oa2 = ObjectAnimator.ofFloat(this.iv_7, "scaleX", 0.0f, 1.0f);
                this.oa1.setInterpolator(new DecelerateInterpolator());
                this.oa2.setInterpolator(new AccelerateDecelerateInterpolator());
                this.oa1.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        EarnMoney_89.this.iv_7.setVisibility(8);
                        EarnMoney_89.this.rl_7.setVisibility(0);
                        EarnMoney_89 earnMoney89 = EarnMoney_89.this;
                        earnMoney89.result = earnMoney89.atv_7.getText().toString();
                        EarnMoney_89.this.oa2.start();
                        EarnMoney_89.this.ShowDialog();
                    }
                });
                this.oa1.start();
                return;

            case R.id.iv_8:
                this.oa1 = ObjectAnimator.ofFloat(this.iv_8, "scaleX", 1.0f, 0.0f);
                this.oa2 = ObjectAnimator.ofFloat(this.iv_8, "scaleX", 0.0f, 1.0f);
                this.oa1.setInterpolator(new DecelerateInterpolator());
                this.oa2.setInterpolator(new AccelerateDecelerateInterpolator());
                this.oa1.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        EarnMoney_89.this.iv_8.setVisibility(8);
                        EarnMoney_89.this.rl_8.setVisibility(0);
                        EarnMoney_89 earnMoney89 = EarnMoney_89.this;
                        earnMoney89.result = earnMoney89.atv_8.getText().toString();
                        EarnMoney_89.this.oa2.start();
                        EarnMoney_89.this.ShowDialog();
                    }
                });
                this.oa1.start();
                return;

            case R.id.iv_9:
                this.oa1 = ObjectAnimator.ofFloat(this.iv_9, "scaleX", 1.0f, 0.0f);
                this.oa2 = ObjectAnimator.ofFloat(this.iv_9, "scaleX", 0.0f, 1.0f);
                this.oa1.setInterpolator(new DecelerateInterpolator());
                this.oa2.setInterpolator(new AccelerateDecelerateInterpolator());
                this.oa1.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        EarnMoney_89.this.iv_9.setVisibility(8);
                        EarnMoney_89.this.rl_9.setVisibility(0);
                        EarnMoney_89 earnMoney89 = EarnMoney_89.this;
                        earnMoney89.result = earnMoney89.atv_9.getText().toString();
                        EarnMoney_89.this.oa2.start();
                        EarnMoney_89.this.ShowDialog();
                    }
                });
                this.oa1.start();
                return;
            default:
                return;
        }
    }

    public void updateGUI(Intent intent) {
        if (intent.getExtras() == null) {
            return;
        }
        if (intent.getBooleanExtra("start", false)) {
            Disable();
            long longExtra = intent.getLongExtra("countdown", 0);
            TextView textView = this.atv_time_left_value;
            textView.setText(longExtra + "");
            return;
        }
        Enable();
    }

    @Override
    public void tik_tik(long j) {
        Disable();
        long seconds = TimeUnit.MILLISECONDS.toSeconds(j);
        TextView textView = this.atv_time_left_value;
        textView.setText(seconds + "");
    }

    @Override
    public void tik_onFinish(Boolean bool) {
        Enable();
        stopService(new Intent(this, realmoney_23.class));
    }

    public int Random() {
        return new Random().nextInt(200) + 100;
    }

    public void Set_Random_Number() {
        TextView textView = this.atv_1;
        textView.setText("" + Random());
        TextView textView2 = this.atv_2;
        textView2.setText("" + Random());
        TextView textView3 = this.atv_3;
        textView3.setText("" + Random());
        TextView textView4 = this.atv_4;
        textView4.setText("" + Random());
        TextView textView5 = this.atv_5;
        textView5.setText("" + Random());
        TextView textView6 = this.atv_6;
        textView6.setText("" + Random());
        TextView textView7 = this.atv_7;
        textView7.setText("" + Random());
        TextView textView8 = this.atv_8;
        textView8.setText("" + Random());
        TextView textView9 = this.atv_9;
        textView9.setText("" + Random());
        TextView textView10 = this.atv_10;
        textView10.setText("" + Random());
        TextView textView11 = this.atv_11;
        textView11.setText("" + Random());
        TextView textView12 = this.atv_12;
        textView12.setText("" + Random());
        TextView textView13 = this.atv_13;
        textView13.setText("" + Random());
        TextView textView14 = this.atv_14;
        textView14.setText("" + Random());
        TextView textView15 = this.atv_15;
        textView15.setText("" + Random());
        TextView textView16 = this.atv_16;
        textView16.setText("" + Random());
    }

    public void Enable() {
        this.iv_1.setEnabled(true);
        this.iv_2.setEnabled(true);
        this.iv_3.setEnabled(true);
        this.iv_4.setEnabled(true);
        this.iv_5.setEnabled(true);
        this.iv_6.setEnabled(true);
        this.iv_7.setEnabled(true);
        this.iv_8.setEnabled(true);
        this.iv_9.setEnabled(true);
        this.iv_10.setEnabled(true);
        this.iv_11.setEnabled(true);
        this.iv_12.setEnabled(true);
        this.iv_13.setEnabled(true);
        this.iv_14.setEnabled(true);
        this.iv_15.setEnabled(true);
        this.iv_16.setEnabled(true);
    }

    public void Disable() {
        this.iv_1.setEnabled(false);
        this.iv_2.setEnabled(false);
        this.iv_3.setEnabled(false);
        this.iv_4.setEnabled(false);
        this.iv_5.setEnabled(false);
        this.iv_6.setEnabled(false);
        this.iv_7.setEnabled(false);
        this.iv_8.setEnabled(false);
        this.iv_9.setEnabled(false);
        this.iv_10.setEnabled(false);
        this.iv_11.setEnabled(false);
        this.iv_12.setEnabled(false);
        this.iv_13.setEnabled(false);
        this.iv_14.setEnabled(false);
        this.iv_15.setEnabled(false);
        this.iv_16.setEnabled(false);
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
                realmoney_24.is_first = true;
                conform_dialog.dismiss();
                EarnMoney_89.this.myMoney.setPref(MyMoney.POINTS, EarnMoney_89.this.myMoney.getPref(MyMoney.POINTS, 0).intValue() + Integer.parseInt(EarnMoney_89.this.result));
                TextView textView = EarnMoney_89.this.atv_coin_value;
                textView.setText("" + EarnMoney_89.this.myMoney.getPref(MyMoney.POINTS, 0));
                int intValue = EarnMoney_89.this.myMoney.getPref(MyMoney.FLIP_LEFT, 0).intValue();
                if (intValue != 0) {
                    int i = intValue - 1;
                    EarnMoney_89.this.myMoney.setPref(MyMoney.FLIP_LEFT, i);
                    EarnMoney_89.this.myMoney.setPref(MyMoney.FLIP_COUNT, EarnMoney_89.this.myMoney.getPref(MyMoney.FLIP_COUNT, 0).intValue() + (Integer.parseInt(EarnMoney_89.this.result) * 2));
                    TextView textView2 = EarnMoney_89.this.atv_flip_left_value;
                    textView2.setText("" + EarnMoney_89.this.myMoney.getPref(MyMoney.FLIP_LEFT, 0));
                    if (i != 0) {
                        EarnMoney_89 earnMoney89 = EarnMoney_89.this;
                        earnMoney89.startService(new Intent(earnMoney89, realmoney_23.class));
                        return;
                    }
                    EarnMoney_89.this.Disable();
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault());
                    Calendar instance = Calendar.getInstance();
                    instance.setTime(new Date());
                    instance.add(5, 1);
                    EarnMoney_89.this.myMoney.setPref(MyMoney.AFTER_TWO_HOUR_FLIP, simpleDateFormat.format(instance.getTime()));
                    String format = new SimpleDateFormat("HH:mm:ss").format(instance.getTime());
                    EarnMoney_89.this.atv_time_left_value.setText(new SimpleDateFormat("hh:mm aa").format(instance.getTime()));
                    EarnMoney_89.this.Notification(format);
                }
            }
        });

        this.conform_dialog.show();

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

        ((AlarmManager) getSystemService(NotificationCompat.CATEGORY_ALARM)).setRepeating(0, instance.getTimeInMillis(), 86400000, PendingIntent.getBroadcast(this, 10000, new Intent(this, earnmoney_59.class), PendingIntent.FLAG_IMMUTABLE));

    }

    @Override 
    public void onBackPressed() {
        if (earnmoney.isAdOn) {
            if (earnmoney.ad_mode.equalsIgnoreCase("admob")) {
                if (realmoney12.isInternetOn(EarnMoney_89.this)) {
                    realmoney12.getInstance().loadintertialads(EarnMoney_89.this, earnmoney.admob_inter_id, new realmoney12.MyCallback() {
                        @Override
                        public void callbackCall() {
                            startActivity(new Intent(EarnMoney_89.this, EarnMoney_82.class));
                         }
                    });
                } else {
                    startActivity(new Intent(EarnMoney_89.this, EarnMoney_82.class));
                }
            } else if (earnmoney.ad_mode.equalsIgnoreCase("qureka")) {

                realmoney14.getInstance().qureka_inter(EarnMoney_89.this, new realmoney14.MyCallback() {
                    @Override
                    public void callbackCall() {
                        startActivity(new Intent(EarnMoney_89.this, EarnMoney_82.class));
                    }
                });

            } else {

                if (realmoney21.isInternetOn(EarnMoney_89.this)) {
                    realmoney21.getInstance().loadintertialads(EarnMoney_89.this, earnmoney.facebook_inter_id, new realmoney21.MyCallback() {
                        @Override
                        public void callbackCall() {
                            startActivity(new Intent(EarnMoney_89.this, EarnMoney_82.class));
                        }
                    });
                } else {
                    startActivity(new Intent(EarnMoney_89.this, EarnMoney_82.class));
                }
            }

        } else {
            startActivity(new Intent(EarnMoney_89.this, EarnMoney_82.class));
        }

    }

    @Override 
    public void onResume() {
        registerReceiver(this.br, new IntentFilter(getPackageName()));
        realmoney_23.activity = this;
        TextView textView = this.atv_coin_value;
        textView.setText("" + this.myMoney.getPref(MyMoney.POINTS, 0));
        TextView textView2 = this.atv_flip_left_value;
        textView2.setText("" + this.myMoney.getPref(MyMoney.FLIP_LEFT, 0));
        if (this.myMoney.getPref(MyMoney.SPIN_LEFT, 0).intValue() == 0) {
            Disable();
        } else {
            Enable();
        }
        super.onResume();
        if (this.mCustomTabsOpened) {
            this.mCustomTabsOpened = false;
            finish();
        }
        String pref = this.myMoney.getPref(MyMoney.AFTER_TWO_HOUR_FLIP, "");
        if (!pref.equalsIgnoreCase("")) {
            Date date = null;
            try {
                date = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).parse(pref);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            if (System.currentTimeMillis() > date.getTime()) {
                this.myMoney.setPref(MyMoney.AFTER_TWO_HOUR_FLIP, "");
                this.myMoney.setPref(MyMoney.FLIP_LEFT, 8);
                TextView textView3 = this.atv_flip_left_value;
                textView3.setText("" + this.myMoney.getPref(MyMoney.FLIP_LEFT, 0));
                this.atv_time_left_value.setText("00");
                Enable();
                return;
            }
            Disable();
            String format = new SimpleDateFormat("HH:mm:ss").format(Long.valueOf(date.getTime()));
            this.atv_time_left_value.setText(new SimpleDateFormat("hh:mm aa").format(Long.valueOf(date.getTime())));
            Notification(format);
            return;
        }
        Enable();
    }

    @Override 
    public void onDestroy() {
        super.onDestroy();
    }

}
