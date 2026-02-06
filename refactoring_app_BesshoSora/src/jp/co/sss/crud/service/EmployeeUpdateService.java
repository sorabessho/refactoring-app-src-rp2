package jp.co.sss.crud.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.text.ParseException;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.util.ConstantMsg;

public class EmployeeUpdateService {

	/**インスタンス化の禁止*/
	private EmployeeUpdateService() {
	}

	/**
	 * 社員情報を1件更新
	 * 
	 * @author 別所大空
	 * @throws NumberFormatException 文字列を数値に変換する際にエラーが発生した場合に送出
	 * @throws IOException 入力処理でエラーが発生した場合に送出
	 * @throws ClassNotFoundException ドライバクラスが不在の場合に送出
	 * @throws SQLException DB処理でエラーが発生した場合に送出
	 * @throws ParseException 形式処理でエラーが発生した場合に送出
	 */
	public static void updateByEmpId()
			throws NumberFormatException, IOException, ClassNotFoundException, SQLException, ParseException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		//更新する値を入力
		Employee employee = new Employee();
		System.out.print(ConstantMsg.GUIDANCE_UPDATE_BY_EMP_ID);
		employee.setEmpId(Integer.parseInt(br.readLine()));
		System.out.print(ConstantMsg.INPUT_INSERT_EMP_NAME);
		employee.setEmpName(br.readLine());
		System.out.print(ConstantMsg.INPUT_INSERT_GENDER);
		employee.setGender(Integer.parseInt(br.readLine()));
		System.out.print(ConstantMsg.INPUT_INSERT_BIRTHDAY);
		employee.setBirthday(br.readLine());
		System.out.print(ConstantMsg.INPUT_INSERT_DEPT_ID);
		employee.getDepartment().setDeptId(Integer.parseInt(br.readLine()));

		//機能の呼出
		int result = EmployeeDAO.updateByEmpIdDAO(employee);

		//処理完遂チェック（失敗の場合-result == 0）
		if (result == 0) {
			//更新失敗メッセージ
			System.out.println(ConstantMsg.NOTICE_FAILED);
		} else {
			//更新完了メッセージ
			System.out.println(ConstantMsg.NOTICE_UPDATE_BY_EMP_ID_COMPLETE);
		}
	}
}
