package com.informatica.listadecontacto.retrofit.services;

import com.informatica.listadecontacto.model.RetroPhoto;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.List;

public interface PhotoService {

    @GET("/photos")
    Call<List<RetroPhoto>> getAllPhotos(@Query("_limit") final int limit);

}
