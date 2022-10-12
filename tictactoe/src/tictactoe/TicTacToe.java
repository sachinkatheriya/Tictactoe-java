package tictactoe;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class TicTacToe
{
  JFrame fr = new JFrame("Tic Tac Toe");
  JLabel la = new JLabel();
  JLabel msg = new JLabel("First Player turn..");
  JPanel [] pa = new JPanel[3];
  JButton reset = new JButton("RESET");
  JButton [] bt = new JButton[9];
  ImageIcon icon1 = new ImageIcon(getClass().getResource("images/user1.png"));
  ImageIcon icon2 = new ImageIcon(getClass().getResource("images/user2.png"));
   int Player =1;
   boolean winnerFound =false;
   int count =0;
	  public TicTacToe()
	  {
		  fr.setSize(600,650);
		  fr.setResizable(false);
		  fr.setDefaultCloseOperation(3);
		  fr.setLocationRelativeTo(null);
		  addLabel();
		  fr.setVisible(true);
	  }
	 public void  addLabel()
	 {
		 la.setLayout(null);
		 fr.add(la);
		 addimage();
		 for(int i=0;i<3;i++)
		 {
			 pa[i]=new JPanel();
			 la.add(pa[i]);
		 }
		 pa[0].setBounds(70,30,460,40);
		 pa[0].setBackground(Color.CYAN);
		 pa[1].setBounds(70,100,460,400);
		 pa[2].setBounds(70,530,460,40);
		 pa[2].setOpaque(false);
		 addbutton();
		 pa[0].add(msg);
		 msg.setFont(new Font("elephant",0,20));
	 }
	 public void addimage()
	 {
		 ImageIcon ic = new ImageIcon(getClass().getResource("images/t2.jpg"));
		 la.setIcon(ic);
		
	}
	 public void addbutton()
	 {
		 pa[1].setLayout(new GridLayout(3,3));
		 for(int i=0;i<=8;i++)
		 {
			 bt[i]= new JButton();
			 bt[i].addActionListener(new TicListener());
			 pa[1].add(bt[i]);
			 bt[i].setBackground(Color.BLUE);
		 }
		 reset.setFont(new Font("arial",0,20));
		 pa[2].add(reset);
		 reset.setEnabled(true);
	 }
	  class TicListener implements ActionListener
	  {

		@Override
		public void actionPerformed(ActionEvent evt) 
		{
			JButton bb=(JButton) evt.getSource();
			if(bb.getIcon()!=null)// when button will have image
			{
				JOptionPane.showMessageDialog(fr,"Wrong clicked");
				return;
			}
			if(Player==1)
			{
				bb.setIcon(icon1);
				msg.setText("Second Player turn..");
				pa[0].setBackground(Color.red);
				msg.setForeground(Color.white);
				Player=2;
			}
			else if(Player==2)
			{
				bb.setIcon(icon2);
				pa[0].setBackground(Color.BLUE);
				msg.setText("First Player turn..");
				msg.setForeground(Color.black);
				Player=1;
			}
			findWinner();
			count++;
			if(count==9 && !winnerFound)
			{
				reset.setEnabled(true);
				
				for(int i=0;i<=8;i++)
				{
					bt[i].setIcon(null);
					bt[i].setBackground(Color.blue);
					
				}
				msg.setText("Game Over");
				pa[0].setBackground(Color.green);
				JOptionPane.showMessageDialog(fr,"No one is winner");	
			}
	  }
	  public void findWinner()
	  {
		  //its for Horizentol
		    if(bt[0].getIcon()==icon1 && bt[1].getIcon()==icon1 && bt[2].getIcon()==icon1)
			  announceWinner(0,1,2,"First");
		    if(bt[0].getIcon()==icon2 && bt[1].getIcon()==icon2 && bt[2].getIcon()==icon2)
			  announceWinner(0,1,2,"Second");
		    if(bt[3].getIcon()==icon1 && bt[4].getIcon()==icon1 && bt[5].getIcon()==icon1)
			  announceWinner(3,4,5,"First");
		    if(bt[3].getIcon()==icon2 && bt[4].getIcon()==icon2 && bt[5].getIcon()==icon2)
			  announceWinner(3,4,5,"Second");
		    if(bt[6].getIcon()==icon1 && bt[7].getIcon()==icon1 && bt[8].getIcon()==icon1)
				announceWinner(6,7,8,"First");
			if(bt[6].getIcon()==icon2 && bt[7].getIcon()==icon2 && bt[8].getIcon()==icon2)
				announceWinner(6,7,8,"Second");
			//its for vertical
			if(bt[0].getIcon()==icon1 && bt[3].getIcon()==icon1 && bt[6].getIcon()==icon1)
				announceWinner(0,3,6,"First");
			if(bt[0].getIcon()==icon2 && bt[3].getIcon()==icon2 && bt[6].getIcon()==icon2)
				announceWinner(0,3,6,"Second");
			if(bt[1].getIcon()==icon1 && bt[4].getIcon()==icon1 && bt[7].getIcon()==icon1)
				announceWinner(1,4,7,"First");
			if(bt[1].getIcon()==icon2 && bt[4].getIcon()==icon2 && bt[7].getIcon()==icon2)
				announceWinner(1,4,7,"Second");
			if(bt[2].getIcon()==icon1 && bt[5].getIcon()==icon1 && bt[8].getIcon()==icon1)
				announceWinner(2,5,8,"First");
			if(bt[2].getIcon()==icon2 && bt[5].getIcon()==icon2 && bt[8].getIcon()==icon2)
				announceWinner(2,5,8,"Second");
              //its for Diagonal
			if(bt[0].getIcon()==icon1 && bt[4].getIcon()==icon1 && bt[8].getIcon()==icon1)
				announceWinner(0,4,8,"First");
			if(bt[0].getIcon()==icon2 && bt[4].getIcon()==icon2 && bt[8].getIcon()==icon2)
				announceWinner(0,4,8,"Second");
			if(bt[2].getIcon()==icon1 && bt[4].getIcon()==icon1 && bt[6].getIcon()==icon1)
				announceWinner(2,4,6,"First");
			if(bt[2].getIcon()==icon2 && bt[4].getIcon()==icon2 && bt[6].getIcon()==icon2)
				announceWinner(2,4,6,"Second");
        }
	  public void announceWinner(int i,int j,int k,String p)
	  {
		  bt[i].setBackground(Color.red);
		  bt[j].setBackground(Color.red);
		  bt[k].setBackground(Color.red);
		  winnerFound=true;
		  reset.setEnabled(true);
		  pa[0].setBackground(Color.GREEN);
		  msg.setText("Game Over");
		  JOptionPane.showMessageDialog(fr,p+" player won");
          reset.addActionListener(new ResetListener());
	  }
 }
	 class ResetListener implements ActionListener
	  {

		public void actionPerformed(ActionEvent evt)
		{
			for(int i=0;i<=8;i++)
			{
				bt[i].setIcon(null);
				bt[i].setBackground(Color.blue);
				
			}
			Player=1;
			winnerFound=false;
			msg.setText("First player turn...");
			msg.setForeground(Color.blue);
			pa[0].setBackground(Color.cyan);
			reset.setEnabled(false);
			
		}
	  } 
  public static void main(String[] args)
  {
	 new TicTacToe();
  }
}
