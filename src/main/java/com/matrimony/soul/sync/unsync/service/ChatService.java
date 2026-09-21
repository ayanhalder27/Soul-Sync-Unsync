package com.matrimony.soul.sync.unsync.service;

import com.matrimony.soul.sync.unsync.domain.Chat;
import com.matrimony.soul.sync.unsync.dto.ChatListDTO;
import com.matrimony.soul.sync.unsync.repository.ChatRepository;
import com.matrimony.soul.sync.unsync.repository.mapper.ChatMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ChatService {
    ChatRepository chatRepository;

    public ChatService(ChatRepository chatRepository) {
        this.chatRepository = chatRepository;
    }


    public List<Chat> inbox(int sender_id, int receiver_id){
        return chatRepository.inbox(sender_id, receiver_id);
    }

    public int sendMessage(Chat chat){
        return chatRepository.sendMessage(chat);
    }

    public int deleteMessage(int message_id, int sender_id){
        return chatRepository.deleteMessage(message_id, sender_id);
    }

    public int editMessage(int message_id, int sender_id, String message){
        return chatRepository.editMessage(message_id, sender_id, message);
    }

    public List<ChatListDTO> getChatList(int sender_id){
        return chatRepository.getChatList(sender_id);
    }
}
