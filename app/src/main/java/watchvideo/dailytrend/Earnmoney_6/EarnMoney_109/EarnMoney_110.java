package watchvideo.dailytrend.Earnmoney_6.EarnMoney_109;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.wang.avi.AVLoadingIndicatorView;

import watchvideo.dailytrend.Earnmoney_6.EarnMoney_104.cashearning4;
import watchvideo.dailytrend.Earnmoney_6.EarnMoney_106.EarnMoney_118;
import watchvideo.dailytrend.Earnmoney_6.RealMoney_100.realcash;
import watchvideo.dailytrend.Earnmoney_6.EarnMoney_106.EarnMoney_115;
import watchvideo.dailytrend.Earnmoney_6.RealMoney_104.RealMoney_105;
import watchvideo.dailytrend.Earnmoney_6.RealMoney_104.EarnMoney_103;
import watchvideo.dailytrend.Earnmoney_6.RealMoney_104.EarnMoney_102;
import watchvideo.dailytrend.Earnmoney_6.RealMoney_104.RealMoney_109;
import watchvideo.dailytrend.Earnmoney_6.RealMoney_104.RealMoney_108;
import watchvideo.dailytrend.Earnmoney_6.EarnMoney_104.cashearning6;
import watchvideo.dailytrend.Earnmoney_6.EarnMoney_104.moneyapp_2;
import watchvideo.dailytrend.Earnmoney_6.EarnMoney_104.moneyapp_3;
import watchvideo.dailytrend.R;
import java.util.ArrayList;

@SuppressLint("WrongConstant")

public class EarnMoney_110 extends EarnMoney_112 {
    private ArrayList<moneyapp_3> arrVideoList = new ArrayList<>();
    private AVLoadingIndicatorView avLoadData;
    private CardView btnRetry;
    private int cont = 0;
    private int fragmentIdentifyer = -1;
    private moneyapp_3 imageBannerModel = new moneyapp_3(-11);
    private ImageView imgError;
    private ImageView imgTotheTop;
    private boolean isLoading = false;
    private moneyapp_3 loadingModel = new moneyapp_3(5);
    private EarnMoney_118 mAdapter;
    private moneyapp_3 modelListTitle = new moneyapp_3(14);
    private moneyapp_3 modelTreanding = new moneyapp_3(-11);

    public BroadcastReceiver newVideoDownloadedReciver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            EarnMoney_110.this.getSavedFiles();
        }
    };

    private moneyapp_3 notificationDialogModel = new moneyapp_3(15);
    private int overallXScroll = 0;
    private int page = 0;
    private moneyapp_3 promoBannerModel = new moneyapp_3(-11);
    private RecyclerView recyclerVideoList;
    private RecyclerView.SmoothScroller smoothScroller;
    private SwipeRefreshLayout swipeToRefresh;
    private int threshol = 1;
    private TextView txtError;
    private View v;
    private int videoIdentifyer = 0;


    private void addImageBanner() {
        if (this.videoIdentifyer == RealMoney_105.IS_FULLSCREEN_VIDEOS) {
            int i = 0;
            int i2 = 1;
            for (int i3 = 0; i3 < this.arrVideoList.size(); i3++) {
                if (this.arrVideoList.get(i3).getItemType() == 1) {
                    i2 = 1;
                }
            }
            int i4 = i2 != i ? 1 : 0;
            for (int i5 = 0; i5 < this.arrVideoList.size(); i5++) {
                if (this.arrVideoList.get(i5).getItemType() == 2) {
                    i = 1;
                }
            }
            if (i == 0) {
                this.arrVideoList.add(i4, this.imageBannerModel);
                this.mAdapter.notifyItemInserted(i4);
                this.mAdapter.notifyItemRangeChanged(i4, this.arrVideoList.size());
            }
        }
    }

    private void addPromoBanner() {
        int i = 0;
        for (int i2 = 0; i2 < this.arrVideoList.size(); i2++) {
            if (this.arrVideoList.get(i2).getItemType() == 3) {
                i = 1;
            }
        }
        if (i == 0) {
            int i3 = 0;
            for (int i4 = 0; i4 < this.arrVideoList.size(); i4++) {
                if (i3 == 2) {
                    this.arrVideoList.add(i4, this.promoBannerModel);
                    this.mAdapter.notifyItemInserted(i4);
                    this.mAdapter.notifyItemRangeChanged(i4, this.arrVideoList.size());
                    return;
                }
                if (this.arrVideoList.get(i4).getItemType() == 0) {
                    i3++;
                }
            }
        }
    }


    private void getData(boolean z, final boolean z2) {
        if (z) {
            this.avLoadData.setVisibility(0);
        }
        this.txtError.setVisibility(8);
        this.imgError.setVisibility(8);
        this.btnRetry.setVisibility(8);
        this.page++;
        cashearning4.Instance().getVideoList(this.videoIdentifyer, this.fragmentIdentifyer, this.page, 24, new cashearning4.ApiDelegate<moneyapp_3>() {
            @Override
            public void OnFailure(String str) {
                EarnMoney_110 earnMoney110 = EarnMoney_110.this;
                earnMoney110.page--;
                EarnMoney_110.this.isLoading = false;
                EarnMoney_110.this.avLoadData.setVisibility(8);
                if (EarnMoney_110.this.arrVideoList.size() <= 0) {
                    EarnMoney_110.this.btnRetry.setVisibility(0);
                    EarnMoney_110.this.txtError.setVisibility(0);
                    EarnMoney_110.this.imgError.setVisibility(0);
                }
                EarnMoney_110.this.recyclerVideoList.setVisibility(8);
                if (EarnMoney_102.isConnected()) {
                    EarnMoney_110.this.txtError.setText(str);
                } else {
                    EarnMoney_110.this.txtError.setText(RealMoney_105.INTERNET_CONNECTION_ISSUE);
                }
                EarnMoney_110.this.imgError.setImageResource(R.drawable.moneyapp_5);
                if (EarnMoney_110.this.swipeToRefresh.isRefreshing()) {
                    EarnMoney_110.this.swipeToRefresh.setRefreshing(false);
                }
            }

            @Override
            public void OnSuccsess(ArrayList<moneyapp_3> arrayList, int i) {
                if (EarnMoney_110.this.fragmentIdentifyer == 6 && EarnMoney_110.this.page == 1) {
                    int i2 = i;
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        if (arrayList.get(i3).getItemType() == 14) {
                            i2 = 1;
                        }
                    }
                    if (i2 == i) {
                        arrayList.add(0, EarnMoney_110.this.modelListTitle);
                        EarnMoney_110.this.avLoadData.setVisibility(8);
                        EarnMoney_110.this.recyclerVideoList.setVisibility(0);
                        EarnMoney_110.this.threshol = (int) Math.ceil((double) (Float.parseFloat(String.valueOf(i)) / 24.0f));
                        for (int i4 = 0; i4 < arrayList.size(); i4++) {
                            if (i4 % 5 == 0 && i4 != 0) {
                                moneyapp_3 moneyapp3 = new moneyapp_3();
                                moneyapp3.setItemType(4);
                                arrayList.add(i4, moneyapp3);
                            }
                        }
                        int i5 = 0;
                        while (true) {
                            if (i5 >= EarnMoney_110.this.arrVideoList.size()) {
                                break;
                            } else if (((moneyapp_3) EarnMoney_110.this.arrVideoList.get(i5)).getItemType() == 5) {
                                EarnMoney_110.this.arrVideoList.remove(i5);
                                EarnMoney_110.this.mAdapter.notifyItemRemoved(i5);
                                EarnMoney_110.this.mAdapter.notifyItemRangeChanged(i5, EarnMoney_110.this.arrVideoList.size());
                                break;
                            } else {
                                i5++;
                            }
                        }
                        if (z2) {
                            EarnMoney_110.this.arrVideoList.clear();
                            EarnMoney_110.this.mAdapter.notifyDataSetChanged();
                            if (EarnMoney_110.this.fragmentIdentifyer == 6) {
                                if (EarnMoney_110.this.modelTreanding.getItemType() == -11) {
                                    EarnMoney_110.this.getFeatureVideos();
                                } else {
                                    EarnMoney_110.this.setFeatureVideos();
                                }
                            }
                        }
                        int size = EarnMoney_110.this.arrVideoList.size();
                        EarnMoney_110.this.arrVideoList.addAll(arrayList);
                        EarnMoney_110.this.mAdapter.notifyItemRangeInserted(size, EarnMoney_110.this.arrVideoList.size());
                        EarnMoney_110.this.isLoading = false;
                        if (EarnMoney_110.this.fragmentIdentifyer == 6) {
                            EarnMoney_110.this.getUpdateApi();
                        }
                        if (!EarnMoney_110.this.swipeToRefresh.isRefreshing()) {
                            EarnMoney_110.this.swipeToRefresh.setRefreshing(false);
                            return;
                        }
                        return;
                    }
                }
                for (int i6 = 0; i6 < arrayList.size(); i6++) {
                    if (i6 % 5 == 0 && i6 != 0) {
                        moneyapp_3 moneyapp32 = new moneyapp_3();
                        moneyapp32.setItemType(4);
                        arrayList.add(i6, moneyapp32);
                    }
                }
                EarnMoney_110.this.avLoadData.setVisibility(8);
                EarnMoney_110.this.recyclerVideoList.setVisibility(0);
                EarnMoney_110.this.threshol = (int) Math.ceil((double) (Float.parseFloat(String.valueOf(i)) / 24.0f));
                int size2 = EarnMoney_110.this.arrVideoList.size();
                EarnMoney_110.this.arrVideoList.addAll(arrayList);
                EarnMoney_110.this.mAdapter.notifyItemRangeInserted(size2, EarnMoney_110.this.arrVideoList.size());
                EarnMoney_110.this.isLoading = false;
                int unused = EarnMoney_110.this.fragmentIdentifyer;
                EarnMoney_110.this.swipeToRefresh.isRefreshing();
            }
        });
    }


    private void getFeatureVideos() {
        if (this.modelTreanding.getItemType() != -11) {
            setFeatureVideos();
        } else {
            cashearning4.Instance().getVideoList(this.videoIdentifyer, 8, 1, 5000, new cashearning4.ApiDelegate<moneyapp_3>() {
                @Override
                public void OnFailure(String str) {

                }
                @Override
                public void OnSuccsess(ArrayList<moneyapp_3> arrayList, int i) {
                    int i2 = i;
                    for (int i3 = 0; i3 < EarnMoney_110.this.arrVideoList.size(); i3++) {
                        if (((moneyapp_3) EarnMoney_110.this.arrVideoList.get(i3)).getItemType() == 1) {
                            i2 = 1;
                        }
                    }
                    if (i2 == i) {
                        if (EarnMoney_110.this.videoIdentifyer == RealMoney_105.IS_FULLSCREEN_VIDEOS) {
                            cashearning6.Instance().setArrFeatureVideos(arrayList);
                        } else {
                            cashearning6.Instance().setArrFeatureLanceVideos(arrayList);
                        }
                        EarnMoney_110.this.setFeatureVideos();
                    }
                }
            });
        }
    }


    private void getSavedFiles() {
        RealMoney_108.getDownloadedFile(this.videoIdentifyer, getActivity(), new RealMoney_108.AllFilesDelegate() {
            @Override
            public void downloadedList(final ArrayList<moneyapp_3> arrayList) {
                EarnMoney_110.this.txtError.setVisibility(8);
                EarnMoney_110.this.imgError.setVisibility(8);
                EarnMoney_110.this.recyclerVideoList.setVisibility(0);
                if (arrayList == null || arrayList.size() <= 0) {
                    EarnMoney_110.this.txtError.setText("No Saved videos");
                    EarnMoney_110.this.txtError.setVisibility(0);
                    EarnMoney_110.this.imgError.setVisibility(0);
                    EarnMoney_110.this.imgError.setImageResource(R.drawable.moneyapp_6);
                    EarnMoney_110.this.recyclerVideoList.setVisibility(8);
                    return;
                }
                for (int size = arrayList.size() - 1; size > 0; size--) {
                    if (size != 0 && size % 6 == 0) {
                        moneyapp_3 moneyapp3 = new moneyapp_3();
                        moneyapp3.setItemType(4);
                        arrayList.add(size, moneyapp3);
                    }
                }
                EarnMoney_110.this.arrVideoList.clear();
                EarnMoney_110.this.mAdapter.notifyDataSetChanged();
                EarnMoney_110.this.recyclerVideoList.post(new Runnable() {
                    @Override
                    public void run() {
                        EarnMoney_110.this.arrVideoList.addAll(arrayList);
                        EarnMoney_110.this.mAdapter.notifyDataSetChanged();
                    }
                });
            }
        });
    }


    private void getUpdateApi() {
        int i = 0;
        Integer num = null;
        if (this.imageBannerModel.getItemType() != -11) {
            addImageBanner();
            /*i = null;*/
        } else {
            i = 1;
        }
        if (this.promoBannerModel.getItemType() != -11) {
            addPromoBanner();
        } else {
            num = i;
        }
        if (num != null) {
            moneyapp_2.Instance().getUpdates(getActivity(), new moneyapp_2.ApiDelegate() {

                @Override
                public void OnFailure(String str) {
                }

                @Override
                public void OnSuccsess(moneyapp_3 moneyapp3, moneyapp_3 moneyapp32) {
                    EarnMoney_110.this.imageBannerModel = moneyapp32;
                    EarnMoney_110.this.promoBannerModel = moneyapp3;
                    if (EarnMoney_110.this.imageBannerModel.getItemType() != -11) {
                        EarnMoney_110.this.addImageBanner();
                    }
                    if (EarnMoney_110.this.promoBannerModel.getItemType() != -11) {
                        EarnMoney_110.this.addPromoBanner();
                    }
                }
            });
        }
    }


    private void init() {
        AVLoadingIndicatorView aVLoadingIndicatorView = (AVLoadingIndicatorView) this.v.findViewById(R.id.avLoadData);
        this.avLoadData = aVLoadingIndicatorView;
        aVLoadingIndicatorView.setVisibility(8);
        RecyclerView recyclerView = (RecyclerView) this.v.findViewById(R.id.recyclerVideoList);
        this.recyclerVideoList = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.recyclerVideoList.setItemAnimator(new DefaultItemAnimator());
        this.swipeToRefresh = (SwipeRefreshLayout) this.v.findViewById(R.id.swipeToRefresh);
        this.txtError = (TextView) this.v.findViewById(R.id.txtError);
        this.btnRetry = (CardView) this.v.findViewById(R.id.btnRetry);
        this.imgError = (ImageView) this.v.findViewById(R.id.imgError);
        this.imgTotheTop = (ImageView) this.v.findViewById(R.id.imgTotheTop);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        this.mAdapter = new EarnMoney_118(this.videoIdentifyer, displayMetrics.widthPixels, getActivity(), this.arrVideoList, this.fragmentIdentifyer, new EarnMoney_118.ItemClickDelegate() {
            @Override
            public void onItemClick(final int i, boolean z) {
                Intent intent = new Intent(EarnMoney_110.this.getActivity(), realcash.class);
                intent.putExtra("Video", ((moneyapp_3) EarnMoney_110.this.arrVideoList.get(i)).getVideoPath());
                intent.putExtra("Title", ((moneyapp_3) EarnMoney_110.this.arrVideoList.get(i)).getTitle());
                intent.putExtra("Image", ((moneyapp_3) EarnMoney_110.this.arrVideoList.get(i)).getThumb());
                EarnMoney_110.this.startActivity(intent);
            }

            @Override
            public void onItemDelete() {
                EarnMoney_110.this.getSavedFiles();
            }
        });

        this.recyclerVideoList.setHasFixedSize(true);
        this.recyclerVideoList.setAdapter(this.mAdapter);
        this.recyclerVideoList.setItemViewCacheSize(20);
        this.loadingModel.setItemType(5);
    }

    public static EarnMoney_110 newInstance(int i, int i2) {
        EarnMoney_110 earnMoney110 = new EarnMoney_110();
        earnMoney110.fragmentIdentifyer = i;
        earnMoney110.videoIdentifyer = i2;
        return earnMoney110;
    }

    private void setFeatureVideos() {
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < this.arrVideoList.size(); i4++) {
            if (this.arrVideoList.get(i4).getItemType() == 1) {
                i3 = 1;
            }
        }
        if (i3 == i) {
            for (int i5 = 0; i5 < this.arrVideoList.size(); i5++) {
                if (this.arrVideoList.get(i5).getItemType() == 15) {
                    i = 1;
                }
            }
            if (i != 0) {
                i2 = 1;
            }
            this.mAdapter.notifyItemInserted(i2);
            this.mAdapter.notifyItemRangeChanged(i2, this.arrVideoList.size());
            if (i == 0) {
                this.recyclerVideoList.scrollToPosition(i2);
            }
        }
    }


    private void setShadow() {
        try {
            EarnMoney_114 dashboardFrag = (EarnMoney_114) getParentFragment();
            if (dashboardFrag != null) {
                if (this.overallXScroll > 0) {
                    dashboardFrag.showAppBarShadow();
                } else {
                    dashboardFrag.hideShadow();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.v = layoutInflater.inflate(R.layout.videoearnmoney, viewGroup, false);
        init();
        if (this.fragmentIdentifyer == 9) {
            this.recyclerVideoList.setPadding(0, (int) RealMoney_109.Instance().DpToPx(10.0f, getActivity()), 0, (int) RealMoney_109.Instance().DpToPx(90.0f, getActivity()));
        }
        this.modelListTitle.setTitle("Latest");
        if (this.fragmentIdentifyer != 9) {
            this.recyclerVideoList.addOnScrollListener(new RecyclerView.OnScrollListener() {
                @Override 
                public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                    super.onScrollStateChanged(recyclerView, i);
                    if (!(EarnMoney_110.this.recyclerVideoList.canScrollVertically(1) || EarnMoney_110.this.isLoading || EarnMoney_110.this.mAdapter == null || EarnMoney_110.this.threshol <= EarnMoney_110.this.page)) {
                        EarnMoney_110.this.isLoading = true;
                        int i2 = i;
                        for (int i3 = 0; i3 < EarnMoney_110.this.arrVideoList.size(); i3++) {
                            if (((moneyapp_3) EarnMoney_110.this.arrVideoList.get(i3)).getItemType() == 5) {
                                i2 = 1;
                            }
                        }
                        if (i2 == i) {
                            EarnMoney_110.this.recyclerVideoList.post(new Runnable() {
                                @Override
                                public void run() {
                                    EarnMoney_110.this.arrVideoList.add(EarnMoney_110.this.loadingModel);
                                    EarnMoney_110.this.mAdapter.notifyItemInserted(EarnMoney_110.this.arrVideoList.size() - 1);
                                    EarnMoney_110.this.mAdapter.notifyItemRangeChanged(EarnMoney_110.this.arrVideoList.size() - 1, EarnMoney_110.this.arrVideoList.size());
                                    EarnMoney_110.this.recyclerVideoList.scrollToPosition(EarnMoney_110.this.arrVideoList.size() - 1);
                                }
                            });
                        }
                        EarnMoney_110.this.getData(false, false);
                    }
                }
            });
        }
        int i = this.fragmentIdentifyer;
        if (i == 6) {
            if (this.videoIdentifyer == RealMoney_105.IS_FULLSCREEN_VIDEOS) {
                this.arrVideoList.addAll(cashearning6.Instance().getArrVideos());
                if (this.arrVideoList.size() > 0) {
                    int i2 = i;
                    for (int i3 = 0; i3 < this.arrVideoList.size(); i3++) {
                        if (this.arrVideoList.get(i3).getItemType() == 14) {
                            i2 = 1;
                        }
                    }
                    if (i2 == i) {
                        this.arrVideoList.add(0, this.modelListTitle);
                    }
                    this.page++;
                    this.threshol = 2;
                    this.mAdapter.notifyDataSetChanged();
                    this.recyclerVideoList.post(new Runnable() {
                        @Override
                        public void run() {
                            EarnMoney_103 Instance = EarnMoney_103.Instance();
                            EarnMoney_103.Instance().getClass();
                            if (Instance.getIntPref("rate_notification_count") == 3) {
                                int i = 0;
                                for (int i2 = 0; i2 < EarnMoney_110.this.arrVideoList.size(); i2++) {
                                    if (((moneyapp_3) EarnMoney_110.this.arrVideoList.get(i2)).getItemType() == 15) {
                                        i = 1;
                                    }
                                }
                                if (i == 0) {
                                    EarnMoney_110.this.arrVideoList.add(0, EarnMoney_110.this.notificationDialogModel);
                                    EarnMoney_110.this.mAdapter.notifyItemInserted(0);
                                    EarnMoney_110.this.mAdapter.notifyItemRangeChanged(0, EarnMoney_110.this.arrVideoList.size());
                                    EarnMoney_110.this.recyclerVideoList.post(new Runnable() {
                                        @Override
                                        public void run() {
                                            EarnMoney_110.this.recyclerVideoList.scrollToPosition(0);
                                        }
                                    });
                                }
                            }
                            EarnMoney_110.this.getUpdateApi();
                        }
                    });
                } else {
                    getData(true, false);
                }
            } else {
                getData(true, false);
            }
        } else if (i == 9) {
            this.swipeToRefresh.setEnabled(false);
            getSavedFiles();
            LocalBroadcastManager.getInstance(getActivity()).registerReceiver(this.newVideoDownloadedReciver, new IntentFilter(RealMoney_105.BRODCAST_REFRASH_SAVED_LIST));
        } else {
            getData(true, false);
        }

        this.swipeToRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                if (EarnMoney_110.this.fragmentIdentifyer != 9) {
                    EarnMoney_110.this.page = 0;
                    EarnMoney_110.this.overallXScroll = 0;
                    EarnMoney_110.this.getData(false, true);
                }
            }
        });

        this.smoothScroller = new LinearSmoothScroller(getActivity()) {
            public int e() {
                return -1;
            }
        };


        this.imgTotheTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EarnMoney_110.this.smoothScroller.setTargetPosition(0);
                EarnMoney_110.this.recyclerVideoList.getLayoutManager().startSmoothScroll(EarnMoney_110.this.smoothScroller);
            }
        });


        this.recyclerVideoList.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                int findLastCompletelyVisibleItemPosition = ((LinearLayoutManager) recyclerView.getLayoutManager()).findLastCompletelyVisibleItemPosition();
                if (findLastCompletelyVisibleItemPosition == -1 || findLastCompletelyVisibleItemPosition < 8) {
                    if (findLastCompletelyVisibleItemPosition != -1) {
                        EarnMoney_110.this.imgTotheTop.animate().scaleY(0.0f).scaleX(0.0f).withEndAction(new Runnable() {
                            @Override
                            public void run() {
                                EarnMoney_110.this.imgTotheTop.setVisibility(8);
                            }
                        }).setDuration(100).start();
                    }
                } else if (EarnMoney_110.this.imgTotheTop.getVisibility() != 0) {
                    EarnMoney_110.this.imgTotheTop.setVisibility(0);
                    EarnMoney_110.this.imgTotheTop.setScaleX(0.0f);
                    EarnMoney_110.this.imgTotheTop.setScaleY(0.0f);
                    EarnMoney_110.this.imgTotheTop.animate().scaleY(1.0f).scaleX(1.0f).setDuration(200).start();
                }
                EarnMoney_110.this.overallXScroll += i2;
                EarnMoney_110.this.setShadow();
                super.onScrolled(recyclerView, i, i2);
            }
        });

        this.btnRetry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EarnMoney_110.this.getData(true, false);
            }
        });

        if (this.fragmentIdentifyer == 6) {
            getFeatureVideos();
        }

        return this.v;
    }

    @Override 
    public void onDestroy() {
        super.onDestroy();
        if (this.fragmentIdentifyer == 6) {
            LocalBroadcastManager.getInstance(getActivity()).unregisterReceiver(this.newVideoDownloadedReciver);
        }
    }

    public void refrashDataWithNewValue() {
        try {
            if (!this.isLoading) {
                this.isLoading = true;
                this.arrVideoList.clear();
                this.mAdapter.notifyDataSetChanged();
                EarnMoney_103 Instance = EarnMoney_103.Instance();
                EarnMoney_103.Instance().getClass();
                int intPref = Instance.getIntPref("home_api_calling");
                if (intPref == 2) {
                    this.modelListTitle.setTitle("Random");
                } else if (intPref == 1) {
                    this.modelListTitle.setTitle("Latest");
                } else {
                    this.modelListTitle.setTitle(EarnMoney_115.POPULAR_TAB_TITLE);
                }
                this.page = 0;
                this.overallXScroll = 0;
                getData(true, true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setLangDataBySelection() {
        this.page = 0;
        this.overallXScroll = 0;
        getData(true, true);
    }

    @Override 
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (z && this.recyclerVideoList != null) {
            setShadow();
        }
    }

}