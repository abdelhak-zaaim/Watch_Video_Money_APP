package watchvideo.dailytrend.Earnmoney_4;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessaging;
import watchvideo.dailytrend.realmoney_24;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class earnmoney_58 extends BroadcastReceiver {
    Context con;
    String token;

    @Override
    public void onReceive(Context context, Intent intent) {
        this.con = context;
        setdata();
    }

    public void setdata() {
        FirebaseMessaging.getInstance().subscribeToTopic("news");
        this.token = FirebaseInstanceId.getInstance().getToken();
        Log.d("tokenval", "" + this.token);
        try {
            RequestQueue newRequestQueue = Volley.newRequestQueue(this.con);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("Title", "Android Volley Demo");
            jSONObject.put("Author", "BNK");
            final String str = "{ \"data\": {\n    \"image\": \"\",\n    \"message\": \"" + realmoney_24.fire_base_evening_message + "\"\n    \"AnotherActivity\": \"True\"\n  },\n  \"to\" :\"" + this.token + "\"\n}";
            newRequestQueue.add(new StringRequest(1, "https://fcm.googleapis.com/fcm/send", new Response.Listener<String>() {

                public void onResponse(String str) {
                    Log.i("VOLLEY", str);
                }
            }, new Response.ErrorListener() {

                @Override 
                public void onErrorResponse(VolleyError volleyError) {
                    Log.e("VOLLEY", volleyError.toString());
                }
            }) {

                @Override 
                public byte[] getBody() throws AuthFailureError {
                    return null;
                }

                @Override 
                public String getBodyContentType() {
                    return "application/json; charset=utf-8";
                }

                @Override 
                public Map<String, String> getHeaders() throws AuthFailureError {
                    HashMap hashMap = new HashMap();
                    hashMap.put("Content-Type", "application/json");
                    hashMap.put("Authorization", "key=" + realmoney_24.firebase_key.trim());
                    return hashMap;
                }

                @Override 
                public Response<String> parseNetworkResponse(NetworkResponse networkResponse) {
                    return Response.success(networkResponse != null ? String.valueOf(networkResponse.statusCode) : "", HttpHeaderParser.parseCacheHeaders(networkResponse));
                }
            });
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
