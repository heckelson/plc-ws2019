/**
 * @author heckelson
 * @id m-nr
 */

grammar AdvancedCalculator;

// Ein Programm besteht aus vielen Statements
// Ein Statement pro Zeile
// Ein Statement kann sein
// Eine Zuweisung (t = …)
// Eine Expression (1 + 2 * s / u - 1)


program     : statement+
            ;

statement   : VARIABLE '=' expression NEWLINE+      # assign
            | expression NEWLINE+                   # expr
            | 'DEBUG' NEWLINE+                      # debug     // Extension: DEBUG
            ;

expression  : '(' expression ')'                    # parens
            | expression op=('*' | '/') expression  # mulDiv
            | expression op=('+' | '-') expression  # addSub
            | expression '%' expression             # mod       // Extension: Modulo
            | NUMBER                                # num
            | VARIABLE                              # var
            ;

NUMBER  :   DIGIT* '.' DIGIT+
        |   DIGIT+
        ;

VARIABLE:   LETTER (LETTER | DIGIT)*
        ;

DIGIT   :   [0-9]
        ;

LETTER  :   [A-Za-z_]
        ;

NEWLINE :   '\r'? '\n'
        ;

WS      :   [ \t]+ -> skip
        ;
