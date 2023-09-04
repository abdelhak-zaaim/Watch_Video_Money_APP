package watchvideo.dailytrend.Earnmoney_2;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import watchvideo.dailytrend.Earnmoney.earnmoney;

import watchvideo.dailytrend.Earnmoney.realmoney14;
import watchvideo.dailytrend.Earnmoney.realmoney12;
import watchvideo.dailytrend.Earnmoney.realmoney21;
import watchvideo.dailytrend.MyMoney;
import watchvideo.dailytrend.realmoney_23;
import watchvideo.dailytrend.Earnmoney_4.SlotMachine;
import watchvideo.dailytrend.Earnmoney_7.earnmoney_53;
import watchvideo.dailytrend.R;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class SlotMachinegame extends AppCompatActivity implements realmoney_23.timer_method {

    Animation animation;
    TextView atv_coin_value;
    TextView atv_slot_left_value;
    TextView atv_time_left_value;


    public BroadcastReceiver br = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            SlotMachinegame.this.updateGUI(intent);
        }
    };


    public Dialog conform_dialog;
    public Handler detectAnyMatchHandler = new Handler() {
        @Override
        public void handleMessage(Message message) {
            if (message.what == 0) {
                SlotMachinegame.this.spin.setEnabled(true);
            }
            if (SlotMachinegame.this.wheel1Selection == 1 && SlotMachinegame.this.wheel2Selection == 1 && SlotMachinegame.this.wheel3Selection == 1) {
                SlotMachinegame.this.result = "150";
            } else if (SlotMachinegame.this.wheel1Selection == 2 && SlotMachinegame.this.wheel2Selection == 2 && SlotMachinegame.this.wheel3Selection == 2) {
                SlotMachinegame.this.result = "150";
            } else if (SlotMachinegame.this.wheel1Selection == 3 && SlotMachinegame.this.wheel2Selection == 3 && SlotMachinegame.this.wheel3Selection == 3) {
                SlotMachinegame.this.result = "150";
            } else if (SlotMachinegame.this.str_whee1.equalsIgnoreCase(SlotMachinegame.this.str_whee2)) {
                SlotMachinegame.this.result = "100";
            } else if (SlotMachinegame.this.str_whee1.equalsIgnoreCase(SlotMachinegame.this.str_whee3)) {
                SlotMachinegame.this.result = "100";
            } else if (SlotMachinegame.this.str_whee2.equalsIgnoreCase(SlotMachinegame.this.str_whee1)) {
                SlotMachinegame.this.result = "100";
            } else if (SlotMachinegame.this.str_whee2.equalsIgnoreCase(SlotMachinegame.this.str_whee3)) {
                SlotMachinegame.this.result = "100";
            } else if (SlotMachinegame.this.str_whee3.equalsIgnoreCase(SlotMachinegame.this.str_whee1)) {
                SlotMachinegame.this.result = "100";
            } else if (SlotMachinegame.this.str_whee3.equalsIgnoreCase(SlotMachinegame.this.str_whee2)) {
                SlotMachinegame.this.result = "100";
            } else {
                SlotMachinegame.this.result = "50";
            }
            SlotMachinegame.this.ShowDialog();
        }
    };


    private boolean mCustomTabsOpened = false;
    MediaPlayer mediaPlayer;
    MyMoney myMoney;
    Random random;
    String result;
    public final int[] slotItem1Images = {R.drawable.realmoneygame_5, R.drawable.realmoneygame_13, R.drawable.realmoneygame_17};
    public final int[] slotItem1Texts = {R.drawable.watchvideoearnmoney_28, R.drawable.watchvideoearnmoney_27, R.drawable.watchvideoearnmoney_26};
    public final int[] slotItem2Images = {R.drawable.realmoneygame_5, R.drawable.realmoneygame_13, R.drawable.realmoneygame_17};
    public final int[] slotItem2Texts = {R.drawable.watchvideoearnmoney_28, R.drawable.watchvideoearnmoney_27, R.drawable.watchvideoearnmoney_26};
    public final int[] slotItem3Images = {R.drawable.realmoneygame_5, R.drawable.realmoneygame_13, R.drawable.realmoneygame_17};
    public final int[] slotItem3Texts = {R.drawable.watchvideoearnmoney_28, R.drawable.watchvideoearnmoney_27, R.drawable.watchvideoearnmoney_26};
    List<earnmoney_53> slotItems1;
    List<earnmoney_53> slotItems2;
    List<earnmoney_53> slotItems3;
    ImageView spin;
    String str_whee1;
    String str_whee2;
    String str_whee3;
    public int wheel1Selection;
    public int wheel2Selection;
    public int wheel3Selection;
    RealMoney_95 realMoney951;
    RealMoney_95 realMoney952;
    RealMoney_95 realMoney953;


    @Override 
    public void onCreate(Bundle bundle) {
        int i;
        int i2;
        super.onCreate(bundle);
        setContentView(R.layout.earnmoneyspin);
        getWindow().setFlags(1024, 1024);

        ((ImageView) findViewById(R.id.ivback)).setOnClickListener(new View.OnClickListener() {
            @Override 
            public void onClick(View view) {
                if (earnmoney.isAdOn) {
                    if (earnmoney.ad_mode.equalsIgnoreCase("admob")) {
                        if (realmoney12.isInternetOn(SlotMachinegame.this)) {
                            realmoney12.getInstance().loadintertialads(SlotMachinegame.this, earnmoney.admob_inter_id, new realmoney12.MyCallback() {
                                @Override
                                public void callbackCall() {
                                    startActivity(new Intent(SlotMachinegame.this, EarnMoney_82.class));
                                }
                            });
                        } else {
                            startActivity(new Intent(SlotMachinegame.this, EarnMoney_82.class));
                        }
                    } else if (earnmoney.ad_mode.equalsIgnoreCase("qureka")) {

                        realmoney14.getInstance().qureka_inter(SlotMachinegame.this, new realmoney14.MyCallback() {
                            @Override
                            public void callbackCall() {
                                startActivity(new Intent(SlotMachinegame.this, EarnMoney_82.class));
                            }
                        });

                    } else {

                        if (realmoney21.isInternetOn(SlotMachinegame.this)) {
                            realmoney21.getInstance().loadintertialads(SlotMachinegame.this, earnmoney.facebook_inter_id, new realmoney21.MyCallback() {
                                @Override
                                public void callbackCall() {
                                    startActivity(new Intent(SlotMachinegame.this, EarnMoney_82.class));
                                }
                            });
                        } else {
                            startActivity(new Intent(SlotMachinegame.this, EarnMoney_82.class));
                        }
                    }

                } else {
                    startActivity(new Intent(SlotMachinegame.this, EarnMoney_82.class));
                }
            }
        });


        this.animation = AnimationUtils.loadAnimation(this, R.anim.moneyapp);
        this.myMoney = new MyMoney(this);
        this.atv_coin_value = (TextView) findViewById(R.id.atv_coin_value);
        this.atv_slot_left_value = (TextView) findViewById(R.id.atv_slot_left_value);
        this.atv_time_left_value = (TextView) findViewById(R.id.atv_time_left_value);
        this.random = new Random();
        this.mediaPlayer = MediaPlayer.create(this, (int) R.raw.earnmoney);
        this.realMoney951 = (RealMoney_95) findViewById(R.id.wheel1);
        this.realMoney952 = (RealMoney_95) findViewById(R.id.wheel2);
        this.realMoney953 = (RealMoney_95) findViewById(R.id.wheel3);
        this.slotItems1 = new ArrayList();
        this.slotItems2 = new ArrayList();
        this.slotItems3 = new ArrayList();
        this.slotItems1.add(new SlotItemsImpl(1, 0));
        this.slotItems1.add(new SlotItemsImpl(1, 1));
        this.slotItems1.add(new SlotItemsImpl(1, 2));
        this.realMoney951.setSlotItems(this.slotItems1);
        this.slotItems2.add(new SlotItemsImpl(2, 0));
        this.slotItems2.add(new SlotItemsImpl(2, 1));
        this.slotItems2.add(new SlotItemsImpl(2, 2));
        this.realMoney952.setSlotItems(this.slotItems2);
        this.slotItems3.add(new SlotItemsImpl(3, 0));
        this.slotItems3.add(new SlotItemsImpl(3, 1));
        this.slotItems3.add(new SlotItemsImpl(3, 2));
        this.realMoney953.setSlotItems(this.slotItems3);
        this.realMoney951.setNumberOfVisibleItems(2);
        this.realMoney952.setNumberOfVisibleItems(2);
        this.realMoney953.setNumberOfVisibleItems(2);

        this.realMoney951.setWheelBackground(getResources().getDrawable(R.drawable.moneydailyearn_3));
        this.realMoney952.setWheelBackground(getResources().getDrawable(R.drawable.moneydailyearn_3));
        this.realMoney953.setWheelBackground(getResources().getDrawable(R.drawable.moneydailyearn_3));

        this.realMoney951.setScrollFinishedListener(new RealMoney_95.OnScrollFinishedListener() {
            @Override 
            public void onWheelFinishedScrolling(int i) {
                SlotMachinegame.this.wheel1Selection = i;
                SlotMachinegame.this.str_whee1 = String.valueOf(i);
            }
        });


        this.realMoney952.setScrollFinishedListener(new RealMoney_95.OnScrollFinishedListener() {
            @Override 
            public void onWheelFinishedScrolling(int i) {
                SlotMachinegame.this.wheel2Selection = i;
                SlotMachinegame.this.str_whee2 = String.valueOf(i);
            }
        });


        this.realMoney953.setScrollFinishedListener(new RealMoney_95.OnScrollFinishedListener() {
            @Override
            public void onWheelFinishedScrolling(int i) {
                SlotMachinegame.this.wheel3Selection = i;
                SlotMachinegame.this.str_whee3 = String.valueOf(i);
            }
        });


        ImageView imageView = (ImageView) findViewById(R.id.spin);
        this.spin = imageView;

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override 
            public void onClick(View view) {
                view.startAnimation(SlotMachinegame.this.animation);

                if (earnmoney.isAdOn) {
                    if (earnmoney.ad_mode.equalsIgnoreCase("admob")) {
                        if (realmoney12.isInternetOn(SlotMachinegame.this)) {
                            realmoney12.getInstance().loadintertialads(SlotMachinegame.this, earnmoney.admob_inter_id, new realmoney12.MyCallback() {
                                @Override
                                public void callbackCall() {
                                    mediaPlayer.start();
                                    spin.setEnabled(false);
                                    realMoney951.scroll((SlotMachinegame.this.random.nextInt(9) * 100) + 16000, 10000);
                                    realMoney952.scroll((SlotMachinegame.this.random.nextInt(9) * 100) + 16000, 10000);
                                    realMoney953.scroll((SlotMachinegame.this.random.nextInt(9) * 100) + 16000, 10000);
                                    Message obtain = Message.obtain();
                                    obtain.what = 0;
                                    detectAnyMatchHandler.sendMessageDelayed(obtain, 11000);
                                }
                            });
                        } else {
                            mediaPlayer.start();
                            spin.setEnabled(false);
                            realMoney951.scroll((SlotMachinegame.this.random.nextInt(9) * 100) + 16000, 10000);
                            realMoney952.scroll((SlotMachinegame.this.random.nextInt(9) * 100) + 16000, 10000);
                            realMoney953.scroll((SlotMachinegame.this.random.nextInt(9) * 100) + 16000, 10000);
                            Message obtain = Message.obtain();
                            obtain.what = 0;
                            detectAnyMatchHandler.sendMessageDelayed(obtain, 11000);
                        }

                    } else if (earnmoney.ad_mode.equalsIgnoreCase("qureka")) {

                        realmoney14.getInstance().qureka_inter(SlotMachinegame.this, new realmoney14.MyCallback() {
                            @Override
                            public void callbackCall() {
                                mediaPlayer.start();
                                spin.setEnabled(false);
                                realMoney951.scroll((SlotMachinegame.this.random.nextInt(9) * 100) + 16000, 10000);
                                realMoney952.scroll((SlotMachinegame.this.random.nextInt(9) * 100) + 16000, 10000);
                                realMoney953.scroll((SlotMachinegame.this.random.nextInt(9) * 100) + 16000, 10000);
                                Message obtain = Message.obtain();
                                obtain.what = 0;
                                detectAnyMatchHandler.sendMessageDelayed(obtain, 11000);
                            }
                        });

                    } else {

                        if (realmoney21.isInternetOn(SlotMachinegame.this)) {
                            realmoney21.getInstance().loadintertialads(SlotMachinegame.this, earnmoney.facebook_inter_id, new realmoney21.MyCallback() {
                                @Override
                                public void callbackCall() {
                                    mediaPlayer.start();
                                    spin.setEnabled(false);
                                    realMoney951.scroll((SlotMachinegame.this.random.nextInt(9) * 100) + 16000, 10000);
                                    realMoney952.scroll((SlotMachinegame.this.random.nextInt(9) * 100) + 16000, 10000);
                                    realMoney953.scroll((SlotMachinegame.this.random.nextInt(9) * 100) + 16000, 10000);
                                    Message obtain = Message.obtain();
                                    obtain.what = 0;
                                    detectAnyMatchHandler.sendMessageDelayed(obtain, 11000);
                                }
                            });
                        } else {
                            mediaPlayer.start();
                            spin.setEnabled(false);
                            realMoney951.scroll((SlotMachinegame.this.random.nextInt(9) * 100) + 16000, 10000);
                            realMoney952.scroll((SlotMachinegame.this.random.nextInt(9) * 100) + 16000, 10000);
                            realMoney953.scroll((SlotMachinegame.this.random.nextInt(9) * 100) + 16000, 10000);
                            Message obtain = Message.obtain();
                            obtain.what = 0;
                            detectAnyMatchHandler.sendMessageDelayed(obtain, 11000);
                        }
                    }
                } else {
                    mediaPlayer.start();
                    spin.setEnabled(false);
                    realMoney951.scroll((SlotMachinegame.this.random.nextInt(9) * 100) + 16000, 10000);
                    realMoney952.scroll((SlotMachinegame.this.random.nextInt(9) * 100) + 16000, 10000);
                    realMoney953.scroll((SlotMachinegame.this.random.nextInt(9) * 100) + 16000, 10000);
                    Message obtain = Message.obtain();
                    obtain.what = 0;
                    detectAnyMatchHandler.sendMessageDelayed(obtain, 11000);
                }
            }
        });


        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int i3 = displayMetrics.heightPixels;
        int i4 = displayMetrics.widthPixels;
        int i5 = (int) ((getResources().getDisplayMetrics().density * 5.0f) + 0.5f);

        if (i4 > i3) {
            i = (i4 * 65) / 100;
            i2 = (i3 * 60) / 100;
        } else {
            i = (i4 * 90) / 100;
            i2 = (i3 * 40) / 100;
        }

        int i6 = (i - (i5 * 2)) / 3;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.realMoney951.getLayoutParams();
        layoutParams.width = i6;
        layoutParams.height = i2;
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.realMoney952.getLayoutParams();
        layoutParams2.width = i6;
        layoutParams2.height = i2;
        layoutParams2.leftMargin = i5;
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.realMoney953.getLayoutParams();
        layoutParams3.width = i6;
        layoutParams3.height = i2;
        layoutParams3.leftMargin = i5;

    }


    class SlotItemsImpl implements earnmoney_53 {
        int slotItemPos;
        int wheelPos;

        public SlotItemsImpl(int i, int i2) {
            this.wheelPos = i;
            this.slotItemPos = i2;
        }

        @Override
        public View getView() {
            View inflate = SlotMachinegame.this.getLayoutInflater().inflate(R.layout.realmoneyreal, (ViewGroup) null, false);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.itemImage);
            TextView textView = (TextView) inflate.findViewById(R.id.itemTxt);
            Resources resources = SlotMachinegame.this.getResources();
            int i = this.wheelPos;
            if (i == 1) {
                imageView.setImageResource(SlotMachinegame.this.slotItem1Images[this.slotItemPos]);
                textView.setBackground(resources.getDrawable(SlotMachinegame.this.slotItem1Texts[this.slotItemPos]));
            } else if (i == 2) {
                imageView.setImageResource(SlotMachinegame.this.slotItem2Images[this.slotItemPos]);
                textView.setBackground(resources.getDrawable(SlotMachinegame.this.slotItem2Texts[this.slotItemPos]));
            } else if (i == 3) {
                imageView.setImageResource(SlotMachinegame.this.slotItem3Images[this.slotItemPos]);
                textView.setBackground(resources.getDrawable(SlotMachinegame.this.slotItem3Texts[this.slotItemPos]));
            }
            return inflate;
        }

    }


    public void Disable() {
        this.spin.setEnabled(false);
    }


    public void Enable() {
        this.spin.setEnabled(true);
    }


    @Override
    public void tik_onFinish(Boolean bool) {
        Enable();
        stopService(new Intent(this, realmoney_23.class));
    }


    @Override
    public void tik_tik(long j) {
        Disable();
        long seconds = TimeUnit.MILLISECONDS.toSeconds(j);
        TextView textView = this.atv_time_left_value;
        textView.setText(seconds + "");
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


    public void ShowDialog() {
        Dialog dialog = new Dialog(this, R.style.creativeDialogTheme);
        this.conform_dialog = dialog;
        dialog.setContentView(R.layout.earnmoneywatchvideo);
        this.conform_dialog.setCancelable(false);
        ((TextView) this.conform_dialog.findViewById(R.id.atv_point_value)).setText(this.result + " Points Added Successfully.");

        ((ImageView) this.conform_dialog.findViewById(R.id.btn_get_points)).setOnClickListener(new View.OnClickListener() {
            @Override 
            public void onClick(View view) {
                SlotMachinegame.this.conform_dialog.dismiss();
                SlotMachinegame.this.myMoney.setPref(MyMoney.POINTS, SlotMachinegame.this.myMoney.getPref(MyMoney.POINTS, 0).intValue() + Integer.parseInt(SlotMachinegame.this.result));
                TextView textView = SlotMachinegame.this.atv_coin_value;
                textView.setText("" + SlotMachinegame.this.myMoney.getPref(MyMoney.POINTS, 0));
                int intValue = SlotMachinegame.this.myMoney.getPref(MyMoney.SLOT_LEFT, 0).intValue();
                if (intValue != 0) {
                    int i = intValue - 1;
                    SlotMachinegame.this.myMoney.setPref(MyMoney.SLOT_LEFT, i);
                    SlotMachinegame.this.myMoney.setPref(MyMoney.SLOT_COUNT, SlotMachinegame.this.myMoney.getPref(MyMoney.SLOT_COUNT, 0).intValue() + Integer.parseInt(SlotMachinegame.this.result));
                    TextView textView2 = SlotMachinegame.this.atv_slot_left_value;
                    textView2.setText("" + SlotMachinegame.this.myMoney.getPref(MyMoney.SLOT_LEFT, 0));
                    if (i != 0) {
                        SlotMachinegame slotMachinegame = SlotMachinegame.this;
                        slotMachinegame.startService(new Intent(slotMachinegame, realmoney_23.class));
                        return;
                    }
                    SlotMachinegame.this.Disable();
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault());
                    Calendar instance = Calendar.getInstance();
                    instance.setTime(new Date());
                    instance.add(5, 1);
                    SlotMachinegame.this.myMoney.setPref(MyMoney.AFTER_TWO_HOUR_SLOT, simpleDateFormat.format(instance.getTime()));
                    String format = new SimpleDateFormat("HH:mm:ss").format(instance.getTime());
                    SlotMachinegame.this.atv_time_left_value.setText(new SimpleDateFormat("hh:mm aa").format(instance.getTime()));
                    SlotMachinegame.this.Notification(format);
                }
            }
        });

        this.conform_dialog.show();

    }


    @SuppressLint({"WrongConstant", "InlinedApi"})
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

        ((AlarmManager) getSystemService(NotificationCompat.CATEGORY_ALARM)).setRepeating(0, instance.getTimeInMillis(), 86400000, PendingIntent.getBroadcast(this, 10000, new Intent(this, SlotMachine.class), PendingIntent.FLAG_IMMUTABLE));

    }


    @Override 
    public void onBackPressed() {
        if (earnmoney.isAdOn) {
            if (earnmoney.ad_mode.equalsIgnoreCase("admob")) {
                if (realmoney12.isInternetOn(SlotMachinegame.this)) {
                    realmoney12.getInstance().loadintertialads(SlotMachinegame.this, earnmoney.admob_inter_id, new realmoney12.MyCallback() {
                        @Override
                        public void callbackCall() {
                            startActivity(new Intent(SlotMachinegame.this, EarnMoney_82.class));
                        }
                    });
                } else {
                    startActivity(new Intent(SlotMachinegame.this, EarnMoney_82.class));
                }

            } else if (earnmoney.ad_mode.equalsIgnoreCase("qureka")) {

                realmoney14.getInstance().qureka_inter(SlotMachinegame.this, new realmoney14.MyCallback() {
                    @Override
                    public void callbackCall() {
                        startActivity(new Intent(SlotMachinegame.this, EarnMoney_82.class));
                    }
                });

            } else {

                if (realmoney21.isInternetOn(SlotMachinegame.this)) {
                    realmoney21.getInstance().loadintertialads(SlotMachinegame.this, earnmoney.facebook_inter_id, new realmoney21.MyCallback() {
                        @Override
                        public void callbackCall() {
                            startActivity(new Intent(SlotMachinegame.this, EarnMoney_82.class));
                        }
                    });
                } else {
                    startActivity(new Intent(SlotMachinegame.this, EarnMoney_82.class));
                }
            }

        } else {
            startActivity(new Intent(SlotMachinegame.this, EarnMoney_82.class));
        }

    }


    @Override 
    public void onResume() {
        registerReceiver(this.br, new IntentFilter(getPackageName()));
        realmoney_23.activity = this;
        TextView textView = this.atv_coin_value;
        textView.setText("" + this.myMoney.getPref(MyMoney.POINTS, 0));
        TextView textView2 = this.atv_slot_left_value;
        textView2.setText("" + this.myMoney.getPref(MyMoney.SLOT_LEFT, 0));


        if (this.myMoney.getPref(MyMoney.SPIN_LEFT, 0).intValue() == 0) {
            Disable();
        } else {
            Enable();
        }

        String pref = this.myMoney.getPref(MyMoney.AFTER_TWO_HOUR_SLOT, "");
        if (!pref.equalsIgnoreCase("")) {
            Date date = null;
            try {
                date = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).parse(pref);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            if (System.currentTimeMillis() > date.getTime()) {
                this.myMoney.setPref(MyMoney.AFTER_TWO_HOUR_SLOT, "");
                this.myMoney.setPref(MyMoney.SLOT_LEFT, 5);
                TextView textView3 = this.atv_slot_left_value;
                textView3.setText("" + this.myMoney.getPref(MyMoney.SLOT_LEFT, 0));
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
