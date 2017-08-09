package com.stackroute.message.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.stackroute.message.dao.MessageDao;
import com.stackroute.message.model.Message;



@Repository(value="messageDao")
@Component
@Transactional
public class MessageDaoImpl implements MessageDao{

	@Autowired
	SessionFactory sessionFactory;

	public boolean sendMessage(Message message) {
		try
		{
			sessionFactory.getCurrentSession().save(message);
			return true;
		}
		catch(Exception ex)
		{
			return false;
		}
		
	}

	public List<Message> getMyMessages(String emailId) {
		return sessionFactory.getCurrentSession().createCriteria(Message.class).add(Restrictions.eq("senderEmailId", emailId)).list();
	}
	
	

}
