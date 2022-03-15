package cursoBaseDAtos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {

    //deficiones en base de datos
 protected  static final String MYSQLDB = "jdbc:mysql://localhost:3306/mycusroedteam";
 protected static  final String MYSQLUSER = "carlos";
 protected static final String MYSQLPASSWORD = "caRTA87.";

 //si hay otra base de datos, realizariamos lo mismo quue lo anterior
    protected  static final String ORACLE_DB = "X";
    protected  static  final String ORACLE_USER = "X";
    protected  static final  String ORACLE_PASSWORD = "X";

    public static Connection getConnection (DBType dbType) throws SQLException {
        switch (dbType){
            case MYSQLDB:
                 return DriverManager.getConnection(MYSQLDB,MYSQLUSER,MYSQLPASSWORD);
                // break; evitamos con return cuando coincida el caso
            case ORACLE_DB:
                return DriverManager.getConnection(ORACLE_DB,ORACLE_USER,ORACLE_PASSWORD);
            default:
                return null;
        }

    }
    public static void processException(SQLException e){
        System.out.println("Error " + e.getMessage());
        System.out.println("code "+ e.getErrorCode());
        System.out.println( "SQL state " + e.getSQLState() );

    }
}
