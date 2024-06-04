import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.Scanner;

public class Base {
    /**
     * @param args
     */
    public static void main(String[] args) {
        Connection conn = null;
        java.sql.Statement stmt = null;
        ResultSet rs = null;
        Scanner cin = new Scanner(System.in);
        int opciones;
        try {
            // Cargar el controlador JDBC de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Establecer conexión
            String url = "jdbc:mysql://localhost:3306/sakila?useSSL=false&serverTimezone=UTC";
            String user = "root";
            String password = "admin";
            conn = DriverManager.getConnection(url, user, password);
            
            // Conexión establecida correctamente, puedes realizar consultas aquí
            int a = 0;
            int b = 0;
            String ciudad;
            String pais;
            // Crear una declaración SQL
            stmt = conn.createStatement();
            
            // Consulta SELECT
            String sql = "SELECT city_id, city FROM city";
            
            // Ejecutar la consulta
            
            
            // Procesar los resultados
            while(true){
                System.out.println("----------- MENU -----------");
                System.out.println("1) Buscar ciudad\n2)crear Ciudad\n3)Modificar ciudad\n4)Eliminar ciudad\n5)Salir");
                opciones = cin.nextInt();
                switch (opciones) {
                    case 1:
                        ciudad = "La Paz";
                        System.out.print("Ingrese el nombre de la ciudad que estas buscando: ");
                        ciudad = cin.next();
                        sql = "SELECT *, city FROM city WHERE city='" + ciudad + "'";
                        rs = ((java.sql.Statement) stmt).executeQuery(sql);
                        while (rs.next()) {
                            // Acceder a los datos por nombre de columna o índice
                            int id = rs.getInt("city_id");
                            String city = rs.getString("city");
                            int country_id = rs.getInt("country_id");
                            
                            // Imprimir los resultados o hacer lo que necesites con ellos
                            System.out.println("ID: " + id + "\t\tCiudad: " + city + "\t\tCountry: " + country_id);
                            //System.out.println(id);
                            a = a + 1;
                        }
                        if(a == 0){
                            System.out.println("No existe la ciudad");
                        }

                    break;
                    case 2:
                        System.out.println("Ingrese el nombre del ciudad");
                        ciudad = "Luna";
                        System.out.println("Ingrese el nombre del pais");
                        pais = "Bolivia";
                        sql = "SELECT *, city FROM city order by city_id desc limit 1";
                        rs = ((java.sql.Statement) stmt).executeQuery(sql);
                        while (rs.next()) {
                            int id = rs.getInt("city_id");
                            b = id;
                        }
                        sql = "INSERT INTO sakila.city (city_id, country)";
                        // insert into sakila.city values(601,'LA PAZ', 14, sysdate())
                        rs = ((java.sql.Statement) stmt).executeQuery(sql);
                        System.out.println("Ya se agrego!!!");
                        
                    break;
                    case 3:
                    System.out.println("Escoja una ciudad: ");
                        sql = "SELECT *, city FROM city";
                        rs = ((java.sql.Statement) stmt).executeQuery(sql);
                        while (rs.next()) {
                            // Acceder a los datos por nombre de columna o índice
                            int id = rs.getInt("city_id");
                            String city = rs.getString("city");
                            int country_id = rs.getInt("country_id");
                            
                            // Imprimir los resultados o hacer lo que necesites con ellos
                            System.out.println("ID: " + id + "\t\tCiudad: " + city + "\t\tCountry: " + country_id);
                            //System.out.println(id);
                            a = a + 1;
                        }

                        System.out.println("Pon el id de la ciudad que quieras modificar");
                        
                    break;

                    default:
                        break;
                }

            }


            
        } catch (ClassNotFoundException | SQLException e) {
            // Manejo de excepciones
            e.printStackTrace();
        } finally {
            try {
                // Cerrar la conexión
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                // Manejo de excepciones
                e.printStackTrace();
            }
        }
    }
}