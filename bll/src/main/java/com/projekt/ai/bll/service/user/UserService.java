package com.projekt.ai.bll.service.user;


import com.projekt.ai.bll.model.user.UserLoginIn;
import com.projekt.ai.bll.model.user.UserLoginOut;
import com.projekt.ai.bll.model.user.UserRegisterIn;
import com.projekt.ai.common.app.AppData;
import com.projekt.ai.common.app.BookstoreAppException;
import com.projekt.ai.common.app.Dictionary;
import com.projekt.ai.dal.domain.enums.Role;
import com.projekt.ai.dal.domain.user.Address;
import com.projekt.ai.dal.domain.user.AddressRepository;
import com.projekt.ai.dal.domain.user.User;
import com.projekt.ai.dal.domain.user.UserRepository;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lenovo on 2017-11-05.
 */

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private RegistrationValidatorService registrationValidatorService;

    public void register(UserRegisterIn userRegisterIn) {
        registrationValidatorService.validateUser(userRegisterIn);

        User user = new User();
        user.setUsername(userRegisterIn.getUsername());
        user.setPassword(userRegisterIn.getPassword());
        user.setFirstname(userRegisterIn.getFirstname());
        user.setLastname(userRegisterIn.getLastname());
        user.setEmail(userRegisterIn.getEmail());
        user.setRole(Role.USER);

        User savedUser = userRepository.save(user);

        Address address = new Address();
        address.setId(savedUser.getId());
        address.setCity(userRegisterIn.getCity());
        address.setStreet(userRegisterIn.getStreet());
        address.setHouseNumber(userRegisterIn.getHouseNumber());
        address.setPostNumber(userRegisterIn.getPostNumber());

        addressRepository.save(address);
    }

    public UserLoginOut login(UserLoginIn userLoginIn) {
        User user = userRepository.getUserByUsernameAndPassword(userLoginIn.getUsername(), userLoginIn.getPassword());

        if(user == null)
            throw new BookstoreAppException(Dictionary.INVALID_PASSES);

        UserLoginOut userLoginOut = new UserLoginOut();
        userLoginOut.setToken(generateToken(user));
        userLoginOut.setUserId(user.getId());
        userLoginOut.setFirstname(user.getFirstname());
        userLoginOut.setRole(user.getRole());

        return userLoginOut;
    }

    private String generateToken(User user) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(AppData.JWT_KEY);
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

        Map<String, Object> map = new HashMap<>();
        map.put("username", user.getUsername());
        map.put("role", user.getRole());

        JwtBuilder builder = Jwts.builder()
                .setClaims(map)
                .signWith(signatureAlgorithm, signingKey);

        return builder.compact();
    }

    public void checkEmail(String email, HttpServletResponse response) {
        if(!checkEmail(email))
            response.setStatus(HttpServletResponse.SC_CONFLICT);
    }

    public void checkUsername(String username, HttpServletResponse response) {
        if(!checkUsername(username))
            response.setStatus(HttpServletResponse.SC_CONFLICT);
    }

    public boolean checkEmail(String email) {
        User user = userRepository.getUserByEmail(email);
        return user == null;
    }

    public boolean checkUsername(String username) {
        User user = userRepository.getUserByUsername(username);
        return user == null;
    }
}
