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
 * 社員IDのコンソール入力を行うクラス
 * 
 * @author 別所大空
 */
public class EmployeeEmpIdReader implements IConsoleReader {

	/**インスタンス化禁止*/
	private EmployeeEmpIdReader() {
	}

	/**
	 * 社員IDのコンソール入力（デフォルトメッセージ）
	 * 
	 * @author 別所大空
	 * @return Object(int) 社員ID
	 * @throws IllegalInputException 不正な入力
	 * @throws SystemErrorException システムエラー
	 */
	public static Object employeeEmpIdReader() throws IllegalInputException, SystemErrorException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		EmployeeEmpIdReader employeeEmpIdReader = new EmployeeEmpIdReader();
		String input = null;
		try {
			//コンソール入力、入力チェック
			System.out.print(ConstantMsg.GUIDANCE_EMP_ID);
			input = br.readLine();
			if (!employeeEmpIdReader.isValid(input)) {
				String errorMessage = employeeEmpIdReader.getErrorMsg();
				throw new IllegalInputException(errorMessage);
			}
			if (employeeEmpIdReader.isParseInt()) {
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
	 * 社員IDのコンソール入力（任意のメッセージ）
	 * 
	 * @param message 入力案内メッセージ
	 * @return Object(int) 社員ID
	 * @throws IllegalInputException 不正な入力
	 * @throws SystemErrorException システムエラー
	 */
	public static Object employeeEmpIdReader(String message) throws IllegalInputException, SystemErrorException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		EmployeeEmpIdReader employeeEmpIdReader = new EmployeeEmpIdReader();
		String input = null;
		try {
			//コンソール入力、入力チェック
			System.out.print(message);
			input = br.readLine();
			if (!employeeEmpIdReader.isValid(input)) {
				String errorMessage = employeeEmpIdReader.getErrorMsg();
				throw new IllegalInputException(errorMessage);
			}
			if (employeeEmpIdReader.isParseInt()) {
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
		return ConstantMsg.MSG_VAILD_EMP_ID;
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
		Pattern p = Pattern.compile(ConstantMsg.VAILD_PATTERN_EMP_ID);
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
