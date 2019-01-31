package TD31012019;

public interface MySerialisable {
    public void writeToBuff(SerializerBuffer ms);

    public void readFromBuff(SerializerBuffer ms);
}
