package com.zosh.service;

import org.springframework.stereotype.Service;

import com.zosh.modal.ChatMessage;
import com.zosh.repository.MessageRepository;

@Service
public class MessageServiceImplementation implements MessageService {
	
	
	
	MessageRepository messageRepository;
	
	public MessageServiceImplementation(MessageRepository messageRepository) {
		this.messageRepository=messageRepository;
		// TODO Auto-generated constructor stub
	}

	@Override
	public ChatMessage sendMessage(ChatMessage message) {
		ChatMessage createdMessage = messageRepository.save(message);
		return createdMessage;
	}

}
