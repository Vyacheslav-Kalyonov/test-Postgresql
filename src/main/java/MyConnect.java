import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MyConnect {


    public List<String[]> executeSelect(String select) {
        try (Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/training_hw_5",
                "postgres", "380Slava123");
             Statement statement = conn.createStatement()) {
            ResultSet result = statement.executeQuery(select);

            ResultSetMetaData setMetaData = result.getMetaData();
            int amount = result.getMetaData().getColumnCount();
            String[] name = new String[amount];

            List<String[]> ans = new ArrayList<>();

            for (int i = 1; i < amount  + 1; i++) {
                name[i-1] = setMetaData.getColumnLabel(i);
            }

            ans.add(name);

            while (result.next()) {
                String[] element = new String[amount];

                for (int i = 1; i < amount + 1; i++) {
                    element[i - 1] = result.getString(i);
                }

                ans.add(element);
            }

            return ans;
        } catch (SQLException e) {
            System.out.println("Cannot connect to DB : " + e);
            return null;
        }
    }
}
