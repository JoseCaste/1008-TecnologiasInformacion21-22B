package com.informatica.unistmo.instagramapi.activities;

import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.informatica.unistmo.instagramapi.R;
import com.squareup.picasso.Picasso;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class InstagramPostDetailActivity extends AppCompatActivity {

    private ImageView imagePost;
    private TextView tvUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instagram_post_detail);
        final String idImage = (String)getIntent().getExtras().get("id_image");

        imagePost = findViewById(R.id.imagePost);
        tvUser = findViewById(R.id.tvUser);
        StringRequest myRequest = new StringRequest(Request.Method.GET, String.format("https://graph.instagram.com/%s?fields=id,media_type,username,media_url,timestamp&access_token=IGQVJXQnBPejRDaWExTDBJZAzExSklGVzFnM0N3Um1QWjZAMZAG9NRnY0VkJqa2lzdlNzZA2xvQ2V4SzlBU3E4a2FNNTY5V2F5ZA2JYZAE5LdXhLQmdjTUVOQUgzSWI0V2VHc3NfYVpNMVlUdjZAlOWlBUm9PcAZDZD",idImage),
                response -> {
                    try {
                        JSONObject myJsonObject = new JSONObject(response);
                        tvUser.setText((String) myJsonObject.get("username"));
                        Picasso
                                .with(this)
                                .load((String)myJsonObject.get("media_url"))
                                .into(imagePost);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                },
                volleyError -> Toast.makeText(InstagramPostDetailActivity.this, volleyError.getMessage(), Toast.LENGTH_SHORT).show()
        );
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(myRequest);
    }
}