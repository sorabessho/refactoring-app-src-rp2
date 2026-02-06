package jp.co.sss.crud.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.List;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.util.ConstantMsg;

public class EmployeeFindByEmpNameService {

	/**インスタンス化の禁止*/
	private EmployeeFindByEmpNameService() {
	}

	/**
	 * 社員名に該当する社員情報を検索
	 * 
	 * @author 別所大空
	 * @throws ClassNotFoundException ドライバクラスが不在の場合に送出
	 * @throws SQLException DB処理でエラーが発生した場合に送出
	 * @throws IOException 入力処理でエラーが発生した場合に送出
	 */
	public static void findByEmpName() throws ClassNotFoundException, SQLException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		//社員名入力
		System.out.print(ConstantMsg.GUIDANCE_EMP_NAME);
		String empName = br.readLine();

		//機能の呼出
		List<Employee> employees = EmployeeDAO.findByEmpNameDAO(empName);

		//nullチェック
		if (employees == null) {
			System.out.println(ConstantMsg.NOTICE_FIND_COMPLETE_ANYONE);
			return;
		}

		//従業員のコンソール出力
		System.out.println(ConstantMsg.HEADER_FIND_RESULT);
		for (Employee employee : employees) {
			System.out.println(employee);
		}
	}
}
