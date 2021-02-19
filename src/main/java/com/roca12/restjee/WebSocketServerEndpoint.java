package com.roca12.restjee;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/websocket")
public class WebSocketServerEndpoint {

    @OnOpen
    public void open(Session session) {
        System.out.println("a client connected");
    }

    @OnClose
    public void close(Session session) {
        System.out.println("a client disconnected");
    }

    @OnMessage
    public void handleMessage(String message) {
        System.out.println("received a message from a websocket client! " + message);
    }
}
