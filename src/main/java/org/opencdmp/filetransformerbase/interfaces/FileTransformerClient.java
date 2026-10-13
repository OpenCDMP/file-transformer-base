package org.opencdmp.filetransformerbase.interfaces;

import org.opencdmp.commonmodels.enums.PluginEntityType;
import org.opencdmp.commonmodels.models.FileEnvelopeModel;
import org.opencdmp.commonmodels.models.description.DescriptionModel;
import org.opencdmp.commonmodels.models.plan.PlanModel;
import org.opencdmp.filetransformerbase.models.misc.DescriptionImportModel;
import org.opencdmp.filetransformerbase.models.misc.PlanImportModel;
import org.opencdmp.filetransformerbase.models.misc.PreprocessingDescriptionModel;
import org.opencdmp.filetransformerbase.models.misc.PreprocessingPlanModel;
import org.opencdmp.filetransformerbase.models.misc.TemplateValidationResultModel;


/**
 * The File Transformer interface represents the mechanism for exporting and importing file formats
 * for both plan and description
 */
public interface FileTransformerClient {

    /**
     * Returns export info from a plan.
     *
     * @param plan plan structure which is to be exported
     * @return object that contains export info
     * @throws Exception if an error occurs while trying to export the plan
     */
    FileEnvelopeModel exportPlan(PlanModel plan, String variant);
    /**
     * Returns a plan from import data.
     *
     * @param planImportModel plan structure which contains import data
     * @return plan model
     */
    PlanModel importPlan(PlanImportModel planImportModel);

    /**
     * Returns export info from a description.
     *
     * @param descriptionFileTransformerModel description structure which is to be exported
     * @return object that contains export info
     * @throws Exception if an error occurs while trying to export the description
     */
    FileEnvelopeModel exportDescription(DescriptionModel descriptionFileTransformerModel, String format);

    /**
     * Returns a plan from import data.
     *
     * @param descriptionImportModel description structure which contains import data
     * @return description model
     */
    DescriptionModel importDescription(DescriptionImportModel descriptionImportModel);

    FileTransformerConfiguration getConfiguration();

    /**
     * Returns a preprocessing plan before import/export
     *
     * @param fileEnvelopeModel file object which is contains data for preprocessing
     * @return plan after preprocessing
     */
    PreprocessingPlanModel preprocessingPlan(FileEnvelopeModel fileEnvelopeModel);

    /**
     * Returns a preprocessing description before import/export
     *
     * @param fileEnvelopeModel file object which is contains data for preprocessing
     * @return description after preprocessing
     */
    PreprocessingDescriptionModel preprocessingDescription(FileEnvelopeModel fileEnvelopeModel);

    /**
     * Validates an uploaded export template for this transformer (optional capability).
     * Transformers that do not support template validation keep the default and return null.
     *
     * @param fileEnvelopeModel the template file to validate
     * @param entityType        the entity the template targets (plan or description)
     * @return the validation result, or null when validation is not supported
     */
    default TemplateValidationResultModel validateTemplate(FileEnvelopeModel fileEnvelopeModel, PluginEntityType entityType) {
        return null;
    }

}
