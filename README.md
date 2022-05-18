# Proyecto del Segundo Cuatrimestre Fundamentos de Programación (Curso  2021/2022)
Autor: Jaime Linares Barrera       
uvus: jailinbar

En el proyecto tenemos tres dataset:
 - estudio_clinico.csv: contiene la información sobre objetos del tipo PacienteEstudio.
 - medicamentos.csv: contiene la información sobre objetos del tipo Medicamento.
 - ccaa_vacunas_3.csv: contiene la información sobre objetos del tipo Vacunacion.


## Estructura de las carpetas del proyecto

* **/src**: Contiene los diferentes archivos que forman parte del proyecto. Debe estar estructurado en los siguentes paquetes
  * **fp.clinico**: Paquete que contiene alguno de los tipos del proyecto.
  * **fp.clinico.test**: Paquete que contiene las clases de test de ciertos tipos del proyecto.
  * **fp.farmaceutico**: Paquete que contiene alguno de los tipos del proyecto.
  * **fp.farmaceutico.test**: Paquete que contiene las clases de test de ciertos tipos del proyecto.
  * **fp.vacunas**: Paquete que contiene alguno de los tipos del proyecto.
  * **fp.vacunas.test**: Paquete que contiene las clases de test de ciertos tipos del proyecto.
  * **fp.utiles**:  Paquete que contiene las clases de utilidad. 
* **/data**: Contiene los datasets del proyecto
    * **estudio_clinico.csv**: contiene la información sobre objetos del tipo PacienteEstudio.
    * **medicamentos.csv**: contiene la información sobre objetos del tipo Medicamento.
    * **ccaa_vacunas_3.csv**: contiene la información sobre objetos del tipo Vacunacion.
* **/doc**: Contiene la documentación y enunciado del proyecto.
    
## Estructura del *dataset*

### estudio_clinico.csv
El dataset está compuesto por 7 columnas, con la siguiente descripción:

* **id**: de tipo String, representa el id del paciente que se esta estudiando.
* **genero**: de tipo String, representa el genero del paciente que se esta estudiando.
* **edad**: de tipo Double, representa la edad del paciente que se esta estudiando.
* **hipertension**: de tipo Boolean, representa si el paciente que se esta estudiando tiene hipertension o no.
* **enfermedadCorazon**: de tipo Boolean, representa si el paciente que se esta estudiando tiene alguna enfermedad del corazón.
* **tipoDeResidencia**: de tipo TipoResidencia, representa el tipo de residencia del paciente que se esta estudiando.
* **nivelMedioGlucosa**: de tipo Double, representa el nivel medio de glucosa que tiene el pacinete que se esta estudiando.

### medicamentos.csv
El dataset está compuesto por 7 columnas, con la siguiente descripción:

* **nombreMedicamento**: de tipo String, representa el nombre del medicamento.
* **tipoDeMedicamento**: de tipo TipoMedicamento, representa el tipo de medicamento.
* **codigoEnfermedad**: de tipo String, representa el codigo de la enfermedad.
* **farmaceutica**: de tipo String, representa la farmaceutica que ha vendido tal producto.
* **puntuacion**: de tipo Double, representa la puntuacion del medicamento.
* **indiceSomatico**: de tipo Integer, representa el indice somatico del medicamento.
* **fechaCatalogo**: de tipo LocalDate, representa la fecha de catalogo del medicamento.

### ccaa_vacunas_3.csv
El dataset está compuesto por 7 columnas, con la siguiente descripción:

* **fecha**: de tipo LocalDate, representa la fecha de vacunación.
* **comunidad**: de tipo String, representa la comunidad autónoma.
* **pfizer**: de tipo Integer, representa número de vacunas de pfizer.
* **moderna**: de tipo Integer, representa el número de vacunas de moderna.
* **astrazeneca**: de tipo Integer, representa el número de vacunas de astrazeneca.
* **janssen**: de tipo Integer, representa el número de vacunas de janssen.
* **numeroPersonas**: de tipo Integer, representa el numero de personas que se han vacunado.



## Tipos implementados

En el proyecto hemos implementado los tipos Persona, Paciente, PacienteEstudio, Vacunacion, Medicamentos y EstudioClinico.

### Tipo Persona

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


### Tipo Paciente

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


### Tipo PacienteEstudio

**Propiedades**:

- id, de tipo String, consultable. 
- genero, de tipo String, consultable.
- edad, de tipo Double, consultable. 
- hipertension, de tipo Boolean, consultable.
- enfermedadCorazon, de tipo Boolean, consultable.
- tipoDeResidencia, de tipo TipoResidencia, consultable.
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

**Tipos auxiliares**:

- TipoResidencia: es un enum que tomará los valores RURAL o URBANA.


### Tipo Vacunacion

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

**FactoriaVacunacion**:

Clase que incluye:
- _leeFichero_ : método que dandole la ruta de un csv devuelve una lista con objetos del tipo Vacunacion. Utilizamos para parsear cada linea de fichero el
metodo parse del Tipo Vacunanción.


### Tipo Medicamento

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

**Tipos auxiliares**:

- TipoMedicamento: es un enum que tomará los valores ANATOMICO, QUIMICO o TERAPEUTICO.

**FactoriaMedicamentos**:

Clase que incluye:
- _parseaMedicamento_: recibe una cadena con un formato específico y devuelve un objeto de tipo Medicamento. Ejemplo: “efavirenz,Anatomico,Y212XXA,Actavis Mid Atlantic LLC,90.0,1848,04/12/2019”. 
- _leeFichero_: método que devuelve una lista con objetos de tipo Medicamento (viene de leer el csv). Utilizamos en metodo parseaMedicamento para parsear
cada línea del csv.


### Tipo EstudioClinico

Es una interfaz que implementa a dos clases EstudioClinicoBucles y EstudioClinico:

### EstudioClinicoBucles

**Propiedades**:

- pacientesEstudio, de tipo List<PacienteEstudio>, consultable.
 
**Constructores**: 

- C1: constructor vacío
- C2: constructor al que le das como parámetro una lista de objetos PacienteEstudio.
 
**Otras operaciones**
 
- Integer numeroPacientes()
- void incluyePaciente(PacienteEstudio paciente)
- void incluyePacientes(Collection<PacienteEstudio> pacientes)
- void eliminaPaciente(PacienteEstudio paciente)
- Boolean estaPaciente(PacienteEstudio paciente)
- void borraEstudio()
- EstudioClinico of(String nombreFichero)
- List<PacienteEstudio> leeFichero(String nombreFichero)
- Boolean todosPacienteSonDelTipo(TipoResidencia tipo)
- Boolean existeAlgunPacienteDelTipo(TipoResidencia tipo)
- Integer numeroPacientesFactorRiesgo()
- Double edadMediaPacientesConFactorRiesgo()
- List<PacienteEstudio> filtraPacientesPorEdad(Double edad)
- Map<String,List<PacienteEstudio>> agruparPacientesEdadMayorQuePorGenero(Double edad)
- Map<String,Long> numeroPacientesPorGenero()
- Map<String,Double> edadMediaPacientesPorPorGenero()
 
 ### EstudioClinicoStream
 
 **Propiedades**:

- pacientesEstudio, de tipo List<PacienteEstudio>, consultable.
 
**Constructores**: 

- C1: constructor vacío
- C2: constructor al que le das como parámetro una lista de objetos PacienteEstudio.
 
**Otras operaciones**
 
- Integer numeroPacientes()
- void incluyePaciente(PacienteEstudio paciente)
- void incluyePacientes(Collection<PacienteEstudio> pacientes)
- void eliminaPaciente(PacienteEstudio paciente)
- Boolean estaPaciente(PacienteEstudio paciente)
- void borraEstudio()
- EstudioClinico of(String nombreFichero)
- List<PacienteEstudio> leeFichero(String nombreFichero)
- Boolean todosPacienteSonDelTipo(TipoResidencia tipo)
- Boolean existeAlgunPacienteDelTipo(TipoResidencia tipo)
- Integer numeroPacientesFactorRiesgo()
- Double edadMediaPacientesConFactorRiesgo()
- List<PacienteEstudio> filtraPacientesPorEdad(Double edad)
- Map<String,List<PacienteEstudio>> agruparPacientesEdadMayorQuePorGenero(Double edad)
- Map<String,Long> numeroPacientesPorGenero()
- Map<String,Double> edadMediaPacientesPorPorGenero()

