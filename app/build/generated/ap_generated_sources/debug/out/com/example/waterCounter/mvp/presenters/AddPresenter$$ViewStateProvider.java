package com.example.waterCounter.mvp.presenters;

import com.example.waterCounter.mvp.views.AddView$$State;
import java.lang.Override;
import moxy.MvpView;
import moxy.ViewStateProvider;
import moxy.viewstate.MvpViewState;

public class AddPresenter$$ViewStateProvider extends ViewStateProvider {
	@Override
	public MvpViewState<? extends MvpView> getViewState() {
		return new AddView$$State();
	}
}
