package watchvideo.dailytrend.Realmoney_3.earnmoney_35;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import watchvideo.dailytrend.R;
import watchvideo.dailytrend.Realmoney_3.realmoney_35.earnmoney_30;
import java.util.ArrayList;

public class earnmoney_26 extends RecyclerView.Adapter<earnmoney_26.ViewHolder> {
    private Context context;
    private SetOnItemClickListener mSetOnItemClickListener;
    private ArrayList<earnmoney_30> mTags;

    public interface SetOnItemClickListener {
        void OnItemClick(View view, int i);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView mTrendingTag;
        RelativeLayout rlMain;

        ViewHolder(View view) {
            super(view);
            view.setOnClickListener(this);
            this.mTrendingTag = (TextView) view.findViewById(R.id.trending_tag);
            this.rlMain = (RelativeLayout) view.findViewById(R.id.rlMain);
        }

        @Override 
        public void onClick(View view) {
            try {
                if (earnmoney_26.this.mSetOnItemClickListener != null) {
                    earnmoney_26.this.mSetOnItemClickListener.OnItemClick(view, getAdapterPosition());
                }
            } catch (Throwable unused) {
            }
        }
    }

    public earnmoney_26(ArrayList<earnmoney_30> arrayList, Context context2) {
        this.mTags = arrayList;
        this.context = context2;
    }

    public void refreshData(ArrayList<earnmoney_30> arrayList) {
        this.mTags = arrayList;
        notifyDataSetChanged();
    }

    @Override 
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.earnmoneywatchvideoearnmoney, viewGroup, false));
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.mTrendingTag.setText(this.mTags.get(i).getmTagName());
        if (this.mTags.get(i).isSelected()) {
            viewHolder.mTrendingTag.setTextColor(this.context.getResources().getColor(R.color.white));
        } else {
            viewHolder.mTrendingTag.setTextColor(this.context.getResources().getColor(R.color.colorTagText));
        }
        viewHolder.rlMain.setBackgroundResource(this.mTags.get(i).isSelected() ? R.drawable.dailyearnmoney_3 : R.drawable.dailyearnmoney_4);
    }

    @Override 
    public int getItemCount() {
        return this.mTags.size();
    }

    public void setOnItemClickListener(SetOnItemClickListener setOnItemClickListener) {
        this.mSetOnItemClickListener = setOnItemClickListener;
    }

}
