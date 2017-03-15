package hackerrank.crackingthecodinginterview.algorithms;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by vranjesluka on 15/03/2017.
 */
public class C6_BFSShortestReachInAGraph {

    private static final int DEFAULT_EDGE_LENGTH = 6;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int numberOfQueries = in.nextInt();
        for (int i = 0; i < numberOfQueries; i++) {
            int numberOfNodes = in.nextInt();
            int numberOfEdges = in.nextInt();
            int[][] edges = new int[numberOfEdges][2];
            for (int edgeIndex = 0; edgeIndex < numberOfEdges; edgeIndex++) {
                edges[edgeIndex][0] = in.nextInt() - 1;
                edges[edgeIndex][1] = in.nextInt() - 1;
            }
            int startingNodeIndex = in.nextInt() - 1;

            int[] distances = calculateDistancesToEverybody(numberOfNodes, numberOfEdges, edges, startingNodeIndex);
            printDistances(distances);
        }
    }

    private static int[] calculateDistancesToEverybody(int numberOfNodes, int numberOfEdges, int[][] edges, int startingNodeIndex) {
        int[] distances = new int[numberOfNodes - 1];
        for (int i = 0; i < distances.length; i++) {
            distances[i] = -1;
        }
        LinkedList<Integer> toVisit = new LinkedList<>();
        toVisit.add(startingNodeIndex);

        while (!toVisit.isEmpty()) {
            int currentNodeIndex = toVisit.removeFirst();
            for (int i = 0; i < numberOfEdges; i++) {
                if (edges[i][0] == currentNodeIndex) {
                    if (edges[i][1] == startingNodeIndex) {
                        continue;
                    }
                    int distanceIndex = getIndexInDistance(edges[i][1], startingNodeIndex);
                    if (distances[distanceIndex] <= 0) {
                        distances[distanceIndex] = getIncrementedDistance(distances, startingNodeIndex, currentNodeIndex);
                        toVisit.add(edges[i][1]);
                    }
                } else if (edges[i][1] == currentNodeIndex) {
                    if (edges[i][0] == startingNodeIndex) {
                        continue;
                    }
                    int distanceIndex = getIndexInDistance(edges[i][0], startingNodeIndex);
                    if (distances[distanceIndex] <= 0) {
                        distances[distanceIndex] = getIncrementedDistance(distances, startingNodeIndex, currentNodeIndex);
                        toVisit.add(edges[i][0]);
                    }
                }
            }
        }
        return distances;
    }

    private static int getIncrementedDistance(int[] distances, int startingNodeIndex, int currentNodeIndex) {
        if (currentNodeIndex == startingNodeIndex) {
            return DEFAULT_EDGE_LENGTH;
        }
        int distanceIndex = getIndexInDistance(currentNodeIndex, startingNodeIndex);
        return distances[distanceIndex] + DEFAULT_EDGE_LENGTH;
    }

    private static int getIndexInDistance(int otherIndex, int startingNodeIndex) {
        return otherIndex < startingNodeIndex ? otherIndex : otherIndex - 1;
    }

    private static void printDistances(int[] distances) {
        for (int distance : distances) {
            System.out.print(distance + " ");
        }
        System.out.println();
    }
}
