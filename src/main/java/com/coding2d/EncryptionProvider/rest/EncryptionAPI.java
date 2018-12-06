package com.coding2d.EncryptionProvider.rest;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coding2d.EncryptionProvider.restservice.EncryptionService;
import com.coding2d.EncryptionProvider.restservice.JsonAccessService;
import com.coding2d.EncryptionProvider.restservice.JsonDefenition;
import com.coding2d.EncryptionProvider.restservice.ValidationService;

@Controller
@RequestMapping
public class EncryptionAPI {
	@Autowired
	private EncryptionService eService;
	@Autowired
	private ValidationService vService;
	@Autowired
	private JsonAccessService jService;
	@Autowired
	private JsonDefenition jDefinition;

	@PostMapping(path = "/encrypt")
	public @ResponseBody String encrypt(@RequestBody String request) throws Exception {
		if (vService.validateObjectIntegrity(request, ObjectConstants.PASSWORD)) {
			return eService.getBCryptedPassword(
					jService.getJsonFiled(new JSONObject(request), jDefinition.getKeys(ObjectConstants.PASSWORD).get(0))
							+ "");
		} else {
			throw new Exception("pw");
		}
	}

	@PostMapping(path = "/check")
	public @ResponseBody String checkValid(@RequestBody String request) throws JSONException, Exception {

		if (vService.validateObjectIntegrity(request, ObjectConstants.PASSWORD_CHECK)) {
			return (eService.checkPassword(
					(jService.getJsonFiled(new JSONObject(request),
							jDefinition.getKeys(ObjectConstants.PASSWORD_CHECK).get(0))) + "",
					(jService.getJsonFiled(new JSONObject(request),
							jDefinition.getKeys(ObjectConstants.PASSWORD_CHECK).get(1))) + ""))
					+ "";

		} else {
			throw new Exception("pw");
		}
	}
}
