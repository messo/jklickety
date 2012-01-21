package hu.krivan.jklickety;

import java.io.Serializable;

/**
 * Egy táblát reprezentál (mezők + pontszám), betöltéshez és mentéshez
 *
 * @author Balint
 */
public class TableData implements Serializable {

    private int table[][];
    private double points;

    /**
     * Lemásolja a teljes táblázatot, nem csak shallow-copy
     */
    public TableData(int[][] table, double points) {
        this.table = new int[table.length][];
        for (int i = 0; i < table.length; i++) {
            this.table[i] = new int[table[i].length];
            System.arraycopy(table[i], 0, this.table[i], 0, table[i].length);
        }
        this.points = points;
    }

    public int[][] getTable() {
        return table;
    }

    public double getPoints() {
        return points;
    }
}
