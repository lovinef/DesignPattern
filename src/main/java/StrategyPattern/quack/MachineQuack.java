package StrategyPattern.quack;

public class MachineQuack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("머신머신!!");
    }
}
