package StrategyPattern.duck;

import StrategyPattern.fly.FlyRocketPowered;
import StrategyPattern.quack.MachineQuack;

public class MachineDuck extends Duck {
    public void MallardDuck() {
        quackBehavior = new MachineQuack();
        flyBehavior = new FlyRocketPowered();
    }
}