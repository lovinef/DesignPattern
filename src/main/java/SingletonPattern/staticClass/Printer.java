package SingletonPattern.staticClass;

public class Printer {
    private static int counter = 0;
    // 메서드 동기화 (임계 구역)
    public synchronized static void print(String str) {
        counter++;
        System.out.println(str + counter);
    }
}