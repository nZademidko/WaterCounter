package com.example.waterCounter.ui.activities;

import com.example.waterCounter.mvp.presenters.MainPresenter;
import java.lang.Override;
import java.util.ArrayList;
import java.util.List;
import moxy.MvpPresenter;
import moxy.PresenterBinder;
import moxy.presenter.PresenterField;

public class MainActivity$$PresentersBinder extends PresenterBinder<MainActivity> {
	@Override
	public List<PresenterField<? super MainActivity>> getPresenterFields() {
		List<PresenterField<? super MainActivity>> presenters = new ArrayList<>(1);
		presenters.add(new MainPresenterBinder());
		return presenters;
	}

	public class MainPresenterBinder extends PresenterField<MainActivity> {
		public MainPresenterBinder() {
			super("mainPresenter", null, MainPresenter.class);
		}

		@Override
		public void bind(MainActivity target, MvpPresenter presenter) {
			target.mainPresenter = (MainPresenter) presenter;
		}

		@Override
		public MvpPresenter<?> providePresenter(MainActivity delegated) {
			return new MainPresenter();
		}
	}
}
