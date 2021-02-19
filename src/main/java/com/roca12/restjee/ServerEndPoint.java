//package com.roca12.restjee;
//
//import java.util.Set;
//import javax.websocket.OnClose;
//import javax.websocket.OnError;
//import javax.websocket.OnMessage;
//import javax.websocket.OnOpen;
//import javax.websocket.Session;
//import javax.websocket.server.ServerEndpoint;
//
//@ServerEndpoint(value = "/webSocketObjectEndPoint",  encoders= {StringMsgEncoder.class, IntegerMsgEncoder.class}, decoders = {MsgDecoder.class})
//public class ServerEndPoint {
//
//    @OnOpen
//    public void onOpen(Session session) {
//        System.out.println("A session has joined");
//    }
//
//    @OnClose
//    public void onClose(Session session) {
//        System.out.println("A session has left");
//    }
//
//    @OnMessage
//    public void onMessage(Session session, AbstractMsg message) {
//        if (message instanceof IntegerMsg) {
//            System.out.println("IntegerMsg received!");
//        } else if (message instanceof StringMsg) {
//            System.out.println("StringMsg received!");
//        }
//        message.transform();
//        sendMessageToAllParties(session, message);
//    }
//
//    @OnError
//    public void onError(Session session, Throwable throwable) {
//        session.getAsyncRemote().sendText(throwable.getLocalizedMessage());
//    }
//
//    private void sendMessageToAllParties(Session session, AbstractMsg message) {
//        Set<Session> set = session.getOpenSessions();
//        for (Session s : set) {
//            s.getAsyncRemote().sendObject(message);
//        }
//}
//}