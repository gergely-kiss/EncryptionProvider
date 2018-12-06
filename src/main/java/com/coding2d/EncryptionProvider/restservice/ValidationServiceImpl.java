package com.coding2d.EncryptionProvider.restservice;

import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValidationServiceImpl implements ValidationService {

	private static final Logger LOG = LoggerFactory.getLogger(ValidationServiceImpl.class);

	@Autowired
	JsonDefenition jDef;

	@Override
	public boolean isNotBlank(List<String> args) {
		for (int i = 0; i < args.size(); i++) {
			if (args.get(i).equals(null)) {
				LOG.warn("The {} th argument is null!");
				return false;
			}
			if (args.get(i).equals("")) {
				LOG.warn("The {} th argument is and empty String!");
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean validateObjectIntegrity(String request, String objectName) throws JSONException, Exception {
		for (String keys : jDef.getKeys(objectName)) {
			new JSONObject(request).get(keys);
		}
		return true;
	}
}
