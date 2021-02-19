package com.roca12.restjee;

public class StringMsg extends AbstractMsg {

    private String content;

    public StringMsg(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public void transform() {
        this.content = "Someone said: " + this.content;
    }
}
