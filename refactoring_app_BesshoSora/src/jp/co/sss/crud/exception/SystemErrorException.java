package jp.co.sss.crud.exception;

/**
 * システムエラーの独自例外クラス
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
	 * 引数ありのスーパークラスを呼び出すコンストラクタ
	 * 
	 * @param message エラーメッセージ
	 */
	public SystemErrorException(String message) {
		super(message);
	}
}
