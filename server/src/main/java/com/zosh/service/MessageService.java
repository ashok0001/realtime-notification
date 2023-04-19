package com.zosh.service;

import org.springframework.stereotype.Service;

import com.zosh.modal.ChatMessage;


public interface MessageService {
	
	public ChatMessage sendMessage(ChatMessage message);

}
