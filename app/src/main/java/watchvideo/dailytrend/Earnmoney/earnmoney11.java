package watchvideo.dailytrend.Earnmoney;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import watchvideo.dailytrend.R;

public class earnmoney11 extends RecyclerView.ViewHolder {

    public ImageView earnmoney_a;
    public TextView earnmoney_b;
    public RelativeLayout earnmoney_c;
    public LinearLayout earnmoney_d;

    public earnmoney11(View itemView) {
        super(itemView);
        earnmoney_a = itemView.findViewById(R.id.appicon);
        earnmoney_b = itemView.findViewById(R.id.appname);
        earnmoney_c = itemView.findViewById(R.id.earnmoney_d);
        earnmoney_d = itemView.findViewById(R.id.earnmoney_e);
    }

}