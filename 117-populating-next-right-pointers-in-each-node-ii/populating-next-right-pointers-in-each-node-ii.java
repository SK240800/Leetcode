class Solution {
    public Node connect(Node root) {
        if (root == null) return root;

        Node cur = root; // current level's first node
        Node head = null; // head of the next level
        Node prev = null; // previous node on the next level

        // Traverse level by level
        while (cur != null) {
            // Iterate over current level
            while (cur != null) {
                // Connect left child
                if (cur.left != null) {
                    if (prev != null) {
                        prev.next = cur.left;
                    } else {
                        head = cur.left;
                    }
                    prev = cur.left;
                }

                // Connect right child
                if (cur.right != null) {
                    if (prev != null) {
                        prev.next = cur.right;
                    } else {
                        head = cur.right;
                    }
                    prev = cur.right;
                }

                // Move to next node in current level
                cur = cur.next;
            }

            // Move to the next level
            cur = head;
            head = null;
            prev = null;
        }

        return root;
    }
}