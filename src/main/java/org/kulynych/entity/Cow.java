package org.kulynych.entity;

import org.kulynych.service.Node;

public class Cow {
    private String cowId;
    private String nickName;
    private String parentId;
    private Node firstChild;

    public Cow(String cowId, String nickName, String parentId) {
        this.cowId = cowId;
        this.nickName = nickName;
        this.parentId = parentId;
        this.firstChild = null;
    }

    public void setFirstChild(Node firstChild) {
        this.firstChild = firstChild;
    }

    public Node getFirstChild() {
        return this.firstChild;
    }

    public String getCowId() {
        return cowId;
    }

    public void setCowId(String cowId) {
        this.cowId = cowId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    @Override
    public String toString() {
        return
                " id=" + cowId +
                " " + nickName +
                ", parent is '" + parentId + '\'';
    }
}