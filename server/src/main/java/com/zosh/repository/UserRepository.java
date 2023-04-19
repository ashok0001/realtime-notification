package com.zosh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zosh.modal.ChatMessage;

public interface UserRepository extends JpaRepository<ChatMessage, Integer> {

	
}
