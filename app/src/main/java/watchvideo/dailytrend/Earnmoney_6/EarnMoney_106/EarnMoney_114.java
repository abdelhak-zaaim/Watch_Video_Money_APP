package watchvideo.dailytrend.Earnmoney_6.EarnMoney_106;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import watchvideo.dailytrend.Earnmoney_6.RealMoney_100.RealMoney_103;
import watchvideo.dailytrend.Earnmoney_6.RealMoney_104.RealMoney_105;
import watchvideo.dailytrend.Earnmoney_6.RealMoney_104.EarnMoney_103;
import watchvideo.dailytrend.Earnmoney_6.EarnMoney_104.cashearning5;
import watchvideo.dailytrend.R;

import java.util.ArrayList;

public class EarnMoney_114 extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static int ITEM = 0;
    public static int NATIVE_ADS = 2;
    private Context _context;
    private ArrayList<cashearning5> arrCategories = new ArrayList<>();
    private int videoIdentify;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private CardView cardSize;
        private ConstraintLayout clMain;
        private ImageView imgThumb;
        public TextView txtName;

        public MyViewHolder(View view, int i) {
            super(view);
            if (i == EarnMoney_114.ITEM) {
                this.txtName = (TextView) view.findViewById(R.id.txtName);
                this.imgThumb = (ImageView) view.findViewById(R.id.imgThumb);
                this.clMain = (ConstraintLayout) view.findViewById(R.id.clMain);
                this.cardSize = (CardView) view.findViewById(R.id.cardSize);
                ConstraintSet constraintSet = new ConstraintSet();
                constraintSet.clone(this.clMain);
                if (EarnMoney_114.this.videoIdentify == RealMoney_105.IS_FULLSCREEN_VIDEOS) {
                    constraintSet.setDimensionRatio(this.cardSize.getId(), "H,1:1.7");
                } else {
                    constraintSet.setDimensionRatio(this.cardSize.getId(), "H,1:1");
                }
                constraintSet.applyTo(this.clMain);
            }
        }
    }

    private class NativeViewHolder extends RecyclerView.ViewHolder {
        CardView p;
        LinearLayout q;

        public NativeViewHolder(View view) {
            super(view);
            this.p = (CardView) view.findViewById(R.id.cardFake);
            this.q = (LinearLayout) view.findViewById(R.id.layoutAd);
        }
    }

    public EarnMoney_114(int i, Context context, ArrayList<cashearning5> arrayList) {
        this.arrCategories = arrayList;
        this._context = context;
        this.videoIdentify = i;
    }

    @Override 
    public int getItemCount() {
        return this.arrCategories.size();
    }

    @Override 
    public int getItemViewType(int i) {
        int itemType = this.arrCategories.get(i).getItemType();
        int i2 = NATIVE_ADS;
        if (itemType == i2) {
            return i2;
        }
        return ITEM;
    }

    @Override 
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        final cashearning5 categories_Model = this.arrCategories.get(i);
        if (viewHolder instanceof MyViewHolder) {
            if (categories_Model.getItemType() == ITEM) {
                final MyViewHolder myViewHolder = (MyViewHolder) viewHolder;
                myViewHolder.txtName.setText(categories_Model.getName());
                Glide.with(this._context).load(categories_Model.getImage()).into(myViewHolder.imgThumb);
                myViewHolder.itemView.setOnTouchListener(new View.OnTouchListener() {

                    @Override
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        int action = motionEvent.getAction();
                        if (action == 0) {
                            myViewHolder.itemView.clearAnimation();
                            myViewHolder.itemView.animate().scaleX(0.92f).setDuration(50).start();
                            myViewHolder.itemView.animate().scaleY(0.92f).setDuration(50).start();
                            return false;
                        } else if (action == 1) {
                            myViewHolder.itemView.clearAnimation();
                            myViewHolder.itemView.animate().scaleX(1.0f).setDuration(50).start();
                            myViewHolder.itemView.animate().scaleY(1.0f).setDuration(50).start();
                            return false;
                        } else if (2 == motionEvent.getAction()) {
                            return false;
                        } else {
                            myViewHolder.itemView.clearAnimation();
                            myViewHolder.itemView.animate().scaleX(1.0f).setDuration(50).start();
                            myViewHolder.itemView.animate().scaleY(1.0f).setDuration(50).start();
                            return false;
                        }
                    }
                });
                myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        new Handler().postDelayed(new Runnable() {

                            @Override // java.lang.Runnable
                            public void run() {
                                Intent intent = new Intent(EarnMoney_114.this._context, RealMoney_103.class);
                                intent.putExtra(RealMoney_105.EXTRA_SEARCHED_IMAGE_TITLE, categories_Model.getName());
                                intent.putExtra(RealMoney_105.EXTRA_SEARCH_VALUE, categories_Model.getId());
                                intent.putExtra(RealMoney_105.EXTRA_IDENTIFYER, 12);
                                intent.putExtra(RealMoney_105.EXTRA_VIDEO_INDENTIFYER, EarnMoney_114.this.videoIdentify);
                                EarnMoney_114.this._context.startActivity(intent);
                            }
                        }, 50);
                    }
                });
            }
        } else if (viewHolder instanceof NativeViewHolder) {
            ((NativeViewHolder) viewHolder).itemView.post(new Runnable() {

                @Override // java.lang.Runnable
                public void run() {
                    EarnMoney_103 Instance = EarnMoney_103.Instance();
                    EarnMoney_103.Instance().getClass();
                    if (Instance.getIntPref("AD_PREF") != 0) {
                        EarnMoney_103 Instance2 = EarnMoney_103.Instance();
                        EarnMoney_103.Instance().getClass();
                        if (Instance2.getIntPref("AD_PREF") != 2) {
                            EarnMoney_103 Instance3 = EarnMoney_103.Instance();
                            EarnMoney_103.Instance().getClass();
                            if (Instance3.getIntPref("AD_PREF") == 1) {
                            }
                        }
                    }
                }
            });
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == NATIVE_ADS) {
            return new NativeViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.realmoneyone, viewGroup, false));
        }
        return new MyViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.dailywatchingvideos, viewGroup, false), i);
    }
}
