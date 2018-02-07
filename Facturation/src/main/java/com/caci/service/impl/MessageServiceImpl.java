package com.caci.service.impl;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import com.caci.service.MessageService;


/**
 * Service pour les messages.
 * 
 * @author Slimane
 *
 */
@Component
public class MessageServiceImpl implements MessageService {
	
	@Autowired
    private MessageSource messageSource;

	@Override
	public String getMessage(String id) {
		 Locale locale = LocaleContextHolder.getLocale();
	     return messageSource.getMessage(id,null,locale);
	}

}
