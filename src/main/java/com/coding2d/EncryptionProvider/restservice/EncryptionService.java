package com.coding2d.EncryptionProvider.restservice;

public interface EncryptionService {

	public String getBCryptedPassword(String password);

	public String checkPassword(String ePassword);
	
	public String getMasterPass();

}
