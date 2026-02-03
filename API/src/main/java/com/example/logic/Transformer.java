package com.example.logic;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import org.apache.commons.text.StringEscapeUtils;

public class Transformer {
	public String transform(String input, String type, String mode) {
	    return switch (type) {
	        case "base64" -> "encode".equals(mode) ? 
	            Base64.getEncoder().encodeToString(input.getBytes()) : 
	            new String(Base64.getDecoder().decode(input));
	            
	        case "url" -> "encode".equals(mode) ? 
	            URLEncoder.encode(input, StandardCharsets.UTF_8) : 
	            URLDecoder.decode(input, StandardCharsets.UTF_8);
	        
	        case "html" -> "encode".equals(mode) ? 
	        	    StringEscapeUtils.escapeHtml4(input) : 
	        	    StringEscapeUtils.unescapeHtml4(input);
	            
	        default -> "Unsupported type";
	    };
	}
}
