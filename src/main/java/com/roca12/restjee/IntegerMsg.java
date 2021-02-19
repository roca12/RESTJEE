package com.roca12.restjee;

public class IntegerMsg extends AbstractMsg {

    private Integer content;

    public IntegerMsg(int content) {
        this.content = content;
    }

    public Integer getContent() {
        return content;
    }

    public void setContent(Integer content) {
        this.content = content;
    }

    @Override
    public void transform() {
        this.content = this.content * this.content;
    }

}
