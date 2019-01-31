import TD31012019.C1;
import TD31012019.SerializerBuffer;

import java.nio.ByteBuffer;

public class Main {

    public static void main(String[] args) {

        C1 c1 = new C1(3.14, 4, "hello $");

        SerializerBuffer serializerBuffer = new SerializerBuffer(ByteBuffer.allocate(512));

        c1.serialize(serializerBuffer);

        System.out.println(c1);

        serializerBuffer.flip();

        C1 c2 = C1.deserialize(serializerBuffer);

        System.out.println(c2);

    }
}
