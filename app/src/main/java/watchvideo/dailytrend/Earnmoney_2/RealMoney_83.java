package watchvideo.dailytrend.Earnmoney_2;

import static watchvideo.dailytrend.Earnmoney.earnmoney.quera_link;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.facebook.ads.NativeAdLayout;
import com.facebook.shimmer.ShimmerFrameLayout;
import watchvideo.dailytrend.Earnmoney.earnmoney;
import watchvideo.dailytrend.Earnmoney.realmoney;

import watchvideo.dailytrend.Earnmoney.realmoney14;
import watchvideo.dailytrend.Earnmoney.realmoney13;
import watchvideo.dailytrend.Earnmoney.realmoney12;
import watchvideo.dailytrend.Earnmoney.realmoney21;
import watchvideo.dailytrend.realmoney_24;
import watchvideo.dailytrend.earnmoney_21;
import watchvideo.dailytrend.MyMoney;
import watchvideo.dailytrend.R;

public class RealMoney_83 extends AppCompatActivity implements View.OnClickListener {
    Animation animation;
    TextView atv_coin_value;
    TextView atv_referral_code;
    Button btn_invite_friends;
    TextView iv_copy;
    private boolean mCustomTabsOpened = false;
    MyMoney myMoney;

    RelativeLayout hscrollContainer;
    FrameLayout admob_native;
    NativeAdLayout nativeAdLayout;
    ShimmerFrameLayout qureka_banner;

    @Override 
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.spinandwinspinandwin);
        getWindow().setFlags(1024, 1024);
        this.myMoney = new MyMoney(this);

        ((ImageView) findViewById(R.id.ivback)).setOnClickListener(new View.OnClickListener() {
            @Override 
            public void onClick(View view) {
                if (earnmoney.isAdOn) {
                    if (earnmoney.ad_mode.equalsIgnoreCase("admob")) {
                        if (realmoney12.isInternetOn(RealMoney_83.this)) {
                            realmoney12.getInstance().loadintertialads(RealMoney_83.this, earnmoney.admob_inter_id, new realmoney12.MyCallback() {
                                @Override
                                public void callbackCall() {
                                    startActivity(new Intent(RealMoney_83.this, EarnMoney_82.class));
                                }
                            });
                        } else {
                            startActivity(new Intent(RealMoney_83.this, EarnMoney_82.class));
                        }
                    } else if (earnmoney.ad_mode.equalsIgnoreCase("qureka")) {

                        realmoney14.getInstance().qureka_inter(RealMoney_83.this, new realmoney14.MyCallback() {
                            @Override
                            public void callbackCall() {
                                startActivity(new Intent(RealMoney_83.this, EarnMoney_82.class));
                            }
                        });

                    } else {

                        if (realmoney21.isInternetOn(RealMoney_83.this)) {
                            realmoney21.getInstance().loadintertialads(RealMoney_83.this, earnmoney.facebook_inter_id, new realmoney21.MyCallback() {
                                @Override
                                public void callbackCall() {
                                    startActivity(new Intent(RealMoney_83.this, EarnMoney_82.class));
                                }
                            });
                        } else {
                            startActivity(new Intent(RealMoney_83.this, EarnMoney_82.class));
                        }
                    }

                } else {
                    startActivity(new Intent(RealMoney_83.this, EarnMoney_82.class));
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
                realmoney.Admobnative1(RealMoney_83.this, admob_native, earnmoney.admob_native_id);
            } else if (earnmoney.ad_mode.equalsIgnoreCase("qureka")) {
                qureka_banner.setVisibility(View.VISIBLE);
            } else {
                hscrollContainer.setBackgroundResource(R.drawable.realmoney_140);
                realmoney13.loadNativeAd(RealMoney_83.this, nativeAdLayout, earnmoney.facebook_native_id);
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


        this.atv_coin_value = (TextView) findViewById(R.id.atv_coin_value);
        TextView textView = (TextView) findViewById(R.id.iv_copy);
        this.iv_copy = textView;
        textView.setOnClickListener(this);
        this.atv_referral_code = (TextView) findViewById(R.id.atv_referral_code);
        this.animation = AnimationUtils.loadAnimation(this, R.anim.moneyapp);
        Button imageView = (Button) findViewById(R.id.btn_invite_friends);
        this.btn_invite_friends = imageView;
        imageView.setOnClickListener(this);


    }

    @Override 
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_invite_friends) {
            ShareApp();
        } else if (id == R.id.iv_copy) {
            ((ClipboardManager) getSystemService(CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("Copied Text", this.atv_referral_code.getText().toString()));
            realmoney_24.ShowSuccessToast(this, "Copied Successfully!!.");
        }
    }

    public void ShareApp() {
        try {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("text/plain");
            intent.putExtra("android.intent.extra.TEXT", "Earn Real Money 100% Real With This Awesome Application \nEnter Referral Code : MYPROMOCARD \nAnd Get 500 Coin & Real Cash Money In Your Wallet\n" + getResources().getString(R.string.app_name) + " :\n" + earnmoney_21.rate_url + getPackageName());
            startActivity(Intent.createChooser(intent, "Share via"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override 
    public void onBackPressed() {
        if (earnmoney.isAdOn) {
            if (earnmoney.ad_mode.equalsIgnoreCase("admob")) {
                if (realmoney12.isInternetOn(RealMoney_83.this)) {
                    realmoney12.getInstance().loadintertialads(RealMoney_83.this, earnmoney.admob_inter_id, new realmoney12.MyCallback() {
                        @Override
                        public void callbackCall() {
                            startActivity(new Intent(RealMoney_83.this, EarnMoney_82.class));
                        }
                    });
                } else {
                    startActivity(new Intent(RealMoney_83.this, EarnMoney_82.class));
                }
            } else if (earnmoney.ad_mode.equalsIgnoreCase("qureka")) {

                realmoney14.getInstance().qureka_inter(RealMoney_83.this, new realmoney14.MyCallback() {
                    @Override
                    public void callbackCall() {
                        startActivity(new Intent(RealMoney_83.this, EarnMoney_82.class));
                    }
                });

            } else {

                if (realmoney21.isInternetOn(RealMoney_83.this)) {
                    realmoney21.getInstance().loadintertialads(RealMoney_83.this, earnmoney.facebook_inter_id, new realmoney21.MyCallback() {
                        @Override
                        public void callbackCall() {
                            startActivity(new Intent(RealMoney_83.this, EarnMoney_82.class));
                        }
                    });
                } else {
                    startActivity(new Intent(RealMoney_83.this, EarnMoney_82.class));
                }
            }

        } else {
            startActivity(new Intent(RealMoney_83.this, EarnMoney_82.class));
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
        super.onDestroy();
    }


}
