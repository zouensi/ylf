package com.ylf.converter;

import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class StringToDateConverter implements Converter<String,Date> {

	@Override
	public Date convert(String source) {
		System.out.println(111);
		Date date = new Date(Long.parseLong(source));
		return date;
	}


	
}
