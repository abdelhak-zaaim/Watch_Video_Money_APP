package watchvideo.dailytrend.VideoCall;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.hardware.Camera;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;
import com.google.android.gms.common.internal.ImagesContract;
import watchvideo.dailytrend.R;

@SuppressLint("WrongConstant")

public class videocalling extends AppCompatActivity {
    private Camera Cameras;
    String VideoLink = "";
    ImageView block;
    ConstraintLayout container;
    ImageView disconect;
    private LinearLayout f15984A;
    private boolean f15985B = true;
    Boolean f15993J = false;
    Boolean f15995L = false;
    private videocallapp f15997t;
    ImageView f15998u;
    private Context f16003z;
    private SimpleExoPlayer player;
    private PlayerView playerView;
    ProgressBar progress_circular;
    private int random;
    ImageView speaker;
    TextView txt_retry;
    ImageView unmute;

    @Override 
    public void onBackPressed() {
        SimpleExoPlayer simpleExoPlayer = this.player;
        if (simpleExoPlayer != null) {
            simpleExoPlayer.stop();
        }
        super.onBackPressed();
    }

    @Override 
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.onlineearnmoney);
        this.f16003z = this;
        this.random = (int) (Math.random() * 706.0d);
        this.VideoLink = getIntent().getStringExtra(ImagesContract.URL);
        this.progress_circular = (ProgressBar) findViewById(R.id.progress_circular);
        this.f15984A = (LinearLayout) findViewById(R.id.cPreview);
        ImageView imageView = (ImageView) findViewById(R.id.swipe);
        this.unmute = (ImageView) findViewById(R.id.unmute);
        this.block = (ImageView) findViewById(R.id.block);
        this.disconect = (ImageView) findViewById(R.id.disconect);
        this.speaker = (ImageView) findViewById(R.id.speaker);
        this.container = (ConstraintLayout) findViewById(R.id.container);
        this.txt_retry = (TextView) findViewById(R.id.txt_retry);
        if (!this.VideoLink.isEmpty()) {
            new Handler().postDelayed(new C3149a(), 3000);
        }
        Camera open = Camera.open(1);
        this.Cameras = open;
        open.setDisplayOrientation(90);
        m19175s();
        videocallapp videoPlayerView = new videocallapp(this.f16003z, this.Cameras);
        this.f15997t = videoPlayerView;
        this.f15984A.addView(videoPlayerView);
        this.f15998u = imageView;
        imageView.setOnClickListener(new C3163a());
        this.Cameras.startPreview();
        this.unmute.setOnClickListener(new Muted());
        this.block.setOnClickListener(new Blocked());
        this.disconect.setOnClickListener(new Disconnected());
        this.speaker.setOnClickListener(new Spickers());
    }

    private int m19171o() {
        int numberOfCameras = Camera.getNumberOfCameras();
        for (int i = 0; i < numberOfCameras; i++) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            Camera.getCameraInfo(i, cameraInfo);
            if (cameraInfo.facing == 0) {
                this.f15985B = false;
                return i;
            }
        }
        return -1;
    }

    private int m19172p() {
        int numberOfCameras = Camera.getNumberOfCameras();
        for (int i = 0; i < numberOfCameras; i++) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            Camera.getCameraInfo(i, cameraInfo);
            if (cameraInfo.facing == 1) {
                this.f15985B = true;
                return i;
            }
        }
        return -1;
    }


    private void m19173q() {
        PlayerView playerView2 = (PlayerView) findViewById(R.id.videocallview);
        this.playerView = playerView2;
        playerView2.requestFocus();
        SimpleExoPlayer newSimpleInstance = ExoPlayerFactory.newSimpleInstance(this, new DefaultTrackSelector());
        this.player = newSimpleInstance;
        newSimpleInstance.addListener(new Player.EventListener() {

            @Override
            public /* synthetic */ void onIsPlayingChanged(boolean z) {
            }

            @Override
            public void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
            }

            @Override
            public /* synthetic */ void onPlaybackSuppressionReasonChanged(int i) {
            }

            @Override
            public /* synthetic */ void onTimelineChanged(Timeline timeline, int i) {
            }

            @Override
            public void onTimelineChanged(Timeline timeline, Object obj, int i) {
                Log.d(NotificationCompat.CATEGORY_MESSAGE, "timeLine Changed");
            }

            @Override
            public void onTracksChanged(TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray) {
                Log.d(NotificationCompat.CATEGORY_MESSAGE, "Tracks changed");
            }

            @Override
            public void onLoadingChanged(boolean z) {
                Log.d(NotificationCompat.CATEGORY_MESSAGE, "loding changed= " + z);
                if (z) {
                    videocalling.this.progress_circular.setVisibility(8);
                    videocalling.this.container.setVisibility(8);
                }
            }

            @Override
            public void onPlayerStateChanged(boolean z, int i) {
                Log.d(NotificationCompat.CATEGORY_MESSAGE, i + " state changed");
            }

            @Override
            public void onRepeatModeChanged(int i) {
                Log.d(NotificationCompat.CATEGORY_MESSAGE, "Repeat Mode");
            }

            @Override
            public void onShuffleModeEnabledChanged(boolean z) {
                Log.d(NotificationCompat.CATEGORY_MESSAGE, "Shuffle Mode changed");
            }

            @Override
            public void onPlayerError(ExoPlaybackException exoPlaybackException) {
                Log.e(NotificationCompat.CATEGORY_MESSAGE, "exoplayer error", exoPlaybackException);
                videocalling.this.txt_retry.setVisibility(0);
                videocalling.this.progress_circular.setVisibility(0);
                new Handler().postDelayed(new ErrorDialog(), 10000);
            }

            @Override
            public void onPositionDiscontinuity(int i) {
                Log.d(NotificationCompat.CATEGORY_MESSAGE, "Position Discountinuity");
            }

            @Override
            public void onSeekProcessed() {
                Log.d(NotificationCompat.CATEGORY_MESSAGE, "seek processed");
            }
        });
        SimpleExoPlayer simpleExoPlayer = this.player;
        simpleExoPlayer.prepare(new ExtractorMediaSource(Uri.parse(this.VideoLink + this.random + "/" + this.random + ".mp4"), new DefaultDataSourceFactory(this, Util.getUserAgent(this, getString(R.string.app_name))), new DefaultExtractorsFactory(), null, null));
        this.playerView.setPlayer(this.player);
        this.player.setPlayWhenReady(true);
    }

    public void m19174r() {
        Camera camera = this.Cameras;
        if (camera != null) {
            camera.stopPreview();
            this.Cameras.setPreviewCallback(null);
            this.Cameras.release();
            this.Cameras = null;
        }
    }

    private void m19175s() {
        ViewGroup.LayoutParams layoutParams = this.f15984A.getLayoutParams();
        double d = (double) getResources().getDisplayMetrics().widthPixels;
        Double.isNaN(d);
        Double.isNaN(d);
        Double.isNaN(d);
        int i = (int) (d * 0.3d);
        layoutParams.width = i;
        layoutParams.height = (i / 2) * 3;
        this.f15984A.setLayoutParams(layoutParams);
    }

    public void mo11553n() {
        if (this.f15985B) {
            int m19171o = m19171o();
            if (m19171o >= 0) {
                Camera open = Camera.open(m19171o);
                this.Cameras = open;
                open.setDisplayOrientation(90);
                this.f15997t.mo11561a(this.Cameras);
                return;
            }
            return;
        }
        int m19172p = m19172p();
        if (m19172p >= 0) {
            Camera open2 = Camera.open(m19172p);
            this.Cameras = open2;
            open2.setDisplayOrientation(90);
            this.f15997t.mo11561a(this.Cameras);
        }
    }

    @SuppressLint("WrongConstant")
    @Override 
    public void onPause() {
        super.onPause();
        m19174r();
        SimpleExoPlayer simpleExoPlayer = this.player;
        if (simpleExoPlayer != null) {
            simpleExoPlayer.stop();
        }
        this.txt_retry.setText("Signal Lost....");
        this.progress_circular.setVisibility(0);
        this.txt_retry.setVisibility(0);
    }

    @Override 
    public void onResume() {
        super.onResume();
        if (this.Cameras == null) {
            Camera open = Camera.open(1);
            this.Cameras = open;
            open.setDisplayOrientation(90);
            this.f15997t.mo11561a(this.Cameras);
            Log.d(NotificationCompat.CATEGORY_MESSAGE, "null");
        }
    }

    class C3149a implements Runnable {
        C3149a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            videocalling.this.m19173q();
        }
    }

    class C3163a implements View.OnClickListener {
        C3163a() {
        }

        @Override 
        public void onClick(View view) {
            if (Camera.getNumberOfCameras() > 1) {
                videocalling.this.m19174r();
                videocalling.this.mo11553n();
            }
        }
    }

    class Muted implements View.OnClickListener {
        Muted() {
        }

        @Override 
        public void onClick(View view) {
            if (videocalling.this.f15993J.booleanValue()) {
                videocalling.this.f15993J = false;
                videocalling.this.player.setVolume(100.0f);
                videocalling.this.unmute.setImageResource(R.drawable.watchvideoearnmoney_25);
                return;
            }
            videocalling.this.f15993J = true;
            videocalling.this.player.setVolume(0.0f);
            videocalling.this.unmute.setImageResource(R.drawable.earnmoneydaily_9);
        }
    }

    class Blocked implements View.OnClickListener {
        Blocked() {
        }

        @Override 
        public void onClick(View view) {
            Dialog dialog = new Dialog(videocalling.this, R.style.creativeDialogTheme);
            dialog.setContentView(R.layout.earnmoneyearnmoney);
            dialog.getWindow().setLayout(-1, -1);
            dialog.setCancelable(false);
            ((TextView) dialog.findViewById(R.id.yes)).setOnClickListener(new C3166a(this, dialog));
            ((TextView) dialog.findViewById(R.id.no)).setOnClickListener(new C3167b(this, dialog));
            dialog.show();
        }

        class C3166a implements View.OnClickListener {
            final Dialog f16007a;

            C3166a(Blocked blocked, Dialog dialog) {
                this.f16007a = dialog;
            }

            @Override 
            public void onClick(View view) {
                this.f16007a.dismiss();
            }
        }

        class C3167b implements View.OnClickListener {
            final Dialog f16008a;

            C3167b(Blocked blocked, Dialog dialog) {
                this.f16008a = dialog;
            }

            @Override 
            public void onClick(View view) {
                this.f16008a.dismiss();
            }
        }
    }

    class Disconnected implements View.OnClickListener {
        Disconnected() {
        }

        @Override 
        public void onClick(View view) {
            if (videocalling.this.player != null) {
                videocalling.this.player.stop();
            }
            videocalling.this.onBackPressed();
        }
    }

    class Spickers implements View.OnClickListener {
        Spickers() {
        }

        @Override 
        public void onClick(View view) {
            if (videocalling.this.f15995L.booleanValue()) {
                videocalling.this.f15995L = false;
                videocalling.this.speaker.setImageResource(R.drawable.moneydailyearn);
                return;
            }
            videocalling.this.f15995L = true;
            videocalling.this.speaker.setImageResource(R.drawable.moneydailyearn_4);
        }
    }

    private class ErrorDialog implements Runnable {
        private ErrorDialog() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                final Dialog dialog = new Dialog(videocalling.this, R.style.creativeDialogTheme);
                dialog.setContentView(R.layout.watchvideomoney);
                dialog.getWindow().setLayout(-1, -1);
                dialog.setCancelable(true);
                ((TextView) dialog.findViewById(R.id.atv_sorry_title)).setText("Sorry !\n Caller not available try again after sometime.");
                ((TextView) dialog.findViewById(R.id.btn_ok)).setOnClickListener(new View.OnClickListener() {

                    @Override 
                    public void onClick(View view) {
                        videocalling.this.finish();
                        dialog.dismiss();
                    }
                });
                dialog.show();
            } catch (Exception unused) {
            }
        }
    }
}
