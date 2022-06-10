package org.mark.app.util;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.swing.table.AbstractTableModel;
import java.lang.reflect.Field;
import java.util.List;

@AllArgsConstructor
@Data
public class CustomTableModel<T> extends AbstractTableModel {
    Class<T> cls;
    String[] columNames;
    List<T> rows;

    @Override
    public String getColumnName(int column) {
        return columNames[column];
    }

    @Override
    public int getRowCount() {
        return rows.size();
    }

    @Override
    public int getColumnCount() {
        return cls.getDeclaredFields().length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        try {
            Field field = cls.getDeclaredFields()[columnIndex];
            field.setAccessible(true);
            return field.get(rows.get(rowIndex));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return "ERROR";
        }
    }
}
