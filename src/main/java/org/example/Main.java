package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.ParseException;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static int getMinimizeHeights(int arr[], int n, int k)
    {
        if (n == 1)


main
        test-branch-2
                222
            return 0;
        Arrays.sort(arr);
        int diff = arr[n-1] - arr[0];
        int minimum = arr[0] + k;
        int maximum = arr[n-1] - k;
        int temp = 0;
        if (minimum > maximum)
        {
            temp = minimum;
            minimum = maximum;
            maximum = temp;
        }
        for (int i = 1; i < n-1; i ++)
        {
            int difference = arr[i] - k;
            int sum = arr[i] + k;
            if (difference >= minimum || sum <= maximum)
                continue;
            if (maximum - difference <= sum - minimum)
                minimum = difference;
            else
                maximum = sum;
        }
        return Math.min(diff, maximum - minimum);
    }
    public static void main(String[] args)
    {
        IntStream.of(1,2,3,4,5).max();
    }

    public static void msg(String m) {
        m = m + "qwq";
    }

    public static TreeNode deserialize(String data) {
        System.out.println(data);
        String[] strs = data.split("#");
        return deserialize(strs, Integer.parseInt("0"));
    }

    static Integer index;

    private static TreeNode deserialize(String[] strs, Integer index) {
        if(strs[index].equals("@")) {
            index++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(strs[index++]));
        node.left = deserialize(strs, index++);
        node.right = deserialize(strs, index++);
        return node;
    }

    public static int coinChange(int[] coins, int amount) {
        return dfs(coins, amount, 0);
    }

    private static int dfs(int[] coins, int amount, int count) {
        if(amount == 0) {
            return count;
        }
        if(amount < 0) {
            return Integer.MAX_VALUE;
        }
        Long min = Long.MAX_VALUE;
        for(int coin : coins) {
            min = Math.min(min, dfs(coins, amount - coin, count + 1));
        }
        return min.intValue();
    }



    public static boolean canJump(int[] nums) {
        boolean[] dp = new boolean[nums.length];
        dp[nums.length - 1] = true;
        int cur = nums.length - 1;
        for(int i = nums.length - 2; i >= 0; i--) {
            if(nums[i] >= cur - i) {
                dp[i] = true;
                cur = i;
            }
        }
        return dp[0];
    }

    private static boolean dfs(int[] nums, int i) {
        if(i >= nums.length - 1) {
            return true;
        }
        for(int j = nums[i]; j > 0; j--) {
            if(dfs(nums, i + j)) {
                return true;
            }
        }
        return false;
    }

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate(0, 0, n, result, "");
        return result;
    }

    private static void generate(int opened, int closed, int n, List<String> result, String s) {
        if(opened + closed == n + n) {
            result.add(s);
            return;
        }
        if(opened < n) {
            generate(opened + 1, closed, n, result, s + "(");
        }
        if(closed < n && closed < opened) {
            generate(opened, closed + 1, n, result, s + ")");
        }
    }

    static int i = 0;
    public static int kthSmallest(TreeNode root, int k) {
        TreeNode n = dfs(root, k);
        if(n != null) {
            return n.val;
        }
        return 0;
    }

    private static TreeNode dfs(TreeNode node, int k) {
        if(node.left != null) {
            TreeNode n = dfs(node.left, k);
            if(n != null) {
                return n;
            }
        }

        i++;
        if(i == k) {
            return node;
        }

        if(node.right != null) {
            TreeNode n = dfs(node.right, k);
            if(n != null) {
                return n;
            }
        }

        return null;


    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++)
            map.put(inorder[i], i);
        return splitTree(preorder, map, 0, 0, inorder.length-1);
    }

    private static TreeNode splitTree(int[] preorder, Map<Integer, Integer> map, int pix, int iLeft, int iRight) {
        int rVal = preorder[pix];
        int iMid = map.get(rVal);
        TreeNode root = new TreeNode(rVal);
        if (iMid > iLeft)
            root.left = splitTree(preorder, map, pix+1, iLeft, iMid-1);
        if (iMid < iRight)
            root.right = splitTree(preorder, map, pix+iMid-iLeft+1, iMid+1, iRight);
        return root;
    }

    public static ListNode oddEvenList(ListNode head) {
        if(head == null) {
            return head;
        }
        if(head.next == null || head.next.next == null) {
            return head;
        }
        ListNode res = head;
        ListNode slow = head;
        ListNode fast = head.next.next;
        ListNode temp = null;
        while(fast != null) {
            if(fast.next != null) {
                temp = fast.next;
            }
            ListNode t = slow.next;
            t.next = fast.next;
            fast.next = t;
            slow.next = fast;
            fast = temp;
            if(fast == null || fast.next == null) {
                break;
            }
            fast = fast.next;
            slow = slow.next;
        }


        return res;
    }

    public static int characterReplacement(String s, int k) {
        int left = 0;
        int right = 0;

        int max = 0;
        Set<Character> set = new HashSet<>();
        while(right < s.length()) {
            if(s.charAt(left) != s.charAt(right)) {
                set.add(s.charAt(right));
                if(set.size() > k) {
                    set.remove(s.charAt(left));
                    left++;
                    continue;
                }
            }
            right++;
            max = Math.max(max, right - left);
        }

        return Math.max(max, right - left);
    }

    public static boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> map1 = new HashMap<>();
        for(char c : s1.toCharArray()) {
            if(!map1.containsKey(c)) {
                map1.put(c, 1);
            } else {
                map1.put(c, map1.get(c) + 1);
            }
        }

        Map<Character, Integer> map2 = new HashMap<>();
        for(int i = 0; i < s1.length(); i++) {
            if(!map2.containsKey(s2.charAt(i))) {
                map2.put(s2.charAt(i), 1);
            } else {
                map2.put(s2.charAt(i), map2.get(s2.charAt(i)) + 1);
            }
        }

        int left = 0;
        while(left + s1.length() - 1 < s2.length()) {
            if(map1.equals(map2)) {
                return true;
            }
            map2.put(s2.charAt(left), map2.get(s2.charAt(left)) - 1);
            if(map2.get(s2.charAt(left)) == 0) {
                map2.remove(s2.charAt(left));
            }
            left++;
            int index = left + s1.length() - 1;
            if(!map2.containsKey(s2.charAt(index))) {
                map2.put(s2.charAt(index), 1);
            } else {
                map2.put(s2.charAt(index), map2.get(s2.charAt(index)) + 1);
            }
        }
        return false;
    }

    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        int[] sum = new int[nums.length + 1];
        sum[0] = 0;
        for (int i = 1; i <= nums.length; i++)
            sum[i] = sum[i - 1] + nums[i - 1];
        for (int start = 0; start < nums.length; start++) {
            for (int end = start + 1; end <= nums.length; end++) {
                if (sum[end] - sum[start] == k)
                    count++;
            }
        }
        return count;
    }

    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;
        int prod = 1, ans = 0, left = 0;
        for (int right = 0; right < nums.length; right++) {
            prod *= nums[right];
            while (prod >= k) prod /= nums[left++];
            ans += right - left + 1;
        }
        return ans;
    }

}
