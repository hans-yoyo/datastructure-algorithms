//给定一个由 4 位数字组成的数组，返回可以设置的符合 24 小时制的最大时间。 
//
// 24 小时格式为 "HH:MM" ，其中 HH 在 00 到 23 之间，MM 在 00 到 59 之间。最小的 24 小时制时间是 00:00 ，而最大
//的是 23:59 。从 00:00 （午夜）开始算起，过得越久，时间越大。 
//
// 以长度为 5 的字符串，按 "HH:MM" 格式返回答案。如果不能确定有效时间，则返回空字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：arr = [1,2,3,4]
//输出："23:41"
//解释：有效的 24 小时制时间是 "12:34"，"12:43"，"13:24"，"13:42"，"14:23"，"14:32"，"21:34"，"21:4
//3"，"23:14" 和 "23:41" 。这些时间中，"23:41" 是最大时间。
// 
//
// 示例 2： 
//
// 
//输入：arr = [5,5,5,5]
//输出：""
//解释：不存在有效的 24 小时制时间，因为 "55:55" 无效。
// 
//
// 示例 3： 
//
// 
//输入：arr = [0,0,0,0]
//输出："00:00"
// 
//
// 示例 4： 
//
// 
//输入：arr = [0,0,1,0]
//输出："10:00"
// 
//
// 
//
// 提示： 
//
// 
// arr.length == 4 
// 0 <= arr[i] <= 9 
// 
// Related Topics 数学 
// 👍 66 👎 0


package com.leetcode.editor.cn;

import java.util.Arrays;

/*
 * Java：给定数字能组成的最大时间
 */
public class P949LargestTimeForGivenDigits {
    public static void main(String[] args) {
        Solution solution = new P949LargestTimeForGivenDigits().new Solution();
        System.out.println(solution.largestTimeFromDigits(new int[]{1, 2, 3, 4}));
        System.out.println(solution.largestTimeFromDigits6(new int[]{0, 2, 3, 0, 5, 6}));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String largestTimeFromDigits(int[] arr) {
            // 先排序
            Arrays.sort(arr);
            // 升序，要找到最大的，所以逆向查找
            for (int i = 3; i >= 0; i--) {
                // i表示小时的十位数
                if (arr[i] > 2) {
                    continue;
                }
                for (int j = 3; j >= 0; j--) {
                    // j表示小时的个位数
                    if (j == i || arr[i] == 2 && arr[j] > 3) {
                        continue;
                    }
                    // k表示分钟的十位数
                    for (int k = 3; k >= 0; k--) {
                        if (k == i || k == j || arr[k] > 5) {
                            continue;
                        }
                        return "" + arr[i] + arr[j] + ":" + arr[k] + arr[6 - i - j - k];
                    }
                }
            }
            return "";
        }

        /**
         * @描述 输出：HH:mm:ss
         * @author Hans
         * @created 2021/04/18 20:16
         */
        public String largestTimeFromDigits6(int[] arr) {
            Arrays.sort(arr);
            for (int i = 5; i >= 0; i--) {
                // i表示小时的十位数
                if (arr[i] > 2) {
                    continue;
                }

                // j表示小时的个位数
                for (int j = 5; j >= 0; j--) {
                    if (j == i || arr[i] == 2 && arr[j] > 3) {
                        continue;
                    }

                    // k表示分钟的十位数
                    for (int k = 5; k >= 0; k--) {
                        if (k == i || k == j || arr[k] > 5) {
                            continue;
                        }

                        // l表示分钟的个位数
                        for (int l = 5; l >= 0; l--) {
                            if (l == i || l == j || l == k) {
                                continue;
                            }

                            // m表示秒十位数
                            for (int m = 5; m >= 0; m--) {
                                if (m == i || m == j || m == k || m == l || arr[m] > 5) {
                                    continue;
                                }
                                return "" + arr[i] + arr[j] + ":" + arr[k] + arr[l] + ":" + arr[m] + arr[15 - i - j - k - l - m];
                            }
                        }
                    }
                }
            }
            return "";
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}