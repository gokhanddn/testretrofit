package com.gokhandidin.apimodule.repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.gokhandidin.apimodule.models.Joke;
import com.gokhandidin.apimodule.network.ApiClient;
import com.gokhandidin.apimodule.network.ApiService;
import com.gokhandidin.apimodule.responses.DataResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JokeRepository {

    private final ApiService service;

    public JokeRepository() {
        service = ApiClient.getRetrofit().create(ApiService.class);
    }

    public LiveData<List<Joke>> getJokes(int maxId) {
        MutableLiveData<List<Joke>> data = new MutableLiveData<>();

        service.getJokesByMaxId(maxId).enqueue(new Callback<DataResponse<List<Joke>>>() {
            @Override
            public void onResponse(Call<DataResponse<List<Joke>>> call, Response<DataResponse<List<Joke>>> response) {
                if (response != null && response.isSuccessful() && response.body().getCount() > 0) {
                    data.setValue(response.body().getData());
                }
                else {
                    data.setValue(null);
                }
            }

            @Override
            public void onFailure(Call<DataResponse<List<Joke>>> call, Throwable t) {
                data.setValue(null);
            }
        });

        return data;
    }
}
