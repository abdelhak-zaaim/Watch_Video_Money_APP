package watchvideo.dailytrend.Earnmoney_2;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import watchvideo.dailytrend.MyMoney;
import watchvideo.dailytrend.realmoney_24;

import watchvideo.dailytrend.BuildConfig;
import watchvideo.dailytrend.R;

@SuppressLint("WrongConstant")

public class EarnMoney_88 extends AppCompatActivity {
    RelativeLayout logout;
    private MyMoney myMoney;
    ImageView next_arrow;
    ImageView next_arrow_age;
    TextView nickname;
    private RelativeLayout rel_name;
    TextView tv_age;
    TextView tv_app_version;
    TextView tv_emailadd;
    TextView tv_gender;
    TextView tv_mobile;

    
    @Override 
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(1024, 1024);
        setContentView(R.layout.earnapp);
        this.myMoney = new MyMoney(this);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.rel_logout);
        this.logout = relativeLayout;

        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override 
            public void onClick(View view) {
                EarnMoney_88.this.exit_Dialog();
            }
        });

        TextView textView = (TextView) findViewById(R.id.tv_nick_name);
        this.nickname = textView;
        textView.setText(this.myMoney.getPref(MyMoney.USER_NAME, "0"));
        TextView textView2 = (TextView) findViewById(R.id.tv_emailadd);
        this.tv_emailadd = textView2;
        textView2.setText(this.myMoney.getPref(MyMoney.EMAIL_ID, "0"));
        TextView textView3 = (TextView) findViewById(R.id.tv_mobile_number);
        this.tv_mobile = textView3;
        textView3.setText(this.myMoney.getPref(MyMoney.MOBILE_NO, "0"));
        TextView textView4 = (TextView) findViewById(R.id.tv_age);
        this.tv_age = textView4;
        textView4.setText(this.myMoney.getPref(MyMoney.AGE, "0"));
        TextView textView5 = (TextView) findViewById(R.id.tv_version);
        this.tv_app_version = textView5;
        textView5.setText(BuildConfig.VERSION_NAME);
        TextView textView6 = (TextView) findViewById(R.id.tv_gender);
        this.tv_gender = textView6;
        textView6.setText(this.myMoney.getPref(MyMoney.GENDER, "Male"));
        ((RelativeLayout) findViewById(R.id.rel_email)).setOnClickListener(new View.OnClickListener() {
            @Override 
            public void onClick(View view) {
                EarnMoney_88.this.ShowDialog_email();
            }
        });

        ((RelativeLayout) findViewById(R.id.rel_gender)).setOnClickListener(new View.OnClickListener() {
            @Override 
            public void onClick(View view) {
                EarnMoney_88.this.choose_gender();
            }
        });

        ((RelativeLayout) findViewById(R.id.rel_mobile)).setOnClickListener(new View.OnClickListener() {
            @Override 
            public void onClick(View view) {
                EarnMoney_88.this.ShowDialog_mobile();
            }
        });

        RelativeLayout relativeLayout2 = (RelativeLayout) findViewById(R.id.rel_name);
        this.rel_name = relativeLayout2;
        relativeLayout2.setOnClickListener(new View.OnClickListener() {
            @Override 
            public void onClick(View view) {
                EarnMoney_88.this.ShowDialog_name();
            }
        });


        ((RelativeLayout) findViewById(R.id.rel_age)).setOnClickListener(new View.OnClickListener() {
            @Override 
            public void onClick(View view) {
                EarnMoney_88.this.ShowDialog_age();
            }
        });

    }


    private void ShowDialog_name() {
        final Dialog dialog = new Dialog(this, R.style.TransparentBackground);
        dialog.setContentView(R.layout.videocallrealmoney);
        TextView textView = (TextView) dialog.findViewById(R.id.btn_ok);
        TextView textView2 = (TextView) dialog.findViewById(R.id.btn_cancel);
        final EditText editText = (EditText) dialog.findViewById(R.id.et_enter_name);
        if (!editText.getText().toString().isEmpty()) {
            editText.setText(editText.getText().toString());
        }


        textView.setOnClickListener(new View.OnClickListener() {
            @Override 
            public void onClick(View view) {
                if (editText.getText().toString().isEmpty()) {
                    realmoney_24.ShowErrorToast(EarnMoney_88.this, "Please Update Your Name.");
                    return;
                }
                EarnMoney_88.this.nickname.setText(editText.getText().toString());
                EarnMoney_88.this.myMoney.setPref(MyMoney.USER_NAME, editText.getText().toString());
                dialog.dismiss();
            }
        });

        textView2.setOnClickListener(new View.OnClickListener() {
            @Override 
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }



    private void ShowDialog_age() {
        final Dialog dialog = new Dialog(this, R.style.TransparentBackground);
        dialog.setContentView(R.layout.spinandwingame);
        TextView textView = (TextView) dialog.findViewById(R.id.btn_ok);
        TextView textView2 = (TextView) dialog.findViewById(R.id.btn_cancel);
        final EditText editText = (EditText) dialog.findViewById(R.id.et_enter_age);
        if (!editText.getText().toString().isEmpty()) {
            editText.setText(editText.getText().toString());
        }

        textView.setOnClickListener(new View.OnClickListener() {
            @Override 
            public void onClick(View view) {
                if (editText.getText().toString().isEmpty()) {
                    realmoney_24.ShowErrorToast(EarnMoney_88.this, "Please Update Your Age.");
                } else if (Integer.parseInt(editText.getText().toString()) > 16) {
                    EarnMoney_88.this.tv_age.setText(editText.getText().toString());
                    EarnMoney_88.this.myMoney.setPref(MyMoney.AGE, editText.getText().toString());
                    dialog.dismiss();
                } else {
                    Toast.makeText(EarnMoney_88.this, "Please Enter 16+ Age", 0).show();
                }
            }
        });

        textView2.setOnClickListener(new View.OnClickListener() {
            @Override 
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        dialog.show();

    }


    private void ShowDialog_email() {
        final Dialog dialog = new Dialog(this, R.style.TransparentBackground);
        dialog.setContentView(R.layout.watchvideoorearnmoney);
        TextView textView = (TextView) dialog.findViewById(R.id.btn_ok);
        TextView textView2 = (TextView) dialog.findViewById(R.id.btn_cancel);
        final EditText editText = (EditText) dialog.findViewById(R.id.et_enter_email);
        if (!editText.getText().toString().isEmpty()) {
            editText.setText(editText.getText().toString());
        }

        textView.setOnClickListener(new View.OnClickListener() {
            @Override 
            public void onClick(View view) {
                if (editText.getText().toString().isEmpty()) {
                    realmoney_24.ShowErrorToast(EarnMoney_88.this, "Please Enter Email.");
                    return;
                }
                EarnMoney_88.this.tv_emailadd.setText(editText.getText().toString());
                EarnMoney_88.this.myMoney.setPref(MyMoney.EMAIL_ID, editText.getText().toString());
                dialog.dismiss();
            }
        });


        textView2.setOnClickListener(new View.OnClickListener() {
            @Override 
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }


    private void ShowDialog_mobile() {
        final Dialog dialog = new Dialog(this, R.style.TransparentBackground);
        dialog.setContentView(R.layout.winandspin);
        TextView textView = (TextView) dialog.findViewById(R.id.btn_ok);
        TextView textView2 = (TextView) dialog.findViewById(R.id.btn_cancel);
        final EditText editText = (EditText) dialog.findViewById(R.id.et_enter_number);
        if (!editText.getText().toString().isEmpty()) {
            editText.setText(editText.getText().toString());
        }

        textView.setOnClickListener(new View.OnClickListener() {
            @Override 
            public void onClick(View view) {
                if (editText.getText().toString().isEmpty()) {
                    realmoney_24.ShowErrorToast(EarnMoney_88.this, "Please Enter number.");
                    return;
                }
                EarnMoney_88.this.tv_mobile.setText(editText.getText().toString());
                EarnMoney_88.this.myMoney.setPref(MyMoney.MOBILE_NO, editText.getText().toString());
                dialog.dismiss();
            }
        });

        textView2.setOnClickListener(new View.OnClickListener() {
            @Override 
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();

    }

    private void choose_gender() {
        final Dialog dialog = new Dialog(this, R.style.TransparentBackground);
        dialog.setContentView(R.layout.onlinerealmoneygame);
        final ImageView imageView = (ImageView) dialog.findViewById(R.id.imgGenderBoy);
        final ImageView imageView2 = (ImageView) dialog.findViewById(R.id.imgGenderGirl);
        ((LinearLayout) dialog.findViewById(R.id.imgConfirm)).setOnClickListener(new View.OnClickListener() {
            @Override 
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        ((ImageView) dialog.findViewById(R.id.imgClose)).setOnClickListener(new View.OnClickListener() {
            @Override 
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        ((FrameLayout) dialog.findViewById(R.id.FLGirl)).setOnClickListener(new View.OnClickListener() {
            @Override 
            public void onClick(View view) {
                imageView.setVisibility(8);
                imageView2.setVisibility(0);
                EarnMoney_88.this.tv_gender.setText("Female");
                EarnMoney_88.this.myMoney.setPref(MyMoney.GENDER, "Female");
            }
        });


        ((FrameLayout) dialog.findViewById(R.id.FLBoy)).setOnClickListener(new View.OnClickListener() {
            @Override 
            public void onClick(View view) {
                imageView.setVisibility(0);
                imageView2.setVisibility(8);
                EarnMoney_88.this.tv_gender.setText("Male");
                EarnMoney_88.this.myMoney.setPref(MyMoney.GENDER, "Male");
            }
        });
        dialog.show();
    }

    private void exit_Dialog() {
        final Dialog dialog = new Dialog(this, R.style.creativeDialogTheme);
        dialog.setContentView(R.layout.spinwin);
        dialog.setCancelable(true);
        ((TextView) dialog.findViewById(R.id.tv_main_text)).setText("Are You Sure You Want To Delete?");
        TextView textView = (TextView) dialog.findViewById(R.id.bt_yes);
        textView.setText("Sure");
        textView.setOnClickListener(new View.OnClickListener() {
            @Override 
            public void onClick(View view) {
                dialog.dismiss();
                Intent intent = new Intent(EarnMoney_88.this, EarnMoney_85.class);
                EarnMoney_88.this.myMoney.setPref(MyMoney.POINTS, 0);
                EarnMoney_88.this.startActivity(intent);
            }
        });

        TextView textView2 = (TextView) dialog.findViewById(R.id.bt_no);
        textView2.setText("Not Now");
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override 
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    @Override 
    public void onBackPressed() {
        super.onBackPressed();
    }

}
