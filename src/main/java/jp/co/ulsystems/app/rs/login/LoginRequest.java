package jp.co.ulsystems.app.rs.login;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * ログインリクエスト
 */
public class LoginRequest {

    @NotNull
    @Size(min = 1)
    public String id;
    
    @NotNull
    @Size(min = 1)
    public String password;
    
    
}
