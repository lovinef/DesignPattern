package StrategyPattern;

import StrategyPattern.duck.Duck;
import StrategyPattern.duck.MallardDuck;
import StrategyPattern.fly.FlyRocketPowered;

public class MainClass {
    public static void main(String[] args) {
        Duck myDuck = new MallardDuck();
        myDuck.performFly();    // 날개로 날아간다!
        myDuck.performQuack();  // 꽥꽥

        myDuck.setFlyBehavior(new FlyRocketPowered());
        myDuck.performFly();    // 로켓 추진으로 날아간다!
    }
}
