package td.learn.tdbatis.v1;

import java.util.List;

public class TdSqlSession implements ISqlsession{
    private TdConfigrution configrution;
    private IExector excetor;

    public TdSqlSession(TdConfigrution configrution, IExector excetor) {
        this.configrution = configrution;
        this.excetor = excetor;
    }

    public <T> T getMapper(Class<T> clazz){
       return  (T)configrution.getMapper(clazz,this);
    }

    public <T> T selectOne(String statement,String preparedstatement){
        return excetor.query(statement,preparedstatement);
    }
}
