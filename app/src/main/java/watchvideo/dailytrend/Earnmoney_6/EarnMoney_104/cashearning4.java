package watchvideo.dailytrend.Earnmoney_6.EarnMoney_104;

import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.exoplayer2.metadata.icy.IcyHeaders;
import com.google.android.exoplayer2.util.MimeTypes;
import com.onesignal.shortcutbadger.impl.NewHtcHomeBadger;
import watchvideo.dailytrend.Earnmoney_6.EarnMoney_108.EarnMoney_111;
import watchvideo.dailytrend.Earnmoney_6.RealMoney_104.RealMoney_105;
import watchvideo.dailytrend.Earnmoney_6.RealMoney_104.EarnMoney_103;
import watchvideo.dailytrend.Earnmoney_6.EarnMoney_105.EarnMoney_113;
import watchvideo.dailytrend.Earnmoney_8.earnmoney_51;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Request;
import okhttp3.ResponseBody;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import okio.Timeout;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class cashearning4 {
    private static volatile cashearning4 _instance;

    public interface ApiDelegate<T> {
        void OnFailure(String str);

        void OnSuccsess(ArrayList<T> arrayList, int i);
    }

    public interface ApiDelegateForSingleItem<T> {
        void OnFailure(String str);

        void OnSuccsess(moneyapp_3 moneyapp3);
    }

    public static cashearning4 Instance() {
        if (_instance == null) {
            synchronized (cashearning4.class) {
                _instance = new cashearning4();
            }
        }
        return _instance;
    }

    private void callApiForVideos(Call<ResponseBody> call, Map<String, String> map, final ApiDelegate<moneyapp_3> apiDelegate) {
        call.enqueue(new Callback<ResponseBody>() {

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable th) {
            }

            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                String str = "";
                try {
                    str = response.body().string();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (str != null) {
                    cashearning4.this.parseData(apiDelegate, str);
                    return;
                }
                if (apiDelegate != null) {
                    apiDelegate.OnFailure(RealMoney_105.NO_DATA_FOUND);
                }
            }
        });
    }


    private void parseData(ApiDelegate apiDelegate, String str) {
        JSONObject optJSONObject;
        ArrayList arrayList = new ArrayList();
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.has(NewHtcHomeBadger.COUNT) ? jSONObject.optInt(NewHtcHomeBadger.COUNT) : 0;
            JSONArray jSONArray = jSONObject.getJSONArray("data");
            if (jSONArray != null && jSONArray.length() > 0) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    moneyapp_3 moneyapp3 = new moneyapp_3();
                    JSONObject jSONObject2 = (JSONObject) jSONArray.get(i);
                    moneyapp3.setId(jSONObject2.optString("id"));
                    moneyapp3.setTitle(jSONObject2.optString("title"));
                    moneyapp3.setLikes(jSONObject2.optString("likes"));
                    moneyapp3.setViews(jSONObject2.optString("views"));
                    try {
                        if (jSONObject2.has("languages")) {
                            moneyapp3.setLanguage(jSONObject2.optJSONObject("languages").optString("name"));
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if (jSONObject2.has(MimeTypes.BASE_TYPE_VIDEO) && (optJSONObject = jSONObject2.optJSONObject(MimeTypes.BASE_TYPE_VIDEO)) != null && optJSONObject.has("name") && optJSONObject.has("folder_path")) {
                        String optString = optJSONObject.optString("folder_path");
                        String optString2 = optJSONObject.optString("name");
                        String str2 = optString + optString2;
                        JSONObject optJSONObject2 = jSONObject2.optJSONObject("video_thumb");
                        if (optJSONObject2 != null) {
                            moneyapp3.setThumb(optJSONObject2.optString("folder_path") + "75pc/" + optJSONObject2.optString("name"));
                        }
                        moneyapp3.setItemType(0);
                        moneyapp3.setVideoName(optString2);
                        moneyapp3.setVideoPath(str2);
                        arrayList.add(moneyapp3);
                    }
                }
                if (arrayList.size() > 0) {
                    if (apiDelegate != null) {
                        apiDelegate.OnSuccsess(arrayList, optInt);
                    }
                } else if (apiDelegate != null) {
                    apiDelegate.OnFailure(RealMoney_105.NO_DATA_FOUND);
                }
            } else if (apiDelegate != null) {
                apiDelegate.OnFailure(RealMoney_105.NO_DATA_FOUND);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
            if (apiDelegate != null) {
                apiDelegate.OnFailure(RealMoney_105.PLZ_TRY_AGAIN);
            }
        }
    }

    public void getDataForSearch(final EarnMoney_111 searchDataBaseHandler, int i, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("limit", "5000");
        hashMap.put("token", earnmoney_51.getLansToken());
        hashMap.put("select", "id-title-language_id-created_at");
        if (!TextUtils.isEmpty(str)) {
            Log.e("lastCreatedAt : ", str + "  -- " + i);
            hashMap.put("where", "[{\"key\":\"created_at\", \"condition\":\">\", \"value\":\"" + str + "\"}, {\"key\":\"status\", \"condition\":\"=\", \"value\":\"1\"}]");
        }
        EarnMoney_113.Instance();
        ((EarnMoney_113.VideoService) EarnMoney_113.getRetro().create(EarnMoney_113.VideoService.class)).getVideo(hashMap).enqueue(new Callback<ResponseBody>() {

            @Override 
            public void onFailure(Call<ResponseBody> call, Throwable th) {
            }

            @Override 
            public void onResponse(Call<ResponseBody> call, final Response<ResponseBody> response) {
                try {
                    new AsyncTask<Void, Void, Void>() {
                        /* class com.watchall.trending.Em_Trending.model_l.cashearning4.AnonymousClass2.AnonymousClass1 */

                        
                        public Void doInBackground(Void... voidArr) {
                            try {
                                String string = ((ResponseBody) response.body()).string();
                                if (string == null) {
                                    return null;
                                }
                                JSONArray jSONArray = new JSONObject(string).getJSONArray("data");
                                ArrayList<moneyapp_3> arrayList = new ArrayList<>();
                                for (int i = 0; i < jSONArray.length(); i++) {
                                    JSONObject optJSONObject = jSONArray.optJSONObject(i);
                                    moneyapp_3 moneyapp3 = new moneyapp_3();
                                    moneyapp3.setId(optJSONObject.optString("id"));
                                    moneyapp3.setTitle(optJSONObject.optString("title"));
                                    moneyapp3.setLanguage(optJSONObject.optString("language_id"));
                                    moneyapp3.setCreated_at(optJSONObject.optString("created_at"));
                                    moneyapp3.setVideoIdentifyer(i);
                                    arrayList.add(moneyapp3);
                                }
                                if (arrayList.size() <= 0) {
                                    return null;
                                }
                                searchDataBaseHandler.storeSearchData(arrayList);
                                return null;
                            } catch (IOException e) {
                                e.printStackTrace();
                                return null;
                            } catch (JSONException e2) {
                                e2.printStackTrace();
                                return null;
                            } catch (Exception e3) {
                                e3.printStackTrace();
                                return null;
                            }
                        }
                    }.execute(new Void[0]);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void getVideoList(int i, int i2, int i3, int i4, ApiDelegate<moneyapp_3> apiDelegate) {
        HashMap hashMap = new HashMap();
        hashMap.put("limit", i4 + "");
        hashMap.put("page", i3 + "");
        hashMap.put("with", "languages");
        hashMap.put("token", earnmoney_51.getLansToken());
        if (i2 == 7) {
            hashMap.put("order_by", RealMoney_105.Popular_OrderdBy);
            hashMap.put("day", "7");
        } else if (i2 == 6) {
            EarnMoney_103 Instance = EarnMoney_103.Instance();
            EarnMoney_103.Instance().getClass();
            int intPref = Instance.getIntPref("home_api_calling");
            if (intPref == 2) {
                hashMap.put("order_by", "random");
            } else if (intPref == 0) {
                hashMap.put("order_by", RealMoney_105.Popular_OrderdBy);
            } else {
                hashMap.put("order_by", "created_at");
            }
        } else if (i2 == 8) {
            hashMap.put("filter", "featured");
            hashMap.put("order_by", "updated_at");
            hashMap.put("order_by_type", "desc");
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("key", "language_id");
            jSONObject.put("condition", "=");
            JSONArray jSONArray = new JSONArray();
            int i5 = 0;
            if (i == RealMoney_105.LANDSCAPE_VIDEOS) {
                while (i5 < cashearning6.Instance().arrSelectedLandscapeLangId.size()) {
                    if (!cashearning6.Instance().arrSelectedLandscapeLangId.get(i5).equals(RealMoney_105.ALL_LANG_ID)) {
                        jSONArray.put(cashearning6.Instance().arrSelectedLandscapeLangId.get(i5));
                    }
                    i5++;
                }
            } else {
                while (i5 < cashearning6.Instance().arrSelectedLangId.size()) {
                    if (!cashearning6.Instance().arrSelectedLangId.get(i5).equals(RealMoney_105.ALL_LANG_ID)) {
                        jSONArray.put(cashearning6.Instance().arrSelectedLangId.get(i5));
                    }
                    i5++;
                }
            }
            JSONArray jSONArray2 = new JSONArray();
            if (i2 != 8 && jSONArray.length() > 0) {
                jSONObject.put("value", jSONArray);
                jSONArray2.put(jSONObject);
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("key", "scheduled");
            jSONObject2.put("condition", "=");
            jSONObject2.put("value", "0");
            jSONArray2.put(jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("key", "status");
            jSONObject3.put("condition", "=");
            jSONObject3.put("value", IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE);
            jSONArray2.put(jSONObject3);
            hashMap.put("where", jSONArray2.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        EarnMoney_113.Instance();
        callApiForVideos(((EarnMoney_113.VideoService) EarnMoney_113.getRetro().create(EarnMoney_113.VideoService.class)).getVideo(hashMap), hashMap, apiDelegate);
    }

    public void getVideoListBySearched(int i, int i2, String str, String str2, String str3, int i3, int i4, ApiDelegate<moneyapp_3> apiDelegate) {
        String str4;
        Call<ResponseBody> videoByCategory = new Call<ResponseBody>() {
            @Override
            public Response<ResponseBody> execute() throws IOException {
                return null;
            }

            @Override
            public void enqueue(Callback<ResponseBody> callback) {

            }

            @Override
            public boolean isExecuted() {
                return false;
            }

            @Override
            public void cancel() {

            }

            @Override
            public boolean isCanceled() {
                return false;
            }

            @Override
            public Call<ResponseBody> clone() {
                return null;
            }

            @Override
            public Request request() {
                return null;
            }

            @Override
            public Timeout timeout() {
                return null;
            }
        };
        JSONException e;
        HashMap hashMap = new HashMap();
        if (i2 == 12 || i2 == 13) {
            hashMap.put("order_by", str);
            hashMap.put("order_by_type", str2);
            hashMap.put("with", "languages");
        } else {
            hashMap.put("order_by", str);
        }
        if (i2 != 17) {
            hashMap.put("with_content", "yes");
        }
        hashMap.put("page", i3 + "");
        hashMap.put("limit", i4 + "");
        hashMap.put("token", earnmoney_51.getLansToken());
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("key", "language_id");
            jSONObject.put("condition", "=");
            JSONArray jSONArray = new JSONArray();
            if (i == RealMoney_105.LANDSCAPE_VIDEOS) {
                for (int i5 = 0; i5 < cashearning6.Instance().arrSelectedLandscapeLangId.size(); i5++) {
                    if (!cashearning6.Instance().arrSelectedLandscapeLangId.get(i5).equals(RealMoney_105.ALL_LANG_ID)) {
                        jSONArray.put(cashearning6.Instance().arrSelectedLandscapeLangId.get(i5));
                    }
                }
            } else {
                for (int i6 = 0; i6 < cashearning6.Instance().arrSelectedLangId.size(); i6++) {
                    if (!cashearning6.Instance().arrSelectedLangId.get(i6).equals(RealMoney_105.ALL_LANG_ID)) {
                        jSONArray.put(cashearning6.Instance().arrSelectedLangId.get(i6));
                    }
                }
            }
            jSONObject.put("value", jSONArray);
            JSONArray jSONArray2 = new JSONArray();
            jSONArray2.put(jSONObject);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("key", "scheduled");
            jSONObject2.put("condition", "=");
            jSONObject2.put("value", "0");
            jSONArray2.put(jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("key", "status");
            jSONObject3.put("condition", "=");
            jSONObject3.put("value", IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE);
            jSONArray2.put(jSONObject3);
            if (i == 8 || jSONArray.length() <= 0) {
                str4 = "where";
                try {
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put("key", "language_id");
                    jSONObject4.put("condition", "=");
                    JSONArray jSONArray3 = new JSONArray();
                    if (i == RealMoney_105.LANDSCAPE_VIDEOS) {
                        for (int i7 = 0; i7 < cashearning6.Instance().arrSelectedLandscapeLangId.size(); i7++) {
                            if (!cashearning6.Instance().arrSelectedLandscapeLangId.get(i7).equals(RealMoney_105.ALL_LANG_ID)) {
                                jSONArray3.put(cashearning6.Instance().arrSelectedLandscapeLangId.get(i7));
                            }
                        }
                    } else {
                        for (int i8 = 0; i8 < cashearning6.Instance().arrSelectedLangId.size(); i8++) {
                            if (!cashearning6.Instance().arrSelectedLangId.get(i8).equals(RealMoney_105.ALL_LANG_ID)) {
                                jSONArray3.put(cashearning6.Instance().arrSelectedLangId.get(i8));
                            }
                        }
                    }
                    jSONObject4.put("value", jSONArray3);
                    JSONArray jSONArray4 = new JSONArray();
                    jSONArray4.put(jSONObject4);
                    JSONObject jSONObject5 = new JSONObject();
                    jSONObject5.put("key", "scheduled");
                    jSONObject5.put("condition", "=");
                    jSONObject5.put("value", "0");
                    jSONArray4.put(jSONObject5);
                    JSONObject jSONObject6 = new JSONObject();
                    jSONObject6.put("key", "status");
                    jSONObject6.put("condition", "=");
                    jSONObject6.put("value", IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE);
                    jSONArray4.put(jSONObject6);
                    if (i != 8 && jSONArray3.length() > 0) {
                        hashMap.put(str4, jSONArray4.toString());
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                if (i2 == 10) {
                    EarnMoney_113.Instance();
                    videoByCategory = ((EarnMoney_113.SearchService) EarnMoney_113.getRetro().create(EarnMoney_113.SearchService.class)).getVideosBySearch(str3, hashMap);
                } else if (i2 == 13) {
                    EarnMoney_113.Instance();
                    videoByCategory = ((EarnMoney_113.LangService) EarnMoney_113.getRetro().create(EarnMoney_113.LangService.class)).getVideoByLang(str3, hashMap);
                } else if (i2 == 17) {
                    EarnMoney_113.Instance();
                    videoByCategory = ((EarnMoney_113.SearchService) EarnMoney_113.getRetro().create(EarnMoney_113.SearchService.class)).getVideosByTitle(str3, hashMap);
                } else {
                    EarnMoney_113.Instance();
                    videoByCategory = ((EarnMoney_113.CategoryService) EarnMoney_113.getRetro().create(EarnMoney_113.CategoryService.class)).getVideoByCategory(str3, hashMap);
                }
                callApiForVideos(videoByCategory, hashMap, apiDelegate);
            }
            String jSONArray5 = jSONArray2.toString();
            str4 = "where";
            hashMap.put(str4, jSONArray5);
            JSONObject jSONObject42 = new JSONObject();
            jSONObject42.put("key", "language_id");
            jSONObject42.put("condition", "=");
            JSONArray jSONArray32 = new JSONArray();
            if (i == RealMoney_105.LANDSCAPE_VIDEOS) {
            }
            jSONObject42.put("value", jSONArray32);
            JSONArray jSONArray42 = new JSONArray();
            jSONArray42.put(jSONObject42);
            JSONObject jSONObject52 = new JSONObject();
            jSONObject52.put("key", "scheduled");
            jSONObject52.put("condition", "=");
            jSONObject52.put("value", "0");
            jSONArray42.put(jSONObject52);
            JSONObject jSONObject62 = new JSONObject();
            jSONObject62.put("key", "status");
            jSONObject62.put("condition", "=");
            jSONObject62.put("value", IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE);
            jSONArray42.put(jSONObject62);
            hashMap.put(str4, jSONArray42.toString());
            if (i2 == 10) {
            }
            callApiForVideos(videoByCategory, hashMap, apiDelegate);
        } catch (JSONException e4) {
            e = e4;
            str4 = "where";
            e.printStackTrace();
            JSONObject jSONObject422 = new JSONObject();
            try {
                jSONObject422.put("key", "language_id");
            } catch (JSONException jsonException) {
                jsonException.printStackTrace();
            }
            try {
                jSONObject422.put("condition", "=");
            } catch (JSONException jsonException) {
                jsonException.printStackTrace();
            }
            JSONArray jSONArray322 = new JSONArray();
            if (i == RealMoney_105.LANDSCAPE_VIDEOS) {
            }
            try {
                jSONObject422.put("value", jSONArray322);
            } catch (JSONException jsonException) {
                jsonException.printStackTrace();
            }
            JSONArray jSONArray422 = new JSONArray();
            jSONArray422.put(jSONObject422);
            JSONObject jSONObject522 = new JSONObject();
            try {
                jSONObject522.put("key", "scheduled");
            } catch (JSONException jsonException) {
                jsonException.printStackTrace();
            }
            try {
                jSONObject522.put("condition", "=");
            } catch (JSONException jsonException) {
                jsonException.printStackTrace();
            }
            try {
                jSONObject522.put("value", "0");
            } catch (JSONException jsonException) {
                jsonException.printStackTrace();
            }
            jSONArray422.put(jSONObject522);
            JSONObject jSONObject622 = new JSONObject();
            try {
                jSONObject622.put("key", "status");
            } catch (JSONException jsonException) {
                jsonException.printStackTrace();
            }
            try {
                jSONObject622.put("condition", "=");
            } catch (JSONException jsonException) {
                jsonException.printStackTrace();
            }
            try {
                jSONObject622.put("value", IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE);
            } catch (JSONException jsonException) {
                jsonException.printStackTrace();
            }
            jSONArray422.put(jSONObject622);
            hashMap.put(str4, jSONArray422.toString());
            if (i2 == 10) {
            }
            callApiForVideos(videoByCategory, hashMap, apiDelegate);
        }
    }
}