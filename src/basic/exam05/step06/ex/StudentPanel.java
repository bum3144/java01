package basic.exam05.step06.ex;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextField;

@SuppressWarnings("serial")
public class StudentPanel extends ContentPanel{
	StudentControl controller = new StudentControl();

	List listView = new List(){
		public Dimension getPreferredSize(){
			return new Dimension(300, 400);
			
		};
	};

	Panel detailView  = new Panel(new FlowLayout(FlowLayout.LEFT));
	TextField tfName = new TextField(10);
	TextField tfAge = new TextField(3);
	TextField tfTel = new TextField(15);
	TextField tfEmail = new TextField(20);
	TextField tfAddr = new TextField(20);
	Panel newButtonBar;
	Panel datailButtonBar;
	Button btnAdd = new Button("등록");
	Button btnUpdate = new Button("변경");
	Button btnDelete = new Button("삭제");
	Button btnCancel = new Button("취소");
	
	int selectIndex = -1;
	

	public StudentPanel(){
		
	}
	private void clearForm(){
		
	}
	private void displayList(){
		
	}
	private Panel createRowPane(){
		
	}
	private Label createLabel(){
		
	}
}
