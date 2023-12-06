package tobeto_rentAcar.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tobeto_rentAcar.data.DTO.VehicleFeaturesDTO.BodyTypeDto;
import tobeto_rentAcar.data.DTO.VehicleFeaturesDTO.BrandDto;
import tobeto_rentAcar.data.DTO.VehicleFeaturesDTO.ColorDto;
import tobeto_rentAcar.data.DTO.VehicleFeaturesDTO.ModelDto;
import tobeto_rentAcar.data.models.BaseEntities.types.ItemType;
import tobeto_rentAcar.data.models.vehicleFeatures.BodyTypeEntity;
import tobeto_rentAcar.data.models.vehicleFeatures.BrandEntity;
import tobeto_rentAcar.data.models.vehicleFeatures.ColorEntity;
import tobeto_rentAcar.data.models.vehicleFeatures.ModelEntity;
import tobeto_rentAcar.data.requests.commonRequests.vehicleRequests.vehicleFeaturesRequests.AddBodyTypeReq;
import tobeto_rentAcar.data.requests.commonRequests.vehicleRequests.vehicleFeaturesRequests.AddBrandReq;
import tobeto_rentAcar.data.requests.commonRequests.vehicleRequests.vehicleFeaturesRequests.AddColorReq;
import tobeto_rentAcar.data.requests.commonRequests.vehicleRequests.vehicleFeaturesRequests.AddModelReq;
import tobeto_rentAcar.services.abstracts.IVehicleFeaturesService;
import tobeto_rentAcar.services.entityServices.VehicleFeaturesEntityService;

import java.util.List;


@Service
@AllArgsConstructor
public class VehicleFeaturesService implements IVehicleFeaturesService {

    private final VehicleFeaturesEntityService vehicleFeaturesEntityService;


    //----------------saveMethods------------------

    @Override
    public BodyTypeDto addBodyType(AddBodyTypeReq addBodyTypeReq) {
        return this.vehicleFeaturesEntityService.saveBodyType(convertToBodyTypeEntity(addBodyTypeReq)).convertToDto();
    }

    @Override
    public BrandDto addBrand(AddBrandReq addBrandReq) {
        return this.vehicleFeaturesEntityService.saveBrandEntity(convertToBrandEntity(addBrandReq)).convertToDto();
    }

    @Override
    public ColorDto addColor(AddColorReq addColorReq) {
        return this.vehicleFeaturesEntityService.saveColorEntity(convertToColorEntity(addColorReq)).convertToDto();
    }

    @Override
    public ModelDto addModel(AddModelReq addModelReq) {
        return this.vehicleFeaturesEntityService.saveModelEntity(convertToModelEntity(addModelReq)).convertToDto();
    }

    //----------------GET METHODS------------------

    @Override
    public BodyTypeDto getBodyTypeById(int id) {
        return this.vehicleFeaturesEntityService.getBodyTypeEntityById(id).convertToDto();
    }

    @Override
    public BrandDto getBrandById(int id) {
        return this.vehicleFeaturesEntityService.getBrandEntityById(id).convertToDto();
    }

    @Override
    public ColorDto getColorById(int id) {
        return this.vehicleFeaturesEntityService.getColorEntityById(id).convertToDto();
    }

    @Override
    public ModelDto getModelById(int id) {
        return this.vehicleFeaturesEntityService.getModelEntityById(id).convertToDto();
    }

    @Override
    public List<BodyTypeDto> getAllBodyTypes() {
        return this.vehicleFeaturesEntityService.getAllBodyTypes().stream().map(BodyTypeEntity::convertToDto).toList();
    }

    @Override
    public List<BrandDto> getAllBrands() {
        return this.vehicleFeaturesEntityService.getAllBrands().stream().map(BrandEntity::convertToDto).toList();
    }

    @Override
    public List<ColorDto> getAllColors() {
        return this.vehicleFeaturesEntityService.getAllColors().stream().map(ColorEntity::convertToDto).toList();
    }

    @Override
    public List<ModelDto> getAllModels() {
        return this.vehicleFeaturesEntityService.getAllModels().stream().map(ModelEntity::convertToDto).toList();
    }

    //----------------DELETE METHODS------------------

    @Override
    public void deleteBodyTypeById(int id) {
        this.vehicleFeaturesEntityService.deleteBodyTypeEntity(
                this.vehicleFeaturesEntityService.getBodyTypeEntityById(id));
    }

    @Override
    public void deleteBrandById(int id) {
        this.vehicleFeaturesEntityService.deleteBrandEntity(
                this.vehicleFeaturesEntityService.getBrandEntityById(id));
    }

    @Override
    public void deleteColorById(int id) {
        this.vehicleFeaturesEntityService.deleteColorEntity(
                this.vehicleFeaturesEntityService.getColorEntityById(id));
    }

    @Override
    public void deleteModelById(int id) {
        this.vehicleFeaturesEntityService.deleteModelEntity(
                this.vehicleFeaturesEntityService.getModelEntityById(id));
    }


    public BodyTypeEntity convertToBodyTypeEntity(AddBodyTypeReq addBodyTypeReq) {
        return BodyTypeEntity.builder()
                .itemType(ItemType.BODY_TYPE)
                .name(addBodyTypeReq.name())
                .build();
    }

    public BrandEntity convertToBrandEntity(AddBrandReq addBrandReq) {
        return BrandEntity.builder()
                .itemType(ItemType.BRAND)
                .name(addBrandReq.name())
                .build();
    }

    public ColorEntity convertToColorEntity(AddColorReq addColorReq) {
        return ColorEntity.builder()
                .itemType(ItemType.COLOUR)
                .name(addColorReq.name())
                .build();
    }

    public ModelEntity convertToModelEntity(AddModelReq addModelReq) {
        return ModelEntity.builder()
                .name(addModelReq.name())
                .brandEntity(this.vehicleFeaturesEntityService.getBrandEntityById(addModelReq.brandId()))
                .build();
    }

}
