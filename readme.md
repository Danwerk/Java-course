#Testeri punktid n�eb: https://ci.itcollege.ee/ci/icd0019/results/danyil

#Lisainfo: 1) Kui tahta k�surealt kompileerida java file, siis tavaks on see, et �hes failis on �ks klass(nt. faili nimi A.java, kus A on klass). Kompileeritakse k�suga "javac A.java". 
           2) Kui kompileerida testid, mis asuvad kuskil kataloogis siis kasutada: "javac -classpath <v�lised teegid> <kompileeritavad failid>". N�iteks: "javac -cp ".;../lib/*" junit\Tests.java". Kompileeritud testide k�ivitamiseks kasutame k�sku: "java -cp ".;../lib/*" org.junit.runner.JUnit
Core Tests"  


#Olulised m�rkused:

	1)Selleks, et esitada oma kood testerile hindamiseks tuleb teha COMMIT, seej�rel IntelliJ-s alt valida GIT. Sealt valida viimane commit ning lisada sellele NEW TAG. 
	PS! Kui TAG m�rgend on juba varasemal commitil olemas, siis valin TAG DELETE ning see tuleb eemaldada ka REMOTE-is. Selleks sobib n�iteks k�sk "git push --delete origin #", kus # on ex01 v�i ex02 jne... 
	
	
#N�dalateemad: 

* intro - EX01 - Java IntelliJ paigaldamine, kompileerimine, bitbucket, �ppeaine reeglid
* types - EX02 - Olulisemad andmestruktuurid ja kontrollstruktuurid
* junit - EX03 - �ksuste testimine
* oo    - EX04 - Objektid, objektorienteeritud programmeerimine
* exceptions - EX05 - Erindid
* inheritance - EX06 - P�rimine, abstraktne klass, alam klass, �lem klass
* collections - EX07 - Kollektsioonid, sorteerimine, enum
* generics - EX08 - geneerilised t��bid, silumine
* fp - EX09 - funktsionaalne programmeerimine, anon��msed funktsioonid, stream API
* poly - EX10 - pol�morfism (n�ited interface kasutamisest, d�naamiline meetodi valimine)
* GOF - EX11 - Game of life, Java virtuaalmasin

#Kirjandus lugemiseks:
1. "Coders at work"