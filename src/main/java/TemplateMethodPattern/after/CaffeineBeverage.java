package TemplateMethodPattern.after;


public abstract class CaffeineBeverage {
    // 알고리즘을 갖고 있는 이 메소드를 '템플릿 메소드'라 부른다
    final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        // 고객이 원하는 경우에만 첨가물을 넣는다
        if (customerWantsCondiments()) {
            addCondiments();
        }
    }

    abstract void brew();           // 서브클래스에서 구현
    abstract void addCondiments();  // 서브클래스에서 구현

    void boilWater() {
        System.out.println("물 끓이는 중");
    }
    void pourInCup() {
        System.out.println("컵에 따르는 중");
    }

    // hook 메소드
    // 추상 클래스에서 선언하지만 기본적인 내용만 구현되어 있거나 내용이 비어 있는 메소드.
    boolean customerWantsCondiments() {
        return true;
    }
}