import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class ExerciseClass {

    public String getUserNames(Connection con) {
        String result = "";
        String sql = "SELECT fname FROM startcode_test.usertable";

        try(PreparedStatement ps = con.prepareStatement(sql)){
            ResultSet res = ps.executeQuery();
            while (res.next()) {
                String fname = res.getString("fname");
                result = fname;
            }
        } catch (java.sql.SQLException e){
            e.printStackTrace();
        }

        return result;

    }

    public String getInfoByName(String name, Connection con) {
        String result = "";
        String sql = "SELECT fname FROM startcode_test.usertable WHERE fname=?";

        try(PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1,name);
            ResultSet res = ps.executeQuery();
            while (res.next()) {
                String fname = res.getString("fname");
                result = fname;
            }
        } catch (java.sql.SQLException e){
            e.printStackTrace();
        }

        return result;
    }

    public String ChangeInfoByName(String currentName, String newName, Connection con) {

        String result = "";
        String sql = "UPDATE startcode_test.usertable SET fname=? WHERE fname=?";

        try(PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1,newName);
            ps.setString(2,currentName);
            ps.executeUpdate();

        } catch (java.sql.SQLException e){
            e.printStackTrace();
        }

        result = getUserNames(con);

        return result;
    }
}
