package td.learn.mybatis.model;


import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Book {
    private int bookId;
    private String book_name;
    private int  persion_id;
    private String insert_time;
    private String book_info;

    public Book() {
    }

    public Book(int bookId, String book_name, int persion_id, String insert_time, String book_info) {
        this.bookId = bookId;
        this.book_name = book_name;
        this.persion_id = persion_id;
        this.insert_time = insert_time;
        this.book_info = book_info;
    }
}
