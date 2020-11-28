package com.example.waterCounter.ui.activities;

import com.example.waterCounter.mvp.presenters.RemovePresenter;
import java.lang.Override;
import java.util.ArrayList;
import java.util.List;
import moxy.MvpPresenter;
import moxy.PresenterBinder;
import moxy.presenter.PresenterField;

public class RemoveActivity$$PresentersBinder extends PresenterBinder<RemoveActivity> {
	@Override
	public List<PresenterField<? super RemoveActivity>> getPresenterFields() {
		List<PresenterField<? super RemoveActivity>> presenters = new ArrayList<>(1);
		presenters.add(new RemovePresenterBinder());
		return presenters;
	}

	public class RemovePresenterBinder extends PresenterField<RemoveActivity> {
		public RemovePresenterBinder() {
			super("removePresenter", null, RemovePresenter.class);
		}

		@Override
		public void bind(RemoveActivity target, MvpPresenter presenter) {
			target.removePresenter = (RemovePresenter) presenter;
		}

		@Override
		public MvpPresenter<?> providePresenter(RemoveActivity delegated) {
			return new RemovePresenter();
		}
	}
}
