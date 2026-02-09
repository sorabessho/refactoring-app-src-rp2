package jp.co.sss.crud.io;

import java.util.List;

import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.util.ConstantMsg;
import jp.co.sss.crud.util.ConstantValue;

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
	 * メニューの表示
	 * 
	 * @author 別所大空
	 */
	public static void showMenu() {
		System.out.println(ConstantMsg.MENU_TITLE);
		System.out.println(ConstantValue.MENU_NUMBER_1 + ConstantMsg.MENU_FIND_ALL);
		System.out.println(ConstantValue.MENU_NUMBER_2 + ConstantMsg.MENU_FIND_BY_EMP_NAME);
		System.out.println(ConstantValue.MENU_NUMBER_3 + ConstantMsg.MENU_FIND_BY_DEPT_ID);
		System.out.println(ConstantValue.MENU_NUMBER_4 + ConstantMsg.MENU_REGIST_EMP);
		System.out.println(ConstantValue.MENU_NUMBER_5 + ConstantMsg.MENU_UPDATE_EMP_BY_EMP_ID);
		System.out.println(ConstantValue.MENU_NUMBER_6 + ConstantMsg.MENU_DELETE_BY_EMP_ID);
		System.out.println(ConstantValue.MENU_NUMBER_7 + ConstantMsg.MENU_FINISH);
		System.out.print(ConstantMsg.MENU_INPUT_NUMBER);
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
	 * 登録の際の処理完遂チェック
	 * 
	 * @author 別所大空
	 * @param result 登録メソッドの戻り値
	 */
	public static void checkCompleteRegistConsoleWriter(int result) {
		//処理完遂チェック（失敗の場合-result == 0）
		if (result == 0) {
			//登録失敗メッセージ
			System.out.println(ConstantMsg.NOTICE_FAILED);
		} else {
			// 登録完了メッセージ
			System.out.println(ConstantMsg.NOTICE_REGIST_COMPLETE);
		}
	}

	/**
	 * 登録、更新、削除の際の処理完遂チェック
	 * 
	 * @author 別所大空
	 * @param result 更新メソッドの戻り値
	 */
	public static void checkCompleteUpdateConsoleWriter(int result) {
		//処理完遂チェック（失敗の場合-result == 0）
		if (result == 0) {
			//登録失敗メッセージ
			System.out.println(ConstantMsg.NOTICE_FAILED);
		} else {
			// 登録完了メッセージ
			System.out.println(ConstantMsg.NOTICE_UPDATE_BY_EMP_ID_COMPLETE);
		}
	}

	/**
	 * 登録、更新、削除の際の処理完遂チェック
	 * 
	 * @author 別所大空
	 * @param result 削除メソッドの戻り値
	 */
	public static void checkCompleteDeleteConsoleWriter(int result) {
		//処理完遂チェック（失敗の場合-result == 0）
		if (result == 0) {
			//登録失敗メッセージ
			System.out.println(ConstantMsg.NOTICE_FAILED);
		} else {
			// 登録完了メッセージ
			System.out.println(ConstantMsg.NOTICE_DELETE_COMPLETE);
		}
	}
}
