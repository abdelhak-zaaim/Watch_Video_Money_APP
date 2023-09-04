package watchvideo.dailytrend.Earnmoney_6.RealMoney_100;

import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.google.android.material.tabs.TabLayout;
import watchvideo.dailytrend.Earnmoney_6.EarnMoney_106.EarnMoney_116;
import watchvideo.dailytrend.Earnmoney_6.RealMoney_104.RealMoney_105;
import watchvideo.dailytrend.Earnmoney_6.RealMoney_104.RealMoney_106;
import watchvideo.dailytrend.Earnmoney_6.RealMoney_104.EarnMoney_101;
import watchvideo.dailytrend.Earnmoney_6.EarnMoney_105.EarnMoney_112;
import watchvideo.dailytrend.R;

public class RealMoney_102 extends RealMoney_101 {

    private boolean isExit = false;
    private EarnMoney_116 tabAdapter;
    private TabLayout tabLayout;
    private Toolbar toolbar;
    private TextView txtTitle;
    private View viewSearchDisable;
    private RealMoney_106 view_pager;


    private void SelectedTabAnim(TabLayout.Tab tab) {
        Drawable icon = tab.getIcon();
        if (icon instanceof Animatable) {
            ((Animatable) icon).start();
        }
    }


    private void init() {
        View findViewById = findViewById(R.id.viewSearchDisable);
        this.viewSearchDisable = findViewById;
        findViewById.setVisibility(View.GONE);
        Toolbar toolbar2 = (Toolbar) findViewById(R.id.toolbar);
        this.toolbar = toolbar2;
        toolbar2.bringToFront();
        setSupportActionBar(this.toolbar);
        getSupportActionBar().setTitle("");
        this.tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        this.view_pager = (RealMoney_106) findViewById(R.id.view_pager);
        this.txtTitle = (TextView) findViewById(R.id.txtTitle);
    }


    private void selectedTabAnimation(TabLayout.Tab tab, int i) {
        if (Build.VERSION.SDK_INT >= 21) {
            if (tab.getPosition() == 0) {
                TabLayout.Tab tabAt = this.tabLayout.getTabAt(0);
                tabAt.getClass();
                SelectedTabAnim(tabAt);
            } else if (tab.getPosition() == 1) {
                TabLayout.Tab tabAt2 = this.tabLayout.getTabAt(1);
                tabAt2.getClass();
                SelectedTabAnim(tabAt2);
            }
        }
    }


    public void changeTabOfOtherFragment(int i, int i2) {
        this.tabAdapter.changeTabPosOfOther(i, i2);
    }


    @Override 
    public void onBackPressed() {
        super.onBackPressed();
    }


    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(1024, 1024);
        setContentView(R.layout.watchvideoandearnmoney);
        startService(new Intent(this, EarnMoney_112.class));
        init();
        this.view_pager.setPagingEnabled(false);
        this.view_pager.setPageTransformer(true, new EarnMoney_101());
        EarnMoney_116 tabSelactionAdapter = new EarnMoney_116(getSupportFragmentManager());
        this.tabAdapter = tabSelactionAdapter;
        this.view_pager.setAdapter(tabSelactionAdapter);
        this.tabLayout.setupWithViewPager(this.view_pager);
        final int color = ContextCompat.getColor(this, R.color.colorAccent);

        this.tabLayout.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                RealMoney_102.this.selectedTabAnimation(tab, color);
                if (tab.getPosition() == RealMoney_102.this.tabLayout.getTabCount() - 1) {
                    LocalBroadcastManager.getInstance(RealMoney_102.this).sendBroadcast(new Intent(RealMoney_105.BRODCAST_REFRASH_SAVED_LIST));
                }
            }
        });

    }


    @Override 
    public void onPause() {
        super.onPause();
    }


    public void setToolBarTitle(String str) {
        this.txtTitle.setText(str);
    }


}
