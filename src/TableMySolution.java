import java.util.ArrayList;


public class TableMySolution extends ArrayList<ArrayList<String>> {

    public TableMySolution(int tableLength, int tableWidth) {
        super(); // Inicializa la ArrayList principal
        for (int i = 0; i < tableLength; i++) {
            ArrayList<String> row = new ArrayList<>();
            for (int j = 0; j < tableWidth; j++) {
                row.add("😎"); // Llena cada fila con "test"
            }
            this.add(row); // Añade la fila a la tabla
        }
    }

    public void displayRow(int row) {
        // Asegúrate de que el índice de la fila es válido
        if (row < 0 || row >= this.size()) {
            System.out.println("Row index out of bounds.");
            return;
        }
        System.out.println(this.get(row));
    }

    public void displayColumn(int column) {
        // Comprueba que haya al menos una fila para determinar el tamaño de la columna
        if (this.size() == 0) {
            System.out.println("The table is empty.");
            return;
        }
        // Asegúrate de que el índice de la columna es válido
        if (column < 0 || column >= this.get(0).size()) {
            System.out.println("Column index out of bounds.");
            return;
        }
        for (ArrayList<String> row : this) {
            System.out.println("[" + row.get(column) + "]");
        }
    }

    public void displayEntireTable() {
        for (ArrayList<String> row : this) {
            System.out.println(row);
        }
    }

    // Método principal para pruebas
    public static void main(String[] args) {
        TableMySolution table = new TableMySolution(4, 4);
        table.displayRow(1);

        System.out.println("displayRow done!");
        table.displayColumn(1);
        System.out.println("displayColumn done!");
        table.displayEntireTable();
        System.out.println("displayEntireTable done!");
    }
}

