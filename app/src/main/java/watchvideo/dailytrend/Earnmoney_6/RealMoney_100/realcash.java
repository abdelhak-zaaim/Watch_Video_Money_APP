package watchvideo.dailytrend.Earnmoney_6.RealMoney_100;

import static watchvideo.dailytrend.Earnmoney.earnmoney.quera_link;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Environment;
import android.os.PowerManager;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import com.dinuscxj.progressbar.CircleProgressBar;
import com.facebook.ads.NativeAdLayout;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Util;
import com.mikhaellopez.circularprogressbar.CircularProgressBar;
import watchvideo.dailytrend.Earnmoney_2.RealMoney_84;
import watchvideo.dailytrend.Earnmoney.earnmoney;
import watchvideo.dailytrend.Earnmoney.realmoney;
import watchvideo.dailytrend.Earnmoney.realmoney13;
import watchvideo.dailytrend.MyMoney;
import watchvideo.dailytrend.R;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

@SuppressLint("WrongConstant")

public class realcash extends RealMoney_101 {
    private static final String TAG = "realcash";
    public String TOTAL_COINS_KEY = MyMoney.POINTS;
    private PlayerView _mExoPlayerView;
    private boolean _mIsAutoPlay;
    private DataSource.Factory _mMDSourceFactory;
    private SimpleExoPlayer _mPlayer;
    private DefaultTrackSelector _mTrackSelector;
    CircularProgressBar cricleProgress;
    File file_path;
    int iPro = 0;
    ImageView imgFbOption;
    ImageView imgInstaOption;
    ImageView imgShare;
    ImageView imgShareOption;
    ImageView imgWaOption;
    Boolean is_canceled = false;
    Boolean is_mute = false;
    Boolean is_silent = false;
    Boolean is_true = false;
    private BandwidthMeter mBandwidthMeter;
    CountDownTimer mCountDownTimer;
    ImageView mFloatingActionButtonCoin;
    CircleProgressBar mPointProgreesbar;
    RelativeLayout mainnn;
    String name;
    MyMoney preferenc;
    ProgressBar progressBar;
    ImageView save;
    String str;
    String thumb;
    TextView title;
    String url;
    String video_name;
    Uri video_uri;

    RelativeLayout hscrollContainer;
    FrameLayout admob_native;
    NativeAdLayout nativeAdLayout;
    ShimmerFrameLayout qureka_banner;
    
    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(1024, 1024);
        setContentView(R.layout.watchvideoearnmoneyapp);
        this.preferenc = new MyMoney(this);
        this.progressBar = (ProgressBar) findViewById(R.id.progressBar);
        Intent intent = getIntent();
        this.name = intent.getStringExtra("Title");
        this.thumb = intent.getStringExtra("Image");
        this.url = intent.getStringExtra("Video");
        this.video_name = this.name + ".mp4";
        this.cricleProgress = (CircularProgressBar) findViewById(R.id.cricleProgress);
        this.imgShare = (ImageView) findViewById(R.id.imgShare);
        this.mainnn = (RelativeLayout) findViewById(R.id.mainnn);
        this.mPointProgreesbar = (CircleProgressBar) findViewById(R.id.mPointProgreesbar);
        this.mFloatingActionButtonCoin = (ImageView) findViewById(R.id.mFloatingActionButtonCoin);
        this.imgFbOption = (ImageView) findViewById(R.id.imgFbOption);
        this.imgInstaOption = (ImageView) findViewById(R.id.imgInstaOption);
        this.imgWaOption = (ImageView) findViewById(R.id.imgWaOption);
        this.imgShareOption = (ImageView) findViewById(R.id.imgShareOption);


        /// Native Ads :-
        hscrollContainer = findViewById(R.id.hscrollContainer);
        admob_native = findViewById(R.id.admob_native);
        nativeAdLayout = findViewById(R.id.fb_native);
        qureka_banner = findViewById(R.id.qureka_banner);


        if (earnmoney.isAdOn) {
            if (earnmoney.ad_mode.equalsIgnoreCase("admob")) {
                realmoney.Admobnative1(getApplicationContext(), admob_native, earnmoney.admob_native_id);
            } else if (earnmoney.ad_mode.equalsIgnoreCase("qureka")) {
                qureka_banner.setVisibility(View.VISIBLE);
            } else {
                hscrollContainer.setBackgroundResource(R.drawable.realmoney_140);
                realmoney13.loadNativeAd(getApplicationContext(), nativeAdLayout, earnmoney.facebook_native_id);
            }
        }


        qureka_banner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent("android.intent.action.VIEW");
                    Bundle bundle = new Bundle();
                    bundle.putBinder("android.support.customtabs.extra.SESSION", null);
                    intent.putExtras(bundle);
                    intent.putExtra("android.support.customtabs.extra.TOOLBAR_COLOR", R.color.colorPrimary);
                    intent.putExtra("android.support.customtabs.extra.EXTRA_ENABLE_INSTANT_APPS", true);
                    intent.setPackage("com.android.chrome");
                    intent.setData(Uri.parse(quera_link));
                    startActivity(intent, bundle);
                } catch (Exception e) {
                    e.printStackTrace();
                    Intent intent = new Intent("android.intent.action.VIEW");
                    Bundle bundle = new Bundle();
                    bundle.putBinder("android.support.customtabs.extra.SESSION", null);
                    intent.putExtras(bundle);
                    intent.putExtra("android.support.customtabs.extra.TOOLBAR_COLOR", R.color.colorPrimary);
                    intent.putExtra("android.support.customtabs.extra.EXTRA_ENABLE_INSTANT_APPS", true);
                    intent.setData(Uri.parse(quera_link));
                    startActivity(intent, bundle);
                }
            }
        });


        this.imgFbOption.setOnClickListener(new View.OnClickListener() {
            @Override 
            public void onClick(View view) {
                realcash.this.str = "com.facebook.katana";
                realcash realcash = realcash.this;
                if (!realcash.check_download(realcash.video_name)) {
                    realcash.this.is_true = true;
                    realcash.this.dowload_method();
                    return;
                }
                realcash.this.share_method();
            }
        });


        this.imgInstaOption.setOnClickListener(new View.OnClickListener() {
            @Override 
            public void onClick(View view) {
                realcash.this.str = "com.instagram.android";
                realcash realcash = realcash.this;
                if (!realcash.check_download(realcash.video_name)) {
                    realcash.this.is_true = true;
                    realcash.this.dowload_method();
                    return;
                }
                realcash.this.share_method();
            }
        });


        this.imgWaOption.setOnClickListener(new View.OnClickListener() {
            @Override 
            public void onClick(View view) {
                realcash.this.str = "com.whatsapp";
                realcash realcash = realcash.this;
                if (!realcash.check_download(realcash.video_name)) {
                    realcash.this.is_true = true;
                    realcash.this.dowload_method();
                    return;
                }
                realcash.this.share_method();
            }
        });


        this.imgShareOption.setOnClickListener(new View.OnClickListener() {
            @Override 
            public void onClick(View view) {
                realcash realcash = realcash.this;
                if (!realcash.check_download(realcash.video_name)) {
                    realcash.this.is_true = true;
                    realcash.this.dowload_method();
                    return;
                }
                realcash.this.share_method();
            }
        });


        ImageView imageView = (ImageView) findViewById(R.id.imgShare);
        this.save = imageView;
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override 
            public void onClick(View view) {
                realcash realcash = realcash.this;
                if (!realcash.check_download(realcash.video_name)) {
                    realcash.this.dowload_method();
                } else {
                    Toast.makeText(realcash.this, "Already Downloded", 0).show();
                }
            }
        });

        TextView textView = (TextView) findViewById(R.id.title);
        this.title = textView;
        textView.setText(this.name);
        this.mBandwidthMeter = new DefaultBandwidthMeter();
        this._mMDSourceFactory = new DefaultDataSourceFactory(this, Util.getUserAgent(this, "mediaPlayerSample"), (TransferListener) this.mBandwidthMeter);
        this._mIsAutoPlay = true;
        String str2 = this.name;

        if (str2 != null && !str2.equals("") && check_download(this.video_name)) {
            this.imgShare.setImageDrawable(getResources().getDrawable(R.drawable.watchvideoearnmoney_5));
        }

    }


    private void share_method() {
        this.file_path = new File(makeSubAppFolder(makeAppFolder(getResources().getString(R.string.dir_name)), getResources().getString(R.string.landscape)) + "/" + this.name + ".mp4");
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("video/*");
        StringBuilder sb = new StringBuilder();
        sb.append("Fullscreen Video\n");
        sb.append(Uri.parse(RealMoney_84.APP_BASE_URL + getPackageName()));
        sb.append("");
        intent.putExtra("android.intent.extra.TEXT", sb.toString());
        Uri uriForFile = FileProvider.getUriForFile(this, "watchvideo.dailytrend.provider", this.file_path);
        this.video_uri = uriForFile;
        intent.putExtra("android.intent.extra.STREAM", uriForFile);
        intent.setPackage(this.str);
        startActivity(Intent.createChooser(intent, "Share Sound File"));
    }


    private boolean check_download(String str2) {
        File[] listFiles = new File(Environment.getExternalStorageDirectory().toString() + "/" + getResources().getString(R.string.dir_name) + "/" + getResources().getString(R.string.landscape)).listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                if (str2.equals(file.getName())) {
                    return true;
                }
            }
        }
        return false;
    }

    
    public void requestPermission(String str2, String str3, int i) {
        ActivityCompat.requestPermissions(this, new String[]{str2}, i);
    }

    public void dowload_method() {
        if (ContextCompat.checkSelfPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
            new DownloadTask(this).execute(this.url);
        }
        requestPermission("android.permission.WRITE_EXTERNAL_STORAGE", "Storage write permission is needed to save the Video.", 102);
    }

    @Override 
    public void onBackPressed() {
        if (this.mCountDownTimer != null) {
            this.is_canceled = true;
            this.mCountDownTimer.cancel();
        }
        this._mPlayer.setPlayWhenReady(false);
        super.onBackPressed();
    }

    private void initializeVideoPlayer() {
        PlayerView playerView = (PlayerView) findViewById(R.id.video_view);
        this._mExoPlayerView = playerView;
        playerView.requestFocus();
        DefaultTrackSelector defaultTrackSelector = new DefaultTrackSelector(new AdaptiveTrackSelection.Factory());
        this._mTrackSelector = defaultTrackSelector;
        SimpleExoPlayer newSimpleInstance = ExoPlayerFactory.newSimpleInstance(this, defaultTrackSelector);
        this._mPlayer = newSimpleInstance;
        this._mExoPlayerView.setPlayer(newSimpleInstance);
        this._mPlayer.setPlayWhenReady(this._mIsAutoPlay);

        this._mPlayer.addListener(new Player.EventListener() {
            @Override
            public void onIsPlayingChanged(boolean z) {

            }

            @Override
            public void onLoadingChanged(boolean z) {
            }

            @Override
            public void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
            }

            @Override
            public void onPlaybackSuppressionReasonChanged(int i) {
            }

            @Override
            public void onPlayerError(ExoPlaybackException exoPlaybackException) {
            }

            @Override
            public void onPositionDiscontinuity(int i) {
            }

            @Override
            public void onRepeatModeChanged(int i) {
            }

            @Override
            public void onSeekProcessed() {
            }

            @Override
            public void onShuffleModeEnabledChanged(boolean z) {
            }

            @Override
            public void onTimelineChanged(Timeline timeline, int i) {
            }

            @Override
            public void onTimelineChanged(Timeline timeline, Object obj, int i) {
            }

            @Override
            public void onTracksChanged(TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray) {
            }

            @Override
            public void onPlayerStateChanged(boolean z, int i) {
                if (i == 2) {
                    realcash.this.progressBar.setVisibility(0);
                } else {
                    realcash.this.progressBar.setVisibility(4);
                }
                if (i == 3 && !realcash.this.is_canceled.booleanValue()) {
                    realcash.this.SetPoint();
                    Log.e(realcash.TAG, "onPlayerStateChanged: ");
                }
            }
        });
        this._mPlayer.prepare(new ExtractorMediaSource(Uri.parse(this.url), this._mMDSourceFactory, new DefaultExtractorsFactory(), null, null));
    }


    @Override 
    public void onResume() {
        super.onResume();
        initializeVideoPlayer();
    }


    private void releasePlayer() {
        SimpleExoPlayer simpleExoPlayer = this._mPlayer;
        if (simpleExoPlayer != null) {
            this._mIsAutoPlay = simpleExoPlayer.getPlayWhenReady();
            this._mPlayer.release();
            this._mPlayer = null;
            this._mTrackSelector = null;
        }
    }


    @Override 
    public void onStop() {
        super.onStop();
        releasePlayer();
    }


    public void SetPoint() {
        this.mPointProgreesbar.setProgress(0);
        CountDownTimer r0 = new CountDownTimer(15000, 1000) {
            @Override
            public void onTick(long j) {
                Log.v("Log_tag", "Tick of Progress" + realcash.this.iPro + j);
                realcash realcash = realcash.this;
                realcash.iPro = realcash.iPro + 1;
                realcash.this.mPointProgreesbar.setProgress((realcash.this.iPro * 100) / 15);
            }

            @Override
            public void onFinish() {
                realcash.this.iPro++;
                realcash.this.mPointProgreesbar.setProgress(100);
                Log.e(realcash.TAG, "CoinAdded: ");
                realcash.this.mFloatingActionButtonCoin.setImageResource(R.drawable.watchvideoearnmoney_1);
                realcash.this.GetWriteAllDataInPref(10);
                Toast.makeText(realcash.this, "You get 10 coins.", Toast.LENGTH_SHORT).show();
            }
        };

        this.mCountDownTimer = r0;
        r0.start();

    }


    public void GetWriteAllDataInPref(int i) {
        MyMoney myMoney = this.preferenc;
        String str2 = this.TOTAL_COINS_KEY;
        myMoney.setPref(str2, myMoney.getPref(str2, 0).intValue() + i);
        Log.e(TAG, "*****GetWriteAllDataFromFB : Get Set Done");
    }


    @Override 
    public void onPause() {
        super.onPause();
        releasePlayer();
        this.is_canceled = true;
    }


    public class DownloadTask extends AsyncTask<String, Integer, String> {
        private Context context;

        public DownloadTask(Context context2) {
            this.context = context2;
        }

        @Override
        public void onPreExecute() {
            super.onPreExecute();
            realcash.this.cricleProgress.setVisibility(0);
            PowerManager powerManager = (PowerManager) this.context.getSystemService("power");
            realcash.this.cricleProgress.setProgress(0.0f);
        }


        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate(numArr);
            realcash.this.cricleProgress.setProgress((float) numArr[0].intValue());
        }

        
        public void onPostExecute(String str) {
            realcash.this.cricleProgress.setVisibility(View.GONE);
            if (str != null) {
                Context context2 = this.context;
                Toast.makeText(context2, "Download error: " + str, Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this.context, "Video downloaded", Toast.LENGTH_SHORT).show();
            }

            if (realcash.this.is_true.booleanValue()) {
                realcash.this.share_method();
            }

            realcash.this.imgShare.setImageDrawable(realcash.this.getResources().getDrawable(R.drawable.watchvideoearnmoney_5));

        }


        public String doInBackground(String... strArr) {
            HttpURLConnection httpURLConnection;
            InputStream inputStream;
            Throwable th;
            Exception e;
            FileOutputStream fileOutputStream = null;
            try {
                httpURLConnection = (HttpURLConnection) new URL(strArr[0]).openConnection();
                try {
                    httpURLConnection.connect();
                    if (httpURLConnection.getResponseCode() != 200) {
                        String str = "Server returned HTTP " + httpURLConnection.getResponseCode() + " " + httpURLConnection.getResponseMessage();
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        return str;
                    }
                    int contentLength = httpURLConnection.getContentLength();
                    inputStream = httpURLConnection.getInputStream();
                    try {
                        realcash.this.file_path = new File(realcash.makeSubAppFolder(realcash.makeAppFolder(this.context.getResources().getString(R.string.dir_name)), this.context.getResources().getString(R.string.landscape)) + "/" + realcash.this.name + ".mp4");
                        FileOutputStream fileOutputStream2 = new FileOutputStream(realcash.this.file_path);
                        try {
                            byte[] bArr = new byte[4096];
                            long j = 0;
                            while (true) {
                                int read = inputStream.read(bArr);
                                if (read == -1) {
                                    try {
                                        fileOutputStream2.close();
                                        if (inputStream != null) {
                                            inputStream.close();
                                        }
                                    } catch (IOException unused) {
                                    }
                                    if (httpURLConnection != null) {
                                        httpURLConnection.disconnect();
                                    }
                                    return null;
                                } else if (isCancelled()) {
                                    inputStream.close();
                                    try {
                                        fileOutputStream2.close();
                                        if (inputStream != null) {
                                            inputStream.close();
                                        }
                                    } catch (IOException unused2) {
                                    }
                                    if (httpURLConnection != null) {
                                        httpURLConnection.disconnect();
                                    }
                                    return null;
                                } else {
                                    j += (long) read;
                                    if (contentLength > 0) {
                                        publishProgress(Integer.valueOf((int) ((100 * j) / ((long) contentLength))));
                                    }
                                    fileOutputStream2.write(bArr, 0, read);
                                }
                            }
                        } catch (Exception e2) {
                            e = e2;
                            fileOutputStream = fileOutputStream2;
                            try {
                                String exc = e.toString();
                                if (fileOutputStream != null) {
                                }
                                if (inputStream != null) {
                                }
                                if (httpURLConnection != null) {
                                }
                                return exc;
                            } catch (Throwable th2) {
                                th = th2;
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (IOException unused3) {
                                        if (httpURLConnection != null) {
                                        }
                                        throw th;
                                    }
                                }
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                                if (httpURLConnection != null) {
                                    httpURLConnection.disconnect();
                                }
                                throw th;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            fileOutputStream = fileOutputStream2;
                            if (fileOutputStream != null) {
                            }
                            if (inputStream != null) {
                            }
                            if (httpURLConnection != null) {
                            }
                            throw th;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        String exc2 = e.toString();
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException unused4) {
                                if (httpURLConnection != null) {
                                }
                                return exc2;
                            }
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        return exc2;
                    }
                } catch (Exception e4) {
                    e = e4;
                    inputStream = null;
                    String exc22 = e.toString();
                    if (fileOutputStream != null) {
                    }
                    if (inputStream != null) {
                    }
                    if (httpURLConnection != null) {
                    }
                    return exc22;
                } catch (Throwable th4) {
                    th = th4;
                    inputStream = null;
                    if (fileOutputStream != null) {
                    }
                    if (inputStream != null) {
                    }
                    if (httpURLConnection != null) {
                    }
                    throw th;
                }
            } catch (Exception e5) {
                e = e5;
                httpURLConnection = null;
                inputStream = null;
                String exc222 = e.toString();
                if (fileOutputStream != null) {
                }
                if (inputStream != null) {
                }
                if (httpURLConnection != null) {
                }
                return exc222;
            } catch (Throwable th5) {
                th = th5;
                httpURLConnection = null;
                inputStream = null;
                if (fileOutputStream != null) {
                }
                if (inputStream != null) {
                }
                if (httpURLConnection != null) {
                }
                try {
                    throw th;
                } catch (Throwable throwable) {
                    throwable.printStackTrace();
                }
            }
            return null;
        }
    }


    public static String makeAppFolder(String str2) {

        File file = null;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
             file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS + "/" + str2).toString());
        } else {
             file = new File(Environment.getExternalStoragePublicDirectory("/" + str2).toString());
        }

        if (file.exists()) {
            return new File(Environment.getExternalStoragePublicDirectory("/" + str2).toString()).getPath();
        }

        file.mkdirs();
        return file.getPath();

    }


    public static String makeSubAppFolder(String str2, String str3) {
        File file = new File(str2 + "/" + str3);
        if (file.exists()) {
            return new File(str2 + "/" + str3).getPath();
        }
        file.mkdirs();
        return file.getPath();
    }


}
