# OpenCDMP file transformer base

**file-transformer-base** is the Maven package that defines the contract between [OpenCDMP](https://github.com/OpenCDMP/OpenCDMP) and its file transformer plugins. A file transformer is a separate Spring Boot service that exports plans and descriptions to a file format, or imports them from one. OpenCDMP calls it over HTTP with the models of the [common-models](https://github.com/OpenCDMP/common-models) package.

The package holds the Java interfaces that a transformer implements, the configuration that it reports to OpenCDMP, and the models of import, preprocessing and template validation. It contains no transformation logic.

**Documentation**: [File transformer plugin guide](https://opencdmp.github.io/developers/plugins/file-transformers/)

## Requirements

- Java 21 or later
- Maven
- Spring Boot 4 for the transformer service, as in the reference transformers
- [common-models](https://github.com/OpenCDMP/common-models), which this package brings in as a dependency

## What the package contains

| Class | Purpose |
| --- | --- |
| `FileTransformerClient` | The operations a transformer implements: export and import of plans and descriptions, preprocessing of an uploaded file before import, its configuration, and optional template validation. |
| `FileTransformerController` | The REST endpoints a transformer exposes under `/api/file-transformer`. Implement it as a `@RestController` that delegates to your `FileTransformerClient`. |
| `FileTransformerConfiguration` | What the transformer reports to OpenCDMP: its id, export and import formats, the entity types it handles (`PluginEntityType.Plan`, `PluginEntityType.Description`), whether it uses shared storage, its configuration fields for administrators and users, and an optional semantics manifest. |
| `FileFormat` | One supported format, such as `docx`, `pdf` or `json`. |
| `PlanImportModel`, `DescriptionImportModel` | The uploaded file and the plan blueprint or description template to import into. |
| `PreprocessingPlanModel`, `PreprocessingDescriptionModel` | What the transformer found in an uploaded file, shown to the user before the import. |
| `TemplateValidationResultModel`, `TemplateValidationIssueModel`, `TemplateValidationIssueLevel` | The result of validating an uploaded export template. |

`validateTemplate` is a `default` method of both interfaces that returns `null`, so a transformer without export templates can leave it out.

### Endpoints

| Method | Path | Request body | Response |
| --- | --- | --- | --- |
| `POST` | `/api/file-transformer/export/plan?format=<format>` | `PlanModel` | `FileEnvelopeModel` |
| `POST` | `/api/file-transformer/export/description?format=<format>` | `DescriptionModel` | `FileEnvelopeModel` |
| `POST` | `/api/file-transformer/import/plan` | `PlanImportModel` | `PlanModel` |
| `POST` | `/api/file-transformer/import/description` | `DescriptionImportModel` | `DescriptionModel` |
| `POST` | `/api/file-transformer/preprocessing/plan` | `FileEnvelopeModel` | `PreprocessingPlanModel` |
| `POST` | `/api/file-transformer/preprocessing/description` | `FileEnvelopeModel` | `PreprocessingDescriptionModel` |
| `GET` | `/api/file-transformer/formats` | - | `FileTransformerConfiguration` |
| `POST` | `/api/file-transformer/validate-template?entityType=Plan` (or `Description`) | `FileEnvelopeModel` | `TemplateValidationResultModel` |

The [plugin guide](https://opencdmp.github.io/developers/plugins/file-transformers/) describes each method and model, template validation, and per-export options.

## Use it in a transformer

Add the dependency to your Spring Boot project, with the latest release from [Maven Central](https://central.sonatype.com/artifact/org.opencdmp/file-transformer-base):

```xml
<dependency>
    <groupId>org.opencdmp</groupId>
    <artifactId>file-transformer-base</artifactId>
    <version>${file-transformer-base.version}</version>
</dependency>
```

Then:

1. Implement `FileTransformerClient` in a `@Service` and `FileTransformerController` in a `@RestController`. See [How to create a custom file transformer](https://opencdmp.github.io/developers/plugins/file-transformers/#how-to-create-a-custom-file-transformer).
2. Accept only tokens of the installation's Keycloak realm that carry the `plugins` audience. See [Step 5: configure security and deploy](https://opencdmp.github.io/developers/plugins/file-transformers/#step-5--configure-security-and-deploy).
3. Try the transformer against a local installation. See [Run and test a plugin locally](https://opencdmp.github.io/developers/plugins/run-locally/).
4. Register it for the whole installation or for one organisation. See [Registering plugin services](https://opencdmp.github.io/deployment/configuration/plugin-services/).

### Reference implementations

| Repository | What it does |
| --- | --- |
| [file-transformer-docx](https://github.com/OpenCDMP/file-transformer-docx) | Exports plans and descriptions as DOCX and PDF, and validates export templates |
| [file-transformer-rda-json](https://github.com/OpenCDMP/file-transformer-rda-json) | Exports and imports plans as RDA DMP Common Standard JSON |
| [file-transformer-raid-json](https://github.com/OpenCDMP/file-transformer-raid-json) | Exports and imports plans as RAiD metadata JSON |

## Build from source

```bash
mvn clean install
```

This installs version `1.0.0-SNAPSHOT` in your local Maven repository, where a transformer built on the same machine finds it. To install another version, set it first with `mvn versions:set -DnewVersion=<version>`.

## Related resources

- [File transformer plugin guide](https://opencdmp.github.io/developers/plugins/file-transformers/)
- [Common models](https://opencdmp.github.io/developers/plugins/common-models/) and the [common-models repository](https://github.com/OpenCDMP/common-models)
- [File transformers overview](https://opencdmp.github.io/optional-services/file-transformers/)
- [OpenCDMP](https://github.com/OpenCDMP/OpenCDMP)

## Contributing

Report bugs and suggest changes in [GitHub Issues](https://github.com/OpenCDMP/file-transformer-base/issues). See [Contributing](https://opencdmp.github.io/developers/contributing/) for how to propose a change.

## License

file-transformer-base is licensed under the [European Union Public Licence (EUPL) v1.2](LICENSE).

## Contact

Questions: email opencdmp at cite.gr.
