package jp.co.sss.crud.service;

import java.util.List;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
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
	 * @throws SystemErrorException システムエラー
	 * @throws IllegalInputException 不正な入力
	 */
	public static void findByDeptId() throws IllegalInputException, SystemErrorException {
		// 検索する部署IDを入力
		int deptId = EmployeeDeptIdReader.employeeDeptIdReader(ConstantMsg.GUIDANCE_FIND_BY_DEPT_ID);

		//機能の呼出
		List<Employee> employees = EmployeeDAO.findByDeptIdDAO(deptId);

		//結果出力
		ConsoleWriter.employeesConsoleWriter(employees);
	}
}
