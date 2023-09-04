package watchvideo.dailytrend.Earnmoney_6.EarnMoney_105;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.tonyodev.fetch2.Download;
import com.tonyodev.fetch2.Status;
import com.tonyodev.fetch2core.Func;
import watchvideo.dailytrend.realmoney_24;
import watchvideo.dailytrend.Earnmoney_6.RealMoney_104.RealMoney_107;

import java.io.File;
import java.util.List;

public class EarnMoney_112 extends Service {
    private static final int GROUP_ID = -1246295935;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int i, int i2) {
        return super.onStartCommand(intent, i, i2);
    }

    @Override
    public void onTaskRemoved(Intent intent) {
        if (!realmoney_24.getInstance().fetch.isClosed()) {
            realmoney_24.getInstance().fetch.getDownloadsInGroup(realmoney_24.GROUP_ID, new Func<List<Download>>() {
                public void call(List<Download> list) {
                    int i = 0;
                    while (i < list.size()) {
                        try {
                            if (list.get(i).getStatus() != Status.COMPLETED) {
                                int id = list.get(i).getId();
                                String file = list.get(i).getFile();
                                realmoney_24.getInstance().fetch.pause(id);
                                realmoney_24.getInstance().fetch.cancel(id);
                                realmoney_24.getInstance().fetch.delete(id);
                                realmoney_24.getInstance().fetch.remove(id);
                                File file2 = new File(file);
                                if (file2.exists()) {
                                    file2.delete();
                                }
                                RealMoney_107.scanFile(EarnMoney_112.this, file2);
                            }
                            i++;
                        } catch (Exception e) {
                            e.printStackTrace();
                        } catch (Throwable unused) {
                            realmoney_24.getInstance().fetch.close();
                            EarnMoney_112.this.stopSelf();
                        }
                    }
                    realmoney_24.getInstance().fetch.close();
                    EarnMoney_112.this.stopSelf();
                }
            });
        }
        super.onTaskRemoved(intent);
    }

}
