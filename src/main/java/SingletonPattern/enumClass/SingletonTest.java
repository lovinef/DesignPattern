package SingletonPattern.enumClass;

// Thread-safety와 Serialization이 보장된다.
// Reflection을 통한 공격에도 안전하다.
public enum SingletonTest {
    INSTANCE;

    public static SingletonTest getInstance(){
        return INSTANCE;
    }
}
