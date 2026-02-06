package jp.co.sss.crud.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
	 * @throws NumberFormatException 文字列を数値に変換する際にエラーが発生した場合に送出
	 * @throws IOException 入力処理でエラーが発生した場合に送出
	 */
	public static int menuNoReader() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		return Integer.parseInt(br.readLine());
	}
}
