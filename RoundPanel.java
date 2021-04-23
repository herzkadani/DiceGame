package projectV1;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class RoundPanel extends JPanel {
	JLabel lbl1 = new JLabel();
	JLabel lbl2 = new JLabel();
	JLabel lbl3 = new JLabel();
	JLabel lbl4 = new JLabel();
	JLabel lbl5 = new JLabel();
	JLabel lbl6 = new JLabel();
	JLabel lbl7 = new JLabel();

	public RoundPanel() {
		this.setLayout(null);

		lbl1.setBounds(10, 10, 30, 30);
		lbl2.setBounds(40, 10, 30, 30);
		lbl3.setBounds(70, 10, 30, 30);
		lbl4.setBounds(100, 10, 30, 30);
		lbl5.setBounds(130, 10, 30, 30);
		lbl6.setBounds(160, 10, 30, 30);
		lbl7.setBounds(190, 10, 30, 30);
		add(lbl1);
		add(lbl2);
		add(lbl3);
		add(lbl4);
		add(lbl5);
		add(lbl6);
		add(lbl7);
		this.setBackground(Color.LIGHT_GRAY);
		lbl6.setForeground(Color.WHITE);
		lbl7.setForeground(Color.WHITE);
	}

	public void setValue(int labelNr, String labelVal) {
		ImageIcon img1 = new ImageIcon("src/projectV1/1_30px.png");
		ImageIcon img2 = new ImageIcon("src/projectV1/2_30px.png");
		ImageIcon img3 = new ImageIcon("src/projectV1/3_30px.png");
		ImageIcon img4 = new ImageIcon("src/projectV1/4_30px.png");
		ImageIcon img5 = new ImageIcon("src/projectV1/5_30px.png");
		ImageIcon img6 = new ImageIcon("src/projectV1/6_30px.png");

		switch (labelNr) {
		case 1:
			if (labelVal.equals("0")) {
				lbl1.setIcon(null);
			} else if (labelVal.equals("1")) {
				lbl1.setIcon(img1);
			} else if (labelVal.equals("2")) {
				lbl1.setIcon(img2);
			} else if (labelVal.equals("3")) {
				lbl1.setIcon(img3);
			} else if (labelVal.equals("4")) {
				lbl1.setIcon(img4);
			} else if (labelVal.equals("5")) {
				lbl1.setIcon(img5);
			} else if (labelVal.equals("6")) {
				lbl1.setIcon(img6);
			}
			break;
		case 2:
			if (labelVal.equals("0")) {
				lbl2.setIcon(null);
			} else if (labelVal.equals("1")) {
				lbl2.setIcon(img1);
			} else if (labelVal.equals("2")) {
				lbl2.setIcon(img2);
			} else if (labelVal.equals("3")) {
				lbl2.setIcon(img3);
			} else if (labelVal.equals("4")) {
				lbl2.setIcon(img4);
			} else if (labelVal.equals("5")) {
				lbl2.setIcon(img5);
			} else if (labelVal.equals("6")) {
				lbl2.setIcon(img6);
			}
			break;
		case 3:
			if (labelVal.equals("0")) {
				lbl3.setIcon(null);
			} else if (labelVal.equals("1")) {
				lbl3.setIcon(img1);
			} else if (labelVal.equals("2")) {
				lbl3.setIcon(img2);
			} else if (labelVal.equals("3")) {
				lbl3.setIcon(img3);
			} else if (labelVal.equals("4")) {
				lbl3.setIcon(img4);
			} else if (labelVal.equals("5")) {
				lbl3.setIcon(img5);
			} else if (labelVal.equals("6")) {
				lbl3.setIcon(img6);
			}
			break;
		case 4:
			if (labelVal.equals("0")) {
				lbl4.setIcon(null);
			} else if (labelVal.equals("1")) {
				lbl4.setIcon(img1);
			} else if (labelVal.equals("2")) {
				lbl4.setIcon(img2);
			} else if (labelVal.equals("3")) {
				lbl4.setIcon(img3);
			} else if (labelVal.equals("4")) {
				lbl4.setIcon(img4);
			} else if (labelVal.equals("5")) {
				lbl4.setIcon(img5);
			} else if (labelVal.equals("6")) {
				lbl4.setIcon(img6);
			}
			break;
		case 5:
			if (labelVal.equals("0")) {
				lbl5.setIcon(null);
			} else if (labelVal.equals("1")) {
				lbl5.setIcon(img1);
			} else if (labelVal.equals("2")) {
				lbl5.setIcon(img2);
			} else if (labelVal.equals("3")) {
				lbl5.setIcon(img3);
			} else if (labelVal.equals("4")) {
				lbl5.setIcon(img4);
			} else if (labelVal.equals("5")) {
				lbl5.setIcon(img5);
			} else if (labelVal.equals("6")) {
				lbl5.setIcon(img6);
			}
			break;
		case 6:
			lbl6.setText(labelVal);
			break;
		case 7:
			lbl7.setText(labelVal);
			break;
		}
	}

}
