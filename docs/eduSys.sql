-- ��������
DROP TABLE IF EXISTS EMPLOYEES RESTRICT;

-- ���ǽ�
DROP TABLE IF EXISTS CROOMS RESTRICT;

-- ����
DROP TABLE IF EXISTS LECTURES RESTRICT;

-- �л�����
DROP TABLE IF EXISTS STUDENTS RESTRICT;

-- ������û����
DROP TABLE IF EXISTS REGEDITS RESTRICT;

-- �⼮�ΰ���
DROP TABLE IF EXISTS ATTENDANCES RESTRICT;

-- ����
DROP TABLE IF EXISTS BOOKS RESTRICT;

-- �ּ���������
DROP TABLE IF EXISTS ADDRS RESTRICT;

-- ��������
DROP TABLE IF EXISTS SUBJECTS RESTRICT;

-- ��������
DROP TABLE IF EXISTS HOMEWORKS RESTRICT;

-- ��������
DROP TABLE IF EXISTS EXAMS RESTRICT;

-- ����
DROP TABLE IF EXISTS TEACHERS RESTRICT;

-- �޴���
DROP TABLE IF EXISTS MANAGERS RESTRICT;

-- ������Ʈ
DROP TABLE IF EXISTS PROJECTS RESTRICT;

-- Ŀ��ŧ��
DROP TABLE IF EXISTS CURRICULUMS RESTRICT;

-- ������Ʈ��
DROP TABLE IF EXISTS PPTEAMS RESTRICT;

-- ��������
CREATE TABLE EMPLOYEES (
	E_NO    INTEGER      NOT NULL COMMENT '������ȣ', -- ������ȣ
	E_NAME  VARCHAR(50)  NOT NULL COMMENT '�̸�', -- �̸�
	E_TEL   VARCHAR(30)  NOT NULL COMMENT '��ȭ��ȣ', -- ��ȭ��ȣ
	E_EMAIL VARCHAR(40)  NOT NULL COMMENT '�̸���', -- �̸���
	E_ADDR2 VARCHAR(255) NOT NULL COMMENT '���ּ�', -- ���ּ�
	E_TASK  VARCHAR(50)  NOT NULL COMMENT '��å', -- ��å
	E_POS   VARCHAR(50)  NOT NULL DEFAULT ��� COMMENT '����', -- ����
	E_FAX   VARCHAR(30)  NULL     COMMENT '�ѽ�', -- �ѽ�
	E_IDATE DATE         NOT NULL COMMENT '�Ի���', -- �Ի���
	E_ODATE DATE         NULL     COMMENT '�����', -- �����
	E_PAY   INTEGER      NOT NULL DEFAULT 0 COMMENT '����', -- ����
	E_STATE VARCHAR(50)  NOT NULL DEFAULT ���� COMMENT '����', -- ����
	AD_NO   INTEGER      NOT NULL COMMENT '�ּҹ�ȣ' -- �ּҹ�ȣ
)
COMMENT '��������';

-- ��������
ALTER TABLE EMPLOYEES
	ADD CONSTRAINT PK_EMPLOYEES -- �������� �⺻Ű
		PRIMARY KEY (
			E_NO -- ������ȣ
		);

-- �������� ����ũ �ε���
CREATE UNIQUE INDEX UIX_EMPLOYEES
	ON EMPLOYEES ( -- ��������
		E_EMAIL ASC -- �̸���
	);

-- �������� �ε���
CREATE INDEX IX_EMPLOYEES
	ON EMPLOYEES( -- ��������
		E_NAME ASC -- �̸�
	);

ALTER TABLE EMPLOYEES
	MODIFY COLUMN E_NO INTEGER NOT NULL AUTO_INCREMENT COMMENT '������ȣ';

ALTER TABLE EMPLOYEES
	AUTO_INCREMENT = 1;

-- ���ǽ�
CREATE TABLE CROOMS (
	C_NO     INTEGER NOT NULL COMMENT '���ǽǹ�ȣ', -- ���ǽǹ�ȣ
	C_ROOMNO INTEGER NOT NULL COMMENT 'ȣ', -- ȣ
	C_MAX    INTEGER NOT NULL COMMENT '�����ο�' -- �����ο�
)
COMMENT '���ǽ�';

-- ���ǽ�
ALTER TABLE CROOMS
	ADD CONSTRAINT PK_CROOMS -- ���ǽ� �⺻Ű
		PRIMARY KEY (
			C_NO -- ���ǽǹ�ȣ
		);

-- ���ǽ� �ε���
CREATE INDEX IX_CROOMS
	ON CROOMS( -- ���ǽ�
		C_ROOMNO ASC -- ȣ
	);

ALTER TABLE CROOMS
	MODIFY COLUMN C_NO INTEGER NOT NULL AUTO_INCREMENT COMMENT '���ǽǹ�ȣ';

ALTER TABLE CROOMS
	AUTO_INCREMENT = 1;

-- ����
CREATE TABLE LECTURES (
	L_NO    INTEGER      NOT NULL COMMENT '���¹�ȣ', -- ���¹�ȣ
	L_TITLE VARCHAR(255) NOT NULL COMMENT '���¸�', -- ���¸�
	L_SDATE DATE         NOT NULL COMMENT '������', -- ������
	L_EDATE DATE         NOT NULL COMMENT '������', -- ������
	L_COST  INTEGER      NOT NULL DEFAULT 0 COMMENT '������', -- ������
	L_STIME TIME         NOT NULL COMMENT '���ǽ��۽ð�', -- ���ǽ��۽ð�
	L_ETIME TIME         NULL     COMMENT '��������ð�', -- ��������ð�
	C_NO2   INTEGER      NOT NULL COMMENT '����ŧ����ȣ', -- ����ŧ����ȣ
	E_NO    INTEGER      NOT NULL COMMENT '������ȣ', -- ������ȣ
	C_NO    INTEGER      NOT NULL COMMENT '���ǽǹ�ȣ' -- ���ǽǹ�ȣ
)
COMMENT '����';

-- ����
ALTER TABLE LECTURES
	ADD CONSTRAINT PK_LECTURES -- ���� �⺻Ű
		PRIMARY KEY (
			L_NO -- ���¹�ȣ
		);

-- ���� �ε���
CREATE INDEX IX_LECTURES
	ON LECTURES( -- ����
		L_TITLE ASC -- ���¸�
	);

ALTER TABLE LECTURES
	MODIFY COLUMN L_NO INTEGER NOT NULL AUTO_INCREMENT COMMENT '���¹�ȣ';

ALTER TABLE LECTURES
	AUTO_INCREMENT = 1;

-- �л�����
CREATE TABLE STUDENTS (
	S_NO    INTEGER      NOT NULL COMMENT '�л���ȣ', -- �л���ȣ
	S_NAME  VARCHAR(50)  NOT NULL COMMENT '�̸�', -- �̸�
	S_TEL   VARCHAR(30)  NOT NULL COMMENT '��ȭ��ȣ', -- ��ȭ��ȣ
	S_EMAIL VARCHAR(40)  NOT NULL COMMENT '�̸���', -- �̸���
	S_ADDR2 VARCHAR(255) NOT NULL COMMENT '���ּ�', -- ���ּ�
	A_ACCNO VARCHAR(50)  NULL     COMMENT '���¹�ȣ', -- ���¹�ȣ
	A_BIRTH DATE         NULL     COMMENT '�������', -- �������
	AD_NO   INTEGER      NOT NULL COMMENT '�ּҹ�ȣ' -- �ּҹ�ȣ
)
COMMENT '�л�����';

-- �л�����
ALTER TABLE STUDENTS
	ADD CONSTRAINT PK_STUDENTS -- �л����� �⺻Ű
		PRIMARY KEY (
			S_NO -- �л���ȣ
		);

-- �л����� ����ũ �ε���
CREATE UNIQUE INDEX UIX_STUDENTS
	ON STUDENTS ( -- �л�����
		S_EMAIL ASC -- �̸���
	);

-- �л����� �ε���
CREATE INDEX IX_STUDENTS
	ON STUDENTS( -- �л�����
		S_NAME ASC -- �̸�
	);

ALTER TABLE STUDENTS
	MODIFY COLUMN S_NO INTEGER NOT NULL AUTO_INCREMENT COMMENT '�л���ȣ';

-- ������û����
CREATE TABLE REGEDITS (
	R_NO     INTEGER     NOT NULL COMMENT '������û��ȣ', -- ������û��ȣ
	L_NO     INTEGER     NOT NULL COMMENT '���¹�ȣ', -- ���¹�ȣ
	S_NO     INTEGER     NOT NULL COMMENT '�л���ȣ', -- �л���ȣ
	R_STATE  VARCHAR(50) NULL     COMMENT '������û����', -- ������û����
	R_CSTATE VARCHAR(50) NOT NULL DEFAULT �̰��� COMMENT '��������' -- ��������
)
COMMENT '������û����';

-- ������û����
ALTER TABLE REGEDITS
	ADD CONSTRAINT PK_REGEDITS -- ������û���� �⺻Ű
		PRIMARY KEY (
			R_NO -- ������û��ȣ
		);

ALTER TABLE REGEDITS
	MODIFY COLUMN R_NO INTEGER NOT NULL AUTO_INCREMENT COMMENT '������û��ȣ';

-- �⼮�ΰ���
CREATE TABLE ATTENDANCES (
	AT_NO      INTEGER     NOT NULL COMMENT '�⼮�ι�ȣ', -- �⼮�ι�ȣ
	R_NO       INTEGER     NOT NULL COMMENT '������û��ȣ', -- ������û��ȣ
	AT_DATE    DATE        NOT NULL COMMENT '������', -- ������
	AT_ASTATE  VARCHAR(10) NOT NULL DEFAULT �Ἦ COMMENT '�⼮����', -- �⼮����
	AT_INTIME  TIME        NULL     COMMENT '����ð�', -- ����ð�
	AT_OUTTIME TIME        NULL     COMMENT '�Ͽ��ð�', -- �Ͽ��ð�
	AT_ETC     TEXT        NULL     COMMENT '���' -- ���
)
COMMENT '�⼮�ΰ���';

-- �⼮�ΰ���
ALTER TABLE ATTENDANCES
	ADD CONSTRAINT PK_ATTENDANCES -- �⼮�ΰ��� �⺻Ű
		PRIMARY KEY (
			AT_NO -- �⼮�ι�ȣ
		);

ALTER TABLE ATTENDANCES
	MODIFY COLUMN AT_NO INTEGER NOT NULL AUTO_INCREMENT COMMENT '�⼮�ι�ȣ';

ALTER TABLE ATTENDANCES
	AUTO_INCREMENT = 1;

-- ����
CREATE TABLE BOOKS (
	B_NO        INTEGER      NOT NULL COMMENT '������ȣ', -- ������ȣ
	B_TITLE     VARCHAR(255) NOT NULL COMMENT '������', -- ������
	B_PRICE     INTEGER      NULL     COMMENT '����', -- ����
	B_WRITER    VARCHAR(255) NOT NULL COMMENT '����', -- ����
	B_PUBLISHER VARCHAR(255) NULL     COMMENT '���ǻ�', -- ���ǻ�
	C_NO        INTEGER      NOT NULL COMMENT '����ŧ����ȣ' -- ����ŧ����ȣ
)
COMMENT '����';

-- ����
ALTER TABLE BOOKS
	ADD CONSTRAINT PK_BOOKS -- ���� �⺻Ű
		PRIMARY KEY (
			B_NO -- ������ȣ
		);

ALTER TABLE BOOKS
	MODIFY COLUMN B_NO INTEGER NOT NULL AUTO_INCREMENT COMMENT '������ȣ';

-- �ּ���������
CREATE TABLE ADDRS (
	AD_NO    INTEGER      NOT NULL COMMENT '�ּҹ�ȣ', -- �ּҹ�ȣ
	AD_POST  VARCHAR(10)  NOT NULL COMMENT '�����ȣ', -- �����ȣ
	AD_ADDR1 VARCHAR(255) NOT NULL COMMENT '�⺻�ּ�' -- �⺻�ּ�
)
COMMENT '�ּ���������';

-- �ּ���������
ALTER TABLE ADDRS
	ADD CONSTRAINT PK_ADDRS -- �ּ��������� �⺻Ű
		PRIMARY KEY (
			AD_NO -- �ּҹ�ȣ
		);

ALTER TABLE ADDRS
	MODIFY COLUMN AD_NO INTEGER NOT NULL AUTO_INCREMENT COMMENT '�ּҹ�ȣ';

ALTER TABLE ADDRS
	AUTO_INCREMENT = 1;

-- ��������
CREATE TABLE SUBJECTS (
	S_NO   INTEGER      NOT NULL COMMENT '�����ȣ', -- �����ȣ
	S_NAME VARCHAR(255) NOT NULL COMMENT '�����' -- �����
)
COMMENT '��������';

-- ��������
ALTER TABLE SUBJECTS
	ADD CONSTRAINT PK_SUBJECTS -- �������� �⺻Ű
		PRIMARY KEY (
			S_NO -- �����ȣ
		);

ALTER TABLE SUBJECTS
	MODIFY COLUMN S_NO INTEGER NOT NULL AUTO_INCREMENT COMMENT '�����ȣ';

ALTER TABLE SUBJECTS
	AUTO_INCREMENT = 1;

-- ��������
CREATE TABLE HOMEWORKS (
	H_NO   INTEGER    NOT NULL COMMENT '������ȣ', -- ������ȣ
	H_DATE DATE       NOT NULL COMMENT '����������', -- ����������
	H_YN   VARCHAR(1) NOT NULL DEFAULT N COMMENT '�������⿩��', -- �������⿩��
	R_NO   INTEGER    NOT NULL COMMENT '������û��ȣ' -- ������û��ȣ
)
COMMENT '��������';

-- ��������
ALTER TABLE HOMEWORKS
	ADD CONSTRAINT PK_HOMEWORKS -- �������� �⺻Ű
		PRIMARY KEY (
			H_NO -- ������ȣ
		);

ALTER TABLE HOMEWORKS
	MODIFY COLUMN H_NO INTEGER NOT NULL AUTO_INCREMENT COMMENT '������ȣ';

-- ��������
CREATE TABLE EXAMS (
	E_NO    INTEGER NOT NULL COMMENT '�����ȣ', -- �����ȣ
	E_DATE  DATE    NOT NULL COMMENT '��������', -- ��������
	E_SCORE INTEGER NOT NULL DEFAULT 0 COMMENT '���輺��', -- ���輺��
	R_NO    INTEGER NOT NULL COMMENT '������û��ȣ' -- ������û��ȣ
)
COMMENT '��������';

-- ��������
ALTER TABLE EXAMS
	ADD CONSTRAINT PK_EXAMS -- �������� �⺻Ű
		PRIMARY KEY (
			E_NO -- �����ȣ
		);

ALTER TABLE EXAMS
	MODIFY COLUMN E_NO INTEGER NOT NULL AUTO_INCREMENT COMMENT '�����ȣ';

ALTER TABLE EXAMS
	AUTO_INCREMENT = 1;

-- ����
CREATE TABLE TEACHERS (
	E_NO   INTEGER NOT NULL COMMENT '������ȣ', -- ������ȣ
	T_CURI TEXT    NULL     COMMENT '�����̷�' -- �����̷�
)
COMMENT '����';

-- ����
ALTER TABLE TEACHERS
	ADD CONSTRAINT PK_TEACHERS -- ���� �⺻Ű
		PRIMARY KEY (
			E_NO -- ������ȣ
		);

-- �޴���
CREATE TABLE MANAGERS (
	E_NO INTEGER NOT NULL COMMENT '������ȣ' -- ������ȣ
)
COMMENT '�޴���';

-- �޴���
ALTER TABLE MANAGERS
	ADD CONSTRAINT PK_MANAGERS -- �޴��� �⺻Ű
		PRIMARY KEY (
			E_NO -- ������ȣ
		);

-- ������Ʈ
CREATE TABLE PROJECTS (
	P_NO    INTEGER      NOT NULL COMMENT '������Ʈ��ȣ', -- ������Ʈ��ȣ
	P_NAME  VARCHAR(255) NOT NULL COMMENT '������Ʈ��', -- ������Ʈ��
	P_SDATE DATE         NOT NULL COMMENT '������Ʈ������', -- ������Ʈ������
	P_EDATE DATE         NOT NULL COMMENT '������Ʈ������', -- ������Ʈ������
	P_ETC   TEXT         NULL     COMMENT '������Ʈ���' -- ������Ʈ���
)
COMMENT '������Ʈ';

-- ������Ʈ
ALTER TABLE PROJECTS
	ADD CONSTRAINT PK_PROJECTS -- ������Ʈ �⺻Ű
		PRIMARY KEY (
			P_NO -- ������Ʈ��ȣ
		);

-- ������Ʈ �ε���
CREATE INDEX IX_PROJECTS
	ON PROJECTS( -- ������Ʈ
		P_NAME ASC -- ������Ʈ��
	);

ALTER TABLE PROJECTS
	MODIFY COLUMN P_NO INTEGER NOT NULL AUTO_INCREMENT COMMENT '������Ʈ��ȣ';

-- Ŀ��ŧ��
CREATE TABLE CURRICULUMS (
	C_NO    INTEGER NOT NULL COMMENT '����ŧ����ȣ', -- ����ŧ����ȣ
	C_SDATE DATE    NOT NULL COMMENT '���������', -- ���������
	C_EDATE DATE    NOT NULL COMMENT '����������', -- ����������
	S_NO    INTEGER NOT NULL COMMENT '�����ȣ', -- �����ȣ
	E_NO    INTEGER NOT NULL COMMENT '������ȣ' -- ������ȣ
)
COMMENT 'Ŀ��ŧ��';

-- Ŀ��ŧ��
ALTER TABLE CURRICULUMS
	ADD CONSTRAINT PK_CURRICULUMS -- Ŀ��ŧ�� �⺻Ű
		PRIMARY KEY (
			C_NO -- ����ŧ����ȣ
		);

ALTER TABLE CURRICULUMS
	MODIFY COLUMN C_NO INTEGER NOT NULL AUTO_INCREMENT COMMENT '����ŧ����ȣ';

-- ������Ʈ��
CREATE TABLE PPTEAMS (
	PP_NO INTEGER NOT NULL COMMENT '����ȣ', -- ����ȣ
	R_NO  INTEGER NOT NULL COMMENT '������û��ȣ', -- ������û��ȣ
	P_NO  INTEGER NOT NULL COMMENT '������Ʈ��ȣ' -- ������Ʈ��ȣ
)
COMMENT '������Ʈ��';

-- ������Ʈ��
ALTER TABLE PPTEAMS
	ADD CONSTRAINT PK_PPTEAMS -- ������Ʈ�� �⺻Ű
		PRIMARY KEY (
			PP_NO -- ����ȣ
		);

ALTER TABLE PPTEAMS
	MODIFY COLUMN PP_NO INTEGER NOT NULL AUTO_INCREMENT COMMENT '����ȣ';

ALTER TABLE PPTEAMS
	AUTO_INCREMENT = 1;

-- ��������
ALTER TABLE EMPLOYEES
	ADD CONSTRAINT FK_ADDRS_TO_EMPLOYEES -- �ּ��������� -> ��������
		FOREIGN KEY (
			AD_NO -- �ּҹ�ȣ
		)
		REFERENCES ADDRS ( -- �ּ���������
			AD_NO -- �ּҹ�ȣ
		);

-- ����
ALTER TABLE LECTURES
	ADD CONSTRAINT FK_CURRICULUMS_TO_LECTURES -- Ŀ��ŧ�� -> ����
		FOREIGN KEY (
			C_NO2 -- ����ŧ����ȣ
		)
		REFERENCES CURRICULUMS ( -- Ŀ��ŧ��
			C_NO -- ����ŧ����ȣ
		);

-- ����
ALTER TABLE LECTURES
	ADD CONSTRAINT FK_MANAGERS_TO_LECTURES -- �޴��� -> ����
		FOREIGN KEY (
			E_NO -- ������ȣ
		)
		REFERENCES MANAGERS ( -- �޴���
			E_NO -- ������ȣ
		);

-- ����
ALTER TABLE LECTURES
	ADD CONSTRAINT FK_CROOMS_TO_LECTURES -- ���ǽ� -> ����
		FOREIGN KEY (
			C_NO -- ���ǽǹ�ȣ
		)
		REFERENCES CROOMS ( -- ���ǽ�
			C_NO -- ���ǽǹ�ȣ
		);

-- �л�����
ALTER TABLE STUDENTS
	ADD CONSTRAINT FK_ADDRS_TO_STUDENTS -- �ּ��������� -> �л�����
		FOREIGN KEY (
			AD_NO -- �ּҹ�ȣ
		)
		REFERENCES ADDRS ( -- �ּ���������
			AD_NO -- �ּҹ�ȣ
		);

-- ������û����
ALTER TABLE REGEDITS
	ADD CONSTRAINT FK_LECTURES_TO_REGEDITS -- ���� -> ������û����
		FOREIGN KEY (
			L_NO -- ���¹�ȣ
		)
		REFERENCES LECTURES ( -- ����
			L_NO -- ���¹�ȣ
		);

-- ������û����
ALTER TABLE REGEDITS
	ADD CONSTRAINT FK_STUDENTS_TO_REGEDITS -- �л����� -> ������û����
		FOREIGN KEY (
			S_NO -- �л���ȣ
		)
		REFERENCES STUDENTS ( -- �л�����
			S_NO -- �л���ȣ
		);

-- �⼮�ΰ���
ALTER TABLE ATTENDANCES
	ADD CONSTRAINT FK_REGEDITS_TO_ATTENDANCES -- ������û���� -> �⼮�ΰ���
		FOREIGN KEY (
			R_NO -- ������û��ȣ
		)
		REFERENCES REGEDITS ( -- ������û����
			R_NO -- ������û��ȣ
		);

-- ����
ALTER TABLE BOOKS
	ADD CONSTRAINT FK_CURRICULUMS_TO_BOOKS -- Ŀ��ŧ�� -> ����
		FOREIGN KEY (
			C_NO -- ����ŧ����ȣ
		)
		REFERENCES CURRICULUMS ( -- Ŀ��ŧ��
			C_NO -- ����ŧ����ȣ
		);

-- ��������
ALTER TABLE HOMEWORKS
	ADD CONSTRAINT FK_REGEDITS_TO_HOMEWORKS -- ������û���� -> ��������
		FOREIGN KEY (
			R_NO -- ������û��ȣ
		)
		REFERENCES REGEDITS ( -- ������û����
			R_NO -- ������û��ȣ
		);

-- ��������
ALTER TABLE EXAMS
	ADD CONSTRAINT FK_REGEDITS_TO_EXAMS -- ������û���� -> ��������
		FOREIGN KEY (
			R_NO -- ������û��ȣ
		)
		REFERENCES REGEDITS ( -- ������û����
			R_NO -- ������û��ȣ
		);

-- ����
ALTER TABLE TEACHERS
	ADD CONSTRAINT FK_EMPLOYEES_TO_TEACHERS -- �������� -> ����
		FOREIGN KEY (
			E_NO -- ������ȣ
		)
		REFERENCES EMPLOYEES ( -- ��������
			E_NO -- ������ȣ
		);

-- �޴���
ALTER TABLE MANAGERS
	ADD CONSTRAINT FK_EMPLOYEES_TO_MANAGERS -- �������� -> �޴���
		FOREIGN KEY (
			E_NO -- ������ȣ
		)
		REFERENCES EMPLOYEES ( -- ��������
			E_NO -- ������ȣ
		);

-- Ŀ��ŧ��
ALTER TABLE CURRICULUMS
	ADD CONSTRAINT FK_SUBJECTS_TO_CURRICULUMS -- �������� -> Ŀ��ŧ��
		FOREIGN KEY (
			S_NO -- �����ȣ
		)
		REFERENCES SUBJECTS ( -- ��������
			S_NO -- �����ȣ
		);

-- Ŀ��ŧ��
ALTER TABLE CURRICULUMS
	ADD CONSTRAINT FK_TEACHERS_TO_CURRICULUMS -- ���� -> Ŀ��ŧ��
		FOREIGN KEY (
			E_NO -- ������ȣ
		)
		REFERENCES TEACHERS ( -- ����
			E_NO -- ������ȣ
		);

-- ������Ʈ��
ALTER TABLE PPTEAMS
	ADD CONSTRAINT FK_REGEDITS_TO_PPTEAMS -- ������û���� -> ������Ʈ��
		FOREIGN KEY (
			R_NO -- ������û��ȣ
		)
		REFERENCES REGEDITS ( -- ������û����
			R_NO -- ������û��ȣ
		);

-- ������Ʈ��
ALTER TABLE PPTEAMS
	ADD CONSTRAINT FK_PROJECTS_TO_PPTEAMS -- ������Ʈ -> ������Ʈ��
		FOREIGN KEY (
			P_NO -- ������Ʈ��ȣ
		)
		REFERENCES PROJECTS ( -- ������Ʈ
			P_NO -- ������Ʈ��ȣ
		);