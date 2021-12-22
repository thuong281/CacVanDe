package com.example.myapplication.utils;

public interface OnCompleted<T> {
  void onFinish(T object);
  void onError(String error);
}
