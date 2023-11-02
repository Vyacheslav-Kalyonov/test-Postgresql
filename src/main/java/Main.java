import java.util.List;

public class Main {
    public static void main(String[] args) {
        MyConnect myConnect = new MyConnect();

        String select = """
                select "Ревизионный номер", "Тип изделия", "Адрес расположения"
                from audit_department;
                """;

        List<String[]> viewSelect = myConnect.executeSelect(select);

        for (String[] element : viewSelect) {

            for (String string : element) {
                System.out.printf("|" + "%-25s", string);
            }
            System.out.println();
            getLineForTable();
            System.out.println();
        }
    }

    public static void getLineForTable() {
        for (int i = 0; i < 3; i++) {
            System.out.print("|");
            for (int j = 0; j < 25; j++) {
                System.out.print("-");
            }
        }
    }
}