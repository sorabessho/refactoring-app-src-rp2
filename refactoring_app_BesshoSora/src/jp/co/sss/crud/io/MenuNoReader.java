package jp.co.sss.crud.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.util.ConstantMsg;

/**
 * メニュー番号のコンソール入力を行うクラス
 * 
 * @author 別所大空
 */
public class MenuNoReader implements IConsoleReader {

	/**インスタンス化禁止*/
	private MenuNoReader() {
	}

	/**
	 * メニュー番号のコンソール入力
	 * 
	 * @author 別所大空
	 * @return Object(int) メニュー番号
	 * @throws IllegalInputException 不正な入力
	 */
	public static Object menuNoReader() throws IllegalInputException, SystemErrorException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		MenuNoReader menuNoReader = new MenuNoReader();
		String input = null;
		try {
			//コンソール入力、入力チェック
			input = br.readLine();
			if (!menuNoReader.isValid(input)) {
				String errorMessage = menuNoReader.getErrorMsg();
				throw new IllegalInputException(errorMessage);
			}
			if (menuNoReader.isParseInt()) {
				return Integer.parseInt(input);
			}

		} catch (NumberFormatException e) {
			throw new IllegalInputException(ConstantMsg.MSG_ERROR_ILLEGAL_INPUT_EXCEPTION, e);
		} catch (IOException e) {
			throw new SystemErrorException(ConstantMsg.MSG_ERROR_SYSTEM_ERROR_EXCEPTION, e);
		}

		return input;
	}

	/**
	 * エラーメッセージを返すメソッド
	 * 
	 * @author 別所大空
	 * @return 入力条件のエラーメッセージ
	 */
	@Override
	public String getErrorMsg() {
		return ConstantMsg.MSG_VAILD_MENU_NUMBER;
	}

	/**
	 * 入力文字列のバリデーションメソッド
	 * 
	 * @author 別所大空
	 * @param inputString コンソール入力した文字列
	 * @return inputStringが適正な値であるときはtrue、そうでないときはfalseを返す。
	 */
	@Override
	public boolean isValid(String inputString) {
		//空白、nullチェック
		if (inputString.isBlank()) {
			return false;
		}
		//正規表現チェック
		Pattern p = Pattern.compile("^[1-7１-７]{1}$");
		Matcher m = p.matcher(inputString);
		if (!m.find()) {
			return false;
		}
		return true;
	}

	/**
	 * コンソール入力した文字列をintに変換するかどうかを返す。
	 * 
	 * @author 別所大空
	 * @return inputをint型へ変換する必要があるときはtrue、そうでないときはfalseを返す。
	 */
	@Override
	public boolean isParseInt() {
		return true;
	}
}
