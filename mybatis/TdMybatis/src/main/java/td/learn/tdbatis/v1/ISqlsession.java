package td.learn.tdbatis.v1;

public interface ISqlsession {
    public <T> T getMapper(Class<T> clazz);
    public <T> T selectOne(String statement,String preparedstatement);

}
