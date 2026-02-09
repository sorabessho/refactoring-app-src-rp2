package jp.co.sss.crud.service;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.io.ConsoleWriter;
import jp.co.sss.crud.io.EmployeeBirthdayReader;
import jp.co.sss.crud.io.EmployeeDeptIdReader;
import jp.co.sss.crud.io.EmployeeEmpIdReader;
import jp.co.sss.crud.io.EmployeeGenderReader;
import jp.co.sss.crud.io.EmployeeNameReader;
import jp.co.sss.crud.util.ConstantMsg;

/**
 * 社員更新のサービスクラス
 * 
 * @author 別所大空
 */
public class EmployeeUpdateService {

	/**インスタンス化の禁止*/
	private EmployeeUpdateService() {
	}

	/**
	 * 社員情報を1件更新
	 * 
	 * @author 別所大
	 * @throws SystemErrorException システムエラー
	 * @throws IllegalInputException 不正な入力
	 */
	public static void updateByEmpId()
			throws IllegalInputException, SystemErrorException {
		//更新する値を入力
		Employee employee = new Employee();
		employee.setEmpId(EmployeeEmpIdReader.employeeEmpIdReader(ConstantMsg.GUIDANCE_UPDATE_BY_EMP_ID));
		employee.setEmpName(EmployeeNameReader.employeeNameReader());
		employee.setGender(EmployeeGenderReader.employeeGenderReader());
		employee.setBirthday(EmployeeBirthdayReader.employeeBirthdayReader());
		employee.getDepartment().setDeptId(EmployeeDeptIdReader.employeeDeptIdReader());

		//機能の呼出
		int result = EmployeeDAO.updateByEmpIdDAO(employee);

		//処理完遂通知
		ConsoleWriter.checkCompleteUpdateConsoleWriter(result);
	}
}
