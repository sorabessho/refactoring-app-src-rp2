package jp.co.sss.crud.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;

import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.util.ConstantMsg;

/**
 * 生年月日のコンソール入力を行うクラス
 * 
 * @author 別所大空
 */
public class EmployeeBirthdayReader implements IConsoleReader {

	/**インスタンス化禁止*/
	private EmployeeBirthdayReader() {
	}

	/**
	 * 生年月日のコンソール入力(デフォルトメッセージ)
	 * 
	 * @author 別所大空
	 * @return Object(String) 生年月日
	 * @throws IllegalInputException 不正な入力
	 * @throws SystemErrorException	 システムエラー
	 */
	public static Object employeeBirthdayReader() throws SystemErrorException, IllegalInputException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		EmployeeBirthdayReader employeeBirthdayReader = new EmployeeBirthdayReader();
		String input = null;
		try {
			//コンソール入力、入力チェック
			System.out.print(ConstantMsg.GUIDANCE_BIRTHDAY);
			input = br.readLine();
			if (!employeeBirthdayReader.isValid(input)) {
				String errorMessage = employeeBirthdayReader.getErrorMsg();
				throw new IllegalInputException(errorMessage);
			}
			if (employeeBirthdayReader.isParseInt()) {
				return Integer.parseInt(input);
			}

		} catch (IOException e) {
			throw new SystemErrorException(ConstantMsg.MSG_ERROR_SYSTEM_ERROR_EXCEPTION, e);
		}

		return input;
	}

	/**
	 * 生年月日のコンソール入力(任意のメッセージ)
	 * 
	 * @author 別所大空
	 * @param message 入力案内メッセージ
	 * @return Object(String) 生年月日
	 * @throws IllegalInputException 不正な入力
	 * @throws SystemErrorException	 システムエラー
	 */
	public static Object employeeBirthdayReader(String message) throws SystemErrorException, IllegalInputException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		EmployeeBirthdayReader employeeBirthdayReader = new EmployeeBirthdayReader();
		String input = null;
		try {
			//コンソール入力、入力チェック
			System.out.print(ConstantMsg.GUIDANCE_BIRTHDAY);
			input = br.readLine();
			if (!employeeBirthdayReader.isValid(input)) {
				String errorMessage = employeeBirthdayReader.getErrorMsg();
				throw new IllegalInputException(errorMessage);
			}
			if (employeeBirthdayReader.isParseInt()) {
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
		return ConstantMsg.MSG_VAILD_DATE;
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
		//日付チェック
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(ConstantMsg.VAILD_PATTERN_DATE)
				.withResolverStyle(ResolverStyle.STRICT);
		try {
			LocalDate date = LocalDate.parse(inputString, dateTimeFormatter);
			return !date.isAfter(LocalDate.now());
		} catch (DateTimeParseException e) {
			return false;
		}
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
