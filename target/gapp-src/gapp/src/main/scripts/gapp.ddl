
    create table academicrecord (
        academicrecordid int4 not null,
        gpa numeric(19, 2),
        grescore numeric(19, 2),
        toeflscore numeric(19, 2),
        transcript bytea,
        studentid int4,
        primary key (academicrecordid)
    );

    create table application (
        applicationid int4 not null,
        term varchar(255),
        programid int4,
        statuses_statusid int4,
        applicantid int4,
        primary key (applicationid)
    );

    create table customdata (
        controlid int4 not null,
        fieldname varchar(255),
        fieldtype varchar(255),
        required boolean,
        applicationid int4,
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
        periodofdegree int4 not null,
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
        studentid int4,
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
        programid int4,
        userid int4,
        primary key (studentid)
    );

    create table users (
        userid int4 not null,
        active int2 not null,
        email varchar(255) not null,
        first_name varchar(255),
        last_name varchar(255),
        password varchar(255) not null,
        username varchar(50) not null,
        primary key (userid)
    );

    alter table users 
        add constraint UK_6dotkott2kjsp8vw4d0m25fb7 unique (email);

    alter table academicrecord 
        add constraint FK_ny3tginvk789dm509kbmyte2r 
        foreign key (studentid) 
        references students;

    alter table application 
        add constraint FK_b6t1yphsk54vx7q58bic4vjlw 
        foreign key (programid) 
        references program;

    alter table application 
        add constraint FK_99pp19hj2g68syy7ob628m4hm 
        foreign key (statuses_statusid) 
        references status;

    alter table application 
        add constraint FK_1ewhyt9dy7pnfov0fmfcvl5ds 
        foreign key (applicantid) 
        references students;

    alter table customdata 
        add constraint FK_lppd52cc1q5edcfrpuwth2t5e 
        foreign key (applicationid) 
        references application;

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
        add constraint FK_79t7w6ecnsx50f81kwc6grgsf 
        foreign key (studentid) 
        references students;

    alter table students 
        add constraint FK_jv7v2sbumycc2qgmkgd42w4ui 
        foreign key (programid) 
        references program;

    alter table students 
        add constraint FK_4skrtot375l19a0d14ckms00u 
        foreign key (userid) 
        references users;

    create sequence hibernate_sequence;
