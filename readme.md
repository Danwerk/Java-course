#Testeri punktid näeb: https://ci.itcollege.ee/ci/icd0019/results/danyil

#Lisainfo: 1) Kui tahta käsurealt kompileerida java file, siis tavaks on see, et ühes failis on üks klass(nt. faili nimi A.java, kus A on klass). Kompileeritakse käsuga "javac A.java". 
           2) Kui kompileerida testid, mis asuvad kuskil kataloogis siis kasutada: "javac -classpath <välised teegid> <kompileeritavad failid>". Näiteks: "javac -cp ".;../lib/*" junit\Tests.java". Kompileeritud testide käivitamiseks kasutame käsku: "java -cp ".;../lib/*" org.junit.runner.JUnit
Core Tests"  


#Olulised märkused:

	1)Selleks, et esitada oma kood testerile hindamiseks tuleb teha COMMIT, seejärel IntelliJ-s alt valida GIT. Sealt valida viimane commit ning lisada sellele NEW TAG. 
	PS! Kui TAG märgend on juba varasemal commitil olemas, siis valin TAG DELETE ning see tuleb eemaldada ka REMOTE-is. Selleks sobib näiteks käsk "git push --delete origin #", kus # on ex01 või ex02 jne... 
	
	
#Nädalateemad: 

* intro - EX01 - Java IntelliJ paigaldamine, kompileerimine, bitbucket, õppeaine reeglid
* types - EX02 - Olulisemad andmestruktuurid ja kontrollstruktuurid
* junit - EX03 - Üksuste testimine
* oo    - EX04 - Objektid, objektorienteeritud programmeerimine
* exceptions - EX05 - Erindid
* inheritance - EX06 - Pärimine, abstraktne klass, alam klass, ülem klass
* collections - EX07 - Kollektsioonid, sorteerimine, enum
* generics - EX08 - geneerilised tüübid, silumine
* fp - EX09 - funktsionaalne programmeerimine, anonüümsed funktsioonid, stream API
* poly - EX10 - polümorfism (näited interface kasutamisest, dünaamiline meetodi valimine)
* GOF - EX11 - Game of life, Java virtuaalmasin

#Kirjandus lugemiseks:
1. "Coders at work"