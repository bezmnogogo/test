package com.totalizator.services;

import com.totalizator.dao.entities.Message;

import java.util.List;

public interface IDataService {

	boolean test();

	Message createMessage(Message message);

	Message readMessage(Long id);

	void deleteMessage(Long id);

	List<Message> findAllMessages();
}
