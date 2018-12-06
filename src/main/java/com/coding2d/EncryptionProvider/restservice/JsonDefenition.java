package com.coding2d.EncryptionProvider.restservice;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.coding2d.EncryptionProvider.rest.ObjectConstants;

@Component
public class JsonDefenition {

	private static final String PASSWORD = "password";
	private static final String E_PASSWORD = "e_password";

	private final List<String> passwordCheck = Arrays.asList(new String[] { PASSWORD, E_PASSWORD });
	private final List<String> password = Arrays.asList(new String[] { PASSWORD });

	public List<String> getKeys(String JsonDef) throws Exception {
		if (JsonDef.equalsIgnoreCase(ObjectConstants.PASSWORD_CHECK)) {
			return passwordCheck;
		} else if (JsonDef.equalsIgnoreCase(ObjectConstants.PASSWORD)) {
			return password;
		} else {
			throw new Exception("No Json defenition found!");
		}
	}
}
