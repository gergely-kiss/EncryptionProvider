package com.coding2d.EncryptionProvider.restservice;

public interface EncryptionService {

	public String getBCryptedPassword(String password);

	public boolean checkPassword(String password, String encryptedPassword);

}
