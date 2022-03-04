package tucanrase.personal.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getData();
    }

    private void getData() {
        RequestQueue queue = Volley.newRequestQueue(this);
        String url= "https://api.weatherapi.com/v1/current.json?key=13084a48383d4912bce114058220303&q=auto:ip";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                                JSONObject obj = new JSONObject(response);
                                JSONObject location= obj.getJSONObject("current");
                                System.out.println(location.getString("condition"));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        ;
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.v("test", "Error: " + error.getMessage());
                Toast.makeText(MainActivity.this, "There was a problem while trying to connect to the server", Toast.LENGTH_SHORT).show();
            }
        }
        );
        // Add the request to the RequestQueue.
        queue.add(stringRequest);
    }
}