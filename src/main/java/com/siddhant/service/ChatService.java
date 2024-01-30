package com.siddhant.service;

import java.util.List;

import com.siddhant.models.Chat;
import com.siddhant.models.User;

public interface ChatService {
	public Chat createChat(User reqUser,User user2);
	public Chat findChatById(Integer chatId) throws Exception;
	public List<Chat> findUsersChat(Integer userId);

}
