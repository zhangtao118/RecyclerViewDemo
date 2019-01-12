package com.example.recyclerviewdemo.mvp;


public interface BasePresenter {
    //绑定数据
    void subscribe();
    //解除绑定
    void unSubscribe();
}