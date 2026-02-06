package jp.co.sss.crud.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 性別のコンソール入力を行うクラス
 * 
 * @author 別所大空
 */
public class EmployeeGenderReader {

	/**インスタンス化禁止*/
	private EmployeeGenderReader() {
	}

	/**
	 * 性別のコンソール入力
	 * 
	 * @author 別所大空
	 * @return int 性別（0:回答なし 1:男性 2:女性 9:その他）
	 * @throws NumberFormatException 文字列を数値に変換する際にエラーが発生した場合に送出
	 * @throws IOException 入力処理でエラーが発生した場合に送出
	 */
	public static int employeeGenderReader() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		return Integer.parseInt(br.readLine());
	}
}
