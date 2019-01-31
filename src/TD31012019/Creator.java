package TD31012019;

public interface Creator<T extends MySerialisable> {
    public abstract T init();
}
