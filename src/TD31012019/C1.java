package TD31012019;

public class C1 implements MySerialisable {
    private double f;
    private int i;
    private String s;

    public C1(double f, int i, String s) {
        this.f = f;
        this.i = i;
        this.s = s;
    }

    public C1() {
    }

    public double getF() {
        return f;
    }

    public int getI() {
        return i;
    }

    public String getS() {
        return s;
    }

    public void setF(double f) {
        this.f = f;
    }

    public void setI(int i) {
        this.i = i;
    }

    public void setS(String s) {
        this.s = s;
    }

    @Override
    public String toString() {
        return "C1( " + f + " , " + i + " ," + s + ")";
    }

    public void serialize(SerializerBuffer buffer) {
        buffer.writeDouble(f);
        buffer.writeInt(i);
        buffer.writeString(s);
    }

    public static C1 deserialize(SerializerBuffer buffer) {
        return new C1(
                buffer.readDouble(),
                buffer.readInt(),
                buffer.readString()
        );
    }

    @Override
    public void writeToBuff(SerializerBuffer ms) {
        ms.writeDouble(f);
        ms.writeInt(i);
        ms.writeString(s);
    }

    @Override
    public void readFromBuff(SerializerBuffer ms) {
        this.f = ms.readDouble();
        this.i = ms.readInt();
        this.s = ms.readString();
    }
}
