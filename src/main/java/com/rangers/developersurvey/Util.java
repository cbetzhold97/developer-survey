package com.rangers.developersurvey;

import java.io.IOException;
import java.io.StringWriter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Util {
	
	private static final Logger lgr = LoggerFactory.getLogger(Util.class);
	
	public static String toJSONString(Object value) {
		
		ObjectMapper xmlMapper = new ObjectMapper();
		StringWriter sw = new StringWriter();
		
		try {
			xmlMapper.writeValue(sw, value);
		}catch(JsonMappingException | JsonGenerationException e) {
			lgr.error(e.toString(),e);
		}catch(IOException e) {
			lgr.error(e.toString(),e);
		}
		
		return sw.toString();
	}

}
