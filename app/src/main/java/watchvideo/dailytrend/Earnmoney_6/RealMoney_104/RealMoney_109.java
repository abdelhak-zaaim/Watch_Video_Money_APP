package watchvideo.dailytrend.Earnmoney_6.RealMoney_104;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;
import androidx.core.content.res.ResourcesCompat;
import com.google.android.exoplayer2.util.MimeTypes;
import watchvideo.dailytrend.Earnmoney_6.EarnMoney_104.moneyapp_3;
import watchvideo.dailytrend.R;
import java.io.File;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@SuppressLint("WrongConstant")

public class RealMoney_109 {
    private static volatile RealMoney_109 _instance;
    private Toast toast;

    public static boolean isLocalStorageDocument(Uri uri) {
        return false;
    }

    public static void HideView(View view) {
        if (view != null && view.getVisibility() == 0) {
            view.setVisibility(8);
        }
    }

    public static RealMoney_109 Instance() {
        if (_instance == null) {
            synchronized (RealMoney_109.class) {
                _instance = new RealMoney_109();
            }
        }
        return _instance;
    }

    public static void InvisibleView(View view) {
        if (view != null) {
            view.setVisibility(4);
        }
    }

    public static void LogDebug(String str) {
        Log.d(RealMoney_105.TAG, str);
    }

    public static void LogError(String str) {
        Log.e(RealMoney_105.TAG, str);
    }

    public static void LogException(Exception exc) {
        Log.d(RealMoney_105.TAG, exc.getMessage() + "\n" + exc);
    }

    public static void LogInfo(String str) {
        Log.e(RealMoney_105.TAG, str);
    }

    public static void LogVerbose(String str) {
        Log.v(RealMoney_105.TAG, str);
    }

    public static void ShowView(View view) {
        if (view != null) {
            view.setVisibility(0);
        }
    }

    private static String capitalize(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        char charAt = str.charAt(0);
        if (Character.isUpperCase(charAt)) {
            return str;
        }
        return Character.toUpperCase(charAt) + str.substring(1);
    }

    public static int dpToPx(int i) {
        return (int) (((float) i) * Resources.getSystem().getDisplayMetrics().density);
    }

    public static void fadeInAndShowView(final View view, long j) {
        if (view.getVisibility() == 8 || view.getVisibility() == 4) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setInterpolator(new AccelerateInterpolator());
            alphaAnimation.setDuration(j);
            alphaAnimation.setAnimationListener(new Animation.AnimationListener() {

                @Override
                public void onAnimationRepeat(Animation animation) {
                }

                @Override
                public void onAnimationStart(Animation animation) {
                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    view.setVisibility(0);
                }
            });
            view.startAnimation(alphaAnimation);
        }
    }

    public static void fadeOutAndHideView(final View view, long j) {
        if (view.getVisibility() == 0) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setInterpolator(new AccelerateInterpolator());
            alphaAnimation.setDuration(j);
            alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationRepeat(Animation animation) {
                }

                @Override
                public void onAnimationStart(Animation animation) {
                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    view.setVisibility(8);
                }
            });
            view.startAnimation(alphaAnimation);
        }
    }

    public static String getDataColumn(Context context, Uri uri, String str, String[] strArr) throws Throwable {
        Cursor query = context.getContentResolver().query(uri, new String[]{"_data"}, str, strArr, null);
        if (query != null) {
            if (query.moveToFirst()) {
                String string = query.getString(query.getColumnIndexOrThrow("_data"));
                if (query != null) {
                    query.close();
                }
                return string;
            }
        }
        if (query == null) {
            return null;
        }
        query.close();
        return null;
    }

    public static String getDeviceName() {
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        if (str2.toLowerCase().startsWith(str.toLowerCase())) {
            return capitalize(str2);
        }
        return capitalize(str) + " " + str2;
    }

    public static String getPath(Context context, Uri uri) throws Throwable {
        Uri uri2 = null;
        if (Build.VERSION.SDK_INT < 19 || !DocumentsContract.isDocumentUri(context, uri)) {
            if (!"content".equalsIgnoreCase(uri.getScheme())) {
                if ("file".equalsIgnoreCase(uri.getScheme())) {
                    return uri.getPath();
                }
            } else if (isGooglePhotosUri(uri)) {
                return uri.getLastPathSegment();
            } else {
                return getDataColumn(context, uri, null, null);
            }
        } else if (isLocalStorageDocument(uri)) {
            return DocumentsContract.getDocumentId(uri);
        } else {
            if (isExternalStorageDocument(uri)) {
                String[] split = DocumentsContract.getDocumentId(uri).split(":");
                if ("primary".equalsIgnoreCase(split[0])) {
                    return Environment.getExternalStorageDirectory() + "/" + split[1];
                }
            } else if (isDownloadsDocument(uri)) {
                return getDataColumn(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(DocumentsContract.getDocumentId(uri)).longValue()), null, null);
            } else {
                if (isMediaDocument(uri)) {
                    String[] split2 = DocumentsContract.getDocumentId(uri).split(":");
                    String str = split2[0];
                    if ("image".equals(str)) {
                        uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                    } else if (MimeTypes.BASE_TYPE_VIDEO.equals(str)) {
                        uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                    } else if (MimeTypes.BASE_TYPE_AUDIO.equals(str)) {
                        uri2 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                    }
                    return getDataColumn(context, uri2, "_id=?", new String[]{split2[1]});
                }
            }
        }
        return null;
    }

    public static int getScreenHeight() {
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }

    public static int getScreenWidth() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    public static void hideKeyboard(View view, Context context) {
        if (view != null) {
            ((InputMethodManager) context.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public static boolean isDownloadsDocument(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    public static boolean isExternalStorageDocument(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    public static boolean isGooglePhotosUri(Uri uri) {
        return "com.google.android.apps.photos.content".equals(uri.getAuthority());
    }

    public static boolean isMediaDocument(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    public static boolean isNetworkAvailable(Activity activity) {
        if (activity == null || activity.isFinishing()) {
            return false;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) activity.getSystemService("connectivity");
            if (connectivityManager.getActiveNetworkInfo() == null || !connectivityManager.getActiveNetworkInfo().isConnected()) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static int pxToDp(int i) {
        return (int) (((float) i) / Resources.getSystem().getDisplayMetrics().density);
    }

    public float DpToPx(float f, Context context) {
        return f * (((float) context.getResources().getDisplayMetrics().densityDpi) / 160.0f);
    }

    public void ErrorLog(String str, String str2) {
        Log.e(str, str2);
    }

    public boolean appInstalledOrNot(Context context, String str) {
        PackageManager packageManager;
        if (context == null || str == null || str.length() <= 0 || (packageManager = context.getPackageManager()) == null) {
            return false;
        }
        try {
            packageManager.getPackageInfo(str, 1);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public Date convertStringToDate(String str, String str2) {
        try {
            return new SimpleDateFormat(str2).parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String coolFormatViews(long j) {
        String valueOf = String.valueOf(j);
        if (valueOf.length() != 6) {
            return String.format("%s", NumberFormat.getNumberInstance(Locale.getDefault()).format(j));
        }
        String substring = valueOf.substring(0, 1);
        String format = String.format("%s", NumberFormat.getNumberInstance(Locale.getDefault()).format(j));
        return substring + "," + format.substring(1, format.length());
    }

    public Drawable getDrawableImage(Context context, int i) {
        return ResourcesCompat.getDrawable(context.getResources(), i, null);
    }

    public int getStatusBarHeight(Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return resources.getDimensionPixelSize(identifier);
        }
        return (int) Math.ceil((double) (((float) (Build.VERSION.SDK_INT >= 23 ? 24 : 25)) * resources.getDisplayMetrics().density));
    }

    public void setMargins(Context context, View view, int i, int i2, int i3, int i4) {
        if (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            float f = context.getResources().getDisplayMetrics().density;
            ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).setMargins((int) ((((float) i) * f) + 0.5f), (int) ((((float) i2) * f) + 0.5f), (int) ((((float) i3) * f) + 0.5f), (int) ((((float) i4) * f) + 0.5f));
            view.requestLayout();
        }
    }

    public void shareVideo(Context context, int i, moneyapp_3 moneyapp3, int i2, int i3) {
        File file;
        File file2;
        if (i2 == 9) {
            file = new File(moneyapp3.getVideoPath());
        } else {
            String videoName = moneyapp3.getVideoName();
            String title = moneyapp3.getTitle();
            if (videoName.contains(".mp4")) {
                videoName = videoName.replace(".mp4", "");
            }
            String str = videoName + "_VIDEO_" + title + ".mp4";
            if (i == RealMoney_105.LANDSCAPE_VIDEOS) {
                file2 = new File(Environment.getExternalStorageDirectory() + "/" + context.getResources().getString(R.string.dir_name) + "/" + context.getResources().getString(R.string.landscape) + "/");
            } else {
                file2 = new File(Environment.getExternalStorageDirectory() + "/" + context.getResources().getString(R.string.dir_name) + "/");
            }
            if (!file2.exists()) {
                file2.mkdirs();
            }
            file = new File(file2 + "/" + str);
        }
        Intent intent = new Intent("android.intent.action.SEND");
        Uri fromFile = Uri.fromFile(file);
        intent.setType("video/*");
        intent.putExtra("android.intent.extra.STREAM", fromFile);
        intent.putExtra("android.intent.extra.SUBJECT", context.getString(R.string.app_name));
        intent.putExtra("android.intent.extra.TEXT", "Download -StatusJoy- for latest fullscreen video status.\nhttp://bit.ly/2RoXvae");
        if (i3 == 0) {
            intent.setPackage("com.whatsapp");
        } else if (i3 == 1) {
            intent.setPackage("com.instagram.android");
        } else if (i3 == 2) {
            intent.setPackage("com.facebook.katana");
        }
        context.startActivity(Intent.createChooser(intent, "Share video using"));
    }

    public void showToast(Context context, String str) {
        try {
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                if (activity.isFinishing()) {
                    return;
                }
                if (Build.VERSION.SDK_INT >= 17 && activity.isDestroyed()) {
                    return;
                }
            }
            if (context != null) {
                Toast toast2 = this.toast;
                if (toast2 != null) {
                    toast2.cancel();
                }
                Toast makeText = Toast.makeText(context, str, 0);
                this.toast = makeText;
                makeText.show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
