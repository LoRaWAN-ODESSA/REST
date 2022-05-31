package com.company.rest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MessageService {

    public List<Map<String, Integer>> countUniqueId(List<Map<String, String>> messages, Map<String, String> message, List<Map<String, Integer>> response) {
        if(messages.size() == 1) {
            Map<String, Integer> newUser = new HashMap<>();
            newUser.put(message.get("userId"), 1);
            response.add(newUser);
        } else {
            boolean isFound = false;
            for (int i = 0; i < response.size(); i++) {
                if(response.get(i).containsKey(message.get("userId"))) {
                    response.get(i).put(message.get("userId"), response.get(i).get(message.get("userId")) + 1);
                    isFound = true;
                }
            }
            if (!isFound) {
                Map<String, Integer> newUser = new HashMap<>();
                newUser.put(message.get("userId"), 1);
                response.add(newUser);
            }
        }
        return response;
    }

    public List<Map<String, String>> changeMessages(List<Map<String, String>> messages, Map<String, String> messageFromDb, String id) {
        for (int i = 0; i < messages.size(); i++) {
            if(messages.get(i).get("id").equals(id)) {
                messages.get(i).putAll(messageFromDb);
            }
        }
        return messages;
    }

}
