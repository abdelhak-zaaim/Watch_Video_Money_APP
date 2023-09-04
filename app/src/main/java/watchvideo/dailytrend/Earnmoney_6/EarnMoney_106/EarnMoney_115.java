package watchvideo.dailytrend.Earnmoney_6.EarnMoney_106;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import watchvideo.dailytrend.Earnmoney_6.EarnMoney_109.EarnMoney_111;
import watchvideo.dailytrend.Earnmoney_6.EarnMoney_109.EarnMoney_110;

public class EarnMoney_115 extends FragmentStatePagerAdapter {
    public static final int CATEGORIES_TAB_POS = 1;
    public static final String CATEGORIES_TAB_TITLE = "Categories";
    public static final int HOME_TAB_POS = 0;
    public static final String HOME_TAB_TITLE = "StatusJoy";
    public static final int POPULAR_TAB_POS = 2;
    public static final String POPULAR_TAB_TITLE = "Popular";
    public static final int SAVED_TAB_POS = 3;
    public static final String SAVED_TAB_TITLE = "Saved";
    private EarnMoney_111 categoriesFrag;
    private int identifyer = 0;
    private EarnMoney_110 popularFragment;
    private EarnMoney_110 videoListHomeFragment;

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int i) {
        return "";
    }

    public EarnMoney_115(FragmentManager fragmentManager, int i) {
        super(fragmentManager);
        this.identifyer = i;
        this.videoListHomeFragment = EarnMoney_110.newInstance(6, i);
        this.popularFragment = EarnMoney_110.newInstance(7, this.identifyer);
        this.categoriesFrag = EarnMoney_111.newInstance(this.identifyer);
    }

    @Override
    public Fragment getItem(int i) {
        if (i == 0) {
            return this.videoListHomeFragment;
        }
        if (i == 1) {
            return this.popularFragment;
        }
        if (i != 2) {
            return this.categoriesFrag;
        }
        return EarnMoney_110.newInstance(9, this.identifyer);
    }

    public void setLangDataBySelection() {
        try {
            EarnMoney_110 earnMoney110 = this.videoListHomeFragment;
            if (earnMoney110 != null) {
                earnMoney110.setLangDataBySelection();
            }
            EarnMoney_110 earnMoney1102 = this.popularFragment;
            if (earnMoney1102 != null) {
                earnMoney1102.setLangDataBySelection();
            }
            EarnMoney_111 categoriesFrag2 = this.categoriesFrag;
            if (categoriesFrag2 != null) {
                categoriesFrag2.setLangDataBySelection();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void swipeToRefrashData() {
        this.videoListHomeFragment.refrashDataWithNewValue();
    }
}
