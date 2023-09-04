package watchvideo.dailytrend.Earnmoney_6.RealMoney_104;

import android.content.Context;
import android.content.Intent;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Environment;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.FileAsyncHttpResponseHandler;
import com.loopj.android.http.RequestHandle;
import watchvideo.dailytrend.Earnmoney_6.EarnMoney_104.moneyapp_3;
import watchvideo.dailytrend.R;
import cz.msebera.android.httpclient.Header;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class RealMoney_108 {
    int a = 0;
    private FileAsyncHttpResponseHandler fileAsyncHttpResponseHandler;
    private RequestHandle requestHandle;

    public interface AllFilesDelegate {
        void downloadedList(ArrayList<moneyapp_3> arrayList);
    }

    public interface VideoDownloadListerner {
        void onComplate();

        void onFail(String str);

        void onStart();

        void onUpdate(float f);
    }


    private void copy(File file, File file2) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            byte[] bArr = new byte[1024];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read > 0) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    fileOutputStream.close();
                    fileInputStream.close();
                    return;
                }
            }
        } catch (Throwable unused) {
            fileInputStream.close();
        }
    }

    public static void getDownloadedFile(final int i, final Context context, final AllFilesDelegate allFilesDelegate) {
        final ArrayList arrayList = new ArrayList();
        new AsyncTask<String, String, String>() {

            public String doInBackground(String... strArr) {
                File file;
                File[] listFiles;
                try {
                    if (context == null) {
                        return null;
                    }

                    if (i == RealMoney_105.IS_FULLSCREEN_VIDEOS) {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                            file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS + "/" + context.getResources().getString(R.string.dir_name) + "/").toString());
                        } else {
                            file = new File(Environment.getExternalStoragePublicDirectory("/" + context.getResources().getString(R.string.dir_name) + "/").toString());
                        }
                    } else {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                            file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS + "/" + context.getResources().getString(R.string.dir_name) + "/" + context.getResources().getString(R.string.landscape)).toString());
                        } else {
                            file = new File(Environment.getExternalStoragePublicDirectory("/" + context.getResources().getString(R.string.dir_name) + "/" + context.getResources().getString(R.string.landscape)).toString());
                        }
                    }

                    if (!file.exists() || (listFiles = file.listFiles()) == null || listFiles.length <= 0) {
                        return null;
                    }

                    Arrays.sort(listFiles, new Comparator<File>() {
                        public int compare(File file, File file2) {
                            if (file.lastModified() > file2.lastModified()) {
                                return -1;
                            }
                            return file.lastModified() < file2.lastModified() ? 1 : 0;
                        }
                    });

                    for (int i = 0; i < listFiles.length; i++) {
                        if (!listFiles[i].isDirectory()) {
                            moneyapp_3 moneyapp3 = new moneyapp_3();
                            moneyapp3.setThumb(listFiles[i].getAbsolutePath());
                            moneyapp3.setVideoPath(listFiles[i].getAbsolutePath());
                            moneyapp3.setItemType(0);
                            String name = listFiles[i].getName();
                            if (listFiles[i].getName().contains("_VIDEO_")) {
                                try {
                                    name = listFiles[i].getName().substring(listFiles[i].getName().indexOf("_VIDEO_") + 7);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                            if (name.contains(".mp4")) {
                                name = name.replace(".mp4", "");
                            }
                            moneyapp3.setTitle(name);
                            arrayList.add(moneyapp3);
                        }
                    }
                    return null;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return null;
                }
            }

            @Override
            public void onPreExecute() {
                super.onPreExecute();
            }

            public void onPostExecute(String str) {
                super.onPostExecute(str);
                try {

                    if (allFilesDelegate != null) {
                        allFilesDelegate.downloadedList(arrayList);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.execute("");
    }

    public void cancelDownload(final Context context) {
        if (this.requestHandle != null) {
            new Thread(new Runnable() {

                @Override
                public void run() {
                    try {
                        RealMoney_108.this.requestHandle.cancel(true);
                        if (RealMoney_108.this.fileAsyncHttpResponseHandler != null) {
                            RealMoney_108.this.fileAsyncHttpResponseHandler.deleteTargetFile();
                        }
                        RealMoney_108.this.requestHandle = null;
                        File file = new File(Environment.getExternalStorageDirectory() + "/" + context.getResources().getString(R.string.app_name) + "/");
                        if (file.exists()) {
                            File file2 = new File(file + "/.temp");
                            if (file2.exists()) {
                                file2.delete();
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }

    public void downloadVideo(final int i, final Context context, String str, final String str2, final VideoDownloadListerner videoDownloadListerner) {
        File file;
        if (i == RealMoney_105.IS_FULLSCREEN_VIDEOS) {
            file = new File(Environment.getExternalStorageDirectory() + "/" + context.getResources().getString(R.string.dir_name) + "/");
        } else {
            file = new File(Environment.getExternalStorageDirectory() + "/" + context.getResources().getString(R.string.dir_name) + "/" + context.getResources().getString(R.string.landscape));
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file + "/.temp");
        if (file2.exists()) {
            file2.delete();
        }
        if (!file2.exists()) {
            file2.mkdir();
        }

        this.fileAsyncHttpResponseHandler = new FileAsyncHttpResponseHandler(context) {
            @Override
            public void onFailure(int i, Header[] headerArr, Throwable th, File file) {
                if (th != null) {
                    try {
                        if (th.getMessage() != null && !th.getMessage().contains("Connection pool shut down") && !th.getMessage().contains("Broken pipe")) {
                            videoDownloadListerner.onFail(RealMoney_105.PLZ_TRY_AGAIN);
                            if (file.exists()) {
                                file.delete();
                            }
                            RealMoney_108.this.requestHandle = null;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                videoDownloadListerner.onFail("");
                file.exists();
                RealMoney_108.this.requestHandle = null;
            }

            @Override
            public void onProgress(long j, long j2) {
                super.onProgress(j, j2);
                videoDownloadListerner.onUpdate((float) ((j * 100) / j2));
            }

            @Override
            public void onStart() {
                super.onStart();
                videoDownloadListerner.onStart();
            }

            @Override
            public void onSuccess(int i, Header[] headerArr, File file) {
                File file2;
                if (file != null) {
                    try {
                        if (i == RealMoney_105.IS_FULLSCREEN_VIDEOS) {
                            file2 = new File(Environment.getExternalStorageDirectory() + "/" + context.getResources().getString(R.string.dir_name) + "/" + str2);
                        } else {
                            file2 = new File(Environment.getExternalStorageDirectory() + "/" + context.getResources().getString(R.string.dir_name) + "/" + context.getResources().getString(R.string.landscape) + "/" + str2);
                        }
                        if (!file2.exists()) {
                            try {
                                file2.createNewFile();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        try {
                            RealMoney_108.this.copy(file, file2);
                            if (file.exists()) {
                                file.delete();
                            }
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                        File file3 = new File(file2 + "/.temp");
                        if (file3.exists()) {
                            file3.delete();
                        }
                        MediaScannerConnection.scanFile(context, new String[]{file2.getAbsolutePath()}, null, new MediaScannerConnection.OnScanCompletedListener() {

                            @Override
                            public void onScanCompleted(String str, Uri uri) {
                            }
                        });
                        EarnMoney_103 Instance = EarnMoney_103.Instance();
                        EarnMoney_103.Instance().getClass();
                        if (!Instance.getBooleanPref("share_is_never")) {
                            EarnMoney_103 Instance2 = EarnMoney_103.Instance();
                            EarnMoney_103.Instance().getClass();
                            EarnMoney_103 Instance3 = EarnMoney_103.Instance();
                            EarnMoney_103.Instance().getClass();
                            Instance2.putPref("rate_download_count", Instance3.getIntPref("rate_download_count") + 1);
                            EarnMoney_103.Instance().savePref();
                        }
                        if (videoDownloadListerner != null) {
                            videoDownloadListerner.onComplate();
                        }
                        RealMoney_108.this.requestHandle = null;
                        if (context != null) {
                            new RealMoney_110(context).checkDialogs();
                            LocalBroadcastManager.getInstance(context).sendBroadcast(new Intent(RealMoney_105.BRODCAST_REFRASH_SAVED_LIST));
                        }
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        videoDownloadListerner.onFail(RealMoney_105.PLZ_TRY_AGAIN);
                    }
                }
            }
        };
        this.requestHandle = new AsyncHttpClient().get(str, this.fileAsyncHttpResponseHandler);
    }
}
