package com.example.waterCounter.mvp.presenters;

import com.example.waterCounter.mvp.views.MainView$$State;
import java.lang.Override;
import moxy.MvpView;
import moxy.ViewStateProvider;
import moxy.viewstate.MvpViewState;

public class MainPresenter$$ViewStateProvider extends ViewStateProvider {
	@Override
	public MvpViewState<? extends MvpView> getViewState() {
		return new MainView$$State();
	}
}
