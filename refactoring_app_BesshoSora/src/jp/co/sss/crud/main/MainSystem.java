package jp.co.sss.crud.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.text.ParseException;

import jp.co.sss.crud.db.DBController;
import jp.co.sss.crud.util.ConstantMsg;
import jp.co.sss.crud.util.ConstantValue;

/**
 * 社員情報管理システム開始クラス 社員情報管理システムはこのクラスから始まる。<br/>
 * メニュー画面を表示する。
 *
 * @author System Shared
 *
 */
public class MainSystem {
	/**
	 * 社員管理システムを起動
	 *
	 * @throws IOException 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException, ParseException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int menuNo = ConstantValue.MENU_NUMBER_0;

		do {
			// メニューの表示
			System.out.println(ConstantMsg.MENU_TITLE);
			System.out.println(ConstantValue.MENU_NUMBER_1 + ConstantMsg.MENU_FIND_ALL);
			System.out.println(ConstantValue.MENU_NUMBER_2 + ConstantMsg.MENU_FIND_BY_EMP_NAME);
			System.out.println(ConstantValue.MENU_NUMBER_3 + ConstantMsg.MENU_FIND_BY_DEPT_ID);
			System.out.println(ConstantValue.MENU_NUMBER_4 + ConstantMsg.MENU_INSERT_EMP);
			System.out.println(ConstantValue.MENU_NUMBER_5 + ConstantMsg.MENU_UPDATE_EMP_BY_EMP_ID);
			System.out.println(ConstantValue.MENU_NUMBER_6 + ConstantMsg.MENU_DELETE_BY_EMP_ID);
			System.out.println(ConstantValue.MENU_NUMBER_7 + ConstantMsg.MENU_FINISH);
			System.out.print(ConstantMsg.MENU_INPUT_NUMBER);

			// メニュー番号の入力
			menuNo = Integer.parseInt(br.readLine());

			// 機能の呼出
			switch (menuNo) {
			case ConstantValue.MENU_NUMBER_1:
				// 全件表示機能の呼出
				DBController.findAll();
				break;

			case ConstantValue.MENU_NUMBER_2:
				// 社員名検索
				System.out.print(ConstantMsg.GUIDANCE_EMP_NAME);

				// 検索機能の呼出
				DBController.findByEmpId();
				break;

			case ConstantValue.MENU_NUMBER_3:
				// 検索する部署IDを入力
				System.out.print(ConstantMsg.GUIDANCE_FIND_BY_DEPT_ID);

				// 検索機能の呼出
				DBController.findByDeptId();
				break;

			case ConstantValue.MENU_NUMBER_4:
				// 登録機能の呼出
				DBController.insertEmp();
				break;

			case ConstantValue.MENU_NUMBER_5:
				// 更新機能の呼出
				DBController.updateByEmpId();
				break;

			case ConstantValue.MENU_NUMBER_6:
				// 削除する社員IDを入力
				System.out.print(ConstantMsg.GUIDANCE_DELETE_BY_EMP_ID);

				// 削除機能の呼出
				DBController.deleteByEmpId();
				break;

			}
		} while (menuNo != ConstantValue.MENU_NUMBER_7);
		System.out.println(ConstantMsg.NOTICE_FINISH);
	}
}
