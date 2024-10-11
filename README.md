# File Transformer Base for OpenCDMP

**file-transformer-base** is a Maven package that provides the base interfaces and configuration classes required to implement custom file transformer services for the **OpenCDMP** platform. Each file transformer is developed as a separate microservice and can be registered with OpenCDMP to support custom import/export operations for various data formats.

## Overview

OpenCDMP supports file transformation services for both importing and exporting different file formats. This functionality is built upon a flexible and extensible mechanism that allows developers to add new file transformers based on specific format requirements.

The **file-transformer-base** package provides the necessary Java interfaces and configuration classes to define and develop these transformers.

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
- **Plan Export/Import**: Defines methods for exporting and importing plan models.
- **Description Export/Import**: Defines methods for exporting and importing descriptions.
- **Preprocessing**: Supports preprocessing of both plans and descriptions before import/export.
- **Configuration**: Returns the file transformer configuration.

### 2. `FileTransformerController.java`

This interface ensures that the file transformer provides the required API endpoints for communication with the OpenCDMP platform.

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
- **REST API Endpoints** for handling file import/export operations.
- **Preprocessing and format support** for plans and descriptions.
- **Supported formats** endpoint to return a list of formats the transformer can handle.

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
}
```

### Fields:
- `fileTransformerId`: Unique identifier for the transformer.
- `exportVariants` and `importVariants`: Supported file formats for export and import.
- `exportEntityTypes` and `importEntityTypes`: Entity types the transformer supports.
- `useSharedStorage`: Indicates if shared storage is used for the transformer.

## How to Create a Custom File Transformer

To implement a custom file transformer service for OpenCDMP:

1. **Create a New Spring Boot Project**:
   - Use **Spring Boot** to create a microservice that implements the `FileTransformerClient` and `FileTransformerController` interfaces.

2. **Define Your Formats and Entity Types**:
   - In your implementation, define the supported file formats and entity types for your import/export operations.

3. **Use Existing Implementations as Examples**:
   - You can refer to the `file-transformer-docx` and `file-transformer-rda-json` projects that are part of the OpenCDMP platform as examples.

4. **Register the Service**:
   - Once your service is implemented and running, register it with the OpenCDMP platform. It will appear as an available option for import/export within the platform.

## Example

An example of an implementation is available in the `file-transformer-docx` and `file-transformer-rda-json` repositories, where each transformer handles specific file formats for import/export operations.

## License

This package is licensed under the [EUPL 1.2 License](LICENSE).

## Contact

For questions or support regarding the implementation of file transformers, please contact:

- **Email**: opencdmp at cite.gr
