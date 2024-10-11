package org.opencdmp.filetransformerbase.interfaces;

import org.opencdmp.commonmodels.models.FileEnvelopeModel;
import org.opencdmp.commonmodels.models.description.DescriptionModel;
import org.opencdmp.commonmodels.models.plan.PlanModel;
import org.opencdmp.filetransformerbase.models.misc.DescriptionImportModel;
import org.opencdmp.filetransformerbase.models.misc.PlanImportModel;
import org.opencdmp.filetransformerbase.models.misc.PreprocessingDescriptionModel;
import org.opencdmp.filetransformerbase.models.misc.PreprocessingPlanModel;
import org.springframework.web.bind.annotation.*;

/**
 * The File Transformer interface represents the mechanism for exporting and importing file formats
 * for both plan and description
 */
@RequestMapping("/api/file-transformer")
public interface FileTransformerController {


	@PostMapping("/export/plan")
	FileEnvelopeModel exportPlan(@RequestBody PlanModel planModel, @RequestParam(value = "format",required = false)String format) throws Exception ;

	@PostMapping("/export/description")
	FileEnvelopeModel exportDescription(@RequestBody DescriptionModel descriptionModel, @RequestParam(value = "format",required = false)String format) throws Exception;

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
