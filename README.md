# Proyecto del Segundo Cuatrimestre Fundamentos de Programación (Curso  2021/2022)
Autor: Jaime Linares Barrera       
uvus: jailinbar

Aquí debes añadir la descripción del dataset y un enunciado del dominio del proyecto.


## Estructura de las carpetas del proyecto

* **/src**: Contiene los diferentes archivos que forman parte del proyecto. Debe estar estructurado en los siguentes paquetes
  * **fp.clinico**: Paquete que contiene alguno de los tipos del proyecto.
  * **fp.clinico.test**: Paquete que contiene las clases de test de ciertos tipos del proyecto.
  * **fp.farmaceutico**: Paquete que contiene alguno de los tipos del proyecto.
  * **fp.farmaceutico.test**: Paquete que contiene las clases de test de ciertos tipos del proyecto.
  * **fp.vacunas**: Paquete que contiene alguno de los tipos del proyecto.
  * **fp.vacunas.test**: Paquete que contiene las clases de test de ciertos tipos del proyecto.
  * **fp.utiles**:  Paquete que contiene las clases de utilidad. 
* **/data**: Contiene el dataset o datasets del proyecto
    * **\<dataset1.csv\>**: Añade una descripción genérica del dataset.
* **/doc**: Contiene la documentación y enunciado del proyecto.
    
## Estructura del *dataset*

Aquí debes describir la estructura del dataset explicando qué representan los datos que contiene y la descripción de cada una de las columnas. Incluye también la URL del dataset original.

El dataset está compuesto por \<N\> columnas, con la siguiente descripción:

* **\<columna 1>**: de tipo \<tipo\>, representa....
* **\<columna 2>**: de tipo \<tipo\>, representa....
....

## Tipos implementados

En el proyecto hemos implementado los tipos Persona, Paciente, PacienteEstudio, Vacunacion y Medicamentos.

### Tipos Base


#### Tipo Persona

**Propiedades**:

- nombre, de tipo String, consultable. 
- apellidos, de tipo String, consultable.
- dni, de tipo String, consultable. 
- fechaNacimiento, de tipo LocalDate, consultable.
- edad, de tipo Integer, derivada.
 
**Constructores**: 

- Por defecto del record.

**Restricciones**:
 
- R1: La fecha de nacimiento debe ser anterior a la fecha actual.
- R2: El dni debe ser una cadena con ocho dígitos y seguidos de una letra. 
 
**Criterio de igualdad**: por defecto asociado al record.

**Criterio de ordenación**: por dni.

**Representacion como cadena**: por defecto asociada al record.

**Otras operaciones**:

- Método static of: recibe nombre, apellidos, dni y fecha de nacimiento y devuelve una persona. 
- Método static parse: recibe una cadena con un formato específico y devuelve una persona.
Ejemplo de cadena: “Juan, García Rodríguez, 12755078Z, 20/03/1965”. 


#### Tipo Paciente

**Propiedades**:

- persona, de tipo Persona, consultable. 
- codigoIngreso, de tipo String, consultable.
- fechaHoraIngreso, de tipo LocalDateTime, consultable. 
- fechaIngreso, de tipo LocalDate, derivada.
- horaIngreso, de tipo String, derivada.
 
**Constructores**: 

- Por defecto del record.

**Restricciones**:
 
- R1: la fecha y hora de ingreso debe ser anterior o igual a la fecha actual. 
 
**Criterio de igualdad**: por defecto asociado al record.

**Representacion como cadena**: por defecto asociada al record.

**Otras operaciones**:

- Método static of: nombre, apellidos, dni, fecha de nacimiento, código y fecha y hora de
ingreso y devuelve un paciente. 
- Método static of: recibe un objeto persona, un código y una fecha y hora de ingreso y devuelve un paciente. 


#### Tipo PacienteEstudio

**Propiedades**:

- id, de tipo String, consultable. 
- genero, de tipo String, consultable.
- edad, de tipo Double, consultable. 
- hipertension, de tipo Boolean, consultable.
- enfermedadCorazon, de tipo Boolean, consultable.
- tipoDeResidencia, de tipo Residencia, consultable.
- nivelMedioGlucosa, de tipo Double, consultable.
- factorRiesgo, de tipo Boolean, derivada.
 
**Constructores**: 

- Por defecto del record.

**Restricciones**:
 
- R1: La edad tiene que ser mayor o igual que cero y menor o igual que 130.
- R2: El nivel medio de glucosa tiene que ser mayor o igual que cero. 
 
**Criterio de igualdad**: por defecto asociado al record.

**Criterio de ordenación**: segun la edad y en caso de igualdad el id.

**Representacion como cadena**:  informa del id y la edad del paciente

**Otras operaciones**:

- Método static of: recibe valores para cada propiedad basica y devuelve un objeto del tipo PacienteEstudio. 
- Método static parse: recibe una cadena con un formato especificado y y devuelve un objeto del tipo. Ejemplo de cadena: “6306;Male;80;false;false;URBANA;83.84” 


#### Tipo Vacunacion

**Propiedades**:

- fecha, de tipo LocalDate, consultable. 
- comunidad, de tipo String, consultable.
- pfizer, de tipo Integer, consultable. 
- moderna, de tipo Integer, consultable.
- astrazeneca, de tipo Integer, consultable.
- janssen, de tipo Integer, consultable.
- numeroPersonas, de tipo Integer, consultable.
- NumeroTotal, de tipo Integer, derivada.
 
**Constructores**: 

- Por defecto del record.

**Restricciones**:
 
- R1: La fecha de debe ser posterior al 01/02/2021. 
 
**Criterio de igualdad**: por defecto asociado al record.

**Criterio de ordenación**: por comunidad y en caso de igualdad por fecha.

**Representacion como cadena**:  por defecto asociado al record.

**Otras operaciones**:

- Método static of: recibe valores para cada propiedad básica y devuelve un objeto del tipo. 
- Método static parse: recibe una cadena con un formato específico y devuelve un objeto del tipo. Ejemplo de cadena: “04/01/2021;Andalucía;140295;0;0;0;0”. 


#### Tipo Medicamento

**Propiedades**:

- nombreMedicamento, de tipo String, consultable. 
- tipoDeMedicamento, de tipo TipoMedicamento, consultable.
- codigoEnfermedad, de tipo String, consultable. 
- farmaceutica, de tipo String, consultable.
- puntuacion, de tipo Double, consultable.
- indiceSomatico, de tipo Integer, consultable.
- fechaCatalogo, de tipo LocalDate, consultable y modificable.
- tratarEnfermedad, de tipo Boolean, derivada.
 
**Constructores**: 

- C1: se le asocia un valor a cada propiedad básica.

**Restricciones**:
 
- R1: La puntación tiene que ser mayor estricta que cero.
- R2: El índice somático tiene que ser mayor o igual que 1000.
- R3: La fecha de catálogo tiene que ser posterior al 01/01/2015. 
 
**Criterio de igualdad**:  por nombre del medicamento y farmacéutica.

**Criterio de ordenación**: por nombre del medicamento y en caso de igualdad por la farmacéutica. 

**Representacion como cadena**: según el nombre del medicamento y de la farmacéutica. 


### Tipos auxiliares
- TipoResidencia: es un enum que tomará los valores RURAL o URBANA.
- TipoMedicamento: es un enum que tomará los valores ANATOMICO, QUIMICO o TERAPEUTICO.
- FactoriaMedicamentos: clase que incluye un método static de nombre parseaMedicamente, que recibe una cadena con un formato específico y devuelve un objeto de tipo Medicamento. Ejemplo: “efavirenz,Anatomico,Y212XXA,Actavis Mid Atlantic LLC,90.0,1848,04/12/2019”. 


### Factoría
Descripción breve de la factoría.

- _método 1_: Descripción del método 1.
-	_método 2_: Descripción del método 2.


### Tipo Contenedor

Descripción breve del tipo contenedor.

**Propiedades**:

- _propiedad1_, de tipo \<Tipo1\>, consultable. 
- _propiedad2_, de tipo \<Tipo2\>, consultable y modificable. 
- ...

**Constructores**: 

- C1: Descripción del constructor 1.
- C2: Descripción del constructor 2.
- ...

**Restricciones**:
 
- R1: Descripción de la restricción 1.
- R2: Descripción de la restricción 2.
- ...
- 
**Criterio de igualdad**: Describir el criterio de igualdad

**Criterio de ordenación**: Describir el criterio de ordenación (si lo hay).

**Otras operaciones**:
 
-	_método 1_: Descripción del método 1.
- ...
