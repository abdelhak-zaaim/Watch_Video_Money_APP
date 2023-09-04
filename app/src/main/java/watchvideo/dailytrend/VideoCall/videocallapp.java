package watchvideo.dailytrend.VideoCall;

import android.content.Context;
import android.hardware.Camera;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import androidx.core.app.NotificationCompat;
import java.io.IOException;

public class videocallapp extends SurfaceView implements SurfaceHolder.Callback {
    private SurfaceHolder f16012a;
    private Camera f16013b;

    @Override 
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
    }

    public videocallapp(Context context, Camera camera) {
        super(context);
        this.f16013b = camera;
        SurfaceHolder holder = getHolder();
        this.f16012a = holder;
        holder.addCallback(this);
        this.f16012a.setType(3);
    }

    public void mo11561a(Camera camera) {
        if (this.f16012a.getSurface() != null) {
            try {
                this.f16013b.stopPreview();
            } catch (Exception unused) {
            }
            setCamera(camera);
            try {
                this.f16013b.setPreviewDisplay(this.f16012a);
                this.f16013b.startPreview();
            } catch (Exception e) {
                Log.d(NotificationCompat.CATEGORY_MESSAGE, "Error starting camera preview: " + e.getMessage());
            }
        }
    }

    public void setCamera(Camera camera) {
        this.f16013b = camera;
    }

    @Override 
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        mo11561a(this.f16013b);
    }

    @Override 
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        try {
            Camera camera = this.f16013b;
            if (camera == null) {
                camera.setPreviewDisplay(surfaceHolder);
                this.f16013b.startPreview();
            }
        } catch (IOException e) {
            Log.d(NotificationCompat.CATEGORY_MESSAGE, "Error setting camera preview: " + e.getMessage());
        }
    }
}
