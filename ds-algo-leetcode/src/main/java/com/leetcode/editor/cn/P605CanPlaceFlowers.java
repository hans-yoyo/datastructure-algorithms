//假设有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花不能种植在相邻的地块上，它们会争夺水源，两者都会死去。 
//
// 给你一个整数数组 flowerbed 表示花坛，由若干 0 和 1 组成，其中 0 表示没种植花，1 表示种植了花。另有一个数 n ，能否在不打破种植规则
//的情况下种入 n 朵花？能则返回 true ，不能则返回 false。 
//
// 
//
// 示例 1： 
//
// 
//输入：flowerbed = [1,0,0,0,1], n = 1
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：flowerbed = [1,0,0,0,1], n = 2
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= flowerbed.length <= 2 * 104 
// flowerbed[i] 为 0 或 1 
// flowerbed 中不存在相邻的两朵花 
// 0 <= n <= flowerbed.length 
// 
// Related Topics 贪心算法 数组 
// 👍 343 👎 0


package com.leetcode.editor.cn;

import java.util.Arrays;

/*
 * Java：种花问题
 */
public class P605CanPlaceFlowers {
    public static void main(String[] args) {
        Solution solution = new P605CanPlaceFlowers().new Solution();
        // TO TEST
        System.out.println(solution.canPlaceFlowers(new int[]{1, 0, 1, 0, 1, 0}, 1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canPlaceFlowers(int[] flowerbed, int n) {
            int len = flowerbed.length;
            int[] flowerbedNew = new int[len + 2];
            // 在头尾补0, 避免边界问题判断
            System.arraycopy(flowerbed, 0, flowerbedNew, 1, len);
            System.out.println(Arrays.toString(flowerbedNew));
            for (int i = 1; i < len + 1; i++) {
                if (flowerbedNew[i - 1] == 0 && flowerbedNew[i] == 0 && flowerbedNew[i + 1] == 0) {
                    flowerbedNew[i] = 1;
                    n--;
                }
            }
            System.out.println(Arrays.toString(flowerbedNew));
            return n <= 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}