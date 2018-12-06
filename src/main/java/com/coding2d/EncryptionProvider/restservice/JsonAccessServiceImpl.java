package com.coding2d.EncryptionProvider.restservice;

import org.json.JSONObject;
import org.springframework.stereotype.Service;
@Service
public class JsonAccessServiceImpl implements JsonAccessService{

	@Override
	public Object getJsonFiled(JSONObject json, String key) {
		return json.get(key);
	}

}
