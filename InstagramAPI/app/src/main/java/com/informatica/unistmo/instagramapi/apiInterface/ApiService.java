package com.informatica.unistmo.instagramapi.apiInterface;

import com.informatica.unistmo.instagramapi.retrofitconfig.ComposeResource;
import com.informatica.unistmo.instagramapi.retrofitconfig.InstagramResource;
import com.informatica.unistmo.instagramapi.retrofitconfig.InstragramBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import java.util.List;

public interface ApiService {
    @GET("/me")
    Call<InstragramBody> getMe(
            @Query("fields") String fields,
            @Query("access_token") String acessToken
    );

    @GET("/me/media")
    Call<List<ComposeResource>> getComposeResources(@Query("fields") String fields,
                                                    @Query("access_token") String acessToken);

    @GET("/{id_resource}")
    Call<InstagramResource> getResource(@Path("id_resource") String idResource,@Query("fields") String fields,
                                        @Query("access_token") String acessToken);
}
