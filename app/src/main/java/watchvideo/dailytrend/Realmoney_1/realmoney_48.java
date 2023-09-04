package watchvideo.dailytrend.Realmoney_1;

import android.content.Context;
import android.os.Handler;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Scroller;

public class realmoney_48 implements Runnable {
    private int distance;
    int lastY = 0;
    private Handler mHandler = new Handler();
    private hyfjhfgjhfd mScrollListener;
    private Scroller mScroller;
    private int previousDistance;

    public interface hyfjhfgjhfd {
        void onFinished();

        void onScroll(int i);
    }

    public realmoney_48(Context context, hyfjhfgjhfd scrollingListener) {
        this.mScroller = new Scroller(context, new AccelerateDecelerateInterpolator());
        this.mScrollListener = scrollingListener;
    }

    public void scroll(int i, int i2) {
        this.distance = i;
        this.mScroller.forceFinished(true);
        this.mScroller.startScroll(0, 0, 0, i, i2);
        this.mHandler.post(this);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.mScroller.computeScrollOffset();
        int currY = this.mScroller.getCurrY();
        int i = currY - this.lastY;
        this.lastY = currY;
        if (!(Math.abs(i) == this.previousDistance || i == 0)) {
            this.mScrollListener.onScroll(i);
        }
        if (!this.mScroller.isFinished()) {
            this.mHandler.post(this);
            return;
        }
        this.previousDistance = this.distance;
        this.mScrollListener.onFinished();
    }
}
