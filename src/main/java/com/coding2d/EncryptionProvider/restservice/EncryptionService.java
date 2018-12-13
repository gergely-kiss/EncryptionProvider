package com.coding2d.EncryptionProvider.restservice;


public interface EncryptionService {

	public String getBCryptedPassword(String password);

	String checkPassword(String ePassword);

}
