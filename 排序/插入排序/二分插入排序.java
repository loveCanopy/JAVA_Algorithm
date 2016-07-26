package com.sort;
二分法插入排序的思想和直接插入一样，只是找合适的插入位置的方式不同，这里是按二分法找到合适的位置，可以减少比较的次数。

    private static void sort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int temp = a[i];
            int left = 0;
            int right = i-1;
            int mid = 0;
            while(left<=right){
                mid = (left+right)/2;
                if(temp<a[mid]){
                    right = mid-1;
                }else{
                    left = mid+1;
                }
            }
            for (int j = i-1; j >= left; j--) {
                a[j+1] = a[j];
            }
            if(left != i){
                a[left] = temp;
            }
        }
    }
