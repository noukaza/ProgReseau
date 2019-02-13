import TD31012019.C1;
import TD31012019.C2;
import TD31012019.SerializerBuffer;

import java.nio.ByteBuffer;

public class Main {

    public static void main(String[] args) {

        C1 c1 = new C1(3.14, 4, "hello $");
        C2 c2 = new C2(c1,new C2(23.2,3,"hi #",null));

        SerializerBuffer serializerBuffer = new SerializerBuffer(ByteBuffer.allocate(512));

        c1.serialize(serializerBuffer);

        System.out.println(c1);

        serializerBuffer.flip();

        C1 c1p = new C1();
        c1p.deserialize(serializerBuffer);
        C2 c2p = new C2();
        c2p.writeToBuff(serializerBuffer);
        System.out.println(c1p);

    }
}
