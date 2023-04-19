package com.zosh.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zosh.exception.UserException;
import com.zosh.modal.ChatMessage;
import com.zosh.modal.User;
import com.zosh.repository.UserRepository;
import com.zosh.service.MessageService;
import com.zosh.service.UserService;

@RestController
public class ChatController {
//	@Autowired
//    private SimpMessagingTemplate template;
	
	MessageService messageService;
	UserService userService;
	UserRepository userRepository;
	
	public ChatController(MessageService messageService, UserService userService, UserRepository userRepository) {
		this.messageService=messageService;
		this.userService=userService;
		this.userRepository=userRepository;
		
	}
	

	
	@PostMapping("/api/messages/send/{userId}")
	public ResponseEntity<ChatMessage> sendMessage(@PathVariable Integer userId , @RequestBody ChatMessage message) throws UserException{
		
		User user=userService.findUserById(userId);
		
		message.setSender(user);
		message.setTimestamp(LocalDateTime.now());
//		
		ChatMessage createdMessage=messageService.sendMessage(message);
//		
		user.getMessages().add(createdMessage);
		
		userRepository.save(user);
		
//		ChatMessage createdMessage=new ChatMessage();
//		createdMessage.setContent(message.getContent());
		
		
//		this.template.convertAndSend("/topic/message/recive/"+userId, createdMessage);
		
		
		
		return new ResponseEntity<ChatMessage>(createdMessage,HttpStatus.ACCEPTED);
	}

}
