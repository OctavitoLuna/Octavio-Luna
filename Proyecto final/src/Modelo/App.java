  

package Modelo;
//importar otros script
import Vista.Bienvenida;
import java.sql.Connection;
import java.sql.SQLException;
import Modelo.DatabaseConnection; // Importa la clase DatabaseConnection


public class App {
	public static void main(String[] args){
        try {
            Connection connection = DatabaseConnection.getConnection();
            if (connection != null) {
                System.out.println("Conexión exitosa a la base de datos!");
                // Aquí puedes continuar con el resto de la inicialización del sistema.
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al conectar con la base de datos.");
        }
		System.out.println("Hello, Universidad!");
		Bienvenida Bienvenida = new Bienvenida();
		Bienvenida.setVisible(true);
	}
}
