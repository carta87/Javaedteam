package cursoBaseDAtos;

import java.sql.*;

public class DBmain {
    public static void main(String[] args) throws SQLException {//se requiere para poder manejar una exception
        //crear conection
        Connection connection = null;
        Statement statement = null; //declaracion
        ResultSet resultSet = null; //es un resulatado como un paquete generico sin importar su cantidad

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mycusroedteam","carlos","Carta87.");
            //System.out.println("conect");                              //puerto por defecto/name database...
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);//es una constante... una peticion en este caso para ver estado
                                                                                      // seria permiso de lectura

            //para mostrar
            resultSet = statement.executeQuery("SElECT * FROM user");
            /*
            //insertar
            String  sql = "insert into user values(?,?,?,?)";//tener cuidado por que java lo lee como cadena mas no como setencia
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,"8");
            preparedStatement.setString(2,"erika");
            preparedStatement.setString(3,"erika@hot");
            preparedStatement.setString(4,"españa");


            //requiere ejecutar para  ver cambios el executeUpdate para insertar acualizar o eliminar
            int result = preparedStatement.executeUpdate();

            //para obeservar si fue exitoso la consulta
            if (result==1){
                System.out.println("exitoso");
            }else {
                System.out.println("error");
            }*/

            while (resultSet.next()){
                System.out.println(resultSet.getString("id") +
                        resultSet.getString("name")+
                        resultSet.getString("email")+
                        resultSet.getString("nacionalidad"));
            }

            //actualizar
            String sql2 = "update user set email = ? where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql2);
            preparedStatement.setString(1,"xxx@d");
            preparedStatement.setString(2,"8");

            int result = preparedStatement.executeUpdate();
            if(result==1){
                System.out.println("exito2 actualizar");
            }else {
                System.out.println("falla");
            }

            //eliminar
            String sql3 = "delete from user where id = ? ";
            PreparedStatement preparedStatement1 = connection.prepareStatement(sql3);
            preparedStatement.setString(1,"8");
            int result2 = preparedStatement.executeUpdate();
            if (result2==1){
                System.out.println("eliminado exitoso");
            }else {
                System.out.println("Error");
            }



        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection !=null){
                connection.close();// importante cerrar
            }
        }
    }
}
