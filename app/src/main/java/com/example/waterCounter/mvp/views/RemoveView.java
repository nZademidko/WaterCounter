package com.example.waterCounter.mvp.views;

import com.example.waterCounter.mvp.BaseView;

import moxy.viewstate.strategy.AddToEndSingleStrategy;
import moxy.viewstate.strategy.StateStrategyType;

public interface RemoveView extends BaseView {


    @StateStrategyType(AddToEndSingleStrategy.class)
    public void navigateTo();
}
