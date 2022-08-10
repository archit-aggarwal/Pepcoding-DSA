import java.io.*;
import java.util.*;

class Main {

    public static class PriorityQueue<T> {
        ArrayList<T> data;

        public PriorityQueue() {
            data = new ArrayList<>();
        }

        public PriorityQueue(ArrayList<T> data) {
            this.data = data;
            for (int idx = (size() - 2) / 2; idx >= 0; idx--) {
                downheapify(idx);
            }
        }

        public boolean isSmaller(int ci, int pi) {
            if (data.get(ci) < data.get(pi)) {
                return true;
            }
            return false;
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
            if (li < size() && data.get(li) < data.get(min)) {
                min = li;
            }

            int ri = 2 * pi + 2;
            if (ri < size() && data.get(ri) < data.get(min)) {
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
                System.out.print(remove() + " ");
            }
        }

        public int size() {
            return data.size();
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        PriorityQueue<Double> q = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            q.add(scn.nextDouble());
        }

        q.heapSort();
    }
}