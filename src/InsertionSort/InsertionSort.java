package InsertionSort;

import java.util.Scanner;

public class InsertionSort
{
    public static void InsertionSort(int arr[],int n)
    {
        for(int i=1;i<n;i++)
        {
            int temp = arr[i];
            int j = i-1;
            while(j>-1 && temp<arr[j])
            {
                arr[j+1] = arr[j];
                arr[j] = temp;
                j--;
            }
        }
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i] = sc.nextInt();
        }

        InsertionSort(arr,n);
        for(int i=0;i<n;i++)
        {
            System.out.print(arr[i]+" ");
        }
    }
}
