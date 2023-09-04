package watchvideo.dailytrend.Earnmoney;

import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import watchvideo.dailytrend.R;

import java.util.ArrayList;


public class realmoney15 extends RecyclerView.Adapter<earnmoney11> {
    Context context;
    ArrayList<realmoney11> data = new ArrayList<realmoney11>();

    public realmoney15(Context context, ArrayList<realmoney11> data) {
        this.data = data;
        this.context = context;
    }

    @Override
    public earnmoney11 onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.winmoney, parent, false);
        earnmoney11 viewHolder = new earnmoney11(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final earnmoney11 holder, @SuppressLint("RecyclerView") final int position) {
        realmoney11 adData = data.get(position);
        Glide.with(context).load(adData.getApp_icon()).into(holder.earnmoney_a);
        holder.earnmoney_b.setText(adData.getApp_name());
        holder.earnmoney_b.setTextSize(12);
        holder.earnmoney_b.setSelected(true);

        holder.earnmoney_a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("market://details?id=" + data.get(position).getPackage_name());
                Intent myAppLinkToMarket = new Intent(Intent.ACTION_VIEW, uri);
                myAppLinkToMarket.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                try {
                    context.startActivity(myAppLinkToMarket);
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(context, " unable to find market app", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

}
