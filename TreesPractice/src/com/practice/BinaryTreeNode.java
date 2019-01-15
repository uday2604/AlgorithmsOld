package com.practice;

/**
 * Created by Uday on 2016-04-24.
 */
public class BinaryTreeNode {

    public BinaryTreeNode llink;
    public BinaryTreeNode rlink;
    public int data;

    public BinaryTreeNode(int data) {
        this.data=data;
        llink=null;
        rlink=null;

    }

    public int getData() {

        return this.data;
    }

    public void setData(int data) {

        this.data=data;
    }

    public void setLeft(BinaryTreeNode leftNode) {
        this.llink = leftNode;
    }

    public void setRight(BinaryTreeNode rightNode) {

        this.rlink=rightNode;
    }

    public BinaryTreeNode getLeft() {

        return this.llink;
    }

    public BinaryTreeNode getRight() {

        return this.rlink;
    }
}
