import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ServerFrame extends JFrame {
	Color dark = new Color(24, 31, 28);
	JButton stopServer = new JButton();
	JButton minimizeWindow = new JButton();
	JButton closeWindow = new JButton();

	JPanel moveWindow = new JPanel();

	JTextArea console = new JTextArea();
	JTextArea activePlayers = new JTextArea();
	JTextArea disconnectedPlayers = new JTextArea();
	JTextArea allPlayers = new JTextArea();

	JLabel consoleLabel = new JLabel("Console:");
	JLabel activePlayersLabel = new JLabel("Active Players:");
	JLabel disconnectedPlayersLabel = new JLabel("Disconnected Players:");
	JLabel allPlayersLabel = new JLabel("All Players:");
	
	JLabel title = new JLabel("Server");

	ArrayList<JTextArea> JTextAreas = new ArrayList<>();
	ArrayList<JScrollPane> JScrollPanes = new ArrayList<>();
	ArrayList<JLabel> JLabels = new ArrayList<>();

	JPanel panel = new JPanel();

	public ServerFrame() {
		setSize(400, 740);
		setLocationRelativeTo(null);
		panel.setBackground(dark);
		this.add(panel);
		setResizable(false);
		setFocusable(true);
		setUndecorated(true);
		initComponents();
		setVisible(true);
	}

	public void initComponents() {
		Font font = new Font("Helvetica", Font.BOLD, 20);
		Font labelFont = new Font("Helvetica", Font.BOLD, 15);

		Color normal = new Color(24, 105, 68);
		Color hover = new Color(82, 157, 123);
		Color hover2 = new Color(129, 188, 163);

		panel.setLayout(null);

		JTextAreas.add(activePlayers);
		JTextAreas.add(disconnectedPlayers);
		JTextAreas.add(allPlayers);
		JTextAreas.add(console);

		JLabels.add(activePlayersLabel);
		JLabels.add(disconnectedPlayersLabel);
		JLabels.add(allPlayersLabel);
		JLabels.add(consoleLabel);

		MouseAdapter ma = new MouseAdapter() {
			int lastX, lastY;

			@Override
			public void mousePressed(MouseEvent e) {
				lastX = e.getXOnScreen();
				lastY = e.getYOnScreen();
			}

			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(getLocationOnScreen().x + x - lastX, getLocationOnScreen().y + y - lastY);
				lastX = x;
				lastY = y;
			}
		};

		moveWindow.setLayout(null);
		moveWindow.addMouseListener(ma);
		moveWindow.addMouseMotionListener(ma);
		moveWindow.setBackground(normal);
		moveWindow.setBounds(0, 0, 400, 40);
		moveWindow.setFocusable(false);
		
		title.setForeground(Color.WHITE);
		title.setFont(font);
		title.setBounds(25, 0, 400, 40);
		moveWindow.add(title);
		
		minimizeWindow.setLayout(null);
		minimizeWindow.setMargin(new Insets(5, 5, 5, 5));
		minimizeWindow.setBackground(hover);
		minimizeWindow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setState(Frame.ICONIFIED);
			}
		});
		minimizeWindow.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				minimizeWindow.setBackground(hover2);
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			public void mouseExited(MouseEvent e) {
				minimizeWindow.setBackground(hover);
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		minimizeWindow.setBounds(310, 5, 30, 30);
		minimizeWindow.setFont(font);
		minimizeWindow.setText("_");
		minimizeWindow.setForeground(Color.WHITE);
		minimizeWindow.setFocusable(false);
		minimizeWindow.setBorderPainted(false);
		moveWindow.add(minimizeWindow);

		closeWindow.setLayout(null);
		closeWindow.setMargin(new Insets(5, 5, 5, 5));
		closeWindow.setBackground(hover);
		closeWindow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		closeWindow.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				closeWindow.setBackground(hover2);
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			public void mouseExited(MouseEvent e) {
				closeWindow.setBackground(hover);
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		closeWindow.setBounds(345, 5, 30, 30);
		closeWindow.setFont(font);
		closeWindow.setText("×");
		closeWindow.setForeground(Color.WHITE);
		closeWindow.setFocusable(false);
		closeWindow.setBorderPainted(false);
		moveWindow.add(closeWindow);

		panel.add(moveWindow);

		stopServer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// STOPPA SERVERN
			}
		});
		stopServer.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				stopServer.setBackground(hover);
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			public void mouseExited(MouseEvent e) {
				stopServer.setBackground(normal);
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		stopServer.setBackground(normal);
		stopServer.setBounds(25, 65, 350, 50);
		stopServer.setFont(font);
		stopServer.setText("Stop Server");
		stopServer.setForeground(Color.WHITE);
		stopServer.setFocusable(false);
		stopServer.setBorderPainted(false);
		panel.add(stopServer);

		for (int i = 0; i < JTextAreas.size(); i++) {

			JTextArea temp = JTextAreas.get(i);
			JLabel tempLabel = JLabels.get(i);

			if (i == 3) {
				temp.setBounds(25, 140, 350, 200);
				tempLabel.setBounds(25, 115, 350, 25);

			} else {
				temp.setBounds(25, 365 + 125 * i, 350, 100);
				tempLabel.setBounds(25, (365 + 125 * i) - 25, 350, 25);
			}
			tempLabel.setFont(labelFont);
			tempLabel.setForeground(Color.WHITE);

			temp.setBackground(hover);
			temp.setFont(font);
			temp.setForeground(Color.WHITE);
			temp.setFocusable(true);
			temp.setEditable(false);
			temp.setMargin(new Insets(5, 5, 5, 5));

			JScrollPane tempScrollPane = new JScrollPane(temp);
			tempScrollPane.setBounds(temp.getBounds());
			tempScrollPane.setBorder(BorderFactory.createEmptyBorder());
			panel.add(tempScrollPane);
			panel.add(tempLabel);

		}

	}
}
