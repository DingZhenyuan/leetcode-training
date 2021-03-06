public class BinaryTree {
    private BTNode root;
    public void setRoot(BTNode root)
    {
        this.root = root;
    }

    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        } else {
            System.out.println("Empty");
        }
    }

    public void infixOrder() {
        if (this.root != null) {
            this.root.infixOrder();
        } else {
            System.out.println("Empty");
        }
    }

    public void postOrder() {
        if (this.root != null) {
            this.root.postOrder();
        } else {
            System.out.println("Empty");
        }
    }

    // search
    public BTNode preOrderSearch(int id) {
        if (root != null) {
            return root.preOrderSearch(id);
        } else {
            return null;
        }
    }

    public void delNode(int id) {
        if (root != null) {
            if (root.getId() == id) {
                root = null;
            } else {
                root.delNode(id);
            }
        } else {
            System.out.println("Empty");
        }
    }
}

class BTNode {
    private int id;
    private int data;
    private BTNode left;
    private BTNode right;

    // false--child, true--pre
    private boolean leftType;
    // false--child, true--post
    private boolean rightType;

    public BTNode(int id, int data) {
        this.id = id;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void preOrder() {
        System.out.println(this);
        if (this.left != null) this.left.preOrder();
        if (this.right != null) this.right.preOrder();
    }

    public void infixOrder() {
        if (this.left != null) this.left.infixOrder();
        System.out.println(this);
        if (this.right != null) this.right.infixOrder();
    }

    public void postOrder() {
        if (this.left != null) this.left.postOrder();
        if (this.right != null) this.right.postOrder();
        System.out.println(this);
    }

    // search
    public BTNode preOrderSearch(int id) {
        if (this.id == id) {
            return this;
        }

        BTNode res = null;
        // left
        if (this.left != null) {
            res = this.left.preOrderSearch(id);
        }
        if (res != null) {
            return res;
        }

        // right
        if (this.right != null) {
            res = this.right.preOrderSearch(id);
        }
        return res;
    }

    // delete node or tree
    public boolean delNode(int id) {
        if (this.left != null && this.left.id == id) {
            this.left = null;
            return true;
        }
        if (this.right != null && this.right.id == id) {
            this.right = null;
            return true;
        }
        if (this.left != null) {
            boolean res = this.left.delNode(id);
            if (res) return true;
        }
        if (this.right != null) {
            boolean res = this.right.delNode(id);
            if (res) return true;
        }
        return false;
    }
}