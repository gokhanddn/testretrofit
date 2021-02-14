package com.gokhandidin.apimodule.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Joke implements Serializable {

    @SerializedName("id")
    private int jokeId;

    private String title;

    private String content;

    private int categoryId;

    public int getJokeId() {
        return jokeId;
    }

    public void setJokeId(int jokeId) {
        this.jokeId = jokeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
}
