package com.coding2d.EncryptionProvider.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.coding2d.EncryptionProvider.data.TestConstants;
import com.coding2d.EncryptionProvider.restservice.EncryptionService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EncryptionServiceTest {
	
	@Autowired
	public EncryptionService eService;
	
	@Test
	public void getBCryptedPassword() {
		assertNotNull(eService.getBCryptedPassword(TestConstants.PASSWORD));
		Assert.assertNotEquals(TestConstants.PASSWORD, eService.getBCryptedPassword(TestConstants.PASSWORD));
	}
	@Test
	public void checkPassword() {
		Assert.assertTrue(eService.checkPassword(TestConstants.PASSWORD, TestConstants.E_PASSWORD));
		Assert.assertNotEquals(true, eService.checkPassword(TestConstants.PASSWORD_CAPITAL, TestConstants.E_PASSWORD));
	}
	@Test
	public void getBCryptedPasswordAndCheckPassword() {
		String encrptedPassword = eService.getBCryptedPassword(TestConstants.PASSWORD);
		Assert.assertTrue(eService.checkPassword(TestConstants.PASSWORD, encrptedPassword));
	}
}

