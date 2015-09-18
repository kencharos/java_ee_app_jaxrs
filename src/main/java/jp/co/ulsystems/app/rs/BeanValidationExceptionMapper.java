package jp.co.ulsystems.app.rs;


import java.util.List;
import java.util.stream.Collectors;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
/**
 * Bean Validationの例外に対するマッピング。
 * 
 * エラーメッセージをレスポンスに設定する。
 */
@Provider 
public class BeanValidationExceptionMapper implements ExceptionMapper<ConstraintViolationException> {

    @Override
    @Produces(MediaType.APPLICATION_JSON)
    public Response toResponse(ConstraintViolationException exception) {
        
        
        List<Pair> list = 
            exception.getConstraintViolations().stream()
                .map(v -> new Pair(last(v.getPropertyPath().toString()), v.getMessage()))
                .collect(Collectors.toList());
        
        return Response.status(400).type(MediaType.APPLICATION_JSON)
                .entity(new GenericEntity<List<Pair>>(list){})
                .build();
    }
    
    private String last(String str) {
        System.out.println(str);
        String[] arr = str.split("[.]");
        return arr[arr.length-1];
    }
    
   
}

