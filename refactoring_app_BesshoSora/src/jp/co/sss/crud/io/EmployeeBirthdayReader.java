package jp.co.sss.crud.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.util.ConstantMsg;

/**
 * 生年月日のコンソール入力を行うクラス
 * 
 * @author 別所大空
 */
public class EmployeeBirthdayReader {

	/**インスタンス化禁止*/
	private EmployeeBirthdayReader() {
	}

	/**
	 * 生年月日のコンソール入力(デフォルトメッセージ)
	 * 
	 * @author 別所大空
	 * @return String 生年月日
	 * @throws IllegalInputException 不正な入力
	 * @throws SystemErrorException	 システムエラー
	 */
	public static String employeeBirthdayReader() throws SystemErrorException {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.print(ConstantMsg.GUIDANCE_BIRTHDAY);
			return br.readLine();
		} catch (IOException e) {
			throw new SystemErrorException(ConstantMsg.MSG_ERROR_SYSTEM_ERROR_EXCEPTION, e);
		}
	}

	/**
	 * 生年月日のコンソール入力(任意のメッセージ)
	 * 
	 * @author 別所大空
	 * @param message 入力案内メッセージ
	 * @return String 生年月日
	 * @throws IllegalInputException 不正な入力
	 * @throws SystemErrorException	 システムエラー
	 */
	public static String employeeBirthdayReader(String message) throws SystemErrorException {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.print(message);
			return br.readLine();
		} catch (IOException e) {
			throw new SystemErrorException(ConstantMsg.MSG_ERROR_SYSTEM_ERROR_EXCEPTION, e);
		}

	}
}
