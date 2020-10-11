/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package burp;

import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ExecutorService;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author moloch
 */
public class HTTPHistory extends AbstractTableModel {
    
    private IBurpExtenderCallbacks callbacks;
    private final List<TableModelListener> tableListenerCallbacks = new ArrayList();
    private final ExecutorService executor;
    private final List<OnEditCallback> onEditCallbacks = new ArrayList();
    
    public static final String ID = "ID";
    public static final String Method = "Method";
    public static final String Protocol = "Protocol";
    public static final String Host = "Host";
    public static final String Path = "Path";
    public static final String Port = "Port";
    public static final String StatusCode = "Status Code";
    public static final String Comment = "Comment";
    public static final String Highlight = "Highlight";
    public static final List<String> columns = new ArrayList<String>(Arrays.asList(
        ID, Method, Protocol, Host, Path, Port, StatusCode, Comment, Highlight
    ));
    public static final List<String> editableColumns = new ArrayList<String>(Arrays.asList(
        Comment, Highlight
    ));
    
    public static final String Red = "Red";
    public static final String Blue = "Blue";
    public static final String Green = "Green";
    public static final List<String> highlights = new ArrayList<String>(Arrays.asList(
        Red, Blue, Green
    ));
    
    
    
    private final ConcurrentSkipListMap<String, MultiplayerRequestResponse> history;
    
    public HTTPHistory(ExecutorService executor, IBurpExtenderCallbacks callbacks) {
        history = new ConcurrentSkipListMap();
        this.executor = executor;
        this.callbacks = callbacks;
    }
    
    public void add(MultiplayerRequestResponse reqResp) {
        history.put(reqResp.getId(), reqResp);
        // TODO: Don't refresh the entire table
        TableModelEvent event = new TableModelEvent(this);
        tableListenerCallbacks.forEach(listener -> {
            executor.submit(() -> listener.tableChanged(event));
        });
    }
    
    public void registerOnEditCallback(OnEditCallback callback) {
        onEditCallbacks.add(callback);
    }
    
    private void triggerOnEdit(String id, String columnName, Object value) {
        onEditCallbacks.forEach(callback -> {
            executor.submit(() -> callback.onEdit(id, columnName, value));
        });
    }
    
    @Override
    public int getRowCount() {
        return history.size();
    }

    @Override
    public int getColumnCount() {
        return columns.size();
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columns.get(columnIndex);
    }
    
    @Override
    public void addTableModelListener(TableModelListener callback) {
        tableListenerCallbacks.add(callback);
    }
     
    @Override
    public void removeTableModelListener(TableModelListener callback) {
        tableListenerCallbacks.remove(callback);
    }
    
    public MultiplayerRequestResponse getById(String reqRespId) {
        return history.get(reqRespId);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {   
        Iterator iter = history.keySet().iterator();
        for (int index = 0; index < rowIndex; ++index) {
            iter.next();
        }
        MultiplayerRequestResponse reqResp = history.get(iter.next());

        switch(columns.get(columnIndex)) {
            case ID:
                return reqResp.getId();
            case Method:
                return reqResp.getMethod();
            case Protocol:
                return reqResp.getProtocol();
            case Host:
                return reqResp.getHost();
            case Path:
                return reqResp.getPath();
            case Port:
                return reqResp.getPort();
            case StatusCode:
                return reqResp.getStatus();
            case Comment:
                return reqResp.getComment();
            case Highlight:
                String highlight = reqResp.getHighlight();
                if (highlight.isBlank() || highlight.isEmpty()) {
                    return "None";
                }
                return highlight;
        }
        return null;
    }
    
    public Color getColorForId(String id) {
        MultiplayerRequestResponse reqResp = history.get(id);
        switch(reqResp.getHighlight()) {
            case Red:
                return Color.RED;
            case Blue:
                return Color.BLUE;
            case Green:
                return Color.GREEN;
        }
        return javax.swing.UIManager.getColor("Table.dropCellForeground");
    }
    
    @Override
    public void setValueAt(Object value, int row, int column) {
        String id = (String) getValueAt(row, 0);
        callbacks.printOutput(String.format("(%d, %d) %s -> %s", row, column, id, value));
        String columnName = getColumnName(column);
        if (editableColumns.contains(columnName)) {
            triggerOnEdit(id, columnName, value);
        }
    }
    
    @Override
    public Class getColumnClass(int columnIndex) {
        return getValueAt(0, columnIndex).getClass();
    }
    
    @Override
    public boolean isCellEditable(int row, int col) {
        return editableColumns.contains(getColumnName(col));
    }

}
