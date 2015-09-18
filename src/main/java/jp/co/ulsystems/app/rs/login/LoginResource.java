/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ulsystems.app.rs.login;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import jp.co.ulsystems.app.rs.ApplicationException;

/**
 * REST Web Service ログイン
 */
@Path("login")
@RequestScoped
public class LoginResource {

    
    @Inject
    private HttpServletRequest req;

    /**
     * ログイン処理
     * 
     * @param  loginReq  IDとパスワード。バリデーション済み
     * @return ログインユーザー名と次の遷移先URL
     */
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public LoginResponse login(@Valid LoginRequest loginReq) {
      
        try {
            req.getSession(true);
            req.login(loginReq.id, loginReq.password);
            return new LoginResponse(req.getUserPrincipal().getName(), "welcome.html");
        } catch(ServletException e) {
            
            throw new ApplicationException("id", "Invalid id or password.");
        }
    }
    

}
