# **DifundeCEV**

### Qué es DifundeCEV

Software para la automatización de la difusión de nuevas publicaciones en [cofradiaselviso.com](www.cofradiaselviso.com), desarrollado por [Antonio Javier Palma](www.github.com/ajpalma28).

El proyecto surge debido a las necesidades que tienen los colaboradores del portal a la hora de difundir las nuevas publicaciones en la página web, ya que se hace muy tedioso entrar en todos los perfiles de las redes sociales de uno en uno e ir escribiendo las novedades a mano. Con ello, el objetivo es reducir el tiempo que se tarda en realizar esta tarea y automatizarla lo máximo posible.

Esta herramienta, introduciendo el enlace de la nueva publicación y seleccionando las etiquetas de los colectivos relacionados con dicha publicación, trabaja las siguientes redes sociales:
- **Twitter**: Publica de forma automática el tweet en la cuenta oficial de **Cofradías El Viso**, con las menciones de los colectivos vinculados a dicha publicación gracias a su selección en la interfaz de usuario.
- **Instagram**: Actualmente, Instagram no permite subir publicaciones desde aplicaciones de terceros con su API, por lo que se ha trabajado en facilitar la subida de publicaciones desde ordenador generando el texto completo que debe acompañar a la foto subida. El proceso de publicación es entero manual, salvo el de escribir el texto y copiarlo al portapapeles, que lo hace la herramienta de forma automática.
- **Telegram**: El portal **Cofradías El Viso** tiene un canal de Telegram en el que se suben las distintas actualizaciones de la web. Con esta herramienta se crea el texto de las nuevas difusiones en el canal, destacando el titular, añadiendo el enlace y copiándolo en el portapapeles. El objetivo es poder automatizar este proceso en el futuro mediante el uso de un bot.

La versión subida aquí no es totalmente funcional, al no tener las credenciales de la API de Twitter para la publicación automática de tweets, por motivos de seguridad.

### Datos técnicos
- Lenguaje de programación: Java 8
- Compilador: Maven
- Entorno de desarrollo: Eclipse IDE
- API de Twitter: twitter4j-4.0.7
- Fecha de la primera versión: 2 de octubre de 2020
- Destinado a equipos con Windows 10

### Ejemplo de publicación en Twitter

DifundeCEV está registrada como una aplicación de terceros autorizada para usar la API de Twitter para publicar tweets.

<p align="center">
  <img src="https://raw.githubusercontent.com/ajpalma28/DifundeCEV/main/assets/difundecevTW.png">
</p>
