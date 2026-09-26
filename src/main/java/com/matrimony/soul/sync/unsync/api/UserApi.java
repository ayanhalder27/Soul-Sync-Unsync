package com.matrimony.soul.sync.unsync.api;

import com.matrimony.soul.sync.unsync.domain.User;
import com.matrimony.soul.sync.unsync.dto.UserDTO;
import com.matrimony.soul.sync.unsync.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class UserApi {
    UserService userService;

    public UserApi(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> get(@PathVariable int id){
        return ResponseEntity.ok(userService.get(id));
    }

    @PostMapping
    public ResponseEntity<Integer> insert(@RequestBody User user){
        userService.insert(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("user/{id}")
    public ResponseEntity<Integer> update(@RequestBody User user, @PathVariable int id){
        userService.update(user, id);
        return ResponseEntity.status(HttpStatus.PARTIAL_CONTENT).build();
    }

    @DeleteMapping("client/user/{id}")
    public ResponseEntity<Integer> delete(@PathVariable int id){
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("client/user")
    public ResponseEntity<List<UserDTO>> Suggestions(@RequestParam int myId){
        return ResponseEntity.ok(userService.Suggestions(myId));
    }
}
