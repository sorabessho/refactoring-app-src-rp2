package jp.co.sss.crud.util;

/**
 * 文章（文字列）を定数化するクラス
 * 
 * @author 別所大空-Task.2
 */
public final class ConstantMsg {

	/**インスタンス化禁止*/
	private ConstantMsg() {
	}

	/**メニュータイトル*/
	public static final String MENU_TITLE = "=== 社員管理システム ===";
	/**メニュー（全件表示）*/
	public static final String MENU_FIND_ALL = ".全件表示";
	/**メニュー（社員名検索）*/
	public static final String MENU_FIND_BY_EMP_NAME = ".社員名検索";
	/**メニュー（部署ID検索）*/
	public static final String MENU_FIND_BY_DEPT_ID = ".部署ID検索";
	/**メニュー（新規登録）*/
	public static final String MENU_INSERT_EMP = ".新規登録";
	/**メニュー（更新）*/
	public static final String MENU_UPDATE_EMP_BY_EMP_ID = ".更新";
	/**メニュー（削除）*/
	public static final String MENU_DELETE_BY_EMP_ID = ".削除";
	/**メニュー（終了）*/
	public static final String MENU_FINISH = ".終了";
	/**メニュー案内*/
	public static final String MENU_INPUT_NUMBER = "メニュー番号を入力してください：";

	/**社員名入力案内*/
	public static final String GUIDANCE_EMP_NAME = "社員名:";
	/**性別入力案内*/
	public static final String GUIDANCE_GENDER = "性別(0:その他, 1:男性, 2:女性, 9:回答なし):";
	/**生年月日入力案内*/
	public static final String GUIDANCE_BIRTHDAY = "生年月日(西暦年/月/日):";
	/**部署ID入力案内*/
	public static final String GUIDANCE_DEPT_ID = "部署ID(1:営業部、2:経理部、3:総務部):";
	/**部署ID入力案内（部署ID検索）*/
	public static final String GUIDANCE_FIND_BY_DEPT_ID = "部署ID(1:営業部、2:経理部、3:総務部)を入力してください:";
	/**社員入力案内（更新）*/
	public static final String GUIDANCE_UPDATE_BY_EMP_ID = "更新する社員の社員IDを入力してください：";
	/**社員ID入力案内（削除）*/
	public static final String GUIDANCE_DELETE_BY_EMP_ID = "削除する社員の社員IDを入力してください：";

	/**更新完了通知*/
	public static final String NOTICE_UPDATE_BY_EMP_ID_COMPLETE = "社員情報を更新しました";
	/**システム終了通知*/
	public static final String NOTICE_FINISH = "システムを終了します。";
}
