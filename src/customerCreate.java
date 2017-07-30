import java.awt.Color;
import java.awt.GridLayout;
import java.util.Properties;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import forms.forms;

public class customerCreate {

	public static void main(String[] args) {
		
		//for JDatePicker
		//http://www.codejava.net/java-se/swing/how-to-use-jdatepicker-to-display-calendar-component
		
		Border border = BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1);
		
		forms customerform = new forms();
		customerform.setFormName("Customer Registration");
		
		JPanel panelCustomer = new JPanel(new GridLayout(16,2));
		
		JLabel firstName = new JLabel(" First Name:");
		JTextField firstnametxt = new JTextField();
		firstnametxt.setBorder(border);
		panelCustomer.add(firstName);
		panelCustomer.add(firstnametxt);
		
		JLabel lastName = new JLabel(" Last Name:");
		JTextField lastnametxt = new JTextField();
		lastnametxt.setBorder(border);
		panelCustomer.add(lastName);
		panelCustomer.add(lastnametxt);
		
		JPanel DatePickPane = new JPanel();
		DatePickPane.setBackground(Color.CYAN);
		UtilDateModel model = new UtilDateModel();
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
		// Don't know about the formatter, but there it is...
		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		datePicker.setBorder(border);
		datePicker.setBackground(Color.WHITE);
		
		JLabel dob = new JLabel(" Date of Birth:");
		panelCustomer.add(dob);
		panelCustomer.add(datePicker);
		
		customerform.addFormComponent(panelCustomer);

		customerform.setVisible(true);
		
	}

}
