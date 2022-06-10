package com.informatica.unistmo.instagramapi;

import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.informatica.unistmo.instagramapi.apiInterface.ApiService;
import com.informatica.unistmo.instagramapi.retrofitconfig.InstragramBody;
import com.informatica.unistmo.instagramapi.retrofitconfig.RetrofitInstance;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
    }
}