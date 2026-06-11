## Casos de Uso - Arquitectura Hexagonal

Esta carpeta contiene los **Casos de Uso** de la aplicación, que implementan la lógica de negocio sin dependencias de infraestructura.

### Estructura

```
usecases/
├── guia/
│   ├── CreateGuiaUseCase.java      # Crear nuevo guía
│   ├── ListGuiaUseCase.java        # Listar guías
│   ├── UpdateGuiaUseCase.java      # Actualizar guía existente
│   └── DeleteGuiaUseCase.java      # Eliminar guía
├── zona/
│   ├── CreateZonaUseCase.java      # Crear nueva zona
│   ├── ListZonaUseCase.java        # Listar zonas
│   ├── UpdateZonaUseCase.java      # Actualizar zona existente
│   └── DeleteZonaUseCase.java      # Eliminar zona
└── UseCasesFacade.java             # Punto de entrada centralizado
```

### Operaciones Soportadas

#### CRUD para Guía
- **CREATE**: `CreateGuiaUseCase.crear(nombre, telefono, email, fechaInicio)`
- **READ**: `ListGuiaUseCase.listarTodos()` y `ListGuiaUseCase.buscarPorPrefijo(id)`
- **UPDATE**: `UpdateGuiaUseCase.actualizar(id, nombre, telefono, email, fechaInicio)`
- **DELETE**: `DeleteGuiaUseCase.eliminar(id)` *(requiere implementación en OutPort)*

#### CRUD para Zona
- **CREATE**: `CreateZonaUseCase.crear(nombre, descripcion)`
- **READ**: `ListZonaUseCase.listarTodas()` y `ListZonaUseCase.buscarPorId(id)`
- **UPDATE**: `UpdateZonaUseCase.actualizar(id, nombre, descripcion)`
- **DELETE**: `DeleteZonaUseCase.eliminar(id)` *(requiere implementación en OutPort)*

### Flujo de Ejecución

```
Controller (entrada)
    ↓
UseCasesFacade
    ↓
UseCase específico (CreateGuia, UpdateZona, etc.)
    ↓
Validaciones de negocio
    ↓
InPort (puerto de entrada - interfaz)
    ↓
Service (GuiaService, ZonaService, etc.)
    ↓
OutPort (puerto de salida - interfaz)
    ↓
Repository (implementación - consultas SQL)
    ↓
Base de datos
```

### Ejemplo de Uso

```java
// En un controlador o punto de entrada
UseCasesFacade useCases = new UseCasesFacade(
    new CreateGuiaUseCase(guiaService),
    new ListGuiaUseCase(guiaService),
    new UpdateGuiaUseCase(guiaService),
    new DeleteGuiaUseCase(guiaService),
    new CreateZonaUseCase(zonaService),
    new ListZonaUseCase(zonaService),
    new UpdateZonaUseCase(zonaService),
    new DeleteZonaUseCase(zonaService)
);

// Crear un nuevo guía
useCases.getCreateGuiaUseCase().crear("Juan Pérez", "1234567890", "juan@zoo.com", LocalDate.now());

// Listar todos los guías
List<GuiaDTO> guias = useCases.getListGuiaUseCase().listarTodos();

// Buscar guía por prefijo
Optional<GuiaDTO> guia = useCases.getListGuiaUseCase().buscarPorPrefijo("Juan");

// Actualizar guía
useCases.getUpdateGuiaUseCase().actualizar("id1", "Carlos Pérez", "0987654321", "carlos@zoo.com", LocalDate.now());

// Crear una zona
useCases.getCreateZonaUseCase().crear("Sabana", "Zona de animales africanos");

// Listar zonas
List<ZonaDTO> zonas = useCases.getListZonaUseCase().listarTodas();

// Buscar zona por ID
Optional<ZonaDTO> zona = useCases.getListZonaUseCase().buscarPorId("zona123");

// Actualizar zona
useCases.getUpdateZonaUseCase().actualizar("zona123", "Sabana Africana", "Zona mejorada con nuevas especies");

// Eliminar zona
try {
    useCases.getDeleteZonaUseCase().eliminar("zona123");
} catch (UnsupportedOperationException e) {
    System.out.println("Operación de eliminación aún no implementada");
}
```

### Conexión con Puertos y Servicios

```
Puertos de Entrada (InPort)
├── GuiaInPort
│   └── GuiaService (implementación)
└── ZonaInPort
    └── ZonaService (implementación)

Puertos de Salida (OutPort)
├── GuiaOutPort
│   └── GuiaRepository (implementación - consultas SQL)
└── ZonaOutPort
    └── ZonaRepository (implementación - consultas SQL)
```

### Validaciones Incluidas

- ✅ Validación de parámetros nulos o vacíos
- ✅ Validación de existencia de entidades antes de actualizar
- ✅ Validación de existencia de entidades antes de eliminar
- ✅ Excepciones descriptivas para casos de error
- ✅ Búsqueda por ID y por prefijo

### Flujo Detallado de Datos

#### Crear Guía
```
CreateGuiaUseCase.crear(datos)
    ↓ Validar parámetros
    ↓ Crear GuiaDTO
    ↓ GuiaInPort.guardar(dto)
    ↓ GuiaService.guardar(dto)
    ↓ GuiaMapper.toDomain(dto)
    ↓ GuiaOutPort.guardar(domain)
    ↓ GuiaRepository.guardar(domain)
    ↓ INSERT INTO guia VALUES(...)
    ↓ Base de datos
```

#### Actualizar Guía
```
UpdateGuiaUseCase.actualizar(id, nuevos datos)
    ↓ Validar parámetros
    ↓ Verificar que guía existe (buscarPorPrefijo)
    ↓ Crear GuiaDTO con datos nuevos
    ↓ GuiaInPort.guardar(dto)
    ↓ GuiaService.guardar(dto)
    ↓ UPDATE guia SET ... WHERE id = ...
    ↓ Base de datos
```

#### Listar Guías
```
ListGuiaUseCase.listarTodos()
    ↓ GuiaInPort.buscarTodas()
    ↓ GuiaService.buscarTodas()
    ↓ GuiaOutPort.buscarTodas()
    ↓ GuiaRepository.buscarTodas()
    ↓ SELECT * FROM guia
    ↓ Mapear a DTOs
    ↓ Retornar lista
```

### Próximos Pasos

1. **Implementar métodos DELETE en OutPort**: Los casos de uso `DeleteGuiaUseCase` y `DeleteZonaUseCase` requieren que se implemente el método `delete()` en los repositorios.

2. **Agregar validaciones adicionales**: Según las reglas de negocio específicas del zoológico.

3. **Crear casos de uso adicionales**: Para otras entidades como Especie, Cuidador, Itinerario, etc.

4. **Implementar transacciones**: Para garantizar consistencia en operaciones que involucren múltiples entidades.

5. **Agregar logs**: Para auditar operaciones críticas.

6. **Manejo de excepciones**: Considerar crear excepciones personalizadas para diferentes tipos de errores.
