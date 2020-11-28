package com.example.waterCounter.mvp.views;

import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import moxy.viewstate.MvpViewState;
import moxy.viewstate.ViewCommand;
import moxy.viewstate.strategy.AddToEndSingleStrategy;

public class MainView$$State extends MvpViewState<MainView> implements MainView {
	@Override
	public void navigateTo(Class<?> l) {
		NavigateToCommand navigateToCommand = new NavigateToCommand(l);
		this.viewCommands.beforeApply(navigateToCommand);

		if (hasNotView()) {
			return;
		}

		for (MainView view : this.views) {
			view.navigateTo(l);
		}

		this.viewCommands.afterApply(navigateToCommand);
	}

	@Override
	public void showMessage(String message) {
		ShowMessageCommand showMessageCommand = new ShowMessageCommand(message);
		this.viewCommands.beforeApply(showMessageCommand);

		if (hasNotView()) {
			return;
		}

		for (MainView view : this.views) {
			view.showMessage(message);
		}

		this.viewCommands.afterApply(showMessageCommand);
	}

	@Override
	public void navigateTo() {
		NavigateTo1Command navigateTo1Command = new NavigateTo1Command();
		this.viewCommands.beforeApply(navigateTo1Command);

		if (hasNotView()) {
			return;
		}

		for (MainView view : this.views) {
			view.navigateTo();
		}

		this.viewCommands.afterApply(navigateTo1Command);
	}

	public class NavigateToCommand extends ViewCommand<MainView> {
		public final Class<?> l;

		NavigateToCommand(Class<?> l) {
			super("navigateTo", AddToEndSingleStrategy.class);

			this.l = l;
		}

		@Override
		public void apply(MainView mvpView) {
			mvpView.navigateTo(l);
		}
	}

	public class ShowMessageCommand extends ViewCommand<MainView> {
		public final String message;

		ShowMessageCommand(String message) {
			super("showMessage", AddToEndSingleStrategy.class);

			this.message = message;
		}

		@Override
		public void apply(MainView mvpView) {
			mvpView.showMessage(message);
		}
	}

	public class NavigateTo1Command extends ViewCommand<MainView> {
		NavigateTo1Command() {
			super("navigateTo", AddToEndSingleStrategy.class);
		}

		@Override
		public void apply(MainView mvpView) {
			mvpView.navigateTo();
		}
	}
}
