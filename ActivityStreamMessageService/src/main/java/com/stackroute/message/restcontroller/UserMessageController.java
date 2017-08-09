package com.stackroute.message.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.message.dao.UserMessageDao;
import com.stackroute.message.model.UserMessage;


@RestController
@RequestMapping("/api/usermessage")
public class UserMessageController {

	@Autowired
	UserMessageDao userMessageDao;
	
	@RequestMapping(value="/sendMessage",method=RequestMethod.POST)
	public ResponseEntity sendMessage(@RequestBody UserMessage userMessage)
	{
		boolean result=userMessageDao.sendMessage(userMessage);
		if(result)
		{
			return new ResponseEntity("Message Successfully Sent",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity("Error Sending Message",HttpStatus.OK);
		}
		
	}
	
	@RequestMapping(value="/deleteMessage/{messageId}",method=RequestMethod.GET)
	public ResponseEntity deleteMessage(@PathVariable("messageId") int messageId)
	{
		boolean result=userMessageDao.deleteMessage(messageId);
		if(result)
		{
			return new ResponseEntity("Message Deleted Successfully",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity("Error Deleting Message",HttpStatus.OK);
		}
	}
	
	@RequestMapping(value="/getAllMessages",method=RequestMethod.POST)
	public List getAllMessageOfUser(@RequestBody UserMessage userMessage)
	{
		return userMessageDao.getMyMessages(userMessage.getSenderEmailId());
	}
}
