package com.coding2d.EncryptionProvider.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coding2d.EncryptionProvider.restservice.EncryptionService;

@Controller
@RequestMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
public class EncryptionAPI {
	@Autowired
	private EncryptionService eService;

	//private static final Logger LOG = LoggerFactory.getLogger(EncryptionAPI.class); 
	@PostMapping(path = "/encrypt")
	public @ResponseBody String encrypt(@RequestBody String password) {
		return eService.getBCryptedPassword(password);
	}

	@PostMapping(path = "/check")
	public @ResponseBody String checkValid(@RequestBody String password) {
		return  eService.checkPassword(password);
	}
}
