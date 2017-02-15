create sequence hibernate_sequence minvalue 100;
   
    create table academicrecord (
        academicrecordid int4 not null,
        filename varchar(255),
        gpa float8 not null,
        grescore float8 not null,
        toeflscore float8 not null,
        studentid int4,
        primary key (academicrecordid)
    );

    create table application (
        applicationid int4 not null,
        term varchar(255),
        applicant_userid int4,
        departmentid int4,
        programid int4,
        applicantid int4,
        primary key (applicationid)
    );

    create table customdata (
        controlid int4 not null,
        fieldname varchar(255),
        fieldtype varchar(255),
        required boolean,
        applicationid int4,
        departmentId int4,
        programid int4,
        primary key (controlid)
    );

    create table customvalue (
        valueid int4 not null,
        value varchar(255),
        applicationid int4,
        controlid int4,
        studentid int4,
        primary key (valueid)
    );

    create table department (
        departmentid int4 not null,
        departmentname varchar(255),
        primary key (departmentid)
    );

    create table educationalinfo (
        educationalid int4 not null,
        collegeuniversity varchar(255),
        degreename varchar(255),
        majorfield varchar(255),
        periodofdegree varchar(255),
        studentid int4,
        primary key (educationalid)
    );

    create table program (
        programid int4 not null,
        programname varchar(255),
        departmentid int4,
        primary key (programid)
    );

    create table rolevalues (
        user_id int4 not null,
        role_name varchar(255)
    );

    create table status (
        statusid int4 not null,
        comment varchar(255),
        status varchar(255),
        timestamp timestamp,
        application_applicationid int4,
        userid int4,
        primary key (statusid)
    );

    create table students (
        studentid int4 not null,
        cin int8 not null,
        citizenship varchar(255),
        dob timestamp,
        email varchar(255),
        firstname varchar(255),
        gender varchar(255),
        lastname varchar(255),
        phoneno varchar(255),
        academicrecord_academicrecordid int4,
        userid int4,
        primary key (studentid)
    );

    create table users (
        userid int4 not null,
        active boolean not null,
        email varchar(255) not null,
        first_name varchar(255),
        last_name varchar(255),
        password varchar(255) not null,
        primary key (userid)
    );

    alter table users 
        add constraint UK_6dotkott2kjsp8vw4d0m25fb7 unique (email);

    alter table academicrecord 
        add constraint FK_ny3tginvk789dm509kbmyte2r 
        foreign key (studentid) 
        references students;

    alter table application 
        add constraint FK_fohm7bg0jm6sk27vghb8blqcx 
        foreign key (applicant_userid) 
        references users;

    alter table application 
        add constraint FK_kfu6u847dqldpkjep0ti7q95q 
        foreign key (departmentid) 
        references department;

    alter table application 
        add constraint FK_b6t1yphsk54vx7q58bic4vjlw 
        foreign key (programid) 
        references program;

    alter table application 
        add constraint FK_1ewhyt9dy7pnfov0fmfcvl5ds 
        foreign key (applicantid) 
        references students;

    alter table customdata 
        add constraint FK_lppd52cc1q5edcfrpuwth2t5e 
        foreign key (applicationid) 
        references application;

    alter table customdata 
        add constraint FK_5amfp2n9ts98sioa8ywuvsot7 
        foreign key (departmentId) 
        references department;

    alter table customdata 
        add constraint FK_qrkpuoshj5werfo3onkyb2i3f 
        foreign key (programid) 
        references program;

    alter table customvalue 
        add constraint FK_fnm090duwfmc9baib00oa4bec 
        foreign key (applicationid) 
        references application;

    alter table customvalue 
        add constraint FK_gvotrftqgwpc2fgxci386js1b 
        foreign key (controlid) 
        references customdata;

    alter table customvalue 
        add constraint FK_akvnq5rq7y5fh5gj69dypwovd 
        foreign key (studentid) 
        references students;

    alter table educationalinfo 
        add constraint FK_2unh2w0xofrpuv5ffb0cuu8mo 
        foreign key (studentid) 
        references students;

    alter table program 
        add constraint FK_277hliqln8kn92tu3ddkb8y7y 
        foreign key (departmentid) 
        references department;

    alter table rolevalues 
        add constraint FK_taqy852e3bno22hbu68icofvy 
        foreign key (user_id) 
        references users;

    alter table status 
        add constraint FK_ivks2wrbf2nu8xadpjeu6i0b0 
        foreign key (application_applicationid) 
        references application;

    alter table status 
        add constraint FK_tbdy4wkoi8med054l580m8sg5 
        foreign key (userid) 
        references users;

    alter table students 
        add constraint FK_px3qmhkhof13xvp0eabch00ii 
        foreign key (academicrecord_academicrecordid) 
        references academicrecord;

    alter table students 
        add constraint FK_4skrtot375l19a0d14ckms00u 
        foreign key (userid) 
        references users;

    


    
    

    


    

   
   
    


    


    
    
    
    insert into users(userid,active,email,first_name,last_name,password) values(1, 'true', 'admin@localhost.localdomain', 'John', 'Doe', 'abcd');
    insert into users(userid,active,email,first_name,last_name,password) values(2, 'true', 'staff1@localhost.localdomain', 'Tom', 'Cruise', 'abcd');
    insert into users(userid,active,email,first_name,last_name,password) values(3, 'true', 'staff2@localhost.localdomain', 'Rohan', 'Patel', 'abcd');
    insert into users(userid,active,email,first_name,last_name,password) values(4, 'true', 'student1@localhost.localdomain', 'Virat', 'Kohli', 'abcd');
    insert into users(userid,active,email,first_name,last_name,password) values(5, 'true', 'student2@localhost.localdomain', 'Mary', 'Lee', 'abcd');
    
    insert into rolevalues(user_id,role_name) values(1, 'ROLE_ADMIN');
    insert into rolevalues(user_id,role_name) values(2, 'ROLE_STAFF');
    insert into rolevalues(user_id,role_name) values(3, 'ROLE_STAFF');
    
	insert into department(departmentid,departmentname) values(2,'Accounting');
	insert into department(departmentid,departmentname) values(3,'Computer-Science');
	
	insert into program(programid,programname,departmentid) values(1,'MS in Accounting',2);
	insert into program(programid,programname,departmentid) values(2,'MS in ComputerScience',3);
	insert into program(programid,programname,departmentid) values(3,'MS in Software Engineering',3);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	