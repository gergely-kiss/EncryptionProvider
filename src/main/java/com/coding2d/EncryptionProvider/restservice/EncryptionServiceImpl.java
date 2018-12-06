package com.coding2d.EncryptionProvider.restservice;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class EncryptionServiceImpl implements EncryptionService{

	@Override
	public String getBCryptedPassword(String password) {
		return BCrypt.hashpw(password, BCrypt.gensalt());
	}

	@Override
	public boolean checkPassword(String password, String encryptedPassword) {
		return BCrypt.checkpw(password, encryptedPassword);
	}

}
