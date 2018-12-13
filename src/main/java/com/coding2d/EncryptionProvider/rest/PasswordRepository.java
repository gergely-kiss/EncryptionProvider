package com.coding2d.EncryptionProvider.rest;

import org.springframework.data.repository.CrudRepository;

public interface PasswordRepository extends CrudRepository<EncryptedPassword, String>{

}
