package com.stackroute.message.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.message.dao.MessageDao;
import com.stackroute.message.model.Message;


@RestController
@RequestMapping("/api/message")
public class MessageController {

	@Autowired
	MessageDao messageDao;
	
	@RequestMapping(value="/sendMessage",method=RequestMethod.POST)
	public ResponseEntity sendMessage(@RequestBody Message message)
	{
		boolean result=messageDao.sendMessage(message);
		if(result)
		{
			return new ResponseEntity("Message Successfully Sent",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity("Error Sending Message",HttpStatus.OK);
		}
		
	}
	
	@RequestMapping(value="/getAllMessages",method=RequestMethod.POST)
	public List getAllMessageOfUser(@RequestBody Message message)
	{
		return messageDao.getMyMessages(message.getSenderEmailId());
	}
}
