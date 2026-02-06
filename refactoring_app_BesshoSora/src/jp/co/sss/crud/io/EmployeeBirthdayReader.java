package jp.co.sss.crud.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
	 * @throws IOException 入力処理でエラーが発生した場合に送出
	 */
	public static String employeeBirthdayReader() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print(ConstantMsg.GUIDANCE_BIRTHDAY);
		return br.readLine();
	}

	/**
	 * 生年月日のコンソール入力(任意のメッセージ)
	 * 
	 * @author 別所大空
	 * @param message 入力案内メッセージ
	 * @return String 生年月日
	 * @throws IOException 入力処理でエラーが発生した場合に送出
	 */
	public static String employeeBirthdayReader(String message) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print(message);
		return br.readLine();
	}
}
