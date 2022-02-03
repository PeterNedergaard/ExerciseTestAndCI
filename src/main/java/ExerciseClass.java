import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ExerciseClass {

    public String getUserNames(Connection con) {
        String result = "";

        try{
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery("SELECT fname FROM startcode_test.usertable");
            while (res.next()) {
                String fname = res.getString("fname");
                result = fname;
            }
            con.close();
        } catch (java.sql.SQLException e){
            e.printStackTrace();
        }

        return result;

    }
}
