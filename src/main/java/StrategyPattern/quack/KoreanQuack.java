package StrategyPattern.quack;

import StrategyPattern.quack.QuackBehavior;

public class KoreanQuack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("꽥꽥");
    }
}