package watchvideo.dailytrend.Realmoney;

import android.view.animation.Interpolator;

public class realmoney_49 implements Interpolator {
    double mAmplitude = 1.0d;
    double mFrequency = 10.0d;

    public realmoney_49(double d, double d2) {
        this.mAmplitude = d;
        this.mFrequency = d2;
    }

    @Override
    public float getInterpolation(float f) {
        double d = this.mAmplitude;
        if (d <= 0.0d && d <= 0.0d) {
            int i = (d > 0.0d ? 1 : (d == 0.0d ? 0 : -1));
        }
        double d2 = (double) (-f);
        Double.isNaN(d2);
        double d3 = this.mFrequency;
        double d4 = (double) f;
        Double.isNaN(d4);
        Double.isNaN(d2);
        Double.isNaN(d4);
        Double.isNaN(d2);
        Double.isNaN(d4);
        return (float) ((Math.pow(2.718281828459045d, d2 / d) * -1.0d * Math.cos(d3 * d4)) + 1.0d);
    }
}
