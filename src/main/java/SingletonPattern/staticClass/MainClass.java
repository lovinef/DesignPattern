package SingletonPattern.staticClass;

/*
    정적 클래스를 이용하면 객체를 전혀 생성하지 않고 메서드를 사용한다.
    정적 메서드를 사용하므로 일반적으로 실행할 때 바인딩되는(컴파일 타임에 바인딩되는) 인스턴스 메서드를 사용하는 것보다 성능 면에서 우수하다.
    정적 클래스를 사용할 수 없는 경우
    인터페이스를 구현해야 하는 경우, 정적 메서드는 인터페이스에서 사용할 수 없다.
*/
public class MainClass {
    private static final int THREAD_NUM = 5;
    public static void main(String[] args) {
        UserThread[] user = new UserThread[THREAD_NUM];

        for (int i = 0; i < THREAD_NUM; i++) {
            // UserThread 인스턴스 생성
            user[i] = new UserThread(String.valueOf(i+1));
            user[i].start();
        }
    }
}