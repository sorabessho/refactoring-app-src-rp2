package jp.co.sss.crud.io;

import java.util.List;

import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.util.ConstantMsg;

/**
 * コンソール出力を行うクラス。
 * 出力する際の諸チェックもここで行う。
 * 
 * @author 別所大空
 */
public class ConsoleWriter {

	/**インスタンス化禁止*/
	private ConsoleWriter() {
	}

	/**
	 * 社員リストをコンソール出力
	 * nullチェック
	 * 
	 * @author 別所大空
	 * @param employees 社員リスト
	 */
	public static void employeesConsoleWriter(List<Employee> employees) {
		//nullチェック
		if (employees == null) {
			System.out.println(ConstantMsg.NOTICE_FIND_COMPLETE_ANYONE);
			return;
		}

		//従業員のコンソール出力
		System.out.println(ConstantMsg.HEADER_FIND_RESULT);
		for (Employee employee : employees) {
			System.out.println(employee);
		}
	}

	/**
	 * 登録、更新、削除の際の処理完遂チェック
	 * 
	 * @author 別所大空
	 * @param result 登録、更新、削除メソッドの戻り値
	 */
	public static void checkCompleteConsoleWriter(int result) {
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
