package prototype.deep;

import java.io.*;

public class Person implements Cloneable ,Serializable{
    String name;
    Book book;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        try {
            return deepClone();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Object deepClone() throws IOException, ClassNotFoundException {
        ByteArrayOutputStream bos=new ByteArrayOutputStream();
        ObjectOutputStream oos=new ObjectOutputStream(bos);
        oos.writeObject(this);


        ByteArrayInputStream bi=new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bi);

        return ois.readObject();
    }
}
