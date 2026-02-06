package jp.co.sss.crud.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
	 * 生年月日のコンソール入力
	 * 
	 * @author 別所大空
	 * @return String 生年月日
	 * @throws IOException 入力処理でエラーが発生した場合に送出
	 */
	public static String employeeBirthdayReader() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		return br.readLine();
	}
}
