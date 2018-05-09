package td.learn.tdbatis.v1;

import java.util.List;

public interface IExector {
    <T> T query(String statment,String preparment);
}
