package watchvideo.dailytrend.Earnmoney_6.EarnMoney_104;

import watchvideo.dailytrend.Earnmoney_6.EarnMoney_106.EarnMoney_114;
import watchvideo.dailytrend.Earnmoney_6.RealMoney_104.RealMoney_105;
import watchvideo.dailytrend.Earnmoney_6.EarnMoney_105.EarnMoney_113;
import watchvideo.dailytrend.Earnmoney_8.earnmoney_51;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import okhttp3.ResponseBody;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class cashearning1 {
    private static volatile cashearning1 _instance;

    public interface ApiDelegate<T> {
        void OnFailure(String str);

        void OnSuccsess(ArrayList<T> arrayList);
    }

    public static cashearning1 Instance() {
        if (_instance == null) {
            synchronized (cashearning1.class) {
                _instance = new cashearning1();
            }
        }
        return _instance;
    }

    public void getCategories(int i, final ApiDelegate apiDelegate) {
        HashMap hashMap = new HashMap();
        hashMap.put("limit", "5000");
        hashMap.put("token", earnmoney_51.getLansToken());
        hashMap.put("has_content", "yes");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("key", "language_id");
            jSONObject.put("condition", "=");
            JSONArray jSONArray = new JSONArray();
            int i2 = 0;
            if (i == RealMoney_105.LANDSCAPE_VIDEOS) {
                while (i2 < cashearning6.Instance().arrSelectedLandscapeLangId.size()) {
                    if (!cashearning6.Instance().arrSelectedLandscapeLangId.get(i2).equals(RealMoney_105.ALL_LANG_ID)) {
                        jSONArray.put(cashearning6.Instance().arrSelectedLandscapeLangId.get(i2));
                    }
                    i2++;
                }
            } else {
                while (i2 < cashearning6.Instance().arrSelectedLangId.size()) {
                    if (!cashearning6.Instance().arrSelectedLangId.get(i2).equals(RealMoney_105.ALL_LANG_ID)) {
                        jSONArray.put(cashearning6.Instance().arrSelectedLangId.get(i2));
                    }
                    i2++;
                }
            }
            jSONObject.put("value", jSONArray);
            JSONArray jSONArray2 = new JSONArray();
            jSONArray2.put(jSONObject);
            if (jSONArray.length() > 0) {
                hashMap.put("has_content_where", jSONArray2.toString());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        EarnMoney_113.Instance();
        ((EarnMoney_113.CategoryService) EarnMoney_113.getRetro().create(EarnMoney_113.CategoryService.class)).getCategory(hashMap).enqueue(new Callback<ResponseBody>() {

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
                    JSONObject jSONObject = null;
                    try {
                        jSONObject = new JSONObject(str);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    ArrayList arrayList = new ArrayList();
                    JSONArray jSONArray = null;
                    try {
                        jSONArray = jSONObject.getJSONArray("data");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    if (jSONArray == null || jSONArray.length() <= 0) {
                        ApiDelegate apiDelegate = null;
                        if (apiDelegate != null) {
                            apiDelegate.OnFailure(RealMoney_105.NO_DATA_FOUND);
                            return;
                        }
                        return;
                    }
                    for (int i = 0; i < jSONArray.length(); i++) {
                        cashearning5 categories_Model = new cashearning5();
                        JSONObject jSONObject2 = null;
                        try {
                            jSONObject2 = (JSONObject) jSONArray.get(i);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        categories_Model.setId(jSONObject2.optString("id"));
                        categories_Model.setName(jSONObject2.optString("name"));
                        categories_Model.setFeatured(jSONObject2.optString("featured"));
                        categories_Model.setItemType(EarnMoney_114.ITEM);
                        if (i == RealMoney_105.IS_FULLSCREEN_VIDEOS) {
                            if (jSONObject2.has("image") && !jSONObject2.isNull("image")) {
                                categories_Model.setImage(jSONObject2.optJSONObject("image").optString("folder_path") + "300px/" + jSONObject2.optJSONObject("image").optString("name"));
                            }
                        } else if (jSONObject2.has("image_new") && !jSONObject2.isNull("image_new") && jSONObject2.optJSONObject("image_new").has("name")) {
                            String optString = jSONObject2.optJSONObject("image_new").optString("name");
                            String optString2 = jSONObject2.optJSONObject("image_new").optString("folder_path");
                            categories_Model.setImage(optString2 + "300px/" + optString);
                        }
                        arrayList.add(categories_Model);
                    }
                    if (arrayList.size() > 0) {
                        ApiDelegate apiDelegate2 = apiDelegate;
                        if (apiDelegate2 != null) {
                            apiDelegate2.OnSuccsess(arrayList);
                            return;
                        }
                        return;
                    }
                    ApiDelegate apiDelegate3 = apiDelegate;
                    if (apiDelegate3 != null) {
                        apiDelegate3.OnFailure(RealMoney_105.NO_DATA_FOUND);
                        return;
                    }
                    return;
                }
                ApiDelegate apiDelegate4 = apiDelegate;
                if (apiDelegate4 != null) {
                    apiDelegate4.OnFailure(RealMoney_105.NO_DATA_FOUND);
                }
            }
        });
    }
}
