package watchvideo.dailytrend.Earnmoney_2;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import watchvideo.dailytrend.MyMoney;
import watchvideo.dailytrend.realmoney_24;
import watchvideo.dailytrend.R;

public class RealMoney_91 extends AppCompatActivity implements View.OnClickListener {
    boolean back = false;
    TextView btn_get_money;
    public CheckBox chk1;
    public CheckBox chk2;
    public CheckBox chk3;
    public CheckBox chk4;
    public CheckBox chk5;
    boolean click = false;
    public Handler handler = new Handler();
    private boolean mCustomTabsOpened = false;
    int money;
    MyMoney myMoney;
    ProgressBar progressBar;
    public int progressStatus = 0;

    @Override 
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(1024, 1024);
        setContentView(R.layout.earnmoneyappearnmoney);
        this.myMoney = new MyMoney(this);
        this.money = getIntent().getIntExtra("money", 0);
        ((TextView) findViewById(R.id.btn_get_money)).setOnClickListener(this);
        this.btn_get_money.setTypeface(realmoney_24.ChangeTypeFaceITCKabelStd(this));
        this.chk1 = (CheckBox) findViewById(R.id.checkBox1);
        this.chk2 = (CheckBox) findViewById(R.id.checkBox2);
        this.chk3 = (CheckBox) findViewById(R.id.checkBox3);
        this.chk4 = (CheckBox) findViewById(R.id.checkBox4);
        this.chk5 = (CheckBox) findViewById(R.id.checkBox5);
        this.progressBar = (ProgressBar) findViewById(R.id.progressBar1);
        this.progressStatus = 0;
        final ProgressBarAnimation progressBarAnimation = new ProgressBarAnimation(this.progressBar, 1000);
        new Thread(new Runnable() {

            @Override
            public void run() {
                while (RealMoney_91.this.progressStatus < 100) {
                    RealMoney_91.this.progressStatus += 5;
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    RealMoney_91.this.handler.post(new Runnable() {

                        @Override
                        public void run() {
                            progressBarAnimation.setProgress(RealMoney_91.this.progressStatus);
                            if (RealMoney_91.this.progressStatus == 20) {
                                RealMoney_91.this.chk1.setButtonDrawable(R.drawable.real_money6);
                            }
                            if (RealMoney_91.this.progressStatus == 40) {
                                RealMoney_91.this.chk2.setButtonDrawable(R.drawable.real_money6);
                            }
                            if (RealMoney_91.this.progressStatus == 60) {
                                RealMoney_91.this.chk3.setButtonDrawable(R.drawable.real_money6);
                            }
                            if (RealMoney_91.this.progressStatus == 75) {
                                RealMoney_91.this.chk4.setButtonDrawable(R.drawable.real_money6);
                            }
                            if (RealMoney_91.this.progressStatus == 90) {
                                RealMoney_91.this.chk5.setButtonDrawable(R.drawable.real_money6);
                            }
                            if (RealMoney_91.this.progressStatus == 100) {
                                RealMoney_91.this.btn_get_money.setVisibility(0);
                            }
                            Log.e("showprog", "" + RealMoney_91.this.progressStatus);
                        }
                    });
                }
            }
        }).start();
    }

    @Override 
    public void onClick(View view) {
        if (view.getId() == R.id.btn_get_money) {
            this.click = true;
            this.back = false;
            NextScreen();
        }
    }

    public class ProgressBarAnimation extends Animation {
        private int mFrom;
        private ProgressBar mProgressBar;
        private long mStepDuration;
        private int mTo;

        public ProgressBarAnimation(ProgressBar progressBar, long j) {
            this.mProgressBar = progressBar;
            this.mStepDuration = j / ((long) progressBar.getMax());
        }

        public void setProgress(int i) {
            if (i < 0) {
                i = 0;
            }
            if (i > this.mProgressBar.getMax()) {
                i = this.mProgressBar.getMax();
            }
            this.mTo = i;
            int progress = this.mProgressBar.getProgress();
            this.mFrom = progress;
            setDuration(((long) Math.abs(this.mTo - progress)) * this.mStepDuration);
            this.mProgressBar.startAnimation(this);
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f, Transformation transformation) {
            int i = this.mFrom;
            this.mProgressBar.setProgress((int) (((float) i) + (((float) (this.mTo - i)) * f)));
        }
    }

    public void PaymentDoneScreen() {
        Calculate_Point();
        startActivity(new Intent(this, RealMoney_87.class));
        finish();
    }

    public void Calculate_Point() {
        int intValue = this.myMoney.getPref(MyMoney.POINTS, 0).intValue();
        int i = this.money;
        if (i == 350) {
            if (intValue > 60000) {
                this.myMoney.setPref(MyMoney.POINTS, intValue - 60000);
            } else {
                this.myMoney.setPref(MyMoney.POINTS, 0);
            }
        } else if (i == 800) {
            if (intValue > 70000) {
                this.myMoney.setPref(MyMoney.POINTS, intValue - 70000);
            } else {
                this.myMoney.setPref(MyMoney.POINTS, 0);
            }
        } else if (i == 1350) {
            if (intValue > 80000) {
                this.myMoney.setPref(MyMoney.POINTS, intValue - 80000);
            } else {
                this.myMoney.setPref(MyMoney.POINTS, 0);
            }
        } else if (i == 1600) {
            if (intValue > 90000) {
                this.myMoney.setPref(MyMoney.POINTS, intValue - 90000);
            } else {
                this.myMoney.setPref(MyMoney.POINTS, 0);
            }
        } else if (i == 2150) {
            if (intValue > 100000) {
                this.myMoney.setPref(MyMoney.POINTS, intValue - 100000);
            } else {
                this.myMoney.setPref(MyMoney.POINTS, 0);
            }
        } else if (i == 2600) {
            if (intValue > 110000) {
                this.myMoney.setPref(MyMoney.POINTS, intValue - 110000);
            } else {
                this.myMoney.setPref(MyMoney.POINTS, 0);
            }
        } else if (i == 5000) {
            if (intValue > 135000) {
                this.myMoney.setPref(MyMoney.POINTS, intValue - 135000);
            } else {
                this.myMoney.setPref(MyMoney.POINTS, 0);
            }
        } else if (i == 7500) {
            if (intValue > 150000) {
                this.myMoney.setPref(MyMoney.POINTS, intValue - 150000);
            } else {
                this.myMoney.setPref(MyMoney.POINTS, 0);
            }
        } else if (i == 10000) {
            if (intValue > 175000) {
                this.myMoney.setPref(MyMoney.POINTS, intValue - 175000);
            } else {
                this.myMoney.setPref(MyMoney.POINTS, 0);
            }
        } else if (i != 20000) {
        } else {
            if (intValue > 200000) {
                this.myMoney.setPref(MyMoney.POINTS, intValue - 200000);
            } else {
                this.myMoney.setPref(MyMoney.POINTS, 0);
            }
        }
    }

    @Override 
    public void onBackPressed() {
        this.back = true;
        this.click = false;
        super.onBackPressed();
    }

    @Override 
    public void onResume() {
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

    public void NextScreen() {
        if (this.back) {
            finish();
        } else if (this.click) {
            PaymentDoneScreen();
        }
    }
}
