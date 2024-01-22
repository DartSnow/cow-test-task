package org.kulynych.service;

import org.kulynych.entity.Cow;

public class Node {
    Cow cow;
    Node firstChild;
    Node nextSibling;

    public Node(Cow cow) {
        this.cow = cow;
        this.firstChild = null;
        this.nextSibling = null;
    }
}
