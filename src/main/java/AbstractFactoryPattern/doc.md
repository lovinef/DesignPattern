AbstractFactoryPattern
--

서로 관련성이 있는 다양한 객체를 생성하기 위한 인터페이스를 제공

### 의도
상세화된 서브클래스를 정의하지 않고도 서로 관련성이 있거나 독립적인 여러 객체의 군을 생성하기 위한 인터페이스를 제공합니다.

### 활용
추상 팩토리는 다음의 경우에 사용합니다.<br/>
객체가 생성되거나 구성, 표현되는 방식과 무관하게 시스템을 독립적으로 만들고자 할 때<br/>
여러 제품군 중 하나를 선택해서 시스템을 설정해야 하고 한번 구성한 제품을 다른 것으로 대체할 수 있을 때<br/>
관련된 제품 객체들이 함께 사용되도록 설계되었고, 이 부분에 대한 제약이 외부에도 지켜지도록 하고 싶을 때<br/>
제품에 대한 클래스 라이브러리를 제공하고, 그들의 구현이 아닌 인터페이스를 노출시키고 싶을 때

### 설명1.
추상 팩토리 패턴을 사용하면 클라이언트에서 추상 인터페이스를 통해서 일련의 제품들을 공급받을 수 있다.<br/>
이때, 실제로 어떤 제품이 생산되는지는 전혀 알 필요 없다. <br/>
따라서 클라이언트와 팩토리에서 생산되는 제품을 분리시킬 수 있다.

### 설명2.
Abstract Factory 는 실제 객체가 정확히 무엇인지 알지 못해도 객체를 생성하고 조작할 수 있도록 해준다(예제는 Iterator를 이용하는데, Iterator 인터페이스만 알면, 구현체는 몰라도 된다).<br/>
이런 방식으로 Concrete Product를 사용하는 코드를 변경하지 않으면서도 손쉽게 새로운 Concrete Product를 추가할 수 있다.<br/>
Abstract Factory는 또한 다양한 환경에서 작동하는 코드를 쉽게 만들 수 있도록 해준다.<br/>
예를 들어 시스템은 각 환경에 맞는 고유한 Concrete Factory를 생성하고, 이는 다시 환경에 맞는 Concrete Product를 생성한다.<br/>
하지만 이들을 구현 클래스가 아닌 인터페이스를 통해 이용하기 때문에 여러분은 사용하고 있는 환경(혹은 Concrete Product)이 무엇인지 알지 못한다.

### 요약
기본이 되는 팩토리가 재료를 공급하며, 생산된 프로덕트가 정확히 무엇인지 알지 못해도 프로덕트의 인터페이스만 알면 조작할 수 있다.

### 사용처 예시
```
Collection.iterator

// iterator 인터페이스로 접근
LinkedList linkedList = new LinkedList();
Iterator iterator = linkedList.iterator();

ArrayList arrayList = new ArrayList<String>();
Iterator iterator1 = arrayList.iterator();

// ConcreteFactory
URL home = new URL(address);

// AbstractProduct 이기도 하고, AbstractFactory 이기도 하다
// URL을 통해 생산된 AbstractProduct.
// InputStream을 만들어내는 AbstractFactory.
URLConnection c = home.openConnection();

InputStream in = c.getInputStream();
```

### 출처
https://johngrib.github.io/wiki/abstract-factory-pattern/