package watchvideo.dailytrend.Earnmoney_2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import watchvideo.dailytrend.Earnmoney_7.earnmoney_53;
import watchvideo.dailytrend.Realmoney_1.realmoney_48;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RealMoney_95 extends View implements realmoney_48.hyfjhfgjhfd {
    private static final int FRAME_PADDING = 10;
    private int[] SHADOWS_COLORS = {-15658735, 11184810, 11184810};
    private GradientDrawable bottomShadow;
    private boolean checkForMiddling = true;
    int itemHeight;
    int itemX;
    private Rect mFullViewRect;
    private realmoney_48 mReelScroller;
    private OnScrollFinishedListener mScrollFinishedListener;
    List<DrawSlotItem> mSlotItems;
    int mViewFullHeight;
    int mViewFullWidth;
    int mViewWidth;
    Paint mWhiteBackgroundPaint;
    private boolean scrollDown = false;
    private GradientDrawable topShadow;
    private int visibleSlotItems = 1;
    private Drawable wheelFrame;

    public interface OnScrollFinishedListener {
        void onWheelFinishedScrolling(int i);
    }

    public RealMoney_95(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    public RealMoney_95(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public RealMoney_95(Context context) {
        super(context);
        init(context);
    }

    public void init(Context context) {
        this.mFullViewRect = new Rect();
        this.mReelScroller = new realmoney_48(context, this);
        Paint paint = new Paint();
        this.mWhiteBackgroundPaint = paint;
        paint.setColor(-1);
        this.topShadow = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.SHADOWS_COLORS);
        this.bottomShadow = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, this.SHADOWS_COLORS);
        this.mSlotItems = new ArrayList();
    }

    public void setSlotItems(List<earnmoney_53> list) {
        fillSlotDrawItems(list);
    }

    public void fillSlotDrawItems(List<earnmoney_53> list) {
        this.mSlotItems.clear();
        int i = 1;
        for (earnmoney_53 iSlotMachineItem : list) {
            this.mSlotItems.add(new DrawSlotItem(iSlotMachineItem, i));
            i++;
        }
    }

    public void setNumberOfVisibleItems(int i) {
        this.visibleSlotItems = i;
    }

    public void scroll(int i, int i2) {
        if (i != 0) {
            this.checkForMiddling = true;
            this.mReelScroller.scroll(i, i2);
        }
    }

    public void setScrollFinishedListener(OnScrollFinishedListener onScrollFinishedListener) {
        this.mScrollFinishedListener = onScrollFinishedListener;
    }

    public void setWheelBackground(Drawable drawable) {
        this.wheelFrame = drawable;
    }

    public void setWheelScrollingDirection(boolean z) {
        this.scrollDown = z;
    }

    @Override 
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.mViewFullWidth = getDefaultSize(getSuggestedMinimumWidth(), i);
        int defaultSize = getDefaultSize(getSuggestedMinimumHeight(), i2);
        this.mViewFullHeight = defaultSize;
        this.mViewWidth = this.mViewFullWidth - 20;
        this.itemHeight = (defaultSize - 20) / this.visibleSlotItems;
        setCorrectVisibleItems();
        resetSlotItemsPositions(this.scrollDown);
        this.itemX = 10;
        Rect rect = this.mFullViewRect;
        rect.top = 10;
        rect.left = 10;
        rect.right = this.mViewWidth + 10;
        int i3 = this.mViewFullHeight;
        rect.bottom = i3 - 10;
        setMeasuredDimension(this.mViewFullWidth, i3);
    }

    public void setCorrectVisibleItems() {
        int i = this.visibleSlotItems;
        if (i == 0 || i == this.mSlotItems.size()) {
            this.visibleSlotItems = this.mSlotItems.size() - 1;
        }
    }

    @Override 
    public void onDraw(Canvas canvas) {
        drawFrame(canvas);
        drawSlotItems(canvas);
    }

    private void drawSlotItems(Canvas canvas) {
        for (DrawSlotItem drawSlotItem : this.mSlotItems) {
            View view = drawSlotItem.getView();
            view.measure(MeasureSpec.makeMeasureSpec(this.mViewWidth, 1073741824), MeasureSpec.makeMeasureSpec(this.itemHeight, 1073741824));
            view.layout(this.itemX, drawSlotItem.getY() + 10, this.mViewWidth, drawSlotItem.getY() + this.itemHeight);
            canvas.save();
            canvas.translate((float) this.itemX, (float) (drawSlotItem.getY() + 10));
            view.draw(canvas);
            canvas.restore();
        }
    }

    private void drawFrame(Canvas canvas) {
        Drawable drawable = this.wheelFrame;
        if (drawable != null) {
            drawable.setBounds(0, 0, this.mViewFullWidth, this.mViewFullHeight);
            this.wheelFrame.draw(canvas);
        }
    }

    private void drawShadows(Canvas canvas) {
        double d = (double) this.itemHeight;
        Double.isNaN(d);
        Double.isNaN(d);
        Double.isNaN(d);
        int i = (int) (d * 1.0d);
        this.topShadow.setBounds(0, 0, getWidth(), i);
        this.topShadow.draw(canvas);
        this.bottomShadow.setBounds(0, getHeight() - i, getWidth(), getHeight());
        this.bottomShadow.draw(canvas);
    }

    public class DrawSlotItem {
        int positionY;
        int slotPosition;
        View view;

        public DrawSlotItem(earnmoney_53 iSlotMachineItem, int i) {
            this.view = iSlotMachineItem.getView();
            this.slotPosition = i;
        }

        public void setPosY(int i) {
            this.positionY = i;
        }

        public int getY() {
            return this.positionY;
        }

        public View getView() {
            return this.view;
        }

        public int getSlotPosition() {
            return this.slotPosition;
        }
    }

    public void scroll(int i) {
        int i2 = 0;
        boolean z = i < 0;
        for (DrawSlotItem drawSlotItem : this.mSlotItems) {
            drawSlotItem.setPosY(drawSlotItem.getY() - i);
        }
        if (z) {
            if (this.mSlotItems.get(this.visibleSlotItems - 1).getY() >= this.mViewFullHeight) {
                for (int i3 = 1; i3 < this.mSlotItems.size(); i3++) {
                    Collections.swap(this.mSlotItems, i2, i3);
                    i2++;
                }
                resetSlotItemsPositions(z);
            }
        } else if (this.mSlotItems.get(0).getY() <= (-this.itemHeight)) {
            for (int i4 = 1; i4 < this.mSlotItems.size(); i4++) {
                Collections.swap(this.mSlotItems, i2, i4);
                i2++;
            }
            resetSlotItemsPositions(z);
        }
        invalidate();
    }

    public void resetSlotItemsPositions(boolean z) {
        int i = z ? -1 : 0;
        for (DrawSlotItem drawSlotItem : this.mSlotItems) {
            drawSlotItem.setPosY((this.itemHeight * i) + 10);
            i++;
        }
    }

    @Override
    public void onScroll(int i) {
        scroll(i);
    }

    @Override
    public void onFinished() {
        if (this.checkForMiddling) {
            positionNearestMiddleItem();
            this.checkForMiddling = false;
        }
    }

    private void positionNearestMiddleItem() {
        scroll(this.mSlotItems.get(this.visibleSlotItems).getY() - (((this.mViewFullHeight - 20) / 2) - (this.itemHeight / 2)), 1000);
        OnScrollFinishedListener onScrollFinishedListener = this.mScrollFinishedListener;
        if (onScrollFinishedListener != null) {
            onScrollFinishedListener.onWheelFinishedScrolling(this.mSlotItems.get(this.visibleSlotItems).getSlotPosition());
        }
    }
}
