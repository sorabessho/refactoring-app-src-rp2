package jp.co.sss.crud.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
	 * @return 検索結果がある場合-List<Employee> 検索結果がない場合-null
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

			//nullチェック
			if (!resultSet.isBeforeFirst()) {
				return null;
			}

			//検索結果をDTOListに入れる 修正-別所
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
}
