package td.learn.spring.common.demo.service.impl;

import td.learn.spring.framework.annotation.TdService;
import td.learn.spring.common.demo.service.IQueryService;
@TdService
public class QueryServiceImpl implements IQueryService {
    @Override
    public String getDetailByName(String name) {
        String result=" query result is name："+name;
        return result;
    }
}
