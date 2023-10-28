package com.example.studentapp;

public class DataQuiz {
    String name;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    String result;

    public DataQuiz(String name , String result) {
        this.name = name;
        this.result = result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
