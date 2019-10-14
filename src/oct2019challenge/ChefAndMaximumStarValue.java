package oct2019challenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ChefAndMaximumStarValue {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine().trim());
        for(int t = 0; t < testCases ; t++){
            int N = Integer.parseInt(reader.readLine().trim());
            String[] arrayStr = reader.readLine().trim().split(" ");

            int highestStars = 0;
            List<Node> nodeList = new ArrayList<>();
            Node firstNode = new Node();
            nodeList.add(firstNode);
                        int[] array = new int[N];
            array[0] = Integer.parseInt(arrayStr[0].trim());

            for(int currentIdx = 1; currentIdx < N; currentIdx++){
                array[currentIdx] = Integer.parseInt(arrayStr[currentIdx].trim());
                int prevIndex = currentIdx-1;

                Node currentNode = new Node();
                while(prevIndex >= 0){
                    Node prevNode =  nodeList.get(prevIndex);
                    if(array[prevIndex] % array[currentIdx] == 0){
                        currentNode.stars = prevNode.stars + 1;
                        for(Integer index : prevNode.nonDivisibleIndexes){
                            if(array[index] % array[currentIdx] == 0){
                                currentNode.stars = currentNode.stars + 1;
                            }else{
                                currentNode.nonDivisibleIndexes.add(index);
                            }
                        }
                        break;
                    }else{
                        currentNode.nonDivisibleIndexes.add(prevIndex);
                        prevIndex--;
                    }
                }
                nodeList.add(currentNode);
                if(highestStars < currentNode.stars){
                    highestStars = currentNode.stars;
                }
            }
            System.out.println(highestStars);
        }
    }
}

class Node{
    int stars;
    List<Integer> nonDivisibleIndexes = new ArrayList<>();
}
