package com.roca12.restjee.sockets;


import java.io.StringReader;
import javax.json.Json;
import javax.json.JsonException;
import javax.json.JsonObject;
import javax.json.JsonValue;
import static javax.json.JsonValue.ValueType.NUMBER;
import static javax.json.JsonValue.ValueType.STRING;
import javax.json.stream.JsonParsingException;
import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;


public class MsgDecoder implements Decoder.Text {

    @Override
    public AbstractMsg decode(String s) throws DecodeException {
        JsonObject json = Json.createReader(new StringReader(s)).readObject();
        JsonValue contentValue = json.get("content");
        switch (contentValue.getValueType()) {
            case STRING:
                String stringContent = json.getString("content");
                return new StringMsg(stringContent);
            case NUMBER:
                Integer intContent = json.getInt("content");
                return new IntegerMsg(intContent);
            default:
                return null;
        }
    }

    @Override
    public boolean willDecode(String s) {
        JsonObject json;
        try {
            json = Json.createReader(new StringReader(s)).readObject();
        } catch (JsonParsingException e) {

            {
                return false;
            }
        } catch (JsonException e) {
            return false;
        }
        boolean hasContent = json.containsKey("content");
        return hasContent;
    }

    @Override
    public void init(EndpointConfig config) {
        System.out.println("Decoding incoming message...");
    }

    @Override
    public void destroy() {
        System.out.println("Incoming message decoding finished");
    }
}
