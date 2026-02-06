package jp.co.sss.crud.exception;

/**
 * 不正な入力の独自例外クラス
 * 
 * @author 別所大空
 */
public class IllegalInputException extends Exception {
	/**
	 * 引数なしのスーパークラスを呼び出すコンストラクタ
	 * 
	 * @author 別所大空
	 */
	public IllegalInputException() {
		super();
	}

	/**
	 * 引数ありのスーパークラスを呼び出すコンストラクタ
	 * 
	 * @param message エラーメッセージ
	 */
	public IllegalInputException(String message) {
		super(message);
	}
}
