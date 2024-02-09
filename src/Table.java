import java.util.ArrayList;

//Código del usuario de StackOverflow que no funciona
public class Table {

    private int length, width;
    private ArrayList newTable;

    public Table() {
    this.length = this.width = 0;
    }

    /**
     * Testing a few functions
     */
    public static void main(String[] args) {
        // Just testing a few functions.
        Table list1 = new Table();
        list1.createTable(4, 4);
        list1.displayRow(1);
        list1.displayColumn(1);
        System.out.println("displayColumn done!");
        list1.displayEntireTable();
    }

    public void createTable(int tableLength, int tableWidth) {
        length = tableLength;
        width = tableWidth;

        this.newTable = new ArrayList();
        for (int i = 0; i < tableWidth; i++) {
            this.newTable.add(new ArrayList(tableLength));
        }
    }

    public void displayRow(int row) {
        System.out.println(this.newTable.get(row));
    }

    /**
     * This function displays the column of the table. Still work which
     * needs to be done here.
     * @param column 
     */
    public void displayColumn(int column) {
        if (this.newTable.size() >= column) {
            for (int i = 0; i < this.newTable.size(); i++) {
                // This doesn't work.
                System.out.println(this.newTable.get(i).get(column)); 
            }
        }
    }

    public void displayEntireTable() {

        for (int i = 0; i < this.newTable.size(); i++) {
        System.out.println(this.newTable.get(i));
        }
    }
}
