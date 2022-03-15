package cursoBaseDAtos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBmainMejorado {
    public static void main(String... arg) throws SQLException {
        Connection connection = null;
        Statement  statement = null;
        ResultSet resultSet = null;

        try {
            connection = DBUtils.getConnection(DBType.MYSQLDB);

            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            resultSet = statement.executeQuery("SElECT * FROM useryfff");//probando con otro nombre de table
        }catch (SQLException e) {
            DBUtils.processException(e);//e.printStackTrace(); para personalizar la exception
        } finally {
            if (statement!=null){
                statement.close();
            }
            if (resultSet !=null){
                resultSet.close();
            }
            if (connection !=null){
                connection.close();// importante cerrar
            }
        }

    }
}
