package TD31012019;

public class C2 {
    private C1 c1;
    private C2 c2;

    public C2(C1 c1, C2 c2) {
        this.c1 = c1;
        this.c2 = c2;
    }

    public C2(Double f, int i, C2 c2) {
        this.c1 = new C1(f,i);
        this.c2 = c2;
    }

    @Override
    public String toString() {
        return "C2( " + c1 + " , "+c2+ ")";
    }
}
