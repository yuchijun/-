//非递归实现
//[1,null,2,3]
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

 //中序
Class Solution{
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList <>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while(curr != null || !stack.isEmpty()){
            while(curr != null){
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop(curr); //先遍历完每一个小树，每一颗小树是左中右
            res.add(curr);
            curr = curr.right;
        }
        return res;
    }
}

//递归实现
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList();
        inOrderVisit(root, res);
        return res;
    }
    public void inOrderVisit(TreeNode root, List res){
        if(root == null){
            return ;
        }
        inOrderVisit(root.left, res); //每一颗小树的左中右
        res.add(root.val);
        inOrderVisit(root.right, res);
    }
}

//前序
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(root != null){
            TreeNode curr = stack.pop();
            res.add(curr.val);
            if(curr.right != null){
                stack.push(curr.right);
            }
            if(curr.left != null){
                stack.push(curr.left);
            }
        }
        return res;
    }
}

//后序 需要用两个栈来实现
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        stack1.push(root);
        while(!stackl.isEmpty()){
            TreeNode curr = stack1.pop();
            stack2.push(curr);
            if(curr.left != null){
                stack1.push(curr.left);
            }
            if(curr.right != null){
                stack1.push(curr.right);
            }
        }
        while(!stack2.isEmpty()){
            TreeNode fin = stack2.pop();
            res.add(fin.val);
        }
        return res;
    }
