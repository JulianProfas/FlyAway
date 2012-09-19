/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package View;

import java.util.*;

/**
 *
 * @author Jesse
 */
public class CheckboxList<T> extends javax.swing.JTable {
    private ArrayList<CheckableObject<T>> tableObjects = new ArrayList<CheckableObject<T>>();

    public CheckboxList(){
        super();

        setModel(new CheckboxListTableModel());
        setTableHeader(null);
        setEnabled(true);
        setColumnSelectionAllowed(false);
        setRowSelectionAllowed(false);
        
        SetData((List<T>) Controller.Controller.Instance().getStaff());

        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if(getSelectedRow() >= 0){
                    tableObjects.get(getSelectedRow()).SetChecked(!tableObjects.get(getSelectedRow()).GetChecked());
                    ((javax.swing.JComponent)evt.getSource()).repaint();
                }
            }
        });

        getColumnModel().getColumn(0).setWidth(50);
    }

    public void SetData(java.util.List<T> data){
        for(T t : data)
            tableObjects.add(new CheckableObject<T>(t));
    }

    public void SetSelected(java.util.List<T> selected){
        for(T sel : selected){
            for(CheckableObject<T> o : tableObjects){
                if(sel.equals(o.GetObject())){
                    o.SetChecked(true);
                }
            }
        }

        this.repaint();
    }

    public List<T> GetCheckedObjects(){
        ArrayList<T> checkedObjects = new ArrayList<T>();
        for(CheckableObject<T> o : tableObjects){
            if(o.GetChecked())
                checkedObjects.add(o.GetObject());
        }

        return checkedObjects;
    }

    class CheckableObject<T2>{
        private T2 object;
        private boolean checked;

        public CheckableObject(T2 object) { this.object = object; checked = false; }
        public CheckableObject(T2 object, boolean checked) { this.object = object; this.checked = checked; }

        public T2 GetObject() { return object; }
        public boolean GetChecked() { return checked; }
        public void SetChecked(boolean checked) { this.checked = checked; }
    }

    class CheckboxListTableModel extends javax.swing.table.AbstractTableModel{
        public CheckboxListTableModel() {
            super();
        }

        public int getRowCount() {
            return tableObjects.size();
        }

        public int getColumnCount() {
            return 2;
        }

        public Object getValueAt(int rowIndex, int columnIndex) {
            CheckableObject<T> o = tableObjects.get(rowIndex);

            switch(columnIndex){
                case 0: return o.GetChecked();
                case 1: return o.GetObject();
                default: return null;
            }
        }
    }
}


