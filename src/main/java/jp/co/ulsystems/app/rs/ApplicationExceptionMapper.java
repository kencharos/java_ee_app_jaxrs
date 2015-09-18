package jp.co.ulsystems.app.rs;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
/**
 * アプリケーション例外から、
 * エラーメッセージをレスポンスに設定する。
 */
@Provider 
public class ApplicationExceptionMapper implements ExceptionMapper<ApplicationException> {

    @Override
    @Produces(MediaType.APPLICATION_JSON)
    public Response toResponse(ApplicationException e) {
        
        
        List<Pair> list = new ArrayList<>();
        list.add(new Pair(e.getKey(), e.getMessage()));
        
        return Response.status(400).type(MediaType.APPLICATION_JSON)
                .entity(new GenericEntity<List<Pair>>(list){})
                .build();
    }
    
}

