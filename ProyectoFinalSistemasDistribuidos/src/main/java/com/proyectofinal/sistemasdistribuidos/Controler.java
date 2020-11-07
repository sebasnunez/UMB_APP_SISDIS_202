package com.proyectofinal.sistemasdistribuidos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controler {
    public class KafkaTestController {
        @Autowired
        Producer MessageProducer;

        @PostMapping("/add/{topic}")
        public void addIdCustomer(@PathVariable String topic, @RequestBody String body)
        {
            MessageProducer.sendMessage(topic,body);
        }
    }
}
