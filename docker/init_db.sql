create table if not exists poc_pochette(
	poc_id SERIAL,
    poc_nom varchar(30) not null,
    constraint pk_pochette primary key(poc_id)
);

create table rgp_rgpd(
	rgp_id SERIAL,
    rgp_nom varchar(100) not null,
    constraint pk_rgpd primary key(rgp_id)
);

create table if not exists tps_temps(
	tps_id SERIAL,
    tps_temps char not null,
    constraint pk_temps primary key(tps_id)
);

create table if not exists par_parametre_date_agent(
	par_id SERIAL,
    par_nom varchar(100) not null,
    par_id_propriete_alf varchar(150) not null,
    constraint pk_parametre_date_agent primary key(par_id)
);

create table if not exists srt_sort_final(
	srt_id SERIAL,
    srt_nom varchar(10),
    constraint pk_sort_final primary key(srt_id)
);

create table if not exists typ_typologie(
	typ_id SERIAL,
    typ_id_pochette integer not null,
    typ_rgpd_id integer not null,
    typ_nom varchar(200) not null,
    typ_sae_intermediaire boolean not null,
    typ_duree_duc int not null,
    typ_duc_temps int not null,
    typ_duc_depart int null,
    typ_duree_dua int not null,
    typ_dua_temps int not null,
    typ_dua_depart int null,
    typ_id_sort_final int not null,
    constraint pk_typologie primary key(typ_id),
    constraint fk_pochette foreign key(typ_id_pochette) references poc_pochette(poc_id)
		on delete cascade on update cascade,
	constraint fk_duc_temps foreign key(typ_duc_temps) references tps_temps(tps_id)
		on delete restrict on update cascade,
	constraint fk_dua_temps foreign key(typ_dua_temps) references tps_temps(tps_id)
		on delete restrict on update cascade,
	constraint fk_duc_depart foreign key(typ_duc_depart) references par_parametre_date_agent(par_id)
		on delete restrict on update cascade,
	constraint fk_dua_depart foreign key(typ_dua_depart) references par_parametre_date_agent(par_id)
		on delete restrict on update cascade
);

create or replace function fun_ajt_pochette(nom varchar(30))  returns integer
language plpgsql
as $$
begin
	if ( (select poc_nom from poc_pochette where poc_nom = nom) is NULL)  then
		insert into poc_pochette(poc_nom)values(nom);
	end if;
    RETURN(select poc_id from poc_pochette where poc_nom = nom);
end;$$;

create or replace function fun_ajt_rgpd(nom varchar(100))
returns integer
language plpgsql
as $$
begin
	if ( (select rgp_nom from rgp_rgpd where rgp_nom = nom) is NULL)  then
		insert into rgp_rgpd(rgp_nom)values(nom);
	end if;
    return(select rgp_id from rgp_rgpd where rgp_nom = nom);
end;$$;

create or replace function fun_ajt_parametre_date_agent(nom varchar(100), nom_parametre varchar(150))
returns integer
language plpgsql
as $$
begin
	if ( (select par_nom from par_parametre_date_agent where par_id_propriete_alf = nom_parametre) is NULL)  then
		insert into par_parametre_date_agent(par_nom, par_id_propriete_alf)values(nom, nom_parametre);
	end if;
    return(select par_id from par_parametre_date_agent where par_id_propriete_alf = nom_parametre);
end;$$;

create or replace function fun_ajt_typologie(id_pochette int, id_rgpd int, nom varchar(200), sae boolean,
											 duree_duc int, id_tps_duree_duc int, id_parametre_depart_duc int,
                                             duree_dua int, id_tps_duree_dua int, id_parametre_depart_dua int,
                                             id_sort_final int)
returns integer
language plpgsql
as $$
begin
	if ( (select typ_id from typ_typologie where typ_nom = nom and typ_id_pochette = id_pochette) is NULL)  then
		insert into typ_typologie(typ_id_pochette, typ_rgpd_id, typ_nom, typ_sae_intermediaire, typ_duree_duc,
		                          typ_duc_temps, typ_duc_depart, typ_duree_dua, typ_dua_temps, typ_dua_depart,
		                          typ_id_sort_final)
        values(id_pochette, id_rgpd, nom, sae, duree_duc, id_tps_duree_duc, id_parametre_depart_duc, duree_dua,
               id_tps_duree_dua, id_parametre_depart_dua, id_sort_final);
	end if;
    return(select typ_id from typ_typologie where typ_nom = nom and typ_id_pochette = id_pochette);
end; $$;

create type typologie as (
	typologie_id integer, nom varchar(200), nom_pochette varchar(30), rgpd varchar(100), est_archive_mida boolean,
	duree_duc integer, temps_duc char, point_depart_duc varchar(100), id_alfresco_duc varchar(150),
	duree_dua integer, temps_dua char, point_depart_dua varchar(100), id_alfresco_dua varchar(150),
	sort_final varchar(10)
);

create or replace function fun_obt_typologie(nom_pochette varchar(30), nom varchar(200))
returns typologie
language sql
as $$
		select
			typ.typ_id, typ.typ_nom, poc_nom, rg.rgp_nom, typ.typ_sae_intermediaire,
			typ.typ_duree_duc, tps1.tps_temps, par1.par_nom, par1.par_id_propriete_alf,
			typ.typ_duree_dua, tps2.tps_temps, par2.par_nom, par2.par_id_propriete_alf,
			srt.srt_nom
		from typ_typologie typ
		left join poc_pochette poc
			on poc.poc_id = typ.typ_id_pochette
		left join rgp_rgpd rg
			on rg.rgp_id = typ.typ_rgpd_id
		left join tps_temps tps1
			on tps1.tps_id = typ.typ_duc_temps
		left join tps_temps tps2
			on tps2.tps_id = typ.typ_dua_temps
		left join par_parametre_date_agent par1
			on par1.par_id = typ.typ_duc_depart
		left join par_parametre_date_agent par2
			on par2.par_id = typ.typ_dua_depart
		left join srt_sort_final srt
			on srt.srt_id = typ.typ_id_sort_final
		where poc.poc_nom = nom_pochette and typ.typ_nom = nom
	;
$$;

select fun_ajt_pochette('1_Carrière & traitement');
select fun_ajt_pochette('2_Santé');
select fun_ajt_pochette('3_Retraite');
select fun_ajt_pochette('4_Discipline');
select fun_ajt_pochette('5_Autorisation');
select fun_ajt_pochette('6_Evaluations');
select fun_ajt_pochette('7_Chômage');
select fun_ajt_pochette('8_Correspondance');
select fun_ajt_pochette('9_Formation');

select fun_ajt_rgpd('Données à caractère personnel');
select fun_ajt_rgpd('Données à caractère sensible');
select fun_ajt_rgpd('Données à caractère hautement personnel');

insert into tps_temps(tps_temps)values('Y');
insert into tps_temps(tps_temps)values('M');
insert into tps_temps(tps_temps)values('D');
insert into tps_temps(tps_temps)values('H');

select fun_ajt_parametre_date_agent('Date de départ de l''agent', 'agt:dateDepart');
select fun_ajt_parametre_date_agent('Date de naissance de l''agent', 'agt:dateNaissance');
select fun_ajt_parametre_date_agent('Date de fin du temps partiel', 'agt:dateFinTpsPartiel');
select fun_ajt_parametre_date_agent('Date de fin de congé', 'agt:dateFinConge');
select fun_ajt_parametre_date_agent('Date du document', 'agt:dateDocument');

insert into srt_sort_final(srt_nom)values('Archiver');
insert into srt_sort_final(srt_nom)values('Détruire');
