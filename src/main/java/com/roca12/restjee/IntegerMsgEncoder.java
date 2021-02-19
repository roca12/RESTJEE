package com.roca12.restjee;


import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

public class IntegerMsgEncoder implements Encoder.Text<IntegerMsg> {

    @Override
    public String encode(IntegerMsg object) throws EncodeException {
        JsonObjectBuilder builder = Json.createObjectBuilder();

        builder.add("content", object.getContent());

        JsonObject jsonObject = builder.build();
        return jsonObject.toString();
    }

    @Override
    public void init(EndpointConfig config) {
        System.out.println("IntegerMsgEncoder initializing");
    }

    @Override
    public void destroy() {
        System.out.println("IntegerMsgEncoder closing");
    }
}
