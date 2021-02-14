package com.gokhandidin.testretrofit.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.gokhandidin.apimodule.models.Joke;
import com.gokhandidin.apimodule.repositories.JokeRepository;

import java.util.List;

public class JokeViewModel extends AndroidViewModel {

    private final JokeRepository repository;

    public JokeViewModel(@NonNull Application application) {
        super(application);

        repository = new JokeRepository();
    }

    public LiveData<List<Joke>> getJokes(int maxId) {
        return repository.getJokes(maxId);
    }
}
