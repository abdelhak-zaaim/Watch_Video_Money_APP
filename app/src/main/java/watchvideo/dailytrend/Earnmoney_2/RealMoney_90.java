package watchvideo.dailytrend.Earnmoney_2;

import android.app.Dialog;
import android.content.Intent;
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

public class RealMoney_90 extends AppCompatActivity implements View.OnClickListener {

    int actual_point;
    TextView atv_1;
    TextView atv_10;
    TextView atv_2;
    TextView atv_3;
    TextView atv_4;
    TextView atv_5;
    TextView atv_6;
    TextView atv_7;
    TextView atv_8;
    TextView atv_9;
    TextView atv_coin_value;
    boolean back = false;
    boolean click = false;
    public Dialog dialog;
    String is_from;
    ImageView iv_1;
    ImageView iv_10;
    ImageView iv_2;
    ImageView iv_3;
    ImageView iv_4;
    ImageView iv_5;
    ImageView iv_6;
    ImageView iv_7;
    ImageView iv_8;
    ImageView iv_9;
    private boolean mCustomTabsOpened = false;
    int mo_ney;
    MyMoney myMoney;
    int remaining_point;
    RelativeLayout rl_1;
    RelativeLayout rl_10;
    RelativeLayout rl_2;
    RelativeLayout rl_3;
    RelativeLayout rl_4;
    RelativeLayout rl_5;
    RelativeLayout rl_6;
    RelativeLayout rl_7;
    RelativeLayout rl_8;
    RelativeLayout rl_9;


    @Override 
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.moneyreal);
        getWindow().setFlags(1024, 1024);
        this.myMoney = new MyMoney(this);

        ((ImageView) findViewById(R.id.ivback)).setOnClickListener(new View.OnClickListener() {
            @Override 
            public void onClick(View view) {
                if (earnmoney.isAdOn) {
                    if (earnmoney.ad_mode.equalsIgnoreCase("admob")) {
                        if (realmoney12.isInternetOn(RealMoney_90.this)) {
                            realmoney12.getInstance().loadintertialads(RealMoney_90.this, earnmoney.admob_inter_id, new realmoney12.MyCallback() {
                                @Override
                                public void callbackCall() {
                                    startActivity(new Intent(RealMoney_90.this, RealMoney_89.class));
                                }
                            });
                        } else {
                            startActivity(new Intent(RealMoney_90.this, RealMoney_89.class));
                        }

                    } else if (earnmoney.ad_mode.equalsIgnoreCase("qureka")) {

                        realmoney14.getInstance().qureka_inter(RealMoney_90.this, new realmoney14.MyCallback() {
                            @Override
                            public void callbackCall() {
                                startActivity(new Intent(RealMoney_90.this, RealMoney_89.class));
                            }
                        });

                    } else {

                        if (realmoney21.isInternetOn(RealMoney_90.this)) {
                            realmoney21.getInstance().loadintertialads(RealMoney_90.this, earnmoney.facebook_inter_id, new realmoney21.MyCallback() {
                                @Override
                                public void callbackCall() {
                                    startActivity(new Intent(RealMoney_90.this, RealMoney_89.class));
                                }
                            });
                        } else {
                            startActivity(new Intent(RealMoney_90.this, RealMoney_89.class));
                        }
                    }
                } else {
                    startActivity(new Intent(RealMoney_90.this, RealMoney_89.class));
                }
             }
        });

        this.atv_coin_value = (TextView) findViewById(R.id.atv_coin_value);
        this.is_from = getIntent().getStringExtra("is_from");
        init();

    }


    @Override 
    public void onResume() {

        try {
            TextView textView = this.atv_coin_value;
            textView.setText("" + this.myMoney.getPref(MyMoney.POINTS, 0));
        } catch (IllegalStateException unused) {
        }
        super.onResume();
        if (this.mCustomTabsOpened) {
            this.mCustomTabsOpened = false;
            finish();
        }

    }


    @Override 
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.rl_1 :
                int intValue = this.myMoney.getPref(MyMoney.POINTS, 0).intValue();
                this.actual_point = intValue;
                if (intValue >= 60000) {
                    RedeemProcessScreen(350);
                    return;
                }
                this.remaining_point = 60000 - intValue;
                SorryDialog("" + this.remaining_point, "350");
                return;

            case R.id.rl_10 :
                int intValue2 = this.myMoney.getPref(MyMoney.POINTS, 0).intValue();
                this.actual_point = intValue2;
                if (intValue2 >= 200000) {
                    RedeemProcessScreen(20000);
                    return;
                }
                this.remaining_point = 200000 - intValue2;
                SorryDialog("" + this.remaining_point, "20000");
                return;

            default:
                switch (id) {
                    case R.id.rl_2 :
                        int intValue3 = this.myMoney.getPref(MyMoney.POINTS, 0).intValue();
                        this.actual_point = intValue3;
                        if (intValue3 >= 70000) {
                            RedeemProcessScreen(800);
                            return;
                        }
                        this.remaining_point = 70000 - intValue3;
                        SorryDialog("" + this.remaining_point, "800");
                        return;

                    case R.id.rl_3 :
                        int intValue4 = this.myMoney.getPref(MyMoney.POINTS, 0).intValue();
                        this.actual_point = intValue4;
                        if (intValue4 >= 80000) {
                            RedeemProcessScreen(1350);
                            return;
                        }
                        this.remaining_point = 80000 - intValue4;
                        SorryDialog("" + this.remaining_point, "1350");
                        return;

                    case R.id.rl_4 :
                        int intValue5 = this.myMoney.getPref(MyMoney.POINTS, 0).intValue();
                        this.actual_point = intValue5;
                        if (intValue5 >= 90000) {
                            RedeemProcessScreen(1600);
                            return;
                        }
                        this.remaining_point = 90000 - intValue5;
                        SorryDialog("" + this.remaining_point, "1600");
                        return;

                    case R.id.rl_5 :
                        int intValue6 = this.myMoney.getPref(MyMoney.POINTS, 0).intValue();
                        this.actual_point = intValue6;
                        if (intValue6 >= 100000) {
                            RedeemProcessScreen(2150);
                            return;
                        }
                        this.remaining_point = 100000 - intValue6;
                        SorryDialog("" + this.remaining_point, "2150");
                        return;

                    case R.id.rl_6 :
                        int intValue7 = this.myMoney.getPref(MyMoney.POINTS, 0).intValue();
                        this.actual_point = intValue7;
                        if (intValue7 >= 110000) {
                            RedeemProcessScreen(2600);
                            return;
                        }
                        this.remaining_point = 110000 - intValue7;
                        SorryDialog("" + this.remaining_point, "2600");
                        return;

                    case R.id.rl_7 :
                        int intValue8 = this.myMoney.getPref(MyMoney.POINTS, 0).intValue();
                        this.actual_point = intValue8;
                        if (intValue8 >= 135000) {
                            RedeemProcessScreen(5000);
                            return;
                        }
                        this.remaining_point = 135000 - intValue8;
                        SorryDialog("" + this.remaining_point, "5000");
                        return;

                    case R.id.rl_8 :
                        int intValue9 = this.myMoney.getPref(MyMoney.POINTS, 0).intValue();
                        this.actual_point = intValue9;
                        if (intValue9 >= 150000) {
                            RedeemProcessScreen(7500);
                            return;
                        }
                        this.remaining_point = 150000 - intValue9;
                        SorryDialog("" + this.remaining_point, "7500");
                        return;

                    case R.id.rl_9 :
                        int intValue10 = this.myMoney.getPref(MyMoney.POINTS, 0).intValue();
                        this.actual_point = intValue10;
                        if (intValue10 >= 175000) {
                            RedeemProcessScreen(10000);
                            return;
                        }
                        this.remaining_point = 175000 - intValue10;
                        SorryDialog("" + this.remaining_point, "10000");
                        return;

                    default:
                        return;

                }
        }
    }


    @Override 
    public void onBackPressed() {

        if (earnmoney.isAdOn) {
            if (earnmoney.ad_mode.equalsIgnoreCase("admob")) {
                if (realmoney12.isInternetOn(RealMoney_90.this)) {
                    realmoney12.getInstance().loadintertialads(RealMoney_90.this, earnmoney.admob_inter_id, new realmoney12.MyCallback() {
                        @Override
                        public void callbackCall() {
                            back = true;
                            click = false;
                            mo_ney = 0;
                            startActivity(new Intent(RealMoney_90.this, RealMoney_89.class));
                        }
                    });
                } else {
                    back = true;
                    click = false;
                    mo_ney = 0;
                    startActivity(new Intent(RealMoney_90.this, RealMoney_89.class));
                }

            } else if (earnmoney.ad_mode.equalsIgnoreCase("qureka")) {

                realmoney14.getInstance().qureka_inter(RealMoney_90.this, new realmoney14.MyCallback() {
                    @Override
                    public void callbackCall() {
                        back = true;
                        click = false;
                        mo_ney = 0;
                        startActivity(new Intent(RealMoney_90.this, RealMoney_89.class));
                    }
                });

            } else {

                if (realmoney21.isInternetOn(RealMoney_90.this)) {
                    realmoney21.getInstance().loadintertialads(RealMoney_90.this, earnmoney.facebook_inter_id, new realmoney21.MyCallback() {
                        @Override
                        public void callbackCall() {
                            back = true;
                            click = false;
                            mo_ney = 0;
                            startActivity(new Intent(RealMoney_90.this, RealMoney_89.class));
                        }
                    });
                } else {
                    back = true;
                    click = false;
                    mo_ney = 0;
                    startActivity(new Intent(RealMoney_90.this, RealMoney_89.class));
                }
            }
        } else {
            back = true;
            click = false;
            mo_ney = 0;
            startActivity(new Intent(RealMoney_90.this, RealMoney_89.class));
        }
    }


    public void init() {
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.rl_1);
        this.rl_1 = relativeLayout;
        relativeLayout.setOnClickListener(this);
        this.iv_1 = (ImageView) findViewById(R.id.iv_1);
        this.atv_1 = (TextView) findViewById(R.id.atv_1);
        RelativeLayout relativeLayout2 = (RelativeLayout) findViewById(R.id.rl_2);
        this.rl_2 = relativeLayout2;
        relativeLayout2.setOnClickListener(this);
        this.iv_2 = (ImageView) findViewById(R.id.iv_2);
        this.atv_2 = (TextView) findViewById(R.id.atv_2);
        RelativeLayout relativeLayout3 = (RelativeLayout) findViewById(R.id.rl_3);
        this.rl_3 = relativeLayout3;
        relativeLayout3.setOnClickListener(this);
        this.iv_3 = (ImageView) findViewById(R.id.iv_3);
        this.atv_3 = (TextView) findViewById(R.id.atv_3);
        RelativeLayout relativeLayout4 = (RelativeLayout) findViewById(R.id.rl_4);
        this.rl_4 = relativeLayout4;
        relativeLayout4.setOnClickListener(this);
        this.iv_4 = (ImageView) findViewById(R.id.iv_4);
        this.atv_4 = (TextView) findViewById(R.id.atv_4);
        RelativeLayout relativeLayout5 = (RelativeLayout) findViewById(R.id.rl_5);
        this.rl_5 = relativeLayout5;
        relativeLayout5.setOnClickListener(this);
        this.iv_5 = (ImageView) findViewById(R.id.iv_5);
        this.atv_5 = (TextView) findViewById(R.id.atv_5);
        RelativeLayout relativeLayout6 = (RelativeLayout) findViewById(R.id.rl_6);
        this.rl_6 = relativeLayout6;
        relativeLayout6.setOnClickListener(this);
        this.iv_6 = (ImageView) findViewById(R.id.iv_6);
        this.atv_6 = (TextView) findViewById(R.id.atv_6);
        RelativeLayout relativeLayout7 = (RelativeLayout) findViewById(R.id.rl_7);
        this.rl_7 = relativeLayout7;
        relativeLayout7.setOnClickListener(this);
        this.iv_7 = (ImageView) findViewById(R.id.iv_7);
        this.atv_7 = (TextView) findViewById(R.id.atv_7);
        RelativeLayout relativeLayout8 = (RelativeLayout) findViewById(R.id.rl_8);
        this.rl_8 = relativeLayout8;
        relativeLayout8.setOnClickListener(this);
        this.iv_8 = (ImageView) findViewById(R.id.iv_8);
        this.atv_8 = (TextView) findViewById(R.id.atv_8);
        RelativeLayout relativeLayout9 = (RelativeLayout) findViewById(R.id.rl_9);
        this.rl_9 = relativeLayout9;
        relativeLayout9.setOnClickListener(this);
        this.iv_9 = (ImageView) findViewById(R.id.iv_9);
        this.atv_9 = (TextView) findViewById(R.id.atv_9);
        RelativeLayout relativeLayout10 = (RelativeLayout) findViewById(R.id.rl_10);
        this.rl_10 = relativeLayout10;
        relativeLayout10.setOnClickListener(this);
        this.iv_10 = (ImageView) findViewById(R.id.iv_10);
        this.atv_10 = (TextView) findViewById(R.id.atv_10);


        if (this.is_from.equalsIgnoreCase("Amazon")) {
            this.iv_1.setImageResource(R.drawable.earnmoney4);
            this.atv_1.setText(R.string.amazon_gift_card);
            this.iv_2.setImageResource(R.drawable.earnmoney4);
            this.atv_2.setText(R.string.amazon_gift_card);
            this.iv_3.setImageResource(R.drawable.earnmoney4);
            this.atv_3.setText(R.string.amazon_gift_card);
            this.iv_4.setImageResource(R.drawable.earnmoney4);
            this.atv_4.setText(R.string.amazon_gift_card);
            this.iv_5.setImageResource(R.drawable.earnmoney4);
            this.atv_5.setText(R.string.amazon_gift_card);
            this.iv_6.setImageResource(R.drawable.earnmoney4);
            this.atv_6.setText(R.string.amazon_gift_card);
            this.iv_7.setImageResource(R.drawable.earnmoney4);
            this.atv_7.setText(R.string.amazon_gift_card);
            this.iv_8.setImageResource(R.drawable.earnmoney4);
            this.atv_8.setText(R.string.amazon_gift_card);
            this.iv_9.setImageResource(R.drawable.earnmoney4);
            this.atv_9.setText(R.string.amazon_gift_card);
            this.iv_10.setImageResource(R.drawable.earnmoney4);
            this.atv_10.setText(R.string.amazon_gift_card);
        } else if (this.is_from.equalsIgnoreCase("Google_Play")) {
            this.iv_1.setImageResource(R.drawable.realmoney_131);
            this.atv_1.setText(R.string.google_play_gift_card);
            this.iv_2.setImageResource(R.drawable.realmoney_131);
            this.atv_2.setText(R.string.google_play_gift_card);
            this.iv_3.setImageResource(R.drawable.realmoney_131);
            this.atv_3.setText(R.string.google_play_gift_card);
            this.iv_4.setImageResource(R.drawable.realmoney_131);
            this.atv_4.setText(R.string.google_play_gift_card);
            this.iv_5.setImageResource(R.drawable.realmoney_131);
            this.atv_5.setText(R.string.google_play_gift_card);
            this.iv_6.setImageResource(R.drawable.realmoney_131);
            this.atv_6.setText(R.string.google_play_gift_card);
            this.iv_7.setImageResource(R.drawable.realmoney_131);
            this.atv_7.setText(R.string.google_play_gift_card);
            this.iv_8.setImageResource(R.drawable.realmoney_131);
            this.atv_8.setText(R.string.google_play_gift_card);
            this.iv_9.setImageResource(R.drawable.realmoney_131);
            this.atv_9.setText(R.string.google_play_gift_card);
            this.iv_10.setImageResource(R.drawable.realmoney_131);
            this.atv_10.setText(R.string.google_play_gift_card);
        } else if (this.is_from.equalsIgnoreCase("Itunes")) {
            this.iv_1.setImageResource(R.drawable.watchvideoearnmoney_11);
            this.atv_1.setText(R.string.itunes_gift_card);
            this.iv_2.setImageResource(R.drawable.watchvideoearnmoney_11);
            this.atv_2.setText(R.string.itunes_gift_card);
            this.iv_3.setImageResource(R.drawable.watchvideoearnmoney_11);
            this.atv_3.setText(R.string.itunes_gift_card);
            this.iv_4.setImageResource(R.drawable.watchvideoearnmoney_11);
            this.atv_4.setText(R.string.itunes_gift_card);
            this.iv_5.setImageResource(R.drawable.watchvideoearnmoney_11);
            this.atv_5.setText(R.string.itunes_gift_card);
            this.iv_6.setImageResource(R.drawable.watchvideoearnmoney_11);
            this.atv_6.setText(R.string.itunes_gift_card);
            this.iv_7.setImageResource(R.drawable.watchvideoearnmoney_11);
            this.atv_7.setText(R.string.itunes_gift_card);
            this.iv_8.setImageResource(R.drawable.watchvideoearnmoney_11);
            this.atv_8.setText(R.string.itunes_gift_card);
            this.iv_9.setImageResource(R.drawable.watchvideoearnmoney_11);
            this.atv_9.setText(R.string.itunes_gift_card);
            this.iv_10.setImageResource(R.drawable.watchvideoearnmoney_11);
            this.atv_10.setText(R.string.itunes_gift_card);
        } else if (this.is_from.equalsIgnoreCase("Visa")) {
            this.iv_1.setImageResource(R.drawable.earnmoney_130);
            this.atv_1.setText(R.string.visa_gift_card);
            this.iv_2.setImageResource(R.drawable.earnmoney_130);
            this.atv_2.setText(R.string.visa_gift_card);
            this.iv_3.setImageResource(R.drawable.earnmoney_130);
            this.atv_3.setText(R.string.visa_gift_card);
            this.iv_4.setImageResource(R.drawable.earnmoney_130);
            this.atv_4.setText(R.string.visa_gift_card);
            this.iv_5.setImageResource(R.drawable.earnmoney_130);
            this.atv_5.setText(R.string.visa_gift_card);
            this.iv_6.setImageResource(R.drawable.earnmoney_130);
            this.atv_6.setText(R.string.visa_gift_card);
            this.iv_7.setImageResource(R.drawable.earnmoney_130);
            this.atv_7.setText(R.string.visa_gift_card);
            this.iv_8.setImageResource(R.drawable.earnmoney_130);
            this.atv_8.setText(R.string.visa_gift_card);
            this.iv_9.setImageResource(R.drawable.earnmoney_130);
            this.atv_9.setText(R.string.visa_gift_card);
            this.iv_10.setImageResource(R.drawable.earnmoney_130);
            this.atv_10.setText(R.string.visa_gift_card);
        } else if (this.is_from.equalsIgnoreCase("Steam_Wallet")) {
            this.iv_1.setImageResource(R.drawable.dailyearnmoney_10);
            this.atv_1.setText(R.string.steam_wallet_gift_card);
            this.iv_2.setImageResource(R.drawable.dailyearnmoney_10);
            this.atv_2.setText(R.string.steam_wallet_gift_card);
            this.iv_3.setImageResource(R.drawable.dailyearnmoney_10);
            this.atv_3.setText(R.string.steam_wallet_gift_card);
            this.iv_4.setImageResource(R.drawable.dailyearnmoney_10);
            this.atv_4.setText(R.string.steam_wallet_gift_card);
            this.iv_5.setImageResource(R.drawable.dailyearnmoney_10);
            this.atv_5.setText(R.string.steam_wallet_gift_card);
            this.iv_6.setImageResource(R.drawable.dailyearnmoney_10);
            this.atv_6.setText(R.string.steam_wallet_gift_card);
            this.iv_7.setImageResource(R.drawable.dailyearnmoney_10);
            this.atv_7.setText(R.string.steam_wallet_gift_card);
            this.iv_8.setImageResource(R.drawable.dailyearnmoney_10);
            this.atv_8.setText(R.string.steam_wallet_gift_card);
            this.iv_9.setImageResource(R.drawable.dailyearnmoney_10);
            this.atv_9.setText(R.string.steam_wallet_gift_card);
            this.iv_10.setImageResource(R.drawable.dailyearnmoney_10);
            this.atv_10.setText(R.string.steam_wallet_gift_card);
        } else if (this.is_from.equalsIgnoreCase("Play_Station")) {
            this.iv_1.setImageResource(R.drawable.play_station);
            this.atv_1.setText(R.string.play_station_gift_card);
            this.iv_2.setImageResource(R.drawable.play_station);
            this.atv_2.setText(R.string.play_station_gift_card);
            this.iv_3.setImageResource(R.drawable.play_station);
            this.atv_3.setText(R.string.play_station_gift_card);
            this.iv_4.setImageResource(R.drawable.play_station);
            this.atv_4.setText(R.string.play_station_gift_card);
            this.iv_5.setImageResource(R.drawable.play_station);
            this.atv_5.setText(R.string.play_station_gift_card);
            this.iv_6.setImageResource(R.drawable.play_station);
            this.atv_6.setText(R.string.play_station_gift_card);
            this.iv_7.setImageResource(R.drawable.play_station);
            this.atv_7.setText(R.string.play_station_gift_card);
            this.iv_8.setImageResource(R.drawable.play_station);
            this.atv_8.setText(R.string.play_station_gift_card);
            this.iv_9.setImageResource(R.drawable.play_station);
            this.atv_9.setText(R.string.play_station_gift_card);
            this.iv_10.setImageResource(R.drawable.play_station);
            this.atv_10.setText(R.string.play_station_gift_card);
        } else if (this.is_from.equalsIgnoreCase("Xbox")) {
            this.iv_1.setImageResource(R.drawable.watchvideoearnmoney_22);
            this.atv_1.setText(R.string.xbox_gift_card);
            this.iv_2.setImageResource(R.drawable.watchvideoearnmoney_22);
            this.atv_2.setText(R.string.xbox_gift_card);
            this.iv_3.setImageResource(R.drawable.watchvideoearnmoney_22);
            this.atv_3.setText(R.string.xbox_gift_card);
            this.iv_4.setImageResource(R.drawable.watchvideoearnmoney_22);
            this.atv_4.setText(R.string.xbox_gift_card);
            this.iv_5.setImageResource(R.drawable.watchvideoearnmoney_22);
            this.atv_5.setText(R.string.xbox_gift_card);
            this.iv_6.setImageResource(R.drawable.watchvideoearnmoney_22);
            this.atv_6.setText(R.string.xbox_gift_card);
            this.iv_7.setImageResource(R.drawable.watchvideoearnmoney_22);
            this.atv_7.setText(R.string.xbox_gift_card);
            this.iv_8.setImageResource(R.drawable.watchvideoearnmoney_22);
            this.atv_8.setText(R.string.xbox_gift_card);
            this.iv_9.setImageResource(R.drawable.watchvideoearnmoney_22);
            this.atv_9.setText(R.string.xbox_gift_card);
            this.iv_10.setImageResource(R.drawable.watchvideoearnmoney_22);
            this.atv_10.setText(R.string.xbox_gift_card);
        } else if (this.is_from.equalsIgnoreCase("Paypal")) {
            this.iv_1.setImageResource(R.drawable.paypal);
            this.atv_1.setText(R.string.paypal_gift_card);
            this.iv_2.setImageResource(R.drawable.paypal);
            this.atv_2.setText(R.string.paypal_gift_card);
            this.iv_3.setImageResource(R.drawable.paypal);
            this.atv_3.setText(R.string.paypal_gift_card);
            this.iv_4.setImageResource(R.drawable.paypal);
            this.atv_4.setText(R.string.paypal_gift_card);
            this.iv_5.setImageResource(R.drawable.paypal);
            this.atv_5.setText(R.string.paypal_gift_card);
            this.iv_6.setImageResource(R.drawable.paypal);
            this.atv_6.setText(R.string.paypal_gift_card);
            this.iv_7.setImageResource(R.drawable.paypal);
            this.atv_7.setText(R.string.paypal_gift_card);
            this.iv_8.setImageResource(R.drawable.paypal);
            this.atv_8.setText(R.string.paypal_gift_card);
            this.iv_9.setImageResource(R.drawable.paypal);
            this.atv_9.setText(R.string.paypal_gift_card);
            this.iv_10.setImageResource(R.drawable.paypal);
            this.atv_10.setText(R.string.paypal_gift_card);
        } else if (this.is_from.equalsIgnoreCase("Paytm")) {
            this.iv_1.setImageResource(R.drawable.earnmoneywatchvideo_5);
            this.atv_1.setText(R.string.paytm_gift_card);
            this.iv_2.setImageResource(R.drawable.earnmoneywatchvideo_5);
            this.atv_2.setText(R.string.paytm_gift_card);
            this.iv_3.setImageResource(R.drawable.earnmoneywatchvideo_5);
            this.atv_3.setText(R.string.paytm_gift_card);
            this.iv_4.setImageResource(R.drawable.earnmoneywatchvideo_5);
            this.atv_4.setText(R.string.paytm_gift_card);
            this.iv_5.setImageResource(R.drawable.earnmoneywatchvideo_5);
            this.atv_5.setText(R.string.paytm_gift_card);
            this.iv_6.setImageResource(R.drawable.earnmoneywatchvideo_5);
            this.atv_6.setText(R.string.paytm_gift_card);
            this.iv_7.setImageResource(R.drawable.earnmoneywatchvideo_5);
            this.atv_7.setText(R.string.paytm_gift_card);
            this.iv_8.setImageResource(R.drawable.earnmoneywatchvideo_5);
            this.atv_8.setText(R.string.paytm_gift_card);
            this.iv_9.setImageResource(R.drawable.earnmoneywatchvideo_5);
            this.atv_9.setText(R.string.paytm_gift_card);
            this.iv_10.setImageResource(R.drawable.earnmoneywatchvideo_5);
            this.atv_10.setText(R.string.paytm_gift_card);
        }
    }


    private void SorryDialog(String str, String str2) {
        Dialog dialog2 = new Dialog(this, R.style.creativeDialogTheme);
        this.dialog = dialog2;
        dialog2.setContentView(R.layout.watchvideomoney);
        this.dialog.setCancelable(false);
        ((TextView) this.dialog.findViewById(R.id.atv_sorry_title)).setText("Must At Least " + str + " Coin");
        ((TextView) this.dialog.findViewById(R.id.btn_ok)).setOnClickListener(new View.OnClickListener() {
            @Override 
            public void onClick(View view) {
                RealMoney_90.this.dialog.dismiss();
            }
        });
        this.dialog.show();
    }


    public void RedeemProcessScreen(int i) {
        this.click = true;
        this.back = false;
        this.mo_ney = i;
        Intent intent = new Intent(RealMoney_90.this, RealMoney_91.class);
        intent.putExtra("money", RealMoney_90.this.mo_ney);
        RealMoney_90.this.startActivity(intent);
    }


    @Override 
    public void onDestroy() {
        super.onDestroy();
    }


}
