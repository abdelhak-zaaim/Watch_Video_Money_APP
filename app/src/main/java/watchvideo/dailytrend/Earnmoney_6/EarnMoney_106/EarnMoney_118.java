package watchvideo.dailytrend.Earnmoney_6.EarnMoney_106;

import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.kingfisher.easyviewindicator.AnyViewIndicator;
import watchvideo.dailytrend.Earnmoney_2.RealMoney_84;
import watchvideo.dailytrend.Earnmoney_6.RealMoney_104.RealMoney_105;
import watchvideo.dailytrend.Earnmoney_6.RealMoney_104.RealMoney_107;
import watchvideo.dailytrend.Earnmoney_6.RealMoney_104.RealMoney_109;
import watchvideo.dailytrend.Earnmoney_6.EarnMoney_104.moneyapp_4;
import watchvideo.dailytrend.Earnmoney_6.EarnMoney_104.moneyapp_1;
import watchvideo.dailytrend.Earnmoney_6.EarnMoney_104.moneyapp_3;
import watchvideo.dailytrend.R;
import cz.msebera.android.httpclient.HttpHost;
import java.io.File;
import java.util.ArrayList;

@SuppressLint("WrongConstant")

public class EarnMoney_118 extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final String TAG = "EarnMoney_118";
    private Context _context;
    private int adCount = 0;
    private ArrayList<moneyapp_3> arrVideoList;
    private int fromIdentifyer = -1;
    private ItemClickDelegate itemClickDelegate;
    private RecyclerView.LayoutManager mLayoutManager;
    private int screenWith = 0;
    private int videoIdentifyer = 0;

    public interface ItemClickDelegate {
        void onItemClick(int i, boolean z);

        void onItemDelete();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private LinearLayout adChoicesContainer;
        private Button btnInstall;
        private CardView cardNo;
        private CardView cardYes;
        private ConstraintLayout clMain;
        private ConstraintLayout clSize;
        public ImageView imgAppIcon;
        public ImageView imgDelete;
        public ImageView imgThumb;
        private CardView rcImage;
        private RecyclerView recyclerImages;
        private RecyclerView recyclerViewTrending;
        private TextView sponsoredLabel;
        public TextView txtDes;
        private TextView txtLang;
        public TextView txtSavedTitle;
        public TextView txtTitle;
        private TextView txtTrending;
        private AnyViewIndicator view_pager_indicator;

        MyViewHolder(View view, int i) {
            super(view);
            if (i == 0) {
                this.imgThumb = (ImageView) view.findViewById(R.id.imgThumb);
                this.txtTitle = (TextView) view.findViewById(R.id.txtTitle);
                this.txtLang = (TextView) view.findViewById(R.id.txtLang);
                this.clMain = (ConstraintLayout) view.findViewById(R.id.clMain);
                this.imgDelete = (ImageView) view.findViewById(R.id.imgDelete);
                this.txtSavedTitle = (TextView) view.findViewById(R.id.txtSavedTitle);
                this.clSize = (ConstraintLayout) view.findViewById(R.id.clSize);
                this.rcImage = (CardView) view.findViewById(R.id.rcImage);
                ConstraintSet constraintSet = new ConstraintSet();
                constraintSet.clone(this.clSize);
                if (EarnMoney_118.this.videoIdentifyer != RealMoney_105.IS_FULLSCREEN_VIDEOS) {
                    constraintSet.setDimensionRatio(this.rcImage.getId(), "H,1:0.56");
                } else if (EarnMoney_118.this.fromIdentifyer == 8) {
                    constraintSet.setDimensionRatio(this.rcImage.getId(), "H,1:1.5");
                    this.clMain.setPadding((int) RealMoney_109.Instance().DpToPx(0.5f, EarnMoney_118.this._context), (int) RealMoney_109.Instance().DpToPx(0.5f, EarnMoney_118.this._context), (int) RealMoney_109.Instance().DpToPx(0.5f, EarnMoney_118.this._context), (int) RealMoney_109.Instance().DpToPx(0.5f, EarnMoney_118.this._context));
                } else {
                    constraintSet.setDimensionRatio(this.rcImage.getId(), "H,1:1.7");
                }
                constraintSet.applyTo(this.clSize);
                if (EarnMoney_118.this.fromIdentifyer == 8) {
                    if (EarnMoney_118.this.videoIdentifyer == RealMoney_105.IS_FULLSCREEN_VIDEOS) {
                        int DpToPx = (int) (((float) (EarnMoney_118.this.screenWith / 4)) - RealMoney_109.Instance().DpToPx(1.0f, EarnMoney_118.this._context));
                        this.clMain.getLayoutParams().width = DpToPx + (DpToPx / 4);
                    } else if (EarnMoney_118.this.arrVideoList.size() > 1) {
                        double d = (double) EarnMoney_118.this.screenWith;
                        Double.isNaN(d);
                        Double.isNaN(d);
                        int DpToPx2 = (int) (((float) ((int) (d / 1.9d))) - RealMoney_109.Instance().DpToPx(1.0f, EarnMoney_118.this._context));
                        double d2 = (double) DpToPx2;
                        Double.isNaN(d2);
                        ViewGroup.LayoutParams layoutParams = this.clMain.getLayoutParams();
                        Double.isNaN(d2);
                        layoutParams.width = DpToPx2 + ((int) (d2 / 1.9d));
                    }
                }
            } else if (i == 2) {
                this.recyclerImages = (RecyclerView) view.findViewById(R.id.recyclerImages);
                this.view_pager_indicator = (AnyViewIndicator) view.findViewById(R.id.view_pager_indicator);
            } else if (i == 3) {
                this.imgAppIcon = (ImageView) view.findViewById(R.id.imgAppIcon);
                this.txtTitle = (TextView) view.findViewById(R.id.txtTitle);
                this.txtDes = (TextView) view.findViewById(R.id.txtDes);
                this.btnInstall = (Button) view.findViewById(R.id.btnInstall);
            } else if (i == 14) {
                this.txtTitle = (TextView) view.findViewById(R.id.txtTitle);
            } else if (i == 15) {
                this.cardYes = (CardView) view.findViewById(R.id.cardYes);
                this.cardNo = (CardView) view.findViewById(R.id.cardNo);
            }
        }

    }

    private class NativeViewHolder extends RecyclerView.ViewHolder {
        CardView p;
        ConstraintLayout q;
        LinearLayout r;
        public int type;

        public NativeViewHolder(EarnMoney_118 earnMoney118, View view, int i) {
            super(view);
            this.r = (LinearLayout) view.findViewById(R.id.ad_view);
            this.r.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            Log.e(EarnMoney_118.TAG, "NativeViewHolder: ");
        }
    }

    public EarnMoney_118(int i, int i2, Context context, ArrayList<moneyapp_3> arrayList, int i3, ItemClickDelegate itemClickDelegate2) {
        this.arrVideoList = arrayList;
        this._context = context;
        this.fromIdentifyer = i3;
        this.itemClickDelegate = itemClickDelegate2;
        this.screenWith = i2;
        this.videoIdentifyer = i;
        this.adCount = 0;
    }

    private void hideLan(MyViewHolder myViewHolder) {
        myViewHolder.txtSavedTitle.setVisibility(0);
        myViewHolder.imgDelete.setVisibility(0);
        myViewHolder.txtTitle.setVisibility(4);
        myViewHolder.txtLang.setVisibility(4);
    }

    @Override 
    public int getItemCount() {
        return this.arrVideoList.size();
    }

    @Override 
    public int getItemViewType(int i) {
        return this.arrVideoList.get(i).getItemType();
    }

    @Override 
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, @SuppressLint("RecyclerView") final int i) {
        final moneyapp_3 moneyapp3 = this.arrVideoList.get(i);
        if (viewHolder instanceof MyViewHolder) {
            final MyViewHolder myViewHolder = (MyViewHolder) viewHolder;
            if (moneyapp3.getItemType() == 0) {
                if (this.fromIdentifyer == 9) {
                    Glide.with(this._context).load(moneyapp3.getVideoPath()).thumbnail(0.4f).into(myViewHolder.imgThumb);
                    myViewHolder.txtSavedTitle.setText(moneyapp3.getTitle());
                    hideLan(myViewHolder);
                } else {
                    String thumb = moneyapp3.getThumb();
                    if (thumb.contains("75pc/")) {
                        thumb = thumb.replace("75pc/", "");
                    }
                    Glide.with(this._context).load(thumb).thumbnail(0.4f).into(myViewHolder.imgThumb);
                    int i2 = this.fromIdentifyer;
                    if (i2 == 10 || i2 == 13) {
                        hideLan(myViewHolder);
                        myViewHolder.txtSavedTitle.setText(moneyapp3.getTitle());
                    } else {
                        myViewHolder.txtTitle.setText(moneyapp3.getTitle());
                        myViewHolder.txtLang.setText(moneyapp3.getLanguage());
                        myViewHolder.txtTitle.setVisibility(0);
                        myViewHolder.txtLang.setVisibility(0);
                        myViewHolder.txtSavedTitle.setVisibility(8);
                    }
                    myViewHolder.imgDelete.setVisibility(8);
                }

                myViewHolder.clMain.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        try {
                            int action = motionEvent.getAction();
                            if (action == 0) {
                                myViewHolder.clMain.clearAnimation();
                                myViewHolder.clMain.animate().scaleX(0.92f).setDuration(50).start();
                                myViewHolder.clMain.animate().scaleY(0.92f).setDuration(50).start();
                                return false;
                            } else if (action == 1) {
                                myViewHolder.clMain.clearAnimation();
                                myViewHolder.clMain.animate().scaleX(1.0f).setDuration(50).start();
                                myViewHolder.clMain.animate().scaleY(1.0f).setDuration(50).start();
                                return false;
                            } else if (2 == motionEvent.getAction()) {
                                return false;
                            } else {
                                myViewHolder.clMain.clearAnimation();
                                myViewHolder.clMain.animate().scaleX(1.0f).setDuration(50).start();
                                myViewHolder.clMain.animate().scaleY(1.0f).setDuration(50).start();
                                return false;
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            return false;
                        }
                    }
                });


                myViewHolder.clMain.setOnClickListener(new View.OnClickListener() {
                    @Override 
                    public void onClick(View view) {
                        if (EarnMoney_118.this.itemClickDelegate != null) {
                            EarnMoney_118.this.itemClickDelegate.onItemClick(i, false);
                        }
                    }
                });


                myViewHolder.imgDelete.setOnClickListener(new View.OnClickListener() {
                    @Override 
                    public void onClick(View view) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(EarnMoney_118.this._context);
                        builder.setMessage("Are you sure you want to delete this video?").setCancelable(false).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                File file = new File(moneyapp3.getVideoPath());
                                if (file.exists()) {
                                    file.delete();
                                    RealMoney_107.scanFile(EarnMoney_118.this._context, file);
                                }
                                if (EarnMoney_118.this.itemClickDelegate != null) {
                                    EarnMoney_118.this.itemClickDelegate.onItemDelete();
                                }
                            }
                        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        });
                        AlertDialog create = builder.create();
                        create.setTitle("Delete");
                        create.show();
                    }
                });

            }

            if (moneyapp3.getItemType() == 14) {
                myViewHolder.txtTitle.setText(moneyapp3.getTitle());
            } else if (moneyapp3.getItemType() == 2) {
                ArrayList<moneyapp_4> arrModelNewImageBanner = this.arrVideoList.get(i).getArrModelNewImageBanner();
                this.mLayoutManager = new LinearLayoutManager(this._context, 0, false);
                myViewHolder.recyclerImages.setLayoutManager(this.mLayoutManager);
                myViewHolder.recyclerImages.setHasFixedSize(true);
                myViewHolder.recyclerImages.setItemAnimator(new DefaultItemAnimator());
                myViewHolder.view_pager_indicator.setItemCount(arrModelNewImageBanner.size());
                if (this.arrVideoList.get(i).getArrModelNewImageBanner().size() > 1) {
                    myViewHolder.view_pager_indicator.setVisibility(0);
                    myViewHolder.view_pager_indicator.setCurrentPosition(0);
                    myViewHolder.recyclerImages.addOnScrollListener(new RecyclerView.OnScrollListener() {
                        @Override 
                        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                            super.onScrollStateChanged(recyclerView, i);
                        }
                        @Override 
                        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                            super.onScrolled(recyclerView, i, i2);
                            myViewHolder.view_pager_indicator.setCurrentPosition(((LinearLayoutManager) EarnMoney_118.this.mLayoutManager).findFirstVisibleItemPosition());
                        }
                    });
                    return;
                }
                myViewHolder.view_pager_indicator.setVisibility(8);
            } else if (moneyapp3.getItemType() == 15) {
                myViewHolder.cardYes.setOnClickListener(new View.OnClickListener() {
                    @Override 
                    public void onClick(View view) {
                        EarnMoney_118.this._context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.full.screen.videostatus.hd")));
                        EarnMoney_118.this.arrVideoList.remove(i);
                        EarnMoney_118.this.notifyItemRemoved(i);
                        EarnMoney_118 earnMoney118 = EarnMoney_118.this;
                        earnMoney118.notifyItemRangeChanged(i, earnMoney118.arrVideoList.size());
                    }
                });

                myViewHolder.cardNo.setOnClickListener(new View.OnClickListener() {

                    @Override 
                    public void onClick(View view) {
                        EarnMoney_118.this.arrVideoList.remove(i);
                        EarnMoney_118.this.notifyItemRemoved(i);
                        EarnMoney_118 earnMoney118 = EarnMoney_118.this;
                        earnMoney118.notifyItemRangeChanged(i, earnMoney118.arrVideoList.size());
                    }
                });
            } else if (moneyapp3.getItemType() == 3) {
                final moneyapp_1 promoBannerModel = this.arrVideoList.get(i).getPromoBannerModel();
                Glide.with(this._context).load(promoBannerModel.icon).thumbnail(0.4f).into(myViewHolder.imgAppIcon);
                myViewHolder.txtTitle.setText(promoBannerModel.title);
                myViewHolder.txtDes.setText(promoBannerModel.desc);
                myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override 
                    public void onClick(View view) {
                        String str = promoBannerModel.link;
                        if (str == null || str.equals("null")) {
                            String str2 = promoBannerModel.pakage;
                            try {
                                Context context = EarnMoney_118.this._context;
                                context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + str2)));
                            } catch (ActivityNotFoundException unused) {
                                Context context2 = EarnMoney_118.this._context;
                                context2.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(RealMoney_84.APP_BASE_URL + str2)));
                            }
                        } else {
                            Intent intent = new Intent("android.intent.action.VIEW");
                            if (!promoBannerModel.link.contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                                moneyapp_1 promoBannerModel = null;
                                promoBannerModel.link = "http://" + promoBannerModel.link;
                            }
                            intent.setData(Uri.parse(promoBannerModel.link));
                            EarnMoney_118.this._context.startActivity(intent);
                        }
                    }
                });
            }
        }
    }


    @Override 
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view;
        if (i == 4) {
            return new NativeViewHolder(this, LayoutInflater.from(this._context).inflate(R.layout.realmoneymoney, (ViewGroup) null), 0);
        }
        if (i == 5) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.moneyspin, viewGroup, false);
        } else if (i == 2) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.realmoneyapps, viewGroup, false);
        } else if (i == 3) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.earnmoneyearnmoneys, viewGroup, false);
        } else if (i == 14) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.earnmoneyappspinandwin, viewGroup, false);
        } else if (i == 15) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.trendvideo, viewGroup, false);
        } else {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.moneyearnapp, viewGroup, false);
        }
        return new MyViewHolder(view, i);
    }

}
