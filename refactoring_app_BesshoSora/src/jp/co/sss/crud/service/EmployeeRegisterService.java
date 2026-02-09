package jp.co.sss.crud.service;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.io.ConsoleWriter;
import jp.co.sss.crud.io.EmployeeBirthdayReader;
import jp.co.sss.crud.io.EmployeeDeptIdReader;
import jp.co.sss.crud.io.EmployeeGenderReader;
import jp.co.sss.crud.io.EmployeeNameReader;

/**
 * 社員登録のサービスクラス
 * 
 * @author 別所大空
 */
public class EmployeeRegisterService {

	/**インスタンス化の禁止*/
	private EmployeeRegisterService() {
	}

	/**
	 * 社員情報を1件登録
	 * 
	 * @author 別所大空
	 * @throws SystemErrorException システムエラー
	 * @throws IllegalInputException 不正な入力
	 */
	public static void registEmp() throws SystemErrorException, IllegalInputException {
		//登録する値を入力
		Employee employee = new Employee();
		employee.setEmpName(EmployeeNameReader.employeeNameReader());
		employee.setGender(EmployeeGenderReader.employeeGenderReader());
		employee.setBirthday(EmployeeBirthdayReader.employeeBirthdayReader());
		employee.getDepartment().setDeptId(EmployeeDeptIdReader.employeeDeptIdReader());

		//機能の呼出
		int result = EmployeeDAO.registEmpDAO(employee);

		//処理完遂通知
		ConsoleWriter.checkCompleteRegistConsoleWriter(result);
	}
}
