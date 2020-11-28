package com.example.waterCounter.mvp.presenters;

import com.example.waterCounter.mvp.views.RemoveView$$State;
import java.lang.Override;
import moxy.MvpView;
import moxy.ViewStateProvider;
import moxy.viewstate.MvpViewState;

public class RemovePresenter$$ViewStateProvider extends ViewStateProvider {
	@Override
	public MvpViewState<? extends MvpView> getViewState() {
		return new RemoveView$$State();
	}
}
