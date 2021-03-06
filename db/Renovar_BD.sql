PGDMP                         y            renovar-em-cristo    13.2    13.2 ?    ?           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            ?           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            ?           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            ?           1262    16394    renovar-em-cristo    DATABASE     s   CREATE DATABASE "renovar-em-cristo" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Portuguese_Brazil.1252';
 #   DROP DATABASE "renovar-em-cristo";
                postgres    false            ?            1259    24666 
   church_seq    SEQUENCE     ?   CREATE SEQUENCE public.church_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 !   DROP SEQUENCE public.church_seq;
       public          postgres    false            ?            1259    24668    church    TABLE     y  CREATE TABLE public.church (
    id integer DEFAULT nextval('public.church_seq'::regclass) NOT NULL,
    name character varying(300) NOT NULL,
    cnpj character varying(14) NOT NULL,
    email character varying(100),
    phone character varying(30) NOT NULL,
    pastor_name character varying(100),
    address character varying(300) NOT NULL,
    city_id integer NOT NULL
);
    DROP TABLE public.church;
       public         heap    postgres    false    202            ?            1259    24690    church_relationship_seq    SEQUENCE     ?   CREATE SEQUENCE public.church_relationship_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 .   DROP SEQUENCE public.church_relationship_seq;
       public          postgres    false            ?            1259    24692    church_relationship    TABLE     ?   CREATE TABLE public.church_relationship (
    id integer DEFAULT nextval('public.church_relationship_seq'::regclass) NOT NULL,
    church_master_id integer NOT NULL,
    church_id integer NOT NULL,
    relationship_type_id integer NOT NULL
);
 '   DROP TABLE public.church_relationship;
       public         heap    postgres    false    206            ?            1259    24682    church_relationship_type_seq    SEQUENCE     ?   CREATE SEQUENCE public.church_relationship_type_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 3   DROP SEQUENCE public.church_relationship_type_seq;
       public          postgres    false            ?            1259    24684    church_relationship_type    TABLE     ?   CREATE TABLE public.church_relationship_type (
    id integer DEFAULT nextval('public.church_relationship_type_seq'::regclass) NOT NULL,
    description character varying(50) NOT NULL
);
 ,   DROP TABLE public.church_relationship_type;
       public         heap    postgres    false    204            ?            1259    16418    city    TABLE        CREATE TABLE public.city (
    id integer NOT NULL,
    name character varying(500) NOT NULL,
    state_id integer NOT NULL
);
    DROP TABLE public.city;
       public         heap    postgres    false            ?            1259    41275    city_district_seq    SEQUENCE     ?   CREATE SEQUENCE public.city_district_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 (   DROP SEQUENCE public.city_district_seq;
       public          postgres    false            ?            1259    41277    city_district    TABLE     ?   CREATE TABLE public.city_district (
    id integer DEFAULT nextval('public.city_district_seq'::regclass) NOT NULL,
    name character varying(200) NOT NULL,
    city_id integer NOT NULL
);
 !   DROP TABLE public.city_district;
       public         heap    postgres    false    235            ?            1259    41299    city_districts    TABLE     l   CREATE TABLE public.city_districts (
    city_model_id bigint NOT NULL,
    districts_id bigint NOT NULL
);
 "   DROP TABLE public.city_districts;
       public         heap    postgres    false            ?            1259    24740    network_seq    SEQUENCE     ?   CREATE SEQUENCE public.network_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 "   DROP SEQUENCE public.network_seq;
       public          postgres    false            ?            1259    24747    network    TABLE     ?   CREATE TABLE public.network (
    id integer DEFAULT nextval('public.network_seq'::regclass) NOT NULL,
    name character varying(300) NOT NULL,
    leader_id integer NOT NULL,
    active integer DEFAULT 1 NOT NULL
);
    DROP TABLE public.network;
       public         heap    postgres    false    212            ?            1259    24711 
   person_seq    SEQUENCE     ?   CREATE SEQUENCE public.person_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 !   DROP SEQUENCE public.person_seq;
       public          postgres    false            ?            1259    24713    person    TABLE     ?  CREATE TABLE public.person (
    id integer DEFAULT nextval('public.person_seq'::regclass) NOT NULL,
    name character varying(300) NOT NULL,
    email character varying(300) NOT NULL,
    birthday date NOT NULL,
    phone character varying(30) NOT NULL,
    city_id integer NOT NULL,
    address character varying(300),
    church_id integer,
    person_type_id integer NOT NULL,
    active integer DEFAULT 1 NOT NULL,
    district_id integer
);
    DROP TABLE public.person;
       public         heap    postgres    false    210            ?            1259    24703    person_type_seq    SEQUENCE     ?   CREATE SEQUENCE public.person_type_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.person_type_seq;
       public          postgres    false            ?            1259    24705    person_type    TABLE     ?   CREATE TABLE public.person_type (
    id integer DEFAULT nextval('public.person_type_seq'::regclass) NOT NULL,
    description character varying(100) NOT NULL
);
    DROP TABLE public.person_type;
       public         heap    postgres    false    208            ?            1259    24745    pg_seq    SEQUENCE     ~   CREATE SEQUENCE public.pg_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
    DROP SEQUENCE public.pg_seq;
       public          postgres    false            ?            1259    24759    pg    TABLE     W  CREATE TABLE public.pg (
    id integer DEFAULT nextval('public.pg_seq'::regclass) NOT NULL,
    name character varying(300) NOT NULL,
    network_id integer NOT NULL,
    church_id integer NOT NULL,
    city_id integer NOT NULL,
    active integer DEFAULT 1 NOT NULL,
    pg_type_id integer NOT NULL,
    configuration_id integer NOT NULL
);
    DROP TABLE public.pg;
       public         heap    postgres    false    213            ?            1259    33063    pg_auth_seq    SEQUENCE     ?   CREATE SEQUENCE public.pg_auth_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 "   DROP SEQUENCE public.pg_auth_seq;
       public          postgres    false            ?            1259    33065    pg_auth    TABLE     ?   CREATE TABLE public.pg_auth (
    id integer DEFAULT nextval('public.pg_auth_seq'::regclass) NOT NULL,
    login character varying(100) NOT NULL,
    password character varying(100) NOT NULL,
    pg_id integer NOT NULL
);
    DROP TABLE public.pg_auth;
       public         heap    postgres    false    233            ?            1259    24822    pg_configuration_seq    SEQUENCE     ?   CREATE SEQUENCE public.pg_configuration_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.pg_configuration_seq;
       public          postgres    false            ?            1259    33048    pg_configuration    TABLE     ?   CREATE TABLE public.pg_configuration (
    id integer DEFAULT nextval('public.pg_configuration_seq'::regclass) NOT NULL,
    day_of_week integer NOT NULL,
    address character varying(300),
    image_id character varying(300),
    district_id integer
);
 $   DROP TABLE public.pg_configuration;
       public         heap    postgres    false    220            ?            1259    24801 	   pg_member    TABLE     ?   CREATE TABLE public.pg_member (
    id integer NOT NULL,
    pg_id integer NOT NULL,
    person_id integer NOT NULL,
    member_type_id integer NOT NULL,
    registered_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP NOT NULL
);
    DROP TABLE public.pg_member;
       public         heap    postgres    false            ?            1259    24796    pg_member_seq    SEQUENCE     ?   CREATE SEQUENCE public.pg_member_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 $   DROP SEQUENCE public.pg_member_seq;
       public          postgres    false            ?            1259    24783    pg_member_type_seq    SEQUENCE     ?   CREATE SEQUENCE public.pg_member_type_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.pg_member_type_seq;
       public          postgres    false            ?            1259    24790    pg_member_type    TABLE     ?   CREATE TABLE public.pg_member_type (
    id integer DEFAULT nextval('public.pg_member_type_seq'::regclass) NOT NULL,
    description character varying(100)
);
 "   DROP TABLE public.pg_member_type;
       public         heap    postgres    false    216            ?            1259    24856    pg_report_seq    SEQUENCE     ?   CREATE SEQUENCE public.pg_report_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 $   DROP SEQUENCE public.pg_report_seq;
       public          postgres    false            ?            1259    24858 	   pg_report    TABLE     ?   CREATE TABLE public.pg_report (
    id integer DEFAULT nextval('public.pg_report_seq'::regclass) NOT NULL,
    pg_id integer NOT NULL,
    date date NOT NULL
);
    DROP TABLE public.pg_report;
       public         heap    postgres    false    221            ?            1259    24872 #   pg_report_absence_justification_seq    SEQUENCE     ?   CREATE SEQUENCE public.pg_report_absence_justification_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 :   DROP SEQUENCE public.pg_report_absence_justification_seq;
       public          postgres    false            ?            1259    24874    pg_report_absence_justification    TABLE        CREATE TABLE public.pg_report_absence_justification (
    id integer DEFAULT nextval('public.pg_report_absence_justification_seq'::regclass) NOT NULL,
    description character varying(300) NOT NULL,
    require_justification integer DEFAULT 0 NOT NULL
);
 3   DROP TABLE public.pg_report_absence_justification;
       public         heap    postgres    false    225            ?            1259    24880    pg_report_data_seq    SEQUENCE     ?   CREATE SEQUENCE public.pg_report_data_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.pg_report_data_seq;
       public          postgres    false            ?            1259    24883    pg_report_data    TABLE     *  CREATE TABLE public.pg_report_data (
    id integer DEFAULT nextval('public.pg_report_data_seq'::regclass) NOT NULL,
    report_id integer NOT NULL,
    situation_id integer NOT NULL,
    absence_justification_id integer,
    justification character varying(300),
    member_id integer NOT NULL
);
 "   DROP TABLE public.pg_report_data;
       public         heap    postgres    false    227            ?            1259    24864    pg_report_member_situation_seq    SEQUENCE     ?   CREATE SEQUENCE public.pg_report_member_situation_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 5   DROP SEQUENCE public.pg_report_member_situation_seq;
       public          postgres    false            ?            1259    24866    pg_report_member_situation    TABLE     ?   CREATE TABLE public.pg_report_member_situation (
    id integer DEFAULT nextval('public.pg_report_member_situation_seq'::regclass) NOT NULL,
    description character varying(100) NOT NULL
);
 .   DROP TABLE public.pg_report_member_situation;
       public         heap    postgres    false    223            ?            1259    24904    pg_type_seq    SEQUENCE     ?   CREATE SEQUENCE public.pg_type_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 "   DROP SEQUENCE public.pg_type_seq;
       public          postgres    false            ?            1259    24906    pg_type    TABLE     ?   CREATE TABLE public.pg_type (
    id integer DEFAULT nextval('public.pg_type_seq'::regclass) NOT NULL,
    description character varying(100) NOT NULL
);
    DROP TABLE public.pg_type;
       public         heap    postgres    false    229            ?            1259    24912    pg_type_def    TABLE     ?   CREATE TABLE public.pg_type_def (
    id integer DEFAULT nextval('public.pg_type_seq'::regclass) NOT NULL,
    description character varying(100) NOT NULL
);
    DROP TABLE public.pg_type_def;
       public         heap    postgres    false    229            ?            1259    16395    state    TABLE     ?   CREATE TABLE public.state (
    id integer NOT NULL,
    name character varying(300) NOT NULL,
    uf character varying(2) NOT NULL
);
    DROP TABLE public.state;
       public         heap    postgres    false            z          0    24668    church 
   TABLE DATA           ]   COPY public.church (id, name, cnpj, email, phone, pastor_name, address, city_id) FROM stdin;
    public          postgres    false    203   ?       ~          0    24692    church_relationship 
   TABLE DATA           d   COPY public.church_relationship (id, church_master_id, church_id, relationship_type_id) FROM stdin;
    public          postgres    false    207   ??       |          0    24684    church_relationship_type 
   TABLE DATA           C   COPY public.church_relationship_type (id, description) FROM stdin;
    public          postgres    false    205   ?       x          0    16418    city 
   TABLE DATA           2   COPY public.city (id, name, state_id) FROM stdin;
    public          postgres    false    201   <?       ?          0    41277    city_district 
   TABLE DATA           :   COPY public.city_district (id, name, city_id) FROM stdin;
    public          postgres    false    236   ??       ?          0    41299    city_districts 
   TABLE DATA           E   COPY public.city_districts (city_model_id, districts_id) FROM stdin;
    public          postgres    false    237   ??       ?          0    24747    network 
   TABLE DATA           >   COPY public.network (id, name, leader_id, active) FROM stdin;
    public          postgres    false    214   Σ       ?          0    24713    person 
   TABLE DATA           ?   COPY public.person (id, name, email, birthday, phone, city_id, address, church_id, person_type_id, active, district_id) FROM stdin;
    public          postgres    false    211   ?       ?          0    24705    person_type 
   TABLE DATA           6   COPY public.person_type (id, description) FROM stdin;
    public          postgres    false    209   O?       ?          0    24759    pg 
   TABLE DATA           l   COPY public.pg (id, name, network_id, church_id, city_id, active, pg_type_id, configuration_id) FROM stdin;
    public          postgres    false    215   ??       ?          0    33065    pg_auth 
   TABLE DATA           =   COPY public.pg_auth (id, login, password, pg_id) FROM stdin;
    public          postgres    false    234   ??       ?          0    33048    pg_configuration 
   TABLE DATA           [   COPY public.pg_configuration (id, day_of_week, address, image_id, district_id) FROM stdin;
    public          postgres    false    232   ??       ?          0    24801 	   pg_member 
   TABLE DATA           X   COPY public.pg_member (id, pg_id, person_id, member_type_id, registered_at) FROM stdin;
    public          postgres    false    219   ??       ?          0    24790    pg_member_type 
   TABLE DATA           9   COPY public.pg_member_type (id, description) FROM stdin;
    public          postgres    false    217   ??       ?          0    24858 	   pg_report 
   TABLE DATA           4   COPY public.pg_report (id, pg_id, date) FROM stdin;
    public          postgres    false    222   ??       ?          0    24874    pg_report_absence_justification 
   TABLE DATA           a   COPY public.pg_report_absence_justification (id, description, require_justification) FROM stdin;
    public          postgres    false    226   ??       ?          0    24883    pg_report_data 
   TABLE DATA           y   COPY public.pg_report_data (id, report_id, situation_id, absence_justification_id, justification, member_id) FROM stdin;
    public          postgres    false    228   ?       ?          0    24866    pg_report_member_situation 
   TABLE DATA           E   COPY public.pg_report_member_situation (id, description) FROM stdin;
    public          postgres    false    224   /?       ?          0    24906    pg_type 
   TABLE DATA           2   COPY public.pg_type (id, description) FROM stdin;
    public          postgres    false    230   y?       ?          0    24912    pg_type_def 
   TABLE DATA           6   COPY public.pg_type_def (id, description) FROM stdin;
    public          postgres    false    231   ??       w          0    16395    state 
   TABLE DATA           -   COPY public.state (id, name, uf) FROM stdin;
    public          postgres    false    200   Ϩ       ?           0    0    church_relationship_seq    SEQUENCE SET     E   SELECT pg_catalog.setval('public.church_relationship_seq', 1, true);
          public          postgres    false    206            ?           0    0    church_relationship_type_seq    SEQUENCE SET     J   SELECT pg_catalog.setval('public.church_relationship_type_seq', 1, true);
          public          postgres    false    204            ?           0    0 
   church_seq    SEQUENCE SET     8   SELECT pg_catalog.setval('public.church_seq', 2, true);
          public          postgres    false    202            ?           0    0    city_district_seq    SEQUENCE SET     @   SELECT pg_catalog.setval('public.city_district_seq', 49, true);
          public          postgres    false    235            ?           0    0    network_seq    SEQUENCE SET     9   SELECT pg_catalog.setval('public.network_seq', 4, true);
          public          postgres    false    212            ?           0    0 
   person_seq    SEQUENCE SET     8   SELECT pg_catalog.setval('public.person_seq', 5, true);
          public          postgres    false    210            ?           0    0    person_type_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.person_type_seq', 4, true);
          public          postgres    false    208            ?           0    0    pg_auth_seq    SEQUENCE SET     9   SELECT pg_catalog.setval('public.pg_auth_seq', 2, true);
          public          postgres    false    233            ?           0    0    pg_configuration_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('public.pg_configuration_seq', 2, true);
          public          postgres    false    220            ?           0    0    pg_member_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.pg_member_seq', 12, true);
          public          postgres    false    218            ?           0    0    pg_member_type_seq    SEQUENCE SET     @   SELECT pg_catalog.setval('public.pg_member_type_seq', 9, true);
          public          postgres    false    216            ?           0    0 #   pg_report_absence_justification_seq    SEQUENCE SET     Q   SELECT pg_catalog.setval('public.pg_report_absence_justification_seq', 6, true);
          public          postgres    false    225            ?           0    0    pg_report_data_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('public.pg_report_data_seq', 56, true);
          public          postgres    false    227            ?           0    0    pg_report_member_situation_seq    SEQUENCE SET     L   SELECT pg_catalog.setval('public.pg_report_member_situation_seq', 4, true);
          public          postgres    false    223            ?           0    0    pg_report_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.pg_report_seq', 14, true);
          public          postgres    false    221            ?           0    0    pg_seq    SEQUENCE SET     4   SELECT pg_catalog.setval('public.pg_seq', 2, true);
          public          postgres    false    213            ?           0    0    pg_type_seq    SEQUENCE SET     9   SELECT pg_catalog.setval('public.pg_type_seq', 2, true);
          public          postgres    false    229            ?           2606    24676    church church_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.church
    ADD CONSTRAINT church_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.church DROP CONSTRAINT church_pkey;
       public            postgres    false    203            ?           2606    24697 ,   church_relationship church_relationship_pkey 
   CONSTRAINT     j   ALTER TABLE ONLY public.church_relationship
    ADD CONSTRAINT church_relationship_pkey PRIMARY KEY (id);
 V   ALTER TABLE ONLY public.church_relationship DROP CONSTRAINT church_relationship_pkey;
       public            postgres    false    207            ?           2606    24689 6   church_relationship_type church_relationship_type_pkey 
   CONSTRAINT     t   ALTER TABLE ONLY public.church_relationship_type
    ADD CONSTRAINT church_relationship_type_pkey PRIMARY KEY (id);
 `   ALTER TABLE ONLY public.church_relationship_type DROP CONSTRAINT church_relationship_type_pkey;
       public            postgres    false    205            ?           2606    41282     city_district city_district_pkey 
   CONSTRAINT     ^   ALTER TABLE ONLY public.city_district
    ADD CONSTRAINT city_district_pkey PRIMARY KEY (id);
 J   ALTER TABLE ONLY public.city_district DROP CONSTRAINT city_district_pkey;
       public            postgres    false    236            ?           2606    16425    city city_pkey 
   CONSTRAINT     L   ALTER TABLE ONLY public.city
    ADD CONSTRAINT city_pkey PRIMARY KEY (id);
 8   ALTER TABLE ONLY public.city DROP CONSTRAINT city_pkey;
       public            postgres    false    201            ?           2606    24753    network network_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.network
    ADD CONSTRAINT network_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.network DROP CONSTRAINT network_pkey;
       public            postgres    false    214            ?           2606    24722    person person_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.person
    ADD CONSTRAINT person_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.person DROP CONSTRAINT person_pkey;
       public            postgres    false    211            ?           2606    24710    person_type person_type_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.person_type
    ADD CONSTRAINT person_type_pkey PRIMARY KEY (id);
 F   ALTER TABLE ONLY public.person_type DROP CONSTRAINT person_type_pkey;
       public            postgres    false    209            ?           2606    33070    pg_auth pg_auth_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.pg_auth
    ADD CONSTRAINT pg_auth_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.pg_auth DROP CONSTRAINT pg_auth_pkey;
       public            postgres    false    234            ?           2606    33056 &   pg_configuration pg_configuration_pkey 
   CONSTRAINT     d   ALTER TABLE ONLY public.pg_configuration
    ADD CONSTRAINT pg_configuration_pkey PRIMARY KEY (id);
 P   ALTER TABLE ONLY public.pg_configuration DROP CONSTRAINT pg_configuration_pkey;
       public            postgres    false    232            ?           2606    24806    pg_member pg_member_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.pg_member
    ADD CONSTRAINT pg_member_pkey PRIMARY KEY (id);
 B   ALTER TABLE ONLY public.pg_member DROP CONSTRAINT pg_member_pkey;
       public            postgres    false    219            ?           2606    24795 "   pg_member_type pg_member_type_pkey 
   CONSTRAINT     `   ALTER TABLE ONLY public.pg_member_type
    ADD CONSTRAINT pg_member_type_pkey PRIMARY KEY (id);
 L   ALTER TABLE ONLY public.pg_member_type DROP CONSTRAINT pg_member_type_pkey;
       public            postgres    false    217            ?           2606    24765 
   pg pg_pkey 
   CONSTRAINT     H   ALTER TABLE ONLY public.pg
    ADD CONSTRAINT pg_pkey PRIMARY KEY (id);
 4   ALTER TABLE ONLY public.pg DROP CONSTRAINT pg_pkey;
       public            postgres    false    215            ?           2606    24879 D   pg_report_absence_justification pg_report_absence_justification_pkey 
   CONSTRAINT     ?   ALTER TABLE ONLY public.pg_report_absence_justification
    ADD CONSTRAINT pg_report_absence_justification_pkey PRIMARY KEY (id);
 n   ALTER TABLE ONLY public.pg_report_absence_justification DROP CONSTRAINT pg_report_absence_justification_pkey;
       public            postgres    false    226            ?           2606    24888 "   pg_report_data pg_report_data_pkey 
   CONSTRAINT     `   ALTER TABLE ONLY public.pg_report_data
    ADD CONSTRAINT pg_report_data_pkey PRIMARY KEY (id);
 L   ALTER TABLE ONLY public.pg_report_data DROP CONSTRAINT pg_report_data_pkey;
       public            postgres    false    228            ?           2606    24871 :   pg_report_member_situation pg_report_member_situation_pkey 
   CONSTRAINT     x   ALTER TABLE ONLY public.pg_report_member_situation
    ADD CONSTRAINT pg_report_member_situation_pkey PRIMARY KEY (id);
 d   ALTER TABLE ONLY public.pg_report_member_situation DROP CONSTRAINT pg_report_member_situation_pkey;
       public            postgres    false    224            ?           2606    24863    pg_report pg_report_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.pg_report
    ADD CONSTRAINT pg_report_pkey PRIMARY KEY (id);
 B   ALTER TABLE ONLY public.pg_report DROP CONSTRAINT pg_report_pkey;
       public            postgres    false    222            ?           2606    24917    pg_type_def pg_type_def_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.pg_type_def
    ADD CONSTRAINT pg_type_def_pkey PRIMARY KEY (id);
 F   ALTER TABLE ONLY public.pg_type_def DROP CONSTRAINT pg_type_def_pkey;
       public            postgres    false    231            ?           2606    24911    pg_type pg_type_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.pg_type
    ADD CONSTRAINT pg_type_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.pg_type DROP CONSTRAINT pg_type_pkey;
       public            postgres    false    230            ?           2606    16399    state state_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.state
    ADD CONSTRAINT state_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.state DROP CONSTRAINT state_pkey;
       public            postgres    false    200            ?           2606    41303 +   city_districts uk_459oio2lbfu67bl2btm669mk4 
   CONSTRAINT     n   ALTER TABLE ONLY public.city_districts
    ADD CONSTRAINT uk_459oio2lbfu67bl2btm669mk4 UNIQUE (districts_id);
 U   ALTER TABLE ONLY public.city_districts DROP CONSTRAINT uk_459oio2lbfu67bl2btm669mk4;
       public            postgres    false    237            ?           2606    24724    person uq_email 
   CONSTRAINT     K   ALTER TABLE ONLY public.person
    ADD CONSTRAINT uq_email UNIQUE (email);
 9   ALTER TABLE ONLY public.person DROP CONSTRAINT uq_email;
       public            postgres    false    211            ?           2606    24767 
   pg uq_name 
   CONSTRAINT     E   ALTER TABLE ONLY public.pg
    ADD CONSTRAINT uq_name UNIQUE (name);
 4   ALTER TABLE ONLY public.pg DROP CONSTRAINT uq_name;
       public            postgres    false    215            ?           2606    41304 *   city_districts fk1g1v3952xtk0oa1dwbegfxe4m    FK CONSTRAINT     ?   ALTER TABLE ONLY public.city_districts
    ADD CONSTRAINT fk1g1v3952xtk0oa1dwbegfxe4m FOREIGN KEY (districts_id) REFERENCES public.city_district(id);
 T   ALTER TABLE ONLY public.city_districts DROP CONSTRAINT fk1g1v3952xtk0oa1dwbegfxe4m;
       public          postgres    false    3031    236    237            ?           2606    24677    church fk_church_city    FK CONSTRAINT     s   ALTER TABLE ONLY public.church
    ADD CONSTRAINT fk_church_city FOREIGN KEY (city_id) REFERENCES public.city(id);
 ?   ALTER TABLE ONLY public.church DROP CONSTRAINT fk_church_city;
       public          postgres    false    203    201    2991            ?           2606    24698 C   church_relationship fk_church_relationship_church_relationship_type    FK CONSTRAINT     ?   ALTER TABLE ONLY public.church_relationship
    ADD CONSTRAINT fk_church_relationship_church_relationship_type FOREIGN KEY (relationship_type_id) REFERENCES public.church_relationship(id);
 m   ALTER TABLE ONLY public.church_relationship DROP CONSTRAINT fk_church_relationship_church_relationship_type;
       public          postgres    false    207    207    2997            ?           2606    41283    city_district fk_city_district    FK CONSTRAINT     |   ALTER TABLE ONLY public.city_district
    ADD CONSTRAINT fk_city_district FOREIGN KEY (city_id) REFERENCES public.city(id);
 H   ALTER TABLE ONLY public.city_district DROP CONSTRAINT fk_city_district;
       public          postgres    false    201    2991    236            ?           2606    16426    city fk_city_state    FK CONSTRAINT     r   ALTER TABLE ONLY public.city
    ADD CONSTRAINT fk_city_state FOREIGN KEY (state_id) REFERENCES public.state(id);
 <   ALTER TABLE ONLY public.city DROP CONSTRAINT fk_city_state;
       public          postgres    false    200    201    2989            ?           2606    24754    network fk_network_person    FK CONSTRAINT     {   ALTER TABLE ONLY public.network
    ADD CONSTRAINT fk_network_person FOREIGN KEY (leader_id) REFERENCES public.person(id);
 C   ALTER TABLE ONLY public.network DROP CONSTRAINT fk_network_person;
       public          postgres    false    211    214    3001            ?           2606    24730    person fk_person_church    FK CONSTRAINT     y   ALTER TABLE ONLY public.person
    ADD CONSTRAINT fk_person_church FOREIGN KEY (church_id) REFERENCES public.church(id);
 A   ALTER TABLE ONLY public.person DROP CONSTRAINT fk_person_church;
       public          postgres    false    2993    211    203            ?           2606    24725    person fk_person_city    FK CONSTRAINT     s   ALTER TABLE ONLY public.person
    ADD CONSTRAINT fk_person_city FOREIGN KEY (city_id) REFERENCES public.city(id);
 ?   ALTER TABLE ONLY public.person DROP CONSTRAINT fk_person_city;
       public          postgres    false    211    201    2991            ?           2606    41288    person fk_person_city_district    FK CONSTRAINT     ?   ALTER TABLE ONLY public.person
    ADD CONSTRAINT fk_person_city_district FOREIGN KEY (district_id) REFERENCES public.city_district(id);
 H   ALTER TABLE ONLY public.person DROP CONSTRAINT fk_person_city_district;
       public          postgres    false    3031    236    211            ?           2606    24735    person fk_person_person_type    FK CONSTRAINT     ?   ALTER TABLE ONLY public.person
    ADD CONSTRAINT fk_person_person_type FOREIGN KEY (person_type_id) REFERENCES public.person_type(id);
 F   ALTER TABLE ONLY public.person DROP CONSTRAINT fk_person_person_type;
       public          postgres    false    209    2999    211            ?           2606    33071    pg_auth fk_pg    FK CONSTRAINT     g   ALTER TABLE ONLY public.pg_auth
    ADD CONSTRAINT fk_pg FOREIGN KEY (pg_id) REFERENCES public.pg(id);
 7   ALTER TABLE ONLY public.pg_auth DROP CONSTRAINT fk_pg;
       public          postgres    false    234    215    3007            ?           2606    24773    pg fk_pg_church    FK CONSTRAINT     q   ALTER TABLE ONLY public.pg
    ADD CONSTRAINT fk_pg_church FOREIGN KEY (church_id) REFERENCES public.church(id);
 9   ALTER TABLE ONLY public.pg DROP CONSTRAINT fk_pg_church;
       public          postgres    false    215    203    2993            ?           2606    24778    pg fk_pg_city    FK CONSTRAINT     k   ALTER TABLE ONLY public.pg
    ADD CONSTRAINT fk_pg_city FOREIGN KEY (city_id) REFERENCES public.city(id);
 7   ALTER TABLE ONLY public.pg DROP CONSTRAINT fk_pg_city;
       public          postgres    false    215    2991    201            ?           2606    33057    pg fk_pg_configuration    FK CONSTRAINT     ?   ALTER TABLE ONLY public.pg
    ADD CONSTRAINT fk_pg_configuration FOREIGN KEY (configuration_id) REFERENCES public.pg_configuration(id);
 @   ALTER TABLE ONLY public.pg DROP CONSTRAINT fk_pg_configuration;
       public          postgres    false    215    232    3027            ?           2606    41294 2   pg_configuration fk_pg_configuration_city_district    FK CONSTRAINT     ?   ALTER TABLE ONLY public.pg_configuration
    ADD CONSTRAINT fk_pg_configuration_city_district FOREIGN KEY (district_id) REFERENCES public.city_district(id);
 \   ALTER TABLE ONLY public.pg_configuration DROP CONSTRAINT fk_pg_configuration_city_district;
       public          postgres    false    3031    232    236            ?           2606    24812    pg_member fk_pg_member_person    FK CONSTRAINT        ALTER TABLE ONLY public.pg_member
    ADD CONSTRAINT fk_pg_member_person FOREIGN KEY (person_id) REFERENCES public.person(id);
 G   ALTER TABLE ONLY public.pg_member DROP CONSTRAINT fk_pg_member_person;
       public          postgres    false    219    211    3001            ?           2606    24807    pg_member fk_pg_member_pg    FK CONSTRAINT     s   ALTER TABLE ONLY public.pg_member
    ADD CONSTRAINT fk_pg_member_pg FOREIGN KEY (pg_id) REFERENCES public.pg(id);
 C   ALTER TABLE ONLY public.pg_member DROP CONSTRAINT fk_pg_member_pg;
       public          postgres    false    219    3007    215            ?           2606    24817 %   pg_member fk_pg_member_pg_member_type    FK CONSTRAINT     ?   ALTER TABLE ONLY public.pg_member
    ADD CONSTRAINT fk_pg_member_pg_member_type FOREIGN KEY (member_type_id) REFERENCES public.pg_member_type(id);
 O   ALTER TABLE ONLY public.pg_member DROP CONSTRAINT fk_pg_member_pg_member_type;
       public          postgres    false    219    3011    217            ?           2606    24768    pg fk_pg_network    FK CONSTRAINT     t   ALTER TABLE ONLY public.pg
    ADD CONSTRAINT fk_pg_network FOREIGN KEY (network_id) REFERENCES public.network(id);
 :   ALTER TABLE ONLY public.pg DROP CONSTRAINT fk_pg_network;
       public          postgres    false    3005    215    214            ?           2606    24918    pg fk_pg_pg_type_def    FK CONSTRAINT     |   ALTER TABLE ONLY public.pg
    ADD CONSTRAINT fk_pg_pg_type_def FOREIGN KEY (pg_type_id) REFERENCES public.pg_type_def(id);
 >   ALTER TABLE ONLY public.pg DROP CONSTRAINT fk_pg_pg_type_def;
       public          postgres    false    215    231    3025            ?           2606    33077 '   pg_report_data fk_pg_report_data_member    FK CONSTRAINT     ?   ALTER TABLE ONLY public.pg_report_data
    ADD CONSTRAINT fk_pg_report_data_member FOREIGN KEY (member_id) REFERENCES public.pg_member(id);
 Q   ALTER TABLE ONLY public.pg_report_data DROP CONSTRAINT fk_pg_report_data_member;
       public          postgres    false    3013    219    228            ?           2606    24889 *   pg_report_data fk_pg_report_data_pg_report    FK CONSTRAINT     ?   ALTER TABLE ONLY public.pg_report_data
    ADD CONSTRAINT fk_pg_report_data_pg_report FOREIGN KEY (report_id) REFERENCES public.pg_report(id);
 T   ALTER TABLE ONLY public.pg_report_data DROP CONSTRAINT fk_pg_report_data_pg_report;
       public          postgres    false    3015    222    228            ?           2606    24899 @   pg_report_data fk_pg_report_data_pg_report_absence_justification    FK CONSTRAINT     ?   ALTER TABLE ONLY public.pg_report_data
    ADD CONSTRAINT fk_pg_report_data_pg_report_absence_justification FOREIGN KEY (situation_id) REFERENCES public.pg_report_absence_justification(id);
 j   ALTER TABLE ONLY public.pg_report_data DROP CONSTRAINT fk_pg_report_data_pg_report_absence_justification;
       public          postgres    false    3019    228    226            ?           2606    33092 *   pg_report_data fkj3yy7bl46qg63u1y5ns2062uc    FK CONSTRAINT     ?   ALTER TABLE ONLY public.pg_report_data
    ADD CONSTRAINT fkj3yy7bl46qg63u1y5ns2062uc FOREIGN KEY (situation_id) REFERENCES public.pg_report_member_situation(id);
 T   ALTER TABLE ONLY public.pg_report_data DROP CONSTRAINT fkj3yy7bl46qg63u1y5ns2062uc;
       public          postgres    false    228    3017    224            ?           2606    33087 *   pg_report_data fkn8utp3vthyneygu1fvrc2qxwc    FK CONSTRAINT     ?   ALTER TABLE ONLY public.pg_report_data
    ADD CONSTRAINT fkn8utp3vthyneygu1fvrc2qxwc FOREIGN KEY (absence_justification_id) REFERENCES public.pg_report_absence_justification(id);
 T   ALTER TABLE ONLY public.pg_report_data DROP CONSTRAINT fkn8utp3vthyneygu1fvrc2qxwc;
       public          postgres    false    226    3019    228            ?           2606    41309 *   city_districts fkr9a6vot4qa7y0yncf0xt657it    FK CONSTRAINT     ?   ALTER TABLE ONLY public.city_districts
    ADD CONSTRAINT fkr9a6vot4qa7y0yncf0xt657it FOREIGN KEY (city_model_id) REFERENCES public.city(id);
 T   ALTER TABLE ONLY public.city_districts DROP CONSTRAINT fkr9a6vot4qa7y0yncf0xt657it;
       public          postgres    false    2991    237    201            ?           2606    33082 %   pg_report fksj3n8hbxhhr7jeg0xpeeorwaf    FK CONSTRAINT        ALTER TABLE ONLY public.pg_report
    ADD CONSTRAINT fksj3n8hbxhhr7jeg0xpeeorwaf FOREIGN KEY (pg_id) REFERENCES public.pg(id);
 O   ALTER TABLE ONLY public.pg_report DROP CONSTRAINT fksj3n8hbxhhr7jeg0xpeeorwaf;
       public          postgres    false    215    3007    222            z   ?   x?m??j?@???? *????????BI?\{?b?MV?wj?y_??^	?a????;?+?6?M????O?]n a??ЮI?????y?PuQ?Z????O?/~???`?m????7?(?~?;????c??H(Iqd"?H??ov??@?v??T?VZ	I???sا?3??(EE??&?U 
ʈVAUF?W?$??6RSI      ~      x?3?4?4?4?????? ??      |      x?3?t???t??????? =?      x   S   x?3120120?t?H,HM>???Ĉ(`n
??KI?Ĺ
Ysz?$f%^2510?t??/?L?;?? ?'?$???? 5?i      ?     x?e?Kn?0???S??Eɯ??H??ܸͪ֜8,$?R??(AWYd??@+e7? A?????C2??ױQb?lPP?a|?@BY???N(??)?M??4??]??X)?`<?6?a?	?ls?1nY-v?GW8;?{?R?lU???2?`?6?0	?%\\o?a??;?ViV(+`+?!u?a=e??}????Q?X?	?*?O??????>91'??$?`?O??|?r??l@CqG?TKf??????@J??H?Z?u?B??2??Ҫ!wbB?.?C?\??.?M[,ǰQ??7$'??^?V&2????ĝ#!?C?`?7#????v??M`??Yd??W??d?~6(???_?O%y???{??v^?:
ȴv?>???R?`G????ն{?????㨺c?.&???ށv??Sؗ?E?????Ȧ26Ͷ?'J?ӕ
?E?b?Ե?:)??o'?'?{k?w????i?F?C?.A1?=??v?????a???Z?"y>?N???K}???b??S??f0??f,g      ?      x?????? ? ?      ?   >   x?3?JMIU "?????bNCNC.#??G~njD?.?[???Z?
6?{??????qqq ?M+      ?   #  x?}?MN?0F??)? u????.UY ??*+6#?m]?8?	??	?h7H3????9y??wh??xæO?=??!??Ź??9Į?>8\?XnmN??\e??B??k?K%?n@Xbs???.@XM???_A?N?V"dӅK??=?~ n???tq?1T3R?r???4LJ???4#???}(?m?Y?Ēc?L???| ?wѝ??S??W\????)?I???S???Ѱ?????K??~?J????????zeq?????2Ny?+i,3??qg??,??$????̲??ɂ?      ?   <   x?3??,?,I?+I?2??M?M*??2??9?6%?H!%U!(5%?˄3 ??$??+F??? ?L?      ?   8   x?3?<ܘ?X??i?i?ibd DF@rq?&%?+?Y???q??qqq ???      ?   L   x?3?,H?MLO,H?L54HLI6?4?LJ4?LLJJ55K505O32H??0N?4?2??M,J?/6434%?ň+F??? ?xY      ?   P   x?3?4?*MTp???,J?+IUpJ,*?/??Q??Pp????4?2?4+*>?8_?73?45G!%_????$??Ќ+F??? u??      ?   H   x?m???0C?s=?	M ?t?9H?UB??I??֬?(???8D?;????,?v???iWs?ՅOJ`? ^???      ?   ?   x?3?t?K?,)?<?8?ˈ?-193'?$1%?H#Q?˘???ڔ?".(C!%U!??????D.S?Xj?BIQjf^bnj^I>??ojnRQ>? sN???ļ?*??????E?%?e?UXr?em?+I?????? ?h1?      ?      x?????? ? ?      ?   Z   x?3?)JLJ????4?2?t-.)M1?9]?S?/O?M8KS?KoM-VpK????L,J-J?r?e&????f???%E?Ŝ?\1z\\\ ??      ?      x?????? ? ?      ?   :   x?3?(J-N?+I?2?t,???!???D?????̴??ĔD.NײĔ̔|?=... =?f      ?      x?????? ? ?      ?   )   x?3?J?IL???K?M?+??2?tK????L,?????? ??
      w   "   x?31?N?+ITpN,I,??K?v?????? h?     