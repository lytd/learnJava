package td.learn.mybatis.dao;

import td.learn.mybatis.model.Book;

public interface IBookMapper {

    String getBookNameById(int id);


    Book getBookinfo(int id);

    int addBook(Book p);
}
