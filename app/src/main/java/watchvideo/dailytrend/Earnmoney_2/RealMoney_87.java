package watchvideo.dailytrend.Earnmoney_2;

import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import watchvideo.dailytrend.realmoney_24;
import watchvideo.dailytrend.earnmoney_21;
import watchvideo.dailytrend.R;

public class RealMoney_87 extends AppCompatActivity implements View.OnClickListener {
    private LinearLayout adView;
    TextView btn_rate_us;
    TextView btn_win_more_money;
    Dialog conform_dialog;

    @Override 
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.earnmoneyapp);
        getWindow().setFlags(1024, 1024);
        TextView textView = (TextView) findViewById(R.id.btn_rate_us);
        this.btn_rate_us = textView;
        textView.setOnClickListener(this);
        this.btn_rate_us.setTypeface(realmoney_24.ChangeTypeFaceITCKabelStd(this));
        TextView textView2 = (TextView) findViewById(R.id.btn_win_more_money);
        this.btn_win_more_money = textView2;
        textView2.setOnClickListener(this);
        this.btn_win_more_money.setTypeface(realmoney_24.ChangeTypeFaceITCKabelStd(this));
        Dialog dialog = new Dialog(this, R.style.TransparentBackground);
        this.conform_dialog = dialog;
        dialog.requestWindowFeature(1);
        this.conform_dialog.setContentView(R.layout.realmoneyspin);
        this.conform_dialog.getWindow().setLayout(-1, -2);
    }

    @Override 
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_rate_us) {
            RateApp();
        } else if (id == R.id.btn_win_more_money) {
            onBackPressed();
        }
    }

    public void RateApp() {
        try {
            ConformRateDialog(earnmoney_21.rate_url + getPackageName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void ConformRateDialog(final String str) {
        ((TextView) this.conform_dialog.findViewById(R.id.btn_rate_now)).setOnClickListener(new View.OnClickListener() {

            @Override 
            public void onClick(View view) {
                try {
                    RealMoney_87.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                } catch (ActivityNotFoundException e) {
                    e.printStackTrace();
                }
                RealMoney_87.this.conform_dialog.dismiss();
            }
        });
        ((TextView) this.conform_dialog.findViewById(R.id.btn_cancel)).setOnClickListener(new View.OnClickListener() {

            @Override 
            public void onClick(View view) {
                RealMoney_87.this.conform_dialog.dismiss();
            }
        });
        this.conform_dialog.show();
    }

    @Override 
    public void onBackPressed() {
        finish();
    }

    @Override 
    public void onDestroy() {
        super.onDestroy();
    }
}
