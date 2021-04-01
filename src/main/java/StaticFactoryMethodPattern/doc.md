StaticFactoryMethodPattern
=
static 메서드로 객체 생성을 캡슐화한다

### 규칙
생성자 대신 정적 팩터리 메서드를 사용할 수 없는지 생각해 보라.
+ 단, GoF-Design-Pattern 책에 나오는 팩토리 메서드 패턴과는 다른 패턴이다. 이름만 비슷하다.
+ Effective Java 저자 조슈아 블로흐도 GoF-Design-Pattern 책에 나온 어떤 패턴과도 맞아 떨어지지 않는다며 주의하라고 한다.

### Effective Java에서는 다음과 같은 장단점을 설명한다.
#### 장점
+ 이름이 있으므로 생성자에 비해 가독성이 좋다.
+ 호출할 때마다 새로운 객체를 생성할 필요가 없다.
+ 하위 자료형 객체를 반환할 수 있다.
+ 형인자 자료형(parameterized type) 객체를 만들 때 편하다.
#### 단점
+ 정적 팩토리 메서드만 있는 클래스라면, 생성자가 없으므로 하위 클래스를 못 만든다.
+ 정적 팩토리 메서드는 다른 정적 메서드와 잘 구분되지 않는다. (문서만으로 확인하기 어려울 수 있음)

### 특징
#### 가독성이 좋다.
```java
// 생성자 사용
// 변수명이 없었다면 5, 15, 20, 3 같은 연속된 숫자만으로는 캐릭터의 직업을 알아보기 어려웠을 것이다.
Character warrior = new Character(5, 15, 20, 3);
Character mage = new Character(15, 5, 10, 15);

// 정적 팩토리 메서드 사용
Character warrior = Character.newWarrior();
Character mage = Character.newMage();
```

#### 호출할 때마다 새로운 객체를 생성할 필요가 없다
```java
public static final BigInteger ZERO = new BigInteger(new int[0], 0);

private final static int MAX_CONSTANT = 16;
private static BigInteger posConst[] = new BigInteger[MAX_CONSTANT+1];
private static BigInteger negConst[] = new BigInteger[MAX_CONSTANT+1];

static {
    /* posConst에 1 ~ 16까지의 BigInteger 값을 담는다. */
    /* negConst에 -1 ~ -16까지의 BigInteger 값을 담는다. */
}

public static BigInteger valueOf(long val) {
    // 미리 만들어둔 객체를 리턴한다 (0 같은 값을 호출시마다 일일이 생성하는 일을 피할 수 있다.)
    if (val == 0)
        return ZERO;
    if (val > 0 && val <= MAX_CONSTANT)
        return posConst[(int) val];
    else if (val < 0 && val >= -MAX_CONSTANT)
        return negConst[(int) -val];
    
    // 새로운 객체를 만들어 리턴한다
    return new BigInteger(val);
}
```

#### 하위 자료형 객체를 반환할 수 있다
리턴하는 객체의 타입을 유연하게 지정할 수 있다
```java
class OrderUtil {

    public static Discount createDiscountItem(String discountCode) throws Exception {
        if(!isValidCode(discountCode)) {
            throw new Exception("잘못된 할인 코드");
        }
        // 쿠폰 코드인가? 포인트 코드인가?
        // 할인 코드의 규칙에 따라 Coupon과 Point 객체를 선택적으로 리턴하고 있다.
        if(isUsableCoupon(discountCode)) {
            return new Coupon(1000);
        } else if(isUsablePoint(discountCode)) {
            return new Point(500);
        }
        throw new Exception("이미 사용한 코드");
    }
}

class Coupon extends Discount { }
class Point extends Discount { }
```
java.util.Collection내 사용 일부분
```java
@SuppressWarnings("rawtypes")
public static final Map EMPTY_MAP = new EmptyMap<>();

/**
 * Returns an empty map (immutable).  This map is serializable.
 */
@SuppressWarnings("unchecked")
public static final <K,V> Map<K,V> emptyMap() {
    return (Map<K,V>) EMPTY_MAP;
}

private static class EmptyMap<K,V> extends AbstractMap<K,V> implements Serializable {
    /* 생략 */
}
```

#### 형인자 자료형 객체를 만들 때 편리하다
Java 1.7 이전에는 다음과 같이 형인자 자료형 객체를 만들어야 했다.

```java
Map<String, List<String>> list = new HashMap<String, List<String>>();
```
아무리 자동 완성이 있어도 타이핑하기 굉장히 짜증나는데, 정적 팩토리 메서드를 사용해서 다음과 같이 사용할 수 있었다.

```java
// 정적 팩토리 메서드: type inference를 이용한다
public static <K, V> HashMap<K, V> newInstance() {
return new HashMap<K, V>();
}
// 위의 정적 팩토리 메서드를 사용한다
Map<String, List<String>> list = HashMap.newInstance();
```

그러나 이 장점은 Java 1.7 이후로는 의미를 거의 잃었다.
```java
Map<String, List<String>> list = new HashMap<>();
```

## Lombok RequiredArgsConstructor.staticName의 사용
### Lombok의 RequiredArgsConstructor를 사용하면 정적 팩토리 메소드를 쉽게 만들 수 있다.

```java
import lombok.RequiredArgsConstructor;

//                                      ↓ 정적 팩토리 메소드 이름
@RequiredArgsConstructor(staticName = "of")
public class BlogUser {
    private final Long id;
    private final String name;
}
```
위와 같이 staticName을 선언하면 롬복이 of라는 이름을 가진 정적 팩토리 메소드를 만들어준다.
즉, 다음과 같이 사용할 수 있다.
```java
BlogUser user = BlogUser.of(1L, "JohnGrib");
```

#### 출처
https://johngrib.github.io/wiki/static-factory-method-pattern/