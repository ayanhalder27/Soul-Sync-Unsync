package com.matrimony.soul.sync.unsync.repository;

import com.matrimony.soul.sync.unsync.domain.Chat;
import com.matrimony.soul.sync.unsync.dto.ChatListDTO;
import com.matrimony.soul.sync.unsync.repository.mapper.ChatMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class ChatRepository {
    JdbcTemplate jdbcTemplate;

    public ChatRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Chat> inbox(int sender_id, int receiver_id){
        return jdbcTemplate.query("SELECT * FROM Chats where (sender_id = ? and receiver_id = ?) or (sender_id = ? and receiver_id = ?) order by sent_at;",
                new ChatMapper(),
                sender_id,
                receiver_id,
                receiver_id,
                sender_id);
    }

    public int sendMessage(Chat chat){
        return jdbcTemplate.update("INSERT INTO Chats (sender_id, receiver_id, message) VALUES (?, ?, ?)",
                chat.getSender_id(),
                chat.getReceiver_id(),
                chat.getMessage());
    }

    public int deleteMessage(int message_id, int sender_id){
        return jdbcTemplate.update("DELETE FROM Chats WHERE id = ? AND sender_id = ?", message_id, sender_id);
    }

    public int editMessage(int message_id, int sender_id, String message){
        return jdbcTemplate.update("UPDATE Chats SET message = ? WHERE id = ? AND sender_id = ?",
                message,
                message_id,
                sender_id);
    }

    public List<ChatListDTO> getChatList(int sender_id){
        return jdbcTemplate.query("SELECT Users.profile_pic, Users.name, message, sent_at, receiver_id FROM ( SELECT receiver_id, message, sent_at, ROW_NUMBER() OVER (PARTITION BY receiver_id ORDER BY sent_at DESC) AS rn FROM Chats WHERE sender_id = ?) c inner join Users on c.receiver_id = Users.id WHERE rn = 1;", ((rs, rowNum) -> {
            return new ChatListDTO(rs.getString("profile_pic"), rs.getString("name"), rs.getString("message"), rs.getObject("sent_at", LocalDateTime.class), rs.getInt("receiver_id"));
        }), sender_id);
    }
}
