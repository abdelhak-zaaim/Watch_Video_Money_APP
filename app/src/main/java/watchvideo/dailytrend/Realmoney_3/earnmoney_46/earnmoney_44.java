package watchvideo.dailytrend.Realmoney_3.earnmoney_46;

import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.TypedArray;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import watchvideo.dailytrend.R;
import watchvideo.dailytrend.Realmoney_3.realmoney_35.earnmoney_34.realmoney_26;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class earnmoney_44 extends AppCompatActivity {
    public static final String EXTRA_ACTION = "action";
    public static final String EXTRA_MODEL_DP = "model_dp";
    public static final String EXTRA_MODEL_JOKES = "model_jokes";
    public static final String EXTRA_MODEL_VIDEO = "model_video";
    public static final String INTENT_FILTER_DOWNLOAD_COMPLETE_VIDEO = "com.hk.allstatus2018.video.complete";
    public static Calendar fromSelectedDate;
    private static earnmoney_44 instance;
    protected static earnmoney_36 earnmoney36;
    public static Calendar toSelectedDate;
    ProgressDialog dialog;

    private BroadcastReceiver receiverDownloadCompleteVideo = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d("myReceiver", "myreceivercalled");
            earnmoney_45.shareVideo(earnmoney_44.this, intent.getIntExtra(earnmoney_44.EXTRA_ACTION, 0), (realmoney_26) intent.getSerializableExtra(earnmoney_44.EXTRA_MODEL_VIDEO));
        }
    };

    public static earnmoney_44 getInstance() {
        return instance;
    }

    public static String currentDate() {
        return new SimpleDateFormat("dd-MM-yyyy").format(new Date());
    }

    public boolean isInternetOn() {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public void showNetworkAlert() {
        try {
            new AlertDialog.Builder(this).setMessage(R.string.check_internet).setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    earnmoney_44.this.finish();
                    dialogInterface.dismiss();
                }
            }).show();
        } catch (Exception e) {
            Log.d("BadTokenException:::", "" + e.getMessage());
        }
    }

    public void showExitDialog() {
        try {
            new AlertDialog.Builder(this).setMessage(R.string.check_internet).setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    earnmoney_44.this.finish();
                    dialogInterface.dismiss();
                }
            }).show();
        } catch (Exception e) {
            Log.d("BadTokenException:::", "" + e.getMessage());
        }
    }

    public void hideKeyboard(View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        if (view == null) {
            inputMethodManager.hideSoftInputFromWindow(getWindow().getCurrentFocus().getWindowToken(), 0);
        } else {
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public void showProgressDialog(int i) {
        try {
            if (this.dialog == null) {
                ProgressDialog progressDialog = new ProgressDialog(this);
                this.dialog = progressDialog;
                progressDialog.setCancelable(false);
                this.dialog.setCanceledOnTouchOutside(false);
            }
            if (!this.dialog.isShowing()) {
                this.dialog.setMessage(getString(i));
                this.dialog.show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void dismissProgressDialog() {
        try {
            ProgressDialog progressDialog = this.dialog;
            if (progressDialog != null && progressDialog.isShowing()) {
                this.dialog.dismiss();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override 
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        fromSelectedDate = Calendar.getInstance();
        toSelectedDate = Calendar.getInstance();
        instance = this;
        if (earnmoney36 == null) {
            earnmoney36 = new earnmoney_36(getApplicationContext());
        }
        if (earnmoney36.getVersionDate().equals("")) {
            earnmoney36.setVersionDate(currentDate());
        }
    }

    public void showToast(String str) {
        Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
    }

    public int getClickableBG() {
        TypedArray obtainStyledAttributes = obtainStyledAttributes(new int[]{R.attr.selectableItemBackground});
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        return resourceId;
    }

    public int getColorWrapper(int i) {
        return ContextCompat.getColor(getApplicationContext(), i);
    }

    @Override 
    public void onResume() {
        super.onResume();
        registerReceiver(this.receiverDownloadCompleteVideo, new IntentFilter(INTENT_FILTER_DOWNLOAD_COMPLETE_VIDEO));
    }

    @Override 
    public void onPause() {
        super.onPause();
        unregisterReceiver(this.receiverDownloadCompleteVideo);
    }


}
