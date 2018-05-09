package td.learn.spring.v1.demo.service.impl;

import td.learn.spring.v1.annotation.TdService;
import td.learn.spring.v1.demo.service.IQueryService;
@TdService
public class QueryServiceImpl implements IQueryService {
    @Override
    public String getDetailByName(String name) {
        String result=" query result is name："+name;
        return result;
    }
}
