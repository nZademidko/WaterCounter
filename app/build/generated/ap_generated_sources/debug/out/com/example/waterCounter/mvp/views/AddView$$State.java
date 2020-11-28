package com.example.waterCounter.mvp.views;

import java.lang.Override;
import java.lang.String;
import moxy.viewstate.MvpViewState;
import moxy.viewstate.ViewCommand;
import moxy.viewstate.strategy.AddToEndSingleStrategy;

public class AddView$$State extends MvpViewState<AddView> implements AddView {
	@Override
	public void navigateTo() {
		NavigateToCommand navigateToCommand = new NavigateToCommand();
		this.viewCommands.beforeApply(navigateToCommand);

		if (hasNotView()) {
			return;
		}

		for (AddView view : this.views) {
			view.navigateTo();
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

		for (AddView view : this.views) {
			view.showMessage(message);
		}

		this.viewCommands.afterApply(showMessageCommand);
	}

	public class NavigateToCommand extends ViewCommand<AddView> {
		NavigateToCommand() {
			super("navigateTo", AddToEndSingleStrategy.class);
		}

		@Override
		public void apply(AddView mvpView) {
			mvpView.navigateTo();
		}
	}

	public class ShowMessageCommand extends ViewCommand<AddView> {
		public final String message;

		ShowMessageCommand(String message) {
			super("showMessage", AddToEndSingleStrategy.class);

			this.message = message;
		}

		@Override
		public void apply(AddView mvpView) {
			mvpView.showMessage(message);
		}
	}
}
