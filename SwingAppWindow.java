package AndreCalculator;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SwingAppWindow {

	private JFrame frame;
	private JTextField first;
	private JTextField second;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SwingAppWindow window = new SwingAppWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SwingAppWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 220);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {200, 200, 200};
		gridBagLayout.rowHeights = new int[] {60, 60, 40, 60};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JLabel lblFirstNumber = new JLabel("First Number");
		lblFirstNumber.setToolTipText("You're investigating...");
		GridBagConstraints gbc_lblFirstNumber = new GridBagConstraints();
		gbc_lblFirstNumber.insets = new Insets(0, 0, 5, 5);
		gbc_lblFirstNumber.fill = GridBagConstraints.VERTICAL;
		gbc_lblFirstNumber.gridx = 0;
		gbc_lblFirstNumber.gridy = 0;
		frame.getContentPane().add(lblFirstNumber, gbc_lblFirstNumber);
		
		JLabel lblSecondNumber = new JLabel("Second Number");
		lblSecondNumber.setToolTipText("");
		GridBagConstraints gbc_lblSecondNumber = new GridBagConstraints();
		gbc_lblSecondNumber.insets = new Insets(0, 0, 5, 0);
		gbc_lblSecondNumber.gridx = 2;
		gbc_lblSecondNumber.gridy = 0;
		frame.getContentPane().add(lblSecondNumber, gbc_lblSecondNumber);
		
		first = new JTextField();
		first.setToolTipText("");
		GridBagConstraints gbc_first = new GridBagConstraints();
		gbc_first.fill = GridBagConstraints.BOTH;
		gbc_first.insets = new Insets(0, 0, 5, 5);
		gbc_first.gridx = 0;
		gbc_first.gridy = 1;
		frame.getContentPane().add(first, gbc_first);
		first.setColumns(10);
		
		second = new JTextField();
		GridBagConstraints gbc_second = new GridBagConstraints();
		gbc_second.fill = GridBagConstraints.BOTH;
		gbc_second.insets = new Insets(0, 0, 5, 0);
		gbc_second.gridx = 2;
		gbc_second.gridy = 1;
		frame.getContentPane().add(second, gbc_second);
		second.setColumns(10);
		
		JButton btnMultiply = new JButton("Multiply");
		btnMultiply.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField.setText(DefaultCalculator.multiply(first.getText(), second.getText()));
			}
		});
		btnMultiply.setToolTipText("GET ON WITH IT.");
		GridBagConstraints gbc_btnMultiply = new GridBagConstraints();
		gbc_btnMultiply.anchor = GridBagConstraints.SOUTH;
		gbc_btnMultiply.insets = new Insets(0, 0, 5, 5);
		gbc_btnMultiply.gridx = 1;
		gbc_btnMultiply.gridy = 2;
		frame.getContentPane().add(btnMultiply, gbc_btnMultiply);
		
		textField = new JTextField();
		GridBagConstraints gbc_output = new GridBagConstraints();
		gbc_output.fill = GridBagConstraints.HORIZONTAL;
		gbc_output.gridwidth = 3;
		gbc_output.insets = new Insets(0, 0, 0, 5);
		gbc_output.gridx = 0;
		gbc_output.gridy = 3;
		frame.getContentPane().add(textField, gbc_output);
		textField.setColumns(10);
	}

}
