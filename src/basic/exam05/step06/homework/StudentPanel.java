package basic.exam05.step06.homework;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

@SuppressWarnings("serial")
public class StudentPanel extends ContentPanel {
	StudentControl	controller	 = new StudentControl();

	List	         listView	     = new List() {
		                             public Dimension getPreferredSize() {
			                             return new Dimension(400, 400);
		                             };
	                             };

	Panel	         detailView	   = new Panel(new FlowLayout(FlowLayout.LEFT));
	TextField	     tfName	       = new TextField(10);
	TextField	     tfTeacher	   = new TextField(10);
	TextField	     tfStartDate	 = new TextField(20);
	TextField	     tfEndDate	   = new TextField(20);
	Choice	       room	         = new Choice();	                             // 강의실
	Choice	       adm	         = new Choice();	                             // 관리자
	Panel	         newButtonBar;
	Panel	         detailButtonBar;
	Button	       btnAdd	       = new Button("등록");
	Button	       btnUpdate	   = new Button("변경");
	Button	       btnDelete	   = new Button("삭제");
	Button	       btnCancel	   = new Button("취소");

	int	           selectedIndex	= -1;

	public StudentPanel() {
		super("숙 제");

		listView.setMultipleMode(false);
		listView.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				Student s = Student.fromCSV(listView.getItem(listView
				    .getSelectedIndex()));
				tfName.setText(s.name);
				tfTeacher.setText(s.teacher);
				tfStartDate.setText(s.startDate);
				tfEndDate.setText(s.endDate);
				
				room.select(s.room);
				adm.select(s.adm);

				newButtonBar.setVisible(false);
				detailButtonBar.setVisible(true);
				StudentPanel.this.validate();

				selectedIndex = listView.getSelectedIndex();
			}
		});
		content.add(listView);

		detailView.setPreferredSize(new Dimension(300, 400));

		Panel rowPane = new Panel(new FlowLayout(FlowLayout.LEFT));
		rowPane.setPreferredSize(new Dimension(290, 50));
		rowPane.add(createLabel("과목"));
		rowPane.add(tfName);
		detailView.add(rowPane);

		rowPane = createRowPane();
		rowPane.add(createLabel("강사"));
		rowPane.add(tfTeacher);
		detailView.add(rowPane);

		rowPane = createRowPane();
		rowPane.add(createLabel("시작일"));
		rowPane.add(tfStartDate);
		detailView.add(rowPane);

		rowPane = createRowPane();
		rowPane.add(createLabel("종료일"));
		rowPane.add(tfEndDate);
		detailView.add(rowPane);

		rowPane = createRowPane();
		rowPane.add(createLabel("교실 : "));
		room.add("3-1");
		room.add("3-2");
		room.add("3-3");
		room.add("4-1");
		room.add("4-2");
		room.add("4-3");
		rowPane.add(room);
		detailView.add(rowPane);

		rowPane = createRowPane();
		rowPane.add(createLabel("관리자 : "));
		adm.add("Park");
		adm.add("Kim");
		adm.add("Yoon");
		adm.add("Hong");
		adm.add("choi");
		rowPane.add(adm);
		detailView.add(rowPane);

		newButtonBar = createRowPane();
		newButtonBar.add(btnAdd);
		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Student s = new Student();
				s.name = tfName.getText();
				s.teacher = tfTeacher.getText();
				s.startDate = tfStartDate.getText();
				s.endDate = tfEndDate.getText();
				s.room = room.getSelectedItem();
				s.adm = adm.getSelectedItem();

				controller.add(s);
				listView.add(s.toString());
				clearForm();
			}
		});
		detailView.add(newButtonBar);

		detailButtonBar = createRowPane();
		detailButtonBar.setVisible(false);
		detailButtonBar.add(btnUpdate);
		detailButtonBar.add(btnDelete);
		detailButtonBar.add(btnCancel);

		btnUpdate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Student s = new Student();
				s.name = tfName.getText();
				s.teacher = tfTeacher.getText();
				s.startDate = tfStartDate.getText();
				s.endDate = tfEndDate.getText();

				s.room = room.getSelectedItem();
				s.adm = adm.getSelectedItem();
				
				controller.update(selectedIndex, s);
				listView.replaceItem(s.toString(), selectedIndex);
			}
		});
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				newButtonBar.setVisible(true);
				detailButtonBar.setVisible(false);
				listView.remove(selectedIndex);
				controller.remove(selectedIndex);
				clearForm();
			}
		});
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				newButtonBar.setVisible(true);
				detailButtonBar.setVisible(false);
				selectedIndex = -1;
				clearForm();
			}
		});
		detailView.add(detailButtonBar);

		content.add(detailView);

		controller.load();
		displayList();
	}

	private void clearForm() {
		tfName.setText("");
		tfTeacher.setText("");
		tfStartDate.setText("");
		tfEndDate.setText("");
		room.select(0);
		adm.select(0);
	}

	private void displayList() {
		for (Student student : controller.studentList) {
			listView.add(student.toString());
		}
	}

	private Panel createRowPane() {
		Panel rowPane = new Panel(new FlowLayout(FlowLayout.LEFT));
		rowPane.setPreferredSize(new Dimension(290, 50));
		return rowPane;
	}

	private Label createLabel(String title) {
		Label label = new Label(title);
		label.setPreferredSize(new Dimension(70, 30));
		return label;
	}

	public void save() {
		controller.save();
	}
}
