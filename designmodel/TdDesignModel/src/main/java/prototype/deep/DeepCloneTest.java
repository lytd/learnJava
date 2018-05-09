package prototype.deep;

public class DeepCloneTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        Person p=new Person();
        Book book=new Book();
        p.name="原始人";
        book.name="原始人进化路";
        p.book=book;
        Person newpeople= (Person) p.clone();
        System.out.println(newpeople+"_"+p);
        System.out.println(newpeople.book+"_"+p.book);
    }
}
