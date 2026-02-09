package jp.co.sss.crud.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.util.ConstantMsg;

/**
 * 社員名コンソール入力を行うクラス
 * 
 * @author 別所大空
 */
public class EmployeeNameReader implements IConsoleReader {

	/**インスタンス化禁止*/
	private EmployeeNameReader() {
	}

	/**
	 * 社員名コンソール入力(デフォルトメッセージ)
	 * 
	 * @author 別所大空
	 * @return Object(String) 社員名
	 * @throws SystemErrorException	 システムエラー
	 * @throws IllegalInputException 入力チェック、不正な入力
	 */
	public static Object employeeNameReader() throws SystemErrorException, IllegalInputException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		EmployeeNameReader employeeNameReader = new EmployeeNameReader();
		String input = null;

		try {
			//コンソール入力、入力チェック
			System.out.print(ConstantMsg.GUIDANCE_EMP_NAME);
			input = br.readLine();
			if (!employeeNameReader.isValid(input)) {
				String errorMessage = employeeNameReader.getErrorMsg();
				throw new IllegalInputException(errorMessage);
			}
			if (employeeNameReader.isParseInt()) {
				return Integer.parseInt(input);
			}

		} catch (IOException e) {
			throw new SystemErrorException(ConstantMsg.MSG_ERROR_SYSTEM_ERROR_EXCEPTION, e);
		}

		return input;
	}

	/**
	 * 社員名コンソール入力(任意のメッセージ)
	 * 
	 * @author 別所大空
	 * @param message 入力案内メッセージ
	 * @return Object(String) 社員名
	 * @throws SystemErrorException	 システムエラー
	 * @throws IllegalInputException 入力チェック、不正な入力
	 */
	public static Object employeeNameReader(String message) throws SystemErrorException, IllegalInputException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		EmployeeNameReader employeeNameReader = new EmployeeNameReader();
		String input = null;

		try {
			//コンソール入力、入力チェック
			System.out.print(message);
			input = br.readLine();
			if (!employeeNameReader.isValid(input)) {
				String errorMessage = employeeNameReader.getErrorMsg();
				throw new IllegalInputException(errorMessage);
			}
			if (employeeNameReader.isParseInt()) {
				return Integer.parseInt(input);
			}

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
		return ConstantMsg.MSG_VAILD_EMP_NAME;
	}

	/**
	 * 入力文字列のバリデーションメソッド
	 * 
	 * @author 別所大空
	 * @param inputString コンソール入力した文字列
	 * @return inputStringが適正な値であるときはtrue、そうでないときはfalseを返す。
	 */
	public boolean isValid(String inputString) {
		//空白、nullチェック
		if (inputString.isBlank()) {
			return false;
		}
		//文字数チェック
		if (1 <= inputString.length() && inputString.length() >= 30) {
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
		return false;
	}
}
