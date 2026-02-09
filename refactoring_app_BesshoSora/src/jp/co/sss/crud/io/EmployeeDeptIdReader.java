package jp.co.sss.crud.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.util.ConstantMsg;

/**
 * 部署IDのコンソール入力を行うクラス
 * 
 * @author 別所大空
 */
public class EmployeeDeptIdReader {

	/**インスタンス化禁止*/
	private EmployeeDeptIdReader() {
	}

	/**
	 * 部署IDのコンソール入力(デフォルトメッセージ)
	 * 
	 * @author 別所大空
	 * @return int 部署ID
	 * @throws IllegalInputException 不正な入力
	 * @throws SystemErrorException	 システムエラー
	 */

	public static int employeeDeptIdReader() throws IllegalInputException, SystemErrorException {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.print(ConstantMsg.GUIDANCE_DEPT_ID);
			return Integer.parseInt(br.readLine());
		} catch (NumberFormatException e) {
			throw new IllegalInputException(ConstantMsg.MSG_ERROR_ILLEGAL_INPUT_EXCEPTION, e);
		} catch (IOException e) {
			throw new SystemErrorException(ConstantMsg.MSG_ERROR_SYSTEM_ERROR_EXCEPTION, e);
		}
	}

	/**
	 * 部署IDのコンソール入力(任意のメッセージ)
	 * 
	 * @author 別所大空
	 * @param message 入力案内メッセージ
	 * @returnint 部署ID
	 * @throws IllegalInputException 不正な入力
	 * @throws SystemErrorException	 システムエラー
	 */
	public static int employeeDeptIdReader(String message) throws IllegalInputException, SystemErrorException {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.print(message);
			return Integer.parseInt(br.readLine());
		} catch (NumberFormatException e) {
			throw new IllegalInputException(ConstantMsg.MSG_ERROR_ILLEGAL_INPUT_EXCEPTION, e);
		} catch (IOException e) {
			throw new SystemErrorException(ConstantMsg.MSG_ERROR_SYSTEM_ERROR_EXCEPTION, e);
		}
	}
}
