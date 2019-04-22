package ksaito.FileWatcher.Exceptions;

/**
 * ファイル操作Exceptionクラス
 */
public class FileControlException extends WatchException {

    /**
     * コンストラクタ.
     *
     * @param code エラーコード
     */
    public FileControlException(String code) {
        super(code);
    }

    /**
     * コンストラクタ.
     *
     * @param code エラーコード
     * @param field フィールド
     * @param messageParameters パラメータ
     */
    public FileControlException(String code, String field, Object... messageParameters) {
        super(code, field, messageParameters);
    }

    /**
     * コンストラクタ.
     *
     * @param code エラーコード
     * @param cause 原因のThrowableオブジェクト.
     * {@link #getCode()}メソッドで参照するために保存します. 原因が存在しないまたは不明な場合のために<tt>null</tt>が許可されています.
     */
    public FileControlException(String code, Throwable cause) {
        super(code, cause);
    }

    /**
     * コンストラクタ.
     *
     * @param code エラーコード
     * @param message {@link String}
     * @param cause {@link Throwable}
     */
    public FileControlException(String code, String message, Throwable cause) {
        super(code, message, cause);
    }
}
