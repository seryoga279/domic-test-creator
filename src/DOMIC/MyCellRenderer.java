package DOMIC;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.UIDefaults;
import javax.swing.UIManager;

class MyCellRenderer extends JComponent
        implements ListCellRenderer {

    static Color listForeground, listBackground,
            listSelectionForeground,
            listSelectionBackground;

    static {
        UIDefaults uid = UIManager.getLookAndFeel().getDefaults();
        listForeground = uid.getColor("List.foreground");
        listBackground = uid.getColor("List.background");
        listSelectionForeground = uid.getColor("List.selectionForeground");
        listSelectionBackground = uid.getColor("List.selectionBackground");
    }

    DefaultListCellRenderer defaultComp;
    JCheckBox checkbox;

    public MyCellRenderer() {
        setLayout(new BorderLayout());
        defaultComp = new DefaultListCellRenderer();
        checkbox = new JCheckBox();
        add(checkbox, BorderLayout.WEST);
        add(defaultComp, BorderLayout.CENTER);
    }

    public Component getListCellRendererComponent(JList list,
            Object value,
            int index,
            boolean isSelected,
            boolean cellHasFocus) {
        defaultComp.getListCellRendererComponent(list, value, index,
                isSelected, cellHasFocus);

        checkbox.setSelected(isSelected);
        Component[] comps = getComponents();
        for (int i = 0; i < comps.length; i++) {
            comps[i].setForeground(listForeground);
            comps[i].setBackground(listBackground);
        }

        return this;
    }
}
