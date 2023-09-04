package watchvideo.dailytrend.Earnmoney_2;

import static watchvideo.dailytrend.Earnmoney.earnmoney.quera_link;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
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
import watchvideo.dailytrend.MyMoney;
import watchvideo.dailytrend.realmoney_24;
import watchvideo.dailytrend.R;

public class RealMoney_92 extends AppCompatActivity implements View.OnClickListener {

    Animation animation;
    TextView atv_coin_value;
    TextView atv_referral_code;
    Button btn_reedem_now;
    public Dialog conform_dialog;
    public Dialog email_dialog;
    private boolean mCustomTabsOpened = false;
    MyMoney myMoney;
    String result = "500";

    RelativeLayout hscrollContainer;
    FrameLayout admob_native;
    NativeAdLayout nativeAdLayout;
    ShimmerFrameLayout qureka_banner;

    @Override 
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.earnmoneyappearnmoneygame);
        getWindow().setFlags(1024, 1024);
        this.myMoney = new MyMoney(this);

        ((ImageView) findViewById(R.id.ivback)).setOnClickListener(new View.OnClickListener() {
            @Override 
            public void onClick(View view) {
                if (earnmoney.isAdOn) {
                    if (earnmoney.ad_mode.equalsIgnoreCase("admob")) {
                        if (realmoney12.isInternetOn(RealMoney_92.this)) {
                            realmoney12.getInstance().loadintertialads(RealMoney_92.this, earnmoney.admob_inter_id, new realmoney12.MyCallback() {
                                @Override
                                public void callbackCall() {
                                    startActivity(new Intent(RealMoney_92.this, EarnMoney_82.class));
                                }
                            });
                        } else {
                            startActivity(new Intent(RealMoney_92.this, EarnMoney_82.class));
                        }
                    } else if (earnmoney.ad_mode.equalsIgnoreCase("qureka")) {

                        realmoney14.getInstance().qureka_inter(RealMoney_92.this, new realmoney14.MyCallback() {
                            @Override
                            public void callbackCall() {
                                startActivity(new Intent(RealMoney_92.this, EarnMoney_82.class));
                            }
                        });

                    } else {

                        if (realmoney21.isInternetOn(RealMoney_92.this)) {
                            realmoney21.getInstance().loadintertialads(RealMoney_92.this, earnmoney.facebook_inter_id, new realmoney21.MyCallback() {
                                @Override
                                public void callbackCall() {
                                    startActivity(new Intent(RealMoney_92.this, EarnMoney_82.class));
                                }
                            });
                        } else {
                            startActivity(new Intent(RealMoney_92.this, EarnMoney_82.class));
                        }
                    }

                } else {
                    startActivity(new Intent(RealMoney_92.this, EarnMoney_82.class));
                }
            }
        });


        TextView textView = (TextView) findViewById(R.id.atv_referral_code);
        this.atv_referral_code = textView;
        textView.setOnClickListener(this);
        Button imageView = (Button) findViewById(R.id.btn_reedem_now);
        this.btn_reedem_now = imageView;
        imageView.setOnClickListener(this);
        this.atv_coin_value = (TextView) findViewById(R.id.atv_coin_value);
        this.animation = AnimationUtils.loadAnimation(this, R.anim.moneyapp);


        /// Native Ads :-
        hscrollContainer = findViewById(R.id.hscrollContainer);
        admob_native = findViewById(R.id.admob_native);
        nativeAdLayout = findViewById(R.id.fb_native);
        qureka_banner = findViewById(R.id.qureka_banner);


        if (earnmoney.isAdOn) {
            if (earnmoney.ad_mode.equalsIgnoreCase("admob")) {
                realmoney.Admobnative1(RealMoney_92.this, admob_native, earnmoney.admob_native_id);
            } else if (earnmoney.ad_mode.equalsIgnoreCase("qureka")) {
                qureka_banner.setVisibility(View.VISIBLE);
            } else {
                hscrollContainer.setBackgroundResource(R.drawable.realmoney_140);
                realmoney13.loadNativeAd(RealMoney_92.this, nativeAdLayout, earnmoney.facebook_native_id);
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

    }


    @Override 
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.atv_referral_code) {
            ShowDialog();
        } else if (id == R.id.btn_reedem_now) {
            if (this.atv_referral_code.getText().toString().isEmpty()) {
                realmoney_24.ShowErrorToast(this, "Please Enter Referral Code.");
            } else if (!this.myMoney.getPref(MyMoney.REFERRAL_ALREADY_USE, false)) {
                Win_ShowDialog();
            } else {
                Sorry_ShowDialog();
            }
        }
    }


    private void ShowDialog() {
        Dialog dialog = new Dialog(this, R.style.TransparentBackground);
        this.email_dialog = dialog;
        dialog.setContentView(R.layout.gamemoneyapp);
        TextView textView = (TextView) this.email_dialog.findViewById(R.id.btn_ok);
        TextView textView2 = (TextView) this.email_dialog.findViewById(R.id.btn_cancel);
        ((TextView) this.email_dialog.findViewById(R.id.atv_note)).setText("Note : Enter Uppercase & Number");
        final EditText editText = (EditText) this.email_dialog.findViewById(R.id.et_enter_email);
        editText.setHint("Enter Referral Code");
        if (!editText.getText().toString().isEmpty()) {
            editText.setText(editText.getText().toString());
        }

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editText.getText().toString().equals(RealMoney_92.this.myMoney.getPref(MyMoney.REFERRAL_CODE, ""))) {
                    RealMoney_92.this.atv_referral_code.setText(editText.getText().toString());
                    RealMoney_92.this.email_dialog.dismiss();
                    return;
                }
                realmoney_24.ShowErrorToast(RealMoney_92.this, "Please Enter Correct Referral Code.");
            }
        });

        textView2.setOnClickListener(new View.OnClickListener() {
            @Override 
            public void onClick(View view) {
                RealMoney_92.this.email_dialog.dismiss();
            }
        });
        this.email_dialog.show();
    }

    private void Win_ShowDialog() {
        ((TextView) this.conform_dialog.findViewById(R.id.atv_point_value)).setText(this.result + " Points Added Successfully.");
        ((ImageView) this.conform_dialog.findViewById(R.id.btn_get_points)).setOnClickListener(new View.OnClickListener() {
            @Override 
            public void onClick(View view) {
                RealMoney_92.this.conform_dialog.dismiss();
                if (!realmoney_24.isOnline(RealMoney_92.this)) {
                    realmoney_24.NoInternetDialog(RealMoney_92.this);
                }
                RealMoney_92.this.myMoney.setPref(MyMoney.POINTS, RealMoney_92.this.myMoney.getPref(MyMoney.POINTS, 0).intValue() + Integer.parseInt(RealMoney_92.this.result));
                TextView textView = RealMoney_92.this.atv_coin_value;
                textView.setText("" + RealMoney_92.this.myMoney.getPref(MyMoney.POINTS, 0));
                RealMoney_92.this.myMoney.setPref(MyMoney.REFERRAL_ALREADY_USE, true);
            }
        });
        this.conform_dialog.show();
    }

    private void Sorry_ShowDialog() {
        ((TextView) this.conform_dialog.findViewById(R.id.btn_ok)).setOnClickListener(new View.OnClickListener() {
            @Override 
            public void onClick(View view) {
                RealMoney_92.this.conform_dialog.dismiss();
            }
        });
        this.conform_dialog.show();
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
        if (!this.myMoney.getPref(MyMoney.REFERRAL_ALREADY_USE, false)) {
            Dialog dialog = new Dialog(this, R.style.creativeDialogTheme);
            this.conform_dialog = dialog;
            dialog.setContentView(R.layout.earnmoneywatchvideo);
            this.conform_dialog.setCancelable(false);
            return;
        }
        Dialog dialog2 = new Dialog(this, R.style.creativeDialogTheme);
        this.conform_dialog = dialog2;
        dialog2.setContentView(R.layout.watchvideomoney);
        this.conform_dialog.setCancelable(false);
    }

    @Override 
    public void onDestroy() {
        super.onDestroy();
    }

    @Override 
    public void onBackPressed() {
        if (earnmoney.isAdOn) {
            if (earnmoney.ad_mode.equalsIgnoreCase("admob")) {
                if (realmoney12.isInternetOn(RealMoney_92.this)) {
                    realmoney12.getInstance().loadintertialads(RealMoney_92.this, earnmoney.admob_inter_id, new realmoney12.MyCallback() {
                        @Override
                        public void callbackCall() {
                            startActivity(new Intent(RealMoney_92.this, EarnMoney_82.class));
                        }
                    });
                } else {
                    startActivity(new Intent(RealMoney_92.this, EarnMoney_82.class));
                }
            } else if (earnmoney.ad_mode.equalsIgnoreCase("qureka")) {

                realmoney14.getInstance().qureka_inter(RealMoney_92.this, new realmoney14.MyCallback() {
                    @Override
                    public void callbackCall() {
                        startActivity(new Intent(RealMoney_92.this, EarnMoney_82.class));
                    }
                });

            } else {

                if (realmoney21.isInternetOn(RealMoney_92.this)) {
                    realmoney21.getInstance().loadintertialads(RealMoney_92.this, earnmoney.facebook_inter_id, new realmoney21.MyCallback() {
                        @Override
                        public void callbackCall() {
                            startActivity(new Intent(RealMoney_92.this, EarnMoney_82.class));
                        }
                    });
                } else {
                    startActivity(new Intent(RealMoney_92.this, EarnMoney_82.class));
                }
            }

        } else {
            startActivity(new Intent(RealMoney_92.this, EarnMoney_82.class));
        }
    }
}
