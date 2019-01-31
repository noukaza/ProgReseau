package TD31012019;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public class SerializerBuffer {
    private ByteBuffer byteBuffer;
    public static final Charset CHARSET = Charset.forName("UTF-8");

    public SerializerBuffer(ByteBuffer byteBuffer) {
        this.byteBuffer = byteBuffer;
    }

    public ByteBuffer getByteBuffer() {
        return byteBuffer;
    }

    void writeInt(int i) {
        byteBuffer.putInt(i);
    }

    void writeDouble(double f) {
        byteBuffer.putDouble(f);
    }

    int readInt() {
        return byteBuffer.getInt();
    }

    double readDouble() {
        return byteBuffer.getDouble();
    }

    void writeString(String s) {
        ByteBuffer b2 = CHARSET.encode(s);
        int size = b2.remaining();
        byteBuffer.putInt(size);
        byteBuffer.put(b2);
    }

    String readString() {
        int size = byteBuffer.getInt();
        int lim = byteBuffer.limit();
        byteBuffer.limit(byteBuffer.position() + size);
        String s = CHARSET.decode(byteBuffer).toString();
        byteBuffer.limit(lim);
        return s;
    }

    public void flip() {
        byteBuffer.flip();
    }
}
