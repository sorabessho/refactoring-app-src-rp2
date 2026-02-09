package jp.co.sss.crud.exception;

/**
 * 不正な入力の独自例外クラス
 * 復帰可能
 * ParseException、NumberFormatException発生時
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
	 * @author 別所大空
	 * @param message エラーメッセージ
	 * @param cause エラー情報
	 */
	public IllegalInputException(String message, Throwable cause) {
		super(message, cause);
	}
}
