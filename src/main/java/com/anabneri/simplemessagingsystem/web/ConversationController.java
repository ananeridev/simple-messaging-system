package com.anabneri.simplemessagingsystem.web;

import com.anabneri.simplemessagingsystem.model.Messaging;
import com.anabneri.simplemessagingsystem.model.Status;
import com.anabneri.simplemessagingsystem.service.ConversationMessagingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/messaging")
public class ConversationController {

    @Autowired
    ConversationMessagingService conversationMessagingService;

    @PostMapping("/queue")
    public @ResponseBody Status queueMessaging(@RequestBody Messaging messaging) {
        return conversationMessagingService.queueMessagingInclude(messaging);
    }

    @PostMapping("/topic")
    public @ResponseBody Status topicMessaging(@RequestBody Messaging messaging) {
        return conversationMessagingService.topicMessageInclude(messaging);
    }

}
