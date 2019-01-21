-- INSTITUTIONS
INSERT INTO institution (institution.institutionCity,institution.institutionName,institution.institutionStamp,institution.institutionSales) VALUES ("Lisboa","Faculdade de Belas Artes","FBA",0);
INSERT INTO institution (institution.institutionCity,institution.institutionName,institution.institutionStamp,institution.institutionSales) VALUES ("Lisboa","Faculdade de Letras","FL",0);
INSERT INTO institution (institution.institutionCity,institution.institutionName,institution.institutionStamp,institution.institutionSales) VALUES ("Lisboa","Faculdade de Direito","FD",0);
INSERT INTO institution (institution.institutionCity,institution.institutionName,institution.institutionStamp,institution.institutionSales) VALUES ("Lisboa","Faculdade de Psicologia","FP",0);
INSERT INTO institution (institution.institutionCity,institution.institutionName,institution.institutionStamp,institution.institutionSales) VALUES ("Lisboa","Instituto Politecnico Lisboa","IPL",0);
INSERT INTO institution (institution.institutionCity,institution.institutionName,institution.institutionStamp,institution.institutionSales) VALUES ("Lisboa","Instituto Universitário de Lisboa","ISCTE",0);
INSERT INTO institution (institution.institutionCity,institution.institutionName,institution.institutionStamp,institution.institutionSales) VALUES ("Lisboa","Universidade Nova","UN",0);
INSERT INTO institution (institution.institutionCity,institution.institutionName,institution.institutionStamp,institution.institutionSales) VALUES ("Lisboa","Faculdade de Aeronautica","FA",0);
INSERT INTO institution (institution.institutionCity,institution.institutionName,institution.institutionStamp,institution.institutionSales) VALUES ("Lisboa","Instituto de Engenharia Maritima","IEM",0);
INSERT INTO institution (institution.institutionCity,institution.institutionName,institution.institutionStamp,institution.institutionSales) VALUES ("Lisboa","Instituto Metalurgico de Lisboa","IMFL",0);
--

-- COURSES
INSERT INTO course (course.courseName,course.courseDescription) Values ("Arte Contemporanea","preparar os formandos para o estudo das artes contemporaneas");
INSERT INTO institution_course (institution_course.course_id,institution_course.institution_id) values (1,1);
INSERT INTO course (course.courseName,course.courseDescription) Values ("Cultura Classica","preparar os formandos para o estudo das culturas classicas");
INSERT INTO institution_course (institution_course.course_id,institution_course.institution_id) values (2,2);
INSERT INTO course (course.courseName,course.courseDescription) Values ("Lei Nacional","formar profissionais nas praticas da lei");
INSERT INTO institution_course (institution_course.course_id,institution_course.institution_id) values (3,3);
INSERT INTO course (course.courseName,course.courseDescription) Values ("Psicologia","estudar a mente");
INSERT INTO institution_course (institution_course.course_id,institution_course.institution_id) values (4,4);
INSERT INTO course (course.courseName,course.courseDescription) Values ("A Lei da tribuna","as leis do tribunal");
INSERT INTO institution_course (institution_course.course_id,institution_course.institution_id) values (5,5);
INSERT INTO course (course.courseName,course.courseDescription) Values ("Engenharia Informatica","futuro em TI");
INSERT INTO institution_course (institution_course.course_id,institution_course.institution_id) values (6,6);
INSERT INTO course (course.courseName,course.courseDescription) Values ("Tecnicos de Hardware","futuro em tecnico TI");
INSERT INTO institution_course (institution_course.course_id,institution_course.institution_id) values (7,7);
INSERT INTO course (course.courseName,course.courseDescription) Values ("Pilotagem","preparar os proximos pilotos");
INSERT INTO institution_course (institution_course.course_id,institution_course.institution_id) values (8,8);
INSERT INTO course (course.courseName,course.courseDescription) Values ("Manuntenção maritima","preparar os proximos engenheiros mecanicos maritimos");
INSERT INTO institution_course (institution_course.course_id,institution_course.institution_id) values (9,9);
INSERT INTO course (course.courseName,course.courseDescription) Values ("Metalurgia Fabril","preparar os ferreiros");
INSERT INTO institution_course (institution_course.course_id,institution_course.institution_id) values (10,10);

--

-- DISCIPLINES
INSERT INTO discipline (discipline.disciplineName) values ("Arte de Portugal Moderno");
INSERT INTO course_discipline (course_discipline.course_id,discipline_id) VALUES (1,1);
INSERT INTO discipline (discipline.disciplineName) values ("Categorias da Arte");
INSERT INTO course_discipline (course_discipline.course_id,discipline_id) VALUES (1,1);
INSERT INTO discipline (discipline.disciplineName) values ("Pintura Moderna I");
INSERT INTO course_discipline (course_discipline.course_id,discipline_id) VALUES (1,1);
INSERT INTO discipline (discipline.disciplineName) values ("Civilizações antigas");
INSERT INTO course_discipline (course_discipline.course_id,discipline_id) VALUES (2,2);
INSERT INTO discipline (discipline.disciplineName) values ("Tecnicas de guerra classicas");
INSERT INTO course_discipline (course_discipline.course_id,discipline_id) VALUES (2,2);
INSERT INTO discipline (discipline.disciplineName) values ("Costumes antigos");
INSERT INTO course_discipline (course_discipline.course_id,discipline_id) VALUES (2,2);
INSERT INTO discipline (discipline.disciplineName) values ("The Bar I");
INSERT INTO course_discipline (course_discipline.course_id,discipline_id) VALUES (3,3);
INSERT INTO discipline (discipline.disciplineName) values ("Lei e Ordem");
INSERT INTO course_discipline (course_discipline.course_id,discipline_id) VALUES (3,3);
INSERT INTO discipline (discipline.disciplineName) values ("Defesa judicial");
INSERT INTO course_discipline (course_discipline.course_id,discipline_id) VALUES (3,3);
INSERT INTO discipline (discipline.disciplineName) values ("A mente humana");
INSERT INTO course_discipline (course_discipline.course_id,discipline_id) VALUES (4,4);
INSERT INTO discipline (discipline.disciplineName) values ("Neurociencia");
INSERT INTO course_discipline (course_discipline.course_id,discipline_id) VALUES (4,4);
INSERT INTO discipline (discipline.disciplineName) values ("Doenças psicologicas");
INSERT INTO course_discipline (course_discipline.course_id,discipline_id) VALUES (4,4);
INSERT INTO discipline (discipline.disciplineName) values ("Fundamentos da Lei");
INSERT INTO course_discipline (course_discipline.course_id,discipline_id) VALUES (5,5);
INSERT INTO discipline (discipline.disciplineName) values ("Ganhar o caso");
INSERT INTO course_discipline (course_discipline.course_id,discipline_id) VALUES (5,5);
INSERT INTO discipline (discipline.disciplineName) values ("Grandes debates");
INSERT INTO course_discipline (course_discipline.course_id,discipline_id) VALUES (5,5);
INSERT INTO discipline (discipline.disciplineName) values ("Algoritmia I");
INSERT INTO course_discipline (course_discipline.course_id,discipline_id) VALUES (6,6);
INSERT INTO discipline (discipline.disciplineName) values ("Padroes de desenho");
INSERT INTO course_discipline (course_discipline.course_id,discipline_id) VALUES (6,6);
INSERT INTO discipline (discipline.disciplineName) values ("Java");
INSERT INTO course_discipline (course_discipline.course_id,discipline_id) VALUES (6,6);
INSERT INTO discipline (discipline.disciplineName) values ("Componentes");
INSERT INTO course_discipline (course_discipline.course_id,discipline_id) VALUES (7,7);
INSERT INTO discipline (discipline.disciplineName) values ("Aplicação eletrónica");
INSERT INTO course_discipline (course_discipline.course_id,discipline_id) VALUES (7,7);
INSERT INTO discipline (discipline.disciplineName) values ("A arquitetura de sistemas");
INSERT INTO course_discipline (course_discipline.course_id,discipline_id) VALUES (7,7);
INSERT INTO discipline (discipline.disciplineName) values ("O mitico teste G");
INSERT INTO course_discipline (course_discipline.course_id,discipline_id) VALUES (8,8);
INSERT INTO discipline (discipline.disciplineName) values ("Aeronautica I");
INSERT INTO course_discipline (course_discipline.course_id,discipline_id) VALUES (8,8);
INSERT INTO discipline (discipline.disciplineName) values ("Aeronautica II");
INSERT INTO course_discipline (course_discipline.course_id,discipline_id) VALUES (8,8);
INSERT INTO discipline (discipline.disciplineName) values ("Veiculos submergiveis I");
INSERT INTO course_discipline (course_discipline.course_id,discipline_id) VALUES (9,9);
INSERT INTO discipline (discipline.disciplineName) values ("A lei do mar");
INSERT INTO course_discipline (course_discipline.course_id,discipline_id) VALUES (9,9);
INSERT INTO discipline (discipline.disciplineName) values ("Natação");
INSERT INTO course_discipline (course_discipline.course_id,discipline_id) VALUES (9,9);
INSERT INTO discipline (discipline.disciplineName) values ("Reconhecimento de minerio");
INSERT INTO course_discipline (course_discipline.course_id,discipline_id) VALUES (10,10);
INSERT INTO discipline (discipline.disciplineName) values ("Metalurgia I");
INSERT INTO course_discipline (course_discipline.course_id,discipline_id) VALUES (10,10);
INSERT INTO discipline (discipline.disciplineName) values ("Fundamentos da metalurgia");
INSERT INTO course_discipline (course_discipline.course_id,discipline_id) VALUES (10,10);
--


-- PROFESSORS
INSERT INTO professor (professorFName,professorLName) values ("Joao","Pinha");
INSERT INTO professor_course (professor_id,course_id) values (1,1);
INSERT INTO professor_discipline (professor_id,discipline_id) values (1,1);
INSERT INTO professor_institution (professor_id,institution_id) values (1,1);
INSERT INTO professor (professorFName,professorLName) values ("Nuno","Simoes");
INSERT INTO professor_course (professor_id,course_id) values (2,2);
INSERT INTO professor_discipline (professor_id,discipline_id) values (2,2);
INSERT INTO professor_institution (professor_id,institution_id) values (2,2);
INSERT INTO professor (professorFName,professorLName) values ("Andre","Resende");
INSERT INTO professor_course (professor_id,course_id) values (3,3);
INSERT INTO professor_discipline (professor_id,discipline_id) values (3,3);
INSERT INTO professor_institution (professor_id,institution_id) values (3,3);
INSERT INTO professor (professorFName,professorLName) values ("Tomas","Buffon");
INSERT INTO professor_course (professor_id,course_id) values (4,4);
INSERT INTO professor_discipline (professor_id,discipline_id) values (4,4);
INSERT INTO professor_institution (professor_id,institution_id) values (4,4);
INSERT INTO professor (professorFName,professorLName) values ("Henrique","Soares");
INSERT INTO professor_course (professor_id,course_id) values (5,5);
INSERT INTO professor_discipline (professor_id,discipline_id) values (5,5);
INSERT INTO professor_institution (professor_id,institution_id) values (5,5);
INSERT INTO professor (professorFName,professorLName) values ("Pedro","Taveira");
INSERT INTO professor_course (professor_id,course_id) values (6,6);
INSERT INTO professor_discipline (professor_id,discipline_id) values (6,6);
INSERT INTO professor_institution (professor_id,institution_id) values (6,6);
INSERT INTO professor (professorFName,professorLName) values ("Diogo","Sousa");
INSERT INTO professor_course (professor_id,course_id) values (7,7);
INSERT INTO professor_discipline (professor_id,discipline_id) values (7,7);
INSERT INTO professor_institution (professor_id,institution_id) values (7,7);
INSERT INTO professor (professorFName,professorLName) values ("Rui","Simao");
INSERT INTO professor_course (professor_id,course_id) values (8,8);
INSERT INTO professor_discipline (professor_id,discipline_id) values (8,8);
INSERT INTO professor_institution (professor_id,institution_id) values (8,8);
INSERT INTO professor (professorFName,professorLName) values ("Joao","Figueiredo");
INSERT INTO professor_course (professor_id,course_id) values (9,9);
INSERT INTO professor_discipline (professor_id,discipline_id) values (9,9);
INSERT INTO professor_institution (professor_id,institution_id) values (9,9);
INSERT INTO professor (professorFName,professorLName) values ("Antonio","Variacoes");
INSERT INTO professor_course (professor_id,course_id) values (10,10);
INSERT INTO professor_discipline (professor_id,discipline_id) values (10,10);
INSERT INTO professor_institution (professor_id,institution_id) values (10,10);
--

-- STUDENTS
INSERT INTO student (studentFName,studentLName,studentEmail,tuitionCode) values ("Diogo","Sousa","diogo12246@gmail.com","264ce5f5-185e-4048-9147-9368143caf95");
INSERT INTO student_institution (student_id,institution_id) values (1,1);
INSERT INTO tuition (tuitionCode,tuitionValue,tuitionPaid) values ("264ce5f5-185e-4048-9147-9368143caf95",1500,0);
--
