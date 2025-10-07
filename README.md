# File Transformer Base for OpenCDMP

**file-transformer-base** is a Maven package that provides the base interfaces and configuration classes required to implement custom file transformer services for the **OpenCDMP** platform. Each file transformer is developed as a separate microservice and can be registered with OpenCDMP to support custom import/export operations for various data formats.

---

## Overview

OpenCDMP supports file transformation services for both importing and exporting different file formats. This functionality is built upon a flexible and extensible mechanism that allows developers to add new file transformers based on specific format requirements.

The **file-transformer-base** package provides the necessary Java interfaces and configuration classes to define and develop these transformers.

**Documentation**: [File Transformation Service Guide](https://opencdmp.github.io/developers/plugins/file-transformers/)

---

## Prerequisites

- **Java**: Version 21 or higher
- **Spring Boot**: Version 3.x
- **Maven**: Version 3.6 or higher
- **common-models**: OpenCDMP [common models](https://github.com/OpenCDMP/common-models) package

---

## Key Interfaces and Classes

### 1. `FileTransformerClient.java`

This interface defines the core operations that any file transformer should implement.

```java
public interface FileTransformerClient {

    FileEnvelopeModel exportPlan(PlanModel plan, String variant)
        throws InvalidApplicationException, IOException, InvalidTypeException;

    PlanModel importPlan(PlanImportModel planImportModel);

    FileEnvelopeModel exportDescription(DescriptionModel descriptionFileTransformerModel, String format)
        throws InvalidApplicationException, IOException;

    DescriptionModel importDescription(DescriptionImportModel descriptionImportModel);

    FileTransformerConfiguration getConfiguration();

    PreprocessingPlanModel preprocessingPlan(FileEnvelopeModel fileEnvelopeModel);

    PreprocessingDescriptionModel preprocessingDescription(FileEnvelopeModel fileEnvelopeModel);
}
```

This interface handles:
- **Plan Export/Import**: Defines methods for exporting and importing Plan models
- **Description Export/Import**: Defines methods for exporting and importing Descriptions
- **Preprocessing**: Supports preprocessing of both Plans and Descriptions before import/export
- **Configuration**: Returns the file transformer configuration

### 2. `FileTransformerController.java`

This interface ensures that the file transformer provides the required REST API endpoints for communication with the OpenCDMP platform.

```java
@RequestMapping("/api/file-transformer")
public interface FileTransformerController {

    @PostMapping("/export/plan")
    FileEnvelopeModel exportPlan(@RequestBody PlanModel planModel,
        @RequestParam(value = "format", required = false) String format) throws Exception;

    @PostMapping("/export/description")
    FileEnvelopeModel exportDescription(@RequestBody DescriptionModel descriptionModel,
        @RequestParam(value = "format", required = false) String format) throws Exception;

    @PostMapping("/import/plan")
    PlanModel importFileToPlan(@RequestBody PlanImportModel planImportModel);

    @PostMapping("/import/description")
    DescriptionModel importFileToDescription(@RequestBody DescriptionImportModel descriptionImportModel);

    @PostMapping("/preprocessing/plan")
    PreprocessingPlanModel preprocessingPlan(@RequestBody FileEnvelopeModel fileEnvelopeModel);

    @PostMapping("/preprocessing/description")
    PreprocessingDescriptionModel preprocessingDescription(@RequestBody FileEnvelopeModel fileEnvelopeModel);

    @GetMapping("/formats")
    FileTransformerConfiguration getSupportedFormats();
}
```

This interface ensures:
- **REST API Endpoints** for handling file import/export operations
- **Preprocessing and format support** for Plans and Descriptions
- **Supported formats** endpoint to return a list of formats the transformer can handle

### 3. `FileTransformerConfiguration.java`

This class contains the configuration details for each file transformer, which the OpenCDMP platform reads and registers.

```java
public class FileTransformerConfiguration {
    private String fileTransformerId;
    private List<FileFormat> exportVariants;
    private List<FileTransformerEntityType> exportEntityTypes;
    private List<FileFormat> importVariants;
    private List<FileTransformerEntityType> importEntityTypes;
    private boolean useSharedStorage;
    private List<ConfigurationField> configurationFields;
    private List<ConfigurationField> userConfigurationFields;
}
```

**Fields**:
- `fileTransformerId`: Unique identifier for the transformer
- `exportVariants` and `importVariants`: Supported file formats for export and import (e.g., PDF, DOCX, XML, JSON)
- `exportEntityTypes` and `importEntityTypes`: Entity types the transformer supports (Plans, Descriptions)
- `useSharedStorage`: Indicates if shared storage is used for the transformer
- `configurationFields`: Fields that could contain additional configuration.
- `configurationUserFields`: Fields that provide additional configuration options for **OpenCDMP** users

---

## How to Create a Custom File Transformer

To implement a custom file transformer service for OpenCDMP:

[How to Create a Custom File Transformer](https://opencdmp.github.io/developers/plugins/file-transformers/#how-to-create-a-custom-file-transformer)

### 1. Create a New Spring Boot Project

Create a Maven-based Spring Boot microservice that implements the `FileTransformerClient` and `FileTransformerController` interfaces.

**Maven Dependency**:

```xml
<dependency>
    <groupId>org.opencdmp</groupId>
    <artifactId>file-transformer-base</artifactId>
    <version>1.2.0</version>
</dependency>
```

### 2. Implement the Interfaces

Create implementation classes for both interfaces:

```java
@Service
public class MyFileTransformerClient implements FileTransformerClient {

    @Override
    public FileEnvelopeModel exportPlan(PlanModel plan, String variant) {
        // Implement your export logic
    }

    @Override
    public FileTransformerConfiguration getConfiguration() {
        FileTransformerConfiguration config = new FileTransformerConfiguration();
        config.setFileTransformerId("my-transformer");
        // Configure supported formats and entity types
        return config;
    }

    // Implement other methods...
}

@RestController
public class MyFileTransformerController implements FileTransformerController {

    private final MyFileTransformerClient client;

    // Implement controller methods delegating to client...
}
```

### 3. Define Your Formats and Entity Types

In your implementation, define the supported file formats and entity types for your import/export operations

### 4. Configure and Deploy

Configure your service endpoints and deploy as a standalone microservice accessible to the OpenCDMP platform.

### 5. Register the Service

Once your service is implemented and running, register it with the OpenCDMP.

---

## Reference Implementations

You can refer to the [file-transformer-docx](https://github.com/OpenCDMP/file-transformer-docx), [file-transformer-rda-json](https://github.com/OpenCDMP/file-transformer-rda-json) and [file-transformer-raid-json](https://github.com/OpenCDMP/file-transformer-raid-json) projects that are part of the OpenCDMP platform as examples.

---

## Architecture Integration

File transformer services integrate with OpenCDMP through:

1. **REST API**: Services expose endpoints defined by `FileTransformerController`
2. **Service Registry**: OpenCDMP backend registers available transformers via configuration
3. **Common Models**: Data exchange using shared models from `common-models` package
4. **Microservices**: Each transformer runs as an independent service

## Related Resources

- **Common Models**: [common-models repository](https://github.com/OpenCDMP/common-models)
- **Main Repository**: [OpenCDMP](https://github.com/OpenCDMP/OpenCDMP)
- **File Transformers Overview**: https://opencdmp.github.io/optional-services/file-transformers
- **Developer Plugin Guide**: https://opencdmp.github.io/developers/plugins/file-transformers

---

## License

This package is licensed under the [EUPL 1.2 License](LICENSE).

---

## Contact

For questions or support regarding the implementation of file transformers, please contact:

- **Email**: opencdmp at cite.gr

---

*This package is part of the OpenCDMP ecosystem. For general OpenCDMP documentation, visit [opencdmp.github.io](https://opencdmp.github.io).*
