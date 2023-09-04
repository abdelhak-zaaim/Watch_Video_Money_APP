package watchvideo.dailytrend.Earnmoney_2;

import static watchvideo.dailytrend.Earnmoney.earnmoney.quera_link;
import static watchvideo.dailytrend.Earnmoney.earnmoney.qureka_visible;
import static watchvideo.dailytrend.Earnmoney.earnmoney.skip_page;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import watchvideo.dailytrend.Earnmoney.earnmoney;
import watchvideo.dailytrend.Earnmoney.realmoney;
import watchvideo.dailytrend.Earnmoney.realmoney13;
import watchvideo.dailytrend.R;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.google.android.material.textfield.TextInputEditText;

public class RealMoney_93 extends AppCompatActivity {

    TextInputEditText txt_email,txt_password;
    AppCompatButton submit_btn;

    SharedPreferences sharedpreferences;

    LinearLayout qureka_img;

    RelativeLayout adContainerView, adContainerPlaylist;
    ShimmerFrameLayout main_act_banner;

    public static final String mypreference = "mypref";
    public static final String EMAIL = "emailKey";
    public static final String PASSWORD = "passwordKey";

    public void saveData(String key,String value) {
        SharedPreferences  sharedPreferences = getSharedPreferences("savedata",Context.MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        prefsEditor.putString(key, value);
        prefsEditor.commit();
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.luckywin);

        sharedpreferences = getSharedPreferences(mypreference, Context.MODE_PRIVATE);

        txt_email = (TextInputEditText) findViewById(R.id.edit_email);
        txt_password = (TextInputEditText)findViewById(R.id.edit_password);
     //   qureka_img = findViewById(R.id.cricket_qureka);

        submit_btn = findViewById(R.id.submit_ep);


        //Banner :-
        adContainerView = findViewById(R.id.adViewContainer);
        adContainerPlaylist = findViewById(R.id.adViewContainer);
        main_act_banner = findViewById(R.id.main_act_banner);


        if (earnmoney.isAdOn) {
            if (earnmoney.ad_mode.equalsIgnoreCase("admob")) {
                realmoney.creteadadaptiveBanner(RealMoney_93.this, adContainerPlaylist, earnmoney.admob_banner_id);
            } else if (earnmoney.ad_mode.equalsIgnoreCase("qureka")) {
                main_act_banner.setVisibility(View.VISIBLE);
            } else {
                adContainerView.setBackgroundResource(R.drawable.realmoney_140);
                realmoney13.createFBLoadBanner(RealMoney_93.this, adContainerPlaylist, earnmoney.facebook_banner_id);
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





        submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = txt_email.getText().toString().trim();
                String lo_password = txt_password.getText().toString().trim();

                if (email.isEmpty()) {
                    txt_email.setError("Email is required!");
                    txt_email.requestFocus();
                    return;
                }

                if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    txt_email.setError("Please provide valid email!");
                    txt_email.requestFocus();
                    return;
                }

                if (lo_password.isEmpty()) {
                    txt_password.setError("Password is required!");
                    txt_password.requestFocus();
                    return;
                }

                if (lo_password.length() < 6) {
                    txt_password.setError("Min password length should be 6 characters!");
                    txt_password.requestFocus();
                    return;
                }

                saveData(EMAIL,txt_email.getText().toString());
                saveData(PASSWORD,txt_password.getText().toString());

                if (skip_page) {
                    Intent intent = new Intent(RealMoney_93.this, EarnMoney_83.class);
                    startActivity(intent);
                }else{
                    Intent intent = new Intent(RealMoney_93.this, EarnMoney_85.class);
                    startActivity(intent);
                }

            }
        });

/*
        if (qureka_visible){
            qureka_img.setVisibility(View.VISIBLE);
        }else{
            qureka_img.setVisibility(View.GONE);
        }


        qureka_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
*/
    }


}
