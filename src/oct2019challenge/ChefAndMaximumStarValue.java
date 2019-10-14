package oct2019challenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChefAndMaximumStarValue {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine().trim());
        for(int t = 0; t < testCases ; t++){
            int N = Integer.parseInt(reader.readLine().trim());
            String[] arrayStr = reader.readLine().trim().split(" ");
            int[] array = new int[N];
            for(int i = 0; i < N; i++){
                array[i] = Integer.parseInt(arrayStr[i].trim());
            }

        }

    }
}
