package SelectionSort;

import java.util.Scanner;

public class selectionsort
{
    public static void selectionsort(int arr[],int n)
    {
        for(int i=0;i<n;i++)
        {
            int minIndex=i;
            for(int j=i+1;j<n;j++)
            {
                if(arr[j]<arr[minIndex])
                {
                    minIndex=j;
                }
            }
            if(i!=minIndex)
            {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
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

        selectionsort(arr,n);
        for(int i=0;i<n;i++)
        {
            System.out.print(arr[i]+" ");
        }
    }
}
