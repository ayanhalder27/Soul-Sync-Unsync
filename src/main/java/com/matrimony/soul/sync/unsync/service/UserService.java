package com.matrimony.soul.sync.unsync.service;

import com.matrimony.soul.sync.unsync.domain.User;
import com.matrimony.soul.sync.unsync.repository.UserRepository;
import com.matrimony.soul.sync.unsync.repository.mapper.UserMapper;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User get(int id){
        return userRepository.get(id);
    }

    public int insert(User user){
        return userRepository.insert(user);
    }

    public int update(User user, int id){
        return userRepository.update(user, id);
    }

    public int delete(int id){
        return userRepository.delete(id);
    }
}
