package watchvideo.dailytrend.Earnmoney_2;

import static watchvideo.dailytrend.Earnmoney.earnmoney.quera_link;
import static watchvideo.dailytrend.Earnmoney.earnmoney.qureka_visible;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import watchvideo.dailytrend.Earnmoney.earnmoney;

import watchvideo.dailytrend.Earnmoney.realmoney14;
import watchvideo.dailytrend.Earnmoney.realmoney12;
import watchvideo.dailytrend.Earnmoney.realmoney21;
import watchvideo.dailytrend.MyMoney;
import watchvideo.dailytrend.R;

public class RealMoney_82 extends AppCompatActivity {
    ImageView earn_money;
    private TextView flip_count;
    private Intent intent;
    MyMoney myMoney;
    ImageView profile;
    TextView scratch_count;
    TextView slot_count;
    private TextView spin_count;

    RelativeLayout gif_qureka;


    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(1024, 1024);
        setContentView(R.layout.moneyrealmoney);
        this.myMoney = new MyMoney(this);

        ((ImageView) findViewById(R.id.ivback)).setOnClickListener(new View.OnClickListener() {
            @Override 
            public void onClick(View view) {
                if (earnmoney.isAdOn) {
                    if (earnmoney.ad_mode.equalsIgnoreCase("admob")) {
                        if (realmoney12.isInternetOn(RealMoney_82.this)) {
                            realmoney12.getInstance().loadintertialads(RealMoney_82.this, earnmoney.admob_inter_id, new realmoney12.MyCallback() {
                                @Override
                                public void callbackCall() {
                                    startActivity(new Intent(RealMoney_82.this, EarnMoney_82.class));
                                }
                            });
                        } else {
                            startActivity(new Intent(RealMoney_82.this, EarnMoney_82.class));
                        }
                    } else if (earnmoney.ad_mode.equalsIgnoreCase("qureka")) {

                        realmoney14.getInstance().qureka_inter(RealMoney_82.this, new realmoney14.MyCallback() {
                            @Override
                            public void callbackCall() {
                                startActivity(new Intent(RealMoney_82.this, EarnMoney_82.class));
                            }
                        });

                    } else {

                        if (realmoney21.isInternetOn(RealMoney_82.this)) {
                            realmoney21.getInstance().loadintertialads(RealMoney_82.this, earnmoney.facebook_inter_id, new realmoney21.MyCallback() {
                                @Override
                                public void callbackCall() {
                                    startActivity(new Intent(RealMoney_82.this, EarnMoney_82.class));
                                }
                            });
                        } else {
                            startActivity(new Intent(RealMoney_82.this, EarnMoney_82.class));
                        }
                    }

                } else {
                    startActivity(new Intent(RealMoney_82.this, EarnMoney_82.class));
                }
            }
        });

        gif_qureka = findViewById(R.id.qureka_gif);

        gif_qureka.setOnClickListener(new View.OnClickListener() {
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


        if (qureka_visible){
            gif_qureka.setVisibility(View.VISIBLE);
        }else{
            gif_qureka.setVisibility(View.GONE);
        }


        ImageView imageView2 = (ImageView) findViewById(R.id.img_earn);
        this.earn_money = imageView2;
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override 
            public void onClick(View view) {
                startActivity(new Intent(RealMoney_82.this, EarnMoney_82.class));
            }
        });


        ImageView imageView3 = (ImageView) findViewById(R.id.img_profile);
        this.profile = imageView3;
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override 
            public void onClick(View view) {
                startActivity(new Intent(RealMoney_82.this, RealMoney_88.class));
            }
        });

        this.scratch_count = (TextView) findViewById(R.id.tv_scratch_count);
        this.scratch_count.setText(String.valueOf(this.myMoney.getPref(MyMoney.SCRATCH_COUNT, 0)));
        this.slot_count = (TextView) findViewById(R.id.tv_slot_count);
        this.slot_count.setText(String.valueOf(this.myMoney.getPref(MyMoney.SLOT_COUNT, 0)));
        this.spin_count = (TextView) findViewById(R.id.tv_spin_count);
        this.spin_count.setText(String.valueOf(this.myMoney.getPref(MyMoney.SPIN_COUNT, 0)));
        this.flip_count = (TextView) findViewById(R.id.tv_flip_count);
        this.flip_count.setText(String.valueOf(this.myMoney.getPref(MyMoney.FLIP_COUNT, 0)));

    }


    @Override
    public void onResume() {
        super.onResume();
        this.earn_money.setImageResource(R.drawable.home_icon_black);
        this.profile.setImageResource(R.drawable.profile_icon);
    }


    @Override 
    public void onBackPressed() {
        if (earnmoney.isAdOn) {
            if (earnmoney.ad_mode.equalsIgnoreCase("admob")) {
                if (realmoney12.isInternetOn(RealMoney_82.this)) {
                    realmoney12.getInstance().loadintertialads(RealMoney_82.this, earnmoney.admob_inter_id, new realmoney12.MyCallback() {
                        @Override
                        public void callbackCall() {
                            startActivity(new Intent(RealMoney_82.this, EarnMoney_82.class));
                        }
                    });
                } else {
                    startActivity(new Intent(RealMoney_82.this, EarnMoney_82.class));
                }
            } else if (earnmoney.ad_mode.equalsIgnoreCase("qureka")) {

                realmoney14.getInstance().qureka_inter(RealMoney_82.this, new realmoney14.MyCallback() {
                    @Override
                    public void callbackCall() {
                        startActivity(new Intent(RealMoney_82.this, EarnMoney_82.class));
                    }
                });

            } else {

                if (realmoney21.isInternetOn(RealMoney_82.this)) {
                    realmoney21.getInstance().loadintertialads(RealMoney_82.this, earnmoney.facebook_inter_id, new realmoney21.MyCallback() {
                        @Override
                        public void callbackCall() {
                            startActivity(new Intent(RealMoney_82.this, EarnMoney_82.class));
                        }
                    });
                } else {
                    startActivity(new Intent(RealMoney_82.this, EarnMoney_82.class));
                }
            }

        } else {
            startActivity(new Intent(RealMoney_82.this, EarnMoney_82.class));
        }

    }

}
