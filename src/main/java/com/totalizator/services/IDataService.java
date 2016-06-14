package com.totalizator.services;

import com.totalizator.dao.entities.Message;

import java.util.List;

/**
 * Created by kasyanov on 6/14/2016.
 */
public interface IDataService {

	boolean test();

	Message createMessage(Message message);

	Message readMessage(Long id);

	void deleteMessage(Long id);

	List<Message> findAllMessages();
}
