package TD31012019;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public class SerializerBuffer {
    private ByteBuffer byteBuffer;
    public static final Charset CHARSET = Charset.forName("UTF-8");


    public SerializerBuffer(ByteBuffer byteBuffer) {
        this.byteBuffer = byteBuffer;
    }

    void writeInt(int i ){
        byteBuffer.putInt(i);
    }

    void writeFloat(Float f){
        byteBuffer.putFloat(f);
    }

    int readInt(){
        return byteBuffer.getInt();
    }

    float readFloat(){
        return byteBuffer.getFloat();
    }

    void writeString(String s){
        ByteBuffer b2 = CHARSET.encode(s);
        int n = b2.remaining();
        byteBuffer.put(CHARSET.encode(Integer.toString(n)));
        byteBuffer.putChar(':');
        byteBuffer.put(b2);
    }

    String readString(){
        int lim = byteBuffer.limit();
        int t = byteBuffer.getInt();
        byteBuffer.limit(byteBuffer.position()+t);
        String s =CHARSET.decode(byteBuffer).toString();
        byteBuffer.limit(lim);
        return s;
    }
}
