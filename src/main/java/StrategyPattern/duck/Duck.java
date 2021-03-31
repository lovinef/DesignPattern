package StrategyPattern.duck;

import StrategyPattern.fly.FlyBehavior;
import StrategyPattern.quack.QuackBehavior;

public class Duck {
    QuackBehavior quackBehavior;    // interface
    FlyBehavior flyBehavior;        // interface

    public void performQuack() {
        quackBehavior.quack();
    }

    public void performFly() {
        flyBehavior.fly();
    }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }
}