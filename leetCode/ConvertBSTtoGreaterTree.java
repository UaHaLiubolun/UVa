package UVa.leetCode;

public class ConvertBSTtoGreaterTree {

    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        convert(root);
        return root;
    }

    public void convert(TreeNode node) {
        if (node == null) return;

        convert(node.right);
        node.val += sum;
        sum = node.val;
        convert(node.left);
    }
}
