package jp.co.ulsystems.app.rs.crud;

import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;


@Path("crudsample/employees") //このリソースの起点のURLを指定
@RequestScoped //CDIと統合
public class EmployeeResource {

    //ビジネスロジックをインジェクション
    @Inject
    private EmployeeService service;
    
    
    @GET // GET crudsample/employees?name=<name> に対応
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML}) //XMLかJSONを生成
    public List<Employee> search(@QueryParam("name") String name) {
        return service.findByName(name);
    }
    
    @GET
    @Path("{id}") // crudsample/employees/{id} に対応
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Employee get(@PathParam("id") long id) {
        return service.findById(id);
    }
    
    
    @POST // POST crudsample/employees に対応
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED) //HTTPフォームを受け取る
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Employee newEmployee(@FormParam("name")String name, @FormParam("age")int age) {
        return service.save(name, age);
    }
    
    @PUT // PUT curdsample/employees/{id} に対応
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED) 
    public void updateEmployee(@PathParam("id") long id, 
            @FormParam("name")String name, @FormParam("age")int age) {
        service.update(new Employee(id, name, age));
    }
    
    
    @DELETE // DELETE crudsample/employees/{id} に対応
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED) 
    public void deleteEmployee(@PathParam("id") long id) {
        service.delete(id);
    }
}
