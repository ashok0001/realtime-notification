package com.zosh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zosh.modal.ChatMessage;

public interface MessageRepository extends JpaRepository<ChatMessage, Integer> {
	
	

}
