/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length == 0){
            return null;
        }
        int length = preorder.length;
        Map<Integer, Integer> indexMap = new HashMap<>();
        //将中序遍历得到的数组的值和他们所在的位置组成键值对放入HashMap中
        for(int i=0; i<length; ++i){
            indexMap.put(inorder[i],i);
        }
        TreeNode root = buildTree(preorder, 0, length-1, inorder, 0, length-1, indexMap)
        return root;

    }
    public TreeNode buildTree(int[] preorder, int preorderStart, int preorderEnd, int[] inorder, int inorderStart, int inorderEnd, Map<Integer,Integer> indexMap){
        if(preorderStart>preorderEnd){
            return null;
        }
        int rootVal = preorder[preorderStart];
        TreeNode root = new TreeNode(rootVal);
        if(preorderStart == preorderEnd){
            return root;
        }
        int rootIndex = indexMap.get(rootval);//获取根节点在中序遍历中的位置
        int leftNodes = rootIndex - inorderStart; //通过中序遍历获得左子树的数量；
        int rightNodes = inorderEnd - rootIndex;//通过中序遍历获得右子树的数量；
        //左子树的构建：输入前序遍历，左子树的节点在前序遍历中的起始位置；输入中序遍历，左子树在中序遍历中的起始位置；
        TreeNode leftSubTree = buildTree(preorder, preorderStart+1, preorderStart+leftNodes, inorder, inorderStart, index-1, indexMap);
        TreeNode rightSubTree = buildTree(preorder, preorderEnd-rightNodes+1, preorderEnd, inorder, rootIndex+1,inorderEnd, indexMap);
        root.left = leftSubTree;
        root.right = rightSubTree;
        return root;


    }
}