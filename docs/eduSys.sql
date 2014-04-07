-- 직원관리
DROP TABLE IF EXISTS EMPLOYEES RESTRICT;

-- 강의실
DROP TABLE IF EXISTS CROOMS RESTRICT;

-- 과정
DROP TABLE IF EXISTS LECTURES RESTRICT;

-- 학생관리
DROP TABLE IF EXISTS STUDENTS RESTRICT;

-- 수강신청관리
DROP TABLE IF EXISTS REGEDITS RESTRICT;

-- 출석부관리
DROP TABLE IF EXISTS ATTENDANCES RESTRICT;

-- 교제
DROP TABLE IF EXISTS BOOKS RESTRICT;

-- 주소정보관리
DROP TABLE IF EXISTS ADDRS RESTRICT;

-- 과목정보
DROP TABLE IF EXISTS SUBJECTS RESTRICT;

-- 숙제정보
DROP TABLE IF EXISTS HOMEWORKS RESTRICT;

-- 시험정보
DROP TABLE IF EXISTS EXAMS RESTRICT;

-- 강사
DROP TABLE IF EXISTS TEACHERS RESTRICT;

-- 메니저
DROP TABLE IF EXISTS MANAGERS RESTRICT;

-- 프로젝트
DROP TABLE IF EXISTS PROJECTS RESTRICT;

-- 커리큘럼
DROP TABLE IF EXISTS CURRICULUMS RESTRICT;

-- 프로젝트팀
DROP TABLE IF EXISTS PPTEAMS RESTRICT;

-- 직원관리
CREATE TABLE EMPLOYEES (
	E_NO    INTEGER      NOT NULL COMMENT '직원번호', -- 직원번호
	E_NAME  VARCHAR(50)  NOT NULL COMMENT '이름', -- 이름
	E_TEL   VARCHAR(30)  NOT NULL COMMENT '전화번호', -- 전화번호
	E_EMAIL VARCHAR(40)  NOT NULL COMMENT '이메일', -- 이메일
	E_ADDR2 VARCHAR(255) NOT NULL COMMENT '상세주소', -- 상세주소
	E_TASK  VARCHAR(50)  NOT NULL COMMENT '직책', -- 직책
	E_POS   VARCHAR(50)  NOT NULL DEFAULT '사원' COMMENT '직급', -- 직급
	E_FAX   VARCHAR(30)  NULL     COMMENT '팩스', -- 팩스
	E_IDATE DATE         NOT NULL COMMENT '입사일', -- 입사일
	E_ODATE DATE         NULL     COMMENT '퇴사일', -- 퇴사일
	E_PAY   INTEGER      NOT NULL DEFAULT 0 COMMENT '연봉', -- 연봉
	E_STATE VARCHAR(50)  NOT NULL DEFAULT '재직' COMMENT '상태', -- 상태
	AD_NO   INTEGER      NOT NULL COMMENT '주소번호' -- 주소번호
)
COMMENT '직원관리';

-- 직원관리
ALTER TABLE EMPLOYEES
	ADD CONSTRAINT PK_EMPLOYEES -- 직원관리 기본키
		PRIMARY KEY (
			E_NO -- 직원번호
		);

-- 직원관리 유니크 인덱스
CREATE UNIQUE INDEX UIX_EMPLOYEES
	ON EMPLOYEES ( -- 직원관리
		E_EMAIL ASC -- 이메일
	);

-- 직원관리 인덱스
CREATE INDEX IX_EMPLOYEES
	ON EMPLOYEES( -- 직원관리
		E_NAME ASC -- 이름
	);

ALTER TABLE EMPLOYEES
	MODIFY COLUMN E_NO INTEGER NOT NULL AUTO_INCREMENT COMMENT '직원번호';

ALTER TABLE EMPLOYEES
	AUTO_INCREMENT = 1;

-- 강의실
CREATE TABLE CROOMS (
	C_NO     INTEGER NOT NULL COMMENT '강의실번호', -- 강의실번호
	C_ROOMNO INTEGER NOT NULL COMMENT '호', -- 호
	C_MAX    INTEGER NOT NULL COMMENT '수용인원' -- 수용인원
)
COMMENT '강의실';

-- 강의실
ALTER TABLE CROOMS
	ADD CONSTRAINT PK_CROOMS -- 강의실 기본키
		PRIMARY KEY (
			C_NO -- 강의실번호
		);

-- 강의실 인덱스
CREATE INDEX IX_CROOMS
	ON CROOMS( -- 강의실
		C_ROOMNO ASC -- 호
	);

ALTER TABLE CROOMS
	MODIFY COLUMN C_NO INTEGER NOT NULL AUTO_INCREMENT COMMENT '강의실번호';

ALTER TABLE CROOMS
	AUTO_INCREMENT = 1;

-- 과정
CREATE TABLE LECTURES (
	L_NO    INTEGER      NOT NULL COMMENT '강좌번호', -- 강좌번호
	L_TITLE VARCHAR(255) NOT NULL COMMENT '강좌명', -- 강좌명
	L_SDATE DATE         NOT NULL COMMENT '시작일', -- 시작일
	L_EDATE DATE         NOT NULL COMMENT '종료일', -- 종료일
	L_COST  INTEGER      NOT NULL DEFAULT 0 COMMENT '수강료', -- 수강료
	L_STIME TIME         NOT NULL COMMENT '강의시작시간', -- 강의시작시간
	L_ETIME TIME         NULL     COMMENT '강의종료시간', -- 강의종료시간
	C_NO2   INTEGER      NOT NULL COMMENT '쿼리큘럼번호', -- 쿼리큘럼번호
	E_NO    INTEGER      NOT NULL COMMENT '직원번호', -- 직원번호
	C_NO    INTEGER      NOT NULL COMMENT '강의실번호' -- 강의실번호
)
COMMENT '과정';

-- 과정
ALTER TABLE LECTURES
	ADD CONSTRAINT PK_LECTURES -- 과정 기본키
		PRIMARY KEY (
			L_NO -- 강좌번호
		);

-- 과정 인덱스
CREATE INDEX IX_LECTURES
	ON LECTURES( -- 과정
		L_TITLE ASC -- 강좌명
	);

ALTER TABLE LECTURES
	MODIFY COLUMN L_NO INTEGER NOT NULL AUTO_INCREMENT COMMENT '강좌번호';

ALTER TABLE LECTURES
	AUTO_INCREMENT = 1;

-- 학생관리
CREATE TABLE STUDENTS (
	S_NO    INTEGER      NOT NULL COMMENT '학생번호', -- 학생번호
	S_NAME  VARCHAR(50)  NOT NULL COMMENT '이름', -- 이름
	S_TEL   VARCHAR(30)  NOT NULL COMMENT '전화번호', -- 전화번호
	S_EMAIL VARCHAR(40)  NOT NULL COMMENT '이메일', -- 이메일
	S_ADDR2 VARCHAR(255) NOT NULL COMMENT '상세주소', -- 상세주소
	A_ACCNO VARCHAR(50)  NULL     COMMENT '계좌번호', -- 계좌번호
	A_BIRTH DATE         NULL     COMMENT '생년월일', -- 생년월일
	AD_NO   INTEGER      NOT NULL COMMENT '주소번호' -- 주소번호
)
COMMENT '학생관리';

-- 학생관리
ALTER TABLE STUDENTS
	ADD CONSTRAINT PK_STUDENTS -- 학생관리 기본키
		PRIMARY KEY (
			S_NO -- 학생번호
		);

-- 학생관리 유니크 인덱스
CREATE UNIQUE INDEX UIX_STUDENTS
	ON STUDENTS ( -- 학생관리
		S_EMAIL ASC -- 이메일
	);

-- 학생관리 인덱스
CREATE INDEX IX_STUDENTS
	ON STUDENTS( -- 학생관리
		S_NAME ASC -- 이름
	);

ALTER TABLE STUDENTS
	MODIFY COLUMN S_NO INTEGER NOT NULL AUTO_INCREMENT COMMENT '학생번호';

-- 수강신청관리
CREATE TABLE REGEDITS (
	R_NO     INTEGER     NOT NULL COMMENT '수강신청번호', -- 수강신청번호
	L_NO     INTEGER     NOT NULL COMMENT '강좌번호', -- 강좌번호
	S_NO     INTEGER     NOT NULL COMMENT '학생번호', -- 학생번호
	R_STATE  VARCHAR(50) NULL     COMMENT '수강신청상태', -- 수강신청상태
	R_CSTATE VARCHAR(50) NOT NULL DEFAULT '미결재' COMMENT '결제상태' -- 결제상태
)
COMMENT '수강신청관리';

-- 수강신청관리
ALTER TABLE REGEDITS
	ADD CONSTRAINT PK_REGEDITS -- 수강신청관리 기본키
		PRIMARY KEY (
			R_NO -- 수강신청번호
		);

ALTER TABLE REGEDITS
	MODIFY COLUMN R_NO INTEGER NOT NULL AUTO_INCREMENT COMMENT '수강신청번호';

-- 출석부관리
CREATE TABLE ATTENDANCES (
	AT_NO      INTEGER     NOT NULL COMMENT '출석부번호', -- 출석부번호
	R_NO       INTEGER     NOT NULL COMMENT '수강신청번호', -- 수강신청번호
	AT_DATE    DATE        NOT NULL COMMENT '수강일', -- 수강일
	AT_ASTATE  VARCHAR(10) NOT NULL DEFAULT '결석' COMMENT '출석여부', -- 출석여부
	AT_INTIME  TIME        NULL     COMMENT '등원시간', -- 등원시간
	AT_OUTTIME TIME        NULL     COMMENT '하원시간', -- 하원시간
	AT_ETC     TEXT        NULL     COMMENT '비고' -- 비고
)
COMMENT '출석부관리';

-- 출석부관리
ALTER TABLE ATTENDANCES
	ADD CONSTRAINT PK_ATTENDANCES -- 출석부관리 기본키
		PRIMARY KEY (
			AT_NO -- 출석부번호
		);

ALTER TABLE ATTENDANCES
	MODIFY COLUMN AT_NO INTEGER NOT NULL AUTO_INCREMENT COMMENT '출석부번호';

ALTER TABLE ATTENDANCES
	AUTO_INCREMENT = 1;

-- 교제
CREATE TABLE BOOKS (
	B_NO        INTEGER      NOT NULL COMMENT '교제번호', -- 교제번호
	B_TITLE     VARCHAR(255) NOT NULL COMMENT '교제명', -- 교제명
	B_PRICE     INTEGER      NULL     COMMENT '가격', -- 가격
	B_WRITER    VARCHAR(255) NOT NULL COMMENT '저자', -- 저자
	B_PUBLISHER VARCHAR(255) NULL     COMMENT '출판사', -- 출판사
	C_NO        INTEGER      NOT NULL COMMENT '쿼리큘럼번호' -- 쿼리큘럼번호
)
COMMENT '교제';

-- 교제
ALTER TABLE BOOKS
	ADD CONSTRAINT PK_BOOKS -- 교제 기본키
		PRIMARY KEY (
			B_NO -- 교제번호
		);

ALTER TABLE BOOKS
	MODIFY COLUMN B_NO INTEGER NOT NULL AUTO_INCREMENT COMMENT '교제번호';

-- 주소정보관리
CREATE TABLE ADDRS (
	AD_NO    INTEGER      NOT NULL COMMENT '주소번호', -- 주소번호
	AD_POST  VARCHAR(10)  NOT NULL COMMENT '우편번호', -- 우편번호
	AD_ADDR1 VARCHAR(255) NOT NULL COMMENT '기본주소' -- 기본주소
)
COMMENT '주소정보관리';

-- 주소정보관리
ALTER TABLE ADDRS
	ADD CONSTRAINT PK_ADDRS -- 주소정보관리 기본키
		PRIMARY KEY (
			AD_NO -- 주소번호
		);

ALTER TABLE ADDRS
	MODIFY COLUMN AD_NO INTEGER NOT NULL AUTO_INCREMENT COMMENT '주소번호';

ALTER TABLE ADDRS
	AUTO_INCREMENT = 1;

-- 과목정보
CREATE TABLE SUBJECTS (
	S_NO   INTEGER      NOT NULL COMMENT '과목번호', -- 과목번호
	S_NAME VARCHAR(255) NOT NULL COMMENT '과목명' -- 과목명
)
COMMENT '과목정보';

-- 과목정보
ALTER TABLE SUBJECTS
	ADD CONSTRAINT PK_SUBJECTS -- 과목정보 기본키
		PRIMARY KEY (
			S_NO -- 과목번호
		);

ALTER TABLE SUBJECTS
	MODIFY COLUMN S_NO INTEGER NOT NULL AUTO_INCREMENT COMMENT '과목번호';

ALTER TABLE SUBJECTS
	AUTO_INCREMENT = 1;

-- 숙제정보
CREATE TABLE HOMEWORKS (
	H_NO   INTEGER    NOT NULL COMMENT '숙제번호', -- 숙제번호
	H_DATE DATE       NOT NULL COMMENT '숙제제출일', -- 숙제제출일
	H_YN   VARCHAR(1) NOT NULL DEFAULT 'N' COMMENT '숙제제출여부', -- 숙제제출여부
	R_NO   INTEGER    NOT NULL COMMENT '수강신청번호' -- 수강신청번호
)
COMMENT '숙제정보';

-- 숙제정보
ALTER TABLE HOMEWORKS
	ADD CONSTRAINT PK_HOMEWORKS -- 숙제정보 기본키
		PRIMARY KEY (
			H_NO -- 숙제번호
		);

ALTER TABLE HOMEWORKS
	MODIFY COLUMN H_NO INTEGER NOT NULL AUTO_INCREMENT COMMENT '숙제번호';

-- 시험정보
CREATE TABLE EXAMS (
	E_NO    INTEGER NOT NULL COMMENT '시험번호', -- 시험번호
	E_DATE  DATE    NOT NULL COMMENT '시험일자', -- 시험일자
	E_SCORE INTEGER NOT NULL DEFAULT 0 COMMENT '시험성적', -- 시험성적
	R_NO    INTEGER NOT NULL COMMENT '수강신청번호' -- 수강신청번호
)
COMMENT '시험정보';

-- 시험정보
ALTER TABLE EXAMS
	ADD CONSTRAINT PK_EXAMS -- 시험정보 기본키
		PRIMARY KEY (
			E_NO -- 시험번호
		);

ALTER TABLE EXAMS
	MODIFY COLUMN E_NO INTEGER NOT NULL AUTO_INCREMENT COMMENT '시험번호';

ALTER TABLE EXAMS
	AUTO_INCREMENT = 1;

-- 강사
CREATE TABLE TEACHERS (
	E_NO   INTEGER NOT NULL COMMENT '직원번호', -- 직원번호
	T_CURI TEXT    NULL     COMMENT '강사이력' -- 강사이력
)
COMMENT '강사';

-- 강사
ALTER TABLE TEACHERS
	ADD CONSTRAINT PK_TEACHERS -- 강사 기본키
		PRIMARY KEY (
			E_NO -- 직원번호
		);

-- 메니저
CREATE TABLE MANAGERS (
	E_NO INTEGER NOT NULL COMMENT '직원번호' -- 직원번호
)
COMMENT '메니저';

-- 메니저
ALTER TABLE MANAGERS
	ADD CONSTRAINT PK_MANAGERS -- 메니저 기본키
		PRIMARY KEY (
			E_NO -- 직원번호
		);

-- 프로젝트
CREATE TABLE PROJECTS (
	P_NO    INTEGER      NOT NULL COMMENT '프로젝트번호', -- 프로젝트번호
	P_NAME  VARCHAR(255) NOT NULL COMMENT '프로젝트명', -- 프로젝트명
	P_SDATE DATE         NOT NULL COMMENT '프로젝트시작일', -- 프로젝트시작일
	P_EDATE DATE         NOT NULL COMMENT '프로젝트종료일', -- 프로젝트종료일
	P_ETC   TEXT         NULL     COMMENT '프로젝트비고' -- 프로젝트비고
)
COMMENT '프로젝트';

-- 프로젝트
ALTER TABLE PROJECTS
	ADD CONSTRAINT PK_PROJECTS -- 프로젝트 기본키
		PRIMARY KEY (
			P_NO -- 프로젝트번호
		);

-- 프로젝트 인덱스
CREATE INDEX IX_PROJECTS
	ON PROJECTS( -- 프로젝트
		P_NAME ASC -- 프로젝트명
	);

ALTER TABLE PROJECTS
	MODIFY COLUMN P_NO INTEGER NOT NULL AUTO_INCREMENT COMMENT '프로젝트번호';

-- 커리큘럼
CREATE TABLE CURRICULUMS (
	C_NO    INTEGER NOT NULL COMMENT '쿼리큘럼번호', -- 쿼리큘럼번호
	C_SDATE DATE    NOT NULL COMMENT '과목시작일', -- 과목시작일
	C_EDATE DATE    NOT NULL COMMENT '과목종료일', -- 과목종료일
	S_NO    INTEGER NOT NULL COMMENT '과목번호', -- 과목번호
	E_NO    INTEGER NOT NULL COMMENT '직원번호' -- 직원번호
)
COMMENT '커리큘럼';

-- 커리큘럼
ALTER TABLE CURRICULUMS
	ADD CONSTRAINT PK_CURRICULUMS -- 커리큘럼 기본키
		PRIMARY KEY (
			C_NO -- 쿼리큘럼번호
		);

ALTER TABLE CURRICULUMS
	MODIFY COLUMN C_NO INTEGER NOT NULL AUTO_INCREMENT COMMENT '쿼리큘럼번호';

-- 프로젝트팀
CREATE TABLE PPTEAMS (
	PP_NO INTEGER NOT NULL COMMENT '팀번호', -- 팀번호
	R_NO  INTEGER NOT NULL COMMENT '수강신청번호', -- 수강신청번호
	P_NO  INTEGER NOT NULL COMMENT '프로젝트번호' -- 프로젝트번호
)
COMMENT '프로젝트팀';

-- 프로젝트팀
ALTER TABLE PPTEAMS
	ADD CONSTRAINT PK_PPTEAMS -- 프로젝트팀 기본키
		PRIMARY KEY (
			PP_NO -- 팀번호
		);

ALTER TABLE PPTEAMS
	MODIFY COLUMN PP_NO INTEGER NOT NULL AUTO_INCREMENT COMMENT '팀번호';

ALTER TABLE PPTEAMS
	AUTO_INCREMENT = 1;

-- 직원관리
ALTER TABLE EMPLOYEES
	ADD CONSTRAINT FK_ADDRS_TO_EMPLOYEES -- 주소정보관리 -> 직원관리
		FOREIGN KEY (
			AD_NO -- 주소번호
		)
		REFERENCES ADDRS ( -- 주소정보관리
			AD_NO -- 주소번호
		);

-- 과정
ALTER TABLE LECTURES
	ADD CONSTRAINT FK_CURRICULUMS_TO_LECTURES -- 커리큘럼 -> 과정
		FOREIGN KEY (
			C_NO2 -- 쿼리큘럼번호
		)
		REFERENCES CURRICULUMS ( -- 커리큘럼
			C_NO -- 쿼리큘럼번호
		);

-- 과정
ALTER TABLE LECTURES
	ADD CONSTRAINT FK_MANAGERS_TO_LECTURES -- 메니저 -> 과정
		FOREIGN KEY (
			E_NO -- 직원번호
		)
		REFERENCES MANAGERS ( -- 메니저
			E_NO -- 직원번호
		);

-- 과정
ALTER TABLE LECTURES
	ADD CONSTRAINT FK_CROOMS_TO_LECTURES -- 강의실 -> 과정
		FOREIGN KEY (
			C_NO -- 강의실번호
		)
		REFERENCES CROOMS ( -- 강의실
			C_NO -- 강의실번호
		);

-- 학생관리
ALTER TABLE STUDENTS
	ADD CONSTRAINT FK_ADDRS_TO_STUDENTS -- 주소정보관리 -> 학생관리
		FOREIGN KEY (
			AD_NO -- 주소번호
		)
		REFERENCES ADDRS ( -- 주소정보관리
			AD_NO -- 주소번호
		);

-- 수강신청관리
ALTER TABLE REGEDITS
	ADD CONSTRAINT FK_LECTURES_TO_REGEDITS -- 과정 -> 수강신청관리
		FOREIGN KEY (
			L_NO -- 강좌번호
		)
		REFERENCES LECTURES ( -- 과정
			L_NO -- 강좌번호
		);

-- 수강신청관리
ALTER TABLE REGEDITS
	ADD CONSTRAINT FK_STUDENTS_TO_REGEDITS -- 학생관리 -> 수강신청관리
		FOREIGN KEY (
			S_NO -- 학생번호
		)
		REFERENCES STUDENTS ( -- 학생관리
			S_NO -- 학생번호
		);

-- 출석부관리
ALTER TABLE ATTENDANCES
	ADD CONSTRAINT FK_REGEDITS_TO_ATTENDANCES -- 수강신청관리 -> 출석부관리
		FOREIGN KEY (
			R_NO -- 수강신청번호
		)
		REFERENCES REGEDITS ( -- 수강신청관리
			R_NO -- 수강신청번호
		);

-- 교제
ALTER TABLE BOOKS
	ADD CONSTRAINT FK_CURRICULUMS_TO_BOOKS -- 커리큘럼 -> 교제
		FOREIGN KEY (
			C_NO -- 쿼리큘럼번호
		)
		REFERENCES CURRICULUMS ( -- 커리큘럼
			C_NO -- 쿼리큘럼번호
		);

-- 숙제정보
ALTER TABLE HOMEWORKS
	ADD CONSTRAINT FK_REGEDITS_TO_HOMEWORKS -- 수강신청관리 -> 숙제정보
		FOREIGN KEY (
			R_NO -- 수강신청번호
		)
		REFERENCES REGEDITS ( -- 수강신청관리
			R_NO -- 수강신청번호
		);

-- 시험정보
ALTER TABLE EXAMS
	ADD CONSTRAINT FK_REGEDITS_TO_EXAMS -- 수강신청관리 -> 시험정보
		FOREIGN KEY (
			R_NO -- 수강신청번호
		)
		REFERENCES REGEDITS ( -- 수강신청관리
			R_NO -- 수강신청번호
		);

-- 강사
ALTER TABLE TEACHERS
	ADD CONSTRAINT FK_EMPLOYEES_TO_TEACHERS -- 직원관리 -> 강사
		FOREIGN KEY (
			E_NO -- 직원번호
		)
		REFERENCES EMPLOYEES ( -- 직원관리
			E_NO -- 직원번호
		);

-- 메니저
ALTER TABLE MANAGERS
	ADD CONSTRAINT FK_EMPLOYEES_TO_MANAGERS -- 직원관리 -> 메니저
		FOREIGN KEY (
			E_NO -- 직원번호
		)
		REFERENCES EMPLOYEES ( -- 직원관리
			E_NO -- 직원번호
		);

-- 커리큘럼
ALTER TABLE CURRICULUMS
	ADD CONSTRAINT FK_SUBJECTS_TO_CURRICULUMS -- 과목정보 -> 커리큘럼
		FOREIGN KEY (
			S_NO -- 과목번호
		)
		REFERENCES SUBJECTS ( -- 과목정보
			S_NO -- 과목번호
		);

-- 커리큘럼
ALTER TABLE CURRICULUMS
	ADD CONSTRAINT FK_TEACHERS_TO_CURRICULUMS -- 강사 -> 커리큘럼
		FOREIGN KEY (
			E_NO -- 직원번호
		)
		REFERENCES TEACHERS ( -- 강사
			E_NO -- 직원번호
		);

-- 프로젝트팀
ALTER TABLE PPTEAMS
	ADD CONSTRAINT FK_REGEDITS_TO_PPTEAMS -- 수강신청관리 -> 프로젝트팀
		FOREIGN KEY (
			R_NO -- 수강신청번호
		)
		REFERENCES REGEDITS ( -- 수강신청관리
			R_NO -- 수강신청번호
		);

-- 프로젝트팀
ALTER TABLE PPTEAMS
	ADD CONSTRAINT FK_PROJECTS_TO_PPTEAMS -- 프로젝트 -> 프로젝트팀
		FOREIGN KEY (
			P_NO -- 프로젝트번호
		)
		REFERENCES PROJECTS ( -- 프로젝트
			P_NO -- 프로젝트번호
		);