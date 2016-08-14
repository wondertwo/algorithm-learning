package me.wondertwo.lee102;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 层序遍历二叉树，分层打印
 *
 * Created by wondertwo on 2016/8/14.
 */
public class Solution {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        levelHelper(result, root, 0);
        return result;
    }

    private void levelHelper(List<List<Integer>> res, TreeNode root, int height) {
        if (root == null) return;
        if (height >= res.size()) res.add(new LinkedList<>());
        levelHelper(res, root.left, height+1);
        levelHelper(res, root.right, height+1);
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
