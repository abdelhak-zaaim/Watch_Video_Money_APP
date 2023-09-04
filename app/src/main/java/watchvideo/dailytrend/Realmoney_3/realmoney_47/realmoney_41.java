package watchvideo.dailytrend.Realmoney_3.realmoney_47;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Environment;
import android.os.Handler;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;
import com.dinuscxj.progressbar.CircleProgressBar;
import com.google.android.exoplayer2.DefaultRenderersFactory;
import com.google.android.exoplayer2.audio.SilenceSkippingAudioProcessor;
import com.google.android.gms.common.internal.ImagesContract;
import com.loopj.android.http.AsyncHttpClient;
import com.mikhaellopez.circularprogressbar.CircularProgressBar;
import com.onesignal.shortcutbadger.impl.NewHtcHomeBadger;
import com.prabhat1707.verticalpager.VerticalViewPager;
import watchvideo.dailytrend.MyMoney;
import watchvideo.dailytrend.R;
import watchvideo.dailytrend.Realmoney_3.realmoney_35.earnmoney_34.realmoney_26;
import watchvideo.dailytrend.Realmoney_3.earnmoney_46.earnmoney_44;
import watchvideo.dailytrend.Realmoney_3.earnmoney_46.earnmoney_39;
import watchvideo.dailytrend.Realmoney_3.earnmoney_46.earnmoney_45;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

@SuppressLint("WrongConstant")

public class realmoney_41 extends earnmoney_44 {
    private static final AsyncHttpClient CLIENT = new AsyncHttpClient();
    private static final String TAG = "realmoney_41";
    public static String count = null;
    public static String filesize = null;
    public static String id = null;
    public static earnmoney_39 mDb = null;
    private static OnDownloadingStartListener mOnDownloadingStartListener = null;
    public static String name = null;
    public static final int progress_bar_type = 0;
    public static final String subject = "Download Videos for WhatsApp status";
    public static final String text = "Download All Status for Social Media status\nhttp://play.google.com/store/apps/details?id=com.hk.allstatus2018";
    public static String urlVideo;
    public String COUNTER = "counter_url";
    public String TOTAL_COINS_KEY = MyMoney.POINTS;
    public CountDownTimer countDownTimer;
    ArrayList<realmoney_26> dataItems;
    private earnmoney_39 db;
    Dialog dialog;
    ImageView fbShare;
    ImageView imageViewThumbDetails;
    ImageView imgCancelDownload;
    ImageView imgPlayIco;
    ImageView instaShare;
    private boolean isDownloadActionClicked = true;
    ImageView iv_download;
    FrameLayout layoutProgress;
    public Dialog loading_dialog;
    CountDownTimer mCountDownTimer;
    CircleProgressBar mPointProgreesbar;
    private VerticalViewPager mViewPager;
    public MyMoney myMoney;
    private ProgressDialog pDialog;
    CircularProgressBar progressBarDownload;
    private int savedOrientation;
    private String surfacingId = "Rewarded_Android";
    public TextView timeCounter;
    LinearLayout toolbar;
    ImageView videoDetailIvFav;
    ImageView videoDetailIvShare;
    ImageView videoDetailIvWhatsapp;
    VideoView videoView;
    TextView video_detail_tv_name;
    TextView video_detail_tv_viewcount;
    View view;
    ArrayList<View> viewArrayList;

    public interface OnDownloadingStartListener {
        void onDownloadStart(String str);
    }

    public void TimerCounter() {
        this.countDownTimer = new CountDownTimer(SilenceSkippingAudioProcessor.DEFAULT_PADDING_SILENCE_US, 1000) {
            @Override
            public void onTick(long j) {
                String format = String.format(Locale.getDefault(), "%02d", Integer.valueOf(((int) (j / 1000)) % 60));
                realmoney_41.this.timeCounter.setText(String.valueOf(format));
                realmoney_41.this.myMoney.setPref(realmoney_41.this.COUNTER, 0);
                Log.e(realmoney_41.TAG, "Time Left : " + format + " -- Millis: " + j);
            }

            @Override
            public void onFinish() {
                realmoney_41.this.timeCounter.setText("Done");
                realmoney_41.this.myMoney.setPref(realmoney_41.this.COUNTER, 1);
            }
        }.start();
    }

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(1024, 1024);
        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().build());
        setContentView(R.layout.realmoney);
        Dialog dialog2 = new Dialog(this);
        this.loading_dialog = dialog2;
        dialog2.requestWindowFeature(1);
        this.loading_dialog.setContentView(R.layout.spinwinspinandwin);
        this.loading_dialog.setCancelable(false);
        this.myMoney = new MyMoney(this);
        this.timeCounter = (TextView) findViewById(R.id.text_timer_task);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                realmoney_41.this.TimerCounter();
            }
        }, DefaultRenderersFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS);

        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitAll().build());
        this.viewArrayList = new ArrayList<>();
        this.toolbar = (LinearLayout) findViewById(R.id.toolbar);
        this.dataItems = new ArrayList<>();
        this.dataItems = earnmoney_45.dataItems;
        this.db = new earnmoney_39(this);
        final String stringExtra = getIntent().getStringExtra(ImagesContract.URL);
        id = getIntent().getStringExtra("id");
        urlVideo = getIntent().getStringExtra(ImagesContract.URL);
        name = getIntent().getStringExtra("name");
        filesize = getIntent().getStringExtra("size");
        count = getIntent().getStringExtra(NewHtcHomeBadger.COUNT);
        Log.e("-----", "----url" + stringExtra);
        this.mPointProgreesbar = (CircleProgressBar) findViewById(R.id.mPointProgreesbar);
        TextView textView = (TextView) findViewById(R.id.video_detail_tv_name);
        this.video_detail_tv_name = textView;
        textView.setText(name);
        TextView textView2 = (TextView) findViewById(R.id.video_detail_tv_view);
        this.video_detail_tv_viewcount = textView2;
        textView2.setText(count);
        this.imgPlayIco = (ImageView) findViewById(R.id.imgPlayIco);
        this.iv_download = (ImageView) findViewById(R.id.video_detail_iv_download);
        VideoView videoView2 = (VideoView) findViewById(R.id.video_dvvv);
        this.videoView = videoView2;
        videoView2.setVideoURI(Uri.parse(stringExtra));
        this.videoView.setDrawingCacheBackgroundColor(getResources().getColor(R.color.colorPrimary));
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(this.videoView);
        this.videoView.setMediaController(mediaController);
        this.videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                realmoney_41.this.videoView.start();
            }
        });


        this.videoView.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            @Override
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                Toast.makeText(realmoney_41.this.getApplicationContext(), "Failed to play video", 0).show();
                realmoney_41.this.onBackPressed();
                return false;
            }
        });


        this.videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                realmoney_41.this.imgPlayIco.setVisibility(0);
                realmoney_41.this.videoView.setVisibility(4);
                realmoney_41.this.LoadingDialog("Please Wait...");
                realmoney_41.this.GetWriteAllDataInPref(100);
                Toast.makeText(realmoney_41.this, "You get 100 coins.", 0).show();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        realmoney_41.this.loading_dialog.dismiss();
                    }
                }, DefaultRenderersFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS);
            }
        });


        this.iv_download.setOnClickListener(new View.OnClickListener() {
            @Override 
            public void onClick(View view) {
                String str = ".gif";
                try {
                    File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "myfolder");
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    if (!stringExtra.toString().contains(str)) {
                        if (stringExtra.toString().contains(".png")) {
                            str = ".png";
                        } else if (stringExtra.toString().contains(".3gp")) {
                            str = ".3gp";
                        } else {
                            stringExtra.toString().contains(".mp4");
                            str = ".mp4";
                        }
                    }
                    String format = DateFormat.getDateTimeInstance().format(new Date());
                    DownloadManager.Request request = new DownloadManager.Request(Uri.parse(stringExtra));
                    if (Build.VERSION.SDK_INT >= 19) {
                        DownloadManager.Request title = request.setAllowedNetworkTypes(3).setAllowedOverRoaming(false).setTitle("Video Demo");
                        DownloadManager.Request notificationVisibility = title.setTitle(realmoney_41.this.getString(R.string.app_name) + "-image-" + format.replace(" ", "").replace(":", "").replace(".", "") + str).setDescription(realmoney_41.this.getString(R.string.save_img)).setNotificationVisibility(1);
                        String str2 = Environment.DIRECTORY_DOCUMENTS;
                        notificationVisibility.setDestinationInExternalPublicDir(str2, "/Video Status/" + realmoney_41.name + ".mp4");
                    }
                    ((DownloadManager) realmoney_41.this.getSystemService("download")).enqueue(request);
                    Toast.makeText(realmoney_41.this.getApplicationContext(), "Download Successfull", 1).show();
                } catch (IllegalStateException e) {
                    Toast.makeText(realmoney_41.this.getApplicationContext(), "Storage Error", 1).show();
                    e.printStackTrace();
                } catch (Exception e2) {
                    Toast.makeText(realmoney_41.this.getApplicationContext(), "Unable to save video", 1).show();
                    e2.printStackTrace();
                }
            }
        });

    }


    public void GetWriteAllDataInPref(int i) {
        MyMoney myMoney2 = this.myMoney;
        String str = this.TOTAL_COINS_KEY;
        myMoney2.setPref(str, myMoney2.getPref(str, 0).intValue() + i);
        Log.e(TAG, "*****GetWriteAllDataFromFB : Get Set Done");
    }


    public void DownloadFiles() {
        try {
            DataInputStream dataInputStream = new DataInputStream(new URL(urlVideo).openStream());
            byte[] bArr = new byte[1024];
            FileOutputStream fileOutputStream = new FileOutputStream(new File(Environment.getExternalStorageDirectory() + "/data/test.mp4"));
            while (true) {
                int read = dataInputStream.read(bArr);
                if (read > 0) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    return;
                }
            }
        } catch (MalformedURLException e) {
            Log.e("SYNC getUpdate", "malformed url error", e);
        } catch (IOException e2) {
            Log.e("SYNC getUpdate", "io error", e2);
        } catch (SecurityException e3) {
            Log.e("SYNC getUpdate", "security error", e3);
        }
    }


    private void startDownloadActionHandler(int i) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                realmoney_41.this.isDownloadActionClicked = false;
            }
        }, (long) i);
    }


    @Override 
    public void onBackPressed() {
        this.videoView.pause();
        super.onBackPressed();
    }

    @Override
    public void onPause() {
        super.onPause();
        try {
            if (this.videoView.isPlaying()) {
                this.videoView.pause();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void LoadingDialog(String str) {
        ((TextView) this.loading_dialog.findViewById(R.id.tv_progress_info)).setText(str);
        this.loading_dialog.show();
    }

}
