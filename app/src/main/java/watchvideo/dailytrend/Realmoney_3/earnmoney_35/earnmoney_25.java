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
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import watchvideo.dailytrend.realmoney_24;
import watchvideo.dailytrend.R;
import watchvideo.dailytrend.Realmoney_3.realmoney_35.earnmoney_34.realmoney_26;
import watchvideo.dailytrend.Realmoney_3.earnmoney_46.earnmoney_39;

import java.util.ArrayList;
@SuppressLint("WrongConstant")

public abstract class earnmoney_25 extends RecyclerView.Adapter<earnmoney_25.ViewHolder> {
    public static earnmoney_39 handler;
    private Context context;
    private ArrayList<realmoney_26> dataItems;
    private onFavoriteClick onFavoriteClick;
    private OnItemClicked onItemClicked;

    public interface OnItemClicked {
        void onClick(int i);
    }

    public interface onFavoriteClick {
        void onFavClick(realmoney_26 modelVideo, String str);
    }

    public abstract void Load();

    public class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout RLNativeAdd;
        LinearLayout btnFav;
        CardView card_view;
        ImageView imgThumbVideo;
        ImageView imgfav;
        LinearLayout loaderlayout;
        TextView txtVideoTitle;
        TextView txtViewCount;

        ViewHolder(View view) {
            super(view);
            this.RLNativeAdd = (LinearLayout) view.findViewById(R.id.RLNativeAdd);
            this.btnFav = (LinearLayout) view.findViewById(R.id.btnFav);
            this.imgThumbVideo = (ImageView) view.findViewById(R.id.imgThumbVideo);
            this.imgfav = (ImageView) view.findViewById(R.id.imgFav);
            this.loaderlayout = (LinearLayout) view.findViewById(R.id.loader_layout);
            this.txtVideoTitle = (TextView) view.findViewById(R.id.txtVideoTitle);
            this.txtViewCount = (TextView) view.findViewById(R.id.txtViewCount);
            this.card_view = (CardView) view.findViewById(R.id.card_view);
        }

    }

    public earnmoney_25(ArrayList<realmoney_26> arrayList, Context context2, onFavoriteClick onfavoriteclick, earnmoney_39 earnmoney39) {
        this.context = context2;
        this.dataItems = arrayList;
        this.onFavoriteClick = onfavoriteclick;
        handler = earnmoney39;
    }

    public void setOnItemClickListener(OnItemClicked onItemClicked2) {
        this.onItemClicked = onItemClicked2;
    }

    @Override 
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.realmoneyapprealmoney, viewGroup, false));
    }

    public void onBindViewHolder(final ViewHolder viewHolder, @SuppressLint("RecyclerView") final int i) {
        if (i % 5 == 0) {
            viewHolder.card_view.setVisibility(0);
            viewHolder.RLNativeAdd.setVisibility(0);
        } else {
            viewHolder.card_view.setVisibility(8);
            viewHolder.RLNativeAdd.setVisibility(8);
        }

        Load_Image(this.dataItems.get(i).getThumb(), viewHolder.imgThumbVideo, viewHolder.loaderlayout);
        viewHolder.txtVideoTitle.setText(this.dataItems.get(i).getName());
        TextView textView = viewHolder.txtViewCount;
        textView.setText(String.valueOf(this.dataItems.get(i).getViewCounter()) + " " + this.context.getString(R.string.views));

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (earnmoney_25.this.onItemClicked != null) {
                    earnmoney_25.this.onItemClicked.onClick(i);
                }
            }
        });

        if (this.dataItems.size() - 1 == i) {
            Log.d("tag", "incoming...");
            Load();
        }

        viewHolder.btnFav.setOnClickListener(new View.OnClickListener() {
            @Override 
            public void onClick(View view) {
                String str;
                Log.d("tag", "what : " + earnmoney_25.handler.checkIsFav(String.valueOf(((realmoney_26) earnmoney_25.this.dataItems.get(i)).getId()), earnmoney_39.TABLE_FAVORITE_VIDEO, "video_id"));
                if (earnmoney_25.handler.checkIsFav(String.valueOf(((realmoney_26) earnmoney_25.this.dataItems.get(i)).getId()), earnmoney_39.TABLE_FAVORITE_VIDEO, "video_id")) {
                    viewHolder.imgfav.setImageResource(R.drawable.realmoneygame_19);
                    str = "REMOVE";
                } else {
                    viewHolder.imgfav.setImageResource(R.drawable.realmoneygame_18);
                    str = "ADD";
                }
                earnmoney_25.this.onFavoriteClick.onFavClick((realmoney_26) earnmoney_25.this.dataItems.get(i), str);
            }
        });

        Log.d("tag", "id :: " + this.dataItems.get(i).getId());

        if (handler.checkIsFav(String.valueOf(this.dataItems.get(i).getId()), earnmoney_39.TABLE_FAVORITE_VIDEO, "video_id")) {
            viewHolder.imgfav.setImageResource(R.drawable.realmoneygame_18);
        } else {
            viewHolder.imgfav.setImageResource(R.drawable.realmoneygame_19);
        }

    }

    @Override 
    public int getItemCount() {
        return this.dataItems.size();
    }

    private void Load_Image(String str, ImageView imageView, final LinearLayout linearLayout) {
        linearLayout.setVisibility(0);
        Glide.with(realmoney_24.getInstance()).asBitmap().load(str).listener(new RequestListener<Bitmap>() {
            @Override
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
    }
}
