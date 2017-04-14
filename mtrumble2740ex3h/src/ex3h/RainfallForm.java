package ex3h;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;

public class RainfallForm extends JFrame {

	private JPanel contentPane;
	private JList rainfallList;
	private JTextField rainfallTextField;
	private JLabel totalLabel;
	private JLabel averageLabel;
	private JLabel maxLabel;
	private JLabel minLabel;
	private JButton updateButton;
	private JButton calculateButton;
	private String[] strRainfall = {
			"2.4", "3.2", "5.3", "5.2", "6.3", "2.1",
			"4.2", "6.2", "7.1", "3.6", "2.5", "5.3" };

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RainfallForm frame = new RainfallForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RainfallForm() {
		setTitle("COMC2740 Ex3H");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 339, 398);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMonthlyRainfall = new JLabel("Monthly rainfall:");
		lblMonthlyRainfall.setBounds(10, 13, 110, 16);
		contentPane.add(lblMonthlyRainfall);
		
		JList monthList = new JList();
		monthList.setBackground(UIManager.getColor("Label.background"));
		monthList.setEnabled(false);
		monthList.setModel(new AbstractListModel() {
			String[] values = new String[] {"01 Jan", "02 Feb", "03 Mar", "04 Apr", "05 May", "06 June", "07 Jul", "08 Aug", "09 Sep", "10 Oct", "11 Nov", "12 Dec"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		monthList.setBounds(10, 42, 62, 220);
		contentPane.add(monthList);
		
		rainfallList = new JList(strRainfall);
		rainfallList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				do_rainfallList_valueChanged(e);
			}
		});
		rainfallList.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		rainfallList.setBounds(84, 42, 62, 220);
		contentPane.add(rainfallList);
		
		rainfallTextField = new JTextField();
		rainfallTextField.setHorizontalAlignment(SwingConstants.RIGHT);
		rainfallTextField.setText("0.0");
		rainfallTextField.setBounds(84, 271, 62, 22);
		contentPane.add(rainfallTextField);
		rainfallTextField.setColumns(10);
		
		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setBounds(158, 63, 56, 16);
		contentPane.add(lblTotal);
		
		JLabel lblAverage = new JLabel("Average:");
		lblAverage.setBounds(158, 111, 56, 16);
		contentPane.add(lblAverage);
		
		JLabel lblHighest = new JLabel("Maximum:");
		lblHighest.setBounds(158, 160, 72, 16);
		contentPane.add(lblHighest);
		
		JLabel lblLowest = new JLabel("Minimum:");
		lblLowest.setBounds(158, 209, 72, 16);
		contentPane.add(lblLowest);
		
		totalLabel = new JLabel("0.0");
		totalLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		totalLabel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		totalLabel.setBounds(242, 57, 42, 28);
		contentPane.add(totalLabel);
		
		averageLabel = new JLabel("0.0");
		averageLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		averageLabel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		averageLabel.setBounds(242, 105, 42, 28);
		contentPane.add(averageLabel);
		
		maxLabel = new JLabel("0.0");
		maxLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		maxLabel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		maxLabel.setBounds(242, 154, 42, 28);
		contentPane.add(maxLabel);
		
		minLabel = new JLabel("0.0");
		minLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		minLabel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		minLabel.setBounds(242, 203, 42, 28);
		contentPane.add(minLabel);
		
		updateButton = new JButton("Update");
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_updateButton_actionPerformed(e);
			}
		});
		updateButton.setBounds(68, 306, 97, 25);
		contentPane.add(updateButton);
		updateButton.setEnabled(false);
		
		calculateButton = new JButton("Calculate");
		calculateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_calculateButton_actionPerformed(e);
			}
		});
		calculateButton.setBounds(212, 245, 97, 25);
		contentPane.add(calculateButton);
	}
	protected void do_rainfallList_valueChanged(ListSelectionEvent e) {
		updateButton.setEnabled(true);
		rainfallTextField.setText((String) rainfallList.getSelectedValue());
		rainfallTextField.requestFocus();
		rainfallTextField.selectAll();
	}
	protected void do_updateButton_actionPerformed(ActionEvent e) {
		int index = rainfallList.getSelectedIndex();
		double rValue = Double.parseDouble(rainfallTextField.getText());
		strRainfall[index] = Double.toString(rValue);
		rainfallList.repaint();
		
		rainfallTextField.setText("0.0");
		updateButton.setEnabled(false);
		totalLabel.setText("");
		averageLabel.setText("");
		maxLabel.setText("");
		minLabel.setText("");
	}
	protected void do_calculateButton_actionPerformed(ActionEvent e) {
		Rainfall rainfall = new Rainfall(strRainfall);
		
		DecimalFormat fmt = new DecimalFormat("#0.0");
		totalLabel.setText(fmt.format(rainfall.getTotal()));
		averageLabel.setText(fmt.format(rainfall.getAverage()));
		maxLabel.setText(fmt.format(rainfall.getHighest()));
		minLabel.setText(fmt.format(rainfall.getLowest()));
	}
}
