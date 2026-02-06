package jp.co.sss.crud.service;

import java.io.IOException;
import java.sql.SQLException;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.io.ConsoleWriter;
import jp.co.sss.crud.io.EmployeeEmpIdReader;
import jp.co.sss.crud.util.ConstantMsg;

public class EmployeeDeleteService {

	/**インスタンス化の禁止*/
	private EmployeeDeleteService() {
	}

	/**
	 * 社員情報を1件削除
	 * 
	 * @author 別所大空
	 * @throws NumberFormatException 文字列を数値に変換する際にエラーが発生した場合に送出
	 * @throws IOException 入力処理でエラーが発生した場合に送出
	 * @throws ClassNotFoundException ドライバクラスが不在の場合に送出
	 * @throws SQLException DB処理でエラーが発生した場合に送出
	 */
	public static void deleteByEmpId() throws NumberFormatException, IOException, ClassNotFoundException, SQLException {

		// 削除する社員IDを入力
		System.out.print(ConstantMsg.GUIDANCE_DELETE_BY_EMP_ID);
		int empId = EmployeeEmpIdReader.employeeEmpIdReader();

		//機能の呼出
		int result = EmployeeDAO.deleteByEmpIdDAO(empId);

		//処理完遂通知
		ConsoleWriter.checkCompleteConsoleWriter(result);
	}
}
