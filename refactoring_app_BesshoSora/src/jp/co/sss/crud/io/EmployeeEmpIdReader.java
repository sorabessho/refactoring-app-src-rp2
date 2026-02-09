package jp.co.sss.crud.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.util.ConstantMsg;

/**
 * 社員IDのコンソール入力を行うクラス
 * 
 * @author 別所大空
 */
public class EmployeeEmpIdReader {

	/**インスタンス化禁止*/
	private EmployeeEmpIdReader() {
	}

	/**
	 * 社員IDのコンソール入力（デフォルトメッセージ）
	 * 
	 * @author 別所大空
	 * @return int 社員ID
	 * @throws IllegalInputException 不正な入力
	 * @throws SystemErrorException システムエラー
	 */
	public static int employeeEmpIdReader() throws IllegalInputException, SystemErrorException {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			//入力案内
			System.out.print(ConstantMsg.GUIDANCE_EMP_ID);
			return Integer.parseInt(br.readLine());
		} catch (NumberFormatException e) {
			throw new IllegalInputException(ConstantMsg.MSG_ERROR_ILLEGAL_INPUT_EXCEPTION, e);
		} catch (IOException e) {
			throw new SystemErrorException(ConstantMsg.MSG_ERROR_SYSTEM_ERROR_EXCEPTION, e);
		}
	}

	/**
	 * 社員IDのコンソール入力（任意のメッセージ）
	 * 
	 * @param message 入力案内メッセージ
	 * @return int 社員ID
	 * @throws IllegalInputException 不正な入力
	 * @throws SystemErrorException システムエラー
	 */
	public static int employeeEmpIdReader(String message) throws IllegalInputException, SystemErrorException {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			//入力案内
			System.out.print(message);
			return Integer.parseInt(br.readLine());
		} catch (NumberFormatException e) {
			throw new IllegalInputException(ConstantMsg.MSG_ERROR_ILLEGAL_INPUT_EXCEPTION, e);
		} catch (IOException e) {
			throw new SystemErrorException(ConstantMsg.MSG_ERROR_SYSTEM_ERROR_EXCEPTION, e);
		}
	}
}
