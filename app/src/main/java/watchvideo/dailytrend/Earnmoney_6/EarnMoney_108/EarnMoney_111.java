package watchvideo.dailytrend.Earnmoney_6.EarnMoney_108;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.os.AsyncTask;
import android.util.Log;
import watchvideo.dailytrend.Earnmoney_6.RealMoney_104.RealMoney_105;
import watchvideo.dailytrend.Earnmoney_6.EarnMoney_104.cashearning6;
import watchvideo.dailytrend.Earnmoney_6.EarnMoney_104.moneyapp_3;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

@SuppressLint("Range")

public class EarnMoney_111 extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "StatusJoyDB";
    private static final int DATABASE_VERSION = 3;
    private static final String DB_PATH_SUFFIX = "/databases/";
    private static final String TABLE_SEARCH_VIDEOS = "search_table";
    private static final String VID_CREATED_AT = "vid_created_at";
    private static final String VID_ID = "vid_id";
    private static final String VID_IDENTIFYER = "vid_identifyer";
    private static final String VID_LANG_ID = "vid_lang_id";
    private static final String VID_TITLE = "vid_title";
    private Context ctx;

    @Override 
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
    }

    @Override 
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    public EarnMoney_111(Context context) {
        super(context, DATABASE_NAME, (SQLiteDatabase.CursorFactory) null, 3);
        this.ctx = context;
    }

    private String getDatabasePath() {
        return this.ctx.getApplicationInfo().dataDir + DB_PATH_SUFFIX + DATABASE_NAME;
    }

    public void CopyDataBaseFromAsset() throws IOException {
        InputStream open = this.ctx.getAssets().open(DATABASE_NAME);
        String databasePath = getDatabasePath();
        File file = new File(this.ctx.getApplicationInfo().dataDir + DB_PATH_SUFFIX);
        if (!file.exists()) {
            file.mkdir();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(databasePath);
        byte[] bArr = new byte[1024];
        while (true) {
            int read = open.read(bArr);
            if (read > 0) {
                fileOutputStream.write(bArr, 0, read);
            } else {
                fileOutputStream.flush();
                fileOutputStream.close();
                open.close();
                return;
            }
        }
    }

    public boolean checkIfAnyRecordsExist() {
        if (!isDatabaseCopied()) {
            return false;
        }
        Cursor rawQuery = getReadableDatabase().rawQuery("Select * from search_table", null);
        if (rawQuery.getCount() <= 0) {
            rawQuery.close();
            return false;
        }
        rawQuery.close();
        return true;
    }

    public void copyDb() {
        new AsyncTask<Void, Void, Exception>() {
            /* class com.watchall.trending.Em_Trending.Database_handler.SearchDataBaseHandler.AnonymousClass1 */

            
            public Exception doInBackground(Void... voidArr) {
                try {
                    EarnMoney_111.this.openDataBase();
                    return null;
                } catch (Exception e) {
                    e.printStackTrace();
                    return e;
                }
            }

            
            public void onPostExecute(Exception exc) {
                super.onPostExecute(exc);
            }
        }.execute(new Void[0]);
    }

    public boolean deleteDatabase() {
        return this.ctx.deleteDatabase(DATABASE_NAME);
    }

    public String getCreatedAt(int i) {
        String str = "";
        if (!isDatabaseCopied()) {
            return str;
        }
        SQLiteDatabase readableDatabase = getReadableDatabase();
        Cursor rawQuery = readableDatabase.rawQuery("select * from search_table where vid_identifyer = " + i + " order by `" + VID_CREATED_AT + "` desc limit 1", null);
        if (rawQuery.getCount() > 0) {
            rawQuery.moveToFirst();
            str = rawQuery.getString(rawQuery.getColumnIndex(VID_CREATED_AT));
        }
        if (rawQuery != null) {
            rawQuery.close();
        }
        return str;
    }

    public boolean hasObject(moneyapp_3 moneyapp3) {
        boolean z;
        SQLiteDatabase writableDatabase = getWritableDatabase();
        Cursor rawQuery = writableDatabase.rawQuery("SELECT * FROM search_table WHERE vid_id = " + moneyapp3.getId() + " AND " + VID_IDENTIFYER + " = " + moneyapp3.getVideoIdentifyer(), null);
        if (rawQuery.moveToFirst()) {
            z = true;
            do {
            } while (rawQuery.moveToNext());
        } else {
            z = false;
        }
        rawQuery.close();
        writableDatabase.close();
        return z;
    }

    public boolean isDatabaseCopied() {
        return this.ctx.getDatabasePath(DATABASE_NAME).exists();
    }

    public SQLiteDatabase openDataBase() {
        File databasePath = this.ctx.getDatabasePath(DATABASE_NAME);
        if (!databasePath.exists()) {
            try {
                CopyDataBaseFromAsset();
                System.out.println("Copying sucess from Assets folder");
            } catch (Throwable th) {
                throw new RuntimeException("Error creating source database", th);
            }
        }
        return SQLiteDatabase.openDatabase(databasePath.getPath(), null, 268435472);
    }

    public ArrayList<moneyapp_3> searchInDb(String str, int i) {
        ArrayList<moneyapp_3> arrayList = new ArrayList<>();
        if (!isDatabaseCopied()) {
            return arrayList;
        }
        SQLiteDatabase readableDatabase = getReadableDatabase();
        try {
            Cursor rawQuery = readableDatabase.rawQuery("SELECT  * FROM search_table WHERE vid_title LIKE '%" + str + "%' AND " + VID_IDENTIFYER + " = " + i + " GROUP BY " + VID_TITLE + " ORDER BY " + VID_ID + " DESC LIMIT 20", null);
            ArrayList arrayList2 = new ArrayList();
            if (i == RealMoney_105.IS_FULLSCREEN_VIDEOS) {
                arrayList2.addAll(cashearning6.Instance().arrSelectedLangId);
            } else {
                arrayList2.addAll(cashearning6.Instance().arrSelectedLandscapeLangId);
            }
            if (rawQuery.moveToFirst()) {
                do {
                    moneyapp_3 moneyapp3 = new moneyapp_3();
                    moneyapp3.setId(rawQuery.getString(rawQuery.getColumnIndex(VID_ID)));
                    moneyapp3.setTitle(rawQuery.getString(rawQuery.getColumnIndex(VID_TITLE)));
                    moneyapp3.setLanguage(rawQuery.getString(rawQuery.getColumnIndex(VID_LANG_ID)));
                    moneyapp3.setCreated_at(rawQuery.getString(rawQuery.getColumnIndex(VID_CREATED_AT)));
                    for (int i2 = 0; i2 < arrayList2.size(); i2++) {
                        Log.d("TestData", "Store Language : " + ((String) arrayList2.get(i2)));
                    }
                    if (arrayList2.size() > 0) {
                        Log.d("TestData", "languages : " + moneyapp3.getLanguage());
                        if (arrayList2.contains(moneyapp3.getLanguage())) {
                            arrayList.add(moneyapp3);
                        }
                    } else {
                        arrayList.add(moneyapp3);
                    }
                } while (rawQuery.moveToNext());
            }
            rawQuery.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public void storeSearchData(ArrayList<moneyapp_3> arrayList) {
        if (isDatabaseCopied()) {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            writableDatabase.enableWriteAheadLogging();
            writableDatabase.beginTransaction();
            SQLiteStatement compileStatement = writableDatabase.compileStatement("INSERT INTO search_table (vid_id,vid_title,vid_lang_id,vid_identifyer,vid_created_at) VALUES(?,?,?,?,?)");
            for (int i = 0; i < arrayList.size(); i++) {
                moneyapp_3 moneyapp3 = arrayList.get(i);
                if (!hasObject(moneyapp3)) {
                    compileStatement.bindLong(1, Long.parseLong(moneyapp3.getId()));
                    compileStatement.bindString(2, moneyapp3.getTitle());
                    compileStatement.bindLong(3, Long.parseLong(moneyapp3.getLanguage()));
                    compileStatement.bindLong(4, 0);
                    compileStatement.bindString(5, moneyapp3.getCreated_at());
                    compileStatement.execute();
                    compileStatement.clearBindings();
                }
            }
            writableDatabase.setTransactionSuccessful();
            writableDatabase.endTransaction();
            writableDatabase.close();
        }
    }
}
