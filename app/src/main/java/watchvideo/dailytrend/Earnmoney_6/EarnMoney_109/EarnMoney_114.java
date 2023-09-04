package watchvideo.dailytrend.Earnmoney_6.EarnMoney_109;

import android.graphics.PorterDuff;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;

import watchvideo.dailytrend.Earnmoney_6.RealMoney_100.RealMoney_102;
import watchvideo.dailytrend.realmoney_24;
import watchvideo.dailytrend.Earnmoney_6.EarnMoney_106.EarnMoney_115;
import watchvideo.dailytrend.Earnmoney_6.RealMoney_104.RealMoney_105;
import watchvideo.dailytrend.Earnmoney_6.RealMoney_104.EarnMoney_103;
import watchvideo.dailytrend.Earnmoney_6.RealMoney_104.EarnMoney_102;
import watchvideo.dailytrend.Earnmoney_6.RealMoney_104.RealMoney_110;
import watchvideo.dailytrend.R;

public class EarnMoney_114 extends EarnMoney_112 {
    private EarnMoney_115 adapter;
    private AppBarLayout appBar;
    private boolean isExit = false;
    private TabLayout tabLayout;
    private View v;
    private int videolistIdentifyer = 0;
    private ViewPager view_pager;

    private void SelectedTabAnim(final TabLayout.Tab tab) {
        if (tab != null) {
            try {
                Drawable icon = tab.getIcon();
                if (icon instanceof Animatable) {
                    ((Animatable) icon).start();
                    if (tab.getPosition() == 0) {
                        new Handler().postDelayed(new Runnable() {


                            public void run() {
                                ViewGroup viewGroup;
                                ViewGroup viewGroup2 = (ViewGroup) EarnMoney_114.this.tabLayout.getChildAt(0);
                                if (viewGroup2 != null && (viewGroup = (ViewGroup) viewGroup2.getChildAt(0)) != null) {
                                    int childCount = viewGroup.getChildCount();
                                    AppCompatImageView appCompatImageView = null;
                                    int i = 0;
                                    while (true) {
                                        if (i >= childCount) {
                                            break;
                                        } else if (viewGroup.getChildAt(i) instanceof AppCompatImageView) {
                                            appCompatImageView = (AppCompatImageView) viewGroup.getChildAt(i);
                                            break;
                                        } else {
                                            i++;
                                        }
                                    }
                                    if (appCompatImageView != null && EarnMoney_114.this.getActivity() != null) {
                                        if (tab.getPosition() == 0) {
                                            AppCompatImageView finalAppCompatImageView = appCompatImageView;
                                            EarnMoney_114.this.getActivity().runOnUiThread(new Runnable() {


                                                public void run() {
                                                    finalAppCompatImageView.animate().scaleX(0.0f).scaleY(0.0f).setDuration(200).withEndAction(new Runnable() {

                                                        public void run() {
                                                            if (EarnMoney_114.this.tabLayout.getSelectedTabPosition() == 0) {
                                                                EarnMoney_114.this.tabLayout.getTabAt(0).setIcon(R.drawable.history_icon);
                                                            } else {
                                                                EarnMoney_114.this.tabLayout.getTabAt(0).setIcon(R.drawable.home_icon_black);
                                                            }
                                                            finalAppCompatImageView.animate().scaleX(1.0f).scaleY(1.0f).setDuration(200).start();
                                                        }
                                                    }).start();
                                                }
                                            });
                                        } else {
                                            EarnMoney_114.this.tabLayout.getTabAt(0).setIcon(R.drawable.home_icon_black);
                                        }
                                    }
                                }
                            }
                        }, 700);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void init() {
        this.view_pager = (ViewPager) this.v.findViewById(R.id.view_pager);
        this.tabLayout = (TabLayout) this.v.findViewById(R.id.tabLayout);
        this.appBar = (AppBarLayout) this.v.findViewById(R.id.appBar);
        hideShadow();
    }

    public static EarnMoney_114 newInstance(int i) {
        EarnMoney_114 dashboardFrag = new EarnMoney_114();
        dashboardFrag.videolistIdentifyer = i;
        return dashboardFrag;
    }

    private void resetIcons() {
        try {
            //  this.tabLayout.getTabAt(1).setIcon(R.drawable.ic_categories_anim);
            this.tabLayout.getTabAt(0).setIcon(R.drawable.moneyapp_1);
            this.tabLayout.getTabAt(1).setIcon(R.drawable.moneyapp_7);
            this.tabLayout.getTabAt(2).setIcon(R.drawable.realmoneygame_11);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void rotedTabIcon(TabLayout.Tab tab) {
        Drawable icon = tab.getIcon();
        if (icon instanceof Animatable) {
            ((Animatable) icon).start();
        }
        EarnMoney_103 Instance = EarnMoney_103.Instance();
        EarnMoney_103.Instance().getClass();
        int intPref = Instance.getIntPref("home_api_calling");
        if (intPref == 2) {
            EarnMoney_103 Instance2 = EarnMoney_103.Instance();
            EarnMoney_103.Instance().getClass();
            Instance2.putPref("home_api_calling", 1);
        } else if (intPref == 1) {
            EarnMoney_103 Instance3 = EarnMoney_103.Instance();
            EarnMoney_103.Instance().getClass();
            Instance3.putPref("home_api_calling", 0);
        } else {
            EarnMoney_103 Instance4 = EarnMoney_103.Instance();
            EarnMoney_103.Instance().getClass();
            Instance4.putPref("home_api_calling", 2);
        }
        EarnMoney_103.Instance().savePref();
        this.adapter.swipeToRefrashData();
    }


    private void selectedTabAnimation(TabLayout.Tab tab, int i) {
        try {
            resetIcons();
            if (Build.VERSION.SDK_INT < 21) {
                tab.getIcon().setColorFilter(i, PorterDuff.Mode.SRC_IN);
            } else if (tab.getPosition() == 0) {
                TabLayout.Tab tabAt = this.tabLayout.getTabAt(0);
                tabAt.getClass();
                SelectedTabAnim(tabAt);
            } else if (tab.getPosition() == 3) {
                TabLayout.Tab tabAt2 = this.tabLayout.getTabAt(2);
                tabAt2.getClass();
                SelectedTabAnim(tabAt2);
            } else if (tab.getPosition() == 2) {
                TabLayout.Tab tabAt3 = this.tabLayout.getTabAt(1);
                tabAt3.getClass();
                SelectedTabAnim(tabAt3);
            }/* else if (tab.getPosition() == 3) {
                TabLayout.Tab tabAt4 = this.tabLayout.getTabAt(3);
                tabAt4.getClass();
                SelectedTabAnim(tabAt4);
            }*/
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setupTabIcons() {
        if (Build.VERSION.SDK_INT >= 21) {
         /*   TabLayout.Tab tabAt = this.tabLayout.getTabAt(1);
            tabAt.getClass();
            tabAt.setIcon(R.drawable.ic_categories_anim);*/
            TabLayout.Tab tabAt2 = this.tabLayout.getTabAt(0);
            tabAt2.getClass();
            tabAt2.setIcon(R.drawable.moneyapp_1);
            TabLayout.Tab tabAt3 = this.tabLayout.getTabAt(1);
            tabAt3.getClass();
            tabAt3.setIcon(R.drawable.moneyapp_7);
            TabLayout.Tab tabAt4 = this.tabLayout.getTabAt(2);
            tabAt4.getClass();
            tabAt4.setIcon(R.drawable.realmoneygame_11);
            return;
        }
        //   this.tabLayout.getTabAt(1).setIcon(R.drawable.ic_categories);
        this.tabLayout.getTabAt(0).setIcon(R.drawable.home_icon_black);
        this.tabLayout.getTabAt(1).setIcon(R.drawable.moneyapp_7);
        this.tabLayout.getTabAt(2).setIcon(R.drawable.moneyapp_12);
    }

    public void changeTabPos(int i) {
        ViewPager viewPager = this.view_pager;
        if (viewPager != null) {
            viewPager.setCurrentItem(i);
        }
    }

    public void hideShadow() {
        if (Build.VERSION.SDK_INT >= 21) {
            this.appBar.setElevation(0.0f);
        }
    }

    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.v = layoutInflater.inflate(R.layout.earnmoneyrealmoney, viewGroup, false);
        init();
        if (this.videolistIdentifyer == RealMoney_105.IS_FULLSCREEN_VIDEOS) {
            new RealMoney_110(getActivity()).checkDialogs();
        }
        EarnMoney_115 tabAdapter = new EarnMoney_115(getChildFragmentManager(), this.videolistIdentifyer);
        this.adapter = tabAdapter;
        this.view_pager.setAdapter(tabAdapter);
        this.tabLayout.setupWithViewPager(this.view_pager);
        setupTabIcons();
        this.view_pager.setOffscreenPageLimit(1);
        final int color = ContextCompat.getColor(getActivity(), R.color.colorAccent);
        if (Build.VERSION.SDK_INT >= 21) {
            selectedTabAnimation(this.tabLayout.getTabAt(0), color);
        } else {
            this.tabLayout.getTabAt(0).getIcon().setColorFilter(color, PorterDuff.Mode.SRC_IN);
        }
        this.tabLayout.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) new TabLayout.OnTabSelectedListener() {


            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                if (tab.getPosition() == 0) {
                    EarnMoney_114.this.rotedTabIcon(tab);
                }
            }

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                try {
                    int position = tab.getPosition();

                    ((RealMoney_102) EarnMoney_114.this.getActivity()).changeTabOfOtherFragment(EarnMoney_114.this.videolistIdentifyer, position);
                    if (position == 0) {
                        ((RealMoney_102) EarnMoney_114.this.getActivity()).setToolBarTitle(EarnMoney_115.HOME_TAB_TITLE);
                        if (EarnMoney_102.isConnected() && realmoney_24.tracker() != null) {
                            realmoney_24.tracker().send(new HitBuilders.EventBuilder("Open ", "Latest Video list").build());
                        }
                    }/* else if (position == 1) {
                                            ((RealMoney_102) DashboardFrag.this.getActivity()).setToolBarTitle(TabAdapter.CATEGORIES_TAB_TITLE);
                                            if (NetworkConnectivity.isConnected() && MyApp.tracker() != null) {
                                                MyApp.tracker().send(new HitBuilders.EventBuilder("Open ", "Categories List").build());
                                            }
                                        }*/ else if (position == 1) {
                        ((RealMoney_102) EarnMoney_114.this.getActivity()).setToolBarTitle(EarnMoney_115.POPULAR_TAB_TITLE);
                        if (EarnMoney_102.isConnected() && realmoney_24.tracker() != null) {
                            realmoney_24.tracker().send(new HitBuilders.EventBuilder("Open ", "Popular Video List").build());
                        }
                    } else if (position == 2) {
                        ((RealMoney_102) EarnMoney_114.this.getActivity()).setToolBarTitle(EarnMoney_115.SAVED_TAB_TITLE);
                        if (EarnMoney_102.isConnected() && realmoney_24.tracker() != null) {
                            realmoney_24.tracker().send(new HitBuilders.EventBuilder("Open ", "Downloaded Video List").build());
                        }
                    }
                    if (Build.VERSION.SDK_INT >= 21) {
                        EarnMoney_114.this.selectedTabAnimation(tab, color);
                    } else {
                        tab.getIcon().setColorFilter(color, PorterDuff.Mode.SRC_IN);
                    }
                }
                 catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tab.getIcon().setColorFilter(ContextCompat.getColor(EarnMoney_114.this.getActivity(), R.color.colornSelected), PorterDuff.Mode.SRC_IN);
            }
        });
        this.view_pager.setCurrentItem(0);
        return this.v;
    }

    public void showAppBarShadow() {
        if (Build.VERSION.SDK_INT >= 21) {
            this.appBar.setElevation(16.0f);
        }
    }
}
