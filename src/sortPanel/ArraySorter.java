package sortPanel;

public class ArraySorter
{
    /*
    Collection of methods for array sorting
     */
    public static int[] bubbleSort(int[] array)
    {
        int n = array.length;
        int temp = 0;

        for(int i = 0; i <= n; i++)
        {
            for(int j = 1; j <= (n - 1); j++)
            {
                if (array[j - 1] > array [j])
                {
                    temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                }
            }
        }


        return array;
    }

    public static int[] quickSort(int[] array)
    {
        sort(array, 0, array.length-1);
        for(int i = 0; i < array.length; i++)
        {
            System.out.println(array[i] + " ");
        }
        return array;
    }

    private static int partition(int arr[], int low, int high)
    {
        int pivot = arr[high];
        int i = (low-1);
        for (int j=low; j<high; j++)
        {
            if (arr[j] <= pivot)
            {
                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i+1;
    }

    private static void sort(int arr[], int low, int high)
    {
        if (low < high)
        {
            int pi = partition(arr, low, high);

            sort(arr, low, pi-1);
            sort(arr, pi+1, high);
        }
    }
}
