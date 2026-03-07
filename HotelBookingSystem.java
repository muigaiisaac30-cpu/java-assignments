//REG NUMBER: CT100/G/22432/24
//NAME: ISAAC JULIUS WAINAINA
//WEEK 8 ASSIGNMENT: JAVA SWING : HOTEL BOOKING SYSTEM

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HotelBookingSystem extends JFrame {
    // Booking Tab components
    private JTextField tfName, tfContact;
    private JSpinner spinnerCheckIn, spinnerCheckOut;
    private JComboBox<String> cbRoomType;
    private JButton btnBookNow, btnGenerateReceipt;

    // Rooms Tab components
    private JTable tableRooms;
    private DefaultTableModel tableModel;

    // Room data: Room Number, Type, Status
    private Object[][] rooms = {
            { "101", "Single", "Available" },
            { "102", "Single", "Available" },
            { "201", "Double", "Available" },
            { "202", "Double", "Available" },
            { "301", "Suite", "Available" },
            { "302", "Suite", "Available" }
    };

    private Object[] columnNames = { "Room No", "Type", "Status" };

    // Booking details
    private String lastBookingSummary = "";

    public HotelBookingSystem() {
        setTitle("Hotel Booking System");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTabbedPane tabbedPane = new JTabbedPane();

        // Booking Tab
        JPanel bookingPanel = new JPanel(new GridLayout(6, 2, 5, 5));
        tfName = new JTextField();
        tfContact = new JTextField();

        spinnerCheckIn = new JSpinner(new SpinnerDateModel());
        spinnerCheckOut = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor checkInEditor = new JSpinner.DateEditor(spinnerCheckIn, "dd/MM/yyyy");
        JSpinner.DateEditor checkOutEditor = new JSpinner.DateEditor(spinnerCheckOut, "dd/MM/yyyy");
        spinnerCheckIn.setEditor(checkInEditor);
        spinnerCheckOut.setEditor(checkOutEditor);

        cbRoomType = new JComboBox<>(new String[] { "Single", "Double", "Suite" });

        btnBookNow = new JButton("Book Now");
        btnGenerateReceipt = new JButton("Generate Receipt");

        bookingPanel.add(new JLabel("Customer Name:"));
        bookingPanel.add(tfName);
        bookingPanel.add(new JLabel("Contact No:"));
        bookingPanel.add(tfContact);
        bookingPanel.add(new JLabel("Check-in Date:"));
        bookingPanel.add(spinnerCheckIn);
        bookingPanel.add(new JLabel("Check-out Date:"));
        bookingPanel.add(spinnerCheckOut);
        bookingPanel.add(new JLabel("Room Type:"));
        bookingPanel.add(cbRoomType);
        bookingPanel.add(btnBookNow);
        bookingPanel.add(btnGenerateReceipt);

        tabbedPane.addTab("Booking", bookingPanel);

        // Rooms Tab
        tableModel = new DefaultTableModel(rooms, columnNames);
        tableRooms = new JTable(tableModel);
        tabbedPane.addTab("Rooms", new JScrollPane(tableRooms));

        add(tabbedPane);

        // Event handling
        btnBookNow.addActionListener(e -> bookRoom());
        btnGenerateReceipt.addActionListener(e -> showReceipt());
    }

    private void bookRoom() {
        String name = tfName.getText().trim();
        String contact = tfContact.getText().trim();
        Date checkIn = (Date) spinnerCheckIn.getValue();
        Date checkOut = (Date) spinnerCheckOut.getValue();
        String roomType = (String) cbRoomType.getSelectedItem();

        if (name.isEmpty() || contact.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all customer details.", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!checkOut.after(checkIn)) {
            JOptionPane.showMessageDialog(this, "Check-out date must be after check-in date.", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Find an available room
        boolean booked = false;
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            if (tableModel.getValueAt(i, 1).equals(roomType) && tableModel.getValueAt(i, 2).equals("Available")) {
                tableModel.setValueAt("Booked", i, 2);
                booked = true;
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                lastBookingSummary = "Customer Name: " + name + "\n" +
                        "Contact: " + contact + "\n" +
                        "Room No: " + tableModel.getValueAt(i, 0) + "\n" +
                        "Room Type: " + roomType + "\n" +
                        "Check-in: " + sdf.format(checkIn) + "\n" +
                        "Check-out: " + sdf.format(checkOut);
                JOptionPane.showMessageDialog(this, "Room booked successfully!");
                break;
            }
        }

        if (!booked) {
            JOptionPane.showMessageDialog(this, "No available rooms of selected type.", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void showReceipt() {
        if (lastBookingSummary.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No booking available to generate receipt.", "Info",
                    JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        JTextArea taReceipt = new JTextArea(lastBookingSummary, 10, 30);
        taReceipt.setEditable(false);
        JOptionPane.showMessageDialog(this, new JScrollPane(taReceipt), "Booking Receipt",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            HotelBookingSystem frame = new HotelBookingSystem();
            frame.setVisible(true);
        });
    }
}