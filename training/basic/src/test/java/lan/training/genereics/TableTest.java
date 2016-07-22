package lan.training.genereics;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by NL on 7/22/2016.
 */
public class TableTest {
    @Test
    public void nonGeneralizedTest() {
        Table table = new Table();
        table.getColumns().add(new Column("column1"));
        table.getColumns().add("aaaa");
        assertEquals("[column1, aaaa]", table.getColumns().toString());
    }

    @Test
    public void generalizedTest() {
        Table<Object> table = new Table<Object>();
        table.getColumns().add(new Column("column1"));
        table.getColumns().add(new Column("column2"));
        assertEquals("[column1, column2]", table.getColumns().toString());
    }

}