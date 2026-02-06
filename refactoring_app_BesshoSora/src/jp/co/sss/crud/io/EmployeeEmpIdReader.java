package jp.co.sss.crud.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
	 * @throws NumberFormatException 文字列を数値に変換する際にエラーが発生した場合に送出
	 * @throws IOException 入力処理でエラーが発生した場合に送出
	 */
	public static int employeeEmpIdReader() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//入力案内
		System.out.print(ConstantMsg.GUIDANCE_EMP_ID);
		return Integer.parseInt(br.readLine());
	}

	/**
	 * 社員IDのコンソール入力（任意のメッセージ）
	 * 
	 * @param message 入力案内メッセージ
	 * @return int 社員ID
	 * @throws NumberFormatException 文字列を数値に変換する際にエラーが発生した場合に送出
	 * @throws IOException 入力処理でエラーが発生した場合に送出
	 */
	public static int employeeEmpIdReader(String message) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//入力案内
		System.out.print(message);
		return Integer.parseInt(br.readLine());
	}
}
