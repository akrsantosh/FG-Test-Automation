
import java.awt.Button;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;



class TextSuite extends Frame implements ActionListener {
static TextField tf1,tf2,tf3,tf4; 

public static void main(String[] args) {


Frame f=new Frame("Test Suite");
Label l1,l2,l3,l4;
Button b1,b2;

f.addWindowListener(new WindowAdapter() {
public void windowClosing(WindowEvent we) {
System.exit(0);	}
}
);


l1=new Label("TestSuiteName"); 
l1.setBounds(70,100,130,30); 
tf1=new TextField();
tf1.setBounds(250,100,150,30); 

l2=new Label("Priority"); 
l2.setBounds(70,150,130,30); 
tf2=new TextField("");
tf2.setBounds(250,150,150,30);

l3=new Label("Description");
l3.setBounds(70,200,130,30);
tf3=new TextField("");
tf3.setBounds(250,200,150,30);

l4=new Label("ReqirementReference");
l4.setBounds(70,250,130,30);
tf4=new TextField();
tf4.setBounds(250,250,150,30);

b1=new Button("Save"); 
b1.setBounds(100,350,80,20);
b2=new Button("Cancel"); 
b2.setBounds(200,350,80,20);

TextSuite classtest=new TextSuite();

b1.addActionListener(classtest);
b2.addActionListener(classtest);

f.add(l1); f.add(l2);
f.add(l3);f.add(l4);f.add(tf1);f.add(tf2);f.add(tf3);f.add(tf4);f.add(b1);f.add(b2);
f.setSize(500,400); 
f.setLayout(null); 
f.setVisible(true);
b1.setVisible(true);
b2.setVisible(true);
}

String uTestSuiteName="",uPriority="",uDescription="",uRequirementReference="";
public void paint(Graphics g){
	Font f=new Font("Serif",Font.BOLD,20);
	g.setFont(f);
	g.drawString("TestSuiteName"+uTestSuiteName,50,300);
	g.drawString("Priority"+uPriority,50,305);
	g.drawString("Description"+uDescription,50,400);
	g.drawString("RequirementReference"+uRequirementReference,50,450);
	}

@Override
public void actionPerformed(ActionEvent e)     
  {
    String str = e.getActionCommand();
    
    if(str.equals("Save")) {
    	 System.out.println("You clicked " + str + " button, Saved");	
         System.out.println("TestSuiteName : "+tf1.getText());
	     System.out.println("Priority" +tf2.getText());
         System.out.println("Description : "+tf3.getText());
         System.out.println("RequirementReference : "+tf4.getText());
    }
     
    else if(str.equals("Cancel")) {
    	tf1.setText("");
    	tf2.setText("");
    	tf3.setText("");
    	tf4.setText("");
      System.out.println("You clicked " + str + " button, Cancelled");
  }
}
}

