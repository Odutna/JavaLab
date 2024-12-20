public class TestANSI {

    public static void main(String[] args) {
        int n;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 10; j++) {
                n = 10 * i + j;
                if (n > 108) break;
                System.out.print("\033[" + n + "m " + n +"\033[m");
            }
            System.out.println();
        }
    }
}
