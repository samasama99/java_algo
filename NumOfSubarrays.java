public class NumOfSubarrays {
    // MY Pure solution
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int sum = 0;
        int res = 0;

        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }

        for (int i = k; i < arr.length; i++) {

            // CHATGPT advice use multiplication instead of division
            if (sum / k >= threshold)
                res++;

            sum -= arr[i - k];
            sum += arr[i];
        }
        if (sum / k >= threshold)
            res++;
        return res;
    }
}
