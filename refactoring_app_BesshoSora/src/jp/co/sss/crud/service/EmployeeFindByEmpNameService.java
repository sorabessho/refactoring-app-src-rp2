package jp.co.sss.crud.service;

import java.util.List;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.io.ConsoleWriter;
import jp.co.sss.crud.io.EmployeeNameReader;

/**
 * 社員名検索のサービスクラス
 * 
 * @author 別所大空
 */
public class EmployeeFindByEmpNameService {

	/**インスタンス化の禁止*/
	private EmployeeFindByEmpNameService() {
	}

	/**
	 * 社員名に該当する社員情報を検索
	 * 
	 * @author 別所大空
	 * @throws SystemErrorException システムエラー
	 * @throws IllegalInputException 入力チェック、不正な入力
	 */
	public static void findByEmpName() throws SystemErrorException, IllegalInputException {
		//社員名入力
		String empName = (String) EmployeeNameReader.employeeNameReader();

		//機能の呼出
		List<Employee> employees = EmployeeDAO.findByEmpNameDAO(empName);

		//結果出力
		ConsoleWriter.employeesConsoleWriter(employees);
	}
}
