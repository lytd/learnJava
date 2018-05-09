package td.learn.spring.v1.demo.action;


import td.learn.spring.v1.annotation.TdAutoWried;
import td.learn.spring.v1.annotation.TdController;
import td.learn.spring.v1.annotation.TdRequestMapping;
import td.learn.spring.v1.demo.service.IQueryService;
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
