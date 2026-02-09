package jp.co.sss.crud.main;

import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.io.ConsoleWriter;
import jp.co.sss.crud.io.MenuNoReader;
import jp.co.sss.crud.service.EmployeeAllFindService;
import jp.co.sss.crud.service.EmployeeDeleteService;
import jp.co.sss.crud.service.EmployeeFindByDeptIdService;
import jp.co.sss.crud.service.EmployeeFindByEmpNameService;
import jp.co.sss.crud.service.EmployeeRegisterService;
import jp.co.sss.crud.service.EmployeeUpdateService;
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
	 */
	public static void main(String[] args) {

		int menuNo = ConstantValue.MENU_NUMBER_0;

		do {
			try {
				// メニューの表示
				ConsoleWriter.showMenu();

				// メニュー番号の入力
				menuNo = (int) MenuNoReader.menuNoReader();

				// 機能の呼出
				switch (menuNo) {

				//全件検索
				case ConstantValue.MENU_NUMBER_1:
					EmployeeAllFindService.findAll();
					break;

				// 社員名検索
				case ConstantValue.MENU_NUMBER_2:
					EmployeeFindByEmpNameService.findByEmpName();
					break;

				//部署ID検索
				case ConstantValue.MENU_NUMBER_3:
					EmployeeFindByDeptIdService.findByDeptId();
					break;

				//社員登録
				case ConstantValue.MENU_NUMBER_4:
					EmployeeRegisterService.registEmp();
					break;

				//社員情報更新
				case ConstantValue.MENU_NUMBER_5:
					EmployeeUpdateService.updateByEmpId();
					break;

				//社員削除
				case ConstantValue.MENU_NUMBER_6:
					EmployeeDeleteService.deleteByEmpId();
					break;
				}
			} catch (IllegalInputException e) {
				System.out.println(e.getMessage());
				System.out.println();
				continue;
			} catch (SystemErrorException e) {
				System.out.println(e.getMessage());
				System.out.println();
				break;
			}
		} while (menuNo != ConstantValue.MENU_NUMBER_7);
		//システム終了メッセージ
		System.out.println(ConstantMsg.NOTICE_FINISH);
	}
}
