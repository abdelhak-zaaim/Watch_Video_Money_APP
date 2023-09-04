package watchvideo.dailytrend.Earnmoney_5;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import watchvideo.dailytrend.R;
import watchvideo.dailytrend.Earnmoney_5.earnmoney_71.earnmoney_72;
import java.util.List;
import java.util.Random;

public class earnmoney_74 extends RelativeLayout implements earnmoney_75.PieRotateListener {
    private ImageView ivCursorView;
    private int mBackgroundColor;
    private int mBorderColor;
    private Drawable mCenterImage;
    private Drawable mCursorImage;
    private int mEdgeWidth;
    private LuckyRoundItemSelectedListener mLuckyRoundItemSelectedListener;
    private int mSecondaryTextSize;
    private int mTextColor;
    private int mTopTextPadding;
    private int mTopTextSize;
    private earnmoney_75 earnmoney75;

    public interface LuckyRoundItemSelectedListener {
        void LuckyRoundItemSelected(int i);
    }

    @Override 
    public void rotateDone(int i) {
        LuckyRoundItemSelectedListener luckyRoundItemSelectedListener = this.mLuckyRoundItemSelectedListener;
        if (luckyRoundItemSelectedListener != null) {
            luckyRoundItemSelectedListener.LuckyRoundItemSelected(i);
        }
    }

    public void setLuckyRoundItemSelectedListener(LuckyRoundItemSelectedListener luckyRoundItemSelectedListener) {
        this.mLuckyRoundItemSelectedListener = luckyRoundItemSelectedListener;
    }

    public earnmoney_74(Context context) {
        super(context);
        init(context, null);
    }

    public earnmoney_74(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    @SuppressLint("ResourceType")
    private void init(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.LuckyWheelView);
            this.mBackgroundColor = obtainStyledAttributes.getColor(0, -3407872);
            this.mTopTextSize = obtainStyledAttributes.getDimensionPixelSize(8, (int) earnmoney_73.convertDpToPixel(10.0f, getContext()));
            this.mSecondaryTextSize = obtainStyledAttributes.getDimensionPixelSize(5, (int) earnmoney_73.convertDpToPixel(20.0f, getContext()));
            this.mTextColor = obtainStyledAttributes.getColor(6, 0);
            this.mTopTextPadding = obtainStyledAttributes.getDimensionPixelSize(7, (int) earnmoney_73.convertDpToPixel(10.0f, getContext())) + ((int) earnmoney_73.convertDpToPixel(10.0f, getContext()));
            this.mCursorImage = obtainStyledAttributes.getDrawable(2);
            this.mCenterImage = obtainStyledAttributes.getDrawable(1);
            this.mEdgeWidth = obtainStyledAttributes.getInt(4, 10);
            this.mBorderColor = obtainStyledAttributes.getColor(3, 0);
            obtainStyledAttributes.recycle();
        }
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(getContext()).inflate(R.layout.luckywingame, (ViewGroup) this, false);
        this.earnmoney75 = (earnmoney_75) frameLayout.findViewById(R.id.pieView);
        this.ivCursorView = (ImageView) frameLayout.findViewById(R.id.cursorView);
        this.earnmoney75.setPieRotateListener(this);
        this.earnmoney75.setPieBackgroundColor(this.mBackgroundColor);
        this.earnmoney75.setTopTextPadding(this.mTopTextPadding);
        this.earnmoney75.setTopTextSize(this.mTopTextSize);
        this.earnmoney75.setSecondaryTextSizeSize(this.mSecondaryTextSize);
        this.earnmoney75.setPieCenterImage(this.mCenterImage);
        this.earnmoney75.setBorderColor(this.mBorderColor);
        this.earnmoney75.setBorderWidth(this.mEdgeWidth);
        int i = this.mTextColor;
        if (i != 0) {
            this.earnmoney75.setPieTextColor(i);
        }
        this.ivCursorView.setImageDrawable(this.mCursorImage);
        addView(frameLayout);
    }

    public boolean isTouchEnabled() {
        return this.earnmoney75.isTouchEnabled();
    }

    public void setTouchEnabled(boolean z) {
        this.earnmoney75.setTouchEnabled(z);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        for (int i = 0; i < getChildCount(); i++) {
            if (isPielView(getChildAt(i))) {
                return super.dispatchTouchEvent(motionEvent);
            }
        }
        return false;
    }

    private boolean isPielView(View view) {
        if (view instanceof ViewGroup) {
            for (int i = 0; i < getChildCount(); i++) {
                if (isPielView(((ViewGroup) view).getChildAt(i))) {
                    return true;
                }
            }
        }
        return view instanceof earnmoney_75;
    }

    public void setLuckyWheelBackgrouldColor(int i) {
        this.earnmoney75.setPieBackgroundColor(i);
    }

    public void setLuckyWheelCursorImage(int i) {
        this.ivCursorView.setBackgroundResource(i);
    }

    public void setLuckyWheelCenterImage(Drawable drawable) {
        this.earnmoney75.setPieCenterImage(drawable);
    }

    public void setBorderColor(int i) {
        this.earnmoney75.setBorderColor(i);
    }

    public void setLuckyWheelTextColor(int i) {
        this.earnmoney75.setPieTextColor(i);
    }

    public void setData(List<earnmoney_72> list) {
        this.earnmoney75.setData(list);
    }

    public void setRound(int i) {
        this.earnmoney75.setRound(i);
    }

    public void setPredeterminedNumber(int i) {
        this.earnmoney75.setPredeterminedNumber(i);
    }

    public void startLuckyWheelWithTargetIndex(int i) {
        this.earnmoney75.rotateTo(i);
    }

    public void startLuckyWheelWithRandomTarget() {
        Random random = new Random();
        earnmoney_75 earnmoney752 = this.earnmoney75;
        earnmoney752.rotateTo(random.nextInt(earnmoney752.getLuckyItemListSize() - 1));
    }
}
