package ksaito.fileWatchBatch.Utilities;

/**
 * システムユーティリティクラス
 */
public class SystemUtil {

    /**
     * コンソール出力メソッド
     * @param message
     */
    public static void print(String message) {
        System.out.println(message);

    }

    /**
     * アプリケーションを終了するメソッド
     * @param returnCode
     */
    public static void exit(int returnCode) {
        System.exit(returnCode);

    }

    /**
     * スタックトレースメソッド
     * @param errorMessage
     * @param exception
     */
    public static void statckTrace(String errorMessage, Throwable exception) {
        System.out.println(errorMessage);
        exception.printStackTrace();

    }

    /**
     * スタックトレースメソッド
     * @param exception
     */
    public static void statckTrace(Throwable exception) {
        exception.printStackTrace();

    }

}
