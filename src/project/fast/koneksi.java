package project.fast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
 
public class koneksi {

    static Object getKoneksi() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    Connection con;
    Statement stm;
    
    ResultSet rs;
    
    public koneksi() {
        try {
            Class.forName("com.mysql.jdbc.Driver");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,""+e.getMessage(),"JDBC Driver Error",JOptionPane.WARNING_MESSAGE);
        }
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/rental_mobil", "root", "");
            stm = con.createStatement();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,""+e.getMessage(),"Connection Error",JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public ResultSet getData(String SQL) throws SQLException {
        try {
            rs = stm.executeQuery(SQL);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,""+e.getMessage(),"AA",JOptionPane.WARNING_MESSAGE);
        }
        return rs;
    }
    
    public void Query (String SQL) {
        try {
            stm.executeUpdate(SQL);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,""+e.getMessage(),"Communication Error",JOptionPane.WARNING_MESSAGE);
        }
    }
}
