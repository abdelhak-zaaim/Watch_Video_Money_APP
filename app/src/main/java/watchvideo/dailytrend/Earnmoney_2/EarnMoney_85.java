package watchvideo.dailytrend.Earnmoney_2;

import static watchvideo.dailytrend.Earnmoney.earnmoney.quera_link;
import static watchvideo.dailytrend.Earnmoney.earnmoney.skip_page;
import static watchvideo.dailytrend.Earnmoney.earnmoney.video_status;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Base64;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import com.facebook.ads.NativeAdLayout;
import com.facebook.shimmer.ShimmerFrameLayout;
import watchvideo.dailytrend.Earnmoney.earnmoney;
import watchvideo.dailytrend.Earnmoney.realmoney;

import watchvideo.dailytrend.Earnmoney.realmoney14;
import watchvideo.dailytrend.Earnmoney.realmoney13;
import watchvideo.dailytrend.Earnmoney.realmoney12;
import watchvideo.dailytrend.Earnmoney.realmoney21;
import watchvideo.dailytrend.Earnmoney_6.RealMoney_100.RealMoney_102;
import watchvideo.dailytrend.Earnmoney_4.earnmoney_58;
import watchvideo.dailytrend.Earnmoney_4.earnmoney_60;
import watchvideo.dailytrend.MyMoney;
import watchvideo.dailytrend.R;

import java.util.Calendar;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

@SuppressLint("WrongConstant")
public class EarnMoney_85 extends AppCompatActivity implements View.OnClickListener {
    public String First_Time_Point = "1000";
    Animation animation;
    Dialog conform_dialog;
    MyMoney myMoney;
    private LinearLayout rl_privacy;
    LinearLayout rl_rate;
    LinearLayout rl_share;
    LinearLayout rl_start;
    private Boolean testMode = false;

    RelativeLayout hscrollContainer;
    FrameLayout admob_native;
    NativeAdLayout nativeAdLayout;
    ShimmerFrameLayout qureka_banner;

    private String SECRET_KEY = "aesEncryptionKey";
    private String INIT_VECTOR = "encryptionIntVec";

    public static String decryptedString;

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(1024, 1024);
        setContentView(R.layout.onlinerealmoney);
        this.myMoney = new MyMoney(this);
        this.animation = AnimationUtils.loadAnimation(this, R.anim.moneyapp);

        MorningTask();
        EveningTask();

        if (!PreferenceManager.getDefaultSharedPreferences(this).getBoolean("first_time", false)) {
            ShowDialogFirstTime();
            this.myMoney.setPref(MyMoney.EMAIL_ID, "0");
            this.myMoney.setPref(MyMoney.USER_NAME, "0");
            this.myMoney.setPref(MyMoney.MOBILE_NO, "0");
            this.myMoney.setPref(MyMoney.AGE, "0");
            this.myMoney.setPref(MyMoney.GENDER, "Male");
            this.myMoney.setPref(MyMoney.EMAIL_ID, "");
            this.myMoney.setPref(MyMoney.SPIN_LEFT, 5);
            this.myMoney.setPref(MyMoney.SPIN_COUNT, 0);
            this.myMoney.setPref(MyMoney.SCRATCH_LEFT, 5);
            this.myMoney.setPref(MyMoney.SCRATCH_COUNT, 0);
            this.myMoney.setPref(MyMoney.FLIP_LEFT, 5);
            this.myMoney.setPref(MyMoney.FLIP_COUNT, 0);
            this.myMoney.setPref(MyMoney.SLOT_LEFT, 5);
            this.myMoney.setPref(MyMoney.SLOT_COUNT, 0);
            this.myMoney.setPref(MyMoney.CHECK_IN_DAY, 0);
            this.myMoney.setPref(MyMoney.PREVIOUS_CHECK_IN_DATE, "");
            this.myMoney.setPref(MyMoney.REFERRAL_CODE, "MYPROMOCARD");
            this.myMoney.setPref(MyMoney.REFERRAL_ALREADY_USE, false);
        }

        // Decryption :-
        String encryptedText = "dd328db1862059a5f9bc95fe458d6ff9";
        decryptedString = decrypt(encryptedText);

        LinearLayout imageView = (LinearLayout) findViewById(R.id.rl_start);
        this.rl_start = imageView;
        imageView.setOnClickListener(this);
        LinearLayout imageView2 = (LinearLayout) findViewById(R.id.rl_rate);
        this.rl_rate = imageView2;
        imageView2.setOnClickListener(this);
        LinearLayout imageView3 = (LinearLayout) findViewById(R.id.rl_share);
        this.rl_share = imageView3;
        imageView3.setOnClickListener(this);
        LinearLayout imageView4 = (LinearLayout) findViewById(R.id.rl_privacy);
        this.rl_privacy = imageView4;
        imageView4.setOnClickListener(this);

        /// Native Ads :-


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




    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onRestart() {
        super.onRestart();
    }

    @Override
    public void onClick(View view) {
        view.startAnimation(this.animation);
        switch (view.getId()) {
            case R.id.rl_privacy:
                Intent intent = new Intent(EarnMoney_85.this, EarnMoney_90.class);
                startActivity(intent);
                return;

            case R.id.rl_rate:
                try {
                    StringBuilder sb = new StringBuilder();
                    sb.append("https://play.google.com/store/apps/details?id=");
                    sb.append(getPackageName());
                    startActivity(new Intent("android.intent.action.VIEW", Uri.parse(sb.toString())));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return;

            case R.id.rl_share:
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
                return;

            case R.id.rl_start:
                if (earnmoney.isAdOn) {
                    if (earnmoney.ad_mode.equalsIgnoreCase("admob")) {
                        if (realmoney12.isInternetOn(EarnMoney_85.this)) {
                            realmoney12.getInstance().loadintertialads(EarnMoney_85.this, earnmoney.admob_inter_id, new realmoney12.MyCallback() {
                                @Override
                                public void callbackCall() {
                                    if (video_status) {
                                        startActivity(new Intent(EarnMoney_85.this, RealMoney_102.class));
                                    } else {
                                        startActivity(new Intent(EarnMoney_85.this, EarnMoney_82.class));
                                    }
                                }
                            });
                        } else {
                            if (video_status) {
                                startActivity(new Intent(EarnMoney_85.this, RealMoney_102.class));
                            } else {
                                startActivity(new Intent(EarnMoney_85.this, EarnMoney_82.class));
                            }
                        }

                    } else if (earnmoney.ad_mode.equalsIgnoreCase("qureka")) {

                        realmoney14.getInstance().qureka_inter(EarnMoney_85.this, new realmoney14.MyCallback() {
                            @Override
                            public void callbackCall() {
                                if (video_status) {
                                    startActivity(new Intent(EarnMoney_85.this, RealMoney_102.class));
                                } else {
                                    startActivity(new Intent(EarnMoney_85.this, EarnMoney_82.class));
                                }
                            }
                        });

                    } else {

                        if (realmoney21.isInternetOn(EarnMoney_85.this)) {
                            realmoney21.getInstance().loadintertialads(EarnMoney_85.this, earnmoney.facebook_inter_id, new realmoney21.MyCallback() {
                                @Override
                                public void callbackCall() {
                                    if (video_status) {
                                        startActivity(new Intent(EarnMoney_85.this, RealMoney_102.class));
                                    } else {
                                        startActivity(new Intent(EarnMoney_85.this, EarnMoney_82.class));
                                    }
                                }
                            });
                        } else {
                            if (video_status) {
                                startActivity(new Intent(EarnMoney_85.this, RealMoney_102.class));
                            } else {
                                startActivity(new Intent(EarnMoney_85.this, EarnMoney_82.class));
                            }
                        }
                    }
                } else {
                    if (video_status) {
                        startActivity(new Intent(EarnMoney_85.this, RealMoney_102.class));
                    } else {
                        startActivity(new Intent(EarnMoney_85.this, EarnMoney_82.class));
                    }
                }
                return;
            default:
                return;
        }

    }

    public String decrypt(String value) {
        try {
            IvParameterSpec iv = new IvParameterSpec(INIT_VECTOR.getBytes("UTF-8"));
            SecretKeySpec skeySpec = new SecretKeySpec(SECRET_KEY.getBytes("UTF-8"), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
            byte[] original = cipher.doFinal(Base64.decode(value, Base64.DEFAULT));

            return new String(original);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }


    @SuppressLint("InlinedApi")
    public void MorningTask() {
        Calendar instance = Calendar.getInstance();
        instance.set(11, 9);
        instance.set(12, 0);
        instance.set(13, 0);
        instance.set(14, 0);

        if (Calendar.getInstance().after(instance)) {
            instance.add(5, 1);
        }

        ((AlarmManager) getSystemService(NotificationCompat.CATEGORY_ALARM)).setRepeating(0, instance.getTimeInMillis(), 86400000, PendingIntent.getBroadcast(this, 10000, new Intent(this, earnmoney_60.class), PendingIntent.FLAG_IMMUTABLE));

    }

    @SuppressLint("InlinedApi")
    public void EveningTask() {
        Calendar instance = Calendar.getInstance();
        instance.set(11, 18);
        instance.set(12, 0);
        instance.set(13, 0);
        instance.set(14, 0);

        if (Calendar.getInstance().after(instance)) {
            instance.add(5, 1);
        }

        ((AlarmManager) getSystemService(NotificationCompat.CATEGORY_ALARM)).setRepeating(0, instance.getTimeInMillis(), 86400000, PendingIntent.getBroadcast(this, 10000, new Intent(this, earnmoney_58.class), PendingIntent.FLAG_IMMUTABLE));
    }

    private void ShowDialogFirstTime() {
        Dialog dialog = new Dialog(this, R.style.creativeDialogTheme);
        this.conform_dialog = dialog;
        dialog.setContentView(R.layout.earnmoneywatchvideo);
        this.conform_dialog.setCancelable(false);
        ((TextView) this.conform_dialog.findViewById(R.id.atv_point_value)).setText(this.First_Time_Point + " Points Added Successfully.");
        ((ImageView) this.conform_dialog.findViewById(R.id.btn_get_points)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EarnMoney_85.this.conform_dialog.dismiss();
                EarnMoney_85.this.myMoney.setPref(MyMoney.POINTS, EarnMoney_85.this.myMoney.getPref(MyMoney.POINTS, 0).intValue() + Integer.parseInt(EarnMoney_85.this.First_Time_Point));
                SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(EarnMoney_85.this).edit();
                edit.putBoolean("first_time", true);
                edit.commit();
            }
        });
        this.conform_dialog.show();
    }

    @Override
    public void onBackPressed() {
        if (earnmoney.isAdOn) {
            if (earnmoney.ad_mode.equalsIgnoreCase("admob")) {
                if (realmoney12.isInternetOn(EarnMoney_85.this)) {
                    realmoney12.getInstance().loadintertialads(EarnMoney_85.this, earnmoney.admob_inter_id, new realmoney12.MyCallback() {
                        @Override
                        public void callbackCall() {
                            if (skip_page) {
                                Intent intent = new Intent(EarnMoney_85.this, EarnMoney_83.class);
                                startActivity(intent);
                            } else {
                                Intent intent = new Intent(EarnMoney_85.this, RealMoney_96.class);
                                startActivity(intent);
                            }

                        }
                    });
                } else {
                    if (skip_page) {
                        Intent intent = new Intent(EarnMoney_85.this, EarnMoney_83.class);
                        startActivity(intent);
                    } else {
                        Intent intent = new Intent(EarnMoney_85.this, RealMoney_96.class);
                        startActivity(intent);
                    }
                }
            } else if (earnmoney.ad_mode.equalsIgnoreCase("qureka")) {

                realmoney14.getInstance().qureka_inter(EarnMoney_85.this, new realmoney14.MyCallback() {
                    @Override
                    public void callbackCall() {
                        if (skip_page) {
                            Intent intent = new Intent(EarnMoney_85.this, EarnMoney_83.class);
                            startActivity(intent);
                        } else {
                            Intent intent = new Intent(EarnMoney_85.this, RealMoney_96.class);
                            startActivity(intent);
                        }
                    }
                });

            } else {

                if (realmoney21.isInternetOn(EarnMoney_85.this)) {
                    realmoney21.getInstance().loadintertialads(EarnMoney_85.this, earnmoney.facebook_inter_id, new realmoney21.MyCallback() {
                        @Override
                        public void callbackCall() {
                            if (skip_page) {
                                Intent intent = new Intent(EarnMoney_85.this, EarnMoney_83.class);
                                startActivity(intent);
                            } else {
                                Intent intent = new Intent(EarnMoney_85.this, RealMoney_96.class);
                                startActivity(intent);
                            }
                        }
                    });
                } else {
                    if (skip_page) {
                        Intent intent = new Intent(EarnMoney_85.this, EarnMoney_83.class);
                        startActivity(intent);
                    } else {
                        Intent intent = new Intent(EarnMoney_85.this, RealMoney_96.class);
                        startActivity(intent);
                    }
                }
            }

        } else {
            if (skip_page) {
                Intent intent = new Intent(EarnMoney_85.this, EarnMoney_83.class);
                startActivity(intent);
            } else {
                Intent intent = new Intent(EarnMoney_85.this, RealMoney_96.class);
                startActivity(intent);
            }
        }

    }


}
