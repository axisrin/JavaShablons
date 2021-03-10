package Builder;

public class B {

    protected String firstPart;
    protected String secondPart;
    protected String thirdPart;

    public void setFirstPart(String firstPart) {
        this.firstPart = firstPart;
    }

    public void setSecondPart(String secondPart) {
        this.secondPart = secondPart;
    }

    public void setThirdPart(String thirdPart) {
        this.thirdPart = thirdPart;
    }

    @Override
    public String toString() {
        return "B{" +
                "firstPart='" + firstPart + '\'' +
                ", secondPart='" + secondPart + '\'' +
                ", thirdPart='" + thirdPart + '\'' +
                '}';
    }
}
