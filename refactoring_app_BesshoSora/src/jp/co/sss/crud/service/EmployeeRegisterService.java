package jp.co.sss.crud.service;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.dto.Employee;
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
	 * @throws IOException 入力処理でエラーが発生した場合に送出
	 * @throws ClassNotFoundException ドライバクラスが不在の場合に送出
	 * @throws SQLException DB処理でエラーが発生した場合に送出
	 * @throws ParseException 形式処理でエラーが発生した場合に送出
	 */
	public static void registEmp() throws IOException, ClassNotFoundException, SQLException, ParseException {
		//登録する値を入力
		Employee employee = new Employee();
		employee.setEmpName(EmployeeNameReader.employeeNameReader());
		employee.setGender(EmployeeGenderReader.employeeGenderReader());
		employee.setBirthday(EmployeeBirthdayReader.employeeBirthdayReader());
		employee.getDepartment().setDeptId(EmployeeDeptIdReader.employeeDeptIdReader());

		//機能の呼出
		int result = EmployeeDAO.registEmpDAO(employee);

		//処理完遂通知
		ConsoleWriter.checkCompleteConsoleWriter(result);
	}
}
