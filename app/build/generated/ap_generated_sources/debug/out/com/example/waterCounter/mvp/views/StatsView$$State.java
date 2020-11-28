package com.example.waterCounter.mvp.views;

import java.lang.Override;
import java.lang.String;
import moxy.viewstate.MvpViewState;
import moxy.viewstate.ViewCommand;
import moxy.viewstate.strategy.AddToEndSingleStrategy;

public class StatsView$$State extends MvpViewState<StatsView> implements StatsView {
	@Override
	public void showMessage(String message) {
		ShowMessageCommand showMessageCommand = new ShowMessageCommand(message);
		this.viewCommands.beforeApply(showMessageCommand);

		if (hasNotView()) {
			return;
		}

		for (StatsView view : this.views) {
			view.showMessage(message);
		}

		this.viewCommands.afterApply(showMessageCommand);
	}

	@Override
	public void navigateTo() {
		NavigateToCommand navigateToCommand = new NavigateToCommand();
		this.viewCommands.beforeApply(navigateToCommand);

		if (hasNotView()) {
			return;
		}

		for (StatsView view : this.views) {
			view.navigateTo();
		}

		this.viewCommands.afterApply(navigateToCommand);
	}

	public class ShowMessageCommand extends ViewCommand<StatsView> {
		public final String message;

		ShowMessageCommand(String message) {
			super("showMessage", AddToEndSingleStrategy.class);

			this.message = message;
		}

		@Override
		public void apply(StatsView mvpView) {
			mvpView.showMessage(message);
		}
	}

	public class NavigateToCommand extends ViewCommand<StatsView> {
		NavigateToCommand() {
			super("navigateTo", AddToEndSingleStrategy.class);
		}

		@Override
		public void apply(StatsView mvpView) {
			mvpView.navigateTo();
		}
	}
}
