# LaPalabraDelDiaJava
LaPalabraDelDia

LaPalabraDelDia es un juego de adivinanzas de palabras basado en Java. El juego se inspira en el popular juego en línea “lapalabradeldia.com”. El objetivo del juego es adivinar una palabra secreta seleccionada al azar de un conjunto de palabras.

Características
Extracción de palabras: El juego comienza leyendo un archivo de texto con una lista de palabras. Filtra las palabras que tienen exactamente cinco letras y las guarda en un nuevo archivo llamado “Destino.txt”.

Juego de adivinanzas: El sistema elige una palabra al azar de la lista y permite al usuario seis oportunidades para adivinarla. Con cada intento, el sistema informa al usuario los aciertos y desaciertos.

Retroalimentación del juego: Con cada intento, el sistema proporciona pistas al usuario de la siguiente manera:

Acierto de letra y posición: devuelve la letra en mayúscula.
Acierto de letra pero no de posición: devuelve la letra en minúscula.
Sin acierto: devuelve una barra baja.
Resultado del juego: Si el usuario adivina la palabra, el sistema informa que ha ganado. Si después de seis intentos fallidos el usuario no adivina la palabra, el sistema informa que ha perdido.

Juego continuo: Después de ganar o perder, el sistema pregunta al usuario si desea jugar de nuevo. Si el usuario decide jugar de nuevo, el sistema selecciona una nueva palabra secreta y reinicia los intentos.

Uso
Para jugar al juego, simplemente ejecute el programa Java. Cuando se le solicite, ingrese su intento para adivinar la palabra secreta o ingrese 0 para salir del juego.