package com.matrimony.soul.sync.unsync.service;

import com.matrimony.soul.sync.unsync.domain.Gender;
import com.matrimony.soul.sync.unsync.domain.Religion;
import com.matrimony.soul.sync.unsync.domain.User;
import com.matrimony.soul.sync.unsync.dto.UserDTO;
import com.matrimony.soul.sync.unsync.repository.UserRepository;
import com.matrimony.soul.sync.unsync.repository.mapper.UserDTOMapper;
import com.matrimony.soul.sync.unsync.repository.mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<UserDTO> Suggestions(int myId){
        User user = userRepository.get(myId);
        if(user.getVisibility() == true)
            return userRepository.Suggestions(user.getGender(), user.getReligion());

        return List.of();
    }
}
