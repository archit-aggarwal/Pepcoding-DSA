import java.io.*;
import java.util.*;

class Main {
    public static class Country implements Comparable<Country> {
        String name;
        int gold, silver, bronze;
        int total;

        Country() {
        }

        Country(String name, int gold, int silver, int bronze) {
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
            this.name = name;
            this.total = gold + silver + bronze;
        }

        @Override
        public int compareTo(Country other) {
            return other.gold - this.gold;
        }

        @Override
        public String toString() {
            return (name + " : " + gold + ", " + silver + ", " + bronze);
        }
    }

    public static class TotalMedalComparator implements Comparator<Country> {
        @Override
        public int compare(Country t, Country o) {
            return (o.gold + o.silver + o.bronze) - (t.gold + t.silver + t.bronze);
        }
    }

    public static class LexicographicalComparator implements Comparator<Country> {
        @Override
        public int compare(Country t, Country o) {
            return t.name.compareTo(o.name);
        }
    }

    public static class PriorityQueue<T> {
        ArrayList<T> data;
        Comparator comp;

        public PriorityQueue() {
            data = new ArrayList<>();
        }

        public PriorityQueue(Comparator comp) {
            data = new ArrayList<>();
            this.comp = comp;
        }

        public PriorityQueue(ArrayList<T> data) {
            this.data = data;
            for (int idx = (size() - 2) / 2; idx >= 0; idx--) {
                downheapify(idx);
            }
        }

        public boolean isSmaller(int ci, int pi) {
            if (comp == null) {
                Comparable obj1 = (Comparable) data.get(ci);
                Comparable obj2 = (Comparable) data.get(pi);

                if (obj1.compareTo(obj2) < 0) {
                    return true;
                }

                return false;
            } else {
                if (comp.compare(data.get(ci), data.get(pi)) < 0) {
                    return true;
                }

                return false;
            }
        }

        public void swap(int ci, int pi) {
            T temp = data.get(ci);
            data.set(ci, data.get(pi));
            data.set(pi, temp);
        }

        public void upheapify(int ci) {
            if (ci == 0)
                return;
            int pi = (ci - 1) / 2;

            if (isSmaller(ci, pi) == true) {
                swap(ci, pi);
                upheapify(pi);
            }
        }

        public void add(T val) {
            data.add(val);
            upheapify(data.size() - 1);
        }

        public void downheapify(int pi) {
            if (pi >= size())
                return;

            int min = pi;

            int li = 2 * pi + 1;
            if (li < size() && isSmaller(li, min) == true) {
                min = li;
            }

            int ri = 2 * pi + 2;
            if (ri < size() && isSmaller(ri, min) == true) {
                min = ri;
            }

            if (min == li) {
                swap(pi, li);
                downheapify(li);
            } else if (min == ri) {
                swap(pi, ri);
                downheapify(ri);
            }
        }

        public T remove() {
            if (size() == 0) {
                System.out.println("Underflow");
                return null;
            }

            swap(0, size() - 1);
            T val = data.remove(size() - 1);
            downheapify(0);
            return val;
        }

        public T peek() {
            if (size() == 0) {
                System.out.println("Underflow");
                return null;
            }

            return data.get(0);
        }

        public void heapSort() {
            while (size() > 0) {
                System.out.println(remove() + " ");
            }
        }

        public int size() {
            return data.size();
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        PriorityQueue<Country> q = new PriorityQueue<>(new LexicographicalComparator());

        Country[] obj = new Country[5];
        obj[0] = new Country("India", 26, 80, 10);
        obj[1] = new Country("Australia", 56, 50, 20);
        obj[2] = new Country("England", 46, 20, 30);
        obj[3] = new Country("USA", 106, 102, 40);
        obj[4] = new Country("China", 76, 100, 50);

        for (int i = 0; i < 5; i++) {
            q.add(obj[i]);
        }

        q.heapSort();
    }
}