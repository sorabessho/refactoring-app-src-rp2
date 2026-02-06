package jp.co.sss.crud.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
	 * 社員IDのコンソール入力
	 * 
	 * @author 別所大空
	 * @return int 社員ID
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	public static int employeeEmpIdReader() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		return Integer.parseInt(br.readLine());
	}
}
