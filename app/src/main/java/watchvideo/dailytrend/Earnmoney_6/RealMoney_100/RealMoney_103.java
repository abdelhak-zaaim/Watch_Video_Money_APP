package watchvideo.dailytrend.Earnmoney_6.RealMoney_100;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.metadata.icy.IcyHeaders;
import com.google.android.material.appbar.AppBarLayout;
import com.miguelcatalan.materialsearchview.MaterialSearchView;
import com.wang.avi.AVLoadingIndicatorView;

import watchvideo.dailytrend.Earnmoney_6.EarnMoney_104.cashearning4;
import watchvideo.dailytrend.Earnmoney_6.EarnMoney_106.EarnMoney_117;
import watchvideo.dailytrend.Earnmoney_6.EarnMoney_106.EarnMoney_118;
import watchvideo.dailytrend.Earnmoney_6.EarnMoney_108.EarnMoney_111;
import watchvideo.dailytrend.Earnmoney_6.RealMoney_104.RealMoney_105;
import watchvideo.dailytrend.Earnmoney_6.RealMoney_104.RealMoney_109;
import watchvideo.dailytrend.Earnmoney_6.EarnMoney_104.cashearning6;
import watchvideo.dailytrend.Earnmoney_6.EarnMoney_104.moneyapp_3;
import watchvideo.dailytrend.R;

import java.util.ArrayList;

@SuppressLint("WrongConstant")

public class RealMoney_103 extends AppCompatActivity {
    private int animationHeight;
    private AppBarLayout appBar;
    private ArrayList<moneyapp_3> arrSearched = new ArrayList<>();
    private ArrayList<moneyapp_3> arrSuggVideos = new ArrayList<>();
    private AsyncTask asyncTask;
    private AVLoadingIndicatorView avLoadData;
    private String categoryId = IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE;
    private ConstraintLayout clFillter;
    private int identifyer = -1;
    private String imgTitle;
    private ImageView imgTotheTop;
    private boolean isFilterOpen = false;
    private boolean isLoading = false;
    protected EarnMoney_111 k;
    private moneyapp_3 loadMoreModel = new moneyapp_3(5);
    private String order_by = "created_at";
    private String order_by_type = "desc";
    private int overallXScroll = 0;
    private int page = 0;
    private AppCompatRadioButton rbMostPopular;
    private AppCompatRadioButton rbNewToOld;
    private RecyclerView recyclerSearchedVideo;
    private RecyclerView recyclerSuggestion;
    private EarnMoney_118 savedAdapter;
    private MaterialSearchView searchView;
    private String searchedResult;
    private moneyapp_3 smallBannerAds = new moneyapp_3(16);
    private EarnMoney_117 suggAdapter;
    private int thresholHome = 1;
    private Toolbar toolbar;
    private TextView txtError;
    private TextView txtTitle;
    private int videoIdentifyer = 0;
    private View viewMostPopular;
    private View viewNewToOld;
    private View viewSearchDisable;

    private void filterSearchData(final String str) {
        if (TextUtils.isEmpty(str)) {
            this.arrSuggVideos.clear();
            this.suggAdapter.notifyDataSetChanged();
            return;
        }

        this.suggAdapter.changeSearch(str);

        AsyncTask asyncTask2 = this.asyncTask;
        if (asyncTask2 != null && (asyncTask2.getStatus() == AsyncTask.Status.RUNNING || this.asyncTask.getStatus() == AsyncTask.Status.PENDING)) {
            this.asyncTask.cancel(true);
        }

        this.asyncTask = new AsyncTask<Void, Void, ArrayList<moneyapp_3>>() {

            public ArrayList<moneyapp_3> doInBackground(Void... voidArr) {
                try {
                    return RealMoney_103.this.k.searchInDb(str, RealMoney_103.this.videoIdentifyer);
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            }
            
            public void onPostExecute(ArrayList<moneyapp_3> arrayList) {
                super.onPostExecute(arrayList);
                if (arrayList != null) {
                    RealMoney_103.this.arrSuggVideos.clear();
                    RealMoney_103.this.arrSuggVideos.addAll(arrayList);
                    RealMoney_103.this.suggAdapter.notifyDataSetChanged();
                }
            }
        }.execute(new Void[0]);

    }

    private void getValueBySearchFilter(boolean z) {
        if (z) {
            this.avLoadData.setVisibility(0);
        }
        this.txtError.setVisibility(8);
        this.page++;
        cashearning4.Instance().getVideoListBySearched(this.videoIdentifyer, this.identifyer, this.order_by, this.order_by_type, this.searchedResult, this.page, 24, new cashearning4.ApiDelegate<moneyapp_3>() {
            @Override
            public void OnFailure(String str) {
                RealMoney_103.this.removeLoading();
                RealMoney_103.this.avLoadData.setVisibility(8);
                RealMoney_103.this.txtError.setVisibility(0);
                RealMoney_103.this.txtError.setText(str);
                RealMoney_103.this.isLoading = false;
                RealMoney_103 realMoney103 = RealMoney_103.this;
                realMoney103.page--;
            }

            @Override
            public void OnSuccsess(ArrayList<moneyapp_3> arrayList, int i) {
                RealMoney_103.this.removeLoading();
                RealMoney_103.this.thresholHome = (int) Math.ceil((double) (Float.parseFloat(String.valueOf(i)) / 24.0f));
                RealMoney_103.this.avLoadData.setVisibility(8);
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    if (i2 % 5 == 0 && i2 != 0) {
                        moneyapp_3 moneyapp3 = new moneyapp_3();
                        moneyapp3.setItemType(4);
                        arrayList.add(i2, moneyapp3);
                    }
                }
                RealMoney_103.this.arrSearched.addAll(arrayList);
                cashearning6.Instance().setArrSearchedVideos(RealMoney_103.this.arrSearched);
                RealMoney_103.this.savedAdapter.notifyDataSetChanged();
                RealMoney_103.this.isLoading = false;
            }
        });

    }

    private void hideFilterOption() {
        this.isFilterOpen = false;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.clFillter, "translationY", 0.0f, (float) this.animationHeight);
        ofFloat.setDuration(200L);
        ofFloat.start();
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setInterpolator(new AccelerateInterpolator());
        alphaAnimation.setDuration(100);
        this.viewSearchDisable.setAnimation(alphaAnimation);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                RealMoney_103.this.viewSearchDisable.setVisibility(8);
            }
        }, 100);
    }

    private void init() {
        this.appBar = (AppBarLayout) findViewById(R.id.appBar);
        if (Build.VERSION.SDK_INT >= 21) {
            this.appBar.setElevation(0.0f);
        }
        this.clFillter = (ConstraintLayout) findViewById(R.id.clFillter);
        this.txtTitle = (TextView) findViewById(R.id.txtTitle);
        this.searchView = (MaterialSearchView) findViewById(R.id.search_view);
        this.imgTotheTop = (ImageView) findViewById(R.id.imgTotheTop);
        this.recyclerSearchedVideo = (RecyclerView) findViewById(R.id.recyclerSearchedVideo);
        if (this.videoIdentifyer == RealMoney_105.IS_FULLSCREEN_VIDEOS) {
            this.recyclerSearchedVideo.setLayoutManager(new GridLayoutManager(this, 2));
            ((GridLayoutManager) this.recyclerSearchedVideo.getLayoutManager()).setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int i) {
                    int itemViewType = RealMoney_103.this.savedAdapter.getItemViewType(i);
                    if (itemViewType == 4) {
                        return 1;
                    }
                    if (itemViewType == 16 || itemViewType == 5) {
                        return 2;
                    }
                    return (itemViewType == 0 || itemViewType != 1) ? 1 : 2;
                }
            });
        } else {
            this.recyclerSearchedVideo.setLayoutManager(new LinearLayoutManager(this));
        }


        this.recyclerSearchedVideo.setItemAnimator(new DefaultItemAnimator());
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        EarnMoney_118 earnMoney118 = new EarnMoney_118(this.videoIdentifyer, displayMetrics.widthPixels, this, this.arrSearched, this.identifyer, new EarnMoney_118.ItemClickDelegate() {
            @Override
            public void onItemDelete() {

            }

            @Override
            public void onItemClick(int i, boolean z) {
                Intent intent = new Intent(RealMoney_103.this, realcash.class);
                intent.putExtra("Video", ((moneyapp_3) RealMoney_103.this.arrSearched.get(i)).getVideoPath());
                intent.putExtra("Title", ((moneyapp_3) RealMoney_103.this.arrSearched.get(i)).getTitle());
                intent.putExtra("Image", ((moneyapp_3) RealMoney_103.this.arrSearched.get(i)).getThumb());
                RealMoney_103.this.startActivity(intent);
            }
        });


        this.savedAdapter = earnMoney118;
        this.recyclerSearchedVideo.setAdapter(earnMoney118);
        this.viewMostPopular = findViewById(R.id.viewMostPopular);
        this.viewNewToOld = findViewById(R.id.viewNewToOld);
        this.rbNewToOld = (AppCompatRadioButton) findViewById(R.id.rbNewToOld);
        this.rbMostPopular = (AppCompatRadioButton) findViewById(R.id.rbMostPopular);
        Toolbar toolbar2 = (Toolbar) findViewById(R.id.toolbar);
        this.toolbar = toolbar2;
        toolbar2.bringToFront();
        setSupportActionBar(this.toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        AVLoadingIndicatorView aVLoadingIndicatorView = (AVLoadingIndicatorView) findViewById(R.id.avLoadData);
        this.avLoadData = aVLoadingIndicatorView;
        aVLoadingIndicatorView.setVisibility(8);
        this.txtError = (TextView) findViewById(R.id.txtError);
        View findViewById = findViewById(R.id.viewSearchDisable);
        this.viewSearchDisable = findViewById;
        findViewById.setVisibility(8);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerSuggestion);
        this.recyclerSuggestion = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.recyclerSuggestion.setItemAnimator(new DefaultItemAnimator());

        this.suggAdapter = new EarnMoney_117(this, this.arrSuggVideos, new EarnMoney_117.ItemClick() {
            @Override
            public void onItemClick(moneyapp_3 moneyapp3) {
                RealMoney_103.this.arrSearched.clear();
                RealMoney_103.this.savedAdapter.notifyDataSetChanged();
                RealMoney_103.this.searchView.closeSearch();
                RealMoney_103.this.searchedResult = moneyapp3.getTitle();
                RealMoney_103.this.imgTitle = null;
                RealMoney_103.this.txtTitle.setText(RealMoney_103.this.searchedResult);
                RealMoney_103.this.identifyer = 17;
                RealMoney_103.this.page = 0;
                RealMoney_103.this.getValueBySearchFilter(true);
            }
        });

        this.recyclerSuggestion.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override 
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                RealMoney_109.hideKeyboard(RealMoney_103.this.recyclerSuggestion, RealMoney_103.this);
            }
        });

        this.recyclerSuggestion.setAdapter(this.suggAdapter);

    }


    private void removeLoading() {
        if (this.arrSearched.contains(this.loadMoreModel)) {
            int indexOf = this.arrSearched.indexOf(this.loadMoreModel);
            this.arrSearched.remove(this.loadMoreModel);
            this.savedAdapter.notifyItemRemoved(indexOf);
            this.savedAdapter.notifyItemRangeChanged(indexOf, this.arrSearched.size());
        }
    }


    private void setShadow() {
        if (this.overallXScroll > 0) {
            if (Build.VERSION.SDK_INT >= 21) {
                this.appBar.setElevation(16.0f);
            }
        } else if (Build.VERSION.SDK_INT >= 21) {
            this.appBar.setElevation(0.0f);
        }
    }

    private void showFilterOption() {
        this.isFilterOpen = true;
        this.clFillter.setVisibility(0);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.clFillter, "translationY", (float) this.animationHeight, 0.0f);
        ofFloat.setDuration(200L);
        ofFloat.start();
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setInterpolator(new DecelerateInterpolator());
        alphaAnimation.setDuration(100);
        this.viewSearchDisable.setBackgroundColor(Color.parseColor("#88000000"));
        this.viewSearchDisable.setVisibility(0);
        this.viewSearchDisable.setAnimation(alphaAnimation);
    }

    @Override 
    public void onBackPressed() {
        if (this.isFilterOpen) {
            hideFilterOption();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.videocall);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.identifyer = extras.getInt(RealMoney_105.EXTRA_IDENTIFYER, -1);
            this.searchedResult = extras.getString(RealMoney_105.EXTRA_SEARCH_VALUE);
            this.imgTitle = extras.getString(RealMoney_105.EXTRA_SEARCHED_IMAGE_TITLE, null);
            this.videoIdentifyer = extras.getInt(RealMoney_105.EXTRA_VIDEO_INDENTIFYER);
        }
        EarnMoney_111 searchDataBaseHandler = new EarnMoney_111(this);
        this.k = searchDataBaseHandler;
        if (searchDataBaseHandler.isDatabaseCopied()) {
            cashearning4 cashearning4 = new cashearning4();
            EarnMoney_111 searchDataBaseHandler2 = this.k;
            int i = RealMoney_105.IS_FULLSCREEN_VIDEOS;
            cashearning4.getDataForSearch(searchDataBaseHandler2, i, searchDataBaseHandler2.getCreatedAt(i));
            cashearning4 cashearning42 = new cashearning4();
            EarnMoney_111 searchDataBaseHandler3 = this.k;
            int i2 = RealMoney_105.LANDSCAPE_VIDEOS;
            cashearning42.getDataForSearch(searchDataBaseHandler3, i2, searchDataBaseHandler3.getCreatedAt(i2));
        } else {
            this.k.copyDb();
        }
        init();
        String str = this.imgTitle;
        if (str != null && str.length() > 0) {
            this.txtTitle.setText(this.imgTitle);
        }
        ViewTreeObserver viewTreeObserver = this.clFillter.getViewTreeObserver();

        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                @Override
                public void onGlobalLayout() {
                    RealMoney_103.this.clFillter.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    RealMoney_103 realMoney103 = RealMoney_103.this;
                    realMoney103.animationHeight = realMoney103.clFillter.getMeasuredHeight() * -1;
                }
            });
        }

        this.viewNewToOld.setOnClickListener(new View.OnClickListener() {
            @Override 
            public void onClick(View view) {
                if (!RealMoney_103.this.rbNewToOld.isChecked()) {
                    RealMoney_103.this.order_by = "created_at";
                    RealMoney_103.this.arrSearched.clear();
                    RealMoney_103.this.page = 0;
                    RealMoney_103.this.savedAdapter.notifyDataSetChanged();
                    RealMoney_103.this.getValueBySearchFilter(true);
                    RealMoney_103.this.rbNewToOld.setChecked(true);
                    RealMoney_103.this.rbMostPopular.setChecked(false);
                    RealMoney_103.this.hideFilterOption();
                }
            }
        });


        this.viewMostPopular.setOnClickListener(new View.OnClickListener() {
            @Override 
            public void onClick(View view) {
                if (!RealMoney_103.this.rbMostPopular.isChecked()) {
                    RealMoney_103.this.order_by = RealMoney_105.Popular_OrderdBy;
                    RealMoney_103.this.arrSearched.clear();
                    RealMoney_103.this.page = 0;
                    RealMoney_103.this.savedAdapter.notifyDataSetChanged();
                    RealMoney_103.this.getValueBySearchFilter(true);
                    RealMoney_103.this.rbNewToOld.setChecked(false);
                    RealMoney_103.this.rbMostPopular.setChecked(true);
                    RealMoney_103.this.hideFilterOption();
                }
            }
        });


        this.recyclerSearchedVideo.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override 
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                if (!recyclerView.canScrollVertically(1) && !RealMoney_103.this.isLoading && RealMoney_103.this.thresholHome > RealMoney_103.this.page) {
                    RealMoney_103.this.isLoading = true;
                    if (!RealMoney_103.this.arrSearched.contains(RealMoney_103.this.loadMoreModel)) {
                        RealMoney_103.this.arrSearched.add(RealMoney_103.this.loadMoreModel);
                        int indexOf = RealMoney_103.this.arrSearched.indexOf(RealMoney_103.this.loadMoreModel);
                        RealMoney_103.this.savedAdapter.notifyItemInserted(indexOf);
                        RealMoney_103.this.savedAdapter.notifyItemRangeChanged(indexOf, RealMoney_103.this.arrSearched.size());
                    }
                    recyclerView.scrollToPosition(RealMoney_103.this.savedAdapter.getItemCount() - 1);
                    RealMoney_103.this.getValueBySearchFilter(false);
                }
            }
        });


        this.viewSearchDisable.setOnClickListener(new View.OnClickListener() {
            @Override 
            public void onClick(View view) {
                if (RealMoney_103.this.searchView != null && RealMoney_103.this.searchView.isSearchOpen()) {
                    RealMoney_103.this.searchView.closeSearch();
                } else if (RealMoney_103.this.isFilterOpen) {
                    RealMoney_103.this.hideFilterOption();
                }
                RealMoney_103.this.viewSearchDisable.setVisibility(8);
            }
        });

        int i3 = this.identifyer;

        if (i3 == 12 || i3 == 13) {
            getValueBySearchFilter(true);
        } else {
            getValueBySearchFilter(true);
            this.searchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextChange(String str) {
                    try {
                        RealMoney_103.this.filterSearchData(str);
                        return false;
                    } catch (Exception e) {
                        e.printStackTrace();
                        return false;
                    }
                }

                @Override
                public boolean onQueryTextSubmit(String str) {
                    RealMoney_103.this.arrSearched.clear();
                    RealMoney_103.this.savedAdapter.notifyDataSetChanged();
                    RealMoney_103.this.searchedResult = str;
                    RealMoney_103.this.imgTitle = null;
                    RealMoney_103.this.identifyer = 10;
                    RealMoney_103.this.txtTitle.setText(RealMoney_103.this.searchedResult);
                    RealMoney_103.this.page = 0;
                    RealMoney_103.this.getValueBySearchFilter(true);
                    return false;
                }
            });

            this.searchView.setOnSearchViewListener(new MaterialSearchView.SearchViewListener() {
                @Override
                public void onSearchViewClosed() {
                    RealMoney_103.this.toolbar.setVisibility(0);
                    RealMoney_103.this.viewSearchDisable.setVisibility(8);
                    RealMoney_103.this.recyclerSuggestion.setVisibility(8);
                }

                @Override
                public void onSearchViewShown() {
                    RealMoney_103.this.toolbar.setVisibility(4);
                    RealMoney_103.this.viewSearchDisable.setBackgroundColor(Color.parseColor("#FFFFFF"));
                    RealMoney_103.this.viewSearchDisable.setVisibility(0);
                    RealMoney_103.this.recyclerSuggestion.setVisibility(0);
                }
            });
        }

        this.recyclerSearchedVideo.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                int findLastCompletelyVisibleItemPosition = ((LinearLayoutManager) recyclerView.getLayoutManager()).findLastCompletelyVisibleItemPosition();
                if (findLastCompletelyVisibleItemPosition != -1 && findLastCompletelyVisibleItemPosition >= 20) {
                    RealMoney_103.this.imgTotheTop.setVisibility(0);
                } else if (findLastCompletelyVisibleItemPosition != -1) {
                    RealMoney_103.this.imgTotheTop.setVisibility(8);
                }
                RealMoney_103.this.overallXScroll += i2;
                RealMoney_103.this.setShadow();
                super.onScrolled(recyclerView, i, i2);
            }
        });

        final LinearSmoothScroller r4 = new LinearSmoothScroller(this) {
            public int e() {
                return -1;
            }
        };

        this.imgTotheTop.setOnClickListener(new View.OnClickListener() {
            @Override 
            public void onClick(View view) {
                r4.setTargetPosition(0);
                RealMoney_103.this.recyclerSearchedVideo.getLayoutManager().startSmoothScroll(r4);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.earnmoney, menu);
        MenuItem findItem = menu.findItem(R.id.action_search);
        this.searchView.setMenuItem(findItem);
        MenuItem findItem2 = menu.findItem(R.id.menu_filter);
        int i = this.identifyer;
        if (i == 12 || i == 13) {
            findItem.setVisible(false);
            findItem2.setVisible(true);
        } else {
            findItem.setVisible(true);
            findItem2.setVisible(false);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            onBackPressed();
            return true;
        }
        if (menuItem.getItemId() == R.id.menu_filter) {
            if (this.isFilterOpen) {
                hideFilterOption();
            } else {
                showFilterOption();
            }
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override
    public void onResume() {
        super.onResume();
        if (this.recyclerSearchedVideo != null) {
            setShadow();
        }
    }

}
