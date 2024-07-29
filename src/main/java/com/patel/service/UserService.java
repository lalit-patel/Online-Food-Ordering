package com.patel.service;

import com.patel.model.User;
import jdk.jshell.spi.ExecutionControl;


public interface UserService {

    public User findUserByJwtToken(String Jwt) throws Exception;

    public User findUserByEmail(String email) throws Exception;
}
