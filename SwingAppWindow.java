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
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;

public class SwingAppWindow {

	private JFrame frmLargeNumberMultiplier;
	private JTextField first;
	private JTextField second;
	private JTextArea outputField;
	private JScrollBar scrollBar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SwingAppWindow window = new SwingAppWindow();
					window.frmLargeNumberMultiplier.setVisible(true);
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
		frmLargeNumberMultiplier = new JFrame();
		frmLargeNumberMultiplier.setFont(new Font("Serpentine Std", Font.PLAIN, 12));
		frmLargeNumberMultiplier.setTitle("Large Number Multiplier");
		frmLargeNumberMultiplier.setBounds(100, 100, 620, 260);
		frmLargeNumberMultiplier.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {10, 200, 200, 200, 0, 10};
		gridBagLayout.rowHeights = new int[] {60, 60, 40, 60};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0};
		frmLargeNumberMultiplier.getContentPane().setLayout(gridBagLayout);
		
		JLabel lblFirstNumber = new JLabel("First Number");
		lblFirstNumber.setToolTipText("You're investigating...");
		GridBagConstraints gbc_lblFirstNumber = new GridBagConstraints();
		gbc_lblFirstNumber.insets = new Insets(0, 0, 5, 5);
		gbc_lblFirstNumber.fill = GridBagConstraints.VERTICAL;
		gbc_lblFirstNumber.gridx = 1;
		gbc_lblFirstNumber.gridy = 0;
		frmLargeNumberMultiplier.getContentPane().add(lblFirstNumber, gbc_lblFirstNumber);
		
		JLabel lblSecondNumber = new JLabel("Second Number");
		lblSecondNumber.setToolTipText("");
		GridBagConstraints gbc_lblSecondNumber = new GridBagConstraints();
		gbc_lblSecondNumber.insets = new Insets(0, 0, 5, 5);
		gbc_lblSecondNumber.gridx = 3;
		gbc_lblSecondNumber.gridy = 0;
		frmLargeNumberMultiplier.getContentPane().add(lblSecondNumber, gbc_lblSecondNumber);
		
		first = new JTextField();
		first.setToolTipText("");
		GridBagConstraints gbc_first = new GridBagConstraints();
		gbc_first.fill = GridBagConstraints.BOTH;
		gbc_first.insets = new Insets(0, 0, 5, 5);
		gbc_first.gridx = 1;
		gbc_first.gridy = 1;
		frmLargeNumberMultiplier.getContentPane().add(first, gbc_first);
		first.setColumns(10);
		
		JButton btnMultiply = new JButton("Multiply");
		btnMultiply.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				outputField.setText(DefaultCalculator.multiply(first.getText(), second.getText()));
			}
		});
		
		second = new JTextField();
		GridBagConstraints gbc_second = new GridBagConstraints();
		gbc_second.fill = GridBagConstraints.BOTH;
		gbc_second.insets = new Insets(0, 0, 5, 5);
		gbc_second.gridx = 3;
		gbc_second.gridy = 1;
		frmLargeNumberMultiplier.getContentPane().add(second, gbc_second);
		second.setColumns(10);
		btnMultiply.setToolTipText("GET ON WITH IT.");
		GridBagConstraints gbc_btnMultiply = new GridBagConstraints();
		gbc_btnMultiply.anchor = GridBagConstraints.SOUTH;
		gbc_btnMultiply.insets = new Insets(0, 0, 5, 5);
		gbc_btnMultiply.gridx = 2;
		gbc_btnMultiply.gridy = 2;
		frmLargeNumberMultiplier.getContentPane().add(btnMultiply, gbc_btnMultiply);
		
		scrollBar = new JScrollBar();
//		GridBagConstraints gbc_scrollBar = new GridBagConstraints();
//		gbc_scrollBar.insets = new Insets(0, 0, 0, 5);
//		gbc_scrollBar.gridx = 4;
//		gbc_scrollBar.gridy = 3;
//		frmLargeNumberMultiplier.getContentPane().add(scrollBar, gbc_scrollBar);
		
		outputField = new JTextArea();
		outputField.setLineWrap(true);
		outputField.add(scrollBar);
		GridBagConstraints gbc_outputField = new GridBagConstraints();
		gbc_outputField.insets = new Insets(0, 0, 0, 5);
		gbc_outputField.fill = GridBagConstraints.HORIZONTAL;
		gbc_outputField.gridwidth = 3;
		gbc_outputField.gridx = 1;
		gbc_outputField.gridy = 3;
		frmLargeNumberMultiplier.getContentPane().add(outputField, gbc_outputField);
		outputField.setColumns(10);
		
	}

}
