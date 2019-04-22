package ksaito.FileWatcher.Exceptions;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 当アプリケーション用Exceptionクラス
 */
@Getter
@Setter
public class WatchException extends Exception {

    /** エラーコード. */
    private String code = "";

    /** フィールド. */
    private String field = "";

    /** エラー. */
    private List<ErrorItem> errors;

    /** メッセージパラメータ. */
    private Object[] messageParameters;

    /**
     * コンストラクタ.
     */
    public WatchException() {
        super();
    }

    /**
     * コンストラクタ.
     *
     * @param code エラーコード
     */
    public WatchException(String code) {
        super();
        setCode(code);
    }

    /**
     * コンストラクタ.
     *
     * @param code エラーコード
     * @param field フィールド
     * @param messageParameters パラメータ
     */
    public WatchException(String code, String field, Object... messageParameters) {
        super();
        setCode(code);
        setField(field);
        setMessageParameters(messageParameters);
    }

    /**
     * コンストラクタ.
     *
     * @param code エラーコード
     * @param cause 原因のThrowableオブジェクト.
     * {@link #getCode()}メソッドで参照するために保存します. 原因が存在しないまたは不明な場合のために<tt>null</tt>が許可されています.
     */
    public WatchException(String code, Throwable cause) {
        super((cause == null ? null : cause.toString()), cause);
        setCode(code);
    }

    /**
     * コンストラクタ.
     *
     * @param code エラーコード
     * @param message {@link String}
     * @param cause {@link Throwable}
     */
    public WatchException(String code, String message, Throwable cause) {
        super(message, cause);
        this.setCode(code);
    }

    /**
     * コンストラクタ.
     *
     * @param errors エラーレスポンス
     */
    public WatchException(List<ErrorItem> errors) {
        this.setErrors(errors);
    }
}
