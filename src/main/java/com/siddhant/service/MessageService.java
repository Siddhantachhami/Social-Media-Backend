package com.siddhant.service;

import java.util.List;

import com.siddhant.models.Chat;
import com.siddhant.models.Message;
import com.siddhant.models.User;

public interface MessageService {
	
	public Message createMessage(User user,Integer chatId,Message req) throws Exception;
	public List<Message> findChatsMessages(Integer chatId) throws Exception;
	
	

}
