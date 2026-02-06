package jp.co.sss.crud.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.util.ConstantSQL;

/**
 * DBと情報をやり取りするクラス
 * 
 * @author 別所大空
 */
public class EmployeeDAO {

	/**インスタンス化を禁止*/
	private EmployeeDAO() {
	}

	/**
	 * <DB操作>全ての社員情報を検索し結果を返す
	 * 
	 * @author 別所大空
	 * @return List<Employee>(検索結果がある場合) OR null(検索結果がない場合)
	 * @throws ClassNotFoundException ドライバクラスが不在の場合に送出
	 * @throws SQLException DB処理でエラーが発生した場合に送出
	 */
	public static List<Employee> findAllDAO() throws ClassNotFoundException, SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			// DBに接続
			connection = DBManager.getConnection();
			// ステートメントを作成
			preparedStatement = connection.prepareStatement(ConstantSQL.SQL_ALL_SELECT);

			// SQL文を実行
			resultSet = preparedStatement.executeQuery();

			//結果が無しの場合
			if (!resultSet.isBeforeFirst()) {
				return null;
			}

			//検索結果をDTOListに入れる
			List<Employee> employees = new ArrayList<Employee>();
			while (resultSet.next()) {
				Employee employee = new Employee();
				employee.setEmpId(resultSet.getInt("emp_id"));
				employee.setEmpName(resultSet.getString("emp_name"));
				employee.setGender(resultSet.getInt("gender"));
				employee.setBirthday(resultSet.getString("birthday"));
				employee.getDepartment().setDeptName(resultSet.getString("dept_name"));
				employees.add(employee);
			}
			return employees;

		} finally {
			// ResultSetをクローズ
			DBManager.close(resultSet);
			// Statementをクローズ
			DBManager.close(preparedStatement);
			// DBとの接続を切断
			DBManager.close(connection);
		}
	}

	/**
	 * <DB操作>社員名に該当する社員情報を検索
	 * 
	 * @author 別所大空
	 * @param empName 社員名
	 * @return List<Employee>(検索結果がある場合) OR null(検索結果がない場合)
	 * @throws ClassNotFoundException ドライバクラスが不在の場合に送出
	 * @throws SQLException DB処理でエラーが発生した場合に送出
	 */
	public static List<Employee> findByEmpIdDAO(int empName) throws ClassNotFoundException, SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			// DBに接続
			connection = DBManager.getConnection();
			// SQL文を準備
			StringBuffer sql = new StringBuffer(ConstantSQL.SQL_SELECT_BASIC);
			sql.append(ConstantSQL.SQL_SELECT_BY_EMP_NAME);
			// ステートメントの作成
			preparedStatement = connection.prepareStatement(sql.toString());
			// 検索条件となる値をバインド
			preparedStatement.setString(1, "%" + empName + "%");

			// SQL文を実行
			resultSet = preparedStatement.executeQuery();

			//結果が無しの場合
			if (!resultSet.isBeforeFirst()) {
				return null;
			}

			//検索結果をDTOListに入れる
			List<Employee> employees = new ArrayList<Employee>();
			while (resultSet.next()) {
				Employee employee = new Employee();
				employee.setEmpId(resultSet.getInt("emp_id"));
				employee.setEmpName(resultSet.getString("emp_name"));
				employee.setGender(resultSet.getInt("gender"));
				employee.setBirthday(resultSet.getString("birthday"));
				employee.getDepartment().setDeptName(resultSet.getString("dept_name"));
				employees.add(employee);
			}
			return employees;

		} finally {
			// クローズ処理
			DBManager.close(resultSet);
			// Statementをクローズ
			DBManager.close(preparedStatement);
			// DBとの接続を切断
			DBManager.close(connection);
		}
	}

	/**
	 * <DB操作>部署IDに該当する社員情報を検索
	 * 
	 * @author 別所大空
	 * @param deptId 部署ID
	 * @return List<Employee>(検索結果がある場合) OR null(検索結果がない場合)
	 * @throws ClassNotFoundException ドライバクラスが不在の場合に送出
	 * @throws SQLException DB処理でエラーが発生した場合に送出
	 */
	public static List<Employee> findByDeptIdDAO(int deptId) throws ClassNotFoundException, SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			// DBに接続
			connection = DBManager.getConnection();
			// SQL文を準備
			StringBuffer sql = new StringBuffer(ConstantSQL.SQL_SELECT_BASIC);
			sql.append(ConstantSQL.SQL_SELECT_BY_DEPT_ID);
			// ステートメントの作成
			preparedStatement = connection.prepareStatement(sql.toString());
			// 検索条件となる値をバインド
			preparedStatement.setInt(1, deptId);

			// SQL文を実行
			resultSet = preparedStatement.executeQuery();

			//結果が無しの場合
			if (!resultSet.isBeforeFirst()) {
				return null;
			}

			//検索結果をDTOListに入れる
			List<Employee> employees = new ArrayList<Employee>();
			while (resultSet.next()) {
				Employee employee = new Employee();
				employee.setEmpId(resultSet.getInt("emp_id"));
				employee.setEmpName(resultSet.getString("emp_name"));
				employee.setGender(resultSet.getInt("gender"));
				employee.setBirthday(resultSet.getString("birthday"));
				employee.getDepartment().setDeptName(resultSet.getString("dept_name"));
				employees.add(employee);
			}
			return employees;

		} finally {
			// クローズ処理
			DBManager.close(resultSet);
			// Statementをクローズ
			DBManager.close(preparedStatement);
			// DBとの接続を切断
			DBManager.close(connection);
		}
	}

	/**
	 * <DB操作>社員情報を1件登録
	 * 
	 * @author 別所大空
	 * @param employee 社員情報
	 * @return 0(登録が出来なかった場合) OR 登録件数(登録が出来た場合)
	 * @throws ClassNotFoundException ドライバクラスが不在の場合に送出
	 * @throws SQLException DB処理でエラーが発生した場合に送出
	 * @throws ParseException 形式処理でエラーが発生した場合に送出
	 */
	public static int insertEmpDAO(Employee employee) throws ClassNotFoundException, SQLException, ParseException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			// DBに接続
			connection = DBManager.getConnection();
			// ステートメントを作成
			preparedStatement = connection.prepareStatement(ConstantSQL.SQL_INSERT);
			// 入力値をバインド
			preparedStatement.setString(1, employee.getEmpName());
			preparedStatement.setInt(2, employee.getGender());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			preparedStatement.setObject(3, sdf.parse(employee.getBirthday()), Types.DATE);
			preparedStatement.setInt(4, employee.getDepartment().getDeptId());

			// SQL文を実行(失敗時は戻り値0)
			int result = preparedStatement.executeUpdate();

			return result;

		} finally {
			// Statementをクローズ
			DBManager.close(preparedStatement);
			// DBとの接続を切断
			DBManager.close(connection);
		}
	}

	/**
	 * <DB操作>社員情報を1件更新
	 * 
	 * @param employee 社員情報
	 * @return 0(登録が出来なかった場合) OR 登録件数(登録が出来た場合)
	 * @throws ClassNotFoundException ドライバクラスが不在の場合に送出
	 * @throws SQLException DB処理でエラーが発生した場合に送出
	 * @throws ParseException 形式処理でエラーが発生した場合に送出
	 */
	public static int updateByEmpIdDAO(Employee employee) throws ClassNotFoundException, SQLException, ParseException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			// データベースに接続
			connection = DBManager.getConnection();
			// ステートメントの作成
			preparedStatement = connection.prepareStatement(ConstantSQL.SQL_UPDATE);
			// 入力値をバインド 修正-別所
			preparedStatement.setString(1, employee.getEmpName());
			preparedStatement.setInt(2, employee.getGender());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			preparedStatement.setObject(3, sdf.parse(employee.getBirthday()), Types.DATE);
			preparedStatement.setInt(4, employee.getDepartment().getDeptId());
			preparedStatement.setInt(5, employee.getEmpId());

			// SQL文の実行(失敗時は戻り値0)
			int result = preparedStatement.executeUpdate();

			return result;

		} finally {
			// クローズ処理
			DBManager.close(preparedStatement);
			// DBとの接続を切断
			DBManager.close(connection);
		}
	}
}
