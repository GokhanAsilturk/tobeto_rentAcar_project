package tobeto_rentAcar.services.entityServices.abstracts;

import tobeto_rentAcar.data.models.vehicleFeatures.BodyTypeEntity;
import tobeto_rentAcar.data.models.vehicleFeatures.BrandEntity;
import tobeto_rentAcar.data.models.vehicleFeatures.ColorEntity;
import tobeto_rentAcar.data.models.vehicleFeatures.ModelEntity;

import java.util.List;

public interface IVehicleFeaturesEntityService {

    //----------------saveMethods------------------
    BodyTypeEntity saveBodyType(BodyTypeEntity bodyTypeEntity);

    BrandEntity saveBrandEntity(BrandEntity brandEntity);

    ColorEntity saveColorEntity(ColorEntity colorEntity);

    ModelEntity saveModelEntity(ModelEntity modelEntity);

    //------------getList----------------------
    List<BodyTypeEntity> getAllBodyTypes();

    List<BrandEntity> getAllBrands();

    List<ColorEntity> getAllColors();

    List<ModelEntity> getAllModels();

    //------------getById----------------------
    BodyTypeEntity getBodyTypeEntityById(int id);

    BrandEntity getBrandEntityById(int id);

    ColorEntity getColorEntityById(int id);

    ModelEntity getModelEntityById(int id);

    //-------------DELETE METHODS---------------

    void deleteBodyTypeEntity(BodyTypeEntity bodyTypeEntity);

    void deleteBrandEntity(BrandEntity brandEntity);

    void deleteColorEntity(ColorEntity colorEntity);

    void deleteModelEntity(ModelEntity modelEntity);
}
