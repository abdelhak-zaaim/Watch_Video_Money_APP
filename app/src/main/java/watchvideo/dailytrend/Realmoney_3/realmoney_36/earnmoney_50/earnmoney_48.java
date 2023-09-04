package watchvideo.dailytrend.Realmoney_3.realmoney_36.earnmoney_50;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.google.android.exoplayer2.metadata.icy.IcyHeaders;
import watchvideo.dailytrend.R;
import watchvideo.dailytrend.Realmoney_3.realmoney_47.realmoney_40;
import watchvideo.dailytrend.Realmoney_3.earnmoney_35.earnmoney_27;
import watchvideo.dailytrend.Realmoney_3.realmoney_38.realmoney_37;
import watchvideo.dailytrend.Realmoney_3.realmoney_36.earnmoney_47;
import watchvideo.dailytrend.Realmoney_3.realmoney_35.earnmoney_30;
import watchvideo.dailytrend.Realmoney_3.realmoney_35.earnmoney_31.earnmoney_29;
import watchvideo.dailytrend.Realmoney_3.realmoney_35.earnmoney_31.earnmoney_28;
import watchvideo.dailytrend.Realmoney_3.earnmoney_46.earnmoney_45;

import java.util.ArrayList;

public class earnmoney_48 extends Fragment implements SwipeRefreshLayout.OnRefreshListener, earnmoney_47 {
    static earnmoney_48 fragmentVideos;
    earnmoney_27 earnmoney27;
    RecyclerView data;
    ArrayList<earnmoney_28> dataItems = new ArrayList<>();
    private String default_lang = "";
    private RecyclerView.OnScrollListener listerOnScroll = new RecyclerView.OnScrollListener() {

        @Override 
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
        }

        @Override 
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
        }
    };
    LinearLayout loaderLayout;
    SwipeRefreshLayout refreshLayout;
    ArrayList<earnmoney_30> tagitems = new ArrayList<>();

    public static earnmoney_48 getInstance() {
        if (fragmentVideos == null) {
            fragmentVideos = new earnmoney_48();
        }
        return fragmentVideos;
    }

    @Override 
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.videomoney, (ViewGroup) null);
        this.data = (RecyclerView) inflate.findViewById(R.id.data);
        this.loaderLayout = (LinearLayout) inflate.findViewById(R.id.loader_layout);
        this.refreshLayout = (SwipeRefreshLayout) inflate.findViewById(R.id.refresh_layout);
        setLayoutManager();
        getVideos();
        return inflate;
    }

    public void getVideos() {
        this.loaderLayout.setVisibility(0);
        earnmoney_49.getInstance().setListener(this, this.default_lang);
    }

    public void setLayoutManager() {
        this.data.setHasFixedSize(true);
        this.data.setDrawingCacheEnabled(true);
        this.data.setDrawingCacheQuality(1048576);
        this.data.addOnScrollListener(this.listerOnScroll);
        this.refreshLayout.setColorSchemeColors(ContextCompat.getColor(getActivity(), R.color.colorPrimary), ContextCompat.getColor(getActivity(), R.color.colorAccent), ContextCompat.getColor(getActivity(), R.color.colorPrimaryDark));
        this.refreshLayout.setOnRefreshListener(this);
    }

    @Override 
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onRefresh() {
        this.refreshLayout.setRefreshing(false);
        if (earnmoney_45.isNetworkAvailable(getActivity())) {
            this.dataItems.clear();
            this.earnmoney27.notifyDataSetChanged();
            getVideos();
            return;
        }
        this.refreshLayout.setRefreshing(false);
    }

    @Override
    public void onGetCategories(earnmoney_29 categoryModel) {
        LinearLayout linearLayout = this.loaderLayout;
        if (linearLayout != null && linearLayout.getVisibility() == 0) {
            this.loaderLayout.setVisibility(8);
        }
        ArrayList<earnmoney_28> arrayList = this.dataItems;
        if (arrayList != null && arrayList.size() > 0) {
            this.dataItems.clear();
        }
        this.dataItems.addAll(categoryModel.getData());
        setAdapter();
    }

    public void setAdapter() {
        final ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.dataItems.size(); i++) {
            if (i % 12 != 0 || i == 0) {
                earnmoney_28 dataItem = new earnmoney_28();
                dataItem.setIcon(this.dataItems.get(i).getIcon());
                dataItem.setIsAds("0");
                dataItem.setName(this.dataItems.get(i).getName());
                dataItem.setId(this.dataItems.get(i).getId());
                arrayList.add(dataItem);
            } else {
                earnmoney_28 dataItem2 = new earnmoney_28();
                earnmoney_28 dataItem3 = new earnmoney_28();
                dataItem2.setIcon(this.dataItems.get(i).getIcon());
                dataItem2.setIsAds(IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE);
                dataItem2.setName(this.dataItems.get(i).getName());
                dataItem2.setId(this.dataItems.get(i).getId());
                dataItem3.setIcon(this.dataItems.get(i).getIcon());
                dataItem3.setIsAds("0");
                dataItem3.setName(this.dataItems.get(i).getName());
                dataItem3.setId(this.dataItems.get(i).getId());
                arrayList.add(dataItem2);
                arrayList.add(dataItem3);
            }
        }
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 3);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int i) {
                return ((earnmoney_28) arrayList.get(i)).getIsAds().equals(IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE) ? 3 : 1;
            }
        });

        this.data.setLayoutManager(gridLayoutManager);
        earnmoney_27 earnmoney272 = this.earnmoney27;
        if (earnmoney272 == null) {
            earnmoney_27 earnmoney273 = new earnmoney_27(arrayList, getActivity());
            this.earnmoney27 = earnmoney273;
            this.data.setAdapter(earnmoney273);
        } else {
            this.data.setAdapter(earnmoney272);
        }

        this.earnmoney27.setOnItemClickListener(new earnmoney_27.OnItemClicked() {
            @Override
            public void onClick(int i) {
                new Bundle().putString("ButtonName", "video_categoriesAdapter");
                Intent intent = new Intent(earnmoney_48.this.getActivity(), realmoney_40.class);
                intent.putExtra(realmoney_37.CATEGORY_ID, earnmoney_48.this.dataItems.get(i).getId());
                intent.putExtra(realmoney_37.CATEGORY_NAME, earnmoney_48.this.dataItems.get(i).getName());
                earnmoney_48.this.startActivity(intent);
            }
        });

    }
}
