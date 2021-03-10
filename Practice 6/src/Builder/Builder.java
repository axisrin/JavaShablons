package Builder;

public interface Builder<T> {

    T buildFirstPart();
    T buildSecondPart();
    T buildThirdPart();
    T reset();

}
