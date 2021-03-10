package Builder;

public class Director {

    public A exampleABuilderWithoutSecondPart() {

        BuilderA builderA = new BuilderA();
        A exampleObject = new A();
//        builderA.setaClassObject(exampleObject);

        exampleObject = builderA.buildFirstPart().buildThirdPart().getResult();
        System.out.println(exampleObject);
        return exampleObject;
    }

    public B exampleBBuilderWithoutFirstPart() {

        BuilderB builderB = new BuilderB();
        B exampleObject = new B();
    
        exampleObject = builderB.buildThirdPart().buildSecondPart().getResult();
        System.out.println(exampleObject);
        return exampleObject;
    }

    public static void main(String[] args) {

        new Director().exampleABuilderWithoutSecondPart();
        new Director().exampleBBuilderWithoutFirstPart();

    }

}
