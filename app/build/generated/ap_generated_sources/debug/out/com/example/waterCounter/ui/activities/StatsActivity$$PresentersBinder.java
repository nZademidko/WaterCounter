package com.example.waterCounter.ui.activities;

import com.example.waterCounter.mvp.presenters.StatsPresenter;
import java.lang.Override;
import java.util.ArrayList;
import java.util.List;
import moxy.MvpPresenter;
import moxy.PresenterBinder;
import moxy.presenter.PresenterField;

public class StatsActivity$$PresentersBinder extends PresenterBinder<StatsActivity> {
	@Override
	public List<PresenterField<? super StatsActivity>> getPresenterFields() {
		List<PresenterField<? super StatsActivity>> presenters = new ArrayList<>(1);
		presenters.add(new StatsPresenterBinder());
		return presenters;
	}

	public class StatsPresenterBinder extends PresenterField<StatsActivity> {
		public StatsPresenterBinder() {
			super("statsPresenter", null, StatsPresenter.class);
		}

		@Override
		public void bind(StatsActivity target, MvpPresenter presenter) {
			target.statsPresenter = (StatsPresenter) presenter;
		}

		@Override
		public MvpPresenter<?> providePresenter(StatsActivity delegated) {
			return new StatsPresenter();
		}
	}
}
