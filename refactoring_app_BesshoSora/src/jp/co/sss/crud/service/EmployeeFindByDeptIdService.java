package jp.co.sss.crud.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.io.ConsoleWriter;
import jp.co.sss.crud.io.EmployeeDeptIdReader;
import jp.co.sss.crud.util.ConstantMsg;

/**
 * 部署ID検索のサービスクラス
 * 
 * @author 別所大空
 */
public class EmployeeFindByDeptIdService {

	/**インスタンス化の禁止*/
	private EmployeeFindByDeptIdService() {
	}

	/**
	 * 部署IDに該当する社員情報を検索
	 * 
	 * @author 別所大空
	 * @throws NumberFormatException 文字列を数値に変換する際にエラーが発生した場合に送出
	 * @throws IOException 入力処理でエラーが発生した場合に送出
	 * @throws ClassNotFoundException ドライバクラスが不在の場合に送出
	 * @throws SQLException DB処理でエラーが発生した場合に送出
	 */
	public static void findByDeptId() throws NumberFormatException, IOException, ClassNotFoundException, SQLException {
		// 検索する部署IDを入力
		System.out.print(ConstantMsg.GUIDANCE_FIND_BY_DEPT_ID);
		int deptId = EmployeeDeptIdReader.employeeDeptIdReader();

		//機能の呼出
		List<Employee> employees = EmployeeDAO.findByDeptIdDAO(deptId);

		//結果出力
		ConsoleWriter.employeesConsoleWriter(employees);
	}
}
