package SortingAlgorithm;

import java.util.Arrays;

public class MainSorting {

    public static void main(String[] args) {

        int arr[]={5,3,6,1,9,20,-1,99};
        System.out.println(Arrays.toString(arr));
        QueckSort(arr , 0 , arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

/////////////////////////////////////////////////////////////////
    public static void bubleSort(int arr[]){

        for(int i=0 ; i<arr.length-1 ; i++){
            for(int j=0 ; j<arr.length-i-1 ; j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
///////////////////////////////////////////////////////////
    public static void selectionSort (int arr[]){

        for(int i=0 ; i<arr.length ; i++){
            int minIndex = i;
            for(int j=i+1 ; j<arr.length ; j++){
                if(arr[j]<arr[minIndex]){
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }
//////////////////////////////////////////////////////////////
    public static void InsershionSort(int arr[]){

        int key =0 , j=0;
        for(int i=1 ; i<arr.length ; i++){

            key = arr[i];
            j = i-1;

            while(j>=0 && arr[j]>key){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
            System.out.println(Arrays.toString(arr));
        }

    }
  ////////////////////////////////////////////////////////////////////////////
    public static void merageSort(int arr[] , int size){


        if(size<2){
            return ;
        }

        int mid = size/2;
        int L[] = new int[mid];
        int R[] = new int[size-mid];

        for(int i=0 ; i<mid ; i++){
            L[i] = arr[i];
        }

        for(int j=mid ; j<size ; j++){
            R[j-mid] = arr[j];
        }

        merageSort(L , mid);
        merageSort(R , size-mid);
        merage(arr , L , R , mid , size-mid);
    }

    public static void merage(int arr[] ,int L[] , int R[] , int left , int right){

        int i=0 , j=0 , k=0 ;

        while(i<left && j<right){
            if(L[i]<R[j]){
                arr[k]=L[i];
                i++;
            }
            else{
                arr[k]=R[j];
                j++;
            }
            k++;
        }
        while(i<left){
            arr[k]=L[i];
            i++;
            k++;
        }
        while(j<right){
            arr[k]=R[j];
            j++;
            k++;
        }
        System.out.println(Arrays.toString(arr));
    }
    //////////////////////////////////////////////////////////////////
    public static void QueckSort(int arr[] , int start , int end ) {

        if (start < end) {
            int loc = partishion(arr, start, end);
            QueckSort(arr, start, loc - 1);
            QueckSort(arr, loc + 1, end);
        }
    }
    public static int partishion(int arr[] , int start , int end){

        int pivot = arr[start];
        int i = start ;
        int j= end;

        while(i < j){

            while(arr[i] <= pivot){
                i++;
            }
            while(arr[j] > pivot){
                j--;
            }
            if(i<j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp =arr[start];
        arr[start] = arr[j];
        arr[j] = temp;
        System.out.println(Arrays.toString(arr));
        return j;
    }






}
