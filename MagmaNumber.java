package SeptemberChallange;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MagmaNumber {
    static int multiplier = 1;
    static int numberOfMagmaNumbers = 0;
    static int count = 0;

    static int findCube(int x) {
        return x * x * x;
    }
    static List<Integer> cubeList = new ArrayList<>();

    public static void main(String[] args) {

        List<Integer> countmagma = new ArrayList<>();
        List<Integer> reduceList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int numberOfTestCases = sc.nextInt();
            //making cube List
        for (int i = 0; i < numberOfTestCases; i++) {
            int numberLimit = sc.nextInt();
            count = 0;
            IntStream.rangeClosed(1, numberLimit).forEach(n->{
                if(findCube(n)<=numberLimit){
                    cubeList.add(findCube(n));
                }
            });
            for(int j=1;j<cubeList.size();j++){
                for(int k=1;k<numberLimit/2;k++){
                    if(cubeList.get(j)*k<=numberLimit){
                        numberOfMagmaNumbers++;
                    }
                }
                countmagma.add(numberOfMagmaNumbers);
                numberOfMagmaNumbers=0;
            }
            cubeList = new ArrayList<>();
            reduceList.add(countmagma.stream().reduce(0, (a, b) -> a + b));
            countmagma= new ArrayList<>();
            if(reduceList.size() == numberOfTestCases) {
                reduceList.forEach(System.out::println);
            }
        }

    }
}
//n -> {
//
//        for (int x = 2; ; x++) {
//        if (x * x * x * 1 > numberLimit) {
//        break;
//        }
//        for (int y = 1; ; y++) {
//        if (x * x * x * y == n) {
//        count++;
//        } else if (x * x * x * y > n) {
//        break;
//
//        }
//        }
//        }
//        }