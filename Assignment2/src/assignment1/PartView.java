package assignment1;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PartView extends JFrame implements PartObserver {
	private JTextField tfPartNum;
	private JTextField tfPartName;
	private JTextField tfVendor;
	private JTextField tfQty;
<<<<<<< HEAD:Assignment2/src/assignment1/PartView.java
	private JMenu uMenu;	

=======
        private JTextField tfID;
	
>>>>>>> Weasley:Assignment2/src/assignment1/PartView.java
	private Part part;
	private InventoryController invC;
	
	public PartView(InventoryController i, Part p) {
		part = p;
		invC = i;
		

	JMenuBar menuBar = new JMenuBar()
	setJMenuBar(menuBar);

	uMenu = new JMenu("Units");
	menuBar.add(uMenu);

	JMenuItem linearFeet = new JMenuItem("Linear Feet");
	JMenuItem pieces = new JMenuItem("Pieces");
	uMenu.add(linearFeet);
	uMenu.add(pieces);

		this.setLayout(new BorderLayout());
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(5,2));
		
		panel.add(new JLabel("Part #"));
		tfPartNum = new JTextField();
		panel.add(tfPartNum);
		
		panel.add(new JLabel("Part Name"));
		tfPartName = new JTextField();
		panel.add(tfPartName);

		panel.add(new JLabel("Vendor"));
		tfVendor = new JTextField();
		panel.add(tfVendor);

		panel.add(new JLabel("Quantity"));
		tfQty = new JTextField();
		panel.add(tfQty);

                panel.add(new JLabel("ID"));
                tfID = new JTextField();
                panel.add(tfID);

		this.add(panel, BorderLayout.CENTER);
		
		panel = new JPanel();
		panel.setLayout(new GridLayout(1,2));
		JButton button = new JButton("Save");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					int x = Integer.parseInt(tfQty.getText().trim());
				} catch(Exception err) {
					PartView.this.showError("Invalid Quantity!");
					return;
				}
				Part p = invC.addPart(PartView.this, part, tfPartNum.getText(), tfPartName.getText(), tfVendor.getText(), Integer.parseInt(tfQty.getText().trim()));
				if(p != null) {
					if(part == null) {
						part = p;
						part.registerObserver(PartView.this);
						PartView.this.setTitle("Editing " + part.getPartName());
					} else
						part = p;
				}
			}
		});
		panel.add(button);
		
		this.add(panel, BorderLayout.SOUTH);

		//set for edit mode
		if(p != null) {
			tfPartNum.setText(part.getPartNumber());
			tfPartName.setText(part.getPartName());
			tfVendor.setText(part.getVendor());
<<<<<<< HEAD:Assignment2/src/assignment1/PartView.java
			tfQty.setText(Integer.toString(part.getQuantity()) + " " + Part.getQuantityUnit());
=======
			tfQty.setText(Integer.toString(part.getQuantity()));
			tfID.setText(Integer.toString(part.getIDNumber()));
>>>>>>> Weasley:Assignment2/src/assignment1/PartView.java
			this.setTitle("Editing " + p.getPartName());
		} else
			this.setTitle("Adding new part");
	}
	
	public void showError(String msg) {
		JOptionPane.showMessageDialog(this, msg, "Error!", JOptionPane.ERROR_MESSAGE);
	}
	
	@Override
	public void updateObserver(Part part) {
		if(part != null) {
			tfPartNum.setText(part.getPartNumber());
			tfPartName.setText(part.getPartName());
			tfVendor.setText(part.getVendor());
<<<<<<< HEAD:Assignment2/src/assignment1/PartView.java
			tfQty.setText(Integer.toString(part.getQuantity()) + " " + Part.getQuantityUnit());
=======
			tfQty.setText(Integer.toString(part.getQuantity()));
			tfID.setText(Integer.toString(pat.getIDNumber()));
>>>>>>> Weasley:Assignment2/src/assignment1/PartView.java
			this.setTitle("Editing " + part.getPartName());
		}
	}

	@Override
	public void modelDeleted() {
		this.setVisible(false);
		
	}

   public void registerListener(InventoryController controller) {
      Component[] components = uMenu.getMenuComponents();
      for (Component component : components) {
         if (component instanceof AbstractButton) {
		AbstractButton button = (AbstractButton) component;
		button.addActionListener((ActionListener) controller);
         }
      }
   }

}
