package com.coding2d.EncryptionProvider.restservice;

import org.json.JSONObject;

public interface JsonAccessService {

	public Object getJsonFiled(JSONObject json, String key);
}
