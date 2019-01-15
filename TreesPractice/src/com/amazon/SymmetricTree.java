package com.amazon;

/**
 * Created by udaypersonal on 9/5/16.
 */
public class SymmetricTree {

    public Boolean isSymmetric(BinaryTreeNode root) {
        if (root == null) {
            return true;
        }

        return isSymmetricInternal(root.llink, root.rlink);
    }

    private Boolean isSymmetricInternal(BinaryTreeNode leftNode,
                                        BinaryTreeNode rightNode) {

        boolean result = false;

        // If both null then true
        if (leftNode == null && rightNode == null) {
            result = true;
        }

        if (leftNode != null && rightNode != null) {
            result = (leftNode.data == rightNode.data)
                    && isSymmetricInternal(leftNode.llink, rightNode.rlink)
                    && isSymmetricInternal(leftNode.llink, rightNode.rlink);
        }

        return result;
    }
}
