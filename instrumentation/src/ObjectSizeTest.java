/**
 * @author bo li
 * @date 2020-09-17 14:03
 */
public class ObjectSizeTest {

    private int i1; // 4
    private int i2;// 4
    private byte b1; // 1
    private byte b2; // 1
    private byte b3;  // 1
    private String s; // 4
    private Object obj; //4


    public static void main(String[] args) {
        System.out.println(ObjectShallowSize.sizeOf(new ObjectSizeTest()));
    }
}