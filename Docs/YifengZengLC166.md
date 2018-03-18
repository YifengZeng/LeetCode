# **LeetCode 166**
https://leetcode.com/problems/fraction-to-recurring-decimal/description/

Yifeng Zeng

# Description
[166. Fraction to Recurring Decimal](https://leetcode.com/problems/fraction-to-recurring-decimal/description/)

Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

If the fractional part is repeating, enclose the repeating part in parentheses.

For example,

Given numerator = 1, denominator = 2, return "0.5".

Given numerator = 2, denominator = 1, return "2".

Given numerator = 2, denominator = 3, return "0.(6)".


# Idea Report

This is a step by step problem. If the quotient is less that 0, we append a '-' to the begining. And we append the integral part then we handle the decimal part. To handle the recurring decimal, we need store each remainder we encountered, if we encouter the same remainder again, that means we have the recurring decimal. When storing each remainder, we also need to store where it starts, just in order to put the left parentheses if we need to.

Code
```java
class Solution {

    public String fractionToDecimal(int numerator, int denominator) {
        if (denominator == 0) {
            return "INF";
        }
        if (numerator == 0) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        if ((numerator < 0) ^ (denominator < 0)) {
            sb.append("-");
        }

        long a = Math.abs((long) numerator);
        long b = Math.abs((long) denominator);
        sb.append(a / b);
        a = a % b;
        if (a == 0) {
            return sb.toString();
        }

        sb.append(".");
        Map<String, Integer> map = new HashMap<>();
        map.put(a + "", sb.length());
        a *= 10;

        while (a != 0) {
            long quotient = a / b;
            long remainder = a % b;
            sb.append(quotient + "");
            if (map.containsKey(remainder + "")) {
                sb.insert(map.get(remainder + ""), "(");
                sb.append(")");
                break;
            }
            map.put(remainder + "", sb.length());
            a = remainder * 10;
        }


        return sb.toString();
    }
}
```

# Summary
- First define the steps, and then code those step by step.
