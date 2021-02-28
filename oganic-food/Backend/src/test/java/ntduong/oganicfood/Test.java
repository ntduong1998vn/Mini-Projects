package ntduong.oganicfood;

public class Test {

    public static void main(String[] args) {
        loop2(0, 2, 10);
    }

    public static void loop2(int a, int b, int n) {
        int total = 0;
        for (int i = 0; i < n; i++) {
            total = a + (int) Math.pow(2, i) * b;
            System.out.print(total + " ");
        }
    }
}
