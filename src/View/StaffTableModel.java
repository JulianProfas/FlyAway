/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.AirMarshall;
import Model.Staff;
import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tom
 */
public class StaffTableModel<T> extends javax.swing.table.AbstractTableModel{

	private ArrayList<T> rows;

    public StaffTableModel(ArrayList<T> rows)
    {
        this.rows = rows;
    }

    public int getRowCount()
    {
        return rows.size();
    }

    public T getRow(int row)
    {
        return rows.get(row);
    }

    public void removeRow(T row)
    {
        rows.remove(row);
        this.fireTableDataChanged();
    }

    public void addRow(T row)
    {
        rows.add(row);
        this.fireTableDataChanged();
    }

    public int getColumnCount()
    {
        int columnCount = 0;
        try
        {
            BeanInfo testBeanInfo = Introspector.getBeanInfo(AirMarshall.class, Object.class);
            columnCount = testBeanInfo.getPropertyDescriptors().length;
        }
        catch (IntrospectionException ex)
        {
            Logger.getLogger(GenericTableModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return columnCount;
    }

    @Override
    public String getColumnName(int column)
    {
        String value = null;
        switch (column)
        {
            case 0:
                value = "Number";
                break;
            case 1:
                value = "Name";
                break;
            case 2:
                value = "Type";
                break;
            case 3:
                value = "Primary airport";
                break;
            case 4:
                value = "Nationality";
                break;
            case 5:
                value = "Weapon number";
                break;
            default:
                value = "";
                break;
        }
        return value;
    }

    public Object getValueAt(int rowIndex, int columnIndex)
    {
        String value = null;
        T o = rows.get(rowIndex);
        if (o != null)
        {
            AirMarshall a = null;
            Staff s = null;

            if (o instanceof AirMarshall)
            {
                a = (AirMarshall) o;
            }
            else
            {
                s = (Staff) o;
            }
            value = "";
            if (s != null)
            {
                switch (columnIndex)
                {
                    case 0:
                        value = "" + s.getNumber();
                        break;
                    case 1:
                        value = s.getName();
                        break;
                    case 2:
                        value = s.getType().toString();
                        break;
                    case 3:
                        value = s.getPrimaryAirport().toString();
                        break;
                    default:
                        value = "";
                        break;
                }
            }
            else if (a != null)
            {
                switch (columnIndex)
                {
                    case 0:
                        value = "" + a.getNumber();
                        break;
                    case 1:
                        value = a.getName();
                        break;
                    case 2:
                        value = a.getType().toString();
                        break;
                    case 3:
                        value = a.getPrimaryAirport().toString();
                        break;
                    case 4:
                        value = a.getNationality().toString();
                        break;
                    case 5:
                        value = "" + a.getWeaponNumber();
                        break;
                    default:
                        value = "";
                        break;
                }
            }
        }
        return value;
    }
}
