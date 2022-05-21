In base -2, integers are represented by sequences of bits in the following way.
Bits are ordered from the least to the most significant. Sequence B of N bits represents the number:
sum{ B[i]*(-2)^i for i = 0..N-1}. The empty sequence represents 0. For example:

100111 represents -23
001011 represents -12
10011 represents 9
001 represents 4,
because:

| 1 | -2 | 4 | -8 | 16 | -32 | ... |
|---|----|---|----|----|-----|-----|
| 1 | 0  | 0 | 1  | 1  | 1   |     | = 1 + 0 + 0
+ (-8) + 16 + (-32) = -23
| 0 | 0  | 1 | 0  | 1  | 1   |     | = 0 + 0 + 4
+  0   + 16 + (-32) = -12
| 1 | 0  | 0 | 1  | 1  |     |     | = 1 + 0 + 0
+ (-8) + 16         =  9
| 0 | 0  | 1 |    |    |     |     | = 0 + 0 + 4

Note that such a representation is suitable for both positive and negative integers

Write a function:

       class Solution {
            public int[] solution (int[] A. int [] B);
       }

that, given two arrays of bits:
    -- A of length M,containing a sequence representing some integer X, and
    -- B of length N, containing a sequence representing some integer Y,
returns the shortest sequence of bits representing X+Y.

Result array should be returned as an array of integers.

For example, given
A = [0,1,1,0,0,1,0,1,1,1,0,1,0,1,1,] (X = 5730) and B = [0,0,1,0,0,1,1,1,1,1,0,1] (Y = -2396), the function
should return [0,1,0,1,1,0,0,0,1,0,1,1,1] (X+Y = 3334)

Write an efficient algorithm for the following assumptions:
    -- M and N are integers within the range [0.. 100,000];
    -- each element of array A is an integer that can have one of the following values: 0,1;
    -- each element of array B is an integer that can have one of the following values: 0,1
