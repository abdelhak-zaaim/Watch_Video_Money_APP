package watchvideo.dailytrend.Earnmoney_2;

import static watchvideo.dailytrend.Earnmoney.earnmoney.quera_link;
import static watchvideo.dailytrend.Earnmoney.earnmoney.qureka_visible;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.facebook.shimmer.ShimmerFrameLayout;
import watchvideo.dailytrend.Earnmoney.earnmoney;
import watchvideo.dailytrend.Earnmoney.realmoney;

import watchvideo.dailytrend.Earnmoney.realmoney14;
import watchvideo.dailytrend.Earnmoney.realmoney13;
import watchvideo.dailytrend.Earnmoney.realmoney12;
import watchvideo.dailytrend.Earnmoney.realmoney21;
import watchvideo.dailytrend.MyMoney;
import watchvideo.dailytrend.R;

public class RealMoney_86 extends AppCompatActivity {
    Animation animation;
    TextView atv_coin_value;
    private boolean mCustomTabsOpened = false;
    MyMoney myMoney;
    LinearLayout rl_daily_bonus;
    LinearLayout rl_gift;
    LinearLayout rl_scratch_card;
    LinearLayout rl_spinwin;

    LinearLayout tech_play,playquiz;

    RelativeLayout adContainerView, adContainerPlaylist;
    ShimmerFrameLayout main_act_banner;

    @Override 
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.realmoneya);
        getWindow().setFlags(1024, 1024);

        tech_play = findViewById(R.id.tech_play);
        playquiz = findViewById(R.id.playquiz);

        tech_play.setOnClickListener(new View.OnClickListener() {
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

        playquiz.setOnClickListener(new View.OnClickListener() {
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

        if (qureka_visible){
            tech_play.setVisibility(View.VISIBLE);
            playquiz.setVisibility(View.VISIBLE);

        }else{
            tech_play.setVisibility(View.GONE);
            playquiz.setVisibility(View.GONE);

        }

        ((ImageView) findViewById(R.id.ivback)).setOnClickListener(new View.OnClickListener() {
            @Override 
            public void onClick(View view) {
                if (earnmoney.isAdOn) {
                    if (earnmoney.ad_mode.equalsIgnoreCase("admob")) {
                        if (realmoney12.isInternetOn(RealMoney_86.this)) {
                            realmoney12.getInstance().loadintertialads(RealMoney_86.this, earnmoney.admob_inter_id, new realmoney12.MyCallback() {
                                @Override
                                public void callbackCall() {
                                    startActivity(new Intent(RealMoney_86.this, EarnMoney_82.class));
                                }
                            });
                        } else {
                            startActivity(new Intent(RealMoney_86.this, EarnMoney_82.class));
                        }
                    } else if (earnmoney.ad_mode.equalsIgnoreCase("qureka")) {

                        realmoney14.getInstance().qureka_inter(RealMoney_86.this, new realmoney14.MyCallback() {
                            @Override
                            public void callbackCall() {
                                startActivity(new Intent(RealMoney_86.this, EarnMoney_82.class));
                            }
                        });

                    } else {

                        if (realmoney21.isInternetOn(RealMoney_86.this)) {
                            realmoney21.getInstance().loadintertialads(RealMoney_86.this, earnmoney.facebook_inter_id, new realmoney21.MyCallback() {
                                @Override
                                public void callbackCall() {
                                    startActivity(new Intent(RealMoney_86.this, EarnMoney_82.class));
                                }
                            });
                        } else {
                            startActivity(new Intent(RealMoney_86.this, EarnMoney_82.class));
                        }
                    }

                } else {
                    startActivity(new Intent(RealMoney_86.this, EarnMoney_82.class));
                }
            }
        });


        //Banner :-
        adContainerView = findViewById(R.id.adViewContainer);
        adContainerPlaylist = findViewById(R.id.adViewContainer);
        main_act_banner = findViewById(R.id.main_act_banner);


        if (earnmoney.isAdOn) {
            if (earnmoney.ad_mode.equalsIgnoreCase("admob")) {
                realmoney.creteadadaptiveBanner(RealMoney_86.this, adContainerPlaylist, earnmoney.admob_banner_id);
            } else if (earnmoney.ad_mode.equalsIgnoreCase("qureka")) {
                main_act_banner.setVisibility(View.VISIBLE);
            } else {
                adContainerView.setBackgroundResource(R.drawable.realmoney_140);
                realmoney13.createFBLoadBanner(RealMoney_86.this, adContainerPlaylist, earnmoney.facebook_banner_id);
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


        this.atv_coin_value = (TextView) findViewById(R.id.atv_coin_value);
        this.myMoney = new MyMoney(this);
        this.animation = AnimationUtils.loadAnimation(this, R.anim.moneyapp);
        this.rl_gift = (LinearLayout) findViewById(R.id.rl_gift);
        this.rl_scratch_card = (LinearLayout) findViewById(R.id.rl_scratch_card);
        this.rl_daily_bonus = (LinearLayout) findViewById(R.id.rl_daily_bonus);
        this.rl_spinwin = (LinearLayout) findViewById(R.id.rl_spinwin);


        this.rl_gift.setOnClickListener(new View.OnClickListener() {
            @Override 
            public void onClick(View view) {
                view.startAnimation(RealMoney_86.this.animation);

                if (earnmoney.isAdOn) {
                    if (earnmoney.ad_mode.equalsIgnoreCase("admob")) {
                        if (realmoney12.isInternetOn(RealMoney_86.this)) {
                            realmoney12.getInstance().loadintertialads(RealMoney_86.this, earnmoney.admob_inter_id, new realmoney12.MyCallback() {
                                @Override
                                public void callbackCall() {
                                    Intent intent = new Intent(RealMoney_86.this, RealMoney_89.class);
                                    intent.putExtra("is_from_home", true);
                                    RealMoney_86.this.startActivity(intent);
                                }
                            });
                        } else {
                            Intent intent = new Intent(RealMoney_86.this, RealMoney_89.class);
                            intent.putExtra("is_from_home", true);
                            RealMoney_86.this.startActivity(intent);
                        }

                    } else if (earnmoney.ad_mode.equalsIgnoreCase("qureka")) {

                        realmoney14.getInstance().qureka_inter(RealMoney_86.this, new realmoney14.MyCallback() {
                            @Override
                            public void callbackCall() {
                                Intent intent = new Intent(RealMoney_86.this, RealMoney_89.class);
                                intent.putExtra("is_from_home", true);
                                RealMoney_86.this.startActivity(intent);
                            }
                        });

                    } else {

                        if (realmoney21.isInternetOn(RealMoney_86.this)) {
                            realmoney21.getInstance().loadintertialads(RealMoney_86.this, earnmoney.facebook_inter_id, new realmoney21.MyCallback() {
                                @Override
                                public void callbackCall() {
                                    Intent intent = new Intent(RealMoney_86.this, RealMoney_89.class);
                                    intent.putExtra("is_from_home", true);
                                    RealMoney_86.this.startActivity(intent);
                                }
                            });
                        } else {
                            Intent intent = new Intent(RealMoney_86.this, RealMoney_89.class);
                            intent.putExtra("is_from_home", true);
                            RealMoney_86.this.startActivity(intent);
                        }
                    }
                } else {
                    Intent intent = new Intent(RealMoney_86.this, RealMoney_89.class);
                    intent.putExtra("is_from_home", true);
                    RealMoney_86.this.startActivity(intent);
                }

            }
        });


        this.rl_spinwin.setOnClickListener(new View.OnClickListener() {
            @Override 
            public void onClick(View view) {
                view.startAnimation(RealMoney_86.this.animation);
                if (earnmoney.isAdOn) {
                    if (earnmoney.ad_mode.equalsIgnoreCase("admob")) {
                        if (realmoney12.isInternetOn(RealMoney_86.this)) {
                            realmoney12.getInstance().loadintertialads(RealMoney_86.this, earnmoney.admob_inter_id, new realmoney12.MyCallback() {
                                @Override
                                public void callbackCall() {
                                    startActivity(new Intent(RealMoney_86.this, RealMoney_85.class));
                                }
                            });
                        } else {
                            startActivity(new Intent(RealMoney_86.this, RealMoney_85.class));
                        }

                    } else if (earnmoney.ad_mode.equalsIgnoreCase("qureka")) {

                        realmoney14.getInstance().qureka_inter(RealMoney_86.this, new realmoney14.MyCallback() {
                            @Override
                            public void callbackCall() {
                                startActivity(new Intent(RealMoney_86.this, RealMoney_85.class));
                            }
                        });

                    } else {

                        if (realmoney21.isInternetOn(RealMoney_86.this)) {
                            realmoney21.getInstance().loadintertialads(RealMoney_86.this, earnmoney.facebook_inter_id, new realmoney21.MyCallback() {
                                @Override
                                public void callbackCall() {
                                    startActivity(new Intent(RealMoney_86.this, RealMoney_85.class));
                                }
                            });
                        } else {
                            startActivity(new Intent(RealMoney_86.this, RealMoney_85.class));
                        }
                    }
                } else {
                    startActivity(new Intent(RealMoney_86.this, RealMoney_85.class));
                }

            }
        });


        this.rl_scratch_card.setOnClickListener(new View.OnClickListener() {
            @Override 
            public void onClick(View view) {
                view.startAnimation(RealMoney_86.this.animation);
                if (earnmoney.isAdOn) {
                    if (earnmoney.ad_mode.equalsIgnoreCase("admob")) {
                        if (realmoney12.isInternetOn(RealMoney_86.this)) {
                            realmoney12.getInstance().loadintertialads(RealMoney_86.this, earnmoney.admob_inter_id, new realmoney12.MyCallback() {
                                @Override
                                public void callbackCall() {
                                    startActivity(new Intent(RealMoney_86.this, ScratchCard.class));
                                }
                            });
                        } else {
                            startActivity(new Intent(RealMoney_86.this, ScratchCard.class));
                        }

                    } else if (earnmoney.ad_mode.equalsIgnoreCase("qureka")) {

                        realmoney14.getInstance().qureka_inter(RealMoney_86.this, new realmoney14.MyCallback() {
                            @Override
                            public void callbackCall() {
                                startActivity(new Intent(RealMoney_86.this, ScratchCard.class));
                            }
                        });

                    } else {

                        if (realmoney21.isInternetOn(RealMoney_86.this)) {
                            realmoney21.getInstance().loadintertialads(RealMoney_86.this, earnmoney.facebook_inter_id, new realmoney21.MyCallback() {
                                @Override
                                public void callbackCall() {
                                    startActivity(new Intent(RealMoney_86.this, ScratchCard.class));
                                }
                            });
                        } else {
                            startActivity(new Intent(RealMoney_86.this, ScratchCard.class));
                        }
                    }
                } else {
                    startActivity(new Intent(RealMoney_86.this, ScratchCard.class));
                }

            }
        });


        this.rl_daily_bonus.setOnClickListener(new View.OnClickListener() {
            @Override 
            public void onClick(View view) {
                view.startAnimation(RealMoney_86.this.animation);
                if (earnmoney.isAdOn) {
                    if (earnmoney.ad_mode.equalsIgnoreCase("admob")) {
                        if (realmoney12.isInternetOn(RealMoney_86.this)) {
                            realmoney12.getInstance().loadintertialads(RealMoney_86.this, earnmoney.admob_inter_id, new realmoney12.MyCallback() {
                                @Override
                                public void callbackCall() {
                                    startActivity(new Intent(RealMoney_86.this, EarnMoney_86.class));
                                }
                            });
                        } else {
                            startActivity(new Intent(RealMoney_86.this, EarnMoney_86.class));
                        }

                    } else if (earnmoney.ad_mode.equalsIgnoreCase("qureka")) {

                        realmoney14.getInstance().qureka_inter(RealMoney_86.this, new realmoney14.MyCallback() {
                            @Override
                            public void callbackCall() {
                                startActivity(new Intent(RealMoney_86.this, EarnMoney_86.class));
                            }
                        });

                    } else {

                        if (realmoney21.isInternetOn(RealMoney_86.this)) {
                            realmoney21.getInstance().loadintertialads(RealMoney_86.this, earnmoney.facebook_inter_id, new realmoney21.MyCallback() {
                                @Override
                                public void callbackCall() {
                                    startActivity(new Intent(RealMoney_86.this, EarnMoney_86.class));
                                }
                            });
                        } else {
                            startActivity(new Intent(RealMoney_86.this, EarnMoney_86.class));
                        }
                    }
                } else {
                    startActivity(new Intent(RealMoney_86.this, EarnMoney_86.class));
                }

            }
        });

        
    }

    @Override 
    public void onResume() {
        super.onResume();
        if (this.mCustomTabsOpened) {
            this.mCustomTabsOpened = false;
            finish();
        }
        try {
            TextView textView = this.atv_coin_value;
            textView.setText("" + this.myMoney.getPref(MyMoney.POINTS, 0));
        } catch (IllegalStateException unused) {

        }

    }

    @Override 
    public void onBackPressed() {
        if (earnmoney.isAdOn) {
            if (earnmoney.ad_mode.equalsIgnoreCase("admob")) {
                if (realmoney12.isInternetOn(RealMoney_86.this)) {
                    realmoney12.getInstance().loadintertialads(RealMoney_86.this, earnmoney.admob_inter_id, new realmoney12.MyCallback() {
                        @Override
                        public void callbackCall() {
                            startActivity(new Intent(RealMoney_86.this, EarnMoney_82.class));
                        }
                    });
                } else {
                    startActivity(new Intent(RealMoney_86.this, EarnMoney_82.class));
                }

            } else if (earnmoney.ad_mode.equalsIgnoreCase("qureka")) {

                realmoney14.getInstance().qureka_inter(RealMoney_86.this, new realmoney14.MyCallback() {
                    @Override
                    public void callbackCall() {
                        startActivity(new Intent(RealMoney_86.this, EarnMoney_82.class));
                    }
                });

            } else {

                if (realmoney21.isInternetOn(RealMoney_86.this)) {
                    realmoney21.getInstance().loadintertialads(RealMoney_86.this, earnmoney.facebook_inter_id, new realmoney21.MyCallback() {
                        @Override
                        public void callbackCall() {
                            startActivity(new Intent(RealMoney_86.this, EarnMoney_82.class));
                        }
                    });
                } else {
                    startActivity(new Intent(RealMoney_86.this, EarnMoney_82.class));
                }
            }

        } else {

            startActivity(new Intent(RealMoney_86.this, EarnMoney_82.class));
        }
    }

}
