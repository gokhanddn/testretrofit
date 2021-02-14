package com.gokhandidin.apimodule.network;

import com.gokhandidin.apimodule.models.Joke;
import com.gokhandidin.apimodule.responses.DataResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("jokesapp/Jokes/getJokes")
    Call<DataResponse<List<Joke>>> getJokesByMaxId(@Query("maxId") int maxId);
}
