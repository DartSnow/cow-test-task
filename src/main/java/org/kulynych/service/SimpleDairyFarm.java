package org.kulynych.service;

import org.kulynych.DairyFarm;
import org.kulynych.entity.Cow;

public class SimpleDairyFarm implements DairyFarm {
    private final Node root;

    public SimpleDairyFarm() {
        root = new Node(new Cow("1", "InitialCow", null));
    }

    public void giveBirth(String parentCowId, Cow child) {
        Node parentNode = findCow(parentCowId, root);
        assignNewCowToHerPlaceInTree(child, parentNode);
    }

    private void assignNewCowToHerPlaceInTree(Cow child, Node parentNode) {
        if (parentNode != null) {
            Node newChildNode = new Node(child);
            if (parentNode.firstChild == null) {
                parentNode.firstChild = newChildNode;
            } else {
                Node current = parentNode.firstChild;
                while (current.nextSibling != null) {
                    current = current.nextSibling;
                }
                current.nextSibling = newChildNode;
            }
        }
    }

    @Override
    public void endLifeSpan(String cowId) {
        if (root == null || root.cow.getCowId().equals(cowId)) {
            // Initial Cow always alive
            return;
        }
        removeCowAndRelocateChildren(cowId, null, root);
    }

    private void removeCowAndRelocateChildren(String cowId, Node parent, Node current) {
        if (current == null) {
            return;
        }

        if (current.cow.getCowId().equals(cowId)) {
            relocateChildrenToTheRootAsSiblings(current);
            removeCowFromExMother(parent, current);
            return;
        }

        removeCowAndRelocateChildren(cowId, current, current.firstChild);
        removeCowAndRelocateChildren(cowId, parent, current.nextSibling);
    }

    private void removeCowFromExMother(Node parent, Node current) {
        if (parent.firstChild == current) {
            parent.firstChild = current.nextSibling;
        } else {
            Node prevSibling = parent.firstChild;
            while (prevSibling != null && prevSibling.nextSibling != current) {
                prevSibling = prevSibling.nextSibling;
            }
            if (prevSibling != null) {
                prevSibling.nextSibling = current.nextSibling;
            }
        }
    }

    private void relocateChildrenToTheRootAsSiblings(Node current) {
        Node rootSibling = root.nextSibling;
        if (rootSibling == null) {
            root.nextSibling = current.firstChild;
        } else {
            while (rootSibling.nextSibling != null) {
                rootSibling = rootSibling.nextSibling;
            }
            rootSibling.nextSibling = current.firstChild;
        }
    }


    private Node findCow(String cowId, Node node) {
        if (node == null) {
            return null;
        }
        if (node.cow.getCowId().equals(cowId)) {
            return node;
        }
        Node childResult = findCow(cowId, node.firstChild);
        if (childResult != null) {
            return childResult;
        }
        return findCow(cowId, node.nextSibling);
    }

    public void printFarmData() {
        new RecursiveNodePrinter().printFarmDataRecursive(root, 0);
    }
}
