package T105;

import Objects.TreeNode;

import java.util.HashMap;
import java.util.Map;

//给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历，
//inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
//
//示例 1:
//输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//输出: [3,9,20,null,null,15,7]
//
//示例 2:
//输入: preorder = [-1], inorder = [-1]
//输出: [-1]
public class Solution {
    Map<Integer,Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0) return null;
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return findNode(preorder,0,preorder.length,inorder,0,inorder.length);
    }
    public TreeNode findNode(int[] preorder,int preBegin,int preEnd, int[] inorder,int inBegin,int inEnd){
        if(preBegin>=preEnd||inBegin>=inEnd) return null;
        //先序遍历的第一个元素为根节点
        //找到该元素在中序遍历中的位置
        int rootIndex = map.get(preorder[preBegin]);
        //创建节点
        TreeNode root = new TreeNode(preorder[preBegin]);
        //左右遍历构造
        int lenOfLeft = rootIndex - inBegin;//左子树的长度
        root.left = findNode(preorder, preBegin + 1, preBegin + 1 + lenOfLeft,inorder, inBegin, rootIndex);
        root.right = findNode(preorder, preBegin + 1 + lenOfLeft, preEnd,inorder, rootIndex + 1, inEnd);
        //返回
        return root;
    }
}
