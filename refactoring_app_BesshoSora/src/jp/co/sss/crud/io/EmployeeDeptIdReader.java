package jp.co.sss.crud.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
	 * @throws NumberFormatException 文字列を数値に変換する際にエラーが発生した場合に送出
	 * @throws IOException 入力処理でエラーが発生した場合に送出
	 */
	public static int employeeDeptIdReader() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print(ConstantMsg.GUIDANCE_DEPT_ID);
		return Integer.parseInt(br.readLine());
	}

	/**
	 * 部署IDのコンソール入力(任意のメッセージ)
	 * 
	 * @author 別所大空
	 * @param message 入力案内メッセージ
	 * @returnint 部署ID
	 * @throws NumberFormatException 文字列を数値に変換する際にエラーが発生した場合に送出
	 * @throws IOException 入力処理でエラーが発生した場合に送出
	 */
	public static int employeeDeptIdReader(String message) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print(message);
		return Integer.parseInt(br.readLine());
	}
}
