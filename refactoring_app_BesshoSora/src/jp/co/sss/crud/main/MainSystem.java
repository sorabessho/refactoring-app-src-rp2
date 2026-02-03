package jp.co.sss.crud.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.text.ParseException;

import jp.co.sss.crud.db.DBController;
import jp.co.sss.crud.util.ConstantMsg;

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

		int menuNo = 0;
		//使用する変数を宣言
		String empId;
		String deptId;
		String empName;
		String gender;
		String birthday;

		do {
			// メニューの表示
			System.out.println(ConstantMsg.MENU_TITLE);
			System.out.println(ConstantMsg.MENU_FIND_ALL);
			System.out.println(ConstantMsg.MENU_FIND_BY_EMP_NAME);
			System.out.println(ConstantMsg.MENU_FIND_BY_DEPT_ID);
			System.out.println(ConstantMsg.MENU_INSERT_EMP);
			System.out.println(ConstantMsg.MENU_UPDATE_EMP_BY_EMP_ID);
			System.out.println(ConstantMsg.MENU_DELETE_BY_EMP_ID);
			System.out.println(ConstantMsg.MENU_FINISH);
			System.out.print(ConstantMsg.MENU_INPUT_NUMBER);

			// メニュー番号の入力
			menuNo = Integer.parseInt(br.readLine());

			// 機能の呼出
			switch (menuNo) {
			case 1:
				// 全件表示機能の呼出
				DBController.findAll();
				break;

			case 2:
				// 社員名検索
				System.out.print(ConstantMsg.GUIDANCE_EMP_NAME);

				// 検索機能の呼出
				DBController.findByEmpId();
				break;

			case 3:
				// 検索する部署IDを入力
				System.out.print(ConstantMsg.GUIDANCE_FIND_BY_DEPT_ID);
				deptId = br.readLine();

				// 検索機能の呼出
				DBController.findByDeptId(deptId);
				break;

			case 4:
				// 登録する値を入力
				System.out.print(ConstantMsg.GUIDANCE_EMP_NAME);
				empName = br.readLine();
				System.out.print(ConstantMsg.GUIDANCE_GENDER);
				gender = br.readLine();
				System.out.print(ConstantMsg.GUIDANCE_BIRTHDAY);
				birthday = br.readLine();
				System.out.print(ConstantMsg.GUIDANCE_DEPT_ID);
				deptId = br.readLine();

				// 登録機能の呼出
				DBController.insertEmp(empName, gender, birthday, deptId);
				break;

			case 5:
				// 更新する社員IDを入力
				System.out.print(ConstantMsg.GUIDANCE_UPDATE_BY_EMP_ID);

				// 更新する値を入力する
				empId = br.readLine();
				Integer.parseInt(empId);

				// 更新機能の呼出
				DBController.updateByEmpId(empId);
				System.out.println(ConstantMsg.NOTICE_UPDATE_BY_EMP_ID_COMPLETE);

				break;

			case 6:
				// 削除する社員IDを入力
				System.out.print(ConstantMsg.GUIDANCE_DELETE_BY_EMP_ID);

				// 削除機能の呼出
				DBController.deleteByEmpId();
				break;

			}
		} while (menuNo != 7);
		System.out.println(ConstantMsg.NOTICE_FINISH);
	}
}
