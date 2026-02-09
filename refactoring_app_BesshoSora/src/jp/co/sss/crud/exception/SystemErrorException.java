package jp.co.sss.crud.exception;

/**
 * システムエラーの独自例外クラス
 * 復帰不可能
 * SQLException、ClassNotFoundException、IOException発生時
 * 
 * @author 別所大空
 */
public class SystemErrorException extends Exception {
	/**
	 * 引数なしのスーパークラスを呼び出すコンストラクタ
	 * 
	 * @author 別所大空
	 */
	public SystemErrorException() {
		super();
	}

	/**
	 * 引数(メッセージ)ありのスーパークラスを呼び出すコンストラクタ
	 * 
	 * @author 別所大空
	 * @param message エラーメッセージ
	 */
	public SystemErrorException(String message) {
		super(message);
	}

	/**
	 * 引数(メッセージ、原因)ありのスーパークラスを呼び出すコンストラクタ
	 * 
	 * @author 別所大空
	 * @param message エラーメッセージ
	 * @param cause エラー情報
	 */
	public SystemErrorException(String message, Throwable cause) {
		super(message, cause);
	}
}
