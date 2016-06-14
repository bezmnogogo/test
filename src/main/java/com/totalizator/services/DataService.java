package com.totalizator.services;

import com.totalizator.dao.entities.Message;
import com.totalizator.dao.repository.IMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by kasyanov on 6/14/2016.
 */

@Service
@Transactional
public class DataService implements IDataService {

	private final IMessageRepository messageRepository;

	@Autowired
	public DataService(IMessageRepository messageRepository) {
		this.messageRepository = messageRepository;
	}

	@Override
	public boolean test() {
		return false;
	}

	@Override
	public Message createMessage(Message message){
		return messageRepository.saveAndFlush(message);
	}

	@Override
	public Message readMessage(Long id) {
		return messageRepository.findOne(id);
	}

	@Override
	public void deleteMessage(Long id) {
		messageRepository.delete(id);
	}

	@Override
	public List<Message> findAllMessages() {
		return messageRepository.findAll();
	}
}
