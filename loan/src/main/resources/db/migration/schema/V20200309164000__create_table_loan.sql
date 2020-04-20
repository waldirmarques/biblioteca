CREATE TABLE loan (
	id int8 NOT NULL GENERATED BY DEFAULT AS IDENTITY,
	loan_time varchar(255) NOT NULL,
	user_app VARCHAR (1000) NOT NULL,
	book VARCHAR (1000),

  CONSTRAINT loan_pkey PRIMARY KEY (id)
);
