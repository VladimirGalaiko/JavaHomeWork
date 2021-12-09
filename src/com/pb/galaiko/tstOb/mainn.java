package com.pb.galaiko.tstOb;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

public class mainn {

    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String,String> map = new HashMap<>();
        map.put("key1","vall1");

        map.put("key2","vall2");
        String json = objectMapper.writeValueAsString(map);
        System.out.println(json);





    }
}
