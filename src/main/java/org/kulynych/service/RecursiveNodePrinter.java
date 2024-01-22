package org.kulynych.service;

public class RecursiveNodePrinter {

    private static final String IDENT = "|--";

    /**
     * Could be prettified in more readable and fancy manner
     */
    public void printFarmDataRecursive(Node node, int depth) {
        if (node == null) {
            return;
        }

        printIndentation(depth);
        System.out.println(node.cow);

        if (node.firstChild != null) {
            printFarmDataRecursive(node.firstChild, depth + 1);
        }

        if (node.nextSibling != null) {
            printFarmDataRecursive(node.nextSibling, depth);
        }
    }


    private void printIndentation(int depth) {
        for (int i = 0; i < depth; i++) {
            System.out.print(IDENT);
        }
    }
}
