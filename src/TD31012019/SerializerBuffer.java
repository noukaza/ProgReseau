package TD31012019;

import java.nio.ByteBuffer;

public class SerializerBuffer {
    private ByteBuffer byteBuffer;

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
}
