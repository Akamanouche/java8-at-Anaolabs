[22/09/2016]

Ici, il est question de la nouvelle classe "Optional".

==> Elle permet d'éviter les "NullPointerException" 

# voir : http://www.touilleur-express.fr/2014/11/07/optional-en-java-8/

# Equivalent en Scala : "Option"



-- [14/02/2018] ---------------------------------------------------------------

	La méthode .ifPresent(...) de Optional est chainable sur les STREAM...
	En effet le .findFirst() de Stream renvoie un Optional
	==> on peut donc y coller au cul un .ifPresent(...) :
	   
		Arrays.asList("a1", "a2", "a3")
		.stream()
		.findFirst()
==>		.ifPresent(System.out::println);
	

-------------------------------------------------------------------------------

