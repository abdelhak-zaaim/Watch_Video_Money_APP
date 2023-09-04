package watchvideo.dailytrend.Earnmoney_2;

import static watchvideo.dailytrend.Earnmoney.earnmoney.quera_link;
import static watchvideo.dailytrend.Earnmoney.earnmoney.qureka_visible;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.facebook.shimmer.ShimmerFrameLayout;
import watchvideo.dailytrend.Earnmoney.earnmoney;
import watchvideo.dailytrend.Earnmoney.realmoney;

import watchvideo.dailytrend.Earnmoney.realmoney14;
import watchvideo.dailytrend.Earnmoney.realmoney13;
import watchvideo.dailytrend.Earnmoney.realmoney12;
import watchvideo.dailytrend.Earnmoney.realmoney21;
import watchvideo.dailytrend.MyMoney;
import watchvideo.dailytrend.earnmoney_21;
import watchvideo.dailytrend.R;
import watchvideo.dailytrend.VideoCall.videocalling;
import watchvideo.dailytrend.Realmoney_3.realmoney_47.realmoney_40;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;

@SuppressLint("WrongConstant")
public class EarnMoney_82 extends AppCompatActivity implements View.OnClickListener {

    Animation anim2;
    Animation animation;
    TextView atv_coin_value;
    Dialog conform_dialog;
    int from;
    ImageView history;
    TextView ll_all_task;
    TextView ll_lucky_spin;
    TextView ll_redeem_card;
    RelativeLayout ll_right;
    private boolean mCustomTabsOpened = false;
    MyMoney myMoney;
    ImageView profile;

    LinearLayout rl_daily_bonus;
    LinearLayout rl_extra_coin;
    LinearLayout rl_flip_card;
    LinearLayout rl_gift;
    LinearLayout rl_invite_friends;
    LinearLayout rl_randomVideocall;
    LinearLayout rl_rate_us;
    LinearLayout rl_refferal_code;
    LinearLayout rl_scratch_card;
    LinearLayout rl_spinwin;
    LinearLayout rl_watch_love;
    LinearLayout rl_watch_video;
    Timer y;

    RelativeLayout adContainerView, adContainerPlaylist;
    ShimmerFrameLayout main_act_banner;

    LinearLayout tech_paly,game_250,mega_prize,play_quiz,play_win,play_cricket;

    LinearLayout tech_play1,game250_1,megaprize_1,playquiz_1,playwin_1,playcricket_1;

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.videocallgirls);

        earnmoney_21.getwebdata(this);

        this.animation = AnimationUtils.loadAnimation(this, R.anim.moneyapp);
        this.anim2 = AnimationUtils.loadAnimation(this, R.anim.slotmachine);

        tech_paly = findViewById(R.id.tech_play);
        game_250 = findViewById(R.id.game250);
        mega_prize = findViewById(R.id.megaprize);
        play_quiz = findViewById(R.id.playquiz);
        play_win = findViewById(R.id.playwin);
        play_cricket = findViewById(R.id.playcricket);


        tech_play1 = findViewById(R.id.tech_play1);
        game250_1 = findViewById(R.id.game250_1);
        megaprize_1 = findViewById(R.id.megaprize_1);
        playquiz_1 = findViewById(R.id.playquiz_1);
        playwin_1 = findViewById(R.id.playwin_1);
        playcricket_1 = findViewById(R.id.playcricket_1);


        tech_paly.setOnClickListener(new View.OnClickListener() {
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

        game_250.setOnClickListener(new View.OnClickListener() {
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

        mega_prize.setOnClickListener(new View.OnClickListener() {
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


        play_quiz.setOnClickListener(new View.OnClickListener() {
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



        play_win.setOnClickListener(new View.OnClickListener() {
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



        play_cricket.setOnClickListener(new View.OnClickListener() {
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

        tech_play1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent1 = new Intent("android.intent.action.VIEW");
                    Bundle bundle = new Bundle();
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
                    bundle.putBinder("android.support.customtabs.extra.SESSION", null);
                    intent2.putExtras(bundle);
                    intent2.putExtra("android.support.customtabs.extra.TOOLBAR_COLOR", R.color.colorPrimary);
                    intent2.putExtra("android.support.customtabs.extra.EXTRA_ENABLE_INSTANT_APPS", true);
                    intent2.setData(Uri.parse(quera_link));
                    startActivity(intent2, bundle);

                }
            }
        });

        game250_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent1 = new Intent("android.intent.action.VIEW");
                    Bundle bundle = new Bundle();
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
                    bundle.putBinder("android.support.customtabs.extra.SESSION", null);
                    intent2.putExtras(bundle);
                    intent2.putExtra("android.support.customtabs.extra.TOOLBAR_COLOR", R.color.colorPrimary);
                    intent2.putExtra("android.support.customtabs.extra.EXTRA_ENABLE_INSTANT_APPS", true);
                    intent2.setData(Uri.parse(quera_link));
                    startActivity(intent2, bundle);

                }
            }
        });

        megaprize_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent1 = new Intent("android.intent.action.VIEW");
                    Bundle bundle = new Bundle();
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
                    bundle.putBinder("android.support.customtabs.extra.SESSION", null);
                    intent2.putExtras(bundle);
                    intent2.putExtra("android.support.customtabs.extra.TOOLBAR_COLOR", R.color.colorPrimary);
                    intent2.putExtra("android.support.customtabs.extra.EXTRA_ENABLE_INSTANT_APPS", true);
                    intent2.setData(Uri.parse(quera_link));
                    startActivity(intent2, bundle);

                }
            }
        });

        playquiz_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent1 = new Intent("android.intent.action.VIEW");
                    Bundle bundle = new Bundle();
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
                    bundle.putBinder("android.support.customtabs.extra.SESSION", null);
                    intent2.putExtras(bundle);
                    intent2.putExtra("android.support.customtabs.extra.TOOLBAR_COLOR", R.color.colorPrimary);
                    intent2.putExtra("android.support.customtabs.extra.EXTRA_ENABLE_INSTANT_APPS", true);
                    intent2.setData(Uri.parse(quera_link));
                    startActivity(intent2, bundle);

                }
            }
        });

        playwin_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent1 = new Intent("android.intent.action.VIEW");
                    Bundle bundle = new Bundle();
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
                    bundle.putBinder("android.support.customtabs.extra.SESSION", null);
                    intent2.putExtras(bundle);
                    intent2.putExtra("android.support.customtabs.extra.TOOLBAR_COLOR", R.color.colorPrimary);
                    intent2.putExtra("android.support.customtabs.extra.EXTRA_ENABLE_INSTANT_APPS", true);
                    intent2.setData(Uri.parse(quera_link));
                    startActivity(intent2, bundle);

                }
            }
        });

        playcricket_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent1 = new Intent("android.intent.action.VIEW");
                    Bundle bundle = new Bundle();
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
                    bundle.putBinder("android.support.customtabs.extra.SESSION", null);
                    intent2.putExtras(bundle);
                    intent2.putExtra("android.support.customtabs.extra.TOOLBAR_COLOR", R.color.colorPrimary);
                    intent2.putExtra("android.support.customtabs.extra.EXTRA_ENABLE_INSTANT_APPS", true);
                    intent2.setData(Uri.parse(quera_link));
                    startActivity(intent2, bundle);

                }
            }
        });




        if (qureka_visible){
            tech_paly.setVisibility(View.VISIBLE);
            game_250.setVisibility(View.VISIBLE);
            mega_prize.setVisibility(View.VISIBLE);
            play_quiz.setVisibility(View.VISIBLE);
            play_win.setVisibility(View.VISIBLE);
            play_cricket.setVisibility(View.VISIBLE);
            tech_play1.setVisibility(View.VISIBLE);
            game250_1.setVisibility(View.VISIBLE);
            megaprize_1.setVisibility(View.VISIBLE);
            playquiz_1.setVisibility(View.VISIBLE);
            playwin_1.setVisibility(View.VISIBLE);
            playcricket_1.setVisibility(View.VISIBLE);
        }else{
            tech_paly.setVisibility(View.GONE);
            game_250.setVisibility(View.GONE);
            mega_prize.setVisibility(View.GONE);
            play_quiz.setVisibility(View.GONE);
            play_win.setVisibility(View.GONE);
            play_cricket.setVisibility(View.GONE);
            tech_play1.setVisibility(View.GONE);
            game250_1.setVisibility(View.GONE);
            megaprize_1.setVisibility(View.GONE);
            playquiz_1.setVisibility(View.GONE);
            playwin_1.setVisibility(View.GONE);
            playcricket_1.setVisibility(View.GONE);
        }


        //Banner :-
        adContainerView = findViewById(R.id.adViewContainer);
        adContainerPlaylist = findViewById(R.id.adViewContainer);
        main_act_banner = findViewById(R.id.main_act_banner);


        if (earnmoney.isAdOn) {
            if (earnmoney.ad_mode.equalsIgnoreCase("admob")) {
                realmoney.creteadadaptiveBanner(EarnMoney_82.this, adContainerPlaylist, earnmoney.admob_banner_id);
            } else if (earnmoney.ad_mode.equalsIgnoreCase("qureka")) {
                main_act_banner.setVisibility(View.VISIBLE);
            } else {
                adContainerView.setBackgroundResource(R.drawable.realmoney_140);
                realmoney13.createFBLoadBanner(EarnMoney_82.this, adContainerPlaylist, earnmoney.facebook_banner_id);
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


        ((ImageView) findViewById(R.id.ivback)).setOnClickListener(new View.OnClickListener() {
            @Override 
            public void onClick(View view) {
                if (earnmoney.isAdOn) {
                    if (earnmoney.ad_mode.equalsIgnoreCase("admob")) {
                        if (realmoney12.isInternetOn(EarnMoney_82.this)) {
                            realmoney12.getInstance().loadintertialads(EarnMoney_82.this, earnmoney.admob_inter_id, new realmoney12.MyCallback() {
                                @Override
                                public void callbackCall() {
                                    startActivity(new Intent(EarnMoney_82.this, EarnMoney_85.class));
                                }
                            });
                        } else {
                            startActivity(new Intent(EarnMoney_82.this, EarnMoney_85.class));
                        }
                    } else if (earnmoney.ad_mode.equalsIgnoreCase("qureka")) {

                        realmoney14.getInstance().qureka_inter(EarnMoney_82.this, new realmoney14.MyCallback() {
                            @Override
                            public void callbackCall() {
                                startActivity(new Intent(EarnMoney_82.this, EarnMoney_85.class));
                            }
                        });

                    } else {

                        if (realmoney21.isInternetOn(EarnMoney_82.this)) {
                            realmoney21.getInstance().loadintertialads(EarnMoney_82.this, earnmoney.facebook_inter_id, new realmoney21.MyCallback() {
                                @Override
                                public void callbackCall() {
                                    startActivity(new Intent(EarnMoney_82.this, EarnMoney_85.class));
                                }
                            });
                        } else {
                            startActivity(new Intent(EarnMoney_82.this, EarnMoney_85.class));
                        }
                    }

                } else {
                    startActivity(new Intent(EarnMoney_82.this, EarnMoney_85.class));
                }

            }
        });


        ImageView imageView2 = (ImageView) findViewById(R.id.img_history);
        this.history = imageView2;
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override 
            public void onClick(View view) {
                if (earnmoney.isAdOn) {
                    if (earnmoney.ad_mode.equalsIgnoreCase("admob")) {
                        if (realmoney12.isInternetOn(EarnMoney_82.this)) {
                            realmoney12.getInstance().loadintertialads(EarnMoney_82.this, earnmoney.admob_inter_id, new realmoney12.MyCallback() {
                                @Override
                                public void callbackCall() {
                                    startActivity(new Intent(EarnMoney_82.this, RealMoney_82.class));
                                }
                            });
                        } else {
                            startActivity(new Intent(EarnMoney_82.this, RealMoney_82.class));
                        }

                    } else if (earnmoney.ad_mode.equalsIgnoreCase("qureka")) {

                        realmoney14.getInstance().qureka_inter(EarnMoney_82.this, new realmoney14.MyCallback() {
                            @Override
                            public void callbackCall() {
                                startActivity(new Intent(EarnMoney_82.this, RealMoney_82.class));
                            }
                        });

                    } else {

                        if (realmoney21.isInternetOn(EarnMoney_82.this)) {
                            realmoney21.getInstance().loadintertialads(EarnMoney_82.this, earnmoney.facebook_inter_id, new realmoney21.MyCallback() {
                                @Override
                                public void callbackCall() {
                                    startActivity(new Intent(EarnMoney_82.this, RealMoney_82.class));
                                }
                            });
                        } else {
                            startActivity(new Intent(EarnMoney_82.this, RealMoney_82.class));
                        }
                    }
                } else {
                    startActivity(new Intent(EarnMoney_82.this, RealMoney_82.class));
                }

            }
        });


        ImageView imageView3 = (ImageView) findViewById(R.id.img_profile);
        this.profile = imageView3;
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override 
            public void onClick(View view) {
                if (earnmoney.isAdOn) {
                    if (earnmoney.ad_mode.equalsIgnoreCase("admob")) {
                        if (realmoney12.isInternetOn(EarnMoney_82.this)) {
                            realmoney12.getInstance().loadintertialads(EarnMoney_82.this, earnmoney.admob_inter_id, new realmoney12.MyCallback() {
                                @Override
                                public void callbackCall() {
                                    startActivity(new Intent(EarnMoney_82.this, RealMoney_88.class));
                                }
                            });
                        } else {
                            startActivity(new Intent(EarnMoney_82.this, RealMoney_88.class));
                        }

                    } else if (earnmoney.ad_mode.equalsIgnoreCase("qureka")) {

                        realmoney14.getInstance().qureka_inter(EarnMoney_82.this, new realmoney14.MyCallback() {
                            @Override
                            public void callbackCall() {
                                startActivity(new Intent(EarnMoney_82.this, RealMoney_88.class));
                            }
                        });

                    } else {

                        if (realmoney21.isInternetOn(EarnMoney_82.this)) {
                            realmoney21.getInstance().loadintertialads(EarnMoney_82.this, earnmoney.facebook_inter_id, new realmoney21.MyCallback() {
                                @Override
                                public void callbackCall() {
                                    startActivity(new Intent(EarnMoney_82.this, RealMoney_88.class));
                                }
                            });
                        } else {
                            startActivity(new Intent(EarnMoney_82.this, RealMoney_88.class));
                        }
                    }
                } else {
                    startActivity(new Intent(EarnMoney_82.this, RealMoney_88.class));
                }
            }
        });


        Dialog dialog = new Dialog(this, R.style.TransparentBackground);
        this.conform_dialog = dialog;
        dialog.requestWindowFeature(1);
        this.conform_dialog.setContentView(R.layout.realmoneyspin);
        this.conform_dialog.getWindow().setLayout(-1, -2);

        Initialize();
        sign();
        checkAndRequestPermissions();

        RelativeLayout linearLayout = (RelativeLayout) findViewById(R.id.ll_right);
        this.ll_right = linearLayout;
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override 
            public void onClick(View view) {
                startActivity(new Intent(EarnMoney_82.this, RealMoney_81.class));
            }
        });

        this.rl_gift = (LinearLayout) findViewById(R.id.rl_gift);
        LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.rl_spinwin);
        this.rl_spinwin = linearLayout2;
        linearLayout2.setOnClickListener(new View.OnClickListener() {
            @Override 
            public void onClick(View view) {
                view.startAnimation(EarnMoney_82.this.animation);
                if (earnmoney.isAdOn) {
                    if (earnmoney.ad_mode.equalsIgnoreCase("admob")) {
                        if (realmoney12.isInternetOn(EarnMoney_82.this)) {
                            realmoney12.getInstance().loadintertialads(EarnMoney_82.this, earnmoney.admob_inter_id, new realmoney12.MyCallback() {
                                @Override
                                public void callbackCall() {
                                    startActivity(new Intent(EarnMoney_82.this, RealMoney_86.class));
                                }
                            });
                        } else {
                            startActivity(new Intent(EarnMoney_82.this, RealMoney_86.class));
                        }

                    } else if (earnmoney.ad_mode.equalsIgnoreCase("qureka")) {

                        realmoney14.getInstance().qureka_inter(EarnMoney_82.this, new realmoney14.MyCallback() {
                            @Override
                            public void callbackCall() {
                                startActivity(new Intent(EarnMoney_82.this, RealMoney_86.class));
                            }
                        });

                    } else {

                        if (realmoney21.isInternetOn(EarnMoney_82.this)) {
                            realmoney21.getInstance().loadintertialads(EarnMoney_82.this, earnmoney.facebook_inter_id, new realmoney21.MyCallback() {
                                @Override
                                public void callbackCall() {
                                    startActivity(new Intent(EarnMoney_82.this, RealMoney_86.class));
                                }
                            });
                        } else {
                            startActivity(new Intent(EarnMoney_82.this, RealMoney_86.class));
                        }
                    }
                } else {
                    startActivity(new Intent(EarnMoney_82.this, RealMoney_86.class));
                }
            }
        });


        this.rl_gift.setOnClickListener(new View.OnClickListener() {
            @Override 
            public void onClick(View view) {
                view.startAnimation(EarnMoney_82.this.animation);
                if (earnmoney.isAdOn) {
                    if (earnmoney.ad_mode.equalsIgnoreCase("admob")) {
                        if (realmoney12.isInternetOn(EarnMoney_82.this)) {
                            realmoney12.getInstance().loadintertialads(EarnMoney_82.this, earnmoney.admob_inter_id, new realmoney12.MyCallback() {
                                @Override
                                public void callbackCall() {
                                    startActivity(new Intent(EarnMoney_82.this, RealMoney_81.class));
                                }
                            });
                        } else {
                            startActivity(new Intent(EarnMoney_82.this, RealMoney_81.class));
                        }

                    } else if (earnmoney.ad_mode.equalsIgnoreCase("qureka")) {

                        realmoney14.getInstance().qureka_inter(EarnMoney_82.this, new realmoney14.MyCallback() {
                            @Override
                            public void callbackCall() {
                                startActivity(new Intent(EarnMoney_82.this, RealMoney_81.class));
                            }
                        });

                    } else {

                        if (realmoney21.isInternetOn(EarnMoney_82.this)) {
                            realmoney21.getInstance().loadintertialads(EarnMoney_82.this, earnmoney.facebook_inter_id, new realmoney21.MyCallback() {
                                @Override
                                public void callbackCall() {
                                    startActivity(new Intent(EarnMoney_82.this, RealMoney_81.class));
                                }
                            });
                        } else {
                            startActivity(new Intent(EarnMoney_82.this, RealMoney_81.class));
                        }
                    }
                } else {
                    startActivity(new Intent(EarnMoney_82.this, RealMoney_81.class));
                }
            }
        });


        LinearLayout linearLayout3 = (LinearLayout) findViewById(R.id.rl_randomVideocall);
        this.rl_randomVideocall = linearLayout3;
        linearLayout3.setOnClickListener(new View.OnClickListener() {
            @Override 
            public void onClick(View view) {
                if (earnmoney.isAdOn) {
                    if (earnmoney.ad_mode.equalsIgnoreCase("admob")) {
                        if (realmoney12.isInternetOn(EarnMoney_82.this)) {
                            realmoney12.getInstance().loadintertialads(EarnMoney_82.this, earnmoney.admob_inter_id, new realmoney12.MyCallback() {
                                @Override
                                public void callbackCall() {
                                    if (earnmoney_21.live_video_call_url != null || !earnmoney_21.live_video_call_url.equals("")) {
                                        Intent intent = new Intent(EarnMoney_82.this, videocalling.class);
                                        intent.putExtra("url", earnmoney_21.live_video_call_url);
                                        EarnMoney_82.this.startActivity(intent);
                                        return;
                                    }
                                    Toast.makeText(EarnMoney_82.this, "Can't getting Video Please try again latter...", 0).show();
                                }
                            });
                        } else {
                            if (earnmoney_21.live_video_call_url != null || !earnmoney_21.live_video_call_url.equals("")) {
                                Intent intent = new Intent(EarnMoney_82.this, videocalling.class);
                                intent.putExtra("url", earnmoney_21.live_video_call_url);
                                EarnMoney_82.this.startActivity(intent);
                                return;
                            }
                            Toast.makeText(EarnMoney_82.this, "Can't getting Video Please try again latter...", 0).show();
                        }

                    } else if (earnmoney.ad_mode.equalsIgnoreCase("qureka")) {

                        realmoney14.getInstance().qureka_inter(EarnMoney_82.this, new realmoney14.MyCallback() {
                            @Override
                            public void callbackCall() {
                                if (earnmoney_21.live_video_call_url != null || !earnmoney_21.live_video_call_url.equals("")) {
                                    Intent intent = new Intent(EarnMoney_82.this, videocalling.class);
                                    intent.putExtra("url", earnmoney_21.live_video_call_url);
                                    EarnMoney_82.this.startActivity(intent);
                                    return;
                                }
                                Toast.makeText(EarnMoney_82.this, "Can't getting Video Please try again latter...", 0).show();
                            }
                        });

                    } else {

                        if (realmoney21.isInternetOn(EarnMoney_82.this)) {
                            realmoney21.getInstance().loadintertialads(EarnMoney_82.this, earnmoney.facebook_inter_id, new realmoney21.MyCallback() {
                                @Override
                                public void callbackCall() {
                                    if (earnmoney_21.live_video_call_url != null || !earnmoney_21.live_video_call_url.equals("")) {
                                        Intent intent = new Intent(EarnMoney_82.this, videocalling.class);
                                        intent.putExtra("url", earnmoney_21.live_video_call_url);
                                        EarnMoney_82.this.startActivity(intent);
                                        return;
                                    }
                                    Toast.makeText(EarnMoney_82.this, "Can't getting Video Please try again latter...", 0).show();
                                }
                            });
                        } else {
                            if (earnmoney_21.live_video_call_url != null || !earnmoney_21.live_video_call_url.equals("")) {
                                Intent intent = new Intent(EarnMoney_82.this, videocalling.class);
                                intent.putExtra("url", earnmoney_21.live_video_call_url);
                                EarnMoney_82.this.startActivity(intent);
                                return;
                            }
                            Toast.makeText(EarnMoney_82.this, "Can't getting Video Please try again latter...", 0).show();
                        }
                    }
                } else {
                    if (earnmoney_21.live_video_call_url != null || !earnmoney_21.live_video_call_url.equals("")) {
                        Intent intent = new Intent(EarnMoney_82.this, videocalling.class);
                        intent.putExtra("url", earnmoney_21.live_video_call_url);
                        EarnMoney_82.this.startActivity(intent);
                        return;
                    }
                    Toast.makeText(EarnMoney_82.this, "Can't getting Video Please try again latter...", 0).show();
                }

            }
        });


        LinearLayout linearLayout4 = (LinearLayout) findViewById(R.id.rl_watch_love);
        this.rl_watch_love = linearLayout4;
        linearLayout4.setOnClickListener(new View.OnClickListener() {
            @Override 
            public void onClick(View view) {
                view.startAnimation(EarnMoney_82.this.animation);
                if (earnmoney.isAdOn) {
                    if (earnmoney.ad_mode.equalsIgnoreCase("admob")) {
                        if (realmoney12.isInternetOn(EarnMoney_82.this)) {
                            realmoney12.getInstance().loadintertialads(EarnMoney_82.this, earnmoney.admob_inter_id, new realmoney12.MyCallback() {
                                @Override
                                public void callbackCall() {
                                    Intent intent = new Intent(EarnMoney_82.this, realmoney_40.class);
                                    intent.putExtra("category", "Lyrical");
                                    EarnMoney_82.this.startActivity(intent);
                                }
                            });
                        } else {
                            Intent intent = new Intent(EarnMoney_82.this, realmoney_40.class);
                            intent.putExtra("category", "Lyrical");
                            EarnMoney_82.this.startActivity(intent);
                        }

                    } else if (earnmoney.ad_mode.equalsIgnoreCase("qureka")) {

                        realmoney14.getInstance().qureka_inter(EarnMoney_82.this, new realmoney14.MyCallback() {
                            @Override
                            public void callbackCall() {
                                Intent intent = new Intent(EarnMoney_82.this, realmoney_40.class);
                                intent.putExtra("category", "Lyrical");
                                EarnMoney_82.this.startActivity(intent);
                            }
                        });

                    } else {

                        if (realmoney21.isInternetOn(EarnMoney_82.this)) {
                            realmoney21.getInstance().loadintertialads(EarnMoney_82.this, earnmoney.facebook_inter_id, new realmoney21.MyCallback() {
                                @Override
                                public void callbackCall() {
                                    Intent intent = new Intent(EarnMoney_82.this, realmoney_40.class);
                                    intent.putExtra("category", "Lyrical");
                                    EarnMoney_82.this.startActivity(intent);
                                }
                            });
                        } else {
                            Intent intent = new Intent(EarnMoney_82.this, realmoney_40.class);
                            intent.putExtra("category", "Lyrical");
                            EarnMoney_82.this.startActivity(intent);
                        }
                    }
                } else {
                    Intent intent = new Intent(EarnMoney_82.this, realmoney_40.class);
                    intent.putExtra("category", "Lyrical");
                    EarnMoney_82.this.startActivity(intent);
                }

            }
        });

    }


    public static String m5849a(StringBuilder sb, String str, String str2) {
        sb.append(str);
        sb.append(str2);
        return sb.toString();
    }


    public void sign() {
        try {
            Signature[] signatureArr = getPackageManager().getPackageInfo(getPackageName(), 64).signatures;
            if (signatureArr.length > 0) {
                Signature signature = signatureArr[0];
                MessageDigest instance = MessageDigest.getInstance("SHA");
                instance.update(signature.toByteArray());
                String replace = Base64.encodeToString(instance.digest(), 2).replace("+", "*");
                String packageName = getPackageName();
                StringBuilder sb = new StringBuilder();
                sb.append("https://");
                sb.append("androidsolution.xyz/");
                sb.append("statusandrewardsapp/");
                sb.append("api/");
                sb.append("get_posts");
                sb.append("?api_key=" + replace + "&package_name=" + packageName + "&page=1");
                Log.d("sb", sb.toString());
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
        }
    }


    public void Initialize() {
        this.myMoney = new MyMoney(this);
        this.atv_coin_value = (TextView) findViewById(R.id.atv_coin_value);
        TextView textView = (TextView) findViewById(R.id.ll_all_task);
        this.ll_all_task = textView;
        textView.setOnClickListener(this);
        TextView textView2 = (TextView) findViewById(R.id.ll_redeem_card);
        this.ll_redeem_card = textView2;
        textView2.setOnClickListener(this);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.rl_invite_friends);
        this.rl_invite_friends = linearLayout;
        linearLayout.setOnClickListener(this);
        TextView textView3 = (TextView) findViewById(R.id.ll_lucky_spin);
        this.ll_lucky_spin = textView3;
        textView3.setOnClickListener(this);
        LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.rl_watch_video);
        this.rl_watch_video = linearLayout2;
        linearLayout2.setOnClickListener(this);
        LinearLayout linearLayout3 = (LinearLayout) findViewById(R.id.rl_extra_coin);
        this.rl_extra_coin = linearLayout3;
        linearLayout3.setOnClickListener(this);
        LinearLayout linearLayout4 = (LinearLayout) findViewById(R.id.rl_daily_bonus);
        this.rl_daily_bonus = linearLayout4;
        linearLayout4.setOnClickListener(this);
        LinearLayout linearLayout5 = (LinearLayout) findViewById(R.id.rl_flip_card);
        this.rl_flip_card = linearLayout5;
        linearLayout5.setOnClickListener(this);
        LinearLayout linearLayout6 = (LinearLayout) findViewById(R.id.rl_scratch_card);
        this.rl_scratch_card = linearLayout6;
        linearLayout6.setOnClickListener(this);
        LinearLayout linearLayout7 = (LinearLayout) findViewById(R.id.rl_refferal_code);
        this.rl_refferal_code = linearLayout7;
        linearLayout7.setOnClickListener(this);
        LinearLayout linearLayout8 = (LinearLayout) findViewById(R.id.rl_rate_us);
        this.rl_rate_us = linearLayout8;
        linearLayout8.setOnClickListener(this);
    }


    @Override 
    public void onClick(View view) {
        view.startAnimation(this.animation);
        switch (view.getId()) {
            case R.id.ll_lucky_spin :
                LuckySpinScreen();
                return;
            case R.id.ll_redeem_card :
                RedeemScreen();
                return;
            case R.id.rl_daily_bonus :
                DailyCheckScreen();
                return;
            case R.id.rl_extra_coin :
                SlotMachineScreen();
                return;
            case R.id.rl_flip_card :
                FlipCardScreen();
                return;
            case R.id.rl_invite_friends :
                InviteScreen();
                return;
            case R.id.rl_rate_us :
                try {
                    StringBuilder sb = new StringBuilder();
                    sb.append("https://play.google.com/store/apps/details?id=");
                    sb.append(getPackageName());
                    startActivity(new Intent("android.intent.action.VIEW", Uri.parse(sb.toString())));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return;
            case R.id.rl_refferal_code :
                ReferralCodeScreen();
                return;
            case R.id.rl_scratch_card :
                ScratchCardScreen();
                return;
            case R.id.rl_watch_video :
                this.from = 5;
                WatchVideoScreeNew();
                return;
            default:
                return;
        }
    }


    public void RedeemScreen() {
        if (earnmoney.isAdOn) {
            if (earnmoney.ad_mode.equalsIgnoreCase("admob")) {
                if (realmoney12.isInternetOn(EarnMoney_82.this)) {
                    realmoney12.getInstance().loadintertialads(EarnMoney_82.this, earnmoney.admob_inter_id, new realmoney12.MyCallback() {
                        @Override
                        public void callbackCall() {
                            Intent intent = new Intent(EarnMoney_82.this, RealMoney_81.class);
                            intent.putExtra("is_from_home", true);
                            EarnMoney_82.this.startActivity(intent);
                        }
                    });
                } else {
                    Intent intent = new Intent(EarnMoney_82.this, RealMoney_81.class);
                    intent.putExtra("is_from_home", true);
                    EarnMoney_82.this.startActivity(intent);
                }

            } else if (earnmoney.ad_mode.equalsIgnoreCase("qureka")) {

                realmoney14.getInstance().qureka_inter(EarnMoney_82.this, new realmoney14.MyCallback() {
                    @Override
                    public void callbackCall() {
                        Intent intent = new Intent(EarnMoney_82.this, RealMoney_81.class);
                        intent.putExtra("is_from_home", true);
                        EarnMoney_82.this.startActivity(intent);
                    }
                });

            } else {

                if (realmoney21.isInternetOn(EarnMoney_82.this)) {
                    realmoney21.getInstance().loadintertialads(EarnMoney_82.this, earnmoney.facebook_inter_id, new realmoney21.MyCallback() {
                        @Override
                        public void callbackCall() {
                            Intent intent = new Intent(EarnMoney_82.this, RealMoney_81.class);
                            intent.putExtra("is_from_home", true);
                            EarnMoney_82.this.startActivity(intent);
                        }
                    });
                } else {
                    Intent intent = new Intent(EarnMoney_82.this, RealMoney_81.class);
                    intent.putExtra("is_from_home", true);
                    EarnMoney_82.this.startActivity(intent);
                }
            }
        } else {
            Intent intent = new Intent(EarnMoney_82.this, RealMoney_81.class);
            intent.putExtra("is_from_home", true);
            EarnMoney_82.this.startActivity(intent);
        }

    }


    public void LuckySpinScreen() {
        if (earnmoney.isAdOn) {
            if (earnmoney.ad_mode.equalsIgnoreCase("admob")) {
                if (realmoney12.isInternetOn(EarnMoney_82.this)) {
                    realmoney12.getInstance().loadintertialads(EarnMoney_82.this, earnmoney.admob_inter_id, new realmoney12.MyCallback() {
                        @Override
                        public void callbackCall() {
                            startActivity(new Intent(EarnMoney_82.this, RealMoney_86.class));
                        }
                    });
                } else {
                    startActivity(new Intent(EarnMoney_82.this, RealMoney_86.class));
                }

            } else if (earnmoney.ad_mode.equalsIgnoreCase("qureka")) {

                realmoney14.getInstance().qureka_inter(EarnMoney_82.this, new realmoney14.MyCallback() {
                    @Override
                    public void callbackCall() {
                        startActivity(new Intent(EarnMoney_82.this, RealMoney_86.class));
                    }
                });

            } else {

                if (realmoney21.isInternetOn(EarnMoney_82.this)) {
                    realmoney21.getInstance().loadintertialads(EarnMoney_82.this, earnmoney.facebook_inter_id, new realmoney21.MyCallback() {
                        @Override
                        public void callbackCall() {
                            startActivity(new Intent(EarnMoney_82.this, RealMoney_86.class));
                        }
                    });
                } else {
                    startActivity(new Intent(EarnMoney_82.this, RealMoney_86.class));
                }
            }
        } else {
            startActivity(new Intent(EarnMoney_82.this, RealMoney_86.class));
        }

    }


    public void FlipCardScreen() {
        if (earnmoney.isAdOn) {
            if (earnmoney.ad_mode.equalsIgnoreCase("admob")) {
                if (realmoney12.isInternetOn(EarnMoney_82.this)) {
                    realmoney12.getInstance().loadintertialads(EarnMoney_82.this, earnmoney.admob_inter_id, new realmoney12.MyCallback() {
                        @Override
                        public void callbackCall() {
                            startActivity(new Intent(EarnMoney_82.this, EarnMoney_89.class));
                        }
                    });
                } else {
                    startActivity(new Intent(EarnMoney_82.this, EarnMoney_89.class));
                }

            } else if (earnmoney.ad_mode.equalsIgnoreCase("qureka")) {

                realmoney14.getInstance().qureka_inter(EarnMoney_82.this, new realmoney14.MyCallback() {
                    @Override
                    public void callbackCall() {
                        startActivity(new Intent(EarnMoney_82.this, EarnMoney_89.class));
                    }
                });

            } else {

                if (realmoney21.isInternetOn(EarnMoney_82.this)) {
                    realmoney21.getInstance().loadintertialads(EarnMoney_82.this, earnmoney.facebook_inter_id, new realmoney21.MyCallback() {
                        @Override
                        public void callbackCall() {
                            startActivity(new Intent(EarnMoney_82.this, EarnMoney_89.class));
                        }
                    });
                } else {
                    startActivity(new Intent(EarnMoney_82.this, EarnMoney_89.class));
                }
            }
        } else {
            startActivity(new Intent(EarnMoney_82.this, EarnMoney_89.class));
        }

    }


    public void DailyCheckScreen() {
        if (earnmoney.isAdOn) {
            if (earnmoney.ad_mode.equalsIgnoreCase("admob")) {
                if (realmoney12.isInternetOn(EarnMoney_82.this)) {
                    realmoney12.getInstance().loadintertialads(EarnMoney_82.this, earnmoney.admob_inter_id, new realmoney12.MyCallback() {
                        @Override
                        public void callbackCall() {
                            startActivity(new Intent(EarnMoney_82.this, EarnMoney_86.class));
                        }
                    });
                } else {
                    startActivity(new Intent(EarnMoney_82.this, EarnMoney_86.class));
                }

            } else if (earnmoney.ad_mode.equalsIgnoreCase("qureka")) {

                realmoney14.getInstance().qureka_inter(EarnMoney_82.this, new realmoney14.MyCallback() {
                    @Override
                    public void callbackCall() {
                        startActivity(new Intent(EarnMoney_82.this, EarnMoney_86.class));
                    }
                });

            } else {

                if (realmoney21.isInternetOn(EarnMoney_82.this)) {
                    realmoney21.getInstance().loadintertialads(EarnMoney_82.this, earnmoney.facebook_inter_id, new realmoney21.MyCallback() {
                        @Override
                        public void callbackCall() {
                            startActivity(new Intent(EarnMoney_82.this, EarnMoney_86.class));
                        }
                    });
                } else {
                    startActivity(new Intent(EarnMoney_82.this, EarnMoney_86.class));
                }
            }
        } else {
            startActivity(new Intent(EarnMoney_82.this, EarnMoney_86.class));
        }
    }


    public void ScratchCardScreen() {
        if (earnmoney.isAdOn) {
            if (earnmoney.ad_mode.equalsIgnoreCase("admob")) {
                if (realmoney12.isInternetOn(EarnMoney_82.this)) {
                    realmoney12.getInstance().loadintertialads(EarnMoney_82.this, earnmoney.admob_inter_id, new realmoney12.MyCallback() {
                        @Override
                        public void callbackCall() {
                            startActivity(new Intent(EarnMoney_82.this, ScratchCard.class));
                        }
                    });
                } else {
                    startActivity(new Intent(EarnMoney_82.this, ScratchCard.class));
                }

            } else if (earnmoney.ad_mode.equalsIgnoreCase("qureka")) {

                realmoney14.getInstance().qureka_inter(EarnMoney_82.this, new realmoney14.MyCallback() {
                    @Override
                    public void callbackCall() {
                        startActivity(new Intent(EarnMoney_82.this, ScratchCard.class));
                    }
                });

            } else {

                if (realmoney21.isInternetOn(EarnMoney_82.this)) {
                    realmoney21.getInstance().loadintertialads(EarnMoney_82.this, earnmoney.facebook_inter_id, new realmoney21.MyCallback() {
                        @Override
                        public void callbackCall() {
                            startActivity(new Intent(EarnMoney_82.this, ScratchCard.class));
                        }
                    });
                } else {
                    startActivity(new Intent(EarnMoney_82.this, ScratchCard.class));
                }
            }
        } else {
            startActivity(new Intent(EarnMoney_82.this, ScratchCard.class));
        }

    }


    public void SlotMachineScreen() {
        if (earnmoney.isAdOn) {
            if (earnmoney.ad_mode.equalsIgnoreCase("admob")) {
                if (realmoney12.isInternetOn(EarnMoney_82.this)) {
                    realmoney12.getInstance().loadintertialads(EarnMoney_82.this, earnmoney.admob_inter_id, new realmoney12.MyCallback() {
                        @Override
                        public void callbackCall() {
                            startActivity(new Intent(EarnMoney_82.this, SlotMachinegame.class));
                        }
                    });
                } else {
                    startActivity(new Intent(EarnMoney_82.this, SlotMachinegame.class));
                }

            } else if (earnmoney.ad_mode.equalsIgnoreCase("qureka")) {

                realmoney14.getInstance().qureka_inter(EarnMoney_82.this, new realmoney14.MyCallback() {
                    @Override
                    public void callbackCall() {
                        startActivity(new Intent(EarnMoney_82.this, SlotMachinegame.class));
                    }
                });

            } else {

                if (realmoney21.isInternetOn(EarnMoney_82.this)) {
                    realmoney21.getInstance().loadintertialads(EarnMoney_82.this, earnmoney.facebook_inter_id, new realmoney21.MyCallback() {
                        @Override
                        public void callbackCall() {
                            startActivity(new Intent(EarnMoney_82.this, SlotMachinegame.class));
                        }
                    });
                } else {
                    startActivity(new Intent(EarnMoney_82.this, SlotMachinegame.class));
                }
            }
        } else {
            startActivity(new Intent(EarnMoney_82.this, SlotMachinegame.class));
        }

    }


    public void WatchVideoScreeNew() {
        if (earnmoney.isAdOn) {
            if (earnmoney.ad_mode.equalsIgnoreCase("admob")) {
                if (realmoney12.isInternetOn(EarnMoney_82.this)) {
                    realmoney12.getInstance().loadintertialads(EarnMoney_82.this, earnmoney.admob_inter_id, new realmoney12.MyCallback() {
                        @Override
                        public void callbackCall() {
                            startActivity(new Intent(EarnMoney_82.this, WatchVideoEarnmoney.class));
                        }
                    });
                } else {
                    startActivity(new Intent(EarnMoney_82.this, WatchVideoEarnmoney.class));
                }

            } else if (earnmoney.ad_mode.equalsIgnoreCase("qureka")) {

                realmoney14.getInstance().qureka_inter(EarnMoney_82.this, new realmoney14.MyCallback() {
                    @Override
                    public void callbackCall() {
                        startActivity(new Intent(EarnMoney_82.this, WatchVideoEarnmoney.class));
                    }
                });

            } else {

                if (realmoney21.isInternetOn(EarnMoney_82.this)) {
                    realmoney21.getInstance().loadintertialads(EarnMoney_82.this, earnmoney.facebook_inter_id, new realmoney21.MyCallback() {
                        @Override
                        public void callbackCall() {
                            startActivity(new Intent(EarnMoney_82.this, WatchVideoEarnmoney.class));
                        }
                    });
                } else {
                    startActivity(new Intent(EarnMoney_82.this, WatchVideoEarnmoney.class));
                }
            }
        } else {
            startActivity(new Intent(EarnMoney_82.this, WatchVideoEarnmoney.class));
        }

    }


    public void ReferralCodeScreen() {
        if (earnmoney.isAdOn) {
            if (earnmoney.ad_mode.equalsIgnoreCase("admob")) {
                if (realmoney12.isInternetOn(EarnMoney_82.this)) {
                    realmoney12.getInstance().loadintertialads(EarnMoney_82.this, earnmoney.admob_inter_id, new realmoney12.MyCallback() {
                        @Override
                        public void callbackCall() {
                            startActivity(new Intent(EarnMoney_82.this, RealMoney_92.class));
                        }
                    });
                } else {
                    startActivity(new Intent(EarnMoney_82.this, RealMoney_92.class));
                }

            } else if (earnmoney.ad_mode.equalsIgnoreCase("qureka")) {

                realmoney14.getInstance().qureka_inter(EarnMoney_82.this, new realmoney14.MyCallback() {
                    @Override
                    public void callbackCall() {
                        startActivity(new Intent(EarnMoney_82.this, RealMoney_92.class));
                    }
                });

            } else {

                if (realmoney21.isInternetOn(EarnMoney_82.this)) {
                    realmoney21.getInstance().loadintertialads(EarnMoney_82.this, earnmoney.facebook_inter_id, new realmoney21.MyCallback() {
                        @Override
                        public void callbackCall() {
                            startActivity(new Intent(EarnMoney_82.this, RealMoney_92.class));
                        }
                    });
                } else {
                    startActivity(new Intent(EarnMoney_82.this, RealMoney_92.class));
                }
            }
        } else {
            startActivity(new Intent(EarnMoney_82.this, RealMoney_92.class));
        }
    }


    public void InviteScreen() {
        if (earnmoney.isAdOn) {
            if (earnmoney.ad_mode.equalsIgnoreCase("admob")) {
                if (realmoney12.isInternetOn(EarnMoney_82.this)) {
                    realmoney12.getInstance().loadintertialads(EarnMoney_82.this, earnmoney.admob_inter_id, new realmoney12.MyCallback() {
                        @Override
                        public void callbackCall() {
                            startActivity(new Intent(EarnMoney_82.this, RealMoney_83.class));
                        }
                    });
                } else {
                    startActivity(new Intent(EarnMoney_82.this, RealMoney_83.class));
                }

            } else if (earnmoney.ad_mode.equalsIgnoreCase("qureka")) {

                realmoney14.getInstance().qureka_inter(EarnMoney_82.this, new realmoney14.MyCallback() {
                    @Override
                    public void callbackCall() {
                        startActivity(new Intent(EarnMoney_82.this, RealMoney_83.class));
                    }
                });

            } else {

                if (realmoney21.isInternetOn(EarnMoney_82.this)) {
                    realmoney21.getInstance().loadintertialads(EarnMoney_82.this, earnmoney.facebook_inter_id, new realmoney21.MyCallback() {
                        @Override
                        public void callbackCall() {
                            startActivity(new Intent(EarnMoney_82.this, RealMoney_83.class));
                        }
                    });
                } else {
                    startActivity(new Intent(EarnMoney_82.this, RealMoney_83.class));
                }
            }
        } else {
            startActivity(new Intent(EarnMoney_82.this, RealMoney_83.class));
        }

    }


    @Override 
    public void onBackPressed() {
        startActivity(new Intent(EarnMoney_82.this, EarnMoney_85.class));
        this.from = 11;
    }


    private boolean checkAndRequestPermissions() {
        int checkSelfPermission = ContextCompat.checkSelfPermission(this, "android.permission.CAMERA");
        int checkSelfPermission2 = ContextCompat.checkSelfPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE");
        ArrayList arrayList = new ArrayList();
        if (checkSelfPermission2 != 0) {
            arrayList.add("android.permission.WRITE_EXTERNAL_STORAGE");
        }
        if (checkSelfPermission != 0) {
            arrayList.add("android.permission.CAMERA");
        }
        if (arrayList.isEmpty()) {
            return true;
        }
        ActivityCompat.requestPermissions(this, (String[]) arrayList.toArray(new String[arrayList.size()]), 4);
        return false;
    }


    @Override 
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == 4) {
            HashMap hashMap = new HashMap();
            hashMap.put("android.permission.CAMERA", 0);
            hashMap.put("android.permission.WRITE_EXTERNAL_STORAGE", 0);
            if (iArr.length > 0) {
                for (int i2 = 0; i2 < strArr.length; i2++) {
                    hashMap.put(strArr[i2], Integer.valueOf(iArr[i2]));
                }
                if (!(((Integer) hashMap.get("android.permission.CAMERA")).intValue() == 0 && ((Integer) hashMap.get("android.permission.WRITE_EXTERNAL_STORAGE")).intValue() == 0) && !ActivityCompat.shouldShowRequestPermissionRationale(this, "android.permission.CAMERA") && !ActivityCompat.shouldShowRequestPermissionRationale(this, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                    Toast.makeText(this, "Go to settings and enable permissions", 1).show();
                }
            }
        }
    }


    @Override 
    public void onResume() {
        TextView textView = this.atv_coin_value;
        textView.setText("" + this.myMoney.getPref(MyMoney.POINTS, 0));
        super.onResume();
        if (this.mCustomTabsOpened) {
            this.mCustomTabsOpened = false;
            finish();
        }
    }


    @Override 
    public void onDestroy() {
        Timer timer2 = this.y;
        if (timer2 != null) {
            timer2.cancel();
            this.y = null;
        }
        super.onDestroy();
    }


}
