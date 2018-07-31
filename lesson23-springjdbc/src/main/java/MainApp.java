import java.sql.*;


public class MainApp {
    public static void main(String[] args) throws SQLException {
        Connection conn = DriverManager.
                getConnection("jdbc:h2:./recipes", "sa", "");
        Statement st = conn.createStatement();
//boolean rs =st.execute("create table tests ( id int(10) NOT NULL AUTO_INCREMENT PRIMARY KEY, name varchar(60) NOT NULL)");
  //      System.out.println(rs);
        ResultSet rs = st.executeQuery("SELECT * FROM RECIPES.INGREDIENTS ");

        while (rs.next()){
            System.out.println(rs.getString("name"));
        }

        rs.close();
        st.close();
        conn.close();
    }
}
