package watchvideo.dailytrend.Earnmoney_2;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import watchvideo.dailytrend.BuildConfig;
import watchvideo.dailytrend.R;

public class EarnMoney_81 extends AppCompatActivity {
    
    @Override 
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(1024, 1024);
        setContentView(R.layout.moneyspinwin);
        ((ImageView) findViewById(R.id.ivback)).setOnClickListener(new View.OnClickListener() {
            @Override 
            public void onClick(View view) {
                EarnMoney_81.this.onBackPressed();
            }
        });
        ((TextView) findViewById(R.id.tv_version)).setText(BuildConfig.VERSION_NAME);
    }

    @Override 
    public void onBackPressed() {
        super.onBackPressed();
    }
}
