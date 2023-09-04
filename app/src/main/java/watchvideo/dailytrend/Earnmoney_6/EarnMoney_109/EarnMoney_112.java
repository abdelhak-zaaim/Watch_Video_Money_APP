package watchvideo.dailytrend.Earnmoney_6.EarnMoney_109;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import java.util.ArrayList;

public class EarnMoney_112 extends Fragment {
    private int MY_PERMISSIONS_REQUEST = 101;
    private int REQUEST_PERMISSION_SETTING = 102;
    private PermissonDelegate permissonDelegate;

    public interface PermissonDelegate {
        void onAllow();
    }

    @Override 
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == this.REQUEST_PERMISSION_SETTING) {
            a(this.permissonDelegate);
        }
    }

    @Override 
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override 
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override 
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == this.MY_PERMISSIONS_REQUEST && strArr != null) {
            try {
                if (strArr.length > 0) {
                    String str = strArr[0];
                    if (iArr.length > 0) {
                        if (iArr[0] == 0) {
                            if (Build.VERSION.SDK_INT >= 23) {
                                this.permissonDelegate.onAllow();
                                return;
                            }
                            return;
                        }
                    }
                    if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(), str)) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                        builder.setTitle("Storage Permission");
                        builder.setMessage("Storage permission is mandatory, Please Allow Storage Permission.");

                        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                EarnMoney_112 baseFrag = EarnMoney_112.this;
                                baseFrag.a(baseFrag.permissonDelegate);
                            }
                        });

                        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        });
                        builder.show();
                        return;
                    }
                    AlertDialog.Builder builder2 = new AlertDialog.Builder(getActivity());
                    builder2.setTitle("Storage Permission");
                    builder2.setMessage("Storage permission is mandatory, Open setting and allow permission.");
                    builder2.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                            intent.setData(Uri.fromParts("package", EarnMoney_112.this.getActivity().getPackageName(), null));
                            EarnMoney_112 baseFrag = EarnMoney_112.this;
                            baseFrag.startActivityForResult(intent, baseFrag.REQUEST_PERMISSION_SETTING);
                        }
                    });

                    builder2.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                        }
                    });
                    builder2.show();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void a(PermissonDelegate permissonDelegate2) {
        this.permissonDelegate = permissonDelegate2;
        int checkSelfPermission = ContextCompat.checkSelfPermission(getActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
        ArrayList arrayList = new ArrayList();
        if (checkSelfPermission != 0) {
            arrayList.add("android.permission.WRITE_EXTERNAL_STORAGE");
        }
        if (arrayList.isEmpty()) {
            permissonDelegate2.onAllow();
        } else {
            requestPermissions((String[]) arrayList.toArray(new String[arrayList.size()]), this.MY_PERMISSIONS_REQUEST);
        }
    }

}
