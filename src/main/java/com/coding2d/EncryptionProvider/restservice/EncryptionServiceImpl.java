package com.coding2d.EncryptionProvider.restservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.coding2d.EncryptionProvider.rest.EncryptedPassword;
import com.coding2d.EncryptionProvider.rest.PasswordRepository;


@Service
public class EncryptionServiceImpl implements EncryptionService {

	private static final String BCRYPT =  "bCrypt";
	
	@Autowired
	private PasswordRepository pRepo;

	@Override
	public String getBCryptedPassword(String password) {
		String bCrptedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
		pRepo.save(new EncryptedPassword(BCRYPT, bCrptedPassword));
		return bCrptedPassword; 

	}

	@Override
	public String checkPassword(String ePassword) {
		List<EncryptedPassword> passwordList = (List<EncryptedPassword>) pRepo.findAll();
		try {
			for (EncryptedPassword ep : passwordList) {
				if (BCrypt.checkpw( ePassword, ep.getPassword())) {
					return "Registered already";
				}
			}
			return "Not registered";
		}

		catch (Exception e) {
			return "Problem occured";
		}
	}

}
