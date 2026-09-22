package com.matrimony.soul.sync.unsync.api;

import com.matrimony.soul.sync.unsync.domain.Chat;
import com.matrimony.soul.sync.unsync.dto.ChatListDTO;
import com.matrimony.soul.sync.unsync.service.ChatService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/chats")
public class ChatApi {
    ChatService chatService;

    public ChatApi(ChatService chatService) {
        this.chatService = chatService;
    }

    @GetMapping
    public ResponseEntity<List<Chat>> inbox(@RequestParam int sender_id, @RequestParam int receiver_id) {
        return ResponseEntity.ok(chatService.inbox(sender_id, receiver_id));
    }

    @PostMapping
    public ResponseEntity<Void> sendMessage(@RequestParam int sender_id, @RequestParam int receiver_id, @RequestBody String message) {
        Chat chat = new Chat();
        chat.setSender_id(sender_id);
        chat.setReceiver_id(receiver_id);
        chat.setMessage(message);
        chatService.sendMessage(chat);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{message_id}")
    public ResponseEntity<Void> deleteMessage(@PathVariable int message_id, @RequestParam int sender_id) {
        chatService.deleteMessage(message_id, sender_id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{message_id}")
    public ResponseEntity<Void> editMessage(@PathVariable int message_id, @RequestParam int sender_id, @RequestBody String message) {
        chatService.editMessage(message_id, sender_id, message);
        return ResponseEntity.status(HttpStatus.PARTIAL_CONTENT).build();
    }

    @GetMapping("/list")
    public ResponseEntity<List<ChatListDTO>> getChatList(@RequestParam int sender_id){
        return ResponseEntity.ok(chatService.getChatList(sender_id));
    }

}
