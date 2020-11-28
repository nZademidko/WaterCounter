package com.example.waterCounter.ui.activities;

import com.example.waterCounter.mvp.presenters.AddPresenter;
import java.lang.Override;
import java.util.ArrayList;
import java.util.List;
import moxy.MvpPresenter;
import moxy.PresenterBinder;
import moxy.presenter.PresenterField;

public class AddActivity$$PresentersBinder extends PresenterBinder<AddActivity> {
	@Override
	public List<PresenterField<? super AddActivity>> getPresenterFields() {
		List<PresenterField<? super AddActivity>> presenters = new ArrayList<>(1);
		presenters.add(new AddPresenterBinder());
		return presenters;
	}

	public class AddPresenterBinder extends PresenterField<AddActivity> {
		public AddPresenterBinder() {
			super("addPresenter", null, AddPresenter.class);
		}

		@Override
		public void bind(AddActivity target, MvpPresenter presenter) {
			target.addPresenter = (AddPresenter) presenter;
		}

		@Override
		public MvpPresenter<?> providePresenter(AddActivity delegated) {
			return new AddPresenter();
		}
	}
}
