package FactoryMethodPattern;
/*
팩토리 메소드 패턴, 가상 생성자 패턴으로 불린다.

객체를 생성하기 위한 인터페이스를 정의하고, 인스턴스 생성은 서브클래스가 결정하게 한다

요약
객체 생성을 캡슐화하는 패턴이다.
Creator의 서브클래스에 팩토리 메소드를 정의하여, 팩토리 메소드 호출로 적절한 ConcreteProduct 인스턴스를 반환하게 한다.

구현시 고려할 점들
팩토리 메소드 페턴의 구현 방법은 크게 두 가지가 있다.
  Creator를 추상 클래스로 정의하고, 팩토리 메소드는 abstract로 선언하는 방법.
  Creator가 구체 클래스이고, 팩토리 메소드의 기본 구현을 제공하는 방법.
팩토리 메소드의 인자를 통해 다양한 Product를 생성하게 한다.
  팩토리 메소드에 잘못된 인자가 들어올 경우의 런타임 에러 처리에 대해 고민할 것.
  Enum 등을 사용하는 것도 고려할 필요가 있다.

https://johngrib.github.io/wiki/factory-method-pattern/
*/
public class MainClass {
    public static void main(String[] args) {
        Factory factory = new IDCardFactory();
        Product card1 = factory.create("홍길동");
        Product card2 = factory.create("이순신");
        Product card3 = factory.create("강감찬");
        card1.use();
        card2.use();
        card3.use();
    }
}
