package com.example.myapplication.game;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class GameViewModel extends ViewModel {
    public MutableLiveData<Integer> highScore = new MutableLiveData<>(0);
}
