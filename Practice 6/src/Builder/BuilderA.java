package Builder;

public class BuilderA implements Builder<BuilderA> {

    A aClassObject = new A();

//    protected void setaClassObject(A aClassObject) {
//        this.aClassObject = aClassObject;
//    }

    @Override
    public BuilderA buildFirstPart() {
        aClassObject.setFirstPart("This is the First Part of A");
        return this;
    }

    @Override
    public BuilderA buildSecondPart() {
        aClassObject.setSecondPart("This is the Second Part of A");
        return this;
    }

    @Override
    public BuilderA buildThirdPart() {
        aClassObject.setThirdPart("This is the Third Part of A");
        return this;
    }

    @Override
    public BuilderA reset() {
        aClassObject = new A();
        return this;
    }

    public A getResult() {
        return this.aClassObject;
    }
}
