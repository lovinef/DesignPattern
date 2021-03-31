package StrategyPattern;

import StrategyPattern.duck.Duck;
import StrategyPattern.duck.MallardDuck;
import StrategyPattern.fly.FlyRocketPowered;
/*
스트레티지 패턴, 전략 패턴, 정책(Policy) 패턴으로 불린다.

동일 계열의 알고리즘을 정의하고 상호교환이 가능하게 한다

의도
동일 계열의 알고리즘군을 정의하고, 각 알고리즘을 캡슐화하며, 이들을 상호교환이 가능하도록 만듭니다.
알고리즘을 사용하는 클라이언트와 상관없이 독립적으로 알고리즘을 다양하게 변경할 수 있게 합니다.

https://johngrib.github.io/wiki/strategy-pattern/
*/
public class MainClass {
    public static void main(String[] args) {
        Duck myDuck = new MallardDuck();
        myDuck.performFly();    // 날개로 날아간다!
        myDuck.performQuack();  // 꽥꽥

        myDuck.setFlyBehavior(new FlyRocketPowered());
        myDuck.performFly();    // 로켓 추진으로 날아간다!
    }
}
