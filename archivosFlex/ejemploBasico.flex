/* codigo de usuario */

%% //separador de area

%class ejemplo1
%standalone
%line
%column

%% // separador de areas

/* reglas lexicas */

(a|b)*abb   {System.out.printf("*** Encontrada ocurrencia [%s] en linea %d, columna %d ***\n", yytext(), yyline, yycolumn);}

\n  { /* Nada */}
.   { /* Nada o manejo de errores*/}
