package Observer;

public class ConcreteSubject implements Subject {
    String subjectState = "DefaultState";

    public void setSubjectState(String subjectState) {
        this.subjectState = subjectState;
    }

    public String getSubjectState() {
        System.out.println(subjectState);
        return subjectState;
    }
}
