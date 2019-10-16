package com.UI_Automation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.MenuBar;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class AutomationSimulator implements TreeSelectionListener, MouseListener
{
	final static String COMMAND_FILES_PATH="D:\\automation-files";
	static String commandString  = "";
	JPanel panel;
    JLabel projectName, projectURL, environment,projectDesc,buildVersion,buildURL,buildDate;
    JTextField userName_text,projectURLField, environmentField,projectDescField,buildVersionField,
    buildURLField,buildDateField;
    JPasswordField password_text;
    JButton submit, cancel;
    JPanel rightClickPanel ;
    
    JButton add, rename,edit, delete;
    
    JPanel  centerPanel,northPanel, westPanel; 
    
   
    
    public AutomationSimulator()
    {

		JFrame mainFrame = new JFrame();
		
		
		panel = new JPanel();
		rightClickPanel = new JPanel();
		rightClickPanel.setLayout(new BoxLayout(rightClickPanel, BoxLayout.Y_AXIS));
		
		add = new JButton("+ Add");
		rename = new JButton("Rename");
		delete = new JButton("Delete");
		edit = new JButton("Edit");
		
		rightClickPanel.add(add);
		rightClickPanel.add(rename);
		rightClickPanel.add(delete);
		rightClickPanel.add(edit);
		
		rightClickPanel.setBounds(100, 100, 100, 100);
		
	    
	    rightClickPanel.setVisible(false);
		
		mainFrame.setSize(750, 650);
		
		 DefaultMutableTreeNode root = new DefaultMutableTreeNode("Root");
		    
		    DefaultMutableTreeNode Project=new DefaultMutableTreeNode("Test Project                   ");  
		   
		    DefaultMutableTreeNode Suit=new DefaultMutableTreeNode("Test Suit");
		    Suit.add(new DefaultMutableTreeNode("add"));
		    Suit.add(new DefaultMutableTreeNode("Rename"));
		    Suit.add(new DefaultMutableTreeNode("Edit"));
		    Suit.add(new DefaultMutableTreeNode("Delete"));
		    
		    DefaultMutableTreeNode Testcase1 = new DefaultMutableTreeNode("TestCase1");
		    DefaultMutableTreeNode Testcase2 = new DefaultMutableTreeNode("Testcase2");
		    
		    
		   
		    root.add(Project);
		    Project.add(Suit);
		    Project.add(Testcase1);
		    Project.add(Testcase2);
		
		JTree tree = new JTree(root);
		tree.setRootVisible(false);
		tree.setSize(1000, 1000);
		
	    tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
	    tree.addTreeSelectionListener(this);
	   tree.addMouseListener(this);
	    
		 northPanel = new JPanel();
		 westPanel = new JPanel();
		 
		 westPanel.setSize(100, 500);
		
		westPanel.add(new JScrollPane(tree));
		
		
		JButton northbtn1 = new JButton("File");
		JButton northbtn2 = new JButton("Edit");
		JButton northbtn3 = new JButton("Toolbar");
		JButton northbtn4 = new JButton("Tools");
		JButton northbtn5 = new JButton("Support");
		JButton northbtn6 = new JButton("View");
		
		
		/**creating and adding contents to projects info frame*/
		
		  projectName = new JLabel("Project Name  ");	
		  
		  userName_text = new JTextField(10);
		 // userName_text.setPreferredSize(new Dimension());
		       
	      projectURL = new JLabel("Project URL     ");	       
	      projectURLField = new JTextField(20);
	     // projectURLField.setPreferredSize(new Dimension());
	      
	      projectDesc = new JLabel("Description      ");	      
	      projectDescField = new JTextField(20);
	      //projectDescField.setPreferredSize(new Dimension());
	      
	      buildVersion = new JLabel("Build Version   ");	       
	      buildVersionField= new  JTextField(20);
	     // buildVersionField.setPreferredSize(new Dimension());
	      
	      buildDate = new JLabel("Build Date         ");	      
	      buildDateField = new JTextField(20);
	     // buildDateField.setPreferredSize(new Dimension());
	      
	      environment = new JLabel("Environment    ");	      
	      environmentField = new JTextField(5);
	     // environmentField.setPreferredSize(new Dimension());
	      
	      
	      

	        

	       submit = new JButton("SUBMIT");
	        centerPanel = new JPanel();
	        centerPanel.setVisible(false);
	        

	        centerPanel.setSize(200, 100);
	        
	        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
	        
	     JLabel projectNameLabel = new JLabel("Project Information");
	     projectNameLabel.setForeground(Color.BLUE);
	     
	     
             projectNameLabel.setFont(new Font("Serif", Font.BOLD,12));
	       // setFont("Serif", Font.BOLD, 20);
	       //projectNameLabel.setFont(null);
	        
	     projectNameLabel.setSize(100, 100);
	       centerPanel.add(projectNameLabel);
	        
	        JPanel projectNamePanel = new JPanel();
	        projectNamePanel.setLayout(new BoxLayout(projectNamePanel, BoxLayout.X_AXIS));
	        projectNamePanel.add(projectName);
	        projectNamePanel.add(userName_text);
	        
	        
	        JPanel projectURLPanel = new JPanel();
	       projectURLPanel.setSize(10, 10);
	        projectURLPanel.setLayout(new BoxLayout(projectURLPanel, BoxLayout.X_AXIS));
	        projectURLPanel.add(projectURL);
	        projectURLPanel.add(projectURLField);
	        
	       
	        
	        JPanel projectDescPanel = new JPanel();
	        projectDescPanel.setLayout(new BoxLayout(projectDescPanel, BoxLayout.X_AXIS));
	        projectDescPanel.add(projectDesc);
	        projectDescPanel.add(projectDescField);
	        
	        JPanel buildVersionPanel = new JPanel();
	        buildVersionPanel.setLayout(new BoxLayout(buildVersionPanel, BoxLayout.X_AXIS));
	        buildVersionPanel.add(buildVersion);
	        buildVersionPanel.add(buildVersionField);
	        
	        JPanel buildDatePanel = new JPanel();
	        buildDatePanel.setLayout(new BoxLayout(buildDatePanel, BoxLayout.X_AXIS));
	        buildDatePanel.add(buildDate);
	        buildDatePanel.add(buildDateField);

	        
	        JPanel envPanel = new JPanel();
	        envPanel.setLayout(new BoxLayout(envPanel, BoxLayout.X_AXIS));
	        envPanel.add(environment);
	        envPanel.add(environmentField);
	        
	        centerPanel.setPreferredSize(new Dimension(400,200));
	        
	        centerPanel.add(projectNamePanel);
	      //  centerPanel.add(projectURLPanel);
	        centerPanel.add(projectDescPanel);
	        centerPanel.add(envPanel);
	        centerPanel.add(buildDatePanel);
	        centerPanel.add(buildVersionPanel);
	        
	        
	        centerPanel.add(rightClickPanel);
	        
	        submit = new JButton("submit");
	       
	        submit.setBounds(1000,420,820,320);
	        
	        cancel = new JButton("cancel");
	        cancel.setBounds(180,420,80,30);
	        JPanel submitPanel  = new JPanel();
	        submitPanel.setLayout(new BoxLayout(submitPanel, BoxLayout.X_AXIS));
	        
	        submitPanel.add(submit);
	        submitPanel.add(cancel);
	        
	        centerPanel.add(submitPanel);
	       


		northPanel.add(northbtn1);
		northPanel.add(northbtn2);
		northPanel.add(northbtn3);
		northPanel.add(northbtn4);
		northPanel.add(northbtn5);
		northPanel.add(northbtn6);
		
		northPanel.setVisible(true);
		
		mainFrame.getContentPane().add(centerPanel, BorderLayout.NORTH);
		mainFrame.getContentPane().add(centerPanel, BorderLayout.CENTER);
    	mainFrame.getContentPane().add(westPanel, BorderLayout.WEST);		
		mainFrame.getContentPane().add(northPanel, BorderLayout.NORTH);	
		
		panel.add(westPanel);
		panel.add(centerPanel);
		mainFrame.getContentPane().add(panel, BorderLayout.WEST);
		
		
		
		mainFrame.setVisible(true);
	
		//mainFrame.setLocationRelativeTo(null);
	
    }
	
	public static void main(String[] args) 
	{
		new AutomationSimulator();
	}

	public static String getCommandInfo(String commandName)
	{
		try 
		{
			
			
			File commandFile = new File(COMMAND_FILES_PATH+"/"+commandName+".xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(commandFile);
					
			
			doc.getDocumentElement().normalize();

			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
					
			NodeList commandList = doc.getElementsByTagName("command");
			NodeList attributeList = doc.getElementsByTagName("attribute1");		
			System.out.println("----------------------------");
			
			commandString = commandString+"------------retrieving commands for "+commandName+"  -------------------\n";

			for (int counter = 0; counter < commandList.getLength(); counter++) {

				Node nNode = commandList.item(counter);
				Node attributeNode = attributeList.item(counter);
				
				
				System.out.println("Command name:----->" + nNode.getNodeName());
						
				if (nNode.getNodeType() == Node.ELEMENT_NODE && attributeNode.getNodeType()== Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;
					Element attributeElement = (Element)attributeNode;
					
					commandString = commandString+"\nCurrent comand :" + eElement.getAttribute("id");
					commandString = commandString+"\nCurrent attribute :" + attributeElement.getNodeName();
					commandString =commandString+"\n=============================";
							
				}
			}
		    } catch (Exception e) {
			e.printStackTrace();
		    }
		return commandString;
		  }

		
	 public void valueChanged(TreeSelectionEvent se) {
		  
		    JTree tree = (JTree) se.getSource();
		    
		    DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree
		        .getLastSelectedPathComponent();
		    String selectedNodeName = selectedNode.toString();
		    if (selectedNode.isLeaf()) {

		      System.out.println("leaf is selected");
		      centerPanel.setVisible(true);

		    }
		    else
		    {
		    	System.out.println("test is selected or not "+selectedNodeName);
		    	if(selectedNodeName.equalsIgnoreCase("Test Suit"))
		    	{
		    		centerPanel.setVisible(true);
		    		
		    	}
		    	else
		    		centerPanel.setVisible(false);
		    }
		    	
		  }

	@Override
	public void mouseClicked(MouseEvent e) 
	{
		if (SwingUtilities.isRightMouseButton(e)) 
		{
			//JOptionPane.showMessageDialog(null, "mouse right click event is enable");
			//JOptionPane.showMessageDialog(null, "Printing complete");
			
	       /* int row = tree.getClosestRowForLocation(e.getX(), e.getY());
	        tree.setSelectionRow(row);
	        popupMenu.show(e.getComponent(), e.getX(), e.getY());*/
	    }
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}	
		
		
	
}
