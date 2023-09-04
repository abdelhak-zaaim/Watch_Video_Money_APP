package watchvideo.dailytrend.Earnmoney_2;

import static watchvideo.dailytrend.Earnmoney.earnmoney.quera_link;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.facebook.shimmer.ShimmerFrameLayout;
import com.makeramen.roundedimageview.RoundedImageView;

import watchvideo.dailytrend.Earnmoney.earnmoney;
import watchvideo.dailytrend.Earnmoney.realmoney;

import watchvideo.dailytrend.Earnmoney.realmoney14;
import watchvideo.dailytrend.Earnmoney.realmoney13;
import watchvideo.dailytrend.Earnmoney.realmoney12;
import watchvideo.dailytrend.Earnmoney.realmoney21;
import watchvideo.dailytrend.MyMoney;
import watchvideo.dailytrend.R;

public class RealMoney_88 extends AppCompatActivity {

    RelativeLayout about_us;
    TextView atv_coin_value;
    TextView atv_pytm_value;
    private ImageView earn_money;
    private ImageView history;
    MyMoney myMoney;
    RelativeLayout payout_service;
    RelativeLayout settings;
    RelativeLayout share_app;
    TextView tv_email;
    TextView tv_user_name;

    RelativeLayout adContainerView, adContainerPlaylist;
    ShimmerFrameLayout main_act_banner;

    @Override 
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(1024, 1024);
        setContentView(R.layout.realmoneywin);
        this.myMoney = new MyMoney(this);



        //Banner :-
        adContainerView = findViewById(R.id.adViewContainer);
        adContainerPlaylist = findViewById(R.id.adViewContainer);
        main_act_banner = findViewById(R.id.main_act_banner);


        if (earnmoney.isAdOn) {
            if (earnmoney.ad_mode.equalsIgnoreCase("admob")) {
                realmoney.creteadadaptiveBanner(RealMoney_88.this, adContainerPlaylist, earnmoney.admob_banner_id);
            } else if (earnmoney.ad_mode.equalsIgnoreCase("qureka")) {
                main_act_banner.setVisibility(View.VISIBLE);
            } else {
                adContainerView.setBackgroundResource(R.drawable.realmoney_140);
                realmoney13.createFBLoadBanner(RealMoney_88.this, adContainerPlaylist, earnmoney.facebook_banner_id);
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


        this.atv_coin_value = (TextView) findViewById(R.id.atv_coin_value);
        this.atv_pytm_value = (TextView) findViewById(R.id.atv_paytm_value);

        this.tv_user_name = (TextView) findViewById(R.id.user_name);
        this.tv_email = (TextView) findViewById(R.id.email_add);
        this.tv_user_name.setText(this.myMoney.getPref(MyMoney.USER_NAME, "0"));
        this.tv_email.setText(this.myMoney.getPref(MyMoney.EMAIL_ID, "0"));

        ((RoundedImageView) findViewById(R.id.edit_profile)).setOnClickListener(new View.OnClickListener() {
            @Override 
            public void onClick(View view) {
                startActivity(new Intent(RealMoney_88.this, EarnMoney_88.class));
            }
        });


        ImageView imageView2 = (ImageView) findViewById(R.id.img_earn);
        this.earn_money = imageView2;
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override 
            public void onClick(View view) {
                startActivity(new Intent(RealMoney_88.this, EarnMoney_82.class));
            }
        });


        ImageView imageView3 = (ImageView) findViewById(R.id.img_history);
        this.history = imageView3;
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override 
            public void onClick(View view) {
                startActivity(new Intent(RealMoney_88.this, RealMoney_82.class));
            }
        });


        RelativeLayout imageView4 = (RelativeLayout) findViewById(R.id.payout_service);
        this.payout_service = imageView4;
        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override 
            public void onClick(View view) {
                Intent intent = new Intent(RealMoney_88.this, RealMoney_89.class);
                intent.putExtra("is_from_home", true);
                startActivity(intent);
            }
        });


        RelativeLayout imageView5 = (RelativeLayout) findViewById(R.id.iv_setting);
        this.settings = imageView5;
        imageView5.setOnClickListener(new View.OnClickListener() {
            @Override 
            public void onClick(View view) {
                startActivity(new Intent(RealMoney_88.this, EarnMoney_88.class));
            }
        });


        RelativeLayout imageView6 = (RelativeLayout) findViewById(R.id.iv_share);
        this.share_app = imageView6;
        imageView6.setOnClickListener(new View.OnClickListener() {
            @Override 
            public void onClick(View view) {
                try {
                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    shareIntent.setType("text/plain");
                    shareIntent.putExtra(Intent.EXTRA_SUBJECT, "My application name");
                    String shareMessage = "\nLet me recommend you this application\n\n";
                    shareMessage = shareMessage + "https://play.google.com/store/apps/details?id=" + getPackageName() + "\n\n";
                    shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
                    startActivity(Intent.createChooser(shareIntent, "choose one"));
                } catch (Exception e) {

                }
            }
        });


        RelativeLayout imageView7 = (RelativeLayout) findViewById(R.id.iv_about_us);
        this.about_us = imageView7;
        imageView7.setOnClickListener(new View.OnClickListener() {
            @Override 
            public void onClick(View view) {
                startActivity(new Intent(RealMoney_88.this, EarnMoney_81.class));
            }
        });


    }


    @Override 
    public void onResume() {
        TextView textView = this.atv_coin_value;
        textView.setText("" + this.myMoney.getPref(MyMoney.POINTS, 0));
        this.tv_user_name.setText(this.myMoney.getPref(MyMoney.USER_NAME, "0"));
        this.tv_email.setText(this.myMoney.getPref(MyMoney.EMAIL_ID, "0"));
        this.earn_money.setImageResource(R.drawable.home_icon_black);
        this.history.setImageResource(R.drawable.history_icon);
        this.atv_pytm_value.setText(String.valueOf(Float.valueOf(Float.valueOf("" + this.myMoney.getPref(MyMoney.POINTS, 0)).floatValue() / 100.0f)));
        super.onResume();
    }



    @Override 
    public void onBackPressed() {
        if (earnmoney.isAdOn) {
            if (earnmoney.ad_mode.equalsIgnoreCase("admob")) {
                if (realmoney12.isInternetOn(RealMoney_88.this)) {
                    realmoney12.getInstance().loadintertialads(RealMoney_88.this, earnmoney.admob_inter_id, new realmoney12.MyCallback() {
                        @Override
                        public void callbackCall() {
                            startActivity(new Intent(RealMoney_88.this, EarnMoney_82.class));
                        }
                    });
                } else {
                    startActivity(new Intent(RealMoney_88.this, EarnMoney_82.class));
                }
            } else if (earnmoney.ad_mode.equalsIgnoreCase("qureka")) {

                realmoney14.getInstance().qureka_inter(RealMoney_88.this, new realmoney14.MyCallback() {
                    @Override
                    public void callbackCall() {
                        startActivity(new Intent(RealMoney_88.this, EarnMoney_82.class));
                    }
                });

            } else {

                if (realmoney21.isInternetOn(RealMoney_88.this)) {
                    realmoney21.getInstance().loadintertialads(RealMoney_88.this, earnmoney.facebook_inter_id, new realmoney21.MyCallback() {
                        @Override
                        public void callbackCall() {
                            startActivity(new Intent(RealMoney_88.this, EarnMoney_82.class));
                        }
                    });
                } else {
                    startActivity(new Intent(RealMoney_88.this, EarnMoney_82.class));
                }
            }

        } else {
            startActivity(new Intent(RealMoney_88.this, EarnMoney_82.class));
        }

     }


}
