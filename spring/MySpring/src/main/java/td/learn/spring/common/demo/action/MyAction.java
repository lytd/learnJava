package td.learn.spring.common.demo.action;


import td.learn.spring.framework.annotation.TdAutoWried;
import td.learn.spring.framework.annotation.TdController;
import td.learn.spring.framework.annotation.TdRequestMapping;
import td.learn.spring.common.demo.service.IQueryService;
@TdController
@TdRequestMapping("/query")
public class MyAction {
    @TdAutoWried
    private IQueryService queryService;
    @TdRequestMapping("/queryByName")
    public  String queryName(String name){
       String result=queryService.getDetailByName(name);
        System.out.println(result);
        return result;
    }

}
