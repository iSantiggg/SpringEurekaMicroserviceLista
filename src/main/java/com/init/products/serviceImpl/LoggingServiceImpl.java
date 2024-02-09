package com.init.products.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.init.products.model.Logging;
import com.init.products.model.dao.LoggingDao;
import com.init.products.service.LoggingService;

@Service
public class LoggingServiceImpl implements LoggingService{
	
	@Autowired
	private LoggingDao loggingDao;

	@Override
	public List<Logging> listausuarios() {
		return (List<Logging>) loggingDao.findAll();
	}
}
