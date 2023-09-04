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
import watchvideo.dailytrend.earnmoney_21;
import watchvideo.dailytrend.Earnmoney_6.RealMoney_100.RealMoney_102;
import watchvideo.dailytrend.MyMoney;
import watchvideo.dailytrend.R;
import watchvideo.dailytrend.VideoCall.videocalling;
import java.util.ArrayList;
import java.util.HashMap;

public class WatchVideoEarnmoney extends AppCompatActivity implements View.OnClickListener {
    public static int max;
    public static int min;
    public static int random;
    Animation animation;
    TextView atv_coin_value;
    ImageView back;
    int i = 0;
    Boolean is_press = false;
    Boolean is_response = true;
    int j = 0;
    LinearLayout llrandomcall;
    private boolean mCustomTabsOpened = false;
    MyMoney myMoney;
    LinearLayout rl_vwatchvideo;

    LinearLayout play_quiz;

    RelativeLayout adContainerView, adContainerPlaylist;
    ShimmerFrameLayout main_act_banner;

    @Override 
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(1024, 1024);
        setContentView(R.layout.realmoneytrend);

        play_quiz = findViewById(R.id.play_quiz);

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

        if (qureka_visible){
            play_quiz.setVisibility(View.VISIBLE);
        }else{
            play_quiz.setVisibility(View.GONE);
        }


        this.myMoney = new MyMoney(this);
        ImageView imageView = (ImageView) findViewById(R.id.ivback);
        this.back = imageView;

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override 
            public void onClick(View view) {
                if (earnmoney.isAdOn) {
                    if (earnmoney.ad_mode.equalsIgnoreCase("admob")) {
                        if (realmoney12.isInternetOn(WatchVideoEarnmoney.this)) {
                            realmoney12.getInstance().loadintertialads(WatchVideoEarnmoney.this, earnmoney.admob_inter_id, new realmoney12.MyCallback() {
                                @Override
                                public void callbackCall() {
                                    startActivity(new Intent(WatchVideoEarnmoney.this, EarnMoney_82.class));
                                }
                            });
                        } else {
                            startActivity(new Intent(WatchVideoEarnmoney.this, EarnMoney_82.class));
                        }
                    } else if (earnmoney.ad_mode.equalsIgnoreCase("qureka")) {

                        realmoney14.getInstance().qureka_inter(WatchVideoEarnmoney.this, new realmoney14.MyCallback() {
                            @Override
                            public void callbackCall() {
                                startActivity(new Intent(WatchVideoEarnmoney.this, EarnMoney_82.class));
                            }
                        });

                    } else {

                        if (realmoney21.isInternetOn(WatchVideoEarnmoney.this)) {
                            realmoney21.getInstance().loadintertialads(WatchVideoEarnmoney.this, earnmoney.facebook_inter_id, new realmoney21.MyCallback() {
                                @Override
                                public void callbackCall() {
                                    startActivity(new Intent(WatchVideoEarnmoney.this, EarnMoney_82.class));
                                }
                            });
                        } else {
                            startActivity(new Intent(WatchVideoEarnmoney.this, EarnMoney_82.class));
                        }
                    }
                } else {
                    startActivity(new Intent(WatchVideoEarnmoney.this, EarnMoney_82.class));
                }
            }
        });

        this.animation = AnimationUtils.loadAnimation(this, R.anim.moneyapp);
        this.atv_coin_value = (TextView) findViewById(R.id.atv_coin_value);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.rl_vwatchvideo);
        this.rl_vwatchvideo = linearLayout;
        linearLayout.setOnClickListener(this);
        checkAndRequestPermissions();


        //Banner :-
        adContainerView = findViewById(R.id.adViewContainer);
        adContainerPlaylist = findViewById(R.id.adViewContainer);
        main_act_banner = findViewById(R.id.main_act_banner);


        if (earnmoney.isAdOn) {
            if (earnmoney.ad_mode.equalsIgnoreCase("admob")) {
                realmoney.creteadadaptiveBanner(WatchVideoEarnmoney.this, adContainerPlaylist, earnmoney.admob_banner_id);
            } else if (earnmoney.ad_mode.equalsIgnoreCase("qureka")) {
                main_act_banner.setVisibility(View.VISIBLE);
            } else {
                adContainerView.setBackgroundResource(R.drawable.realmoney_140);
                realmoney13.createFBLoadBanner(WatchVideoEarnmoney.this, adContainerPlaylist, earnmoney.facebook_banner_id);
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


        LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.llrandomcall);
        this.llrandomcall = linearLayout2;
        linearLayout2.setOnClickListener(new View.OnClickListener() {
            @Override 
            public void onClick(View view) {
                if (earnmoney.isAdOn) {
                    if (earnmoney.ad_mode.equalsIgnoreCase("admob")) {
                        if (realmoney12.isInternetOn(WatchVideoEarnmoney.this)) {
                            realmoney12.getInstance().loadintertialads(WatchVideoEarnmoney.this, earnmoney.admob_inter_id, new realmoney12.MyCallback() {
                                @Override
                                public void callbackCall() {
                                    if (earnmoney_21.live_video_call_url != null || !earnmoney_21.live_video_call_url.equals("")) {
                                        Intent intent = new Intent(WatchVideoEarnmoney.this, videocalling.class);
                                        intent.putExtra("url", earnmoney_21.live_video_call_url);
                                        WatchVideoEarnmoney.this.startActivity(intent);
                                        return;
                                    }
                                    Toast.makeText(WatchVideoEarnmoney.this, "Can't getting Video Please try again latter...", Toast.LENGTH_SHORT).show();
                                }
                            });
                        } else {
                            if (earnmoney_21.live_video_call_url != null || !earnmoney_21.live_video_call_url.equals("")) {
                                Intent intent = new Intent(WatchVideoEarnmoney.this, videocalling.class);
                                intent.putExtra("url", earnmoney_21.live_video_call_url);
                                WatchVideoEarnmoney.this.startActivity(intent);
                                return;
                            }
                            Toast.makeText(WatchVideoEarnmoney.this, "Can't getting Video Please try again latter...", Toast.LENGTH_SHORT).show();
                        }

                    } else if (earnmoney.ad_mode.equalsIgnoreCase("qureka")) {

                        realmoney14.getInstance().qureka_inter(WatchVideoEarnmoney.this, new realmoney14.MyCallback() {
                            @Override
                            public void callbackCall() {
                                if (earnmoney_21.live_video_call_url != null || !earnmoney_21.live_video_call_url.equals("")) {
                                    Intent intent = new Intent(WatchVideoEarnmoney.this, videocalling.class);
                                    intent.putExtra("url", earnmoney_21.live_video_call_url);
                                    WatchVideoEarnmoney.this.startActivity(intent);
                                    return;
                                }

                                Toast.makeText(WatchVideoEarnmoney.this, "Can't getting Video Please try again latter...", Toast.LENGTH_SHORT).show();
                            }
                        });

                    } else {

                        if (realmoney21.isInternetOn(WatchVideoEarnmoney.this)) {
                            realmoney21.getInstance().loadintertialads(WatchVideoEarnmoney.this, earnmoney.facebook_inter_id, new realmoney21.MyCallback() {
                                @Override
                                public void callbackCall() {
                                    if (earnmoney_21.live_video_call_url != null || !earnmoney_21.live_video_call_url.equals("")) {
                                        Intent intent = new Intent(WatchVideoEarnmoney.this, videocalling.class);
                                        intent.putExtra("url", earnmoney_21.live_video_call_url);
                                        WatchVideoEarnmoney.this.startActivity(intent);
                                        return;
                                    }
                                    Toast.makeText(WatchVideoEarnmoney.this, "Can't getting Video Please try again latter...", Toast.LENGTH_SHORT).show();
                                }
                            });
                        } else {
                            if (earnmoney_21.live_video_call_url != null || !earnmoney_21.live_video_call_url.equals("")) {
                                Intent intent = new Intent(WatchVideoEarnmoney.this, videocalling.class);
                                intent.putExtra("url", earnmoney_21.live_video_call_url);
                                WatchVideoEarnmoney.this.startActivity(intent);
                                return;
                            }
                            Toast.makeText(WatchVideoEarnmoney.this, "Can't getting Video Please try again latter...", Toast.LENGTH_SHORT).show();
                        }
                    }
                } else {
                    if (earnmoney_21.live_video_call_url != null || !earnmoney_21.live_video_call_url.equals("")) {
                        Intent intent = new Intent(WatchVideoEarnmoney.this, videocalling.class);
                        intent.putExtra("url", earnmoney_21.live_video_call_url);
                        WatchVideoEarnmoney.this.startActivity(intent);
                        return;
                    }
                    Toast.makeText(WatchVideoEarnmoney.this, "Can't getting Video Please try again latter...", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }


    @Override 
    public void onClick(View view) {
        view.startAnimation(this.animation);
        if (view.getId() == R.id.rl_vwatchvideo) {
            if (earnmoney.isAdOn) {
                if (earnmoney.ad_mode.equalsIgnoreCase("admob")) {
                    if (realmoney12.isInternetOn(WatchVideoEarnmoney.this)) {
                        realmoney12.getInstance().loadintertialads(WatchVideoEarnmoney.this, earnmoney.admob_inter_id, new realmoney12.MyCallback() {
                            @Override
                            public void callbackCall() {
                                startActivity(new Intent(WatchVideoEarnmoney.this, RealMoney_102.class));
                            }
                        });
                    } else {
                        startActivity(new Intent(WatchVideoEarnmoney.this, RealMoney_102.class));
                    }

                } else if (earnmoney.ad_mode.equalsIgnoreCase("qureka")) {

                    realmoney14.getInstance().qureka_inter(WatchVideoEarnmoney.this, new realmoney14.MyCallback() {
                        @Override
                        public void callbackCall() {
                            startActivity(new Intent(WatchVideoEarnmoney.this, RealMoney_102.class));
                        }
                    });

                } else {

                    if (realmoney21.isInternetOn(WatchVideoEarnmoney.this)) {
                        realmoney21.getInstance().loadintertialads(WatchVideoEarnmoney.this, earnmoney.facebook_inter_id, new realmoney21.MyCallback() {
                            @Override
                            public void callbackCall() {
                                startActivity(new Intent(WatchVideoEarnmoney.this, RealMoney_102.class));
                            }
                        });
                    } else {
                        startActivity(new Intent(WatchVideoEarnmoney.this, RealMoney_102.class));
                    }
                }
            } else {
                startActivity(new Intent(WatchVideoEarnmoney.this, RealMoney_102.class));
            }

        }
    }


    @Override 
    public void onBackPressed() {
        if (earnmoney.isAdOn) {
            if (earnmoney.ad_mode.equalsIgnoreCase("admob")) {
                if (realmoney12.isInternetOn(WatchVideoEarnmoney.this)) {
                    realmoney12.getInstance().loadintertialads(WatchVideoEarnmoney.this, earnmoney.admob_inter_id, new realmoney12.MyCallback() {
                        @Override
                        public void callbackCall() {
                            startActivity(new Intent(WatchVideoEarnmoney.this, EarnMoney_82.class));
                        }
                    });
                } else {
                    startActivity(new Intent(WatchVideoEarnmoney.this, EarnMoney_82.class));
                }
            } else if (earnmoney.ad_mode.equalsIgnoreCase("qureka")) {

                realmoney14.getInstance().qureka_inter(WatchVideoEarnmoney.this, new realmoney14.MyCallback() {
                    @Override
                    public void callbackCall() {
                        startActivity(new Intent(WatchVideoEarnmoney.this, EarnMoney_82.class));
                    }
                });

            } else {

                if (realmoney21.isInternetOn(WatchVideoEarnmoney.this)) {
                    realmoney21.getInstance().loadintertialads(WatchVideoEarnmoney.this, earnmoney.facebook_inter_id, new realmoney21.MyCallback() {
                        @Override
                        public void callbackCall() {
                            startActivity(new Intent(WatchVideoEarnmoney.this, EarnMoney_82.class));
                        }
                    });
                } else {
                    startActivity(new Intent(WatchVideoEarnmoney.this, EarnMoney_82.class));
                }
            }
        } else {
            startActivity(new Intent(WatchVideoEarnmoney.this, EarnMoney_82.class));
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
    public void onPause() {
        super.onPause();
    }


    @Override 
    public void onDestroy() {
        super.onDestroy();
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
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        if (i2 == 4) {
            HashMap hashMap = new HashMap();
            hashMap.put("android.permission.CAMERA", 0);
            hashMap.put("android.permission.WRITE_EXTERNAL_STORAGE", 0);
            if (iArr.length > 0) {
                for (int i3 = 0; i3 < strArr.length; i3++) {
                    hashMap.put(strArr[i3], Integer.valueOf(iArr[i3]));
                }
                if (!(((Integer) hashMap.get("android.permission.CAMERA")).intValue() == 0 && ((Integer) hashMap.get("android.permission.WRITE_EXTERNAL_STORAGE")).intValue() == 0) && !ActivityCompat.shouldShowRequestPermissionRationale(this, "android.permission.CAMERA") && !ActivityCompat.shouldShowRequestPermissionRationale(this, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                    Toast.makeText(this, "Go to settings and enable permissions", Toast.LENGTH_LONG).show();
                }
            }
        }
    }


}
