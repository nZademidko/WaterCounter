package com.example.waterCounter.mvp;

import moxy.MvpView;
import moxy.viewstate.strategy.AddToEndSingleStrategy;
import moxy.viewstate.strategy.StateStrategyType;

public interface BaseView extends MvpView {

    @StateStrategyType(AddToEndSingleStrategy.class)
    public void showMessage(String message);

    @StateStrategyType(AddToEndSingleStrategy.class)
    public void navigateTo();
}
