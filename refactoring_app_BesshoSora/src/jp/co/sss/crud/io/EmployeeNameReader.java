package jp.co.sss.crud.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
	 * 社員名コンソール入力
	 * 
	 * @author 別所大空
	 * @return String 社員名
	 * @throws IOException 入力処理でエラーが発生した場合に送出
	 */
	public static String employeeNameReader() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		return br.readLine();
	}
}
