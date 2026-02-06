package jp.co.sss.crud.service;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.io.EmployeeBirthdayReader;
import jp.co.sss.crud.io.EmployeeDeptIdReader;
import jp.co.sss.crud.io.EmployeeGenderReader;
import jp.co.sss.crud.io.EmployeeNameReader;
import jp.co.sss.crud.util.ConstantMsg;

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
		System.out.print(ConstantMsg.GUIDANCE_EMP_NAME);
		employee.setEmpName(EmployeeNameReader.employeeNameReader());
		System.out.print(ConstantMsg.GUIDANCE_GENDER);
		employee.setGender(EmployeeGenderReader.employeeGenderReader());
		System.out.print(ConstantMsg.GUIDANCE_BIRTHDAY);
		employee.setBirthday(EmployeeBirthdayReader.employeeBirthdayReader());
		System.out.print(ConstantMsg.GUIDANCE_DEPT_ID);
		employee.getDepartment().setDeptId(EmployeeDeptIdReader.employeeDeptIdReader());

		//機能の呼出
		int result = EmployeeDAO.registEmpDAO(employee);

		//処理完遂チェック（失敗の場合-result == 0）
		if (result == 0) {
			//登録失敗メッセージ
			System.out.println(ConstantMsg.NOTICE_FAILED);
		} else {
			// 登録完了メッセージ
			System.out.println(ConstantMsg.NOTICE_INSERT_COMPLETE);

		}

	}
}
