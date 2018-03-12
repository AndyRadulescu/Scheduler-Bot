DROP TABLE IF EXISTS users CASCADE;
DROP TABLE IF EXISTS subscriber CASCADE;

CREATE TABLE "users"(
    id BIGSERIAL PRIMARY KEY,
    enabled BOOLEAN NOT NULL,
    username varchar(255) NOT NULL,
    password varchar(255) NOT NULL,
    CONSTRAINT constraint_username UNIQUE (id)
);

CREATE TABLE "subscriber"
(
  id bigint NOT NULL,
  name character varying(255) NOT NULL,
  CONSTRAINT subscriber_pkey PRIMARY KEY (id)
);

INSERT INTO public.users(enabled,password,username) VALUES(true,'$2a$04$qc5Ac12RpORlPExHrsZ7/erb8JCNMj14ZzVwj9QhWSEy0yHsegpO.','user1');
INSERT INTO public.users(enabled,password,username) VALUES(true,'$2a$10$fVhy0kyq4yBAT0Jjjdavc.4z2Fq.rVuGLM2lrc9hWlqe9LIbVEpFe','user2');
INSERT INTO public.users(enabled,password,username) VALUES(true,'$2a$10$gA15AS4mW7ugtkAN8URSGulfoDUatgQmUdUabpoe3O4QGrHRcsYE.','user3');
INSERT INTO public.users(enabled,password,username) VALUES(true,'$2a$10$VQ0fLCwagxwz7v.G3lMSG.2TR/qWLuL7lpj1rJZJDjiskHngZqne.','user4');