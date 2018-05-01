package finalProject;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class frame3 extends JFrame {

	private static final int FRAME_WIDTH = 400;
	private static final int FRAME_HEIGHT = 400;
	private static final int CHART_WIDTH = 200;
	private static final int CHART_HEIGHT = 200;
	private static final String DEFAULT_NAME = "";
	private JLabel companyOffer;
	private JLabel NameOfCompany;
	private JTextField Result;
	private JTextField nameCo;
	private JTextField offer;
	private JButton addButton;
	private JButton removeButton;
	private JButton resultButton;
	private ChartComponent chart;
	company myCompany;
	LinkedList laleh = new LinkedList();

	/**
	 * make a new frame
	 */
	public frame3() {

		chart = new ChartComponent();
		chart.setPreferredSize(new Dimension(CHART_WIDTH, CHART_HEIGHT));
	//	chart.append(DEFAULT_NAME);
		createTextFields();
		createButtons();
		createPanel();
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
	}

	/**
	 * create all text fields
	 */
	private void createTextFields() {
		final int LABEL_FIELD_WIDTH = 20;
		NameOfCompany = new JLabel("Name:");
		nameCo = new JTextField(LABEL_FIELD_WIDTH);
		final int VALUE_FIELD_WIDTH = 10;
		companyOffer = new JLabel("Offer:");
		offer = new JTextField(VALUE_FIELD_WIDTH);
		Result = new JTextField(VALUE_FIELD_WIDTH);

	}

	/**
	 * add company to chart
	 *
	 */
	class AddBarListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {

			try {
				myCompany = new company();
				String label = nameCo.getText();
				double value = Double.parseDouble(offer.getText());
				myCompany.setCompanyName(label);
				myCompany.setSuggestedCost(value);
				laleh.sortInsert(myCompany);
				String co = myCompany.toString();
				chart.append(co);
				nameCo.setText("");
				offer.setText("");
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "enter number " + e.getMessage());
			}
		}
	}

	class AddResultListner implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			try {
				Result.setText(laleh.findWinner(laleh).toString());
			} catch (Exception e) {
				e.getMessage();
			}
		}
	}

	/**
	 *  create buttons
	 */
	public void createButtons() {
		addButton = new JButton("Add");
		addButton.addActionListener(new AddBarListener());
		removeButton = new JButton("Remove last");
		removeButton.addActionListener(new RemoveBarListener());
		resultButton = new JButton("Result");
		resultButton.addActionListener(new AddResultListner());
	}

	class RemoveBarListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			try {
				laleh.deletLast();
			    laleh.displaylist();
			} catch (Exception e) {
				e.getMessage();
			}
			chart.removeLast();
		}
	}

	/**
	 * create Panel
	 */
	public void createPanel() {
	    JPanel panel = new JPanel();
	    panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
	//    add(panel);
	    JPanel panel1 = new JPanel();
	    panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
		panel.add(NameOfCompany);
		panel.add(nameCo);
		panel.add(companyOffer);
		panel.add(offer);
		panel.add(addButton);
		panel.add(removeButton);
		panel1.add(chart);
		panel.add(resultButton);
		panel.add(Result);
		//add(panel);
		
		add(panel1);
		add(panel);
	}
}
