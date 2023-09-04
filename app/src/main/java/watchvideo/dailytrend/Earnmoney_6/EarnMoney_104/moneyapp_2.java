package watchvideo.dailytrend.Earnmoney_6.EarnMoney_104;

import android.content.Context;
import com.google.android.gms.common.internal.ImagesContract;
import watchvideo.dailytrend.Earnmoney_6.RealMoney_104.RealMoney_105;
import watchvideo.dailytrend.Earnmoney_6.RealMoney_104.RealMoney_109;
import watchvideo.dailytrend.Earnmoney_6.EarnMoney_105.EarnMoney_113;
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

public class moneyapp_2 {
    private static volatile moneyapp_2 _instance;

    public interface ApiDelegate {
        void OnFailure(String str);

        void OnSuccsess(moneyapp_3 moneyapp3, moneyapp_3 moneyapp32);
    }

    public static moneyapp_2 Instance() {
        if (_instance == null) {
            synchronized (moneyapp_2.class) {
                _instance = new moneyapp_2();
            }
        }
        return _instance;
    }

    public void getUpdates(final Context context, final ApiDelegate apiDelegate) {
        EarnMoney_113.Instance();
        ((EarnMoney_113.CommanApiService) EarnMoney_113.getRetro().create(EarnMoney_113.CommanApiService.class)).getUpdateValue(new HashMap()).enqueue(new Callback<ResponseBody>() {

            @Override 
            public void onFailure(Call<ResponseBody> call, Throwable th) {
            }

            @Override 
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                String str;
                String str2;
                String str3;
                String str4;
                Exception e;
                JSONArray optJSONArray;
                String str5;
                String str6;
                String str7;
                String str8;
                String str9;
                int i;
                String str10;
                moneyapp_3 moneyapp3;
                JSONArray jSONArray;
                String str11;
                String str12;
                String str13;
                String str14;
                String str15;
                String str16;
                String str17;
                String str18;
                int i2;
                String str19;
                moneyapp_3 moneyapp32;
                String str20;

                String str21;
                String str22;
                String str23;
                String str24;
                String str25;
                String str26;
                String str27;
                String str28 = "list";
                String str29 = "new_img_banner";
                String str30 = "lang_id";
                String str31 = "cat_id";
                String str32 = "video_id";
                String str33 = "visibility";
                String str34 = "data";
                moneyapp_3 moneyapp33 = new moneyapp_3(-11);
                moneyapp_3 moneyapp34 = new moneyapp_3(-11);
                new ArrayList();
                String str35 = "";
                try {
                    str35 = response.body().string();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                if (str35 != null) {
                    JSONObject jSONObject = null;
                    try {
                        jSONObject = new JSONObject(str35);
                    } catch (JSONException jsonException) {
                        jsonException.printStackTrace();
                    }
                    if (jSONObject.has(str34)) {
                        try {
                            JSONArray optJSONArray2 = jSONObject.optJSONObject(str34).optJSONArray("tag_search");
                            moneyapp_3 moneyapp35 = moneyapp34;
                            String str36 = "tag_name";
                            String str37 = "mail";
                            String str38 = "tag";
                            if (optJSONArray2 == null || optJSONArray2.length() <= 0) {
                                JSONObject optJSONObject = jSONObject.optJSONObject(str34).optJSONObject("promo_banner");
                                if (!optJSONObject.optBoolean(str33) || (optJSONArray = optJSONObject.optJSONArray(str28)) == null || optJSONArray.length() <= 0) {
                                    str = "promo_banner";
                                    str4 = str29;
                                    str3 = str33;
                                } else {
                                    moneyapp_1 promoBannerModel = new moneyapp_1();
                                    str = "promo_banner";
                                    String str39 = ImagesContract.URL;
                                    int i3 = 0;
                                    while (true) {
                                        str5 = str30;
                                        try {
                                            str6 = str36;
                                            str7 = str38;
                                            str8 = str31;
                                            str9 = str32;
                                            if (i3 >= optJSONArray.length()) {
                                                i = Integer.parseInt(null);
                                                str10 = str29;
                                                break;
                                            }
                                            try {
                                                JSONObject optJSONObject2 = optJSONArray.optJSONObject(i3);
                                                if (!optJSONObject2.has("package") || optJSONObject2.optString("package") == null) {
                                                    moneyapp32 = moneyapp35;
                                                    i2 = i3;
                                                    str26 = str29;
                                                    str27 = str37;
                                                    str24 = str39;
                                                    str22 = str5;
                                                    str19 = str6;
                                                    str21 = str7;
                                                    str20 = str8;
                                                    str32 = str9;
                                                    str23 = str28;
                                                    str25 = str33;
                                                } else {
                                                    i2 = i3;
                                                    str10 = str29;
                                                    try {
                                                        if (!optJSONObject2.optString("package").equals("null")) {
                                                            try {
                                                                if (!RealMoney_109.Instance().appInstalledOrNot(context, optJSONObject2.optString("package"))) {
                                                                    promoBannerModel.rightColor = optJSONObject2.optString("right");
                                                                    promoBannerModel.leftColor = optJSONObject2.optString("left");
                                                                    promoBannerModel.icon = optJSONObject2.optString("icon");
                                                                    promoBannerModel.pakage = optJSONObject2.optString("package");
                                                                    promoBannerModel.title = optJSONObject2.optString("title");
                                                                    promoBannerModel.desc = optJSONObject2.optString("desc");
                                                                    promoBannerModel.link = optJSONObject2.optString("link");
                                                                    moneyapp33.setPromoBannerModel(promoBannerModel);
                                                                    i = 1;
                                                                    break;
                                                                }
                                                                moneyapp32 = moneyapp35;
                                                            } catch (Exception e3) {
                                                                e = e3;
                                                                str3 = str33;
                                                                str4 = str10;
                                                                str2 = str34;
                                                                try {
                                                                    e.printStackTrace();
                                                                    jSONObject.optJSONObject(str2).optJSONObject(str).optBoolean(str3);
                                                                    jSONObject.optJSONObject(str2).optJSONObject(str4).optBoolean(str3);
                                                                    return;
                                                                } catch (Exception e4) {
                                                                    e4.printStackTrace();
                                                                    return;
                                                                }
                                                            }
                                                        } else {
                                                            moneyapp32 = moneyapp35;
                                                        }
                                                        str27 = str37;
                                                        str24 = str39;
                                                        str22 = str5;
                                                        str19 = str6;
                                                        str21 = str7;
                                                        str20 = str8;
                                                        str32 = str9;
                                                        str23 = str28;
                                                        str25 = str33;
                                                        str26 = str10;
                                                    } catch (Exception e5) {
                                                        e = e5;
                                                        str3 = str33;
                                                        str4 = str10;
                                                        str2 = str34;
                                                        e.printStackTrace();
                                                        jSONObject.optJSONObject(str2).optJSONObject(str).optBoolean(str3);
                                                        jSONObject.optJSONObject(str2).optJSONObject(str4).optBoolean(str3);
                                                        return;
                                                    }
                                                }
                                                moneyapp35 = moneyapp32;
                                                str36 = str19;
                                                str37 = str27;
                                                str31 = str20;
                                                str33 = str25;
                                                i3 = i2 + 1;
                                                str39 = str24;
                                                str29 = str26;
                                                str28 = str23;
                                                str38 = str21;
                                                str30 = str22;
                                            } catch (Exception e6) {
                                                e = e6;
                                                str4 = str29;
                                                str3 = str33;
                                                str2 = str34;
                                                e.printStackTrace();
                                                jSONObject.optJSONObject(str2).optJSONObject(str).optBoolean(str3);
                                                jSONObject.optJSONObject(str2).optJSONObject(str4).optBoolean(str3);
                                                return;
                                            }
                                        } catch (Exception e7) {
                                            e = e7;
                                            str4 = str29;
                                            str3 = str33;
                                            str2 = str34;
                                            e.printStackTrace();
                                            jSONObject.optJSONObject(str2).optJSONObject(str).optBoolean(str3);
                                            jSONObject.optJSONObject(str2).optJSONObject(str4).optBoolean(str3);
                                            return;
                                        }
                                    }
                                    int i4 = 3;
                                    moneyapp33.setItemType(3);
                                    str4 = str10;
                                    try {
                                        JSONObject optJSONObject3 = jSONObject.optJSONObject(str34).optJSONObject(str4);
                                        str3 = str33;
                                        try {
                                            if (optJSONObject3.optBoolean(str3)) {
                                                ArrayList<moneyapp_4> arrayList = new ArrayList<>();
                                                JSONArray optJSONArray3 = optJSONObject3.optJSONArray(str28);
                                                int i5 = 2;
                                                if (optJSONArray3 != null) {
                                                    while (optJSONArray3.length() > 0) {
                                                        JSONObject optJSONObject4 = optJSONArray3.optJSONObject(0);
                                                        if (optJSONObject4.optBoolean(str3)) {
                                                            moneyapp_4 modelNewImageBanner = new moneyapp_4();
                                                            str15 = str9;
                                                            if (!optJSONObject4.has(str15) || optJSONObject4.isNull(str15)) {
                                                                str14 = str8;
                                                                if (!optJSONObject4.has(str14) || optJSONObject4.isNull(str14)) {
                                                                    str12 = str7;
                                                                    if (!optJSONObject4.has(str12)) {
                                                                        str18 = str6;
                                                                        str16 = str5;
                                                                        if (optJSONObject4.has(str16)) {
                                                                        }
                                                                        str17 = str39;
                                                                        if (optJSONObject4.has(str17)) {
                                                                        }
                                                                        jSONArray = optJSONArray3;
                                                                        str13 = str37;
                                                                        if (optJSONObject4.has(str13)) {
                                                                        }
                                                                        str11 = str18;
                                                                        modelNewImageBanner.img = optJSONObject4.optString("img");
                                                                        Integer.valueOf(1);
                                                                        modelNewImageBanner.img = optJSONObject4.optString("img");
                                                                    } else if (optJSONObject4.isNull(str12)) {
                                                                        str16 = str5;
                                                                        str18 = str6;
                                                                        try {
                                                                            if (optJSONObject4.has(str16)) {
                                                                                if (!optJSONObject4.isNull(str16)) {
                                                                                    modelNewImageBanner.id = optJSONObject4.optString(str16);
                                                                                    modelNewImageBanner.title = optJSONObject4.optString("lang_name");
                                                                                    modelNewImageBanner.Identifier = 5;
                                                                                    modelNewImageBanner.img = optJSONObject4.optString("img");
                                                                                    str13 = str37;
                                                                                    str17 = str39;
                                                                                }
                                                                            }
                                                                            str17 = str39;
                                                                            if (optJSONObject4.has(str17)) {
                                                                                if (!optJSONObject4.isNull(str17)) {
                                                                                    modelNewImageBanner.id = optJSONObject4.optString(str17);
                                                                                    modelNewImageBanner.Identifier = 6;
                                                                                    jSONArray = optJSONArray3;
                                                                                    modelNewImageBanner.img = optJSONObject4.optString("img");
                                                                                    str13 = str37;
                                                                                    str11 = str18;
                                                                                    Integer.valueOf(1);
                                                                                    modelNewImageBanner.img = optJSONObject4.optString("img");
                                                                                }
                                                                            }
                                                                            jSONArray = optJSONArray3;
                                                                            str13 = str37;
                                                                            if (optJSONObject4.has(str13)) {
                                                                                if (!optJSONObject4.isNull(str13)) {
                                                                                    modelNewImageBanner.id = optJSONObject4.optString(str13);
                                                                                    modelNewImageBanner.Identifier = 7;
                                                                                    str11 = str18;
                                                                                    modelNewImageBanner.img = optJSONObject4.optString("img");
                                                                                    Integer.valueOf(1);
                                                                                    modelNewImageBanner.img = optJSONObject4.optString("img");
                                                                                }
                                                                            }
                                                                            str11 = str18;
                                                                            modelNewImageBanner.img = optJSONObject4.optString("img");
                                                                            Integer.valueOf(1);
                                                                            modelNewImageBanner.img = optJSONObject4.optString("img");
                                                                        } catch (Exception e9) {
                                                                            e = e9;
                                                                            str2 = str16;
                                                                            e.printStackTrace();
                                                                            jSONObject.optJSONObject(str2).optJSONObject(str).optBoolean(str3);
                                                                            jSONObject.optJSONObject(str2).optJSONObject(str4).optBoolean(str3);
                                                                            return;
                                                                        }
                                                                    } else {
                                                                        modelNewImageBanner.id = optJSONObject4.optString(str12);
                                                                        str18 = str6;
                                                                        modelNewImageBanner.title = optJSONObject4.optString(str18);
                                                                        modelNewImageBanner.Identifier = 4;
                                                                        str13 = str37;
                                                                        str17 = str39;
                                                                        str16 = str5;
                                                                    }
                                                                    jSONArray = optJSONArray3;
                                                                    str11 = str18;
                                                                    Integer.valueOf(1);
                                                                    modelNewImageBanner.img = optJSONObject4.optString("img");
                                                                } else {
                                                                    modelNewImageBanner.id = optJSONObject4.optString(str14);
                                                                    modelNewImageBanner.title = optJSONObject4.optString("cat_name");
                                                                    modelNewImageBanner.Identifier = i4;
                                                                    str13 = str37;
                                                                    str17 = str39;
                                                                    str16 = str5;
                                                                    str11 = str6;
                                                                    str12 = str7;
                                                                }
                                                            } else {
                                                                modelNewImageBanner.id = optJSONObject4.optString(str15);
                                                                modelNewImageBanner.Identifier = i5;
                                                                str13 = str37;
                                                                str17 = str39;
                                                                str16 = str5;
                                                                str11 = str6;
                                                                str12 = str7;
                                                                str14 = str8;
                                                            }
                                                            jSONArray = optJSONArray3;
                                                            Integer.valueOf(1);
                                                            modelNewImageBanner.img = optJSONObject4.optString("img");
                                                        } else {
                                                            str13 = str37;
                                                            str17 = str39;
                                                            str16 = str5;
                                                            str11 = str6;
                                                            str12 = str7;
                                                            str14 = str8;
                                                            str15 = str9;
                                                            jSONArray = optJSONArray3;
                                                        }
                                                        str5 = str16;
                                                        str9 = str15;
                                                        str8 = str14;
                                                        str7 = str12;
                                                        str6 = str11;
                                                        optJSONArray3 = jSONArray;
                                                        i4 = 3;
                                                        str39 = str17;
                                                        str37 = str13;
                                                        i5 = 2;
                                                        str34 = str5;
                                                    }
                                                }
                                                str2 = str34;
                                                try {
                                                    if (apiDelegate != null) {
                                                        if (arrayList.size() > 0) {
                                                            moneyapp3 = moneyapp35;
                                                            moneyapp3.setArrModelNewImageBanner(arrayList);
                                                            moneyapp3.setItemType(2);
                                                        } else {
                                                            moneyapp3 = moneyapp35;
                                                        }
                                                        apiDelegate.OnSuccsess(moneyapp33, moneyapp3);
                                                        return;
                                                    }
                                                    return;
                                                } catch (Exception e10) {
                                                    e = e10;
                                                    e.printStackTrace();
                                                    jSONObject.optJSONObject(str2).optJSONObject(str).optBoolean(str3);
                                                    jSONObject.optJSONObject(str2).optJSONObject(str4).optBoolean(str3);
                                                    return;
                                                }
                                            }
                                        } catch (Exception e11) {
                                            e = e11;
                                            str2 = str34;
                                            e.printStackTrace();
                                            jSONObject.optJSONObject(str2).optJSONObject(str).optBoolean(str3);
                                            jSONObject.optJSONObject(str2).optJSONObject(str4).optBoolean(str3);
                                            return;
                                        }
                                    } catch (Exception e12) {
                                        e = e12;
                                        str3 = str33;
                                        str2 = str34;
                                        e.printStackTrace();
                                        jSONObject.optJSONObject(str2).optJSONObject(str).optBoolean(str3);
                                        jSONObject.optJSONObject(str2).optJSONObject(str4).optBoolean(str3);
                                        return;
                                    }
                                }
                                try {
                                    jSONObject.optJSONObject(str34).optJSONObject(str4).optBoolean(str3);
                                    return;
                                } catch (Exception e13) {
                                    e = e13;
                                }
                            } else {
                                RealMoney_105.arrFullScreenTags.clear();
                                RealMoney_105.arrFullScreenNames.clear();
                                RealMoney_105.arrLandscapeTags.clear();
                                RealMoney_105.arrLandscapeNames.clear();
                                int i6 = 0;
                                while (i6 < optJSONArray2.length()) {
                                    try {
                                        JSONObject optJSONObject5 = optJSONArray2.optJSONObject(i6);
                                        if (optJSONObject5.has(str38)) {
                                            try {
                                                RealMoney_105.arrFullScreenTags.add(optJSONObject5.optString(str38));
                                                RealMoney_105.arrLandscapeTags.add(optJSONObject5.optString(str38));
                                            } catch (Exception e14) {
                                                try {
                                                    e14.printStackTrace();
                                                    jSONObject.optJSONObject(str34).optJSONObject("promo_banner").optBoolean(str33);
                                                    jSONObject.optJSONObject(str34).optJSONObject(str29).optBoolean(str33);
                                                } catch (Exception e15) {
                                                    e15.printStackTrace();
                                                }
                                            }
                                        }
                                        if (optJSONObject5.has(str36)) {
                                            RealMoney_105.arrFullScreenNames.add(optJSONObject5.optString(str36));
                                            RealMoney_105.arrLandscapeNames.add(optJSONObject5.optString(str36));
                                        }
                                        i6++;
                                    } catch (Exception e16) {
                                        e16.printStackTrace();
                                        jSONObject.optJSONObject(str34).optJSONObject("promo_banner").optBoolean(str33);
                                        jSONObject.optJSONObject(str34).optJSONObject(str29).optBoolean(str33);
                                    }
                                }
                                jSONObject.optJSONObject(str34).optJSONObject("promo_banner").optBoolean(str33);
                                jSONObject.optJSONObject(str34).optJSONObject(str29).optBoolean(str33);
                            }
                        } catch (Exception e17) {
                            e = e17;
                            str = "promo_banner";
                            str4 = str29;
                            str3 = str33;
                            str2 = str34;
                            e.printStackTrace();
                            jSONObject.optJSONObject(str2).optJSONObject(str).optBoolean(str3);
                            jSONObject.optJSONObject(str2).optJSONObject(str4).optBoolean(str3);
                            return;
                        }
                    }
                    return;
                }
                if (apiDelegate != null) {
                    apiDelegate.OnFailure(RealMoney_105.NO_DATA_FOUND);
                }
            }
        });
    }
}
