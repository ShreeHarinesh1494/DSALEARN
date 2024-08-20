package MergeSort;

import java.util.Arrays;
import java.util.Scanner;

public class Merge
{
    public static int[] merge(int arr1[],int arr2[],int n)
    {
        int combined[] = new int[arr1.length+arr2.length];
        int index=0;
        int i=0;
        int j=0;

        while(i<n && j<n)
        {
            if(arr1[i]<arr2[j])
            {
                combined[index] = arr1[i];
                index++;
                i++;
            }
            else
            {
                combined[index] = arr2[j];
                index++;
                j++;
            }
        }
        while(i<arr1.length)
        {
            combined[index] = arr1[i];
            index++;
            i++;
        }

        while(j<arr2.length)
        {
            combined[index] = arr2[j];
            index++;
            j++;
        }

        return combined;
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr1[] = new int[n];
        int arr2[] = new int[n];
        for(int i=0;i<n;i++)
        {
            arr1[i] = sc.nextInt();
        }

        for(int i=0;i<n;i++)
        {
            arr2[i] = sc.nextInt();
        }

        System.out.println(Arrays.toString(merge(arr1, arr2, n)));

    }


}
