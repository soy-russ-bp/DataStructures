import java.util.ArrayList;


public class CineExample extends ArrayList<ArrayList<String>> {

    public int Length, Width;
    ArrayList<String> row = new ArrayList<>();

    public CineExample (int tableLength, int tableWidth) {
        super(); // Inicializa la ArrayList principal
        Length = tableLength;
        Width = tableWidth;
        for (int i = 0; i < Length; i++) {
            ArrayList<String> row = new ArrayList<>();
            for (int j = 0; j < Width; j++) {
                row.add("💺"); // Llena cada fila con "test"
            }
            this.add(row); // Añade la fila a la tabla
        }
    }

    public void addRow(){
        ArrayList<String> row = new ArrayList<>();
        for (int j = 0; j < this.Width; j++) {
            row.add("💺"); // Llena cada fila con "test"
        }
        this.add(row); // Añade la fila a la tabla
        this.Length++; // Incrementa el contador de la altura de la tabla
    }

    public void addColumn(){
        for (ArrayList<String> row : this) {
            row.add("💺"); // Llena cada fila con "test"
        }
        this.Width++; // Incrementa el contador de la anchura de la tabla
    }

    public void busyChair(int row, int column) {
        // Asegúrate de que el índice de la fila es válido
        if (row < 0 || row >= this.size()) {
            System.out.println("Row index out of bounds.");
            return;
        }
        // Asegúrate de que el índice de la columna es válido
        if (column < 0 || column >= this.get(0).size()) {
            System.out.println("Column index out of bounds.");
            return;
        }
        this.get(row-1).set(column-1, "🔴");
    }

    public void displayRow(int row) {
        // Asegúrate de que el índice de la fila es válido
        if (row < 0 || row >= this.size()+1) {
            System.out.println("Row index out of bounds.");
            return;
        }
        System.out.println(this.get(row-1));
    }

    public void displayColumn(int column) {
        // Comprueba que haya al menos una fila para determinar el tamaño de la columna
        if (this.size() == 0) {
            System.out.println("The table is empty.");
            return;
        }
        // Asegúrate de que el índice de la columna es válido
        if (column < 0 || column >= this.get(0).size()+1) {
            System.out.println("Column index out of bounds.");
            return;
        }
        for (ArrayList<String> row : this) {
            System.out.println("[" + row.get(column-1) + "]");
        }
    }

    public void displayEntireChairs() {
        for (ArrayList<String> row : this) {
            System.out.println(row);
        }
    }

    // Método principal para pruebas
    public static void main(String[] args) {
        CineExample cine = new CineExample(4, 4);
        cine.busyChair(1,2);
        cine.displayRow(1);

        System.out.println("displayRow done!");
        cine.displayColumn(1);
        System.out.println("displayColumn done!");
        cine.displayEntireChairs();
        System.out.println("displayEntireTable done!");

        cine.addRow();
        cine.addRow();
        cine.displayEntireChairs();
        System.out.println("displayEntireTable done!");

        cine.displayRow(6);
        System.out.println("displayRow done!");

        cine.addColumn();
        cine.displayEntireChairs();

    }
}