package TemplateMethodPattern.after;

/*

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
