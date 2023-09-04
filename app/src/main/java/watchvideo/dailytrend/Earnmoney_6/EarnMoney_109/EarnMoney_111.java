package watchvideo.dailytrend.Earnmoney_6.EarnMoney_109;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.wang.avi.AVLoadingIndicatorView;
import watchvideo.dailytrend.Earnmoney_6.EarnMoney_106.EarnMoney_114;
import watchvideo.dailytrend.Earnmoney_6.RealMoney_104.RealMoney_105;
import watchvideo.dailytrend.Earnmoney_6.RealMoney_104.EarnMoney_102;
import watchvideo.dailytrend.Earnmoney_6.EarnMoney_104.cashearning5;
import watchvideo.dailytrend.Earnmoney_6.EarnMoney_104.cashearning1;
import watchvideo.dailytrend.R;
import java.util.ArrayList;
@SuppressLint("WrongConstant")

public class EarnMoney_111 extends Fragment {
    private ArrayList<cashearning5> arrCategories = new ArrayList<>();
    private AVLoadingIndicatorView avLoadData;
    private CardView btnRetry;
    private int identify = 0;
    private ImageView imgError;
    private EarnMoney_114 mAdapter;
    private int overallXScroll = 0;
    private RecyclerView recyclerCategories;
    private SwipeRefreshLayout swipeToRefresh;
    private TextView txtError;
    private View v;


    private void getCategoriesFromApi(boolean z) {
        if (z) {
            this.avLoadData.setVisibility(0);
        }
        this.txtError.setVisibility(8);
        this.btnRetry.setVisibility(8);
        this.imgError.setVisibility(8);
        cashearning1.Instance().getCategories(this.identify, new cashearning1.ApiDelegate() {

            @Override
            public void OnFailure(String str) {
                if (EarnMoney_111.this.arrCategories.size() <= 0) {
                    EarnMoney_111.this.txtError.setVisibility(0);
                    EarnMoney_111.this.btnRetry.setVisibility(0);
                    EarnMoney_111.this.imgError.setVisibility(0);
                }
                if (EarnMoney_102.isConnected()) {
                    EarnMoney_111.this.txtError.setText(str);
                } else {
                    EarnMoney_111.this.txtError.setText(RealMoney_105.INTERNET_CONNECTION_ISSUE);
                }
                EarnMoney_111.this.avLoadData.setVisibility(8);
                if (EarnMoney_111.this.swipeToRefresh.isRefreshing()) {
                    EarnMoney_111.this.swipeToRefresh.setRefreshing(false);
                }
            }

            @Override
            public void OnSuccsess(final ArrayList arrayList) {
                EarnMoney_111.this.recyclerCategories.post(new Runnable() {

                    @Override // java.lang.Runnable
                    public void run() {
                        EarnMoney_111.this.avLoadData.setVisibility(8);
                        EarnMoney_111.this.arrCategories.clear();
                        EarnMoney_111.this.arrCategories.addAll(arrayList);
                        if (EarnMoney_111.this.arrCategories.size() > 6) {
                            cashearning5 categories_Model = new cashearning5();
                            categories_Model.setItemType(EarnMoney_114.NATIVE_ADS);
                            EarnMoney_111.this.arrCategories.add(6, categories_Model);
                        }
                        EarnMoney_111.this.mAdapter.notifyDataSetChanged();
                        if (EarnMoney_111.this.swipeToRefresh.isRefreshing()) {
                            EarnMoney_111.this.swipeToRefresh.setRefreshing(false);
                        }
                    }
                });
            }
        });
    }

    private void init() {
        this.recyclerCategories = (RecyclerView) this.v.findViewById(R.id.recyclerCategories);
        this.mAdapter = new EarnMoney_114(this.identify, getActivity(), this.arrCategories);
        this.recyclerCategories.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        this.recyclerCategories.setItemAnimator(new DefaultItemAnimator());
        this.recyclerCategories.setHasFixedSize(true);
        this.recyclerCategories.setAdapter(this.mAdapter);
        this.swipeToRefresh = (SwipeRefreshLayout) this.v.findViewById(R.id.swipeToRefresh);
        ((GridLayoutManager) this.recyclerCategories.getLayoutManager()).setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            /* class com.watchall.trending.Em_Trending.Frg_l.CategoriesFrag.AnonymousClass2 */

            @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
            public int getSpanSize(int i) {
                return ((cashearning5) EarnMoney_111.this.arrCategories.get(i)).getItemType() == EarnMoney_114.NATIVE_ADS ? 2 : 1;
            }
        });
        AVLoadingIndicatorView aVLoadingIndicatorView = (AVLoadingIndicatorView) this.v.findViewById(R.id.avLoadData);
        this.avLoadData = aVLoadingIndicatorView;
        aVLoadingIndicatorView.setVisibility(8);
        TextView textView = (TextView) this.v.findViewById(R.id.txtError);
        this.txtError = textView;
        textView.setVisibility(8);
        CardView cardView = (CardView) this.v.findViewById(R.id.btnRetry);
        this.btnRetry = cardView;
        cardView.setVisibility(8);
        ImageView imageView = (ImageView) this.v.findViewById(R.id.imgError);
        this.imgError = imageView;
        imageView.setVisibility(8);
    }

    public static EarnMoney_111 newInstance(int i) {
        EarnMoney_111 categoriesFrag = new EarnMoney_111();
        categoriesFrag.identify = i;
        return categoriesFrag;
    }


    private void setShadow() {
        try {
            watchvideo.dailytrend.Earnmoney_6.EarnMoney_109.EarnMoney_114 dashboardFrag = (watchvideo.dailytrend.Earnmoney_6.EarnMoney_109.EarnMoney_114) getParentFragment();
            if (this.overallXScroll > 0) {
                dashboardFrag.showAppBarShadow();
            } else {
                dashboardFrag.hideShadow();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override 
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.v = layoutInflater.inflate(R.layout.watchearnmoney, viewGroup, false);
        init();
        this.swipeToRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {

            @Override
            public void onRefresh() {
                EarnMoney_111.this.overallXScroll = 0;
                EarnMoney_111.this.getCategoriesFromApi(false);
            }
        });
        getCategoriesFromApi(true);
        this.btnRetry.setOnClickListener(new View.OnClickListener() {

            @Override 
            public void onClick(View view) {
                EarnMoney_111.this.getCategoriesFromApi(true);
            }
        });
        this.recyclerCategories.addOnScrollListener(new RecyclerView.OnScrollListener() {

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                EarnMoney_111.this.overallXScroll += i2;
                EarnMoney_111.this.setShadow();
                super.onScrolled(recyclerView, i, i2);
            }
        });
        return this.v;
    }

    public void setLangDataBySelection() {
        this.recyclerCategories.scrollToPosition(0);
        getCategoriesFromApi(true);
    }
}
