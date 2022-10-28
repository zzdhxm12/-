import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_나이순정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        PriorityQueue<People> judge = new PriorityQueue<>();

        int N = Integer.parseInt(br.readLine());
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            judge.add(new People(age, i, name));
        }

        for(int i=0;i<N;i++) {
            People p = judge.poll();
            System.out.println(p.age + " " + p.name);
        }
    }

    static class People implements Comparable<People>{
        int age;
        int order;
        String name;

        People(int age, int order, String name){
            this.age = age;
            this.order = order;
            this.name = name;
        }

        @Override
        public int compareTo(People o) {
            if(this.age == o.age) {
                return this.order - o.order;
            }
            return this.age - o.age;
        }
    }
}
