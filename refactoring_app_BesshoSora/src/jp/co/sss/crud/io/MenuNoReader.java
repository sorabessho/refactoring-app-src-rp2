package jp.co.sss.crud.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.util.ConstantMsg;

/**
 * メニュー番号のコンソール入力を行うクラス
 * 
 * @author 別所大空
 */
public class MenuNoReader {

	/**インスタンス化禁止*/
	private MenuNoReader() {
	}

	/**
	 * メニュー番号のコンソール入力
	 * 
	 * @author 別所大空
	 * @return int メニュー番号
	 * @throws IllegalInputException 不正な入力
	 */
	public static int menuNoReader() throws IllegalInputException, SystemErrorException {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			return Integer.parseInt(br.readLine());
		} catch (NumberFormatException e) {
			throw new IllegalInputException(ConstantMsg.MSG_ERROR_ILLEGAL_INPUT_EXCEPTION, e);
		} catch (IOException e) {
			throw new SystemErrorException(ConstantMsg.MSG_ERROR_SYSTEM_ERROR_EXCEPTION, e);
		}
	}
}
