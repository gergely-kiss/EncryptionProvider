package com.coding2d.EncryptionProvider.rest;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class EncryptedPassword {

	/**
	 * 
	 */
	public EncryptedPassword() {
	}

	public EncryptedPassword(String encryption, String password) {
		this.password = password;
		this.encryption = encryption;
	}

	@Id
	private String password;
	@Column
	private String encryption;

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the encryption
	 */
	public String getEncryption() {
		return encryption;
	}

	/**
	 * @param encryption the encryption to set
	 */
	public void setEncryption(String encryption) {
		this.encryption = encryption;
	}

}
