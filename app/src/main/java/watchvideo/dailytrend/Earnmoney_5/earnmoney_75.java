package watchvideo.dailytrend.Earnmoney_5;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.ViewCompat;
import watchvideo.dailytrend.Earnmoney_5.earnmoney_71.earnmoney_72;
import java.util.List;
import java.util.Random;

public class earnmoney_75 extends View {
    private int borderColor;
    private int defaultBackgroundColor;
    long downPressTime;
    private Drawable drawableCenterImage;
    double fingerRotation;
    private boolean isRunning;
    private Paint mArcPaint;
    private Paint mBackgroundPaint;
    private int mCenter;
    private int mEdgeWidth;
    private List<earnmoney_72> mEarnmoney72List;
    private int mPadding;
    private PieRotateListener mPieRotateListener;
    private int mRadius;
    private RectF mRange;
    private int mRoundOfNumber;
    private int mSecondaryTextSize;
    private float mStartAngle;
    private TextPaint mTextPaint;
    private int mTopTextPadding;
    private int mTopTextSize;
    double[] newRotationStore;
    private int predeterminedNumber;
    private int textColor;
    public boolean touchEnabled;
    long upPressTime;
    float viewRotation;

    public interface PieRotateListener {
        void rotateDone(int i);
    }

    @interface SpinRotation {
        public static final int CLOCKWISE = 0;
        public static final int COUNTERCLOCKWISE = 1;
    }

    private float newRotationValue(float f, double d, double d2) {
        return ((f + ((float) (d2 - d))) + 360.0f) % 360.0f;
    }

    public earnmoney_75(Context context) {
        super(context);
        this.mRange = new RectF();
        this.mStartAngle = 0.0f;
        this.mRoundOfNumber = 4;
        this.mEdgeWidth = -1;
        this.isRunning = false;
        this.borderColor = 0;
        this.defaultBackgroundColor = 0;
        this.textColor = 0;
        this.predeterminedNumber = -1;
        this.newRotationStore = new double[3];
        this.touchEnabled = true;
    }

    public earnmoney_75(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRange = new RectF();
        this.mStartAngle = 0.0f;
        this.mRoundOfNumber = 4;
        this.mEdgeWidth = -1;
        this.isRunning = false;
        this.borderColor = 0;
        this.defaultBackgroundColor = 0;
        this.textColor = 0;
        this.predeterminedNumber = -1;
        this.newRotationStore = new double[3];
        this.touchEnabled = true;
    }

    public void setPieRotateListener(PieRotateListener pieRotateListener) {
        this.mPieRotateListener = pieRotateListener;
    }

    private void init() {
        Paint paint = new Paint();
        this.mArcPaint = paint;
        paint.setAntiAlias(true);
        this.mArcPaint.setDither(true);
        TextPaint textPaint = new TextPaint();
        this.mTextPaint = textPaint;
        textPaint.setAntiAlias(true);
        int i = this.textColor;
        if (i != 0) {
            this.mTextPaint.setColor(i);
        }
        this.mTextPaint.setTextSize(TypedValue.applyDimension(2, 14.0f, getResources().getDisplayMetrics()));
        int i2 = this.mPadding;
        float f = (float) i2;
        float f2 = (float) (i2 + this.mRadius);
        this.mRange = new RectF(f, f, f2, f2);
    }

    public int getLuckyItemListSize() {
        return this.mEarnmoney72List.size();
    }

    public void setData(List<earnmoney_72> list) {
        this.mEarnmoney72List = list;
        invalidate();
    }

    public void setPieBackgroundColor(int i) {
        this.defaultBackgroundColor = i;
        invalidate();
    }

    public void setBorderColor(int i) {
        this.borderColor = i;
        invalidate();
    }

    public void setTopTextPadding(int i) {
        this.mTopTextPadding = i;
        invalidate();
    }

    public void setPieCenterImage(Drawable drawable) {
        this.drawableCenterImage = drawable;
        invalidate();
    }

    public void setTopTextSize(int i) {
        this.mTopTextSize = i;
        invalidate();
    }

    public void setSecondaryTextSizeSize(int i) {
        this.mSecondaryTextSize = i;
        invalidate();
    }

    public void setBorderWidth(int i) {
        this.mEdgeWidth = i;
        invalidate();
    }

    public void setPieTextColor(int i) {
        this.textColor = i;
        invalidate();
    }

    private void drawPieBackgroundWithBitmap(Canvas canvas, Bitmap bitmap) {
        int i = this.mPadding / 2;
        canvas.drawBitmap(bitmap, (Rect) null, new Rect(i, i, getMeasuredWidth() - (this.mPadding / 2), getMeasuredHeight() - (this.mPadding / 2)), (Paint) null);
    }

    @Override 
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mEarnmoney72List != null) {
            drawBackgroundColor(canvas, this.defaultBackgroundColor);
            init();
            float f = this.mStartAngle;
            float size = 360.0f / ((float) this.mEarnmoney72List.size());
            for (int i = 0; i < this.mEarnmoney72List.size(); i++) {
                if (this.mEarnmoney72List.get(i).color != 0) {
                    this.mArcPaint.setStyle(Paint.Style.FILL);
                    this.mArcPaint.setColor(this.mEarnmoney72List.get(i).color);
                    canvas.drawArc(this.mRange, f, size, true, this.mArcPaint);
                }
                if (this.borderColor != 0 && this.mEdgeWidth > 0) {
                    this.mArcPaint.setStyle(Paint.Style.STROKE);
                    this.mArcPaint.setColor(this.borderColor);
                    this.mArcPaint.setStrokeWidth((float) this.mEdgeWidth);
                    canvas.drawArc(this.mRange, f, size, true, this.mArcPaint);
                }
                int i2 = this.mEarnmoney72List.get(i).color != 0 ? this.mEarnmoney72List.get(i).color : this.defaultBackgroundColor;
                if (!TextUtils.isEmpty(this.mEarnmoney72List.get(i).topText)) {
                    drawTopText(canvas, f, size, this.mEarnmoney72List.get(i).topText, i2);
                }
                if (!TextUtils.isEmpty(this.mEarnmoney72List.get(i).secondaryText)) {
                    drawSecondaryText(canvas, f, this.mEarnmoney72List.get(i).secondaryText, i2);
                }
                if (this.mEarnmoney72List.get(i).icon != 0) {
                    drawImage(canvas, f, BitmapFactory.decodeResource(getResources(), this.mEarnmoney72List.get(i).icon));
                }
                f += size;
            }
            drawCenterImage(canvas, this.drawableCenterImage);
        }
    }

    private void drawBackgroundColor(Canvas canvas, int i) {
        if (i != 0) {
            Paint paint = new Paint();
            this.mBackgroundPaint = paint;
            paint.setColor(i);
            int i2 = this.mCenter;
            float f = (float) i2;
            canvas.drawCircle(f, f, (float) (i2 - 5), this.mBackgroundPaint);
        }
    }

    @Override 
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int min = Math.min(getMeasuredWidth(), getMeasuredHeight());
        int paddingLeft = getPaddingLeft() == 0 ? 10 : getPaddingLeft();
        this.mPadding = paddingLeft;
        this.mRadius = min - (paddingLeft * 2);
        this.mCenter = min / 2;
        setMeasuredDimension(min, min);
    }

    private void drawImage(Canvas canvas, float f, Bitmap bitmap) {
        int size = this.mRadius / this.mEarnmoney72List.size();
        double size2 = (double) (f + ((360.0f / ((float) this.mEarnmoney72List.size())) / 2.0f));
        Double.isNaN(size2);
        Double.isNaN(size2);
        float f2 = (float) ((size2 * 3.141592653589793d) / 180.0d);
        double d = (double) this.mCenter;
        double d2 = (double) ((this.mRadius / 2) / 2);
        double d3 = (double) f2;
        double cos = Math.cos(d3);
        Double.isNaN(d2);
        Double.isNaN(d);
        Double.isNaN(d2);
        Double.isNaN(d);
        int i = (int) (d + (d2 * cos));
        double d4 = (double) this.mCenter;
        double d5 = (double) ((this.mRadius / 2) / 2);
        double sin = Math.sin(d3);
        Double.isNaN(d5);
        Double.isNaN(d4);
        Double.isNaN(d5);
        Double.isNaN(d4);
        int i2 = (int) (d4 + (d5 * sin));
        int i3 = size / 2;
        canvas.drawBitmap(bitmap, (Rect) null, new Rect(i - i3, i2 - i3, i + i3, i2 + i3), (Paint) null);
    }

    private void drawCenterImage(Canvas canvas, Drawable drawable) {
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(earnmoney_73.drawableToBitmap(drawable), 90, 90, false);
        canvas.drawBitmap(createScaledBitmap, (float) ((getMeasuredWidth() / 2) - (createScaledBitmap.getWidth() / 2)), (float) ((getMeasuredHeight() / 2) - (createScaledBitmap.getHeight() / 2)), (Paint) null);
    }

    private boolean isColorDark(int i) {
        return ColorUtils.calculateLuminance(i) <= 0.3d;
    }

    private void drawTopText(Canvas canvas, float f, float f2, String str, int i) {
        Path path = new Path();
        path.addArc(this.mRange, f, f2);
        if (this.textColor == 0) {
            this.mTextPaint.setColor(isColorDark(i) ? -1 : ViewCompat.MEASURED_STATE_MASK);
        }
        this.mTextPaint.setTypeface(Typeface.create(Typeface.SANS_SERIF, 0));
        this.mTextPaint.setTextAlign(Paint.Align.LEFT);
        this.mTextPaint.setTextSize((float) this.mTopTextSize);
        float measureText = this.mTextPaint.measureText(str);
        double d = (double) this.mRadius;
        Double.isNaN(d);
        double size = (double) this.mEarnmoney72List.size();
        Double.isNaN(size);
        double d2 = (double) (measureText / 2.0f);
        Double.isNaN(d2);
        Double.isNaN(d);
        Double.isNaN(size);
        Double.isNaN(d2);
        canvas.drawTextOnPath(str, path, (float) ((int) ((((d * 3.141592653589793d) / size) / 2.0d) - d2)), (float) this.mTopTextPadding, this.mTextPaint);
    }

    private void drawSecondaryText(Canvas canvas, float f, String str, int i) {
        canvas.save();
        int size = this.mEarnmoney72List.size();
        if (this.textColor == 0) {
            this.mTextPaint.setColor(isColorDark(i) ? -1 : ViewCompat.MEASURED_STATE_MASK);
        }
        this.mTextPaint.setTypeface(Typeface.create(Typeface.SANS_SERIF, 1));
        this.mTextPaint.setTextSize((float) this.mSecondaryTextSize);
        this.mTextPaint.setTextAlign(Paint.Align.LEFT);
        float measureText = this.mTextPaint.measureText(str);
        float f2 = (float) size;
        float f3 = f + ((360.0f / f2) / 2.0f);
        double d = (double) f3;
        Double.isNaN(d);
        double d2 = (double) this.mCenter;
        double d3 = (double) ((this.mRadius / 2) / 2);
        Double.isNaN(d);
        double d4 = (double) ((float) ((d * 3.141592653589793d) / 180.0d));
        double cos = Math.cos(d4);
        Double.isNaN(d3);
        Double.isNaN(d2);
        Double.isNaN(d3);
        Double.isNaN(d2);
        double d5 = (double) this.mCenter;
        double d6 = (double) ((this.mRadius / 2) / 2);
        double sin = Math.sin(d4);
        Double.isNaN(d6);
        Double.isNaN(d5);
        float f4 = (float) ((int) (d2 + (d3 * cos)));
        Double.isNaN(d6);
        Double.isNaN(d5);
        float f5 = (float) ((int) (d5 + (d6 * sin)));
        RectF rectF = new RectF(f4 + measureText, f5, f4 - measureText, f5);
        Path path = new Path();
        path.addRect(rectF, Path.Direction.CW);
        path.close();
        canvas.rotate(f3 + (f2 / 18.0f), f4, f5);
        canvas.drawTextOnPath(str, path, ((float) this.mTopTextPadding) / 7.0f, this.mTextPaint.getTextSize() / 2.75f, this.mTextPaint);
        canvas.restore();
    }

    private float getAngleOfIndexTarget(int i) {
        return (360.0f / ((float) this.mEarnmoney72List.size())) * ((float) i);
    }

    public void setRound(int i) {
        this.mRoundOfNumber = i;
    }

    public void setPredeterminedNumber(int i) {
        this.predeterminedNumber = i;
    }

    public void rotateTo(int i) {
        rotateTo(i, (new Random().nextInt() * 3) % 2, true);
    }

    public void rotateTo(final int i, final int i2, boolean z) {
        if (!this.isRunning) {
            int i3 = i2 <= 0 ? 1 : -1;
            float f = 2.0f;
            if (getRotation() != 0.0f) {
                setRotation(getRotation() % 360.0f);
                TimeInterpolator accelerateInterpolator = z ? new AccelerateInterpolator() : new LinearInterpolator();
                if (getRotation() <= 200.0f) {
                    f = 1.0f;
                }
                animate().setInterpolator(accelerateInterpolator).setDuration(500).setListener(new Animator.AnimatorListener() {
                    /* class com.watchall.trending.library.earnmoney_75.AnonymousClass1 */

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        earnmoney_75.this.isRunning = true;
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        earnmoney_75.this.isRunning = false;
                        earnmoney_75.this.setRotation(0.0f);
                        earnmoney_75.this.rotateTo(i, i2, false);
                    }
                }).rotation(f * 360.0f * ((float) i3)).start();
                return;
            }
            if (i3 < 0) {
                this.mRoundOfNumber++;
            }
            animate().setInterpolator(new DecelerateInterpolator()).setDuration(((long) (this.mRoundOfNumber * 1000)) + 900).setListener(new Animator.AnimatorListener() {
                /* class com.watchall.trending.library.earnmoney_75.AnonymousClass2 */

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    earnmoney_75.this.isRunning = true;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    earnmoney_75.this.isRunning = false;
                    earnmoney_75 earnmoney75 = earnmoney_75.this;
                    earnmoney75.setRotation(earnmoney75.getRotation() % 360.0f);
                    if (earnmoney_75.this.mPieRotateListener != null) {
                        earnmoney_75.this.mPieRotateListener.rotateDone(i);
                    }
                }
            }).rotation(((((((float) this.mRoundOfNumber) * 360.0f) * ((float) i3)) + 270.0f) - getAngleOfIndexTarget(i)) - ((360.0f / ((float) this.mEarnmoney72List.size())) / 2.0f)).start();
        }
    }

    public boolean isTouchEnabled() {
        return this.touchEnabled;
    }

    public void setTouchEnabled(boolean z) {
        this.touchEnabled = z;
    }

    @Override 
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.isRunning || !this.touchEnabled) {
            return false;
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        float width = ((float) getWidth()) / 2.0f;
        float height = ((float) getHeight()) / 2.0f;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.viewRotation = (getRotation() + 360.0f) % 360.0f;
            this.fingerRotation = Math.toDegrees(Math.atan2((double) (x - width), (double) (height - y)));
            this.downPressTime = motionEvent.getEventTime();
            return true;
        } else if (action == 1) {
            double degrees = Math.toDegrees(Math.atan2((double) (x - width), (double) (height - y)));
            float newRotationValue = newRotationValue(this.viewRotation, this.fingerRotation, degrees);
            this.fingerRotation = degrees;
            long eventTime = motionEvent.getEventTime();
            this.upPressTime = eventTime;
            long j = eventTime - this.downPressTime;
            if (j > 700) {
                return true;
            }
            if (newRotationValue <= -250.0f) {
                newRotationValue += 360.0f;
            } else if (newRotationValue >= 250.0f) {
                newRotationValue -= 360.0f;
            }
            float f = this.viewRotation;
            double d = (double) (newRotationValue - f);
            if (d >= 200.0d || d <= -200.0d) {
                if (f <= -50.0f) {
                    this.viewRotation = f + 360.0f;
                } else if (f >= 50.0f) {
                    this.viewRotation = f - 360.0f;
                }
            }
            double d2 = (double) (newRotationValue - this.viewRotation);
            if (d2 <= -60.0d || (d2 < 0.0d && d2 >= -59.0d && j <= 200)) {
                int i = this.predeterminedNumber;
                if (i > -1) {
                    rotateTo(i, 1, false);
                } else {
                    rotateTo(getFallBackRandomIndex(), 1, false);
                }
            }
            if (d2 >= 60.0d || (d2 > 0.0d && d2 <= 59.0d && this.upPressTime - this.downPressTime <= 200)) {
                int i2 = this.predeterminedNumber;
                if (i2 > -1) {
                    rotateTo(i2, 0, false);
                } else {
                    rotateTo(getFallBackRandomIndex(), 0, false);
                }
            }
            return true;
        } else if (action != 2) {
            return super.onTouchEvent(motionEvent);
        } else {
            double degrees2 = Math.toDegrees(Math.atan2((double) (x - width), (double) (height - y)));
            if (isRotationConsistent(degrees2)) {
                setRotation(newRotationValue(this.viewRotation, this.fingerRotation, degrees2));
            }
            return true;
        }
    }

    private int getFallBackRandomIndex() {
        return new Random().nextInt(this.mEarnmoney72List.size() - 1) + 0;
    }

    private boolean isRotationConsistent(double d) {
        double[] dArr = this.newRotationStore;
        if (Double.compare(dArr[2], dArr[1]) != 0) {
            double[] dArr2 = this.newRotationStore;
            dArr2[2] = dArr2[1];
        }
        double[] dArr3 = this.newRotationStore;
        if (Double.compare(dArr3[1], dArr3[0]) != 0) {
            double[] dArr4 = this.newRotationStore;
            dArr4[1] = dArr4[0];
        }
        double[] dArr5 = this.newRotationStore;
        dArr5[0] = d;
        if (Double.compare(dArr5[2], dArr5[0]) != 0) {
            double[] dArr6 = this.newRotationStore;
            if (Double.compare(dArr6[1], dArr6[0]) != 0) {
                double[] dArr7 = this.newRotationStore;
                if (Double.compare(dArr7[2], dArr7[1]) != 0) {
                    double[] dArr8 = this.newRotationStore;
                    if ((dArr8[0] <= dArr8[1] || dArr8[1] >= dArr8[2]) && (dArr8[0] >= dArr8[1] || dArr8[1] <= dArr8[2])) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
