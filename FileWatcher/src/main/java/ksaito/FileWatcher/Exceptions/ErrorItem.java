package ksaito.FileWatcher.Exceptions;

import lombok.Data;

/**
 * エラー項目.
 */
@Data
public class ErrorItem {
    /** code. */
    private String code;
    /** field. */
    private String field;
    /** args. */
    private Object[] args;

    /**
     * Constructor.
     * @param code .
     * @param field .
     * @param args .
     */
    public ErrorItem(String code, String field, Object... args) {
        this.code = code;
        this.field = field;
        this.args = args;
    }
}
