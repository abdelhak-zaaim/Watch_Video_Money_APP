package watchvideo.dailytrend.Realmoney_3.realmoney_47;

import static watchvideo.dailytrend.Earnmoney.earnmoney.quera_link;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.facebook.shimmer.ShimmerFrameLayout;
import com.google.android.gms.common.internal.ImagesContract;
import com.onesignal.shortcutbadger.impl.NewHtcHomeBadger;
import watchvideo.dailytrend.Earnmoney_2.EarnMoney_82;
import watchvideo.dailytrend.Earnmoney.earnmoney;
import watchvideo.dailytrend.Earnmoney.realmoney;

import watchvideo.dailytrend.Earnmoney.realmoney14;
import watchvideo.dailytrend.Earnmoney.realmoney13;
import watchvideo.dailytrend.Earnmoney.realmoney12;
import watchvideo.dailytrend.Earnmoney.realmoney21;
import watchvideo.dailytrend.realmoney_24;
import watchvideo.dailytrend.R;
import watchvideo.dailytrend.Realmoney_3.realmoney_47.realmoney_46.realmoney_43;
import watchvideo.dailytrend.Realmoney_3.realmoney_47.realmoney_46.realmoney_44;
import watchvideo.dailytrend.Realmoney_3.earnmoney_35.earnmoney_26;
import watchvideo.dailytrend.Realmoney_3.earnmoney_35.earnmoney_25;
import watchvideo.dailytrend.Realmoney_3.realmoney_35.earnmoney_30;
import watchvideo.dailytrend.Realmoney_3.realmoney_35.earnmoney_34.realmoney_26;
import watchvideo.dailytrend.Realmoney_3.realmoney_35.earnmoney_34.realmoney_25;
import watchvideo.dailytrend.Realmoney_3.earnmoney_46.earnmoney_44;
import watchvideo.dailytrend.Realmoney_3.earnmoney_46.earnmoney_39;
import watchvideo.dailytrend.Realmoney_3.earnmoney_46.earnmoney_45;
import java.util.ArrayList;
import java.util.Collections;

public class realmoney_40 extends earnmoney_44 implements realmoney_44, earnmoney_25.onFavoriteClick, SwipeRefreshLayout.OnRefreshListener {
    earnmoney_25 adapter;
    int categoryId = 53;
    String categoryName = "All";
    ArrayList<realmoney_26> dataItems = new ArrayList<>();
    private earnmoney_39 db;
    private String default_lang = "";
    private String default_type = "latest";
    ImageView imgThumbVideo;
    private boolean isLastPage = false;
    private boolean isPopular = false;
    private boolean isRandom = false;
    private boolean islatest = true;
    earnmoney_26 earnmoney26;
    private String last_lang = "";
    LinearLayout loaderLayout;
    private int page = 1;
    RecyclerView rcvList;
    SwipeRefreshLayout refreshLayout;
    ArrayList<earnmoney_30> tagitems;
    Toolbar toolbar;
    RecyclerView trendingTags;
    TextView txtLatest;
    TextView txtMessage;
    TextView txtPopular;
    TextView txtRandom;

    RelativeLayout adContainerView, adContainerPlaylist;
    ShimmerFrameLayout main_act_banner;

    static int access$408(realmoney_40 realmoney40) {
        int i = realmoney40.page;
        realmoney40.page = i + 1;
        return i;
    }

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(1024, 1024);
        setContentView(R.layout.earnmoney);
        this.tagitems = new ArrayList<>();
        this.default_type = getIntent().getStringExtra("category");
        Log.e("----default_type", "----default_type" + this.default_type);
        this.imgThumbVideo = (ImageView) findViewById(R.id.imgThumbVideo);
        this.loaderLayout = (LinearLayout) findViewById(R.id.loader_layout);
        this.rcvList = (RecyclerView) findViewById(R.id.rcvList);
        this.refreshLayout = (SwipeRefreshLayout) findViewById(R.id.refresh_layout);
        this.toolbar = (Toolbar) findViewById(R.id.toolbar);
        this.trendingTags = (RecyclerView) findViewById(R.id.trending_tags);
        this.txtLatest = (TextView) findViewById(R.id.txtLatest);
        this.txtMessage = (TextView) findViewById(R.id.txtMessage);
        this.txtPopular = (TextView) findViewById(R.id.txtPopular);
        this.txtRandom = (TextView) findViewById(R.id.txtRandom);
        this.db = new earnmoney_39(this);
        setLayoutManager();
        initData();
        setActionBar();
        getVideoList(this.default_type);

        toolbar.setTitleTextColor(getResources().getColor(android.R.color.white));


        //Banner :-
        adContainerView = findViewById(R.id.adViewContainer);
        adContainerPlaylist = findViewById(R.id.adViewContainer);
        main_act_banner = findViewById(R.id.main_act_banner);


        if (earnmoney.isAdOn) {
            if (earnmoney.ad_mode.equalsIgnoreCase("admob")) {
                realmoney.creteadadaptiveBanner(realmoney_40.this, adContainerPlaylist, earnmoney.admob_banner_id);
            } else if (earnmoney.ad_mode.equalsIgnoreCase("qureka")) {
                main_act_banner.setVisibility(View.VISIBLE);
            } else {
                adContainerView.setBackgroundResource(R.drawable.realmoney_140);
                realmoney13.createFBLoadBanner(realmoney_40.this, adContainerPlaylist, earnmoney.facebook_banner_id);
            }
        }


        main_act_banner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent1 = new Intent("android.intent.action.VIEW");
                    Bundle bundle = new Bundle();
                    int i = Build.VERSION.SDK_INT;
                    bundle.putBinder("android.support.customtabs.extra.SESSION", null);
                    intent1.putExtras(bundle);
                    intent1.putExtra("android.support.customtabs.extra.TOOLBAR_COLOR", R.color.colorPrimary);
                    intent1.putExtra("android.support.customtabs.extra.EXTRA_ENABLE_INSTANT_APPS", true);
                    intent1.setPackage("com.android.chrome");
                    intent1.setData(Uri.parse(quera_link));
                    startActivity(intent1, bundle);
                } catch (Exception e) {
                    e.printStackTrace();
                    Intent intent1 = new Intent("android.intent.action.VIEW");
                    Bundle bundle = new Bundle();
                    int i = Build.VERSION.SDK_INT;
                    bundle.putBinder("android.support.customtabs.extra.SESSION", null);
                    intent1.putExtras(bundle);
                    intent1.putExtra("android.support.customtabs.extra.TOOLBAR_COLOR", R.color.colorPrimary);
                    intent1.putExtra("android.support.customtabs.extra.EXTRA_ENABLE_INSTANT_APPS", true);
                    intent1.setData(Uri.parse(quera_link));
                    startActivity(intent1, bundle);
                }
            }
        });

    }

    public void setActionBar() {
        setSupportActionBar(this.toolbar);
        getSupportActionBar().setTitle(this.default_type);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void initData() {
        this.refreshLayout.setColorSchemeColors(ContextCompat.getColor(this, R.color.colorPrimary), ContextCompat.getColor(this, R.color.colorAccent), ContextCompat.getColor(this, R.color.colorPrimaryDark));
        this.refreshLayout.setOnRefreshListener(this);
    }


    public void setLanguage() {
        ArrayList<earnmoney_30> arrayList = this.tagitems;
        if (arrayList != null && arrayList.size() > 0) {
            this.tagitems.clear();
        }
        int i = 0;
        while (i < realmoney_24.getInstance().getLanguages().size()) {
            earnmoney_30 earnmoney302 = new earnmoney_30();
            earnmoney302.setSelected(i == 0);
            earnmoney302.setmTagId(realmoney_24.getInstance().getLanguages().get(i).getId());
            earnmoney302.setmTagName(realmoney_24.getInstance().getLanguages().get(i).getName());
            this.tagitems.add(earnmoney302);
            i++;
        }
        Log.d("tag", "size :: " + this.tagitems.size());
        this.earnmoney26 = new earnmoney_26(this.tagitems, this);
        this.trendingTags.setLayoutManager(new LinearLayoutManager(this, 0, false));
        this.trendingTags.setAdapter(this.earnmoney26);
        setAdapterClick();
    }


    public void setAdapterClick() {
        this.earnmoney26.setOnItemClickListener(new earnmoney_26.SetOnItemClickListener() {
            @Override
            public void OnItemClick(View view, int i) {
                if (realmoney_40.this.loaderLayout != null && realmoney_40.this.loaderLayout.getVisibility() == 0) {
                    return;
                }
                if ((!realmoney_40.this.default_lang.equals("") || i != 0) && !realmoney_40.this.last_lang.equals(String.valueOf(realmoney_40.this.tagitems.get(i).getmTagId()))) {
                    for (int i2 = 0; i2 < realmoney_40.this.tagitems.size(); i2++) {
                        if (i2 == i) {
                            realmoney_40.this.tagitems.get(i2).setSelected(true);
                        } else {
                            realmoney_40.this.tagitems.get(i2).setSelected(false);
                        }
                    }
                    realmoney_40.this.earnmoney26.refreshData(realmoney_40.this.tagitems);
                    if (realmoney_40.this.tagitems.get(i).getmTagId() == 0) {
                        realmoney_40.this.default_lang = "";
                    } else {
                        realmoney_40 realmoney40 = realmoney_40.this;
                        realmoney40.default_lang = String.valueOf(realmoney40.tagitems.get(i).getmTagId());
                    }
                    realmoney_40 realmoney402 = realmoney_40.this;
                    realmoney402.last_lang = realmoney402.default_lang;
                    realmoney_40.this.dataItems.clear();
                    realmoney_40.this.adapter.notifyDataSetChanged();
                    realmoney_40 realmoney403 = realmoney_40.this;
                    realmoney403.getVideoList(realmoney403.default_type);
                }
            }
        });

    }



    public void setLayoutManager() {
        this.rcvList.setHasFixedSize(true);
        this.rcvList.setDrawingCacheEnabled(true);
        this.rcvList.setDrawingCacheQuality(1048576);
        this.rcvList.setLayoutManager(new GridLayoutManager(this, 1));
    }


    public void getVideoList(String str) {
        if (isInternetOn()) {
            this.txtMessage.setVisibility(8);
            this.loaderLayout.setVisibility(0);
            realmoney_43.getInstance().setListener(this, this.categoryId, str, "", this.page, this.default_lang);
            return;
        }
        showNetworkAlert();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override 
    public void onBackPressed() {
        if (earnmoney.isAdOn) {
            if (earnmoney.ad_mode.equalsIgnoreCase("admob")) {
                if (realmoney12.isInternetOn(realmoney_40.this)) {
                    realmoney12.getInstance().loadintertialads(realmoney_40.this, earnmoney.admob_inter_id, new realmoney12.MyCallback() {
                        @Override
                        public void callbackCall() {
                            startActivity(new Intent(realmoney_40.this, EarnMoney_82.class));
                        }
                    });
                } else {
                    startActivity(new Intent(realmoney_40.this, EarnMoney_82.class));
                }
            } else if (earnmoney.ad_mode.equalsIgnoreCase("qureka")) {

                realmoney14.getInstance().qureka_inter(realmoney_40.this, new realmoney14.MyCallback() {
                    @Override
                    public void callbackCall() {
                        startActivity(new Intent(realmoney_40.this, EarnMoney_82.class));
                    }
                });

            } else {

                if (realmoney21.isInternetOn(realmoney_40.this)) {
                    realmoney21.getInstance().loadintertialads(realmoney_40.this, earnmoney.facebook_inter_id, new realmoney21.MyCallback() {
                        @Override
                        public void callbackCall() {
                            startActivity(new Intent(realmoney_40.this, EarnMoney_82.class));
                        }
                    });
                } else {
                    startActivity(new Intent(realmoney_40.this, EarnMoney_82.class));
                }
            }

        } else {
            startActivity(new Intent(realmoney_40.this, EarnMoney_82.class));
        }

    }


    @Override
    public void onGetVideoList(realmoney_25 realmoney25) {
        LinearLayout linearLayout = this.loaderLayout;
        if (linearLayout != null && linearLayout.getVisibility() == 0) {
            this.loaderLayout.setVisibility(8);
        }
        this.dataItems.addAll(realmoney25.getData());
        if (realmoney25.getData() == null || realmoney25.getData().size() <= 0) {
            this.isLastPage = true;
        } else if (realmoney25.getData().size() < 15) {
            this.isLastPage = true;
        } else {
            this.isLastPage = false;
        }
        setAdapter();
        if (this.page == 1) {
            ArrayList<realmoney_26> arrayList = this.dataItems;
            if (arrayList != null && arrayList.size() <= 0) {
                this.txtMessage.setVisibility(0);
                this.txtMessage.setText("No Video Found !!");
            } else if (this.dataItems == null) {
                this.txtMessage.setVisibility(0);
                this.txtMessage.setText("No Video Found !!");
            }
        }
    }


    @Override
    public void onRefresh() {
        this.refreshLayout.setRefreshing(false);
        if (earnmoney_45.isNetworkAvailable(this)) {
            this.page = 1;
            this.dataItems.clear();
            this.adapter.notifyDataSetChanged();
            getVideoList(this.default_type);
            return;
        }
        this.refreshLayout.setRefreshing(false);
    }


    public void setAdapter() {
        earnmoney_25 earnmoney25 = this.adapter;
        if (earnmoney25 == null) {
            this.adapter = new earnmoney_25(this.dataItems, this, this, this.db) {
                @Override
                public void Load() {
                    Log.d("tag", "isLastpage : " + realmoney_40.this.isLastPage);
                    if (!realmoney_40.this.isLastPage) {
                        realmoney_40.access$408(realmoney_40.this);
                        realmoney_40 realmoney40 = realmoney_40.this;
                        realmoney40.getVideoList(realmoney40.default_type);
                    } else if (realmoney_40.this.page > 1) {
                        realmoney_40.this.showToast("No More Videos !!");
                    }
                }
            };
            Collections.shuffle(this.dataItems);
            this.rcvList.setAdapter(this.adapter);
        } else {
            earnmoney25.notifyDataSetChanged();
        }

        this.adapter.setOnItemClickListener(new earnmoney_25.OnItemClicked() {
            @Override
            public void onClick(int i) {
                earnmoney_45.dataItems = realmoney_40.this.dataItems;
                earnmoney_45.SelectedVideo = i;
                Intent intent = new Intent(realmoney_40.this, realmoney_41.class);
                intent.putExtra("pos", realmoney_40.this.dataItems.get(i));
                intent.putExtra(ImagesContract.URL, realmoney_40.this.dataItems.get(i).getVideo());
                intent.putExtra("id", realmoney_40.this.dataItems.get(i).getId());
                intent.putExtra("name", realmoney_40.this.dataItems.get(i).getName());
                intent.putExtra("size", realmoney_40.this.dataItems.get(i).getFileSize());
                intent.putExtra(NewHtcHomeBadger.COUNT, realmoney_40.this.dataItems.get(i).getViewCounter());
                realmoney_40.this.startActivity(intent);
                realmoney_40.this.finish();
                realmoney_40.this.overridePendingTransition(R.anim.realmoneyapp, R.anim.videocall);
            }
        });
    }

    @Override
    public void onFavClick(realmoney_26 modelVideo, String str) {
        if (str.equals("ADD")) {
            this.db.Add_To_Fav_Video(modelVideo);
        } else {
            this.db.deleteFav(String.valueOf(modelVideo.getId()), earnmoney_39.TABLE_FAVORITE_VIDEO, "video_id");
        }
    }

    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnLatest :
                LinearLayout linearLayout = this.loaderLayout;
                if ((linearLayout == null || linearLayout.getVisibility() != 0) && !this.islatest) {
                    this.islatest = true;
                    this.isPopular = false;
                    this.isRandom = false;
                    this.page = 1;
                    this.default_type = "latest";
                    this.dataItems.clear();
                    getVideoList(this.default_type);
                    this.txtLatest.setTextColor(getResources().getColor(R.color.black));
                    this.txtPopular.setTextColor(getResources().getColor(R.color.colorAccent));
                    this.txtRandom.setTextColor(getResources().getColor(R.color.colorAccent));
                    return;
                }
                return;
            default:
                return;

            case R.id.btnPopular :
                LinearLayout linearLayout2 = this.loaderLayout;
                if ((linearLayout2 == null || linearLayout2.getVisibility() != 0) && !this.isPopular) {
                    this.isPopular = true;
                    this.islatest = false;
                    this.isRandom = false;
                    this.page = 1;
                    this.default_type = "popular";
                    this.dataItems.clear();
                    getVideoList(this.default_type);
                    this.txtLatest.setTextColor(getResources().getColor(R.color.colorAccent));
                    this.txtPopular.setTextColor(getResources().getColor(R.color.black));
                    this.txtRandom.setTextColor(getResources().getColor(R.color.colorAccent));
                    return;
                }
                return;

            case R.id.btnRandom :
                LinearLayout linearLayout3 = this.loaderLayout;
                if ((linearLayout3 == null || linearLayout3.getVisibility() != 0) && !this.isRandom) {
                    this.isRandom = true;
                    this.islatest = false;
                    this.isPopular = false;
                    this.page = 1;
                    this.default_type = "random";
                    this.dataItems.clear();
                    getVideoList(this.default_type);
                    this.txtLatest.setTextColor(getResources().getColor(R.color.colorAccent));
                    this.txtPopular.setTextColor(getResources().getColor(R.color.colorAccent));
                    this.txtRandom.setTextColor(getResources().getColor(R.color.black));
                    return;
                }
                return;
        }
    }
}
