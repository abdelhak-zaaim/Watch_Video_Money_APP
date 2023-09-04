package watchvideo.dailytrend.Realmoney_3.earnmoney_46;

import android.annotation.SuppressLint;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Handler;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.FileAsyncHttpResponseHandler;
import com.loopj.android.http.RequestHandle;

import watchvideo.dailytrend.Realmoney_3.realmoney_47.realmoney_41;
import watchvideo.dailytrend.earnmoney_21;
import watchvideo.dailytrend.R;
import watchvideo.dailytrend.Realmoney_3.realmoney_35.earnmoney_34.realmoney_26;
import cz.msebera.android.httpclient.Header;
import java.io.File;
import java.util.HashMap;

public final class earnmoney_40 {
    private static final AsyncHttpClient CLIENT = new AsyncHttpClient();
    public static final HashMap<String, MyDownloadTask> listRunningTask = new HashMap<>();
    public static earnmoney_39 mDb;
    private static OnDownloadingStartListener mOnDownloadingStartListener;

    public interface OnDownloadingStartListener {
        void onDownloadStart(realmoney_26 modelVideo);
    }

    public static class MyDownloadTask {
        int action;
        private Context context;
        File file;
        final String fileNameUrl;
        int id;
        private boolean isMinusLength;
        private NotificationCompat.Builder mBuilder;
        private NotificationManager mNotifyManager;
        realmoney_26 modelVideo;
        earnmoney_41 onProgressDownloadInterface;
        RequestHandle requestHandle;

        public MyDownloadTask(realmoney_26 modelVideo2, File file2, int i) {
            this.file = null;
            this.id = 0;
            this.isMinusLength = false;
            this.fileNameUrl = this.modelVideo.getVideo().substring(this.modelVideo.getVideo().lastIndexOf(47) + 1);
            this.file = this.file;
            this.modelVideo = this.modelVideo;
            this.action = this.action;
            this.context = earnmoney_21.getInstance();
        }

        public void setOnProgressDownloadInterface(earnmoney_41 onProgressDownloadInterface2) {
            this.onProgressDownloadInterface = onProgressDownloadInterface2;
        }

        public RequestHandle getRequestHandle() {
            return this.requestHandle;
        }

        public void cancel(boolean z) {
            this.requestHandle.cancel(z);
        }

        public File getDownloadingFile() {
            return this.file;
        }

        public NotificationManager getNotifyManager() {
            return this.mNotifyManager;
        }

        @SuppressLint("WrongConstant")
        public void execute() {
            try {
                this.id = this.modelVideo.getId();
            } catch (Exception unused) {
                this.id = (int) System.currentTimeMillis();
            }
            NotificationManager notificationManager = (NotificationManager) this.context.getSystemService("notification");
            this.mNotifyManager = notificationManager;
            earnmoney_40.initChannels(notificationManager);
            NotificationCompat.Builder builder = new NotificationCompat.Builder(this.context);
            this.mBuilder = builder;
            builder.setContentTitle(this.file.getName()).setContentText("Download in progress").setLargeIcon(BitmapFactory.decodeResource(this.context.getResources(), R.mipmap.ic_launcher)).setSmallIcon(R.drawable.earnmoneywatchvideo_3);
            Intent intent = new Intent(this.context, realmoney_41.class);
             intent.putExtra("video_id", this.modelVideo);
            this.mBuilder.setContentIntent(PendingIntent.getActivity(this.context, (int) System.currentTimeMillis(), intent, 0));
            this.mBuilder.setProgress(100, 0, false);
            this.mBuilder.setOngoing(true);
            this.mBuilder.setSound(null);
            this.mBuilder.setDefaults(0);
            this.mNotifyManager.notify(this.id, this.mBuilder.build());
            Log.d("myVideo", "id :: " + this.id);
            this.requestHandle = earnmoney_40.CLIENT.get(this.modelVideo.getVideo(), new FileAsyncHttpResponseHandler(this.file) {
                private int lastPercentage = 0;

                @Override // com.loopj.android.http.FileAsyncHttpResponseHandler
                public void onFailure(int i, Header[] headerArr, Throwable th, File file) {
                    MyDownloadTask.this.mBuilder.setContentText("Failed Download");
                    if (file.exists()) {
                        file.delete();
                    }
                    th.printStackTrace();
                }

                @SuppressLint("NotificationTrampoline")
                @Override // com.loopj.android.http.FileAsyncHttpResponseHandler
                public void onSuccess(int i, Header[] headerArr, File file) {
                    earnmoney_40.mDb.addToFav(MyDownloadTask.this.modelVideo);
                    MyDownloadTask.this.mBuilder.setContentText("Download complete");
                    Intent intent = new Intent(MyDownloadTask.this.context, earnmoney_42.class);
                    intent.putExtra(earnmoney_44.EXTRA_ACTION, MyDownloadTask.this.action);
                    intent.putExtra("id", MyDownloadTask.this.id);
                    intent.putExtra(earnmoney_44.EXTRA_MODEL_VIDEO, MyDownloadTask.this.modelVideo);
                    MyDownloadTask.this.mBuilder.setContentIntent(PendingIntent.getBroadcast(MyDownloadTask.this.context, (int) System.currentTimeMillis(), intent, 0));
                    earnmoney_45.scanMediaFile(MyDownloadTask.this.context, file);
                    if (MyDownloadTask.this.action != 0) {
                        Intent intent2 = new Intent(earnmoney_44.INTENT_FILTER_DOWNLOAD_COMPLETE_VIDEO);
                        intent2.putExtra(earnmoney_44.EXTRA_ACTION, MyDownloadTask.this.action);
                        intent2.putExtra(earnmoney_44.EXTRA_MODEL_VIDEO, MyDownloadTask.this.modelVideo);
                        MyDownloadTask.this.context.sendBroadcast(intent2);
                    }
                }

                @Override // com.loopj.android.http.AsyncHttpResponseHandler
                public void onFinish() {
                    super.onFinish();
                    MyDownloadTask.this.mBuilder.setProgress(0, 0, false);
                    MyDownloadTask.this.mBuilder.setOngoing(false);
                    MyDownloadTask.this.mNotifyManager.notify(MyDownloadTask.this.id, MyDownloadTask.this.mBuilder.build());
                    earnmoney_40.listRunningTask.remove(String.valueOf(MyDownloadTask.this.modelVideo.getId()));
                    if (MyDownloadTask.this.onProgressDownloadInterface != null) {
                        MyDownloadTask.this.onProgressDownloadInterface.onFinish();
                    }
                }

                @Override // com.loopj.android.http.AsyncHttpResponseHandler
                public void onCancel() {
                    super.onCancel();
                    earnmoney_40.listRunningTask.remove(String.valueOf(MyDownloadTask.this.modelVideo.getId()));
                    MyDownloadTask.this.mNotifyManager.cancel(MyDownloadTask.this.id);
                }

                @Override // com.loopj.android.http.AsyncHttpResponseHandler
                public void onProgress(long j, long j2) {
                    super.onProgress(j, j2);
                    long fileSize = (long) MyDownloadTask.this.modelVideo.getFileSize();
                    if (fileSize <= 0) {
                        if (!MyDownloadTask.this.isMinusLength) {
                            MyDownloadTask.this.isMinusLength = true;
                        } else {
                            return;
                        }
                    }
                    if (MyDownloadTask.this.isMinusLength) {
                        MyDownloadTask.this.mBuilder.setProgress(0, 0, false);
                        MyDownloadTask.this.mNotifyManager.notify(MyDownloadTask.this.id, MyDownloadTask.this.mBuilder.build());
                        return;
                    }
                    int i = (int) ((j * 100) / fileSize);
                    if (this.lastPercentage < i) {
                        this.lastPercentage = i;
                        if (i % 10 == 0) {
                            MyDownloadTask.this.mBuilder.setProgress(100, i, false);
                            MyDownloadTask.this.mNotifyManager.notify(MyDownloadTask.this.id, MyDownloadTask.this.mBuilder.build());
                        }
                        if (MyDownloadTask.this.onProgressDownloadInterface != null) {
                            MyDownloadTask.this.onProgressDownloadInterface.onProgress(i);
                        }
                    }
                }
            });
        }
    }

    public static void startAction(realmoney_26 modelVideo, int i, earnmoney_39 earnmoney39) {
        startDownload(modelVideo, i);
        if (mDb == null) {
            mDb = earnmoney39;
        }
    }

    public static void setOnDownloadingStartListener(OnDownloadingStartListener onDownloadingStartListener) {
        mOnDownloadingStartListener = onDownloadingStartListener;
    }

    private static void startDownload(realmoney_26 modelVideo, int i) {
        File createFile = earnmoney_45.createFile(modelVideo);
        if (createFile != null) {
            Log.d("myVideo", modelVideo.getVideo());
            MyDownloadTask myDownloadTask = new MyDownloadTask(modelVideo, createFile, i);
            if (Build.VERSION.SDK_INT >= 23) {
                myDownloadTask.execute();
            }
            Log.d("myVideo", " key :: " + String.valueOf(modelVideo.getId()));
            listRunningTask.put(String.valueOf(modelVideo.getId()), myDownloadTask);
            OnDownloadingStartListener onDownloadingStartListener = mOnDownloadingStartListener;
            if (onDownloadingStartListener != null) {
                onDownloadingStartListener.onDownloadStart(modelVideo);
            }
        }
    }

    public static HashMap<String, MyDownloadTask> getDownloadingTasksMap() {
        return listRunningTask;
    }

    public static boolean isDownloadRunning(String str) {
        return listRunningTask.containsKey(str);
    }

    public static MyDownloadTask getDownloadingTask(String str) {
        return listRunningTask.get(str);
    }

    public static void initChannels(NotificationManager notificationManager) {
        int i = Build.VERSION.SDK_INT;
    }

    public static void cancelTask(final String str) {
        final MyDownloadTask remove = listRunningTask.remove(str);
        remove.cancel(true);
        if (remove.getDownloadingFile().exists()) {
            remove.getDownloadingFile().delete();
        }
        new Handler().postDelayed(new Runnable() {

            @Override // java.lang.Runnable
            public void run() {
                int i;
                try {
                    i = Integer.parseInt(str);
                } catch (Exception e) {
                    e.printStackTrace();
                    i = 0;
                }
                remove.getNotifyManager().cancel(i);
                if (remove.getDownloadingFile().exists()) {
                    remove.getDownloadingFile().delete();
                }
            }
        }, 1000);
    }

    public static void cancelAllRequest(final Context context) {
        HashMap<String, MyDownloadTask> hashMap = listRunningTask;
        if (!hashMap.isEmpty()) {
            for (String str : hashMap.keySet()) {
                MyDownloadTask myDownloadTask = listRunningTask.get(str);
                myDownloadTask.cancel(true);
                if (myDownloadTask.getDownloadingFile().exists()) {
                    myDownloadTask.getDownloadingFile().delete();
                }
            }
            new Handler().postDelayed(new Runnable() {

                @SuppressLint("WrongConstant")
                @Override // java.lang.Runnable
                public void run() {
                    ((NotificationManager) context.getSystemService("notification")).cancelAll();
                }
            }, 1000);
        }
    }
}
