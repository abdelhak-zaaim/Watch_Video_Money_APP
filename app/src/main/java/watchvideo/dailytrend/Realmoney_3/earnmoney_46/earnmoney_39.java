package watchvideo.dailytrend.Realmoney_3.earnmoney_46;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import watchvideo.dailytrend.Realmoney_3.realmoney_35.earnmoney_34.realmoney_26;
import java.util.ArrayList;

public class earnmoney_39 extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "videos";
    public static final String KEY_TAG_ID = "tag_id";
    public static final String KEY_VIDEO_FAV_SIZE = "file_size";
    public static final String KEY_VIDEO_PATH = "video_path";
    public static final String KEY_VIDEO_THUMB_IMAGE = "thumb_image";
    public static final String KEY_VIDEO_TITLE = "video_title";
    public static final String KEY_VIDEO_VIEW_COUNTER = "view_counter";
    public static final String TABLE_FAVORITE_VIDEO = "Favorite_Video";
    public static final String TABLE_FAV_VIDEO = "fav_video";
    private static SQLiteDatabase db;

    public earnmoney_39(Context context) {
        super(context, DATABASE_NAME, (SQLiteDatabase.CursorFactory) null, 1);
        if (db == null) {
            db = getReadableDatabase();
        }
    }

    @Override 
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE fav_video(id INTEGER PRIMARY KEY AUTOINCREMENT , video_id INTEGER , video TEXT , video_title TEXT , thumb_image TEXT , video_path TEXT ,tag_id TEXT )");
        sQLiteDatabase.execSQL("CREATE TABLE Favorite_Video(id INTEGER PRIMARY KEY AUTOINCREMENT , video_id INTEGER , name TEXT , video TEXT , thumb TEXT , file_size INTEGER , view_counter INTEGER , download_counter INTEGER )");
    }

    public void addToFav(realmoney_26 modelVideo) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("video_id", Integer.valueOf(modelVideo.getId()));
        contentValues.put(KEY_VIDEO_TITLE, modelVideo.getName());
        contentValues.put(KEY_VIDEO_THUMB_IMAGE, modelVideo.getThumb());
        contentValues.put(KEY_VIDEO_PATH, modelVideo.getVideo());
        contentValues.put(KEY_TAG_ID, Integer.valueOf(modelVideo.getViewCounter()));
        Log.d("myInsertId", db.insertWithOnConflict(TABLE_FAV_VIDEO, null, contentValues, 4) + "");
    }

    public void Add_To_Fav_Video(realmoney_26 modelVideo) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("video_id", Integer.valueOf(modelVideo.getId()));
        contentValues.put(MimeTypes.BASE_TYPE_VIDEO, modelVideo.getVideo());
        contentValues.put("name", modelVideo.getName());
        contentValues.put("thumb", modelVideo.getThumb());
        contentValues.put(KEY_VIDEO_FAV_SIZE, Integer.valueOf(modelVideo.getFileSize()));
        contentValues.put(KEY_VIDEO_VIEW_COUNTER, Integer.valueOf(modelVideo.getViewCounter()));
        Log.d("myInsertId", db.insertWithOnConflict(TABLE_FAVORITE_VIDEO, null, contentValues, 4) + "");
    }

    public boolean checkIsFav(String str, String str2, String str3) {
        String str4 = "Select * from " + str2 + " where " + str3 + " = " + str;
        Log.d("tag", "query : " + str4);
        Cursor rawQuery = db.rawQuery(str4, null);
        if (rawQuery.getCount() <= 0) {
            rawQuery.close();
            return false;
        }
        rawQuery.close();
        return true;
    }

    public void deleteFav(String str, String str2, String str3) {
        Log.d("tag", "tablename : " + str2 + "dbcolumnname : " + str3 + " id : " + str);
        SQLiteDatabase sQLiteDatabase = db;
        StringBuilder sb = new StringBuilder();
        sb.append(str3);
        sb.append(" = ?");
        sQLiteDatabase.delete(str2, sb.toString(), new String[]{String.valueOf(str)});
    }

    public ArrayList<realmoney_26> getAllFav() {
        ArrayList<realmoney_26> arrayList = new ArrayList<>();
        Cursor rawQuery = db.rawQuery("SELECT  * FROM fav_video ORDER BY id DESC", null);
        if (rawQuery.moveToFirst()) {
            do {
                String string = rawQuery.getString(rawQuery.getColumnIndex("video_id"));
                String string2 = rawQuery.getString(rawQuery.getColumnIndex(KEY_VIDEO_TITLE));
                String string3 = rawQuery.getString(rawQuery.getColumnIndex(KEY_VIDEO_THUMB_IMAGE));
                String string4 = rawQuery.getString(rawQuery.getColumnIndex(KEY_VIDEO_PATH));
                String string5 = rawQuery.getString(rawQuery.getColumnIndex(KEY_TAG_ID));
                if (!string3.equals("")) {
                    realmoney_26 modelVideo = new realmoney_26();
                    modelVideo.setId(Integer.parseInt(String.valueOf(string)));
                    modelVideo.setName(string2);
                    modelVideo.setThumb(string3);
                    modelVideo.setVideo(string4);
                    modelVideo.setViewCounter(Integer.parseInt(String.valueOf(string5)));
                    arrayList.add(modelVideo);
                }
            } while (rawQuery.moveToNext());
        }
        rawQuery.close();
        return arrayList;
    }

    @Override 
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS fav_video");
        onCreate(sQLiteDatabase);
    }
}
