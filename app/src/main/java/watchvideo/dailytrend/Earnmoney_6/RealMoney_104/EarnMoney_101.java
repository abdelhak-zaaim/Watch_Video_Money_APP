package watchvideo.dailytrend.Earnmoney_6.RealMoney_104;

import android.view.View;
import androidx.viewpager.widget.ViewPager;

public class EarnMoney_101 implements ViewPager.PageTransformer {
    @Override
    public void transformPage(View view, float f) {
        view.setTranslationX((-f) * ((float) view.getWidth()));
        if (((double) Math.abs(f)) < 0.5d) {
            view.setVisibility(0);
            view.setScaleX(1.0f - Math.abs(f));
            view.setScaleY(1.0f - Math.abs(f));
        } else if (((double) Math.abs(f)) > 0.5d) {
            view.setVisibility(8);
        }
    }
}
