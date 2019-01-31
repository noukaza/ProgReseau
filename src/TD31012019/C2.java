package TD31012019;

public class C2 implements MySerialisable {
    private C1 c1;
    private C2 c2;

    public C2(C1 c1, C2 c2) {
        this.c1 = c1;
        this.c2 = c2;
    }

    public C2() {
    }

    public C2(double f, int i, String s, C2 c2) {
        this.c1 = new C1(f, i, s);
        this.c2 = c2;
    }

    @Override
    public String toString() {
        return "C2( " + c1 + " , " + c2 + ")";
    }

    @Override
    public void writeToBuff(SerializerBuffer ms) {
        //TODO implement
    }

    @Override
    public void readFromBuff(SerializerBuffer buffer) {
        c2.c1 = new C1();
        c2.c1.serialize(buffer);
        if (buffer.getByteBuffer().get() != 0) {
            c2 = new C2();
            c2.readFromBuff(buffer);
        }

    }
}
