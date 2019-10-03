# Klassifizierung von Programmiersprachen
  * Der Großteil der Programmiersprachen ist imperativ
  * Funktionale Konzepte sind auch in vielen Sprachen

Die Einteilung von Sprachen ist schwierig, weil Sprachen häufig viele Konzepte kombinieren.  
Bsp: In C++ kann, muss man aber nicht Objekte schreiben.

## Beispiele für Programmiersprachen
### Prozedural (C):
```
int gcd( int a , int b ) {
        while ( a != b) {
            // ...
        }
        return a;
    }
```

### Funktional (Haskell)
```
    gcd a b
    | a == b = a
    | a > b ......
    ...
```
### Logisch (Prolog)
```
    A(x,y)
```
## Programmierstile
unterscheiden sich auch in den Sprachen
Bsp: Java imperativ vs. funktional
```
for ( Iterator<int> it = /*usw*/);  
p1.stream().filter(p -> p.age > 30).forEach(p -> System.out.println(p.name));
```
## Paradigmen
### Parallele Programmierung
 * soll Performance erhöhen
 * alles ist multicore, deshalb wichtig

### Reactive Programming
 * z.B. Programmlogik abhängig von Datenmenge
 * asynchrone Datenströme

Keine Programmiersprache unterstützt nur ein Paradigma

# Programmerzeugung

## Kompilierte Sprachen
 * Compiler kann viel heißen, Programmiersprache A -> B oder in Maschinencode
 * Zielprogramm ist ausführbar (VM, interpretiert, ...)

## Interpreter
 * Jedes Statement sofort ausführen
 * oft wesentlich langsamer

## Ziele
 * Geschwindigkeit
 * Energieeffizienz

Ein Compiler könnte gesteuert werden, dass das Programm energieeffizient ist statt schnell.  
Ab Ende der 80er waren Speicherzugriffe energieineffizienter als Operationen.  
Wenn man in Java Strings falsch benutzt, wird viiiel Speicher benutzt.

Sprachen können mehrere Konzepte gleichzeitig benutzen:
  * Java Virtual Machine
  * Java Compiler erzeugt maschinenunabhängigen Bytecode
  * JVM liest den Bytecode
  * JVM gibts auf sehr vielen Plattformen, Architekturen, Systemen

Vorteil von Bytecode: portabler Code

## Warum kompilieren?
 * sicherer
 * schneller
 
## Dynamische / Just-In-Time (JIT) Kompilierung
Bei JIT Compilation wird in einem eigenen Thread das Programm zur Laufzeit kompiliert.

## Andere Klassifizierung
 * **Machine Languages**
 * **Assembly Languages** (High Level Maschinensprachen)
 * **Systemsprachen:** low level tasks
 * **High-Level Sprachen:** Maschinenunabhängig, z.B. R
 * **Scripting languages:** dynamisch, sind high-level
 * **Domain-specific languages:** Spezielle Anwendungsgebiete
 
## Generationen
 1. First Generation: Machine languages
 2. Second Generation: Assembly languages
 3. Third Generation: High level languages
 4. Fourth Generation
 5. Fifth Generation: AI und Machine learning
 
## Statically/Dynamically typed languages
Typen werden zur compile timefestgesetzt vs. bei runtime

# High Demand Programming Languages
 1. Java
 2. C#
 3. C++
 4. Python
 5. JavaScript
 
## Professor's Sprachen
 * Fortran
 * C
 * C++
 * Java
 * Python
 * Go
 * C#
 * Go
 * Kotlin
 
Konzepte -> leichtes Sprachenlernen

## Warum sind Sprachen erfolgreich?
 * Ausdrucksstärke
 * Produktivität: leicht anzupassen
 * Portabilität
 * ...

