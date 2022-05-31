package com.company.rest.controllers;

import com.company.rest.exceptions.NotFoundException;
import com.company.rest.services.MessageService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("message")
public class MessageController {
    MessageService messageService = new MessageService();
    private List<Map<String, String>> messages = new ArrayList<Map<String, String>>();
    private List<Map<String, Integer>> response = new ArrayList<Map<String, Integer>>();

    @GetMapping
    public List<Map<String, String>> list() {
        return messages;
    }

    @GetMapping("{id}")
    public Map<String, String> getOne(@PathVariable String id) {
        return getMessage(id);
    }

    private Map<String, String> getMessage(@PathVariable String id) {
        return messages.stream()
                .filter(message -> message.get("id").equals(id))
                .findFirst()
                .orElseThrow(NotFoundException::new);
    }

    @PostMapping
    public List<Map<String, Integer>> create(@RequestBody Map<String, String> message) {
        messages.add(message);
        response = messageService.countUniqueId(messages, message, response);
        return response;
    }

    @PutMapping("{id}")
    public Map<String, String> update(@PathVariable String id, @RequestBody Map<String, String> message) {
        Map<String, String> messageFromDb = getMessage(id);

        messageFromDb.putAll(message);
        messageFromDb.put("id", id);

        return messageFromDb;
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable String id) {
        Map<String, String> message = getMessage(id);

        messages.remove(message);
    }
}
