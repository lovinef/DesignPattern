package StrategyPattern.duck;

import StrategyPattern.fly.FlyWithWings;
import StrategyPattern.quack.KoreanQuack;

public class MallardDuck extends Duck {
    public MallardDuck() {
        quackBehavior = new KoreanQuack();
        flyBehavior = new FlyWithWings();
    }
}