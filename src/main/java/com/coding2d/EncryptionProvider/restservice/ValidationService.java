package com.coding2d.EncryptionProvider.restservice;

import java.util.List;

import org.json.JSONException;

public interface ValidationService {
	
	public boolean isNotBlank(List<String> args);

	public boolean validateObjectIntegrity(String request, String passwordCheck) throws JSONException, Exception;

}
