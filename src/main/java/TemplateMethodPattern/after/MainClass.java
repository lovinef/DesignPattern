package TemplateMethodPattern.after;

/*
알고리즘의 일부 단계를 서브클래스에서 정의한다

용어
템플릿 메소드
  필수 처리 절차를 정의한 메소드.
  서브클래스가 오버라이드하는 추상 메소드들을 사용하여 알고리즘을 정의하는 메소드.
훅 연산(hook operation)
  필요하다면 서브클래스에서 확장할 수 있는 기본적인 행동을 제공하는 연산(메소드).
  기본적으로는 아무 내용도 정의하지 않는다.

구현팁
템플릿 메소드가 호출하는 메소드들을 템플릿 메소드만 호출할 수 있게 하는 것을 고려한다.
  protected 접근 제한을 사용하면 된다.
템플릿 메소드는 오버라이드할 수 없도록 구현하는 것을 고려한다.
  Java라면 템플릿 메소드에 final을 달아주면 된다.
구현해야 하는 abstract 메소드의 수가 너무 많아지지 않도록 주의한다.
재정의할 abstract 메소드는 식별하기 쉽도록 접두사를 붙여주자.
  예를 들어 메소드 이름이 Do로 시작하도록 한다.

주의사항
Template Method 패턴은 가능한 절제해 사용해야 한다.
클래스 자체가 전적으로 파생 클래스의 커스터마이징에 의존하는 일종의 '프레임워크'가 되면 이 역시 매우 부서지기 쉽기 때문이다.
기반 클래스는 매우 깨지기 쉽다

https://johngrib.github.io/wiki/template-method-pattern/#fn:holub
*/
public class MainClass {
    public static void main(String[] args) {
        Coffee coffee = new Coffee();
        Tea tea = new Tea();

        coffee.prepareRecipe();

        System.out.println();

        tea.prepareRecipe();

    }
}
