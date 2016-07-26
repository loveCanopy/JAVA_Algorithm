/*查找两个有序数组的公共元素*/
#include<stdio.h>
#include<stdlib.h>

void findCommon1(int *arr1, int *arr2, int len1, int len2);
void findCommon2(int *arr1, int *arr2, int len1, int len2);



int main()
{
    int arr1[10] = {1,2,3,4,5,6,7,8,9,10};
    int arr2[5] = {1,3,5,7,9};

    findCommon2(arr1,arr2,10,5);

    return 0;
}

//时间复杂度为O(len1*len2)
void findCommon1(int *arr1, int *arr2, int len1, int len2)
{
    int i, j;
    i = j = 0;
    while(i < len1 && j < len2)
    {
        if(arr1[i] == arr2[j])
        {
            printf("%3d",arr1[i]);
            i++;
            j++;
        }
        else
            arr1[i] > arr2[j] ? j++ : i++;
    }
    printf("\n");
}

//对数组2进行二分查找，时间复杂度为O(len1*lg(len2))
void findCommon2(int *arr1, int *arr2, int len1, int len2)
{
    int i, low, mid, high;
    for(i = 0; i < len1; i++)
    {
        low = 0;
        high = len2 - 1;
        while(low <= high)
        {
            mid = low + (high-low) / 2;
            if(arr1[i] == arr2[mid])
            {
                printf("%3d",arr1[i]);
                break;
            }
            else
                arr1[i] < arr2[mid] ? (high = mid - 1) : (low = mid + 1);
        }
    }//end for()
}