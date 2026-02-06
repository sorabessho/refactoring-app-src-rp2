package jp.co.sss.crud.service;

import java.sql.SQLException;
import java.util.List;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.io.ConsoleWriter;

/**
 * 全件検索のサービスクラス
 * 
 * @author 別所大空
 */
public class EmployeeAllFindService {

	/**インスタンス化の禁止*/
	private EmployeeAllFindService() {
	}

	/**
	 * 全ての社員情報を検索
	 * 
	 * @author 別所大空
	 * @throws ClassNotFoundException ドライバクラスが不在の場合に送出
	 * @throws SQLException DB処理でエラーが発生した場合に送出
	 */
	public static void findAll() throws ClassNotFoundException, SQLException {
		//機能の呼出
		List<Employee> employees = EmployeeDAO.findAllDAO();

		//結果出力
		ConsoleWriter.employeesConsoleWriter(employees);
	}
}
