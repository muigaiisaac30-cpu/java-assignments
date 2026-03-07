//REG NUMBER: CT100/G/22432/24
//NAME: ISAAC JULIUS WAINAINA
//WEEK 8: JAVA SWING ASSIGNMENT

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StudentRegistration extends JFrame {
    // GUI components
    private JTextField tfID, tfName, tfCourse, tfYear;
    private JComboBox<String> cbDept;
    private JRadioButton rbMale, rbFemale, rbOther;
    private JCheckBox cbHostel;
    private JButton btnRegister, btnClear;
    private JTextArea taOutput;
    private ButtonGroup genderGroup;

    public StudentRegistration() {
        // JFrame settings
        setTitle("Student Registration");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // Panel for form inputs
        JPanel panelForm = new JPanel(new GridLayout(7, 2, 5, 5));

        panelForm.add(new JLabel("Student ID:"));
        tfID = new JTextField();
        panelForm.add(tfID);

        panelForm.add(new JLabel("Full Name:"));
        tfName = new JTextField();
        panelForm.add(tfName);

        panelForm.add(new JLabel("Course:"));
        tfCourse = new JTextField();
        panelForm.add(tfCourse);

        panelForm.add(new JLabel("Year of Study:"));
        tfYear = new JTextField();
        panelForm.add(tfYear);

        panelForm.add(new JLabel("Department:"));
        cbDept = new JComboBox<>(new String[]{"IT", "Business", "Engineering", "Science"});
        panelForm.add(cbDept);

        panelForm.add(new JLabel("Gender:"));
        JPanel genderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        rbMale = new JRadioButton("Male");
        rbFemale = new JRadioButton("Female");
        rbOther = new JRadioButton("Other");
        genderGroup = new ButtonGroup();
        genderGroup.add(rbMale);
        genderGroup.add(rbFemale);
        genderGroup.add(rbOther);
        genderPanel.add(rbMale);
        genderPanel.add(rbFemale);
        genderPanel.add(rbOther);
        panelForm.add(genderPanel);

        panelForm.add(new JLabel("Hostel Required:"));
        cbHostel = new JCheckBox();
        panelForm.add(cbHostel);

        add(panelForm, BorderLayout.NORTH);

        // Panel for buttons
        JPanel panelButtons = new JPanel(new FlowLayout());
        btnRegister = new JButton("Register");
        btnClear = new JButton("Clear");
        panelButtons.add(btnRegister);
        panelButtons.add(btnClear);
        add(panelButtons, BorderLayout.CENTER);

        // Text area to display registered info
        taOutput = new JTextArea(8, 40);
        taOutput.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(taOutput);
        add(scrollPane, BorderLayout.SOUTH);

        // Event handling
        btnRegister.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                registerStudent();
            }
        });

        btnClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clearFields();
            }
        });
    }

    private void registerStudent() {
        // Validate fields
        if (tfID.getText().isEmpty() || tfName.getText().isEmpty() ||
            tfCourse.getText().isEmpty() || tfYear.getText().isEmpty() ||
            genderGroup.getSelection() == null) {
            JOptionPane.showMessageDialog(this, "Please fill all fields.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Get selected gender
        String gender = rbMale.isSelected() ? "Male" : rbFemale.isSelected() ? "Female" : "Other";
        String hostel = cbHostel.isSelected() ? "Yes" : "No";

        // Display student info in text area
        taOutput.setText("Student Registration Details:\n");
        taOutput.append("ID: " + tfID.getText() + "\n");
        taOutput.append("Name: " + tfName.getText() + "\n");
        taOutput.append("Course: " + tfCourse.getText() + "\n");
        taOutput.append("Year: " + tfYear.getText() + "\n");
        taOutput.append("Department: " + cbDept.getSelectedItem() + "\n");
        taOutput.append("Gender: " + gender + "\n");
        taOutput.append("Hostel Required: " + hostel + "\n");

        JOptionPane.showMessageDialog(this, "Student registered successfully!");
    }

    private void clearFields() {
        tfID.setText("");
        tfName.setText("");
        tfCourse.setText("");
        tfYear.setText("");
        cbDept.setSelectedIndex(0);
        genderGroup.clearSelection();
        cbHostel.setSelected(false);
        taOutput.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            StudentRegistration frame = new StudentRegistration();
            frame.setVisible(true);
        });
    }
}