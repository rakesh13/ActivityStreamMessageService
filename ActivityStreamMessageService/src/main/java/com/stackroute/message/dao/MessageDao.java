package com.stackroute.message.dao;

import java.util.List;

import com.stackroute.message.model.Message;


public interface MessageDao {

	boolean sendMessage(Message message);
	List<Message> getMyMessages(String emailId);//create a private method in daoimpl class getmycircleids(email id)
	//boolean sendMessageToUser(String emailId);
}
