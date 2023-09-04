package watchvideo.dailytrend.Earnmoney_6.EarnMoney_106;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import watchvideo.dailytrend.Earnmoney_6.EarnMoney_109.EarnMoney_114;
import watchvideo.dailytrend.Earnmoney_6.RealMoney_104.RealMoney_105;

public class EarnMoney_116 extends FragmentPagerAdapter {

    private EarnMoney_114 landsapeFragment = EarnMoney_114.newInstance(RealMoney_105.LANDSCAPE_VIDEOS);

    @Override
    public int getCount() {
        return 1;
    }

    @Override
    public CharSequence getPageTitle(int i) {
        return "";
    }

    public EarnMoney_116(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    public void changeTabPosOfOther(int i, int i2) {
        EarnMoney_114 dashboardFrag;
        if (i == RealMoney_105.IS_FULLSCREEN_VIDEOS && (dashboardFrag = this.landsapeFragment) != null) {
            dashboardFrag.changeTabPos(i2);
        }
    }

    @Override
    public Fragment getItem(int i) {
        return this.landsapeFragment;
    }

}
