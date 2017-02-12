package codility;

import java.util.*;

/**
 * Created by vranjesluka on 04/02/2017.
 */
public class Amazon2_CitiesAtDistance {

    public int[] solution(int[] T) {
        // write your code in Java SE 8
        int[] citiesAtDistance = new int[T.length - 1];
        Map<Integer, Set<Integer>> neighbours = new HashMap<>();
        int capital = 0;
        for (int i = 0; i < T.length; i++) {
            if (i == T[i]) {
                capital = i;
            } else {
                Set<Integer> neighboursOfI;
                if (neighbours.containsKey(i)) {
                    neighboursOfI = neighbours.get(i);
                } else {
                    neighboursOfI = new HashSet<>();
                }
                neighboursOfI.add(T[i]);
                neighbours.put(i, neighboursOfI);

                Set<Integer> neighboursOfTi;
                if (neighbours.containsKey(T[i])) {
                    neighboursOfTi = neighbours.get(T[i]);
                } else {
                    neighboursOfTi = new HashSet<>();
                }
                neighboursOfTi.add(i);
                neighbours.put(T[i], neighboursOfTi);
            }
        }
        Set<Integer> citiesAtDistanceI = neighbours.get(capital);
        Set<Integer> citiesAtLastDistance = new HashSet<>();
        citiesAtLastDistance.add(capital);
        for (int i = 0; i < T.length - 1; i++) {
            citiesAtDistance[i] = citiesAtDistanceI.size();
            Set<Integer> citiesAtNextDistance = new HashSet<>();
            for (int city : citiesAtDistanceI) {
                citiesAtNextDistance.addAll(neighbours.get(city));
            }
            for (int city : citiesAtLastDistance) {
                citiesAtNextDistance.remove(city);
            }
            citiesAtLastDistance = citiesAtDistanceI;
            citiesAtDistanceI = citiesAtNextDistance;

        }
        return citiesAtDistance;
    }

    public static void main(String[] args) {
        Amazon2_CitiesAtDistance solution = new Amazon2_CitiesAtDistance();
        System.out.println(Arrays.toString(solution.solution(new int[]{9, 1, 4, 9, 0, 4, 8, 9, 0, 1})));
    }
}
