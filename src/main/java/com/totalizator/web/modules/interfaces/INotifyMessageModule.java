package com.totalizator.web.modules.interfaces;

import com.totalizator.web.viewmodels.MessageViewModel;

/**
 * Created by SergeyD on 25.05.2015.
 */
public interface INotifyMessageModule {
	void notifyAddMessage(MessageViewModel messageViewModel);
}
