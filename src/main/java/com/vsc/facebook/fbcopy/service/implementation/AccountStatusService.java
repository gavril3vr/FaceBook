package com.vsc.facebook.fbcopy.service.implementation;

import com.vsc.facebook.fbcopy.dto.AccountStatusDTO;
import com.vsc.facebook.fbcopy.entity.User;
import com.vsc.facebook.fbcopy.exception.InvalidUserException;
import com.vsc.facebook.fbcopy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountStatusService {
    private final UserRepository userRepository;
    private final UserServiceImpl userService;

    @Autowired
    public AccountStatusService(UserRepository userRepository, UserServiceImpl userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    public boolean isPassValid(AccountStatusDTO accountStatusDTO) throws InvalidUserException {
        User user = userRepository.findFirstByEmail(accountStatusDTO.getEmail()).orElseThrow(()-> new InvalidUserException("Invalid User"));

        return user.getPassword().equals(accountStatusDTO.getPasswordToBeChecked());
    }

    public void deactivateAccount(AccountStatusDTO accountStatusDTO, User user) throws IllegalAccessException, InvalidUserException //throws CustomExceptionHandler
    {
        if (isPassValid(accountStatusDTO)) {
            user.setActive(false);
            userRepository.save(user);
        } else
            throw new IllegalAccessException();
    }

    public void activateAccount(AccountStatusDTO accountStatusDTO, User user) throws IllegalAccessException, InvalidUserException //throws CustomExceptionHandler
    {
        if (isPassValid(accountStatusDTO)) {
            user.setActive(true);
            userRepository.save(user);
        } else
            throw new IllegalAccessException();

    }
}
