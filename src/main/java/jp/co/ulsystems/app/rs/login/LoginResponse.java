package jp.co.ulsystems.app.rs.login;

import javax.validation.constraints.Size;

/**
 * ログインリクエスト
 */
public class LoginResponse {

    public String user;
    
    public String next;
    
    public LoginResponse() {
    }

    public LoginResponse(String user, String next) {
        this.user = user;
        this.next = next;
    }
}
