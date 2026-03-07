//REG NUMBER: CT100/G/22432/24
//NAME: ISAAC JULIUS WAINAINA
// JAVA SWING ASSIGNMENT: LIBRARY SEARCH SYSTEM

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class LibrarySearch extends JFrame {
    private JTextField tfSearch;
    private JButton btnSearch;
    private JTable tableResults;
    private DefaultTableModel tableModel;
    private JList<String> listHistory;
    private DefaultListModel<String> historyModel;

    // Simulated book database (Title, Author, ISBN, Availability)
    private Object[][] books = {
            { "Java Programming", "John Smith", "978-001", "Available" },
            { "Data Structures", "Alice Brown", "978-002", "Not Available" },
            { "Database Systems", "Robert White", "978-003", "Available" },
            { "Algorithms", "Mary Green", "978-004", "Available" },
            { "Operating Systems", "James Black", "978-005", "Not Available" },
            { "Networking Basics", "Linda Blue", "978-006", "Available" },
            { "Software Engineering", "Peter Grey", "978-007", "Available" },
            { "Machine Learning", "Susan Yellow", "978-008", "Not Available" },
            { "Artificial Intelligence", "David Purple", "978-009", "Available" },
            { "Web Development", "Emma Orange", "978-010", "Available" }
    };

    public LibrarySearch() {
        setTitle("Library Search");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // Top panel for search
        JPanel panelTop = new JPanel(new FlowLayout());
        tfSearch = new JTextField(30);
        btnSearch = new JButton("Search");
        panelTop.add(new JLabel("Search:"));
        panelTop.add(tfSearch);
        panelTop.add(btnSearch);
        add(panelTop, BorderLayout.NORTH);

        // Table for results
        String[] columns = { "Title", "Author", "ISBN", "Availability" };
        tableModel = new DefaultTableModel(columns, 0);
        tableResults = new JTable(tableModel);
        add(new JScrollPane(tableResults), BorderLayout.CENTER);

        // List for search history
        historyModel = new DefaultListModel<>();
        listHistory = new JList<>(historyModel);
        add(new JScrollPane(listHistory), BorderLayout.EAST);

        // Menu bar
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem exitItem = new JMenuItem("Exit");
        fileMenu.add(exitItem);

        JMenu viewMenu = new JMenu("View");
        JMenuItem clearHistoryItem = new JMenuItem("Clear History");
        viewMenu.add(clearHistoryItem);

        JMenu helpMenu = new JMenu("Help");
        JMenuItem aboutItem = new JMenuItem("About");
        helpMenu.add(aboutItem);

        menuBar.add(fileMenu);
        menuBar.add(viewMenu);
        menuBar.add(helpMenu);
        setJMenuBar(menuBar);

        // Event handling
        btnSearch.addActionListener(e -> searchBooks());
        tfSearch.addActionListener(e -> searchBooks()); // Enter key

        exitItem.addActionListener(e -> System.exit(0));
        clearHistoryItem.addActionListener(e -> historyModel.clear());
        aboutItem.addActionListener(e -> JOptionPane.showMessageDialog(this, "Library Search v1.0\nCreated by OpenAI",
                "About", JOptionPane.INFORMATION_MESSAGE));
    }

    private void searchBooks() {
        String keyword = tfSearch.getText().trim().toLowerCase();
        if (keyword.isEmpty())
            return;

        // Add to history
        historyModel.addElement(keyword);

        // Clear previous results
        tableModel.setRowCount(0);

        // Search in book database
        for (Object[] book : books) {
            String title = book[0].toString().toLowerCase();
            String author = book[1].toString().toLowerCase();
            String isbn = book[2].toString().toLowerCase();
            if (title.contains(keyword) || author.contains(keyword) || isbn.contains(keyword)) {
                tableModel.addRow(book);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LibrarySearch frame = new LibrarySearch();
            frame.setVisible(true);
        });
    }
}