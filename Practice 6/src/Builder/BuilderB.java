package Builder;

public class BuilderB implements Builder<BuilderB> {

    B bClassObject = new B();

//    protected void setbClassObject(B bClassObject) {
//        this.bClassObject = bClassObject;
//    }

    @Override
    public BuilderB buildFirstPart() {
        bClassObject.setFirstPart("This is the First Part of B");
        return this;
    }

    @Override
    public BuilderB buildSecondPart() {
        bClassObject.setSecondPart("This is the Second Part of B");
        return this;
    }

    @Override
    public BuilderB buildThirdPart() {
        bClassObject.setThirdPart("This is the Third Part of B");
        return this;
    }

    @Override
    public BuilderB reset() {
        bClassObject = new B();
        return this;
    }

    public B getResult() {
        return this.bClassObject;
    }
}
