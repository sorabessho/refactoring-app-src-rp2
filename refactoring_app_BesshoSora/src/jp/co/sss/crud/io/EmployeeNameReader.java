package jp.co.sss.crud.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.util.ConstantMsg;

/**
 * 社員名コンソール入力を行うクラス
 * 
 * @author 別所大空
 */
public class EmployeeNameReader {

	/**インスタンス化禁止*/
	private EmployeeNameReader() {
	}

	/**
	 * 社員名コンソール入力(デフォルトメッセージ)
	 * 
	 * @author 別所大空
	 * @return String 社員名
	 * @throws SystemErrorException	 システムエラー
	 */
	public static String employeeNameReader() throws SystemErrorException {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.print(ConstantMsg.GUIDANCE_EMP_NAME);
			return br.readLine();
		} catch (IOException e) {
			throw new SystemErrorException(ConstantMsg.MSG_ERROR_SYSTEM_ERROR_EXCEPTION, e);
		}

	}

	/**
	 * 社員名コンソール入力(任意のメッセージ)
	 * 
	 * @author 別所大空
	 * @param message 入力案内メッセージ
	 * @return String 社員名
	 * @throws SystemErrorException	 システムエラー
	 */
	public static String employeeNameReader(String message) throws SystemErrorException {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.print(message);
			return br.readLine();
		} catch (IOException e) {
			throw new SystemErrorException(ConstantMsg.MSG_ERROR_SYSTEM_ERROR_EXCEPTION, e);
		}

	}
}
