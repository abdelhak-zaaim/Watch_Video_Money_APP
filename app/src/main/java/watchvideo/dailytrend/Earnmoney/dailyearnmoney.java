package watchvideo.dailytrend.Earnmoney;

import android.app.Activity;
import android.app.Dialog;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.github.ybq.android.spinkit.style.ThreeBounce;
import watchvideo.dailytrend.R;


public class dailyearnmoney extends Dialog {
    private final TextView earnn;
    private ImageView iv;

    public dailyearnmoney(Activity activity) {
        super(activity, R.style.moneyy);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.gravity = 1;
        getWindow().setAttributes(attributes);
        setTitle(null);
        setCancelable(false);
        setOnCancelListener(null);
        LinearLayout linearLayout = new LinearLayout(activity);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        this.earnn = new TextView(activity);
        this.earnn.setText("Showing Ads");
        this.earnn.setTextColor(-1);
        linearLayout.addView(this.earnn, layoutParams);
        ProgressBar progressBar = new ProgressBar(activity);
        progressBar.setIndeterminateDrawable(new ThreeBounce());
        linearLayout.addView(progressBar);
        addContentView(linearLayout, layoutParams);
    }

    @Override
    public void show() {
        super.show();
    }


}
