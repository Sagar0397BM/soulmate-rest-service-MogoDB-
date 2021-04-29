package com.stackroute.soulMateDemo.service;

import com.stackroute.soulMateDemo.Domain.User;

import com.stackroute.soulMateDemo.Exceptions.UserAlradyExistsException;
import com.stackroute.soulMateDemo.Exceptions.UserNotFoundException;
import com.stackroute.soulMateDemo.repository.UserRepository;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private UserServiceImpl userService;

    @Test
    public void givenUserToSaveShouldReturnSavedUser() throws UserAlradyExistsException {
        User user= new User(1,"John","Male",25);
        when(userRepository.save(any())).thenReturn(user);
        userService.saveUser(user);
        verify(userRepository,times(1)).save(any());
    }

    @Test
    public  void listallTheUsers(){
        User user= new User(1,"John","Male",25);
        userRepository.save(user);
        List <User> userList = userService.getAllUser();
        when(userRepository.findAll()).thenReturn(userList);
        assertEquals(userList,userList);
        verify(userRepository,times(1)).save(user);
        verify(userRepository,times(1)).findAll();

    }

    @Test
    public  void deleteUser() throws UserNotFoundException {
        int id=2;
        User user= new User(1,"John","Male",25);
        userService.deleteUser(id);
        verify(userRepository,times(1)).deleteById(id);

    }
}