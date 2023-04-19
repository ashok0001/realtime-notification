package com.zosh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zosh.modal.ChatMessage;
import com.zosh.service.MessageService;

@RestController
public class ChatController {
	
	MessageService messageService;
	
	public ChatController(MessageService messageService) {
		this.messageService=messageService;
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
    private SimpMessagingTemplate template;
	
	@PostMapping("/message/send/{userId}")
	public ResponseEntity<ChatMessage> sendMessage(@PathVariable Integer userId , @RequestBody ChatMessage message){
		
		ChatMessage createdMessage=messageService.sendMessage(message);
		
		this.template.convertAndSend("/topic/message/recive/"+userId, createdMessage);
		
		
		
		return new ResponseEntity<ChatMessage>(createdMessage,HttpStatus.ACCEPTED);
	}

}
