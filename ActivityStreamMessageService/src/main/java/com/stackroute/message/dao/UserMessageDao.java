package com.stackroute.message.dao;

import java.util.List;

import com.stackroute.message.model.UserMessage;


public interface UserMessageDao {

	boolean sendMessage(UserMessage usrmessage);
	boolean deleteMessage(int messageId);
	List<UserMessage> getMyMessages(String emailId);
}
