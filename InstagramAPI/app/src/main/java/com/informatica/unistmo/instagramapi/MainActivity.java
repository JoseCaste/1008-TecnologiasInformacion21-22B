package com.informatica.unistmo.instagramapi;

import android.os.Build;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.RecyclerView;
import com.informatica.unistmo.instagramapi.apiInterface.ApiService;
import com.informatica.unistmo.instagramapi.retrofitconfig.ComposeResource;
import com.informatica.unistmo.instagramapi.retrofitconfig.InstagramResource;
import com.informatica.unistmo.instagramapi.retrofitconfig.InstragramBody;
import com.informatica.unistmo.instagramapi.retrofitconfig.RetrofitInstance;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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

        ApiService apiService = RetrofitInstance.getClient("https://graph.instagram.com/").create(ApiService.class);
        apiService.getComposeResources("id,username",AccessToken.ACCESS_TOKEN.getToken()).enqueue(new Callback<List<ComposeResource>>() {
            @Override
            public void onResponse(Call<List<ComposeResource>> call, Response<List<ComposeResource>> response) {
                System.out.println(response);
            }

            @Override
            public void onFailure(Call<List<ComposeResource>> call, Throwable t) {

            }
        });
    }
}