import java.util.*; // Collection Frameworks

class Main {
    public static void main(String[] args) {
        HashMap<String, Integer> ipl = new HashMap<>();

        // Put / Insert
        ipl.put("Chennai", 4);
        ipl.put("Mumbai", 5);
        ipl.put("Gujarat", 1);
        ipl.put("Kolkata", 2);
        ipl.put("Hyderabad", 2);
        ipl.put("Rajasthan", 1);
        System.out.println(ipl);

        // Update
        ipl.put("Chennai", 5);
        System.out.println(ipl);

        // Get
        System.out.println(ipl.get("Mumbai")); // Key is present -> Value return
        System.out.println(ipl.get("Delhi")); // Key is not present -> Value = null
        System.out.println(ipl.getOrDefault("Mumbai", 0)); // Key is presnet -> Value
        System.out.println(ipl.getOrDefault("Delhi", 0)); // If Key not Present -> Default

        // Remove or Delete
        // If Key is Found, Get Along with Delete Key-Value Pair
        int trophies = ipl.remove("Rajasthan");
        System.out.println(trophies);
        System.out.println(ipl);

        // If Key is not Found, Get -> null, No Deletion
        Integer trophies2 = ipl.remove("Delhi");
        System.out.println(trophies2);
        System.out.println(ipl);

        // Check if Key is Present or not -> containsKey
        System.out.println(ipl.containsKey("Chennai")); // If Key is Present -> True
        System.out.println(ipl.containsKey("Delhi")); // If Key is Present -> False

        // Length or Size of Hashmap -> Count of Key-Value Pairs
        System.out.println(ipl.size()); // Number of Keys

        // Traverse or Iterate or Hashmap => keySet
        for (String team : ipl.keySet()) {
            System.out.println("Key : " + team + " = Value : " + ipl.get(team));
        }

    }
}