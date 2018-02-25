package org.blackwok.spotifychat.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;
/**
 * Created by Jemma on 6/17/17.
 */
public class ChatMessage {

    private String message_uuid;
    private String message_text;


    public ChatMessage (String message_text) {
        this.message_uuid = UUID.randomUUID().toString();
        this.message_text = message_text;
    }

    public ChatMessage (String message_uuid, String message_text) {
        this.message_uuid = message_uuid;
        this.message_text = message_text;
    }

    @JsonProperty
    public String getMessageUuid() { return message_uuid; }

    @JsonProperty
    public String getMessageText() { return message_text; }

}
