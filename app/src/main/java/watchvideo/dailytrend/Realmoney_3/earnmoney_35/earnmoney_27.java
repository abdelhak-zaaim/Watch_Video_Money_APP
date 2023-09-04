package watchvideo.dailytrend.Realmoney_3.earnmoney_35;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.google.android.exoplayer2.metadata.icy.IcyHeaders;
import watchvideo.dailytrend.R;
import watchvideo.dailytrend.Realmoney_3.realmoney_47.realmoney_39;
import watchvideo.dailytrend.Realmoney_3.realmoney_35.earnmoney_31.earnmoney_28;
import java.util.ArrayList;

public class earnmoney_27 extends RecyclerView.Adapter<earnmoney_27.ViewHolder> {
    ArrayList<earnmoney_28> categoryItems;
    Context context;
    private OnItemClicked onItemClicked;

    public interface OnItemClicked {
        void onClick(int i);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout FL_MainContainer;
        CardView cardView;
        ImageView ivCategory;
        LinearLayout loaderlayout;
        AppCompatTextView tvCategory;

        ViewHolder(View view) {
            super(view);
            this.ivCategory = (ImageView) view.findViewById(R.id.ivCategory);
            this.loaderlayout = (LinearLayout) view.findViewById(R.id.loader_layout);
            this.tvCategory = (AppCompatTextView) view.findViewById(R.id.tvCategory);
            this.cardView = (CardView) view.findViewById(R.id.cardView);
            this.FL_MainContainer = (LinearLayout) view.findViewById(R.id.FL_MainContainer);
        }
    }

    public earnmoney_27(ArrayList<earnmoney_28> arrayList, Context context2) {
        this.categoryItems = arrayList;
        this.context = context2;
    }

    public void setOnItemClickListener(OnItemClicked onItemClicked2) {
        this.onItemClicked = onItemClicked2;
    }

    @Override 
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.realmoneygameget, viewGroup, false));
    }

    public void onBindViewHolder(ViewHolder viewHolder, final int i) {
        if (this.categoryItems.get(i).getIsAds().equals(IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE)) {
            viewHolder.FL_MainContainer.setVisibility(0);
            viewHolder.cardView.setVisibility(8);
            return;
        }
        viewHolder.FL_MainContainer.setVisibility(8);
        viewHolder.cardView.setVisibility(0);
        Load_Image(this.categoryItems.get(i).getIcon(), viewHolder.ivCategory, viewHolder.loaderlayout);
        viewHolder.tvCategory.setText(this.categoryItems.get(i).getName());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override 
            public void onClick(View view) {
                if (earnmoney_27.this.onItemClicked != null) {
                    earnmoney_27.this.onItemClicked.onClick(i);
                }
            }
        });
    }

    @Override 
    public int getItemCount() {
        return this.categoryItems.size();
    }

    private void Load_Image(String str, ImageView imageView, final LinearLayout linearLayout) {
        try {
            linearLayout.setVisibility(0);
            Glide.with((FragmentActivity) realmoney_39.getInstance()).asBitmap().load(str).listener(new RequestListener<Bitmap>() {

                @SuppressLint("WrongConstant")
                @Override // com.bumptech.glide.request.RequestListener
                public boolean onLoadFailed(GlideException glideException, Object obj, Target<Bitmap> target, boolean z) {
                    Log.d("tag", "earnmoney_27 onLoadFailed");
                    linearLayout.setVisibility(0);
                    return false;
                }

                public boolean onResourceReady(Bitmap bitmap, Object obj, Target<Bitmap> target, DataSource dataSource, boolean z) {
                    Log.d("tag", "earnmoney_27 onResourceReady");
                    linearLayout.setVisibility(8);
                    return false;
                }
            }).into(imageView);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
