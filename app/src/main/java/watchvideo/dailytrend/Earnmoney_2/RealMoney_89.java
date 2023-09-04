package watchvideo.dailytrend.Earnmoney_2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import watchvideo.dailytrend.Earnmoney.earnmoney;

import watchvideo.dailytrend.Earnmoney.realmoney14;
import watchvideo.dailytrend.Earnmoney.realmoney12;
import watchvideo.dailytrend.Earnmoney.realmoney21;
import watchvideo.dailytrend.MyMoney;
import watchvideo.dailytrend.R;

public class RealMoney_89 extends AppCompatActivity implements View.OnClickListener {
    Animation animation;
    TextView atv_coin_value;
    private boolean mCustomTabsOpened = false;
    MyMoney myMoney;
    ImageView rl_amazon_gift;
    ImageView rl_google_play_gift;
    ImageView rl_itunes_gift;
    ImageView rl_paypal_gift;
    private ImageView rl_paytm_gift;
    ImageView rl_play_station_gift;
    ImageView rl_steam_wallet_gift;
    ImageView rl_visa_gift;
    ImageView rl_xbox_gift;

    @Override 
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.earnsmoney);
        getWindow().setFlags(1024, 1024);

        ((ImageView) findViewById(R.id.ivback)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (earnmoney.isAdOn) {
                    if (earnmoney.ad_mode.equalsIgnoreCase("admob")) {
                        if (realmoney12.isInternetOn(RealMoney_89.this)) {
                            realmoney12.getInstance().loadintertialads(RealMoney_89.this, earnmoney.admob_inter_id, new realmoney12.MyCallback() {
                                @Override
                                public void callbackCall() {
                                    startActivity(new Intent(RealMoney_89.this, EarnMoney_82.class));
                                }
                            });
                        } else {
                            startActivity(new Intent(RealMoney_89.this, EarnMoney_82.class));
                        }

                    } else if (earnmoney.ad_mode.equalsIgnoreCase("qureka")) {

                        realmoney14.getInstance().qureka_inter(RealMoney_89.this, new realmoney14.MyCallback() {
                            @Override
                            public void callbackCall() {
                                startActivity(new Intent(RealMoney_89.this, EarnMoney_82.class));
                            }
                        });

                    } else {

                        if (realmoney21.isInternetOn(RealMoney_89.this)) {
                            realmoney21.getInstance().loadintertialads(RealMoney_89.this, earnmoney.facebook_inter_id, new realmoney21.MyCallback() {
                                @Override
                                public void callbackCall() {
                                    startActivity(new Intent(RealMoney_89.this, EarnMoney_82.class));
                                }
                            });
                        } else {
                            startActivity(new Intent(RealMoney_89.this, EarnMoney_82.class));
                        }
                    }
                } else {
                    startActivity(new Intent(RealMoney_89.this, EarnMoney_82.class));
                }
            }
        });

        this.animation = AnimationUtils.loadAnimation(this, R.anim.moneyapp);
        this.myMoney = new MyMoney(this);
        this.atv_coin_value = (TextView) findViewById(R.id.atv_coin_value);
        ImageView imageView = (ImageView) findViewById(R.id.rl_amazon_gift);
        this.rl_amazon_gift = imageView;
        imageView.setOnClickListener(this);
        ImageView imageView2 = (ImageView) findViewById(R.id.rl_google_play_gift);
        this.rl_google_play_gift = imageView2;
        imageView2.setOnClickListener(this);
        ImageView imageView3 = (ImageView) findViewById(R.id.rl_itunes_gift);
        this.rl_itunes_gift = imageView3;
        imageView3.setOnClickListener(this);
        ImageView imageView4 = (ImageView) findViewById(R.id.rl_visa_gift);
        this.rl_visa_gift = imageView4;
        imageView4.setOnClickListener(this);
        ImageView imageView5 = (ImageView) findViewById(R.id.rl_steam_wallet_gift);
        this.rl_steam_wallet_gift = imageView5;
        imageView5.setOnClickListener(this);
        ImageView imageView6 = (ImageView) findViewById(R.id.rl_play_station_gift);
        this.rl_play_station_gift = imageView6;
        imageView6.setOnClickListener(this);
        ImageView imageView7 = (ImageView) findViewById(R.id.rl_xbox_gift);
        this.rl_xbox_gift = imageView7;
        imageView7.setOnClickListener(this);
        ImageView imageView8 = (ImageView) findViewById(R.id.rl_paypal_gift);
        this.rl_paypal_gift = imageView8;
        imageView8.setOnClickListener(this);
        ImageView imageView9 = (ImageView) findViewById(R.id.rl_paytm_gift);
        this.rl_paytm_gift = imageView9;
        imageView9.setOnClickListener(this);

    }

    @Override 
    public void onClick(View view) {
        view.startAnimation(this.animation);
        switch (view.getId()) {
            case R.id.rl_amazon_gift :
                RedeemPaypalScreen("Amazon");
                return;
            case R.id.rl_google_play_gift :
                RedeemPaypalScreen("Google_Play");
                return;
            case R.id.rl_itunes_gift :
                RedeemPaypalScreen("Itunes");
                return;
            case R.id.rl_paypal_gift :
                RedeemPaypalScreen("Paypal");
                return;
            case R.id.rl_paytm_gift :
                RedeemPaypalScreen("Paytm");
                return;
            case R.id.rl_play_station_gift :
                RedeemPaypalScreen("Play_Station");
                return;
            case R.id.rl_steam_wallet_gift :
                RedeemPaypalScreen("Steam_Wallet");
                return;
            case R.id.rl_visa_gift :
                RedeemPaypalScreen("Visa");
                return;
            case R.id.rl_xbox_gift :
                RedeemPaypalScreen("Xbox");
                return;
            default:
                return;
        }
    }


    public void RedeemPaypalScreen(final String str) {

        if (earnmoney.isAdOn) {
            if (earnmoney.ad_mode.equalsIgnoreCase("admob")) {
                if (realmoney12.isInternetOn(RealMoney_89.this)) {
                    realmoney12.getInstance().loadintertialads(RealMoney_89.this, earnmoney.admob_inter_id, new realmoney12.MyCallback() {
                        @Override
                        public void callbackCall() {
                            Intent intent = new Intent(RealMoney_89.this, RealMoney_90.class);
                            intent.putExtra("is_from", str);
                            startActivity(intent);
                        }
                    });
                } else {
                    Intent intent = new Intent(RealMoney_89.this, RealMoney_90.class);
                    intent.putExtra("is_from", str);
                    startActivity(intent);
                }

            } else if (earnmoney.ad_mode.equalsIgnoreCase("qureka")) {

                realmoney14.getInstance().qureka_inter(RealMoney_89.this, new realmoney14.MyCallback() {
                    @Override
                    public void callbackCall() {
                        Intent intent = new Intent(RealMoney_89.this, RealMoney_90.class);
                        intent.putExtra("is_from", str);
                        startActivity(intent);
                    }
                });

            } else {

                if (realmoney21.isInternetOn(RealMoney_89.this)) {
                    realmoney21.getInstance().loadintertialads(RealMoney_89.this, earnmoney.facebook_inter_id, new realmoney21.MyCallback() {
                        @Override
                        public void callbackCall() {
                            Intent intent = new Intent(RealMoney_89.this, RealMoney_90.class);
                            intent.putExtra("is_from", str);
                            startActivity(intent);
                        }
                    });
                } else {
                    Intent intent = new Intent(RealMoney_89.this, RealMoney_90.class);
                    intent.putExtra("is_from", str);
                    startActivity(intent);
                }
            }

        } else {
            Intent intent = new Intent(RealMoney_89.this, RealMoney_90.class);
            intent.putExtra("is_from", str);
            startActivity(intent);
        }

    }


    @Override 
    public void onBackPressed() {
        if (earnmoney.isAdOn) {
            if (earnmoney.ad_mode.equalsIgnoreCase("admob")) {
                if (realmoney12.isInternetOn(RealMoney_89.this)) {
                    realmoney12.getInstance().loadintertialads(RealMoney_89.this, earnmoney.admob_inter_id, new realmoney12.MyCallback() {
                        @Override
                        public void callbackCall() {
                            startActivity(new Intent(RealMoney_89.this, EarnMoney_82.class));
                        }
                    });
                } else {
                    startActivity(new Intent(RealMoney_89.this, EarnMoney_82.class));
                }

            } else if (earnmoney.ad_mode.equalsIgnoreCase("qureka")) {

                realmoney14.getInstance().qureka_inter(RealMoney_89.this, new realmoney14.MyCallback() {
                    @Override
                    public void callbackCall() {
                        startActivity(new Intent(RealMoney_89.this, EarnMoney_82.class));
                    }
                });

            } else {

                if (realmoney21.isInternetOn(RealMoney_89.this)) {
                    realmoney21.getInstance().loadintertialads(RealMoney_89.this, earnmoney.facebook_inter_id, new realmoney21.MyCallback() {
                        @Override
                        public void callbackCall() {
                            startActivity(new Intent(RealMoney_89.this, EarnMoney_82.class));
                        }
                    });
                } else {
                    startActivity(new Intent(RealMoney_89.this, EarnMoney_82.class));
                }
            }
        } else {
            startActivity(new Intent(RealMoney_89.this, EarnMoney_82.class));
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
