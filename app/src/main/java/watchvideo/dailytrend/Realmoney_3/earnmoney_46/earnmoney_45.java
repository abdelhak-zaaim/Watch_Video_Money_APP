package watchvideo.dailytrend.Realmoney_3.earnmoney_46;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.TypedArray;
import android.media.MediaScannerConnection;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Parcelable;
import android.util.Log;
import android.widget.Toast;
import androidx.core.content.FileProvider;
import com.google.android.exoplayer2.util.MimeTypes;
import com.loopj.android.http.AsyncHttpClient;
import watchvideo.dailytrend.R;
import watchvideo.dailytrend.Realmoney_3.realmoney_35.earnmoney_34.realmoney_26;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class earnmoney_45 {
    public static final int ACTION_DOWNLOAD = 0;
    public static final int ACTION_FACEBOOK = 3;
    public static final int ACTION_INSTAGRAM = 2;
    public static final int ACTION_MESSENGER = 5;
    public static final int ACTION_RINGTONE = 6;
    public static final int ACTION_SHARE = 6;
    public static final int ACTION_TWITTER = 4;
    public static final int ACTION_WHATSAPP = 1;
    public static int ADS_COUNTER = 0;
    private static final int ADS_COUNTER_THRESHOLD = 5;
    public static int ADS_POSITIION_LIST = 5;
    public static final String BASE_URL = "http://www.kids2win.com/api/";
    public static final int DATA_COUNTER = 15;
    private static final int DAYS_UNTIL_PROMPT = 3;
    public static final String DIRECTORY_DOWNLOAD_DP = "Memes - All Status";
    public static final String DIRECTORY_DOWNLOAD_JOKES = "DP - All Status";
    public static final String DIRECTORY_DOWNLOAD_RINGTONE = ("Video" + File.separator + "Video Status");
    public static final String DIRECTORY_DOWNLOAD_VIDEO = "Video - All Status";
    public static int LoanAmount = 0;
    public static final String MAIN_URL = "http://www.kids2win.com/";
    public static int SelectedVideo = 1;
    public static final int UPLOAD_VIDEO_RESPONSE_TIMEOUT = 30000;
    public static final int UPLOAD_VIDEO_SOCKET_TIMEOUT = 30000;
    public static final int VIEW_TYPE_ADS = 3;
    public static final int VIEW_TYPE_ITEM_LIST = 2;
    public static final int VIEW_TYPE_LOADING = 1;
    public static ArrayList<realmoney_26> dataItems = new ArrayList<>();
    public static final String subject = "Download Videos for WhatsApp status";
    public static final String subjectDp = "Download Dp for All social media";
    public static final String subjectJokes = "Download Memes for All social media";
    public static final String text = "Download All Status for Social Media status\nhttp://play.google.com/store/apps/details?id=com.hk.allstatus2018";

    public static void showAppRaterOnDownload(Context context) {
    }

    private static String getAbsoluteUrl(String str) {
        return BASE_URL + str;
    }

    public static int convertDpToPixel(int i, Context context) {
        return (int) (((float) i) * (((float) context.getResources().getDisplayMetrics().densityDpi) / 160.0f));
    }

    public static boolean isNetworkAvailable(Context context) {
        if (context == null) {
            return false;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager.getActiveNetworkInfo() == null || !connectivityManager.getActiveNetworkInfo().isConnected()) {
            return false;
        }
        return true;
    }

    public static String getThreeWordTitle(String str) {
        String[] split = str.split("\\s+");
        if (split.length <= 3) {
            return str;
        }
        return "" + split[0] + " " + split[1] + " " + split[2];
    }

    private static AsyncHttpClient getClient() {
        AsyncHttpClient asyncHttpClient = new AsyncHttpClient();
        asyncHttpClient.setConnectTimeout(5000);
        asyncHttpClient.setResponseTimeout(20000);
        asyncHttpClient.setMaxRetriesAndTimeout(2, 2000);
        return asyncHttpClient;
    }

    public static void scanMediaFile(Context context, File file) {
        MediaScannerConnection.scanFile(context, new String[]{file.getAbsolutePath()}, null, new MediaScannerConnection.OnScanCompletedListener() {

            @Override
            public void onScanCompleted(String str, Uri uri) {
                Log.i("ExternalStorage", "Scanned " + str + ":");
                StringBuilder sb = new StringBuilder();
                sb.append("-> uri=");
                sb.append(uri);
                Log.i("ExternalStorage", sb.toString());
            }
        });
    }

    public static int getClickableBGBorderLessIfGreaterThen21(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Build.VERSION.SDK_INT >= 21 ? new int[]{R.attr.selectableItemBackgroundBorderless} : new int[]{R.attr.selectableItemBackground});
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        return resourceId;
    }

    static void showToast(final Activity activity, final String str) {
        activity.runOnUiThread(new Runnable() {

            @Override // java.lang.Runnable
            public void run() {
                Toast.makeText(activity, str, 0).show();
            }
        });
    }

    public static File createFile(realmoney_26 modelVideo) {
        String video = modelVideo.getVideo();
        String substring = video.substring(video.lastIndexOf(".") - 6);
        Log.d("tag", "file name :: " + substring);
        String str = modelVideo.getName() + substring;
        File createStorageDir = createStorageDir(MimeTypes.BASE_TYPE_VIDEO);
        if (createStorageDir != null) {
            return new File(createStorageDir, str);
        }
        return null;
    }

    public static File createStorageDir(String str) {
        File file;
        if (str.equals(MimeTypes.BASE_TYPE_VIDEO)) {
            file = new File(Environment.getExternalStorageDirectory() + File.separator + "Video StatusH" + File.separator);
        } else {
            file = null;
        }
        if (file.exists() || file.isDirectory()) {
            Log.i("CreateDir", "App dir already exists");
            return file;
        } else if (file.mkdirs()) {
            Log.i("CreateDir", "App dir created");
            return file;
        } else {
            Log.w("CreateDir", "Unable to create app dir!");
            return null;
        }
    }

    public static boolean checkIfAppInstallForAction(Activity activity, int i) {
        if (i == 1 && !appInstalledOrNot(activity, "com.whatsapp")) {
            showToast(activity, "Install WhatsApp first");
            return false;
        } else if (i == 2 && !appInstalledOrNot(activity, "com.instagram.android")) {
            showToast(activity, "Install Instagram first");
            return false;
        } else if (i == 3 && !appInstalledOrNot(activity, "com.facebook.katana")) {
            showToast(activity, "Install Facebook first");
            return false;
        } else if (i == 5 && !appInstalledOrNot(activity, "com.facebook.orca")) {
            showToast(activity, "Install Facebook Messenger first");
            return false;
        } else if (i != 4 || appInstalledOrNot(activity, "com.bsb.hike")) {
            return true;
        } else {
            showToast(activity, "Install Hike First");
            return false;
        }
    }

    public static boolean appInstalledOrNot(Context context, String str) {
        try {
            context.getPackageManager().getPackageInfo(str, 0);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    @SuppressLint("WrongConstant")
    public static void shareVideo(Activity activity, int i, realmoney_26 modelVideo) {
        Uri uri;
        Log.d("myReceiver", "shareFileCalled");
        File createFile = createFile(modelVideo);
        scanMediaFile(activity, createFile);
        if (Build.VERSION.SDK_INT <= 25) {
            uri = Uri.parse("file://" + createFile.getAbsolutePath());
        } else {
            uri = FileProvider.getUriForFile(activity, "watchall.trending.provider", createFile);
        }
        if (i == 0) {
            Intent intent = new Intent("android.intent.action.VIEW", uri);
            intent.setDataAndType(uri, MimeTypes.VIDEO_MP4);
             try {
                activity.startActivity(intent);
            } catch (ActivityNotFoundException unused) {
                showToast(activity, "Not any app found that handle Video");
            }
        } else if (i == 6) {
            Intent intent2 = new Intent("android.intent.action.SEND");
            intent2.setType("video/*");
            intent2.putExtra("android.intent.extra.SUBJECT", "Download Videos for WhatsApp status");
            intent2.putExtra("android.intent.extra.TEXT", modelVideo.getName() + "\n\nDownload All Status for Social Media status\nhttp://play.google.com/store/apps/details?id=com.hk.allstatus2018");
            intent2.putExtra("android.intent.extra.STREAM", uri);
             activity.startActivity(Intent.createChooser(intent2, "Choose one..."));
        } else if (i == 1) {
            Intent intent3 = new Intent("android.intent.action.SEND");
            intent3.setPackage("com.whatsapp");
            intent3.setType("video/*");
            intent3.putExtra("android.intent.extra.SUBJECT", "Download Videos for WhatsApp status");
            intent3.putExtra("android.intent.extra.TEXT", modelVideo.getName() + "\n\nDownload All Status for Social Media status\nhttp://play.google.com/store/apps/details?id=com.hk.allstatus2018");
            intent3.putExtra("android.intent.extra.STREAM", uri);
             try {
                activity.startActivity(intent3);
            } catch (ActivityNotFoundException unused2) {
                showToast(activity, "Install WhatsApp first");
            }
        } else if (i == 2) {
            Intent intent4 = new Intent("android.intent.action.SEND");
            intent4.setPackage("com.instagram.android");
            intent4.setType("video/*");
            intent4.putExtra("android.intent.extra.SUBJECT", "Download Videos for WhatsApp status");
            intent4.putExtra("android.intent.extra.TEXT", "Download All Status for Social Media status\nhttp://play.google.com/store/apps/details?id=com.hk.allstatus2018");
            intent4.putExtra("android.intent.extra.STREAM", uri);
             try {
                activity.startActivity(intent4);
            } catch (ActivityNotFoundException unused3) {
                showToast(activity, "Install Instagram first");
            }
        } else if (i == 3) {
            shareFacebook(activity, uri, "Download Videos for WhatsApp status", "Download All Status for Social Media status\nhttp://play.google.com/store/apps/details?id=com.hk.allstatus2018");
        } else if (i == 4) {
            shareHike(activity, uri, "Download Videos for WhatsApp status", "Download All Status for Social Media status\nhttp://play.google.com/store/apps/details?id=com.hk.allstatus2018");
        } else if (i == 5) {
            shareMessenger(activity, uri, "Download Videos for WhatsApp status", "Download All Status for Social Media status\nhttp://play.google.com/store/apps/details?id=com.hk.allstatus2018");
        }
    }

    private static void shareFacebook(Activity activity, Uri uri, String str, String str2) {
        ArrayList arrayList = new ArrayList();
        if (appInstalledOrNot(activity, "com.facebook.katana")) {
            PackageManager packageManager = activity.getPackageManager();
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("video/*");
            List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 0);
            for (int i = 0; i < queryIntentActivities.size(); i++) {
                ResolveInfo resolveInfo = queryIntentActivities.get(i);
                String str3 = resolveInfo.activityInfo.packageName;
                Log.i("Package Name", str3);
                if (str3.contains("com.facebook.katana")) {
                    Intent intent2 = new Intent();
                    intent2.setComponent(new ComponentName(str3, resolveInfo.activityInfo.name));
                    intent2.setAction("android.intent.action.SEND");
                    intent2.setType("video/*");
                    intent2.putExtra("android.intent.extra.TEXT", str2);
                    intent2.putExtra("android.intent.extra.SUBJECT", str);
                    intent2.putExtra("android.intent.extra.STREAM", uri);
                    intent2.setPackage(str3);
                    arrayList.add(intent2);
                }
                if (arrayList.isEmpty()) {
                    System.out.println("Do not Have Intent");
                } else {
                    System.out.println("Have Intent");
                    Intent createChooser = Intent.createChooser((Intent) arrayList.remove(0), "Choose app to share");
                    createChooser.putExtra("android.intent.extra.INITIAL_INTENTS", (Parcelable[]) arrayList.toArray(new Parcelable[0]));
                    activity.startActivity(createChooser);
                }
            }
            return;
        }
        showToast(activity, "Install Facebook First");
    }

    private static void shareMessenger(Activity activity, Uri uri, String str, String str2) {
        ArrayList arrayList = new ArrayList();
        if (appInstalledOrNot(activity, "com.facebook.orca")) {
            PackageManager packageManager = activity.getPackageManager();
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("video/*");
            List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 0);
            for (int i = 0; i < queryIntentActivities.size(); i++) {
                ResolveInfo resolveInfo = queryIntentActivities.get(i);
                String str3 = resolveInfo.activityInfo.packageName;
                Log.i("Package Name", str3);
                if (str3.contains("com.facebook.orca")) {
                    Intent intent2 = new Intent();
                    intent2.setComponent(new ComponentName(str3, resolveInfo.activityInfo.name));
                    intent2.setAction("android.intent.action.SEND");
                    intent2.setType("video/*");
                    intent2.putExtra("android.intent.extra.TEXT", str2);
                    intent2.putExtra("android.intent.extra.SUBJECT", str);
                    intent2.putExtra("android.intent.extra.STREAM", uri);
                    intent2.setPackage(str3);
                    arrayList.add(intent2);
                }
                if (arrayList.isEmpty()) {
                    System.out.println("Do not Have Intent");
                } else {
                    System.out.println("Have Intent");
                    Intent createChooser = Intent.createChooser((Intent) arrayList.remove(0), "Choose app to share");
                    createChooser.putExtra("android.intent.extra.INITIAL_INTENTS", (Parcelable[]) arrayList.toArray(new Parcelable[0]));
                    activity.startActivity(createChooser);
                }
            }
            return;
        }
        showToast(activity, "Install Facebook Messenger First");
    }

    private static void shareHike(Activity activity, Uri uri, String str, String str2) {
        ArrayList arrayList = new ArrayList();
        if (appInstalledOrNot(activity, "com.bsb.hike")) {
            PackageManager packageManager = activity.getPackageManager();
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("video/*");
            List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 0);
            for (int i = 0; i < queryIntentActivities.size(); i++) {
                ResolveInfo resolveInfo = queryIntentActivities.get(i);
                String str3 = resolveInfo.activityInfo.packageName;
                Log.i("Package Name", str3);
                if (str3.contains("com.bsb.hike")) {
                    Intent intent2 = new Intent();
                    intent2.setComponent(new ComponentName(str3, resolveInfo.activityInfo.name));
                    intent2.setAction("android.intent.action.SEND");
                    intent2.setType("video/*");
                    intent2.putExtra("android.intent.extra.TEXT", str2);
                    intent2.putExtra("android.intent.extra.SUBJECT", str);
                    intent2.putExtra("android.intent.extra.STREAM", uri);
                    intent2.setPackage(str3);
                    arrayList.add(intent2);
                }
                if (arrayList.isEmpty()) {
                    System.out.println("Do not Have Intent");
                } else {
                    System.out.println("Have Intent");
                    Intent createChooser = Intent.createChooser((Intent) arrayList.remove(0), "Choose app to share");
                    createChooser.putExtra("android.intent.extra.INITIAL_INTENTS", (Parcelable[]) arrayList.toArray(new Parcelable[0]));
                    activity.startActivity(createChooser);
                }
            }
            return;
        }
        showToast(activity, "Install Hike First");
    }

    public static int getClickableBG(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(new int[]{R.attr.selectableItemBackground});
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        return resourceId;
    }
}
