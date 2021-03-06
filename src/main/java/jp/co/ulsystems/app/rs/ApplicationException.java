package jp.co.ulsystems.app.rs;

import javax.ws.rs.WebApplicationException;

/**
 * メッセージ付き例外
 */
public class ApplicationException extends RuntimeException {
    
    private String key;

    public ApplicationException(String key, String message) {
        super(message);
        this.key = key;
    }
    
    public String getKey() {
        return key;
    }
}
