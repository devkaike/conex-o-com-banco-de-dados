package conectar;
import java.sql.Connection;
public class Principal {
	public static void main(String[] args) {
		Conect cx = new Conect();
		Connection conn = null;
		
		conn = cx.getConnection();
		if(conn == null) {
			System.out.print("A conexão não ocorreu");
		}else {
			System.out.print("O banco de dados esta conectado");
		}
	}
}
