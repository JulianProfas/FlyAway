/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Flight;
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
public class FlightTableModel<T> extends javax.swing.table.AbstractTableModel{

	private ArrayList<T> rows;

    public FlightTableModel(ArrayList<T> rows)
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
            BeanInfo testBeanInfo = Introspector.getBeanInfo(Flight.class, Object.class);
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
                value = "number";
                break;
            case 1:
                value = "date";
                break;
            case 2:
                value = "from";
                break;
            case 3:
                value = "destination";
                break;
            case 4:
                value = "pilot";
                break;
            case 5:
                value = "copilot";
                break;
			case 6:
				value = "stops";
				break;
			case 7:
				value = "other personal";
				break;
			case 8:
				value = "plane";
				break;
			case 9:
				value = "return flight";
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
            Flight f = null;

            f = (Flight) o; 
			
            value = "";
            if (f != null)
            {
                switch (columnIndex)
                {
                    case 0:
                        value = "" + f.getNumber();
                        break;
                    case 1:
                        value = f.getDate().toString();
                        break;
                    case 2:
                        value = f.getFrom().toString();
                        break;
                    case 3:
                        value = f.getDestination().toString();
                        break;
					case 4:
						value = f.getPilot().toString();
						break;
					case 5:
						value = f.getCopilot().toString();
						break;
					case 6:
						value = f.getStops().toString();
						break;
					case 7:
						value = f.getOtherPersonal().toString();
						break;
					case 8:
						value = f.getPlane().toString();
						break;
					case 9:
						if(f.getReturnFlight() !=null){
							value = "" + f.getReturnFlight().getNumber();
						}else{
							value = "";
						}	
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
