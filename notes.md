# Notas

## Java Persistence Api (JPA)

Herramienta o intermediario para transmitir informacion
a de nuestra aplicacion Java a una base de datos

* Mapea clases
* [Annotations (@)](#annotations)
* Las clases pasan a ser entidades en una database

### Annotations

* **@Controller** : usada para indicar que es un controlador;
  en los controladores se realizan las funciones para que
  los requests puedan conectarse al Back-End.
* **@Service** : Esta anotación es usada para indicar
  que la clase es usada para la business Logic.
* **@Repository** : Esta anotación es usada para indicar
  que la clase es usada como DAO.
  El DAO (Data Access Object), es el termino usado para las
  clases que se conectan a la base de datos y
  realizan diferentes funciones allí como:
  inserts, selects, updates, etc.
* **@RestController** : se utiliza para marcar una
clase como un controlador de Spring MVC que está
diseñado específicamente para la creación de servicios
web RESTful. Cuando se aplica esta anotación a una
clase, Spring automáticamente detecta y
gestiona las solicitudes HTTP entrantes hacia
los métodos de esa clase.
* **@RequestMapping("/taxi")** : se utiliza para asignar
una ruta específica a un controlador o a métodos
dentro de un controlador.
* **@Autowired** : es una anotación que permite
que Spring Framework maneje la inyección de
dependencias automáticamente en las clases
anotadas, lo que facilita la gestión de las
relaciones entre los distintos componentes
* **@GetMapping** : para mapear solicitudes
HTTP GET a métodos específicos en un controlador.
Esto significa que cuando una solicitud GET
llega al servidor web para una URL específica,
la función o método anotado con @GetMapping
correspondiente será invocado para manejar esa solicitud.


### GET /taxi

- URL: GET http://localhost:8080/taxi
- Respuesta esperada: Lista de taxis paginada con sus respectivos id y placas.

### GET con diferentes valores para los parámetros de paginación `pageNumber` y `pageSize`

- URL: GET http://localhost:8080/taxi?pageNumber=1&pageSize=10
- Respuesta esperada: Lista de taxis paginada con sus respectivos id y placas.

### 