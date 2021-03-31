package FactoryMethodPattern;

abstract class Factory {
    public final Product create(String owner) {
        Product p = createProduct(owner);
        registerProduct(p);
        return p;
    }

    // 팩토리 메소드
    protected abstract Product createProduct(String owner);
    protected abstract void registerProduct(Product p);
}