//2021-5-31
//Power of four/Easy

//Given an integer n, return true if it is a power of four. Otherwise, return false.
//An integer n is a power of four, if there exists an integer x such that n == 4x.

//来源：LeetCode
//链接：https://leetcode-cn.com/problems/power-of-four


class PowerOfFour {
    public boolean isPowerOfFour(int n) {
        //if < 0, then false
        if (n < 0) return false;

        //n 如果是 4 的幂，那肯定是 2 的幂，所以先求解n & (n - 1)（删掉 n 的二进制表示最右边的 1 ），
        //判断是否为 0 ，不为 0 ，返回false， 否则 n 是 2 的幂，调到第三步。
        if((n & (n - 1)) != 0) return false;

        // 这个时候只需判断 n 最右边的 1 是否在奇数位置，通过 n 向右移位操作，用 cnt 记数，判断 cnt 的奇偶性既可。
        //如果 n 是 4 的幂，那么 n 的二进制表示中有且仅有一个 1，并且这个 1 出现在从低位开始的第偶数个二进制位上
        //（这是因为这个 1 后面必须有偶数个 0）

        int cnt = 0;
        while(n != 0) {
            n >>= 1;
            cnt++;
        }
        return cnt % 2 == 1;


    }

    public static void main(String[] args) {
        PowerOfFour p = new PowerOfFour();
        System.out.println(p.isPowerOfFour(16));
        System.out.println(p.isPowerOfFour(-5));
        System.out.println(p.isPowerOfFour(29));

    }
}
