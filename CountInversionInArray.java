/**
 * ip: [2, 5, 1, 3, 4]
 * op: 4
 * explanation: i should be greater than j; i > j, then it is an inversion
 * (2, 1), (5, 1), (5, 3), (5, 4)
 */

public class CountInversionInArray {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 5, 1, 3, 4};

        int output = merge(arr, 0, arr.length - 1);
        System.out.println(output);
    }

    public static int sort(int[] arr, int l, int m, int h) {
        int[] temp = new int[h - l + 1];
        int k = 0;
        int count = 0;
        int left = l;
        int right = m + 1;
        while (left <= m && right <= h) {
            if (arr[left] <= arr[right]) {
                temp[k++] = arr[left++];
            } else {
                temp[k++] = arr[right++];
                count += (m - left) + 1;
            }
        }

        while (left <= m) {
            temp[k++] = arr[left++];
        }

        while (right <= h) {
            temp[k++] = arr[right++];
        }

        for (int i = l; i <= h; i++) {
            arr[i] = temp[i - l];
        }

        return count;
    }

    public static int merge(int[] arr, int l, int h) {
        int count = 0;
        if (l >= h) return count;
        int mid = l + (h - l)/2;
        count += merge(arr, l, mid);
        count += merge(arr, mid + 1, h);
        count += sort(arr, l, mid, h);
        return count;
    }

}
