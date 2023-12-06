package tobeto_rentAcar.services.entityServices;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tobeto_rentAcar.data.models.vehicleFeatures.BodyTypeEntity;
import tobeto_rentAcar.data.models.vehicleFeatures.BrandEntity;
import tobeto_rentAcar.data.models.vehicleFeatures.ColorEntity;
import tobeto_rentAcar.data.models.vehicleFeatures.ModelEntity;
import tobeto_rentAcar.dataAccess.VehicleFeaturesRepositories.BodyTypeRepository;
import tobeto_rentAcar.dataAccess.VehicleFeaturesRepositories.BrandRepository;
import tobeto_rentAcar.dataAccess.VehicleFeaturesRepositories.ColorRepository;
import tobeto_rentAcar.dataAccess.VehicleFeaturesRepositories.ModelRepository;
import tobeto_rentAcar.exception.DataNotFoundException;
import tobeto_rentAcar.exception.ExceptionType;
import tobeto_rentAcar.services.entityServices.abstracts.IVehicleFeaturesEntityService;

import java.util.List;

@Service
@AllArgsConstructor
public class VehicleFeaturesEntityService implements IVehicleFeaturesEntityService {

    private final BodyTypeRepository bodyTypeRepository;
    private final BrandRepository brandRepository;
    private final ColorRepository colorRepository;
    private final ModelRepository modelRepository;

    //------------------------------------SAVE METHODS---------------------------------------------------------


    @Override
    public BodyTypeEntity saveBodyType(BodyTypeEntity bodyTypeEntity) {
        return this.bodyTypeRepository.save(bodyTypeEntity);
    }

    @Override
    public BrandEntity saveBrandEntity(BrandEntity brandEntity) {
        return this.brandRepository.save(brandEntity);
    }

    @Override
    public ColorEntity saveColorEntity(ColorEntity colorEntity) {
        return this.colorRepository.save(colorEntity);
    }

    @Override
    public ModelEntity saveModelEntity(ModelEntity modelEntity) {
        return this.modelRepository.save(modelEntity);
    }

    //---------------------------------------GET LIST METHODS------------------------------------------------------
    @Override
    public List<BodyTypeEntity> getAllBodyTypes() {
        return this.bodyTypeRepository.findAll();
    }

    @Override
    public List<BrandEntity> getAllBrands() {
        return this.brandRepository.findAll();
    }

    @Override
    public List<ColorEntity> getAllColors() {
        return this.colorRepository.findAll();
    }

    @Override
    public List<ModelEntity> getAllModels() {
        return this.modelRepository.findAll();
    }

    //------------------------------------------GET METHODS---------------------------------------------------s
    @Override
    public BodyTypeEntity getBodyTypeEntityById(int id) {
        return this.bodyTypeRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException(ExceptionType.ITEM_NOT_FOUND, "Body type not found! :)"));
    }

    @Override
    public BrandEntity getBrandEntityById(int id) {
        return this.brandRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException(ExceptionType.ITEM_NOT_FOUND, "Brand not found! :)"));
    }

    @Override
    public ColorEntity getColorEntityById(int id) {
        return this.colorRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException(ExceptionType.ITEM_NOT_FOUND, "Color not found! :)"));
    }

    @Override
    public ModelEntity getModelEntityById(int id) {
        return this.modelRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException(ExceptionType.ITEM_NOT_FOUND, "Color not found! :)"));
    }

    @Override
    public void deleteBodyTypeEntity(BodyTypeEntity bodyTypeEntity) {
        this.bodyTypeRepository.delete(bodyTypeEntity);
    }

    @Override
    public void deleteBrandEntity(BrandEntity brandEntity) {
        this.brandRepository.delete(brandEntity);
    }

    @Override
    public void deleteColorEntity(ColorEntity colorEntity) {
        this.colorRepository.delete(colorEntity);
    }

    @Override
    public void deleteModelEntity(ModelEntity modelEntity) {
        this.modelRepository.delete(modelEntity);
    }


}
