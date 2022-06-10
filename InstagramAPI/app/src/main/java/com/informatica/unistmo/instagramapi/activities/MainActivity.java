package com.informatica.unistmo.instagramapi.activities;

import android.content.Intent;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.informatica.unistmo.instagramapi.R;
import com.informatica.unistmo.instagramapi.apiInterface.ApiService;
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

public class MainActivity extends AppCompatActivity {

    private ApiService apiService;
    private TextView userId;
    private TextView userName;
    private String[] imagesArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadComponents();
        loadResources();
    }

    private void loadComponents() {
        userId = findViewById(R.id.userId);
        userName = findViewById(R.id.userName);
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
        userId.setText(body.getId());
        userName.setText(body.getUsername());
        makeRequest("https://graph.instagram.com/me/media?fields=id,username&access_token=IGQVJXQnBPejRDaWExTDBJZAzExSklGVzFnM0N3Um1QWjZAMZAG9NRnY0VkJqa2lzdlNzZA2xvQ2V4SzlBU3E4a2FNNTY5V2F5ZA2JYZAE5LdXhLQmdjTUVOQUgzSWI0V2VHc3NfYVpNMVlUdjZAlOWlBUm9PcAZDZD");

    }

    private void makeRequest(String myUrl) {
        List<String> imagesList = new ArrayList<>();

        StringRequest myRequest = new StringRequest(Request.Method.GET, myUrl,
                response -> {
                    try {
                        JSONObject myJsonObject = new JSONObject(response);
                        JSONArray jsonArray = myJsonObject.getJSONArray("data");
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject = jsonArray.getJSONObject(i);
                            imagesList.add((String) jsonObject.get("id"));
                        }
                        loadListView(imagesList);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                },
                volleyError -> Toast.makeText(MainActivity.this, volleyError.getMessage(), Toast.LENGTH_SHORT).show()
        );
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(myRequest);
    }

    private void loadListView(final List<String> imagesList) {
        ListView listView = findViewById(R.id.listMultimedia);
        listView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, imagesList.toArray()));
        listView.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(this, InstagramPostDetailActivity.class);
            intent.putExtra("id_image",imagesList.get(position));
            startActivity(intent);
        });
    }
}