package view.panels;

import register_entry.RegisterEntry;

import javax.swing.*;

public class ListPanel extends JPanel{
    private DefaultListModel<RegisterEntry> entryListModel;

    public ListPanel()
    {
        JLabel label = new JLabel("Registrations");
        entryListModel = new DefaultListModel<>();
        JList<RegisterEntry> entryJList = new JList<>(entryListModel);

        this.add(label);
        this.add(entryJList);
    }

    public void addEntry(RegisterEntry entry)
    {
        this.entryListModel.addElement(entry);
    }

}
