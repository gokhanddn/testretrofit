package com.gokhandidin.testretrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.Toast;

import com.gokhandidin.testretrofit.viewmodels.JokeViewModel;

public class MainActivity extends AppCompatActivity {

    private JokeViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewModel = new ViewModelProvider(this).get(JokeViewModel.class);

        getJokes(195);
    }

    private void getJokes(int maxId) {
        mViewModel.getJokes(maxId).observe(MainActivity.this, response -> {
            if (response != null) {
                Toast.makeText(this, response.get(0).getTitle(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}