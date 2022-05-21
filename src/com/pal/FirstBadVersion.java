package com.pal;

/**
 * You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.
 *
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
 *
 * You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.
 * Example:
 * n = 2126753390
 * first version = 1702766719
 */
public class FirstBadVersion {

    public long firstBadVersion(long n) {
        long left = 1;
        long right = n;

        while(left<right){
            long mid = (left + right)/2;
            if(isBadVersion(mid)){
                right=mid;
            }else{
                left=mid+1;
            }
        }

        return left;
    }

    public boolean isBadVersion(long n){
        if(n >= 1702766719)
            return true;
        else
            return false;
    }

    public static void main(String args[]){
        FirstBadVersion s = new FirstBadVersion();
        System.out.println("First bad version="+s.firstBadVersion(2126753390));
    }
}