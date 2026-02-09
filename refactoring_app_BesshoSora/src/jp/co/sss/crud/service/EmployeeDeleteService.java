package jp.co.sss.crud.service;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.io.ConsoleWriter;
import jp.co.sss.crud.io.EmployeeEmpIdReader;
import jp.co.sss.crud.util.ConstantMsg;

/**
 * 社員削除のサービスクラス
 * 
 * @author 別所大空
 */
public class EmployeeDeleteService {

	/**インスタンス化の禁止*/
	private EmployeeDeleteService() {
	}

	/**
	 * 社員情報を1件削除
	 * 
	 * @author 別所大空
	 * @throws SystemErrorException システムエラー
	 * @throws IllegalInputException 不正な入力
	 */
	public static void deleteByEmpId() throws IllegalInputException, SystemErrorException {
		// 削除する社員IDを入力
		int empId = (int) EmployeeEmpIdReader.employeeEmpIdReader(ConstantMsg.GUIDANCE_DELETE_BY_EMP_ID);

		//機能の呼出
		int result = EmployeeDAO.deleteByEmpIdDAO(empId);

		//処理完遂通知
		ConsoleWriter.checkCompleteDeleteConsoleWriter(result);
	}
}
