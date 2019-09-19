-- Resenje 1. zadatka
SELECT Odsek.Naziv, count(Kurs.SifK) AS "Broj kurseva"
FROM Odsek, Kurs
WHERE kurs.SifO = odsek.SifO
GROUP by odsek.Naziv

--Resenje 2. zadatka
SELECT Kurs.Naziv, count(*) AS "Broj studenata"
FROM Kurs, Raspored, Student, Pohadja
WHERE Kurs.SifK = raspored.SifK AND student.SifS = Pohadja.SifS and Pohadja.SifR = Raspored.SifR
GROUP BY Kurs.Naziv
HAVING count(*) > 3

--Resenje 3. zadatka
SELECT SUM(Raspored.BrPrijaveljenih) / COUNT( DISTINCT raspored.SifK)
FROM  Raspored

--Resenje 4. zadatka
SELECT Kurs.Naziv
FROM Kurs, Raspored, Student, Pohadja
WHERE student.SifS = 1 AND Kurs.SifK = raspored.SifK AND student.SifS = Pohadja.SifS and Pohadja.SifR = Raspored.SifR

--Resenje 5. zadatka
SELECT Student.Ime, count(*) AS "Broj predmeta koji pohadja"
FROM Student, Kurs,Raspored, Pohadja
WHERE Kurs.SifK = raspored.SifK AND student.SifS = Pohadja.SifS and Pohadja.SifR = Raspored.SifR
Group by Student.ime
HAVING count (*) > 2

--Resenje 6. zadatka 

SELECT  DISTINCT Student.Ime
FROM Student, Pohadja, Raspored, Ucionica
WHERE Ucionica.SifU = 111 AND Raspored.Dan = "Pon" AND Student.SifS = Pohadja.SifS AND Raspored.SifR = Pohadja.SifR AND Ucionica.SifU = Raspored.SifU

--Resenje 7. zadatka

SELECT Kurs.Naziv, MAX(Raspored.BrPrijaveljenih)
FROM  Kurs, Raspored, Profesor
WHERE Profesor.SifP = 7 AND Kurs.SifK = raspored.SifK AND Profesor.SifO = Kurs.SifO
Group by Kurs.Naziv


--Resenje 8. zadatka

SELECT Kurs.Naziv
FROM Kurs, Preduslov
WHERE Preduslov.SifK = 4 AND  Preduslov.SifKP= kurs.SifK
GROUP by Kurs.Naziv

--Resenje 9. zadatka
SELECT Kurs.Naziv, count(*) 
FROM Kurs, Preduslov
WHERE Preduslov.SifK= kurs.SifK 
Group by Kurs.Naziv


--Resenje 10. zadatka
SELECT Profesor.Ime, SUM(Raspored.BrPrijaveljenih) AS "Broj Studenata"
FROM Raspored, Profesor
WHERE Raspored.dan = "Pon" AND Raspored.SifP = Profesor.SifP
GROUP BY Profesor.Ime