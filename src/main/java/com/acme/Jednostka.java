package com.acme;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "jednostki_ratownictwa_medycznego")
@Entity
public class Jednostka{

@Id
public int Id;
@Column(length = 200, unique = false)
public String Nazwa_jednostki;
@Column(length = 14, unique = false)
public String Regon;
@Column(length = 2, unique = false)
public String Kraj;
@Column(length = 30, unique = false)
public String Wojewodztwo;
@Column(length = 30, unique = false)
public String Powiat;
@Column(length = 30, unique = false)
public String Gmina;
@Column(length = 30, unique = false)
public String Miejscowosc;
@Column(length = 6, unique = false)
public String Kod_pocztowy;
@Column(length = 150, unique = false)
public String Ulica;
@Column(length = 25, unique = false)
public String Numer_budynku;
@Column(length = 25, unique = false)
public String Numer_lokalu;
@Column(length = 2, unique = false)
public String Kraj_jp;
@Column(length = 30, unique = false)
public String Wojewodztwo_jp;
@Column(length = 30, unique = false)
public String Powiat_jp;
@Column(length = 30, unique = false)
public String Gmina_jp;
@Column(length = 30, unique = false)
public String Miejscowosc_jp;
@Column(length = 6, unique = false)
public String Kod_pocztowy_jp;
@Column(length = 150, unique = false)
public String Ulica_jp;
@Column(length = 25, unique = false)
public String Numer_budynku_jp;
@Column(length = 25, unique = false)
public String Numer_lokalu_jp;
@Column(length = 1500, unique = false)
public String Teren_dzialania;
@Column(length = 150, unique = false)
public String Telefon_kontaktowy;
@Column(length = 150, unique = false)
public String Adres_email;
@Column(unique = false)
public Date Okres_dzialania_od;
@Column(unique = false)
public Date Okres_dzialania_do;
@Column(unique = false)
public Integer Liczebnosc_jednostki;
@Column(length = 15, unique = false)
public String Okres_pozostawania_w_gotowosci_w_ciagu_roku_od_1;
@Column(length = 15, unique = false)
public String Okres_pozostawania_w_gotowosci_w_ciagu_roku_do_1;
@Column(unique = false)
public Integer Czas_pozostawania_w_gotowosci_w_ciagu_doby_w_godzinach_1;
@Column(length = 10, unique = false)
public String Czas_osiagniecia_gotowosci_w_minutach_1;
@Column(unique = false)
public Integer Liczebnosc_jednostki_1;
@Column(length = 15, unique = false)
public String Okres_pozostawania_w_gotowosci_w_ciagu_roku_od_2;
@Column(length = 15, unique = false)
public String Okres_pozostawania_w_gotowosci_w_ciagu_roku_do_2;
@Column(length = 15, unique = false)
public Integer Czas_pozostawania_w_gotowosci_w_ciagu_doby_w_godzinach_2;
@Column(length = 10, unique = false)
public String Czas_osiagniecia_gotowosci_w_minutach_2;
@Column(unique = false)
public Integer Liczebnosc_jednostki_2;
@Column(length = 15, unique = false)
public String Okres_pozostawania_w_gotowosci_w_ciagu_roku_od_3;
@Column(length = 15, unique = false)
public String Okres_pozostawania_w_gotowosci_w_ciagu_roku_do_3;
@Column(unique = false)
public Integer Czas_pozostawania_w_gotowosci_w_ciagu_doby_w_godzinach_3;
@Column(length=10, unique = false)
public String Czas_osiagniecia_gotowosci_w_minutach_3;
@Column(unique = false)
public Integer Liczebnosc_jednostki_3;
@Column(length = 15, unique = false)
public String Okres_pozostawania_w_gotowosci_w_ciagu_roku_od_4;
@Column(length = 15, unique = false)
public String Okres_pozostawania_w_gotowosci_w_ciagu_roku_do_4;
@Column(unique = false)
public Integer Czas_pozostawania_w_gotowosci_w_ciagu_doby_w_godzinach_4;
@Column(length = 10, unique = false)
public String Czas_osiagniecia_gotowosci_w_minutach_4;
@Column(unique = false)
public Integer Liczebnosc_jednostki_4;
@Column(length = 15, unique = false)
public String Okres_pozostawania_w_gotowosci_w_ciagu_roku_od_5;
@Column(length = 15, unique = false)
public String Okres_pozostawania_w_gotowosci_w_ciagu_roku_do_5;
@Column(unique = false)
public Integer Czas_pozostawania_w_gotowosci_w_ciagu_doby_w_godzinach_5;
@Column(length = 10, unique = false)
public String Czas_osiagniecia_gotowosci_w_minutach_5;
@Column(unique = false)
public Integer Liczebnosc_jednostki_5;
@Column(length = 60, unique = false)
public String Rodzaj_jednostki;
@Column(length = 350, unique = false)
public String Rodzaj_ratownictwa;

}
