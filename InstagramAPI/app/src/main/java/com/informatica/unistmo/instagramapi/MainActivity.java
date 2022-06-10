package com.informatica.unistmo.instagramapi;

import android.os.Build;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.JsonArray;
import com.informatica.unistmo.instagramapi.adapter.ResourceAdapter;
import com.informatica.unistmo.instagramapi.apiInterface.ApiService;
import com.informatica.unistmo.instagramapi.retrofitconfig.ComposeResource;
import com.informatica.unistmo.instagramapi.retrofitconfig.InstagramResource;
import com.informatica.unistmo.instagramapi.retrofitconfig.InstragramBody;
import com.informatica.unistmo.instagramapi.retrofitconfig.RetrofitInstance;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {

    private ApiService apiService;
    private TextView userId;
    private TextView userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadComponents();
        loadResources();
    }

    private void loadComponents() {

    }

    private void loadResources() {
        apiService = RetrofitInstance.getClient("https://graph.instagram.com/").create(ApiService.class);
        apiService.getMe("id,username","IGQVJXQnBPejRDaWExTDBJZAzExSklGVzFnM0N3Um1QWjZAMZAG9NRnY0VkJqa2lzdlNzZA2xvQ2V4SzlBU3E4a2FNNTY5V2F5ZA2JYZAE5LdXhLQmdjTUVOQUgzSWI0V2VHc3NfYVpNMVlUdjZAlOWlBUm9PcAZDZD")
                .enqueue(new Callback<InstragramBody>() {
                    @Override
                    public void onResponse(Call<InstragramBody> call, Response<InstragramBody> response) {
                        setValues(response.body());
                    }

                    @Override
                    public void onFailure(Call<InstragramBody> call, Throwable t) {
                        t.printStackTrace();
                    }
                });
    }
    private void setValues(InstragramBody body) {
        makeRequest("https://graph.instagram.com/me/media?fields=id,username&access_token=IGQVJXQnBPejRDaWExTDBJZAzExSklGVzFnM0N3Um1QWjZAMZAG9NRnY0VkJqa2lzdlNzZA2xvQ2V4SzlBU3E4a2FNNTY5V2F5ZA2JYZAE5LdXhLQmdjTUVOQUgzSWI0V2VHc3NfYVpNMVlUdjZAlOWlBUm9PcAZDZD");

    }

    private void makeRequest(String myUrl) {
        List<InstagramResource> imagesList= new ArrayList<>();

        StringRequest myRequest = new StringRequest(Request.Method.GET, myUrl,
                response -> {
                    try{
                        //Create a JSON object containing information from the API.
                        JSONObject myJsonObject = new JSONObject(response);
                        JSONArray jsonArray = myJsonObject.getJSONArray("data");
                        for (int i = 0; i< jsonArray.length();i++){
                            JSONObject jsonObject= jsonArray.getJSONObject(i);
                            loadImage((String)jsonObject.get("id"),imagesList);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }finally {
                        loadRecyclerView(imagesList);
                    }
                },
                volleyError -> Toast.makeText(MainActivity.this, volleyError.getMessage(), Toast.LENGTH_SHORT).show()
        );
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(myRequest);
    }

    private void loadImage(String id, List<InstagramResource> imagesList) {
        final String url =String.format("https://graph.instagram.com/%s?fields=id,media_type,media_url,username,timestamp&access_token=IGQVJXQnBPejRDaWExTDBJZAzExSklGVzFnM0N3Um1QWjZAMZAG9NRnY0VkJqa2lzdlNzZA2xvQ2V4SzlBU3E4a2FNNTY5V2F5ZA2JYZAE5LdXhLQmdjTUVOQUgzSWI0V2VHc3NfYVpNMVlUdjZAlOWlBUm9PcAZDZD",id);
        StringRequest myRequest = new StringRequest(Request.Method.GET, url,
                response -> {
                    try{
                        //Create a JSON object containing information from the API.
                        JSONObject myJsonObject = new JSONObject(response);
                        imagesList.add(new InstagramResource((String) myJsonObject.get("media_url"),(String) myJsonObject.get("username"),(String) myJsonObject.get("timestamp")));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                },
                volleyError -> Toast.makeText(MainActivity.this, volleyError.getMessage(), Toast.LENGTH_SHORT).show()
        );
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(myRequest);
    }

    private void loadRecyclerView(List<InstagramResource> imagesList) {
        ListView listView = findViewById(R.id.listMultimedia);
        String[] imagesArray = new String[imagesList.size()];
        for (int i =0 ;i<imagesList.size();i++){
            imagesArray[i] = imagesList.get(i).getMedia_url();
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, imagesArray);

        listView.setAdapter(adapter);
    }
}