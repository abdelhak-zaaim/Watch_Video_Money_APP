package watchvideo.dailytrend.Earnmoney_2;

import static watchvideo.dailytrend.Earnmoney.earnmoney.quera_link;
import static watchvideo.dailytrend.Earnmoney.earnmoney.qureka_visible;
import static watchvideo.dailytrend.Earnmoney.earnmoney.skip_page;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.facebook.ads.NativeAdLayout;
import com.facebook.shimmer.ShimmerFrameLayout;
import watchvideo.dailytrend.Earnmoney.earnmoney;
import watchvideo.dailytrend.Earnmoney.realmoney;

import watchvideo.dailytrend.Earnmoney.realmoney14;
import watchvideo.dailytrend.Earnmoney.realmoney13;
import watchvideo.dailytrend.Earnmoney.realmoney12;
import watchvideo.dailytrend.Earnmoney.realmoney21;
import watchvideo.dailytrend.R;


public class RealMoney_96 extends AppCompatActivity {

    ImageView btnYes, btnNo;
    LinearLayout lllll;
    ImageView pred_1;
    ImageView pred_2;
    ImageView pred_3;

    RelativeLayout hscrollContainer;
    FrameLayout admob_native;
    NativeAdLayout nativeAdLayout;
    ShimmerFrameLayout qureka_banner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.slotmachine);

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
            public void onClick(View view) {
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


        pred_1 = findViewById(R.id.pred_1);
        pred_2 = findViewById(R.id.pred_2);
        pred_3 = findViewById(R.id.pred_3);

        lllll = findViewById(R.id.lllll);

        if (qureka_visible){
            lllll.setVisibility(View.VISIBLE);
        }else {
            lllll.setVisibility(View.GONE);
        }

        pred_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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


        pred_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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


        pred_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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


        btnYes = (ImageView) findViewById(R.id.yes);
        btnNo = (ImageView) findViewById(R.id.no);

        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (earnmoney.isAdOn) {
                    if (earnmoney.ad_mode.equalsIgnoreCase("admob")) {
                        if (realmoney12.isInternetOn(RealMoney_96.this)) {
                            realmoney12.getInstance().loadintertialads(RealMoney_96.this, earnmoney.admob_inter_id, new realmoney12.MyCallback() {

                                @Override
                                public void callbackCall() {
                                    Intent intent = new Intent(RealMoney_96.this, EarnMoney_84.class);
                                    startActivity(intent);
                                }
                            });
                        } else {
                            Intent intent = new Intent(RealMoney_96.this, EarnMoney_84.class);
                            startActivity(intent);
                        }
                    } else if (earnmoney.ad_mode.equalsIgnoreCase("qureka")) {

                        realmoney14.getInstance().qureka_inter(RealMoney_96.this, new realmoney14.MyCallback() {
                            @Override
                            public void callbackCall() {
                                Intent intent = new Intent(RealMoney_96.this, EarnMoney_84.class);
                                startActivity(intent);
                            }
                        });

                    } else {
                        if (realmoney21.isInternetOn(RealMoney_96.this)) {
                            realmoney21.getInstance().loadintertialads(RealMoney_96.this, earnmoney.facebook_inter_id, new realmoney21.MyCallback() {
                                @Override
                                public void callbackCall() {
                                    Intent intent = new Intent(RealMoney_96.this, EarnMoney_84.class);
                                    startActivity(intent);
                                }
                            });
                        } else {
                            Intent intent = new Intent(RealMoney_96.this, EarnMoney_84.class);
                            startActivity(intent);
                        }
                    }
                } else {
                    Intent intent = new Intent(RealMoney_96.this, EarnMoney_84.class);
                    startActivity(intent);
                }

            }
        });


        btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (earnmoney.isAdOn) {
                    if (earnmoney.ad_mode.equalsIgnoreCase("admob")) {
                        if (realmoney12.isInternetOn(RealMoney_96.this)) {
                            realmoney12.getInstance().loadintertialads(RealMoney_96.this, earnmoney.admob_inter_id, new realmoney12.MyCallback() {
                                @Override
                                public void callbackCall() {
                                    if (skip_page){
                                        startActivity(new Intent(RealMoney_96.this, EarnMoney_83.class));
                                    }else{
                                        startActivity(new Intent(RealMoney_96.this, EarnMoney_85.class));
                                    }
                                }
                            });
                        } else {
                            if (skip_page){
                                startActivity(new Intent(RealMoney_96.this, EarnMoney_83.class));
                            }else{
                                startActivity(new Intent(RealMoney_96.this, EarnMoney_85.class));
                            }
                        }

                    } else if (earnmoney.ad_mode  .equalsIgnoreCase("qureka")) {

                        realmoney14.getInstance().qureka_inter(RealMoney_96.this, new realmoney14.MyCallback() {
                            @Override
                            public void callbackCall() {
                                if (skip_page){
                                    startActivity(new Intent(RealMoney_96.this, EarnMoney_83.class));
                                }else{
                                    startActivity(new Intent(RealMoney_96.this, EarnMoney_85.class));
                                }
                            }
                        });

                    } else {

                        if (realmoney21.isInternetOn(RealMoney_96.this)) {
                            realmoney21.getInstance().loadintertialads(RealMoney_96.this, earnmoney.facebook_inter_id, new realmoney21.MyCallback() {
                                @Override
                                public void callbackCall() {
                                    if (skip_page){
                                        startActivity(new Intent(RealMoney_96.this, EarnMoney_83.class));
                                    }else{
                                        startActivity(new Intent(RealMoney_96.this, EarnMoney_85.class));
                                    }
                                }
                            });
                        } else {
                            if (skip_page){
                                startActivity(new Intent(RealMoney_96.this, EarnMoney_83.class));
                            }else{
                                startActivity(new Intent(RealMoney_96.this, EarnMoney_85.class));
                            }
                        }
                    }

                } else {
                    if (skip_page){
                        startActivity(new Intent(RealMoney_96.this, EarnMoney_83.class));
                    }else{
                        startActivity(new Intent(RealMoney_96.this, EarnMoney_85.class));
                    }
                }

            }
        });


    }

    @Override
    public void onBackPressed() {
        if (earnmoney.isAdOn) {
            if (earnmoney.ad_mode.equalsIgnoreCase("admob")) {
                if (realmoney12.isInternetOn(RealMoney_96.this)) {
                    realmoney12.getInstance().loadintertialads(RealMoney_96.this, earnmoney.admob_inter_id, new realmoney12.MyCallback() {
                        @Override
                        public void callbackCall() {
                            if (skip_page){
                                startActivity(new Intent(RealMoney_96.this, EarnMoney_83.class));
                            }else{
                                startActivity(new Intent(RealMoney_96.this, EarnMoney_85.class));
                            }
                        }
                    });
                } else {
                    if (skip_page){
                        startActivity(new Intent(RealMoney_96.this, EarnMoney_83.class));
                    }else{
                        startActivity(new Intent(RealMoney_96.this, EarnMoney_85.class));
                    }
                }
            } else if (earnmoney.ad_mode.equalsIgnoreCase("qureka")) {

                realmoney14.getInstance().qureka_inter(RealMoney_96.this, new realmoney14.MyCallback() {
                    @Override
                    public void callbackCall() {
                        if (skip_page){
                            startActivity(new Intent(RealMoney_96.this, EarnMoney_83.class));
                        }else{
                            startActivity(new Intent(RealMoney_96.this, EarnMoney_85.class));
                        }
                    }
                });

            } else {
                if (realmoney21.isInternetOn(RealMoney_96.this)) {

                    realmoney21.getInstance().loadintertialads(RealMoney_96.this, earnmoney.facebook_inter_id, new realmoney21.MyCallback() {
                        @Override
                        public void callbackCall() {
                            if (skip_page){
                                startActivity(new Intent(RealMoney_96.this, EarnMoney_83.class));
                            }else{
                                startActivity(new Intent(RealMoney_96.this, EarnMoney_85.class));
                            }
                        }
                    });
                } else {
                    if (skip_page){
                        startActivity(new Intent(RealMoney_96.this, EarnMoney_83.class));
                    }else{
                        startActivity(new Intent(RealMoney_96.this, EarnMoney_85.class));
                    }
                }
            }

        } else {
            if (skip_page){
                startActivity(new Intent(RealMoney_96.this, EarnMoney_83.class));
            }else{
                startActivity(new Intent(RealMoney_96.this, EarnMoney_85.class));
            }
        }

    }

}
