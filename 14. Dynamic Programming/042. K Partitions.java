import java.util.*;

// NADOS: https://nados.io/question/k-partitions?zen=true

class Main {
    public static ArrayList<ArrayList<Integer>> deepCopy(ArrayList<ArrayList<Integer>> arr) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            ArrayList<Integer> room = new ArrayList<>();
            for (int j = 0; j < arr.get(i).size(); j++) {
                room.add(arr.get(i).get(j));
            }
            res.add(room);
        }
        return res;
    }

    // All Ways -> All Rooms -> All Persons
    public static ArrayList<ArrayList<ArrayList<Integer>>> solution(int currPerson, int n, int k) {
        ArrayList<ArrayList<ArrayList<Integer>>> resWays = new ArrayList<>();

        if (n < k || k <= 0) {
            return resWays;
        }

        if (currPerson == n) {
            if (k == 1) {
                resWays.add(new ArrayList<>());
                resWays.get(0).add(new ArrayList<>());
                resWays.get(0).get(0).add(currPerson);
            }
            return resWays;
        }

        // Share with Remaining People
        ArrayList<ArrayList<ArrayList<Integer>>> ways1 = solution(currPerson + 1, n, k);

        for (ArrayList<ArrayList<Integer>> way : ways1) {
            for (int i = 0; i < way.size(); i++) {
                ArrayList<ArrayList<Integer>> newWay = deepCopy(way);
                newWay.get(i).add(0, currPerson);
                resWays.add(newWay);
            }
        }

        // Private New Room
        ArrayList<ArrayList<ArrayList<Integer>>> ways2 = solution(currPerson + 1, n, k - 1);

        for (ArrayList<ArrayList<Integer>> way : ways2) {
            ArrayList<ArrayList<Integer>> newWay = deepCopy(way);
            ArrayList<Integer> newRoom = new ArrayList<>();
            newRoom.add(currPerson);
            newWay.add(0, newRoom);
            resWays.add(newWay);
        }

        return resWays;

    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        ArrayList<ArrayList<ArrayList<Integer>>> ways = solution(1, n, k);

        for (int i = 0; i < ways.size(); i++) {
            System.out.print((i + 1) + ". ");

            ArrayList<ArrayList<Integer>> way = ways.get(i);
            for (int j = 0; j < way.size(); j++) {
                System.out.print(way.get(j) + " ");
            }

            System.out.println();
        }

    }

}